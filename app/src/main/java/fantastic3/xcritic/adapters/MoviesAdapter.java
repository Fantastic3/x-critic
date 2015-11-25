package fantastic3.xcritic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import fantastic3.xcritic.R;
import fantastic3.xcritic.models.Movie;

/**
 * Created by jpodlech on 11/25/15.
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {

    private static class ViewHolder {
        ImageView ivThumbnail;
        TextView tvName;
    }

    public MoviesAdapter(Context context, List<Movie> movies) {
        super(context, R.layout.item_generic, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Movie movie = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_generic, parent, false);
            viewHolder.ivThumbnail = (ImageView) convertView.findViewById(R.id.ivThumbnail);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            convertView.setTag(viewHolder);
        } else {
            viewHolder =  (ViewHolder) convertView.getTag();
        }

        if (movie.getThumbnail() != null) Picasso.with(getContext()).load(movie.getThumbnail()).into(viewHolder.ivThumbnail);
        if (movie.getName() != null) viewHolder.tvName.setText(movie.getName());

        return convertView;
    }
}

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
import fantastic3.xcritic.models.Game;

/**
 * Created by jpodlech on 11/24/15.
 */
public class GamesAdapter extends ArrayAdapter<Game> {

    private static class ViewHolder {
        ImageView ivThumbnail;
        TextView tvName;
    }

    public GamesAdapter(Context context, List<Game> games) {
        super(context, R.layout.item_generic, games);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Game game = getItem(position);
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

        if (game.getThumbnail() != null) Picasso.with(getContext()).load(game.getThumbnail()).into(viewHolder.ivThumbnail);
        if (game.getName() != null) viewHolder.tvName.setText(game.getName());

        return convertView;
    }
}

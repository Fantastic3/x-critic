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
import fantastic3.xcritic.models.Music;

/**
 * Created by jpodlech on 11/25/15.
 */
public class MusicsAdapter extends ArrayAdapter<Music> {

    private static class ViewHolder {
        ImageView ivThumbnail;
        TextView tvName;
    }

    public MusicsAdapter(Context context, List<Music> musics) {
        super(context, R.layout.item_generic, musics);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Music music = getItem(position);
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

        if (music.getThumbnail() != null) Picasso.with(getContext()).load(music.getThumbnail()).into(viewHolder.ivThumbnail);
        if (music.getName() != null) viewHolder.tvName.setText(music.getName());

        return convertView;
    }
}

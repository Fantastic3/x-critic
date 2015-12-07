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
import fantastic3.xcritic.interfaces.ListItemable;

/**
 * Created by jpodlech on 12/6/15.
 */
public class ListItemAdapter extends ArrayAdapter<ListItemable> {

    private static class ViewHolder {
        ImageView ivThumbnail;
        TextView tvName;
        ImageView ivFavorite;
    }

    public ListItemAdapter(Context context, List<ListItemable> listItems) {
        super(context, R.layout.item_generic, listItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ListItemable listItem = getItem(position);
        final ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_generic, parent, false);
            viewHolder.ivThumbnail = (ImageView) convertView.findViewById(R.id.ivThumbnail);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.ivFavorite = (ImageView) convertView.findViewById(R.id.ivFavorite);
            convertView.setTag(viewHolder);
        } else {
            viewHolder =  (ViewHolder) convertView.getTag();
        }

        if (listItem.getThumbnail() != null) Picasso.with(getContext()).load(listItem.getThumbnail()).into(viewHolder.ivThumbnail);
        if (listItem.getName() != null) viewHolder.tvName.setText(listItem.getName());
        viewHolder.ivFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.with(getContext()).load(R.drawable.ic_favorited).into(viewHolder.ivFavorite);
            }
        });

        return convertView;
    }
}

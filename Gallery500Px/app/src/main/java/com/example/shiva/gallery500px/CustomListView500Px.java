package com.example.shiva.gallery500px;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiva on 23-11-2015.
 */
public class CustomListView500Px extends ArrayAdapter<ImagePx> {

    List<ImagePx> objects;
    int textViewResourceId;
    Context context;
    int resource;

    public CustomListView500Px(Context context, int resource, List<ImagePx> objects) {

        super(context, resource, objects);
        this.objects = objects;
        this.textViewResourceId = textViewResourceId;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImagePx imagePx = new ImagePx();

        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.searchresult_eachrow,null);
        }

        imagePx = objects.get(position);

        TextView txtViewTitle = (TextView) convertView.findViewById(R.id.tViewTitle);
        txtViewTitle.setText(imagePx.getTitle());

        ImageView imageViewtitle = (ImageView) convertView.findViewById(R.id.imgThumbnail);
        Picasso.with(context)
                .load(imagePx.getImageUrl_Thumbnail())
                .into(imageViewtitle);

        return super.getView(position, convertView, parent);
    }
}

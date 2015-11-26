package com.example.shiva.gallery500px;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by shiva on 24-11-2015.
 */
public class JsonParsingImagePx {

    public static ArrayList<ImagePx> JsonParsersearchResults (String s){

        ArrayList<ImagePx> ArrayListsearchresults = new ArrayList<ImagePx>();


        try {
            JSONObject jsonObjectinputstream = new JSONObject(s);
            JSONArray jsonArraysearchresults = jsonObjectinputstream.getJSONArray("photos");

            for (int i=0;i<jsonArraysearchresults.length();i++){
                ImagePx imagePx = new ImagePx();
                JSONObject jsonObjectid = jsonArraysearchresults.getJSONObject(i);

                JSONObject jsonObjectuser = jsonObjectid.getJSONObject("user");
                imagePx.setAuthor(jsonObjectuser.getString("fullname"));
                imagePx.setTitle(jsonObjectid.getString("name"));
                imagePx.setImageUrl_Thumbnail(jsonObjectid.getString("image_url"));

                //Log.d("FullName",jsonObjectuser.getString("fullname"));

                //imagePx.setImageUrl(jsonObjectid.getString("image_url"));
                //imagePx.setTitle(jsonObjectid.getString("image_url"));
                //imagePx.setAuthor(jsonObjectid.getString("image_url"));
                ArrayListsearchresults.add(imagePx);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return ArrayListsearchresults;
    }
}

package com.udacity.ravindmauriya.capstonestage2.ui.saved;

import android.os.AsyncTask;
import android.util.Log;

import com.udacity.ravindmauriya.capstonestage2.R;
import com.udacity.ravindmauriya.capstonestage2.model.PlaceListDetail;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.EntityUtils;

/**
 * Created by ravind on 21/01/17.
 */

class SavedListPresenter {
    private SavedListView savedListView;
    private static final String TAG_RESULT = "result";
    private static final String TAG_PHOTOS_REFERENCE = "photo_reference";

    SavedListPresenter(SavedListView savedListView) {

        this.savedListView = savedListView;
    }

    void getPlaceDetail(List<String> allPlaces) {
        GetPlacesAsync getPlacesAsync = new GetPlacesAsync(allPlaces);
        getPlacesAsync.execute();
    }

    private class GetPlacesAsync extends AsyncTask<Void, Void, Void> {

        private List<String> allPlaces;
        List<PlaceListDetail> placeListDetailList = new ArrayList<>();

        GetPlacesAsync(List<String> allPlaces) {

            this.allPlaces = allPlaces;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            savedListView.showProgress(true);

        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (String id : allPlaces) {
                String url = "https://maps.googleapis.com/maps/api/place/details/json?placeid=" + id + "&key="
                        + savedListView.getViewContext().getString(R.string.api_key);

                DefaultHttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet(url);
                // replace with your url

                HttpResponse response;
                try {
                    response = client.execute(request);
                    String result = EntityUtils.toString(response.getEntity());

                    Log.d("Response of GET request", result);
                    final ArrayList<String> photos_reference = new ArrayList<>();

                    try {
                        JSONObject jsonObject = new JSONObject(result);
                        PlaceListDetail detail = new PlaceListDetail();

                        JSONObject list = jsonObject.getJSONObject(TAG_RESULT);

                        JSONArray photos = list.getJSONArray("photos");

                        for (int j = 0; j < photos.length(); j++) {
                            JSONObject photo = photos.getJSONObject(j);

                            photos_reference.add(photo.getString(TAG_PHOTOS_REFERENCE));
                            detail.setPhoto_reference(photos_reference);

                        }

                        String placename = list.getString("name");
                        detail.setPlace_name(placename);

                        String vicinity = list.getString("vicinity");
                        detail.setPlace_address(vicinity);
                        detail.setPlace_id(list.getString("place_id"));
                        detail.setPlace_rating(list.getDouble("rating"));
                        placeListDetailList.add(detail);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            savedListView.showProgress(false);
            savedListView.setData(placeListDetailList);

        }
    }


}

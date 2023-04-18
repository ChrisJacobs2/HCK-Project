package com.csc340sp23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author Christopher Jacobs
 */
public class ImageGrabber {
    private String apiUrl;

    public ImageGrabber(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public ArrayList<String> getImageUrls() {
        ArrayList<String> imageUrls = new ArrayList<>();
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            String jsonStr = "";
            while ((output = br.readLine()) != null) {
                jsonStr += output;
            }
            conn.disconnect();

            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONArray results = jsonObj.getJSONArray("image_results");
            for (int i = 0; i < 50 && i < results.length(); i++) {
                JSONObject result = results.getJSONObject(i);
                String imageUrl = result.getString("sourceUrl");
                imageUrls.add(imageUrl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageUrls;
    }
}

package com.csc340sp23;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Christopher Jacobs
 */
public class TenorGif {
    private static String first = "https://tenor.googleapis.com/v2/search?q=";
    private static String middle = "&key=";
    private static String last = "&client_key=my_test_app&limit=16";
    
    public static String apiUrl(String apiKey, String search) {
        String url = first + search + middle + apiKey + last;
        return url;
    }
    
    public static ArrayList<String> soyImg(String apiUrl) {
        ArrayList<String> urls = new ArrayList<String>();

        try {
            // Make a HTTP GET request to the API endpoint
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // Read the response from the API into a string
            Scanner sc = new Scanner(url.openStream());
            String response = "";
            while (sc.hasNext()) {
                response += sc.nextLine();
            }
            sc.close();

            // Parse the JSON response and extract the gif URLs
            JSONObject json = new JSONObject(response);
            JSONArray results = json.getJSONArray("results");
            for (int i = 0; i < results.length(); i++) {
                JSONObject result = results.getJSONObject(i);
                JSONObject mediaFormats = result.getJSONObject("media_formats");
                String tinyGifUrl = mediaFormats.getJSONObject("tinygif").getString("url");
//                String nanoGifUrl = mediaFormats.getJSONObject("nanogif").getString("url");
                urls.add(tinyGifUrl);
//                urls.add(nanoGifUrl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return urls;
    }
}

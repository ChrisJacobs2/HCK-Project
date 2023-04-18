package com.csc340sp23;

import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrototypeDemoApplication {

    public static ArrayList<String> imageUrls;
    public static ArrayList<String> soyUrls;
    public static ArrayList<String> engUrls;
    public static String tenorApiKey = "AIzaSyDD9j7Fw91uj7uW5UO__ftIlj_T-avJSaQ";

	public static void main(String[] args) {
		SpringApplication.run(PrototypeDemoApplication.class, args);
                System.out.println("TEST TEST TEST\n\n\n");
                
                // rest api 1 (random gifs from google image search)
//                ImageGrabber imageGrabber = new ImageGrabber("https://app.zenserp.com/api/v2/search?apikey=24e2e040-ddac-11ed-b11b-0fffd593572a&q=Soyjack%20gif&tbm=isch&search_engine=google.com.sv");
//                imageUrls = imageGrabber.getImageUrls();
                String soyApi = TenorGif.apiUrl(tenorApiKey, "soyjack");
                String engieApi = TenorGif.apiUrl(tenorApiKey, "tf2engineerbuff");
                soyUrls = TenorGif.soyImg(soyApi);
                engUrls = TenorGif.soyImg(engieApi);
                
                
                imageUrls = soyUrls;
                     
	}
        
        
        
        
        
        public static String engieTenor() {
            // pick a random image url from the arraylist
            int index = (int) (Math.random() * engUrls.size());
            return engUrls.get(index);
        }
        public static String soyImg() {
            // pick a random image url from the arraylist
            int index = (int) (Math.random() * imageUrls.size());
            return imageUrls.get(index);
        }
        public static String soyTenor() {
            // pick a random image url from the arraylist
            int index = (int) (Math.random() * soyUrls.size());
            return soyUrls.get(index);
        }
}

package net.kalastore.divar;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Diamond Android on 12/19/2016.
 */
public class G extends Application {
    public  static Context context;
    public static Activity currentActivity;
    public static List<Movie> movieList = new ArrayList<>();
    public static HashMap<String,String> categoryList=new HashMap<>();

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        context = getApplicationContext();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String json=   HttpHandler.makeServiceCall("http://192.168.1.30/server/api/products");
                //Log.i("Kala", json+"Is the json..........");
                //Log.i("MOL",+"uuuu");


                //   JsonObject jsonObject  = new JsonParser().parse(HttpHandler.makeServiceCall("http://192.168.1.33/server/api/products")).getAsJsonObject();
                JSONArray jsonarray = null;
                String  title,address,cDate,picture = null;


                try {

                    jsonarray = new JSONArray(json);
                    //Log.i("MOL", json+"Is the json..........");
                    // Log.i("MOL", jsonarray.length()+"Is the size..........");
                    for (int i = 0; i < jsonarray.length(); i++) {

                        JSONObject jsonobject = jsonarray.getJSONObject(i);
                        address = jsonobject.getString("address");
                        cDate = jsonobject.getString("create_date");
                        title = jsonobject.getString("title");
                        picture = jsonobject.getString("mobile");
                        Movie  movie =new Movie(title, address,cDate,picture);
                        G.movieList.add(movie);
                        Log.i("MOL","" +title+"|||||||"+ address);
                        Log.i("MOL","" +i);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        }).start();


    }

 /*   public static void prepareMovieData() {
        G.movieList.clear();
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        G.movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        G.movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        G.movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        G.movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        G.movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        G.movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009");
        G.movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        G.movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        G.movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        G.movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986");
        G.movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000");
        G.movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        G.movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        G.movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        G.movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        G.movieList.add(movie);


    }*/
}

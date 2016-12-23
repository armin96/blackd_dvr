package net.kalastore.divar;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diamond Android on 12/19/2016.
 */
public class G extends Application {
    public  static Context context;
    public static List<Movie> movieList = new ArrayList<>();
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static void prepareMovieData() {
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


    }
}

package elmeniawy.eslam.daggermvp.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Data
 * <p>
 * Created by Eslam El-Meniawy on 19-Feb-2018.
 * CITC - Mansoura University
 */

public class Data {
    @SerializedName("movie_count")
    private int count;

    private List<Movie> movies;

    //
    // Getters.
    //

    public int getCount() {
        return count;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}

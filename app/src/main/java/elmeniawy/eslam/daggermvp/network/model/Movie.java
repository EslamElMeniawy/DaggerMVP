package elmeniawy.eslam.daggermvp.network.model;

import com.google.gson.annotations.SerializedName;

/**
 * Movie
 * <p>
 * Created by Eslam El-Meniawy on 19-Feb-2018.
 * CITC - Mansoura University
 */

public class Movie {
    private String title;

    @SerializedName("small_cover_image")
    private String image;

    //
    // Getters.
    //

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
}

package elmeniawy.eslam.daggermvp.network;

import elmeniawy.eslam.daggermvp.network.model.SearchResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * ApiInterface
 * <p>
 * Created by Eslam El-Meniawy on 19-Feb-2018.
 * CITC - Mansoura University
 */

public interface ApiInterface {

    // Search movies API.
    @GET("list_movies.json")
    Observable<SearchResponse> searchMovies(@Query("query_term") String title);
}

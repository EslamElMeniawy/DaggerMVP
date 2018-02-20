package elmeniawy.eslam.daggermvp.main_screen;

import elmeniawy.eslam.daggermvp.network.ApiClient;
import elmeniawy.eslam.daggermvp.network.ApiInterface;
import elmeniawy.eslam.daggermvp.network.model.SearchResponse;
import io.reactivex.Observable;

/**
 * MainRepository
 * <p>
 * Created by Eslam El-Meniawy on 19-Feb-2018.
 * CITC - Mansoura University
 */

class MainRepository {
    Observable<SearchResponse> getResults(String title) {
        return ApiClient.getClient().create(ApiInterface.class).searchMovies(title);
    }
}

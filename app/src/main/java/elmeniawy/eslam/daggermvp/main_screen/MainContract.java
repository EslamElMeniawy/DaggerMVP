package elmeniawy.eslam.daggermvp.main_screen;

import java.util.List;

/**
 * MainContract
 * <p>
 * Created by Eslam El-Meniawy on 19-Feb-2018.
 * CITC - Mansoura University
 */

public interface MainContract {
    interface MainView {
        // button events
        void onSearchButtonClicked();

        // search results actions
        void displayResults(List<String> titles, List<String> images);

        void showResults(boolean show);

        // results error actions
        void displayErrorMessage(String message);

        void displayResultsError(Throwable throwable);

        void showError(boolean show);

        // loading indicator actions
        void setLoadingIndicator(boolean active);
    }

    interface MainPresenter {
        void loadResults(String title);
    }
}

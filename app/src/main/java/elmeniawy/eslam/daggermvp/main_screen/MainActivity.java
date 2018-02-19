package elmeniawy.eslam.daggermvp.main_screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import elmeniawy.eslam.daggermvp.R;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    @Inject
    MainPresenter presenter;

    @BindView(R.id.etSearchText)
    EditText etSearchText;

    @BindView(R.id.tvError)
    TextView tvError;

    @BindView(R.id.progressBar)
    ProgressBar loadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Timber.tag(MainActivity.class.getSimpleName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stop();
    }

    @Override
    @OnClick(R.id.btSearch)
    public void onSearchButtonClicked() {
        if (!etSearchText.getText().toString().isEmpty()) {
            presenter.loadResults(etSearchText.getText().toString());
        }
    }

    @Override
    public void displayResults(List<String> titles, List<String> images) {
        Timber.d("titles: %s\nimages:%s", titles.toString(), images.toString());
    }

    @Override
    public void showResults(boolean show) {

    }

    @Override
    public void displayErrorMessage(String message) {
        tvError.setText(message);
    }

    @Override
    public void displayResultsError(Throwable throwable) {
        Timber.e(throwable);
        tvError.setText("Error getting data");
    }

    @Override
    public void showError(boolean show) {
        tvError.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        loadingIndicator.setVisibility(active ? View.VISIBLE : View.GONE);
    }
}

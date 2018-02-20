package elmeniawy.eslam.daggermvp.movies_list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import elmeniawy.eslam.daggermvp.R;


/**
 * A simple {@link Fragment} subclass.
 * to handle interaction events.
 * Use the {@link MoviesListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoviesListFragment extends Fragment {

    private Unbinder unbinder;
    private MoviesAdapter moviesAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView moviesRecycler;

    public MoviesListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MoviesListFragment.
     */
    public static MoviesListFragment newInstance() {
        return new MoviesListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movies_list, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        moviesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        moviesAdapter = new MoviesAdapter(getContext());
        moviesRecycler.setAdapter(moviesAdapter);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void showRecycler(boolean show) {
        moviesRecycler.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void setData(List<String> titles, List<String> images) {
        moviesAdapter.setLists(titles, images);
    }
}

package elmeniawy.eslam.daggermvp.movies_list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import elmeniawy.eslam.daggermvp.R;


/**
 * A simple {@link Fragment} subclass.
 * to handle interaction events.
 * Use the {@link MoviesListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoviesListFragment extends Fragment {

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_list, container, false);
    }
}

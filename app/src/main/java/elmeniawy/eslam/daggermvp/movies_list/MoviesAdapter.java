package elmeniawy.eslam.daggermvp.movies_list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import elmeniawy.eslam.daggermvp.R;

/**
 * MoviesAdapter
 * <p>
 * Created by Eslam El-Meniawy on 20-Feb-2018.
 * CITC - Mansoura University
 */

public class MoviesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<String> listTitles = new ArrayList<>();
    private List<String> listImages = new ArrayList<>();

    MoviesAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    void setLists(List<String> listTitles, List<String> listImages) {
        this.listTitles = listTitles;
        this.listImages = listImages;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View view = layoutInflater.inflate(R.layout.movie_item, parent, false);
        viewHolder = new ViewHolderMovies(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolderMovies movieHolder = (ViewHolderMovies) holder;
        movieHolder.movieTitle.setText(listTitles.get(position));

        Picasso.with(context)
                .load(listImages.get(position))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(movieHolder.movieImage);
    }

    @Override
    public int getItemCount() {
        return listTitles.size();
    }

    class ViewHolderMovies extends RecyclerView.ViewHolder {

        @BindView(R.id.ivImage)
        ImageView movieImage;

        @BindView(R.id.tvTitle)
        TextView movieTitle;

        ViewHolderMovies(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

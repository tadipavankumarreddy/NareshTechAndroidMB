package in.nareshtechnologies.favoritemovies;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    // This method is used to create one single item on the recyclerview.
    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    // This method populates the data on the item given by onCreateViewHolder(..)
    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {

    }

    // This method tells the recyclerview about the total number of items that it has
    @Override
    public int getItemCount() {
        return 0;
    }

    // This class is used to connect the individual items (images,textviews...) on each
    // single item on Recyclerview
    public class MoviesViewHolder extends RecyclerView.ViewHolder {
        public MoviesViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

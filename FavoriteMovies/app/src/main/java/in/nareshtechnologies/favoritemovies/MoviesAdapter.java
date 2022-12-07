package in.nareshtechnologies.favoritemovies;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    // Get the data along with the context object while we create the object for MoviesAdapter
    Context context;
    int[] movie_posters; String[] names, actors;

    public MoviesAdapter(Context context, int[] movie_posters, String[] names, String[] actors) {
        this.context = context;
        this.movie_posters = movie_posters;
        this.names = names;
        this.actors = actors;
    }

    // This method is used to create one single item on the recyclerview.
    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.one_row_design,parent,false);
        return new MoviesViewHolder(v);
    }

    // This method populates the data on the item given by onCreateViewHolder(..)
    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        holder.iv.setImageResource(movie_posters[position]);
        holder.m_n.setText(names[position]);
        holder.a_n.setText(actors[position]);
    }

    // This method tells the recyclerview about the total number of items that it has
    @Override
    public int getItemCount() {
        return movie_posters.length;
    }

    // This class is used to connect the individual items (images,textviews...) on each
    // single item on Recyclerview
    public class MoviesViewHolder extends RecyclerView.ViewHolder {
        ImageView iv; TextView m_n, a_n;
        public MoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.movie_poster_display);
            m_n = itemView.findViewById(R.id.movie_name_display);
            a_n = itemView.findViewById(R.id.movie_actor_display);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    int img_id = movie_posters[position];
                    String n = names[position];
                    String a = actors[position];

                    Intent i = new Intent(context,DetailsActivity.class);
                    i.putExtra("IMAGE",img_id);
                    i.putExtra("MOVIE",n);
                    i.putExtra("ACTOR",a);

                    context.startActivity(i);
                }
            });
        }
    }
}

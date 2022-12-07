package in.nareshtechnologies.favoritemovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Movie;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private int[] movie_posters;
    private String[] movie_names;
    private String[] movie_actors;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        getDataReady();

        MoviesAdapter ma = new MoviesAdapter(this,movie_posters,movie_names,movie_actors);
        recyclerView.setAdapter(ma);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void getDataReady() {
        movie_posters = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
        R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j};
        movie_names = new String[]{"Adipurush", "Bahubali", "Chhapak","Drishyam","End Game","fukrey","Gajani",
        "Heropanti","I","Joker"};
        movie_actors = new String[]{"Prabhas","Prabhas","Deepika","Ajay","Robert","Ali Fazal","Aamir khan",
        "Tiger Shroff","Vikram","Phonix"};
    }

    // TODO 1: (Completed) Get the data ready
    // TODO 2: (Completed) Design how you want to display each item on RV
    // TODO 3: (Completed) Add & Connect to RV (RecyclerView)
    // TODO 4: Create an Adapter along with View Holder
    // TODO 5: Set the Adapter on RV
    // TODO 6: set the Layout Manager (Linear, Grid, Staggered)

}
package in.nareshtechnologies.fruitslistview;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView fruitsList;
    String []fruits;
    int []fruits_images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fruitsList = findViewById(R.id.fruits_list);

        //TODO 1 CREATE a Fruits List array
        fruits = new String[]{"Apple", "Banana", "Avocado","Orange","Grapes","Mango","Kiwi","Water melon","Papaya","Guava","Custard Apple", "Pine Apple"};
        fruits_images = new int[]{R.drawable.a, R.drawable.b,R.drawable.av, R.drawable.or,R.drawable.g,R.drawable.mango,
        R.drawable.kiwi,R.drawable.watermelon,R.drawable.papaya,R.drawable.guava,R.drawable.custardapple,R.drawable.papple};

        //TODO 2: display all the names on the ListView
            // TODO 2.1: First create the Adapter
       /* ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,fruits);*/
            // TODO 2.2 : set The Adapter on top of List view
        /*fruitsList.setAdapter(adapter);*/

        // TODO 3: When an item is selected, how do we go about it
        /*fruitsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
            }
        });*/

        FruitsAdapter fa = new FruitsAdapter();
        fruitsList.setAdapter(fa);
    }

    class FruitsAdapter extends BaseAdapter{
        FruitsAdapter(){

        }

        // This method returns the total number of items
        @Override
        public int getCount() {
            return fruits.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            if(view==null){
                view = getLayoutInflater().inflate(R.layout.one_item_design,viewGroup,false);
            }
            ImageView fruits_image_view = view.findViewById(R.id.fruit_image);
            TextView fruits_name_tv = view.findViewById(R.id.fruit_name);

            fruits_image_view.setImageResource(fruits_images[position]);
            fruits_name_tv.setText(fruits[position]);

            return view;
        }
    }
}
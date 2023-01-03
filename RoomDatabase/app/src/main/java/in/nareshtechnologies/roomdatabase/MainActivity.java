package in.nareshtechnologies.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import in.nareshtechnologies.roomdatabase.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    StudentsDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);*/
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        database = Room.databaseBuilder(this,StudentsDatabase.class,"students")
                        .allowMainThreadQueries()
                                .build();
        
        binding.button.setOnClickListener(view -> {
            String n = binding.etName.getText().toString();
            int a = Integer.parseInt(binding.etAge.getText().toString());
            
            Students s = new Students(n,a);
            database.studentsDAO().insertData(s);
            Toast.makeText(this, "Data is saved successfully!", Toast.LENGTH_SHORT).show();
        });

        binding.button2.setOnClickListener(view -> {
            binding.textView.setText("");
            List<Students> students = database.studentsDAO().getAllData();
            for(Students s: students){
                binding.textView.append(s.getStudents_id()+" "+s.getStudents_name()+" "+s.getStudents_age()+"\n");
            }
            Toast.makeText(this, "Data retrieved", Toast.LENGTH_SHORT).show();
        });
    }
}
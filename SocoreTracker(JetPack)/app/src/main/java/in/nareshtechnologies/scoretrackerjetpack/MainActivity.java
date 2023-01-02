package in.nareshtechnologies.scoretrackerjetpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import in.nareshtechnologies.scoretrackerjetpack.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    MainViewModel mvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);*/
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        mvm = new ViewModelProvider(this).get(MainViewModel.class);

        binding.textView.setText(String.valueOf(mvm.count));

        binding.button.setOnClickListener(view -> {
            mvm.increment();
            binding.textView.setText(String.valueOf(mvm.count));
        });

        binding.button2.setOnClickListener(view -> {
            mvm.decrement();
            binding.textView.setText(String.valueOf(mvm.count));
        });
    }
}
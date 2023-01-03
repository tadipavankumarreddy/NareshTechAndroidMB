package in.nareshtechnologies.scoretrackerjetpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
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

        mvm.count.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.textView.setText(String.valueOf(mvm.count.getValue()));
            }
        });

        binding.button.setOnClickListener(view -> {
            mvm.increment();
        });

        binding.button2.setOnClickListener(view -> {
            mvm.decrement();
        });
    }
}
package in.nareshtechnologies.tabsfornavigation;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabLayout);
        ViewPagerAdapter vpa = new ViewPagerAdapter(this);
        viewPager2.setAdapter(vpa);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0: tab.setText("RED"); break;
                    case 1: tab.setText("GREEN"); break;
                    case 2: tab.setText("BLUE"); break;
                }
            }
        }).attach();
    }

    // if you want to override the default behavior of back button (<), we can use this method
    @Override
    public void onBackPressed() {
        /*super.onBackPressed(); -> this line must be removed. otherwise overriding is not possible*/
        AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
        alert.setTitle("Hello User!");
        alert.setMessage("This is our first alert dialog");
        alert.setIcon(R.drawable.ic_baseline_auto_awesome_24);

        // Alert dialog boxes can have 3 buttons (1 positive, 1 negative and 1 neutral)
        alert.setPositiveButton("yes", (dialogInterface, i) -> {
            Toast.makeText(getApplicationContext(), "Yes is pressed", Toast.LENGTH_SHORT).show();
            dialogInterface.cancel();
        });
        alert.setNegativeButton("no",null);
        alert.setNeutralButton("cancel",null);

        alert.show();
    }

    class ViewPagerAdapter extends FragmentStateAdapter{


        public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0: return new RedFragment();
                case 1: return new GreenFragment();
                case 2: return new BlueFragment();
            }

            return null;
        }


        @Override
        public int getItemCount() {
            return 3;
        }
    }
}
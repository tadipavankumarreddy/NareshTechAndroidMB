package in.nareshtechnologies.tabsfornavigation;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class GreenFragment extends Fragment {


    public GreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_green, container, false);

        Button button = v.findViewById(R.id.button3);

        button.setOnClickListener(view -> {
            AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
            alert.setTitle("Hello User!");
            alert.setMessage("This is our first alert dialog");
            alert.setIcon(R.drawable.ic_baseline_auto_awesome_24);

            // Alert dialog boxes can have 3 buttons (1 positive, 1 negative and 1 neutral)
            alert.setPositiveButton("yes", (dialogInterface, i) -> {
                Toast.makeText(getContext(), "Yes is pressed", Toast.LENGTH_SHORT).show();
                dialogInterface.cancel();
            });
            alert.setNegativeButton("no",null);
            alert.setNeutralButton("cancel",null);

            alert.show();

        });

        return v;
    }
}
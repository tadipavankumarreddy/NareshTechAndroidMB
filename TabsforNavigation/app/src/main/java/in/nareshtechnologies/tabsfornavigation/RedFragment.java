package in.nareshtechnologies.tabsfornavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class RedFragment extends Fragment  {

    public RedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_red, container, false);;

        EditText num1 = v.findViewById(R.id.editTextNumber); EditText num2 = v.findViewById(R.id.editTextNumber2);
        Button plus = v.findViewById(R.id.button); Button minus = v.findViewById(R.id.button2);
        TextView result = v.findViewById(R.id.textView);

        plus.setOnClickListener(view -> {
            int n1 = Integer.parseInt(num1.getText().toString());
            int n2 = Integer.parseInt(num2.getText().toString());
            result.setText(String.valueOf(n1+n2));
        });

        minus.setOnClickListener(view -> {
            int n1 = Integer.parseInt(num1.getText().toString());
            int n2 = Integer.parseInt(num2.getText().toString());
            result.setText(String.valueOf(n1-n2));
        });

        return v;
    }

}
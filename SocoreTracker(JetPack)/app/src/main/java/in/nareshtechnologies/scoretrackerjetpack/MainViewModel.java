package in.nareshtechnologies.scoretrackerjetpack;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    int count;
    public MainViewModel() {
        count = 0;
    }

    public void increment(){
        count++;
    }

    public void decrement(){
        count--;
    }

    // onCleared() method is encountered when the view model is about to be destroyed
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.v("MAIN","ViewModel is Destroyed!");
    }
}

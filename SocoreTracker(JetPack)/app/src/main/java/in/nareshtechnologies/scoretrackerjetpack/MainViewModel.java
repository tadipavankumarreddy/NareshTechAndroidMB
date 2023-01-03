package in.nareshtechnologies.scoretrackerjetpack;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    MutableLiveData<Integer> count;
    public MainViewModel() {
        count = new MutableLiveData<>();
        count.setValue(0);
    }

    public void increment(){
        count.setValue(count.getValue() + 1);
    }

    public void decrement(){
        count.setValue(count.getValue() - 1);
    }

    // onCleared() method is encountered when the view model is about to be destroyed
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.v("MAIN","ViewModel is Destroyed!");
    }
}

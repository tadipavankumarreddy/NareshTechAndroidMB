package in.nareshtechnologies.fruityvice;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class FetchFruits extends AsyncTask<String,Void,String> {

    Context context;
    TextView textView;
    ProgressBar progressBar;

    public FetchFruits(Context context, TextView textView, ProgressBar progressBar) {
        this.context = context;
        this.textView = textView;
        this.progressBar = progressBar;
    }

    // This is the method from where we do the background task.
    // This doInBackground(...) runs in the background thread
    @Override
    protected String doInBackground(String... strings) {
        // First of all get the url-  from which you need to read data
        String link = strings[0]; // We should send the url from MainActivity as first arg
        // Convert it to URL type
        try {
            URL url = new URL(link);
            // Open  the connection (HttpsURLConnection)
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            // You have to read the data of the url - you need to get the input stream
            InputStream is = urlConnection.getInputStream();
            // Now read the data line by line using BufferedReader
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer stringBuffer = new StringBuffer();
            while((line = br.readLine())!=null){
                stringBuffer.append(line);
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // doInBackground(...) returns data to which method ?
    // Answer: onPostExecute(...) method


    // onPostExecute(..) method runs on Main or UI Thread
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        progressBar.setVisibility(View.INVISIBLE);
        // Parse the data
        textView.setText("");
        try {
            JSONArray array = new JSONArray(s);
            for(int i=0; i<array.length(); i++){
                JSONObject item = array.getJSONObject(i);
                String name = item.getString("name");
                JSONObject nutritions = item.getJSONObject("nutritions");
                double carbs = nutritions.getDouble("carbohydrates");
                double protein = nutritions.getDouble("protein");
                double fat = nutritions.getDouble("fat");
                int calories = nutritions.getInt("calories");
                double sugar = nutritions.getDouble("sugar");

                textView.append("--------------------\n");
                textView.append(name+"\n");
                textView.append("Nutrition info: carbs:"+carbs+" Protein:"+protein+" fat:"+fat+" calories:"+calories+"\n");
                textView.append("--------------------\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

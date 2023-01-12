package `in`.nareshtechnologies.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button:Button = findViewById(R.id.button)
        val button2:Button = findViewById(R.id.button2)
        val tv:TextView = findViewById(R.id.textView)

        var count = 0;

        button.setOnClickListener(View.OnClickListener {
           count = count+1
            tv.text = ""+count
        })

        button2.setOnClickListener(View.OnClickListener {
            count = count-1
            tv.text = ""+count
        })
    }
}
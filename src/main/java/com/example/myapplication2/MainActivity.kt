package com.example.myapplication2

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.transition.Visibility

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onApearButtonsClick(view: View):Unit{
        var button:Button=view as Button
        if (button != null)
            when (view.id){
                R.id.button1-> {
                    DesappearButton(R.id.button1)
                    AppearButton(R.id.button2)
                }
                R.id.button2->{
                    DesappearButton(R.id.button2)
                    AppearButton(R.id.button1)
                }
            }
    }
    fun AppearButton(buttonId: Int):Unit{
        findViewById<Button>(buttonId).visibility= View.VISIBLE
    }
    fun DesappearButton(buttonId: Int):Unit{
        findViewById<Button>(buttonId).visibility=View.INVISIBLE
    }
}





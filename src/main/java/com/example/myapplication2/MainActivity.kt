package com.example.myapplication2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.transition.Visibility

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.tablelayout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tableLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setTitle("TableLayout")
    }



    fun onOrientClick(view: View):Unit{
        val orientationTextView= findViewById<TextView>(R.id.textView2)
        val viewParent=view.parent as LinearLayout

        val outputResult:String=if(viewParent.orientation==0) "Горизонтальная"; else "Вертикальная";
        orientationTextView.setText(outputResult)
    }

    fun onGravityClick(view: View):Unit{
        val buttonRef=findViewById<Button>(view.id) as Button

        val orientationTextView= findViewById<TextView>(R.id.textView4)

        val params = buttonRef.layoutParams as LinearLayout.LayoutParams
        val gravity=params.gravity

        val outputResult:String=
            if(gravity==Gravity.START) "по левой границе";
                else
            if(gravity==Gravity.END) "по правой границе";
                else "по центру";

        orientationTextView.setText(outputResult)
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





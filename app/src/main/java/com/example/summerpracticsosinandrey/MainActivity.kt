package com.example.summerpracticsosinandrey

import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private var string:String = ""
    set(value) {
        field = if(value.equals("error"))
            "Данные введены некорректно"
        else "Ответ: $value"
        textView?.text = field
    }
    private var textView: TextView? = null
    private var nameIn: EditText? = null
    private var heightIn: EditText? = null
    private var weightIn: EditText? = null
    private var ageIn: EditText? = null
    private var button: Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        nameIn = findViewById(R.id.editTextName);
        heightIn = findViewById(R.id.editTextHeight);
        weightIn = findViewById(R.id.editTextWeight);
        ageIn = findViewById(R.id.editTextAge);
        button = findViewById(R.id.button);
        button?.setOnClickListener{
            pressTheButton()
        }

    }

    private fun pressTheButton(){
        val name:String = nameIn?.text.toString()
        string = try {
            val height = heightIn?.text.toString().toInt()
            val weight = weightIn?.text.toString().toDouble()
            val age = ageIn?.text.toString().toInt()
            if(name.length in 1..50&&height in 1..249&&weight>0&&weight<250&&age in 1..149){
                name+" "+(height*weight*age)
            } else{
                "error"
            }
        } catch (e:NumberFormatException){
            "error"
        }
    }

}
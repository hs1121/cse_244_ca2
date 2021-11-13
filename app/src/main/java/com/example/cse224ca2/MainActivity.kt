package com.example.cse224ca2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.RadioButton




class MainActivity : AppCompatActivity() ,CompoundButton.OnCheckedChangeListener{

    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var radioGroup: RadioGroup
    private lateinit var buttonNextActivity: Button
    private lateinit var checkBox1: CheckBox
    private lateinit var checkBox2: CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()

        button.setOnClickListener { editText.text?.let { showToast(it.toString()) } }
        radioGroup.setOnCheckedChangeListener { radioGroup, id ->
            val radioButton = findViewById<RadioButton>(id)
            showToast(radioButton.text.toString())
        }
        checkBox1.setOnCheckedChangeListener(this)
        checkBox2.setOnCheckedChangeListener(this)

        buttonNextActivity.setOnClickListener { startActivity(Intent(applicationContext,Question1::class.java)) }


    }

    private fun initUi(){
        editText=findViewById(R.id.edit_text)
        button=findViewById(R.id.button)
        buttonNextActivity=findViewById(R.id.button_next_activity)
        radioGroup=findViewById(R.id.radio_group)
        checkBox1=findViewById(R.id.checkbox_1)
        checkBox2=findViewById(R.id.checkbox_2)
    }

    private fun showToast(msg:String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onCheckedChanged(compoundButton: CompoundButton?, checked: Boolean) {
        if (checked)
            showToast(compoundButton?.text.toString())
    }
}
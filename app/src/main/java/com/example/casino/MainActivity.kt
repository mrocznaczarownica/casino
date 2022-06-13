package com.example.casino

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var count:EditText
    val choose = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun upCount(view: android.view.View) {
        count = findViewById(R.id.count)
        var count1 = count.text.toString().toInt()
        var count2 = count1 + 1000
        count.setText(count2.toString())
    }

    fun startGame(view: android.view.View) {
        val intent = Intent(this, game::class.java)
        var count1 = count.text.toString()
        intent.putExtra("count", count1)
        startActivityForResult(intent, choose)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == choose){
            if(resultCode == Activity.RESULT_OK){
                val thriefName = data?.getStringExtra("countRes")
                count.setText(thriefName.toString())
            }
        }
    }
}
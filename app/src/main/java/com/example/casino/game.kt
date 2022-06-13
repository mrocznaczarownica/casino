package com.example.casino

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class game : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val count = getIntent().getStringExtra("count")
        var co:EditText = findViewById(R.id.count)
        co.setText(count.toString())
    }

    fun randomClick(view: android.view.View) {
        var stavka:EditText = findViewById(R.id.stavka)
        var count:EditText = findViewById(R.id.count)
        if(stavka.text != null && stavka.text.toString().toInt() < count.text.toString().toInt()){
            var rand = (1..6).random()
            var user:TextView = findViewById(R.id.user)
            user.setText(rand.toString())
            var rand1 = (1..6).random()
            var bot:TextView = findViewById(R.id.bot)
            bot.setText(rand1.toString())

            var user1:Int = user.text.toString().toInt()
            var bot1:Int = bot.text.toString().toInt()

            if(user1 > bot1){
                val toast = Toast.makeText(this, "Вы победили", Toast.LENGTH_SHORT)
                toast.show()
                var result:Int = count.text.toString().toInt() + stavka.text.toString().toInt()
                count.setText(result.toString())
            }
            else if(bot1 > user1){
                val toast = Toast.makeText(this, "Вы проиграли", Toast.LENGTH_SHORT)
                toast.show()
                var result:Int = count.text.toString().toInt() - stavka.text.toString().toInt()
                count.setText(result.toString())
            }
            else if(user1 == bot1){
                val toast = Toast.makeText(this, "Ничья", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
        else if(stavka.text.toString().toInt() > count.text.toString().toInt()){
            val toast = Toast.makeText(this, "Ваша ставка больше вашего баланса", Toast.LENGTH_SHORT)
            toast.show()
        }
        else if(stavka.text == null){
            val toast = Toast.makeText(this, "Введите ставку", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    fun endGame(view: android.view.View) {
        val intent = Intent(this, MainActivity::class.java)
        var count:EditText = findViewById(R.id.count)
        val count1:String = count.text.toString()
        intent.putExtra("countRes", count1)
        setResult(RESULT_OK, intent)
        finish()
    }
}
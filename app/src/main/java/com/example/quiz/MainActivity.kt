package com.example.quiz

import android.icu.text.UnicodeSetSpanner
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {





    private val questionBank = listOf(
        Question(R.string.qustion_Sanaa,true),
        Question(R.string.question_comercial,false),
        Question(R.string.question_coin,false),
        Question(R.string.question_ibb,true))
    private var currentIndex = 0






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        true_button.setOnClickListener {

            checkAnswer(true)

        }

        false_button.setOnClickListener {
            checkAnswer(false)

        }

        next_button.setOnClickListener {

            currentIndex = (currentIndex + 1) % questionBank.size
            updateQusetion()}


        prev_button.setOnClickListener {
            currentIndex = if(currentIndex == 0) {
                questionBank.size - 1
            }
            else {
                currentIndex - 1
            }

            updateQusetion()
        }




        updateQusetion()

    }
    private fun updateQusetion (){
        val questionTextResId = questionBank[currentIndex].textResId
        question_text_view.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer :Boolean){
        val correctAnswer = questionBank[currentIndex].answer
        var messageResId =  if(userAnswer==correctAnswer){
            R.string.correct_toast
        }else{
            R.string.incorrect_toast
        }
        var toastA=Toast.makeText(this,messageResId,Toast.LENGTH_LONG)
        toastA.setGravity(Gravity.TOP,0,0)
        toastA.show()
    }
}

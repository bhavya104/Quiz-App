package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quizapp.R.layout
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionsList:ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_quiz_questions)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionsList = Constants.getQuestions()

        setQuestion()

        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    private fun setQuestion() {

        val question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionsView()

        if(mCurrentPosition == mQuestionsList!!.size){
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text = "SUBMIT"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max

        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        optionOne.text = question.optionOne
        optionTwo.text = question.optionTwo
        optionThree.text = question.optionThree
        optionFour.text = question.optionFour

    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0,optionOne)
        options.add(1,optionTwo)
        options.add(2,optionThree)
        options.add(3,optionFour)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.optionOne -> {
                selectedOptionView(optionOne, 1)
            }

            R.id.optionTwo -> {
                selectedOptionView(optionTwo, 2)
            }

            R.id.optionThree -> {
                selectedOptionView(optionThree, 3)
            }

            R.id.optionFour -> {
            selectedOptionView(optionFour, 4)
            }

            R.id.btn_submit -> {
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        } else -> {
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME, mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                        startActivity(intent)
                        finish()
                    }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)
                    if(mCurrentPosition == mQuestionsList!!.size){
                        btn_submit.text = "FINISH"
                    }else {
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){

            1 ->{
                optionOne.background = ContextCompat.getDrawable(this,drawableView)
            }

            2 ->{
                optionTwo.background = ContextCompat.getDrawable(this,drawableView)
            }

            3 ->{
                optionThree.background = ContextCompat.getDrawable(this,drawableView)
            }

            4 ->{
                optionFour.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }


    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }
}
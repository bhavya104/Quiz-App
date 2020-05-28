package com.example.quizapp

object Constants {

    const val USER_NAME: String ="user_name"
    const val TOTAL_QUESTIONS: String ="total_question"
    const val CORRECT_ANSWERS: String ="correct_answers"


    fun getQuestions(): ArrayList<Question>{

        val questionsList = ArrayList<Question>()

        val ques1 = Question(1,"Guess the Logo ?",R.drawable.android,"Apple","Android","Windows","None of Above",2)
        val ques2 = Question(2,"Guess the Logo ?",R.drawable.github,"Github","Microsoft","Google","None of Above",1)
        val ques3 = Question(3,"Guess the Logo ?",R.drawable.apple,"Android","Microsoft","Apple","None of Above",3)
        val ques4 = Question(4,"This Trophy belongs to which Category?",R.drawable.mensclassicphysique,"Mass Monsters","Classic Physique","Diva Championship","None of Above",2)
        val ques5 = Question(5,"This Trophy belongs to which Category ?",R.drawable.mrindia,"MR WORLD","MR ASIA","MR  INDIA","None of Above",3)
        val ques6 = Question(6,"Guess the Logo ?",R.drawable.starbuckslogo,"Star Bucks","Mc Donalds","Pta Nahi","None of Above",1)
        val ques7 = Question(7,"Guess the Logo ?",R.drawable.wwe,"Boxing","WWE","Moto-e Racing ","None of Above",2)
        val ques8 = Question(8,"Guess the Logo ?",R.drawable.mcdonalds,"Zomato","Swiggy","Mc Donalds","None of Above",3)
        val ques9 = Question(9,"Guess the Brand Name ?",R.drawable.louisvuittonlogo,"GUCCI","Louis Vuitton","Audi","None of Above",2)
        val ques10 = Question(10,"Guess the Logo ?",R.drawable.spotify,"Gaana","Musically","Tik-Tok","None of Above",4)

        questionsList.add(ques1)
        questionsList.add(ques2)
        questionsList.add(ques3)
        questionsList.add(ques4)
        questionsList.add(ques5)
        questionsList.add(ques6)
        questionsList.add(ques7)
        questionsList.add(ques8)
        questionsList.add(ques9)
        questionsList.add(ques10)

        return questionsList
    }

}
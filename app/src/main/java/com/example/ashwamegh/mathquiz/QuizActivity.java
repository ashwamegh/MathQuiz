package com.example.ashwamegh.mathquiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ConcurrentHashMap;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private Button mCheatButton;

    private boolean mCheated;
    private QuestionBank[] mQuestionBank = new QuestionBank[]{
            new QuestionBank(R.string.question_1, true),
            new QuestionBank(R.string.question_2,true),
            new QuestionBank(R.string.question_3,true),
            new QuestionBank(R.string.question_4,true),
            new QuestionBank(R.string.question_5,false)

    };

    private int currentIndex =0;

    private static final String TAG="QuizActivity";
    private static final String KEY_INDEX="INDEX";
    private static final int REQUEST_CODE_CHEAT=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        Log.d(TAG,"Inside OnCreate Method");

        mQuestionTextView= (TextView) findViewById(R.id.question_text_view);

        if (savedInstanceState!=null){
            currentIndex=savedInstanceState.getInt(KEY_INDEX,0);
        }
        updateQuestion();



        mTrueButton= (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkAnswer(true);
            }
        });

        mFalseButton =(Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex=(currentIndex +1)% mQuestionBank.length;
                updateQuestion();
            }
        });

        mCheatButton = (Button) findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Cheat Button Pressed");
                Intent i = CheatActivity.newIntent(QuizActivity.this,currentIndex);
                //startActivity(i);
                //Replacing the startActivity function with one to reciece data

                startActivityForResult(i,REQUEST_CODE_CHEAT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode!= Activity.RESULT_OK){
            return;
        }

        if(requestCode== REQUEST_CODE_CHEAT){
            if(data==null){
                return;
            }
            mCheated= CheatActivity.wasCheatShown(data);
        }
    }

    private void updateQuestion() {
        int question = mQuestionBank[currentIndex].getQuestion();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(Boolean userPressedTrue){
        Boolean answerisTrue=mQuestionBank[currentIndex].isTrueQuestion();

        int messageResId=0;

        if(userPressedTrue==answerisTrue){

            messageResId=R.string.correct_toast;

        }
        else{
            messageResId=R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart(){
        super.onStart();

        Log.d(TAG,"Inside onStart");
    }

    @Override
    protected void onPause(){
        super.onPause();

        Log.d(TAG,"Inside onPasue");
    }
    @Override
    protected void onResume(){
        super.onResume();

        Log.d(TAG,"Inside onResume");
        Log.e(TAG,"INside e call");
        Log.i(TAG,"Inside i call");
        Log.v(TAG,"Inside Verbose");
        Log.w(TAG,"Inside Warning");

        Log.d(TAG,"Did user Cheat ? "+mCheated);
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG,"Inside onRestart");
    }
    @Override
    protected void onStop(){
        super.onStop();

        Log.d(TAG,"Inside onStop");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();

        Log.d(TAG,"Inside onDestroy");
    }

    //Method to save the current State of instances//
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(KEY_INDEX,currentIndex);
    }
}


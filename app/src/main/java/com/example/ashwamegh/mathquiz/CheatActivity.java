package com.example.ashwamegh.mathquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class CheatActivity extends AppCompatActivity {


    //Declaration of Global Identifiers
    public static final String TAG="CheatActivity";
    public static final String Cheat_Index= "CheatIndex";
    private static final String Is_Cheated="Is_Cheated";
    private boolean isCheated=false;



    //Intent Method to receive the data from QuizActivity class and Process further
    public static Intent newIntent(Context context, boolean b){
        Intent intent= new Intent(context, CheatActivity.class);
        intent.putExtra(Cheat_Index,b);

        return intent;

    }

    //Judges and return the boolean value it receives
    public static boolean wasCheatShown(Intent i){
        return i.getBooleanExtra(Is_Cheated,false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        Log.d(TAG,"Inside OnCreate of CheatActivity");

        //Gets the integer value from newIntent method and saves it to check the corresponding value
        int i = getIntent().getIntExtra(Cheat_Index,-999);

        Log.d(TAG,"Received Value:"+i);
        if(i>=0){
            isCheated=true;
        }
        setAnswerResult(isCheated);
    }


    //Check if the user has cheated or not and Set The Result
    private void setAnswerResult(boolean b){
        Intent i=new Intent();
        i.putExtra(Is_Cheated,b);
        setResult(RESULT_OK,i);

    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG,"Inside OnStart of CheatActivity");

    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"Inside OnResume of CheatActivity");

    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"Inside OnPause of CheatActivity");

    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG,"Inside OnStop of CheatActivity");

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"Inside OnStart of CheatActivity");

    }

}

package com.example.ashwamegh.mathquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class CheatActivity extends AppCompatActivity {

    public static final String TAG="CheatActivity";
    public static final String Cheat_Index= "CheatIndex";


    public static Intent newIntent(Context context, int i){
        Intent intent= new Intent(context, CheatActivity.class);
        intent.putExtra(Cheat_Index,i);
        
        return intent;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        Log.d(TAG,"Inside OnCreate of CheatActivity");
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

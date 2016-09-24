package com.example.ashwamegh.mathquiz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {


    //Declaration of Global Identifiers
    public static final String TAG="CheatActivity";
    public static final String ANSWER_IS_TRUE= "com.ashwamegh.mathquiz.answer_is_true";
    private static final String Is_Cheated="Is_Cheated";
    private boolean isCheated=false;
    private TextView mCheatAnswerTextView;
    private Button mShowCheatButton;
    private String mCheat;



    //Intent Method to receive the data from QuizActivity class and Process further
    public static Intent newIntent(Context context, boolean b){
        Intent intent= new Intent(context, CheatActivity.class);
        intent.putExtra(ANSWER_IS_TRUE,b);

        return intent;

    }

    //Judges and return the boolean value it receives
    public static boolean wasCheatShown(Intent i){
        return i.getBooleanExtra(Is_Cheated,false);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        Log.d(TAG,"Inside OnCreate of CheatActivity");

        //Gets the integer value from newIntent method and saves it to check the corresponding value
        isCheated = getIntent().getBooleanExtra(ANSWER_IS_TRUE, false);


                //Setting cheat Answer text view to receive the cheat hint
        mCheatAnswerTextView=(TextView) findViewById(R.id.cheatAnswer_text_view);

        //Initialising cheat button
        mShowCheatButton=(Button) findViewById(R.id.show_cheat_button);
        mShowCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG,"Show Cheat Pressed");

                if (isCheated){
                    mCheatAnswerTextView.setText(R.string.true_button);
                }
                else
                    mCheatAnswerTextView.setText(R.string.false_button);

                setAnswerResult(true);

                //Introduced Implicit Intents to evoke a webpage in another application(Here :A browser)//

                Uri webpage= Uri.parse("http://www.android.com");
                Intent wenIntent=new Intent(Intent.ACTION_VIEW,webpage);
                startActivity(wenIntent);
            }
        });
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

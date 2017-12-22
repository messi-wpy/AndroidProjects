package com.bignerdranch.androidboy.geoquiz;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class QuizActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mCheatButton;
    private ImageButton mNextbutton;
    private ImageButton mNextbutton2;
    private TextView mQuestionTextView;
    private int grade=0;
    private boolean mIsCheater;
    private static final String TAG="QuizActivity";
    private static final String KEY_INDEX="index";
    private static final int REQUEST_CODE_CHEAT=0;
    private static final String CHEAT_TRUE="anti-cheat";

    private Question[] mQuestionsBank = new Question[]{
            new Question(R.string.question_australia,true),
            new Question(R.string.question_oceans,true),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_africa,false),
            new Question(R.string.question_americas,true),
            new Question(R.string.question_asia,true)
    };
          private int mCurrentIndex =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate(Bundle) called");
        setContentView(R.layout.activity_quiz);
        mFalseButton=(Button)findViewById(R.id.false_button);
        mTrueButton=(Button) findViewById(R.id.true_button);
        mCheatButton=(Button)findViewById(R.id.cheat_button) ;
        mQuestionTextView=(TextView) findViewById(R.id.question_text_view);

        if(savedInstanceState!=null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
           mIsCheater=savedInstanceState.getBoolean(CHEAT_TRUE,false);
        }
      updateQuestion();
      mQuestionTextView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              mCurrentIndex=(mCurrentIndex +1)% mQuestionsBank.length;
              updateQuestion();
          }
      });
        mNextbutton2=(ImageButton)findViewById(R.id.next_button2);
        mNextbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex-=1;
                if(mCurrentIndex==-1)
                    mCurrentIndex+=mQuestionsBank.length;
                mIsCheater=mQuestionsBank[mCurrentIndex].isHaveCheated();
                updateQuestion();

            }
        });


        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              checkAnswer(true);
            }

        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              checkAnswer(false);

            }
        });
        mNextbutton =(ImageButton) findViewById(R.id.next_button);
        mNextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCurrentIndex=(mCurrentIndex +1)% mQuestionsBank.length;
                mIsCheater=mQuestionsBank[mCurrentIndex].isHaveCheated();
                updateQuestion();
            }
        });

        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              boolean answerIsTrue=mQuestionsBank[mCurrentIndex].isAnswerTrue();
              Intent intent=CheatActivity.newIntent(QuizActivity.this,answerIsTrue);//第一次父activity给子传递
               startActivityForResult(intent,REQUEST_CODE_CHEAT);
            }
        });




    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"onStart() called");
    }
    @Override
    public void onResume(){
         super.onResume();
        Log.d(TAG,"onResume() called");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"onPause() called");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"onStop() called");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy() called");
    }

    private void updateQuestion(){
        int question=mQuestionsBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
        setButtons();
    }
    private void checkAnswer(boolean usePressedTrue) {
        boolean answerisTrue = mQuestionsBank[mCurrentIndex].isAnswerTrue();
        mIsCheater=mQuestionsBank[mCurrentIndex].isHaveCheated();
        mQuestionsBank[mCurrentIndex].setTag(1);
        int messageResId = 0;
        if(mIsCheater)
              messageResId=R.string.judgment_toast;
              else {
            if (usePressedTrue == answerisTrue) {
                messageResId = R.string.correct_toast;
                grade += 1;
            } else {
                messageResId = R.string.incorrect_toast;
            }
        }

            setButtons();
            Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
            if (mCurrentIndex == 5) {
                String mgrade = percent(grade, 6);

                Toast.makeText(this, "你答对了" + mgrade, Toast.LENGTH_LONG).show();
            }

    }
//储存数据
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG,"onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX,mCurrentIndex);
        savedInstanceState.putBoolean(CHEAT_TRUE,mIsCheater);

    }
    public void setButtons() {
        if (mQuestionsBank[mCurrentIndex].getTag() == 1) {
            mFalseButton.setEnabled(false);
            mTrueButton.setEnabled(false);
        }
        if (mQuestionsBank[mCurrentIndex].getTag() == 0) {

            mTrueButton.setEnabled(true);
            mFalseButton.setEnabled(true);
        }
    }


    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public   static  String percent( double  p1,  double  p2) {
        String str;
        double p3 = p1 / p2;
        NumberFormat nf = NumberFormat.getPercentInstance();
        //nf.setMinimumFractionDigits(2);
        str = nf.format(p3);
        return str;
    }

    protected void onActivityResult(int resquestCode,int resultCode,Intent data){
        if(resultCode!= Activity.RESULT_OK){
            return;
        }
        if(resquestCode==REQUEST_CODE_CHEAT) {
            if(data==null){
                return;
            }
            mQuestionsBank[mCurrentIndex].setHaveCheated(CheatActivity.wasAnswerShown(data));

        }

        }
    }




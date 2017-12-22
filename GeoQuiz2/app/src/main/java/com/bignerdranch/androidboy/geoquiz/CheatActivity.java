package com.bignerdranch.androidboy.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    private static final String EXTRA_ANSWER_IS_TRUE=
            "com.bignerdranch.android.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN=
            "com.bignerdranch.android.geoquiz.answer_shown";
    private static final String HAVE_CHEAT="Having cheated";
    private boolean mAnswerIsTrue;
    private Button mShowAnswerButton;
    private TextView mAnswerTextView;
    private boolean cheated=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue=getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);
        if(savedInstanceState !=null)
            cheated=savedInstanceState.getBoolean(HAVE_CHEAT,false);

        mAnswerTextView=findViewById(R.id.andswer_text_view);
        mShowAnswerButton=findViewById(R.id.show_anwser_button);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAnswerIsTrue)
                    mAnswerTextView.setText(R.string.true_button);
                else
                    mAnswerTextView.setText(R.string.false_button);
                cheated=true;
                setAnswerShownResult(cheated);
            }
        });
        setAnswerShownResult(cheated);

    }
    public static Intent newIntent(Context packagecontext,boolean answerIsTrue){
        Intent intent=new Intent(packagecontext,CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE,answerIsTrue);
        return intent;
    }

    private void setAnswerShownResult(boolean isAnswerShwn){
        Intent date =new Intent();
        date.putExtra(EXTRA_ANSWER_SHOWN,isAnswerShwn);
        setResult(RESULT_OK,date);
    }
    public static boolean wasAnswerShown(Intent result){
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN,false);
    }

    public void onSaveInstanceState(Bundle onSaveInstanceState){
        super.onSaveInstanceState(onSaveInstanceState);
        onSaveInstanceState.putBoolean(HAVE_CHEAT,cheated);

    }
}

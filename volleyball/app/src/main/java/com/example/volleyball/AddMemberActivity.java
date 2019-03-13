package com.example.volleyball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.volleyball.data.MemberData;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddMemberActivity extends AppCompatActivity {

    public static final int RESULTCODE = 222;
    public static final String EXERA = "MEMBER";
    private MemberData member;

    @BindView(R.id.play_name_ed)
     EditText name_ed;

    @BindView(R.id.play_country_ed)
    EditText country_ed;

    @BindView(R.id.play_position_ed)
    EditText position_ed;

    @BindView(R.id.play_score_ed)
     EditText score_ed;

    @BindView(R.id.play_successRate_ed)
     EditText successRate_ed;

    @BindView(R.id.player_save_bt)
    Button save_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        ButterKnife.bind(this);

        save_bt.setOnClickListener(v -> {
            if (TextUtils.isEmpty(name_ed.getText().toString()) || TextUtils.isEmpty(country_ed.getText().toString()) ||
                    TextUtils.isEmpty(position_ed.getText().toString()) || TextUtils.isEmpty(score_ed.getText().toString()) || TextUtils.isEmpty(successRate_ed.getText().toString())) {
                Toast.makeText(this, "请填写完整再保存", Toast.LENGTH_SHORT).show();
                return;
            }
            int[] score=new int[5];
            loadScore(score);
            String[]rates;
            rates=successRate_ed.getText().toString().split("\\s+");
            member=new MemberData(name_ed.getText().toString(),position_ed.getText().toString(),score,rates,country_ed.getText().toString());
            Intent intent=new Intent();
            intent.putExtra(EXERA,member);
            setResult(RESULTCODE,intent);
            finish();

        });


    }

    public void loadScore(int []score){
        String[] scores=score_ed.getText().toString().split("\\s+");

        int i=0;
        for (String s:scores) {
            score[i++]=Integer.parseInt(s);
        }
        while (i<5)
            score[i++]=0;

    }




}




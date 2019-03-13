package com.example.volleyball;

import android.content.Intent;
import android.media.MediaMetadata;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.volleyball.data.MemberData;
import com.example.volleyball.data.VolleyballTAG;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StatisticsScoreActivity extends AppCompatActivity {


    @BindView(R.id.statistics_name)
    TextView statisticsName;
    @BindView(R.id.text_statistics_1)
    TextView textStatistics1;
    @BindView(R.id.statistics_plus_1)
    Button statisticsPlus1;
    @BindView(R.id.statistics_minus_1)
    Button statisticsMinus1;
    @BindView(R.id.statistics_reset_1)
    Button statisticsReset1;
    @BindView(R.id.statistics_score_1)
    TextView statisticsScore1;
    @BindView(R.id.line_statistics_1)
    LinearLayout lineStatistics1;
    @BindView(R.id.text_statistics_2)
    TextView textStatistics2;
    @BindView(R.id.statistics_plus_2)
    Button statisticsPlus2;
    @BindView(R.id.statistics_minus_2)
    Button statisticsMinus2;
    @BindView(R.id.statistics_reset_2)
    Button statisticsReset2;
    @BindView(R.id.statistics_score_2)
    TextView statisticsScore2;
    @BindView(R.id.line_statistics_2)
    LinearLayout lineStatistics2;
    @BindView(R.id.text_statistics_3)
    TextView textStatistics3;
    @BindView(R.id.statistics_plus_3)
    Button statisticsPlus3;
    @BindView(R.id.statistics_minus_3)
    Button statisticsMinus3;
    @BindView(R.id.statistics_reset_3)
    Button statisticsReset3;
    @BindView(R.id.statistics_score_3)
    TextView statisticsScore3;
    @BindView(R.id.line_statistics_3)
    LinearLayout lineStatistics3;
    @BindView(R.id.text_statistics_4)
    TextView textStatistics4;
    @BindView(R.id.statistics_plus_4)
    Button statisticsPlus4;
    @BindView(R.id.statistics_minus_4)
    Button statisticsMinus4;
    @BindView(R.id.statistics_reset_4)
    Button statisticsReset4;
    @BindView(R.id.statistics_score_4)
    TextView statisticsScore4;
    @BindView(R.id.line_statistics_4)
    LinearLayout lineStatistics4;

    private MemberData memberData;
    String []rate;
    public static final String EXTRASERIA="SerializableExtra";
    float[] scores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        ButterKnife.bind(this);

        memberData=(MemberData) getIntent().getSerializableExtra(EXTRASERIA);
        statisticsName.setText(memberData.getName());

        DecimalFormat decimalFormat=new DecimalFormat("0.00");
        if (memberData.getStatistics()==null)
            scores=new float[8];
        else {
            scores = memberData.getStatistics();
            StringBuilder sb=new StringBuilder();
            sb.append((int)scores[0])
                    .append('/')
                    .append((int)scores[1])
                    .append("  ")
                    .append(decimalFormat.format( scores[1]/scores[0]));
            statisticsScore1.setText(sb.toString());

             sb=new StringBuilder();
            sb.append((int)scores[2])
                    .append('/')
                    .append((int)scores[3])
                    .append("  ")
                    .append(decimalFormat.format( scores[3]/scores[2]));
            statisticsScore2.setText(sb.toString());
            sb=new StringBuilder();
            sb.append((int)scores[4])
                    .append('/')
                    .append((int)scores[5])
                    .append("  ")
                    .append( decimalFormat.format( scores[5]/scores[4]));
            statisticsScore3.setText(sb.toString());
            sb=new StringBuilder();
            sb.append((int)scores[6])
                    .append('/')
                    .append((int)scores[7])
                    .append("  ")
                    .append(  decimalFormat.format( scores[7]/scores[6]));
            statisticsScore4.setText(sb.toString());
        }
        if (memberData.getSuccessRate().length==5){
            rate=memberData.getSuccessRate();
        }
        else
            rate=new String[5];




        statisticsPlus1.setOnClickListener(v -> {
            scores[0]++;
            scores[1]++;
            StringBuilder sb=new StringBuilder();
            sb.append((int)scores[0])
                    .append('/')
                    .append((int)scores[1])
                    .append("  ")
                    .append(decimalFormat.format( scores[1]/scores[0]));
            statisticsScore1.setText(sb.toString());
            rate[0]=String.valueOf(decimalFormat.format(scores[1]/scores[0]));


        });
        statisticsMinus1.setOnClickListener(v->{
            scores[0]++;

            StringBuilder sb=new StringBuilder();
            sb.append((int)scores[0])
                    .append('/')
                    .append((int)scores[1])
                    .append("  ")
                    .append(decimalFormat.format( scores[1]/scores[0]));
            statisticsScore1.setText(sb.toString());
            rate[0]=String.valueOf(decimalFormat.format( scores[1]/scores[0]));


        });
        statisticsReset1.setOnClickListener(v -> {
            scores[0]=scores[1]= (float) 0;
            statisticsScore1.setText(String.valueOf(0));
            rate[0]=String.valueOf(0);
        });


        scores[2]=0;
        scores[3]=0;
        statisticsPlus2.setOnClickListener(v -> {
            scores[2]++;
            scores[3]++;
            StringBuilder sb=new StringBuilder();
            sb.append((int)scores[2])
                    .append('/')
                    .append((int)scores[3])
                    .append("  ")
                    .append(decimalFormat.format( scores[3]/scores[2]));
            statisticsScore2.setText(sb.toString());
            rate[1]=String.valueOf(decimalFormat.format( scores[3]/scores[2]));


        });
        statisticsMinus2.setOnClickListener(v->{
            scores[2]++;

            StringBuilder sb=new StringBuilder();
            sb.append((int)scores[2])
                    .append('/')
                    .append((int)scores[3])
                    .append("  ")
                    .append(decimalFormat.format( scores[3]/scores[2]));
            statisticsScore2.setText(sb.toString());
            rate[1]=String.valueOf(decimalFormat.format( scores[3]/scores[2]));


        });
        statisticsReset2.setOnClickListener(v -> {
            scores[2]=scores[3]= (float) 0;
            statisticsScore2.setText(String.valueOf(0));
            rate[1]=String.valueOf(0);
        });


        statisticsPlus3.setOnClickListener(v -> {
            scores[4]++;
            scores[5]++;
            StringBuilder sb=new StringBuilder();
            sb.append((int)scores[4])
                    .append('/')
                    .append((int)scores[5])
                    .append("  ")
                    .append( decimalFormat.format( scores[5]/scores[4]));
            statisticsScore3.setText(sb.toString());
            rate[2]=String.valueOf( decimalFormat.format( scores[5]/scores[4]));


        });
        statisticsMinus3.setOnClickListener(v->{
            scores[4]++;

            StringBuilder sb=new StringBuilder();
            sb.append((int)scores[4])
                    .append('/')
                    .append((int)scores[5])
                    .append("  ")
                    .append( decimalFormat.format( scores[5]/scores[4]));
            statisticsScore3.setText(sb.toString());
            rate[2]=String.valueOf( decimalFormat.format( scores[5]/scores[4]));


        });
        statisticsReset3.setOnClickListener(v -> {
            scores[4]=scores[5]= (float) 0;
            statisticsScore3.setText(String.valueOf(0));
            rate[2]=String.valueOf(0);
        });


        statisticsPlus4.setOnClickListener(v -> {
            scores[6]++;
            scores[7]++;
            StringBuilder sb=new StringBuilder();
            sb.append((int)scores[6])
                    .append('/')
                    .append((int)scores[7])
                    .append("  ")
                    .append(  decimalFormat.format( scores[7]/scores[6]));
            statisticsScore4.setText(sb.toString());
            rate[3]=String.valueOf(decimalFormat.format( scores[7]/scores[6]));


        });
        statisticsMinus4.setOnClickListener(v->{
            scores[6]++;

            StringBuilder sb=new StringBuilder();
            sb.append((int)scores[6])
                    .append('/')
                    .append((int)scores[7])
                    .append("  ")
                    .append( decimalFormat.format( scores[7]/scores[6]));
            statisticsScore4.setText(sb.toString());
            rate[3]=String.valueOf(decimalFormat.format( scores[7]/scores[6]));


        });
        statisticsReset4.setOnClickListener(v -> {
            scores[6]=scores[7]= (float) 0;
            statisticsScore4.setText(String.valueOf(0));
            rate[3]=String.valueOf(0);
        });

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i(VolleyballTAG.TAG, "onDestroy: ");

    }


    @Override
    protected void onStop(){
        Log.i("VOLLEYBALL", "onStop: ");
        super.onStop();


    }

    @Override
    public void onBackPressed() {
        Log.i(VolleyballTAG.TAG, "onBackPressed: ");
        Intent intent=new Intent();
        memberData.setSuccessRate(rate);
        memberData.setStatistics(scores);
        intent.putExtra("MEMBER",memberData);
        setResult(8, intent);

        super.onBackPressed();
    }

}

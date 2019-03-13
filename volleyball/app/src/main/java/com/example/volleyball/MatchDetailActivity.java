package com.example.volleyball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.volleyball.data.MatchData;
import com.example.volleyball.data.MatchDataLab;
import com.example.volleyball.data.MemberData;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MatchDetailActivity extends AppCompatActivity {

    @BindView(R.id.detail_country_1)
    TextView detail_country_1;
    @BindView(R.id.detail_country_2)
    TextView detail_country_2;
    @BindView(R.id.detail_score_1)
    TextView detail_score_1;
    @BindView(R.id.detail_score_2)
    TextView detail_score_2;
    @BindView(R.id.list_view)
    ListView listView;
    @BindView(R.id.spinner1)
    Spinner spinner;
    @BindView(R.id.change_bt)
    Button change_bt;
    private MatchData matchData;
    private int matchIndex=0;
    private BaseAdapter adapter;
    public static final String EXTRAINT="INDEX";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail);
        ButterKnife.bind(this);

        Intent intent=getIntent();
        int i=intent.getIntExtra(EXTRAINT,0);
        matchData= MatchDataLab.getInstance().getList().get(i);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                matchIndex=position;
                listView.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        initView();

        change_bt.setOnClickListener( v->{
            AddMatchActivity.StartActivity(this,i);


        });

    }

    public void initView(){
        int a,b;
        List<MemberData> members = new ArrayList<>();
        for (int i=0;matchData.getTeam()[0].getTeamMember()[i]!=null;i++)
            members.add(matchData.getTeam()[0].getTeamMember()[i]);
        for (int i=0;matchData.getTeam()[1].getTeamMember()[i]!=null;i++)
            members.add(matchData.getTeam()[1].getTeamMember()[i]);

        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        a=b=0;
        for (int i=0,j=5;i<5;i++,j++){
            sb1.append(matchData.getScore()[i]).append("  ");
            sb2.append(matchData.getScore()[j]).append("  ");
            if (matchData.getScore()[i]>matchData.getScore()[j])
                a++;
            else if (matchData.getScore()[i]<matchData.getScore()[j])
                b++;
        }
       detail_country_1.setText(matchData.getTeam()[0].getName()+"   "+a);
       detail_country_2.setText(matchData.getTeam()[1].getName()+"   "+b);
       detail_score_1.setText(sb1.toString());
       detail_score_2.setText(sb2.toString());
        adapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return members.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                LayoutInflater inflater = MatchDetailActivity.this.getLayoutInflater();
                View view;

                if (convertView==null) {
                    //因为getView()返回的对象，adapter会自动赋给ListView
                    view = inflater.inflate(R.layout.score_item, null);
                }else{
                    view=convertView;
                    Log.i("info","有缓存，不需要重新生成"+position);
                }
                int s=0;
                for (int i=0;i<members.get(position).getScore().length;i++)
                    s+=members.get(position).getScore()[i];
                TextView tv=view.findViewById(R.id.score_item_tv);
                StringBuilder sb=new StringBuilder();
                sb.append(members.get(position).getName())
                        .append("　  　　")
                        .append(s)
                        .append("　  　　")
                        .append(matchIndex>=members.get(position).getSuccessRate().length?"无":members.get(position).getSuccessRate()[matchIndex]);
                tv.setText(sb.toString());
                return view;
            }
        };
        listView.setAdapter(adapter);
    }




}

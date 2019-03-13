package com.example.volleyball;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.volleyball.adapter.PlayerRecycleAdapter;
import com.example.volleyball.data.MatchData;
import com.example.volleyball.data.MatchDataLab;
import com.example.volleyball.data.MemberData;
import com.example.volleyball.data.TeamData;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddMatchActivity extends AppCompatActivity {

    @BindView(R.id.detail_country_name_left)
    EditText mLeftCountry_ed;

    @BindView(R.id.detail_country_name_right)
    EditText mRightCountry_ed;

    @BindView(R.id.match_date_ed)
    EditText mDate_ed;

    @BindView(R.id.match_type_ed)
    EditText mType_ed;

    @BindView(R.id.detail_recycle_view)
    RecyclerView mRecycleView;

    @BindView(R.id.detail_add_bt)
    Button mAdd_bt;

    @BindView(R.id.detail_save_bt)
    Button mSave_bt;

    @BindView(R.id.score_up)
    EditText mScore1_ed;
    @BindView(R.id.score_down)
    EditText mScore2_ed;

    private MatchData matchData;
    private PlayerRecycleAdapter adapter;
    private final static int REQUEST=111;
    public static final int RESULTCODE=444;
    public static final String EXTRAINT="POSITION";
    int position=-1;

    public static void StartActivity(Context context,int position){
        Intent intent=new Intent(context,AddMatchActivity.class);
        intent.putExtra(EXTRAINT,position);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        ButterKnife.bind(this);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        adapter=new PlayerRecycleAdapter(this,new ArrayList<>());
        mRecycleView.setAdapter(adapter);

        Intent startIntent =getIntent();
        position=startIntent.getIntExtra(EXTRAINT,-1);
        initViewWithExtraData(position);

        mAdd_bt.setOnClickListener(v -> {
            Intent intent=new Intent(this,AddMemberActivity.class);
            startActivityForResult(intent,REQUEST);

        });

        mSave_bt.setOnClickListener(v -> {
            mSave_bt.setEnabled(false);
            if (!isComplete())
                return;
            TeamData team[]=new TeamData[2];
            team[0]=new TeamData(mLeftCountry_ed.getText().toString(),new MemberData[6]);
            team[1]=new TeamData(mRightCountry_ed.getText().toString(),new MemberData[6]);
            List<MemberData>list=adapter.getList();
            int a,b;
            a=b=0;
            for (int i=0;i<list.size();i++){
                MemberData member=list.get(i);
                if (team[0].getName().equals(member.getCountry())) {
                    if (a < 6)
                        team[0].getTeamMember()[a++] = member;
                }
                if (team[1].getName().equals(member.getCountry())){
                    if (b<6)
                        team[1].getTeamMember()[b++]=member;
                }
            }
            int score[]=new int[10];
            writeScoreInfo(score);
            matchData=new MatchData(team,score,"0",mDate_ed.getText().toString(),mType_ed.getText().toString());

            List<MatchData>temp=MatchDataLab.getInstance().getList();
            if (position!=-1){
                temp.set(position,matchData);
            }
            else
                temp.add(matchData);
            new Thread(()->{
                ObjectOutputStream out=null;
                try {
                    List<MatchData>list1=MatchDataLab.getInstance().getList();
                    out=new ObjectOutputStream(openFileOutput(MainActivity.FILENAME,MODE_PRIVATE));
                    out.writeObject(list1);

                    MainActivity.getHandle().post(()->{
                        mSave_bt.setEnabled(true);
                        Toast.makeText(getApplicationContext(),"保存成功",Toast.LENGTH_SHORT).show();
                        RxBus.getDefault().send(new UpdataEvent());
                        RxBus.getDefault().send(new UpdataMemberEvent());

                    });

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (out!=null) {
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    finish();
                }

            }).start();

        });

    }


    public void initViewWithExtraData(int position){
        if (position==-1)
            return;
        MatchData m=MatchDataLab.getInstance().getList().get(position);
        mLeftCountry_ed.setText(m.getTeam()[0].getName());
        mRightCountry_ed.setText(m.getTeam()[1].getName());
        mDate_ed.setText(m.getDate());

        StringBuilder sb=new StringBuilder();
        for (int i=0;i<m.getScore().length;i++){
            sb.append(m.getScore()[i]).append(" ");
            if (i==4){
                mScore1_ed.setText(sb.toString());
                sb=new StringBuilder();
            }

        }
        mScore2_ed.setText(sb.toString());
        mType_ed.setText(m.getName());
        List<MemberData>members=new ArrayList<>();
        for (int i=0;m.getTeam()[0].getTeamMember()[i]!=null;i++)
            members.add(m.getTeam()[0].getTeamMember()[i]);
        for (int i=0;m.getTeam()[1].getTeamMember()[i]!=null;i++)
            members.add(m.getTeam()[1].getTeamMember()[i]);
        adapter.addAllMember(members);




    }
    public boolean isComplete(){

        return !(TextUtils.isEmpty(mLeftCountry_ed.getText().toString())||TextUtils.isEmpty(mRightCountry_ed.getText().toString())||
                        TextUtils.isEmpty(mType_ed.getText().toString())||TextUtils.isEmpty(mDate_ed.getText().toString()));


    }

    public void writeScoreInfo(int [] score){
        String []score1=mScore1_ed.getText().toString().split("\\s+");
        String []score2=mScore2_ed.getText().toString().split("\\s+");
        int i=0;
        for (String s:score1) {
            score[i++]=Integer.parseInt(s);
        }
        while (i<5)
            score[i++]=0;
        for (String s:score2) {
            score[i++]=Integer.parseInt(s);
        }
        while (i<10)
            score[i++]=0;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data==null)
            return;

        if (resultCode==AddMemberActivity.RESULTCODE){
            if (requestCode==REQUEST){
                adapter.addMember((MemberData) data.getSerializableExtra(AddMemberActivity.EXERA));


            }

        }
    }


}

package com.example.volleyball;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.volleyball.adapter.ViewPagerAdapter;
import com.example.volleyball.data.MatchData;
import com.example.volleyball.data.MatchDataLab;
import com.example.volleyball.data.MemberData;
import com.example.volleyball.data.VolleyballTAG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MenuItem menuItem;
    private BottomNavigationView bottomNavigationView;
    private List<MatchData> mList;
    private static Handler mHandler=new Handler();
    private ViewPagerAdapter adapter;
    public static String FILENAME="matchData.dat";
    public static final String TAG= VolleyballTAG.TAG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FILENAME=getIntent().getStringExtra("filename");
        viewPager=findViewById(R.id.viewpager);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        BottomNavigationHelper.disableShiftMode(bottomNavigationView);
        loadDataFromFire();

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.item_match:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.item_count:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.item_strategy:
                                viewPager.setCurrentItem(2);
                                break;
                            case R.id.item_personal:
                                viewPager.setCurrentItem(3);
                                break;

                        }


                        return false;
                    }
                }

        );
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(i);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        setupViewPager(viewPager);

        RxBus.getDefault().toObservable(UpdataMemberEvent.class)
                .subscribe(updataMemberEvent -> {
                    MatchData matchData=MatchDataLab.getInstance().getLast();
                    List<MemberData>members=new ArrayList<>();
                    for (int i = 0; matchData.getTeam()[0].getTeamMember()[i] != null; i++)
                        members.add(matchData.getTeam()[0].getTeamMember()[i]);
                    for (int i = 0; matchData.getTeam()[1].getTeamMember()[i] != null; i++)
                        members.add(matchData.getTeam()[1].getTeamMember()[i]);
                    updataStatistics(members);

                });
    }
    public void setupViewPager(ViewPager viewPager){
        adapter=new ViewPagerAdapter(getSupportFragmentManager());
        String[] names={"比赛记录","实时统计","布置战术","个人中心"};
        if (adapter.getCount()==0)
            adapter.addFragment(new MatchFragment());

        adapter.addFragment(new StatisticsFragment());
        adapter.addFragment(new StrategyFragment());
        adapter.addFragment(BaseFragment.newInstance(names[3]));

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
    }


    public static Handler getHandle(){
        return mHandler;
    }
    public void loadDataFromFire(){
        if (MatchDataLab.getInstance().isHasUpload())
            return;
        MatchDataLab.getInstance().setHasUpload(true);
        mList= MatchDataLab.getInstance().getList();
        new Thread(()->{
            ObjectInputStream in = null;
            try {
                in=new ObjectInputStream(openFileInput(FILENAME));
                List<MatchData>list=(ArrayList<MatchData>) in.readObject();
                mList.addAll(list);
                Log.i(TAG, "loadDataFromFire: finash");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }finally {
                try {
                    if( in != null)
                        in.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            mHandler.post(()->{
                MatchFragment fragment;
                if (adapter.getCount()>0)
                    fragment=(MatchFragment) adapter.getItem(0);
                else {
                    fragment = new MatchFragment();
                    adapter.addFragment(fragment);
                }
                fragment.setAdapter(mList);
            });


        }).start();



    }


    int position=0;
    public void startStatisticsActivity(MemberData member,int position){
        Log.i(TAG, "startStatisticsActivity: start");
        this.position=position;
        Intent intent=new Intent(this,StatisticsScoreActivity.class);
        intent.putExtra(StatisticsScoreActivity.EXTRASERIA,member);
        startActivityForResult(intent,7);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i(TAG, "onActivityResult: get111111"+requestCode+"  "+resultCode);
        if (requestCode==7){

            if (resultCode==8){
                Log.i(TAG, "onActivityResult: get------------");
                ((StatisticsFragment)adapter.getItem(1)).changeData((MemberData) data.getSerializableExtra("MEMBER"),position);
            }
        }

    }

    public void updataStatistics(List<MemberData>m){
        ((StatisticsFragment)adapter.getItem(1)).addAll(m);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: call");
    }
}

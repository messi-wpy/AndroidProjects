package com.example.volleyball;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.volleyball.data.MatchData;
import com.example.volleyball.data.MatchDataLab;
import com.example.volleyball.data.MemberData;
import com.example.volleyball.data.TeamData;

import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class StatisticsFragment extends Fragment {


    private ListView listView;
    private MatchData matchData;
    private List<MemberData>members=new ArrayList<>();
    private BaseAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_statistics,container,false);
        listView=view.findViewById(R.id.statistics_listView);
        int size;
        if ((size=MatchDataLab.getInstance().getList().size())-1>=0)
            matchData= MatchDataLab.getInstance().getList().get(size-1);

        if (matchData!=null) {
            for (int i = 0; matchData.getTeam()[0].getTeamMember()[i] != null; i++)
                members.add(matchData.getTeam()[0].getTeamMember()[i]);
            for (int i = 0; matchData.getTeam()[1].getTeamMember()[i] != null; i++)
                members.add(matchData.getTeam()[1].getTeamMember()[i]);

        }
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
                View view;
                float[] scores=new float[2];
                scores[0]=0;
                scores[1]=0;
                if (convertView!=null)
                    view=convertView;
                else
                    view=getActivity().getLayoutInflater().inflate(R.layout.statistics_item,null);

                TextView name_tv=view.findViewById(R.id.statistics_tv);
                TextView rate=view.findViewById(R.id.rate);
                name_tv.setText(members.get(position).getName());
                StringBuilder sb=new StringBuilder();
                int i=0;
                while (i<members.get(position).getSuccessRate().length&&members.get(position).getSuccessRate()[i]!=null) {
                    sb.append(members.get(position).getSuccessRate()[i])
                            .append(" ");
                    i++;
                }
                rate.setText(sb.toString());
                view.setOnClickListener(v->{
                    ((MainActivity)getActivity()).startStatisticsActivity(members.get(position),position);
                });

                return view;
            }
        };
        listView.setAdapter(adapter);

        Button button=view.findViewById(R.id.finish);
        button.setOnClickListener(v -> {

            int a,b;
            a=b=0;
            for (int i=0;i<members.size();i++){
                MemberData member=members.get(i);
                if (matchData.getTeam()[0].getName().equals(member.getCountry())) {
                    if (a < 6)
                        matchData.getTeam()[0].getTeamMember()[a++] = member;
                }
                if (matchData.getTeam()[1].getName().equals(member.getCountry())){
                    if (b<6)
                        matchData.getTeam()[1].getTeamMember()[b++]=member;
                }
            }

            new Thread(()->{
                ObjectOutputStream out=null;
                try {
                    List<MatchData>list1=MatchDataLab.getInstance().getList();
                    list1.set(size-1,matchData);
                    out=new ObjectOutputStream(getActivity().openFileOutput(MainActivity.FILENAME,MODE_PRIVATE));
                    out.writeObject(list1);

                    MainActivity.getHandle().post(()->{
                        Toast.makeText(getActivity(),"保存成功",Toast.LENGTH_SHORT).show();
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
                }

            }).start();

        });
        return view;
    }

    public void changeData(MemberData m,int position){
        members.set(position,m);
        adapter.notifyDataSetChanged();

    }

    public void addAll(List<MemberData>m){
        members=m;
        adapter.notifyDataSetChanged();

    }

}

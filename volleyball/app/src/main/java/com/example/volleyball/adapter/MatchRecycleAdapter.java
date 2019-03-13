package com.example.volleyball.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.volleyball.MatchDetailActivity;
import com.example.volleyball.R;
import com.example.volleyball.data.MatchData;

import java.util.List;

public class MatchRecycleAdapter extends RecyclerView.Adapter<MatchRecycleAdapter.MatchItem> {


    private Context mContext;
    private List<MatchData>matchDataList;
    public MatchRecycleAdapter(Context context,List<MatchData> list){
        mContext=context;
        matchDataList=list;
    }
    @NonNull
    @Override
    public MatchItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        MatchItem item = new MatchItem(LayoutInflater.from(mContext)
                .inflate(R.layout.match_item_view,viewGroup,false));


        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull MatchItem matchItem, int i) {
        matchItem.bind(matchDataList.get(i),i);
    }

    @Override
    public int getItemCount() {
        return matchDataList.size();
    }

    public void addItem(MatchData data){
        // FIXME: 19-3-3
        matchDataList.add(data);

        notifyItemInserted(matchDataList.size()-1);
    }
    public void updataUi(){
        notifyDataSetChanged();

    }

    class MatchItem extends RecyclerView.ViewHolder{

        private TextView matchName_tv;
        private TextView countryLeft_tv;
        private TextView countryRight_tv;
        private TextView scoreLeft_tv;
        private TextView scoreRight_tv;

        private int position;
        public MatchItem(@NonNull View itemView) {
            super(itemView);

            matchName_tv=itemView.findViewById(R.id.item_matchName);
            countryLeft_tv=itemView.findViewById(R.id.country_name_left);
            countryRight_tv=itemView.findViewById(R.id.country_name_right);
            scoreLeft_tv=itemView.findViewById(R.id.country_score_left);
            scoreRight_tv=itemView.findViewById(R.id.country_score_right);
            itemView.setOnClickListener(v -> {
                Intent intent=new Intent(mContext, MatchDetailActivity.class);
                intent.putExtra(MatchDetailActivity.EXTRAINT,position);
                mContext.startActivity(intent);

            });

        }

        public void bind(MatchData matchData,int p){
            position=p;
            matchName_tv.setText(matchData.getName());
            countryLeft_tv.setText(matchData.getTeam()[0].getName());
            countryRight_tv.setText(matchData.getTeam()[1].getName());
            int a,b;
            a=b=0;
            for (int i=0,j=5;i<5;i++,j++){
                if (matchData.getScore()[i]>matchData.getScore()[j])
                    a++;
                else if (matchData.getScore()[i]<matchData.getScore()[j])
                    b++;
            }
            scoreLeft_tv.setText(String.valueOf(a));
            scoreRight_tv.setText(String.valueOf(b));

        }


    }
}
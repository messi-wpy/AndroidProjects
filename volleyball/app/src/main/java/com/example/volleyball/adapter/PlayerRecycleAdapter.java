package com.example.volleyball.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.volleyball.R;
import com.example.volleyball.data.MemberData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayerRecycleAdapter extends RecyclerView.Adapter<PlayerRecycleAdapter.PlayViewHolder> {
    private List<MemberData>list;
    private Context context;
    public PlayerRecycleAdapter(Context context,List<MemberData>list){
        this.context=context;
        this.list=list;
    }

    public List<MemberData> getList(){
        return list;
    }
    @NonNull
    @Override
    public PlayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PlayViewHolder holder=new PlayViewHolder(LayoutInflater.from(context).inflate(R.layout.member_item,parent,false));
        return holder;
    }

    public void addMember(MemberData member){
        list.add(member);
        notifyItemInserted(list.size());
    }

    public void addAllMember(List<MemberData>l){
        list.addAll(l);
        notifyDataSetChanged();


    }

    @Override
    public void onBindViewHolder(@NonNull PlayViewHolder holder, int position) {
        holder.bind(list.get(position));

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    class PlayViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.member_left)
        TextView player_tv1;

        @BindView(R.id.member_position)
        TextView position_tv2;

        public PlayViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
        public void bind(MemberData member){

            player_tv1.setText(member.getName());
            position_tv2.setText(member.getPosition());
        }
    }
}

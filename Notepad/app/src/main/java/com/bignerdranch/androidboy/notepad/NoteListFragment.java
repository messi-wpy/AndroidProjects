package com.bignerdranch.androidboy.notepad;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by androidboy on 18-1-6.
 */

public class NoteListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private NoteAdapter mAdapter;
    private FloatingActionButton mActionButton;

@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState){
    View view=inflater.inflate(R.layout.fragment_note_list,container,false);
    mRecyclerView=view.findViewById(R.id.note_recycle_view);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    updateUI();
    return view;
}

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActionButton=getActivity().findViewById(R.id.fab);
        mActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note note=new Note();
                NoteLab.get(getActivity()).addNote(note);
                Intent intent=NoteActivity.newIntent(getActivity(),note.getUUID());
                startActivity(intent);

            }
        });
    }
        private class NoteHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textTitle;
        private TextView textDate;
        private Note mNote;


        public NoteHolder(LayoutInflater inflater,ViewGroup parent){
            super(inflater.inflate(R.layout.not_item_list,parent,false));
            itemView.setOnClickListener(this);
            textTitle=itemView.findViewById(R.id.note_title);
            textDate=itemView.findViewById(R.id.note_date);
        }

        public void onClick(View view){
            Intent intent=NoteActivity.newIntent(getActivity(),mNote.getUUID());
            startActivity(intent);
        }

        public void bind(Note note){
            mNote=note;
            textTitle.setText(mNote.getTitle());
            textDate.setText(mNote.getDate().toString());
        }
    }

    private class NoteAdapter extends RecyclerView.Adapter<NoteHolder>{
        private List<Note>mNotes;

       public NoteAdapter(List<Note>notes){
           mNotes=notes;
       }

        @Override
        public NoteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater=LayoutInflater.from(getActivity());
            return new NoteHolder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(NoteHolder holder, int position) {
                Note note=mNotes.get(position);
                holder.bind(note);
        }

        @Override
        public int getItemCount() {
            return mNotes.size();
        }
    }

    public void updateUI(){
        NoteLab noteLab=NoteLab.get(getActivity());
        List<Note>notes=noteLab.getNotes();

        if (mAdapter==null){
        mAdapter=new NoteAdapter(notes);
        mRecyclerView.setAdapter(mAdapter);
    }
    else {
            mAdapter.notifyDataSetChanged();
        }
    }

    public void onResume(){
        super.onResume();
        updateUI();
    }
}

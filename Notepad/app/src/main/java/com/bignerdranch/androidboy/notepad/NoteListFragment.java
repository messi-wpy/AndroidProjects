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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by androidboy on 18-1-6.
 * note列表的fragment
 */

public class NoteListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private NoteAdapter mAdapter;
    private FloatingActionButton mActionButton;//note界面的悬浮添加按钮
    private CheckBox mCheckBox;
    private LinearLayout linearLayout;
    private int multiply;
    private Button mdeleteButton;
    private List<Note> deleteNote = new ArrayList<>();
    private Button mcancelButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);
        mRecyclerView = view.findViewById(R.id.note_recycle_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        linearLayout = view.findViewById(R.id.linearLayout);
        mdeleteButton = view.findViewById(R.id.bt_delete);
        mdeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < deleteNote.size(); i++) {
                    NoteLab noteLab = NoteLab.get(getActivity());
                    noteLab.deletenote(deleteNote.get(i));
                }

                updateUI();
                mActionButton.setVisibility(View.VISIBLE);
            }

        });
        mcancelButton = view.findViewById(R.id.bt_cancel);
        mcancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteNote = new ArrayList<>();
                updateUI();
                mActionButton.setVisibility(View.VISIBLE);
            }
        });
        updateUI();
        return view;
    }

    //启动悬浮添加按钮
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActionButton = getActivity().findViewById(R.id.fab);
        mActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note note = new Note();
                NoteLab.get(getActivity()).addNote(note);
                Intent intent = NoteActivity.newIntent(getActivity(), note.getUUID());
                startActivity(intent);

            }
        });
    }

    //更新视图，使每次更改note后list视图能得到更新
    //也是在这里建立集合，供recycleview使用
    public void updateUI() {
        NoteLab noteLab = NoteLab.get(getActivity());
        List<Note> notes = noteLab.getNotes();
        multiply = 0;
        linearLayout.setVisibility(View.INVISIBLE);
        if (mAdapter == null) {
            mAdapter = new NoteAdapter(notes);
            //为内部类建立集合数据

        } else {
            mAdapter.setNotes(notes);
            mAdapter.notifyDataSetChanged();
        }
        mRecyclerView.setAdapter(mAdapter);
        // Log.d("d","666");
    }

    //防止悬浮窗口，界面不完全可视等意外退出，保存数据
    public void onResume() {
        super.onResume();
        updateUI();
    }


    //实现recycle的第一个内部类，承担view
    private class NoteHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textTitle;
        private TextView textDate;
        private Note mNote;

        public void bind(Note note) {
            mNote = note;
            textTitle.setText(mNote.getTitle());
            textDate.setText(mNote.getDate().toString());
        }

        //重载，更新视图出现checkbox
        public NoteHolder(LayoutInflater inflater, ViewGroup parent, int a) {
            super(inflater.inflate(R.layout.not_item_list, parent, false));
            itemView.setOnClickListener(this);
            mCheckBox = (CheckBox) itemView.findViewById(R.id.cb_select);
            textTitle = itemView.findViewById(R.id.note_title);
            textDate = itemView.findViewById(R.id.note_date);
            mCheckBox.setVisibility(View.VISIBLE);
            mCheckBox.setChecked(false);
            mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    deleteNote.add(mNote);
                    //Toast.makeText(getActivity(),"6666",Toast.LENGTH_SHORT).show();

                    // Log.d("d","666");
                }
            });
            mActionButton.setVisibility(View.INVISIBLE);

        }

        public NoteHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.not_item_list, parent, false));
            itemView.setOnClickListener(this);
            mCheckBox = (CheckBox) itemView.findViewById(R.id.cb_select);

            textTitle = itemView.findViewById(R.id.note_title);
            textDate = itemView.findViewById(R.id.note_date);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    multiply = 111;
                    linearLayout.setVisibility(View.VISIBLE);
                    mRecyclerView.setAdapter(mAdapter);

                    return true;
                }
            });

        }

        public void onClick(View view) {
            Intent intent = NoteActivity.newIntent(getActivity(), mNote.getUUID());
            startActivity(intent);

        }

        //viewholder的方法负责处理数据

    }

    //recycle的第二个内部类
    private class NoteAdapter extends RecyclerView.Adapter<NoteHolder> {
        private List<Note> mNotes;


        public NoteAdapter(List<Note> notes) {
            mNotes = notes;
        }

        @Override
        public NoteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            if (multiply == 111) {
                return new NoteHolder(layoutInflater, parent, 1);
            } else
                return new NoteHolder(layoutInflater, parent);
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public void onBindViewHolder(NoteHolder holder, int position) {
            Note note = mNotes.get(position);
            holder.bind(note);
        }

        @Override
        public int getItemCount() {
            return mNotes.size();
        }

        public void setNotes(List<Note> notes) {
            mNotes = notes;
        }
    }
}

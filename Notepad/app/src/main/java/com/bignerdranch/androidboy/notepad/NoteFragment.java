package com.bignerdranch.androidboy.notepad;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by androidboy on 18-1-6.
 */

public class NoteFragment extends Fragment {
    private EditText mEdtitle;
    private EditText mEdcontent;
    private Note mNote;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        UUID noteId = (UUID) getActivity().getIntent()
                .getSerializableExtra(NoteActivity.EXTRA_NOTE_ID);
          mNote=NoteLab.get(getActivity()).getNote(noteId);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_note,container,false);

        mEdcontent=view.findViewById(R.id.content_edit);
        mEdcontent.setText(mNote.getContent());
        mEdcontent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                  mNote.setContent(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mEdtitle=view.findViewById(R.id.title_edit);
        mEdtitle.setText(mNote.getTitle());
        mEdtitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                 mNote.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return view;
    }
    public void onPause(){
        super.onPause();

        NoteLab.get(getActivity()).updateNote(mNote);
    }

}

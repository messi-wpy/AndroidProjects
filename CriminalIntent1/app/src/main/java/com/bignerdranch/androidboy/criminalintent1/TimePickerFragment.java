package com.bignerdranch.androidboy.criminalintent1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * Created by androidboy on 18-1-13.
 */

public class TimePickerFragment extends DialogFragment {
    private TimePicker mTimePicker;
    public static final String EXTRA_TIME="time";
    private static final String ARG_TIME="com.bignerdranch.android.criminalintent.time";
    private static final String ARG_CRIMEID="com.bignerdranch.android.criminalintent.crimeid";
    public static final int RESULTCODE2=21212121;

    public static TimePickerFragment newInstance(Date date, UUID crimeId){
        Bundle bundle=new Bundle();
        bundle.putSerializable(ARG_TIME,date);
        bundle.putSerializable(ARG_CRIMEID,crimeId);
        TimePickerFragment fragment=new TimePickerFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
          Date date=(Date)getArguments().getSerializable(ARG_TIME);
         final Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        View v= LayoutInflater.from(getActivity()).inflate(R.layout.dialog_time,null);
        mTimePicker=v.findViewById(R.id.time_picker);
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle("time")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int year=calendar.get(Calendar.YEAR);
                        int month=calendar.get(Calendar.MONTH);
                        int day=calendar.get(Calendar.DAY_OF_MONTH);
                        int hour=mTimePicker.getCurrentHour();
                        int minus=mTimePicker.getCurrentMinute();
                        Date date1=new GregorianCalendar(year,month,day,hour,minus).getTime();
                        UUID crimeId=(UUID)getArguments().getSerializable(ARG_CRIMEID);
                        Crime crime=CrimeLab.get(getActivity()).getCrime(crimeId);
                        crime.setDate(date1);
                        sendResult(RESULTCODE2,date1);
                    }
                }).create();


    }

    public void sendResult(int resultCode,Date date){
        if(getTargetFragment()==null){
            return;

        }
        Intent intent=new Intent();
        intent.putExtra(EXTRA_TIME,date);
        getTargetFragment().onActivityResult(getTargetRequestCode(),resultCode,intent);
    }
}

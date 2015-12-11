package com.example.alberto.criminalintent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Alberto on 12/10/15.
 */
public class TimePickerFragment extends DialogFragment {

    private static final String ARG_TIME = "argTime";
    public static final String EXTRA_TIME = "com.example.alberto.criminalintent.extra_time";

    private TimePicker mTimePicker;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        final Date date = (Date) getArguments().getSerializable(ARG_TIME);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hours = calendar.get(Calendar.HOUR);
        int minutes = calendar.get(Calendar.MINUTE);
        int amOrPm = calendar.get(Calendar.AM_PM);

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_time, null);
        //Init timePicker
        mTimePicker = (TimePicker) v.findViewById(R.id.dialog_time_time_picker);
        mTimePicker.setCurrentHour(hours);
        mTimePicker.setCurrentMinute(minutes);
        mTimePicker.setEnabled(true);
        mTimePicker.setIs24HourView(false);

        return new AlertDialog.Builder(getActivity())
                .setTitle("Time of the crime")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Date time = new Date();
                        time.setHours(mTimePicker.getCurrentHour());
                        time.setMinutes(mTimePicker.getCurrentMinute());
                        //Get time from pciker and send it using sendResut
                        sendResult(Activity.RESULT_OK, time);
                    }
                })
                .setView(v)
                .create();
    }

    public static TimePickerFragment newInstance(Date mTime) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_TIME, mTime);
        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void sendResult(int resultCode, Date date){
        Intent intent = new Intent();
        intent.putExtra(EXTRA_TIME, date);
        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }
}

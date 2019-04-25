package com.nci.sleeplab;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;

import java.util.Calendar;

public class TimePickerFragmentTwo extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        Calendar c2 = Calendar.getInstance();
        int hour2 = c2.get(Calendar.HOUR_OF_DAY);
        int minute2 = c2.get(Calendar.MINUTE);



        return new TimePickerDialog(getActivity(), (TimePickerDialog.OnTimeSetListener) getActivity(), hour2, minute2, DateFormat.is24HourFormat(getActivity()));
    }

}
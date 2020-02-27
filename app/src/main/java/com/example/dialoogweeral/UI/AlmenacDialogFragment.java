package com.example.dialoogweeral.UI;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.PriorityQueue;

public class AlmenacDialogFragment extends DialogFragment {

    private Calendar calendar;
    private Context mContext;
    private DatePickerDialog.OnDateSetListener dateSelectedListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            calendar.set(year, month, dayOfMonth);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy", Locale.getDefault() );
            String dateAsText = simpleDateFormat.format(calendar.getTime());

            Toast.makeText(getActivity(), dateAsText, Toast.LENGTH_LONG).show();
        }
    };


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            mContext = context;
        }catch (RuntimeException re){
            throw new RuntimeException("Can only be opened in an activity");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        calendar = Calendar.getInstance(Locale.getDefault());

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), dateSelectedListener, year, month, day);

    }
}

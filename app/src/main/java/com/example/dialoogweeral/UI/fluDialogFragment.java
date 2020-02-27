package com.example.dialoogweeral.UI;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class fluDialogFragment extends DialogFragment {

    String [] flues = {"Corona", "Sars", "Birdflu", "Fluflu"};
    private DialogInterface.OnClickListener itemSelectListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(getActivity(), "You caught " + flues[which], Toast.LENGTH_LONG).show() ;

        }
    };

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("What the flu ?");

        builder.setItems(flues, itemSelectListener);

        builder.setNegativeButton(android.R.string.cancel, null);



        return builder.create();
    }
}

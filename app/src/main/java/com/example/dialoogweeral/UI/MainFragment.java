package com.example.dialoogweeral.UI;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.dialoogweeral.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    private View.OnClickListener toastListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast toasty = Toast.makeText(getActivity(), "Druk ni op mij !", Toast.LENGTH_LONG);

            toasty.show();
        }

    };
    private View.OnClickListener simpleListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new SimpleDialoogFragment().show(getParentFragmentManager(), "SDF");

        }

    };
    private View.OnClickListener fluListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new fluDialogFragment().show(getParentFragmentManager(), "flu");

        }
    };
    private View.OnClickListener calendarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new AlmenacDialogFragment().show(getParentFragmentManager(), "Almenac");
        }
    };
    private View.OnClickListener snackListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Snackbar snackbar = Snackbar.make(rootView.findViewById(R.id.frag_container), "Woarum?", Snackbar.LENGTH_INDEFINITE);

            snackbar.setAction("Durum!", new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            snackbar.setActionTextColor(Color.GREEN);

            snackbar.show();

        }
    };
    private View rootView;


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Button btnToast = rootView.findViewById(R.id.btn_toast);
        btnToast.setOnClickListener(toastListener);

        Button btnSimple = rootView.findViewById(R.id.btn_Simple);
        btnSimple.setOnClickListener(simpleListener);

        Button btnFlu = rootView.findViewById(R.id.btnFlu);
        btnFlu.setOnClickListener(fluListener);

        Button btnAlmenac = rootView.findViewById(R.id.btn_almenac);
        btnAlmenac.setOnClickListener(calendarListener);

        FloatingActionButton fabSnackbar = rootView.findViewById(R.id.fab_snackbar);
        fabSnackbar.setOnClickListener(snackListener);

        return rootView;
    }

}

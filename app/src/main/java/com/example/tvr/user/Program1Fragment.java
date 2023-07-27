package com.example.tvr.user;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tvr.R;
import com.example.tvr.user.MasukProgramActivity;

public class Program1Fragment extends Fragment {

    private ImageView imageViewLogo;
    private TextView textViewAppName;
    private Button buttonJanuary, buttonFebruary, buttonMarch, buttonApril, buttonMay, buttonJune,
            buttonJuly, buttonAugust, buttonSeptember, buttonOctober, buttonNovember, buttonDecember;

    public Program1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_program1, container, false);

        // Initialize views
        imageViewLogo = view.findViewById(R.id.imageViewLogo);
        textViewAppName = view.findViewById(R.id.textViewAppName);
        buttonJanuary = view.findViewById(R.id.buttonJanuary);
        buttonFebruary = view.findViewById(R.id.buttonFebruary);
        buttonMarch = view.findViewById(R.id.buttonMarch);
        buttonApril = view.findViewById(R.id.buttonApril);
        buttonMay = view.findViewById(R.id.buttonMay);
        buttonJune = view.findViewById(R.id.buttonJune);
        buttonJuly = view.findViewById(R.id.buttonJuly);
        buttonAugust = view.findViewById(R.id.buttonAugust);
        buttonSeptember = view.findViewById(R.id.buttonSeptember);
        buttonOctober = view.findViewById(R.id.buttonOctober);
        buttonNovember = view.findViewById(R.id.buttonNovember);
        buttonDecember = view.findViewById(R.id.buttonDecember);

        // Set click listeners for the buttons
        buttonJanuary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("KOMISI I");
            }
        });
        buttonFebruary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("KOMISI II");
            }
        });
        buttonMarch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("KOMISI III");
            }
        });
        buttonApril.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("KOMISI IV");
            }
        });
        buttonMay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("KOMISI V");
            }
        });
        buttonJune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("KOMISI VI");
            }
        });
        buttonJuly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("KOMISI VII");
            }
        });
        buttonAugust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("KOMISI VIII");
            }
        });
        buttonSeptember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("KOMISI IX");
            }
        });
        buttonOctober.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("KOMISI X");
            }
        });
        buttonNovember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("KOMISI XI");
            }
        });
        buttonDecember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("PIMPINAN");
            }
        });

        return view;
    }

    private void openMasukProgramActivity(String month) {
        Intent intent = new Intent(getActivity(), MasukProgramActivity.class);
        intent.putExtra("program", "ALAT KELENGKAPAN DEWAN");
        intent.putExtra("subProgram", month);
        startActivity(intent);
    }
}

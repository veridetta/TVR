package com.example.tvr.user;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.tvr.R;

public class RadioFragment extends Fragment {

    private ImageView imageViewLogo;
    private TextView textViewAppName;
    private Button buttonJanuary, buttonFebruary, buttonMarch, buttonApril, buttonMay, buttonJune,
            buttonJuly, buttonAugust, buttonSeptember, buttonOctober, buttonNovember, buttonDecember,
            buttonSub11, buttonSub12;

    public RadioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_radio, container, false);

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
        buttonSub11 = view.findViewById(R.id.buttonSub11);
        buttonSub12 = view.findViewById(R.id.buttonSub12);
        // Set click listeners for the buttons
        buttonJanuary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("Warta Parlemen");
            }
        });
        buttonFebruary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("Peryataan Wakil Rakyat");
            }
        });
        buttonMarch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("Sudut dengar Parlemen");
            }
        });
        buttonApril.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("Profil Wakil Rakyat");
            }
        });
        buttonMay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("Agenda hari ini");
            }
        });
        buttonJune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("Warna - Warni Parlemen");
            }
        });
        buttonJuly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("Rapat Wakil Rakyat");
            }
        });
        buttonAugust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("Perspektif Para Pakar");
            }
        });
        buttonSeptember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("PSA / Iklan Layanan Masyarakat");
            }
        });
        buttonOctober.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("Lomba Orasi Bintang Parlemen");
            }
        });
        buttonNovember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("Warna Ramadhan");
            }
        });
        buttonDecember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("Report On The Spot");
            }
        });
        buttonSub11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("Kenverensi Pers");
            }
        });
        buttonSub12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMasukProgramActivity("Suara Rakyat");
            }
        });
        return view;
    }

    private void openMasukProgramActivity(String month) {
        Intent intent = new Intent(getActivity(), RadioActivity.class);
        intent.putExtra("program", "Radio");
        intent.putExtra("subProgram", month);
        startActivity(intent);
    }
}

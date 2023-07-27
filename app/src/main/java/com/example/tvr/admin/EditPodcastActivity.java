package com.example.tvr.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tvr.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class EditPodcastActivity extends AppCompatActivity {

    private ImageView imageViewLogo;
    private TextView textViewAppName;
    private EditText editTextTitle;
    private EditText editTextDescription;
    private Button buttonSave;

    private FirebaseFirestore firestore;
    private CollectionReference podcastRef;

    private String podcastId;
    private Spinner spinnerProgram;
    private Spinner spinnerSubProgram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_podcast);

        // Inisialisasi komponen UI
        imageViewLogo = findViewById(R.id.imageViewLogo);
        textViewAppName = findViewById(R.id.textViewAppName);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        buttonSave = findViewById(R.id.buttonSave);
        spinnerProgram = findViewById(R.id.spinnerProgram);
        spinnerSubProgram = findViewById(R.id.spinnerSubProgram);


        // Inisialisasi ArrayAdapter untuk spinner program
        ArrayAdapter<CharSequence> programAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.podcast_array,
                android.R.layout.simple_spinner_item
        );
        programAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set adapter untuk spinner program
        spinnerProgram.setAdapter(programAdapter);
        // Jika Program 1 dipilih, tampilkan spinner Sub Program dan sesuaikan adapter-nya
        spinnerSubProgram.setVisibility(View.VISIBLE);

        ArrayAdapter<CharSequence> subProgramAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.subpodcast_array,
                android.R.layout.simple_spinner_item
        );
        subProgramAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSubProgram.setAdapter(subProgramAdapter);

        // Inisialisasi Firestore
        firestore = FirebaseFirestore.getInstance();
        podcastRef = firestore.collection("podcasts");

        // Mengambil data podcast dari intent
        podcastId = getIntent().getStringExtra("podcastId");
        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        String program = getIntent().getStringExtra("program");
        String subProgram = getIntent().getStringExtra("subProgram");

        // Menampilkan data podcast pada form
        editTextTitle.setText(title);
        editTextDescription.setText(description);
        String[] programItems = getResources().getStringArray(R.array.podcast_array);
        spinnerProgram.setSelection(getIndex(programItems, program));
        String[] subprogramItems = getResources().getStringArray(R.array.subpodcast_array);
        spinnerSubProgram.setSelection(getIndex(subprogramItems, subProgram));
        // Mengatur OnClickListener untuk tombol "Simpan"
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mendapatkan nilai judul dan deskripsi podcast yang diubah
                String updatedTitle = editTextTitle.getText().toString();
                String updatedDescription = editTextDescription.getText().toString();

                // Mengupdate data podcast ke Firestore
                podcastRef.document(podcastId)
                        .update("title", updatedTitle, "description", updatedDescription)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                // Simpan perubahan berhasil
                                finish();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Simpan perubahan gagal
                                Toast.makeText(EditPodcastActivity.this, "Gagal menyimpan perubahan", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
    // Method to get the index of a value in an array
    private int getIndex(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return 0; // Default index if the value is not found in the array
    }
}

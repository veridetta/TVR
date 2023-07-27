package com.example.tvr.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.tvr.R;
import com.example.tvr.adapter.PodcastUserAdapter;
import com.example.tvr.model.Podcast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class RadioActivity extends AppCompatActivity {
    private RecyclerView recyclerViewPodcasts;
    private PodcastUserAdapter podcastUserAdapter;
    private List<Podcast> podcastList;
    private FirebaseFirestore firestore;
    private String selectedProgram,subProgram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        // Initialize Firestore
        firestore = FirebaseFirestore.getInstance();
        // Mengambil program yang dipilih dari intent
        selectedProgram = getIntent().getStringExtra("program");
        subProgram = getIntent().getStringExtra("subProgram");
        // Initialize RecyclerView
        recyclerViewPodcasts = findViewById(R.id.recyclerViewPrograms);
        //recyclerViewPodcasts.setLayoutManager(new LinearLayoutManager(getContext()));
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerViewPodcasts.setLayoutManager(layoutManager);

        // Initialize podcast list
        podcastList = new ArrayList<>();
        // Mendapatkan referensi koleksi "programs" dari Firestore

        // Membuat query untuk mengambil program berdasarkan program dan subprogram
        // Get reference to the "podcasts" collection from Firestore
        CollectionReference podcastsRef = firestore.collection("podcasts");
        Query query = podcastsRef.whereEqualTo("program", selectedProgram);

        // Retrieve podcast data based on the query
        query.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                // Get the list of podcast documents from the query result
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    // Create Podcast object from the document data
                    Podcast podcast = documentSnapshot.toObject(Podcast.class);
                    // Filter berdasarkan subprogram untuk Program Radio
                    if (selectedProgram.equals(podcast.getProgram()) && podcast.getSubProgram().equals(subProgram)) {
                        podcastList.add(podcast);
                    }
                }

                // Initialize and set the adapter for RecyclerView
                podcastUserAdapter = new PodcastUserAdapter(RadioActivity.this, podcastList);
                recyclerViewPodcasts.setAdapter(podcastUserAdapter);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // If failed to retrieve data from Firestore, display an error message
                Log.e("PodcastFragment", "Error getting podcasts", e);
            }
        });
    }
}
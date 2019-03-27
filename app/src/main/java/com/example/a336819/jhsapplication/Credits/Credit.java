package com.example.a336819.jhsapplication.Credits;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.a336819.jhsapplication.AddClasses.CreditInformation;
import com.example.a336819.jhsapplication.HOME.Home;
import com.example.a336819.jhsapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Credit extends AppCompatActivity {

    private static final String TAG = "Credit";
    private FirebaseAuth mAuth;
    private DatabaseReference myRef;
    private FirebaseDatabase mFirebaseDatabase;
    private String p1, p2, p3, p4, p5, p6;
     int math;
     final int mathmax = 3;
     int english;
     final int englishmax = 4;
     int science;
     final int sciencemax = 3;
     int elective;
     final int electivemax = 4;
    int language;
    final int languagemax = 2;
     boolean languagemet=false;
    int socialStudies;
    final int socialStudiesmax = 3;
    int fineArts;
    final int fineArtsmax = 2;
    int fitness;
    final int fitnessmax = 2;
    int CTE;
    final int CTEmax = 1;
    int CCS;
    ArrayList<String> credits;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credit_layout);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        myRef = mFirebaseDatabase.getReference("students");
        final String userID = user.getUid();
        credits = new ArrayList<>();
        ListView list = findViewById(R.id.classes);


        final DatabaseReference firebaseUser = FirebaseDatabase.getInstance().getReference();
        DatabaseReference reference = firebaseUser.child("students");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    CreditInformation a = new CreditInformation();
                    math = Integer.parseInt(dataSnapshot.child(userID).child("Credits").child("math").getValue(Long.class).toString());
                    credits.add("Math: " + math + "/" + mathmax);
                    english = Integer.parseInt(dataSnapshot.child(userID).child("Credits").child("english").getValue(Long.class).toString());
                    credits.add("English: " + english + "/" + englishmax);
                    science = Integer.parseInt(dataSnapshot.child(userID).child("Credits").child("science").getValue(Long.class).toString());
                    credits.add("Science: " + science + "/" + sciencemax);
                    elective = Integer.parseInt(dataSnapshot.child(userID).child("Credits").child("elective").getValue(Long.class).toString());
                    credits.add("Elective: " + elective + "/" + electivemax);
                    language = Integer.parseInt(dataSnapshot.child(userID).child("Credits").child("language").getValue(Long.class).toString());
                    credits.add("Language: " +  language + "/" +  languagemax);
                    socialStudies = Integer.parseInt(dataSnapshot.child(userID).child("Credits").child("socialStudies").getValue(Long.class).toString());
                    credits.add("Social Studies: " + socialStudies + "/" + socialStudiesmax);
                    fineArts = Integer.parseInt(dataSnapshot.child(userID).child("Credits").child("fineArts").getValue(Long.class).toString());
                    credits.add("Fine Arts: " + fineArts + "/" + fineArtsmax);
                    fitness = Integer.parseInt(dataSnapshot.child(userID).child("Credits").child("fitness").getValue(Long.class).toString());
                    credits.add("Fitness: " + fitness + "/" + fitnessmax);
                    CTE = Integer.parseInt(dataSnapshot.child(userID).child("Credits").child("cte").getValue(Long.class).toString());
                    credits.add("CTE: " + CTE + "/" + CTEmax);







            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        reference.addListenerForSingleValueEvent(eventListener);

        ArrayAdapter litvw = new ArrayAdapter(this, android.R.layout.simple_list_item_1, credits);
        list.setAdapter(litvw);





        Button cback = (Button) findViewById(R.id.credit_back);
        Button recom = findViewById(R.id.recommend);

        cback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Credit.this, Home.class);
                startActivity(i);
            }
        });

        recom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Credit.this, Recommend.class);
                startActivity(j);
            }
        });

    }
}

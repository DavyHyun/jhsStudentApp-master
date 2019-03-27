package com.example.a336819.jhsapplication.AddClasses;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.a336819.jhsapplication.Credits.Credit;
import com.example.a336819.jhsapplication.R;
import com.example.a336819.jhsapplication.InformationStore.UserInformation;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class AddClassesF extends AppCompatActivity {
    private static final String TAG = "AddClassesF";
    private FirebaseAuth mAuth;
    private DatabaseReference myRef;
    private FirebaseDatabase mFirebaseDatabase;
    private String grade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addclass_layout);

        ArrayList<String> listt = new ArrayList<>();
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        myRef = mFirebaseDatabase.getReference("students");
        assert user != null;
        final String userID = user.getUid();
        final String G;

        final AutoCompleteTextView c1 = (AutoCompleteTextView) findViewById(R.id.c1);
        final AutoCompleteTextView c2 = (AutoCompleteTextView) findViewById(R.id.c2);
        final AutoCompleteTextView c3 = (AutoCompleteTextView) findViewById(R.id.c3);
        final AutoCompleteTextView c4 = (AutoCompleteTextView) findViewById(R.id.c4);
        final AutoCompleteTextView c5 = (AutoCompleteTextView) findViewById(R.id.c5);
        final AutoCompleteTextView c6 = (AutoCompleteTextView) findViewById(R.id.c6);
        Button cont = (Button) findViewById(R.id.cont);

        InputStream is = getResources().openRawResource(R.raw.coursecatalog);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

        String line;
        int test = 0;
        try {
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                String name = values[1];
                listt.add(name);

            }
        } catch (IOException e) {

        }



        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, listt);
        c1.setAdapter(adapter);
        c2.setAdapter(adapter);
        c3.setAdapter(adapter);
        c4.setAdapter(adapter);
        c5.setAdapter(adapter);
        c6.setAdapter(adapter);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                UserInformation uInfo = new UserInformation();
                uInfo.setstudentGrade(dataSnapshot.child(userID).getValue(UserInformation.class).getstudentGrade());
                grade = uInfo.getstudentGrade();

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());

            }
        });


        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p1 = c1.getText().toString().trim();
                String p2 = c2.getText().toString().trim();
                String p3 = c3.getText().toString().trim();
                String p4 = c4.getText().toString().trim();
                String p5 = c5.getText().toString().trim();
                String p6 = c6.getText().toString().trim();
                String[] p = {p1, p2, p3, p4, p5, p6};
                FirebaseUser user = mAuth.getCurrentUser();
                String useID = user.getUid();
                myRef.child(useID).child("classesAdded").setValue("yes");

                int math = 1;
                int english = 1;
                int science = 1;
                int elective = 2;
                int language = 1;
                boolean languagemet=false;
                int socialStudies = 0;
                int fineArts=0;
                int fitness=1;
                int CTE = 1;
                int CCS = 0;

               // for (int i=0; i<6; i++) {

                  //  InputStream is = getResources().openRawResource(R.raw.coursecatalog);
                 //   BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                   //String[] classline=new String[13];
                    //String line;
                    //int test = 0;
                    //try {
                      //  while ((line = reader.readLine()) != null) {
                        //    String[] values = line.split(",");
                          //  classline=values;
                            //String name = values[1];
                            //if (p[i].equals(name)) {
                             //   break;
                            //} else {

                // }

                //        }
                 //   } catch (IOException e) {

//                    }
  //                  Log.d(TAG, classline.toString());
    //                    int z=0;
      //              for (int j=3; j<classline.length; j++) {
//
  //                      ArrayList<Integer> pos = new ArrayList<>();
    //                    if (classline[j].equals("X") || classline[j].equals("Elective")) {
      //                      pos.add(j);
        //                } else if (classline[j].equals("WL")) {
          //                  language++;
            //                if (language >= 2) {
              //                  languagemet = true;
                //            }
                  //      }
//

  //                      if (pos.indexOf(z)==3) {
    //                        if(CTE<1) {
//
  //                              CTE++;
    //                        }
      //                  } else if (pos.indexOf(z)==4) {
        //                    if (english<4) {
//
  //                              english++;
    //                        }
      //                  } else if (pos.indexOf(z)==5) {
        //                    if (math<3) {
//
  //                              math++;
    //                        }
      //                  } else if (pos.indexOf(z)==6) {
        //                    if (fitness<2) {
          ///                      fitness++;
             //               }
               //         } else if (pos.indexOf(z)==7) {
                 //           if (science<3) {
//
  //                              science++;
    //                        }
      //                  } else if (pos.indexOf(z)==8) {
        //                    if (socialStudies<3) {
//
  //                              socialStudies++;
    //                        }
      //                  } else if (pos.indexOf(z)==9) {
        //                    if (fineArts<2) {
//
  //                              fineArts++;
    //                        }
      //                  } else if (pos.indexOf(z)==10) {
        //                    if (elective<4) {

 ///                               elective++;
    //                        }
      //                  }  else {
        //                    elective++;
          //              }
            //        }
//
  //              }

                //declare credits needed
                //look for credits in the classes
                //add how many credits achieved in the database

                CreditInformation CI = new CreditInformation(CTE, elective, english, fineArts, fitness ,language, math, science,socialStudies);
                myRef.child(useID).child("Credits").setValue(CI);

                if(grade.equals("FRESHMAN")) {
                    Intent i = new Intent(AddClassesF.this, Credit.class);
                    startActivity(i);
                } else {
                    Intent j = new Intent(AddClassesF.this, AddClassesS.class);
                    startActivity(j);
                }

            }
        });
    }

    }


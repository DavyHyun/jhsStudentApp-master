package com.example.a336819.jhsapplication.Credits;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.a336819.jhsapplication.HOME.Home;
import com.example.a336819.jhsapplication.R;

import java.util.ArrayList;

public class Recommend extends AppCompatActivity {

    ArrayList<String> recommended;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommend_layout);
        ListView l = findViewById(R.id.reco);
        Button bck = (Button) findViewById(R.id.reco_back);

        recommended = new ArrayList<>();
        recommended.add("Math: Pre-calc / Statistics");
        recommended.add("English: Ap Seminar / English 3");
        recommended.add("Science: AP Physics / AP Environmental Science");
        recommended.add("Language: Spanish 2");
        recommended.add("Social Studies: AP World History / World History");
        recommended.add("Fine Arts: Intro to Art / Ceramics");
        recommended.add("Fitness: Weight Training / Advanced Team Sports");
        recommended.add("CTE: Advanced Computer Science Topics");

        ArrayAdapter litv = new ArrayAdapter(this, android.R.layout.simple_list_item_1, recommended);
        l.setAdapter(litv);

        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Recommend.this, Home.class);
                startActivity(i);
            }
        });




    }
}

package com.example.practice10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    Button btnResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        btnResult = findViewById(R.id.btnResult);
        //region
        Intent intent = getIntent();
        String[] imageNames = intent.getStringArrayExtra("nameData");
        int[] voteResult = intent.getIntArrayExtra("voteData");
        int[] textViewIds = {R.id.tv1, R.id.tv2,R.id.tv3,R.id.tv4,R.id.tv5,R.id.tv6,R.id.tv7,R.id.tv8,R.id.tv9};
        int[] ratingBarIds = {R.id.rbar1,R.id.rbar2,R.id.rbar3,R.id.rbar4,R.id.rbar5,R.id.rbar6,R.id.rbar7,R.id.rbar8,R.id.rbar9};

        TextView[] textViews = new TextView[imageNames.length];
        RatingBar[] ratingBars = new RatingBar[voteResult.length];
        //endregion
        for(int i = 0; i < textViewIds.length; i++){
            textViews[i] = findViewById(textViewIds[i]);
            ratingBars[i] = findViewById(ratingBarIds[i]);
        }

        for(int i = 0; i < voteResult.length; i++){
            textViews[i].setText(imageNames[i]);
            ratingBars[i].setRating(voteResult[i]);

        }

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

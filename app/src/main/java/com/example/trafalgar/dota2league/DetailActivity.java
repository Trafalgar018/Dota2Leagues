package com.example.trafalgar.dota2league;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


import com.example.trafalgar.dota2league.model.League;

public class DetailActivity extends AppCompatActivity {

    TextView mTextViewLeagueName;
    TextView mTextViewLeagueTier;
    TextView mTextViewLeagueBanner;
    TextView mTextViewLeagueTicket;

    League league;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        league = new League();

        mTextViewLeagueName = findViewById(R.id.label_name_text_view);
        mTextViewLeagueTier = findViewById(R.id.tier_text_view);
        mTextViewLeagueBanner = findViewById(R.id.banner_text_view);
        mTextViewLeagueTicket = findViewById(R.id.ticket_text_view);

        Intent detailIntent = DetailActivity.this.getIntent();

        if(detailIntent.hasExtra("league")){
            league = (League)detailIntent.getSerializableExtra("league");
        }

        mTextViewLeagueName.setText(league.getName());
        mTextViewLeagueTier.setText(league.getTier());
        mTextViewLeagueBanner.setText(league.getBanner());
        mTextViewLeagueTicket.setText(league.getTicket());

    }


}
package com.ece.stm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class MissionActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button changeID;
    private Button goMission;
    private ArrayList<String> missions; //db
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_mission);

        changeID = findViewById(R.id.change_id);

        changeID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MissionActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        spinner = findViewById(R.id.missionSelect);
        goMission = findViewById(R.id.goMissionButton);

        //db
        missions = new ArrayList<>();
        missions.add("Çiftlik1");
        missions.add("Çiftlik2");

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, missions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        goMission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MissionActivity.this, FormActivity.class);
                startActivity(i);
            }
        });
    }
}
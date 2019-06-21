package com.ece.stm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton;
    private EditText id_input;
    static String ID = "1234"; //db

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_login);


        if(connectionCheck()==true){
            Toast.makeText(LoginActivity.this, getString(R.string.connection_check_ok) ,Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(LoginActivity.this, getString(R.string.connection_check_error) ,Toast.LENGTH_LONG).show();
        }

        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id_input=findViewById(R.id.idInput);
                String id_str = id_input.getText().toString();
                if(connectionCheck()==true){
                    if(id_str.equals(ID)){
                        Intent i = new Intent(LoginActivity.this, MissionActivity.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(LoginActivity.this, getString(R.string.id_match_error) ,Toast.LENGTH_LONG).show();
                        id_input.setText("");
                    }
                }
                else{
                    Toast.makeText(LoginActivity.this, getString(R.string.connection_check_error) ,Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    private boolean connectionCheck() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}

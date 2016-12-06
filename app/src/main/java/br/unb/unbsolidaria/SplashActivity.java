package br.unb.unbsolidaria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.unb.unbsolidaria.persistency.Database;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Load local database contents
        Database.getInstance().loadLocalState(getApplicationContext());
    }

    @Override
    protected void onResume (){
        super.onResume();

        //Start LoginActivity
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}

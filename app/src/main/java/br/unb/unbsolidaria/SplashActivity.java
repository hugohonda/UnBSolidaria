package br.unb.unbsolidaria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import br.unb.unbsolidaria.persistency.Database;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Apenas para ver a splash
        // Retirar
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Retirar

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

package br.unb.unbsolidaria;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class OportunidadeAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oportunidade);
        Toolbar toolbar = (Toolbar) findViewById(R.id.oportunidateToolbar);
        setSupportActionBar(toolbar);
        final int vagas = 1;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Oportunidade");

        TextView Titulo = (TextView) findViewById(R.id.oportunidadeActivity_Titulo);
        Titulo.setText("Professor de História do Brasil");
        Titulo.setGravity(Gravity.CENTER);

        TextView Descricao = (TextView) findViewById(R.id.oportunidadeActivity_desc);
        Descricao.setText("Precisamos de professor de história no colégio A para alunos do 3º ano do Ensino Médio. Os conteúdos são: \nA; \nB.\nQuem puder, entre em contato.");

        TextView Organizacao = (TextView) findViewById(R.id.oportunidadeActivity_org);
        Organizacao.setText("Organização: " + "SEE-DF");

        TextView Localizacao = (TextView) findViewById(R.id.oportunidadeActivity_loc);
        Localizacao.setText("Local: " + "Próximo a UnB");

        TextView Vagas = (TextView) findViewById(R.id.oportunidadeActivity_vagas);
        Vagas.setText("Vagas: " + vagas);

        final Button button = (Button) findViewById(R.id.oportunidadeActivity_actionConfirm);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO: Adicionar algum mecanismo para gerenciar eventos em que o usuário se candidatou (Activity, pop-up,...)
                if (vagas > 0) {
                    Snackbar.make(findViewById(android.R.id.content), "Participação Confirmada!", Snackbar.LENGTH_SHORT).show();
                    return;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_oportunidade, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.oportunidade_share:
                Snackbar.make(findViewById(android.R.id.content), "Compartilhar Oportunidade", Snackbar.LENGTH_SHORT).show();
                return true;
            default:
                // If we got here, the user's action was not recognized.
                return super.onOptionsItemSelected(item);
        }
    }
}

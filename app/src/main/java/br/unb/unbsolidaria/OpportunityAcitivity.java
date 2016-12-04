package br.unb.unbsolidaria;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.unb.unbsolidaria.entities.Opportunity;
import br.unb.unbsolidaria.extras.ImageHelper;
import br.unb.unbsolidaria.persistency.Database;


public class OpportunityAcitivity extends AppCompatActivity {

    private float scale;
    private int width;
    private int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opportunity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.oportunidateToolbar);
        setSupportActionBar(toolbar);
        final int positions = 1;

        int id = getIntent().getIntExtra("id", 0);

        Database bd = Database.getInstance();
        Opportunity opportunity = bd.getOpportunitie(id);

        TextView title = (TextView) findViewById(R.id.tv_title);
        ImageView logo = (ImageView) findViewById(R.id.iv_logo);
        TextView description = (TextView) findViewById(R.id.tv_description);
        TextView org = (TextView) findViewById(R.id.tv_org);
        TextView local = (TextView) findViewById(R.id.tv_local);
        TextView vagas = (TextView) findViewById(R.id.tv_vaga);
        TextView start = (TextView) findViewById(R.id.tv_start);
        TextView end = (TextView) findViewById(R.id.tv_end);


        title.setText(opportunity.getTitle());
        description.setText( getString(R.string.ov_description, opportunity.getDescription()) );
        org.setText( getString(R.string.ov_org, opportunity.getOrganization().getCommercialName()) );
        local.setText( getString(R.string.ov_local, opportunity.getLocal()) );
        vagas.setText( getString(R.string.ov_vagas, opportunity.getVagas()) );

        start.setText( getString(R.string.ov_dateStart, opportunity.getFormattedDate(Opportunity.oDate.start)) );
        end.setText( getString(R.string.ov_dateEnd, opportunity.getFormattedDate(Opportunity.oDate.end)) );

        scale = this.getResources().getDisplayMetrics().density;
        width = this.getResources().getDisplayMetrics().widthPixels - (int) (14 * scale + 0.5f);
        height = (width / 16) * 9;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            logo.setImageResource(opportunity.getPhoto());
        } else {
            Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), opportunity.getPhoto());
            bitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);

            bitmap = ImageHelper.getRoundedCornerBitmap(this, bitmap, 4, width, height, false, false, true, true);
            logo.setImageBitmap(bitmap);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Opportunity");



        final Button button = (Button) findViewById(R.id.oportunidadeActivity_actionConfirm);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO: Adicionar algum mecanismo para gerenciar eventos em que o usuário se candidatou (Activity, pop-up,...)
                if (positions > 0) {
                    Snackbar.make(findViewById(android.R.id.content), "Participação Confirmada!", Snackbar.LENGTH_SHORT).show();
                    return;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_opportunity, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.oportunidade_share:
                Snackbar.make(findViewById(android.R.id.content), "Compartilhar Opportunity", Snackbar.LENGTH_SHORT).show();
                return true;
            case android.R.id.home:
                this.finish();
                return true;
            default:
                // If we got here, the user's action was not recognized.
                return super.onOptionsItemSelected(item);
        }
    }
}

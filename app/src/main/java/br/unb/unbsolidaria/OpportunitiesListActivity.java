package br.unb.unbsolidaria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.unb.unbsolidaria.adapter.OpportunitiesAdapter;
import br.unb.unbsolidaria.entities.Opportunity;
import br.unb.unbsolidaria.persistency.Database;

public class OpportunitiesListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opportunities_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);


        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        List<Opportunity> mList = getSetOportinidadesList(10);

        mAdapter = new OpportunitiesAdapter(this, mList);
        mRecyclerView.setAdapter(mAdapter);
    }

    //TODO - chamar recycler view
    // ver aqui https://github.com/LucasRez/Recycler-View-Example/blob/master/app/src/main/java/com/lucasrez/recyclerviewproj/MainActivity.java

    public List<Opportunity> getSetOportinidadesList(int qtd) {
//        String[] title = new String[]{"Unb Solidaria", "EduBot", "Voluntarios"};
//        String[] description = new String[]{"Desenvolve aplicativos","Aulas de robotica", "Somos legais"};
//        String[] address = new String[]{"UNB","SG 11", "Asa Norte"};
//        int[] positions = new int[]{10,5,20};
//        int[] photos = new int[]{R.drawable.logo, R.drawable.logo, R.drawable.logo};
//        List<Opportunity> listAux = new ArrayList<>();
//
//        for(int i = 0; i < qtd; i++){
//            Opportunity o = new Opportunity(i, local[i % local.length], positions[i % positions.length], title[i % title.length],
//                    descricao[i % descricao.length],getCalendar("01/01/2017"), getCalendar("01/02/2017"), new Organization(), photos[i % photos.length]);
//            listAux.add(o);
//        }

        Database bd = Database.getInstance();
        List<Opportunity> listAux = bd.getOpportunities();
        return (listAux);
    }

    private Calendar getCalendar(String data) {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();

        try {
            c.setTime(formatoData.parse(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return c;
    }


}

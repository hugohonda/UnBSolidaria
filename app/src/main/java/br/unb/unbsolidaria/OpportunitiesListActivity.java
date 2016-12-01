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

    public List<Opportunity> getSetOportinidadesList(int qtd) {

        Database bd = Database.getInstance();
        List<Opportunity> listAux = bd.getOpportunities();
        return (listAux);
    }

    private Calendar getCalendar(String data) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();

        try {
            c.setTime(dataFormat.parse(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return c;
    }


}

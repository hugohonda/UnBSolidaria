package br.unb.unbsolidaria;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.unb.unbsolidaria.adapter.OpportunitiesAdapter;
import br.unb.unbsolidaria.communication.OpportunityService;
import br.unb.unbsolidaria.communication.RestCommunication;
import br.unb.unbsolidaria.entities.Opportunity;
import br.unb.unbsolidaria.persistency.Database;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OpportunitiesListActivity extends AppCompatActivity implements Callback<List<Opportunity>> {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Opportunity> mList;
    private ProgressDialog progressDialog;
    private boolean commFailure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opportunities_list);

        //ShowOpportunitiesList();
        ShowOpportunitiesList(10);
    }

    public void ShowOpportunitiesList(int qtd) {
        Database bd = Database.getInstance();
        mList = bd.getOpportunities();
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new OpportunitiesAdapter(this, mList);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void ShowOpportunitiesList() {
        progressDialog = ProgressDialog.show(this, null, "Carregando...", true, false);
        OpportunityService opportunityService = RestCommunication.createService(OpportunityService.class);
        Call<List<Opportunity>> call = opportunityService.getOpportunities();
        call.enqueue(this);

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


    @Override
    public void onResponse(Call<List<Opportunity>> call, Response<List<Opportunity>> response) {
        progressDialog.dismiss();
        mList = response.body();
        if (response.body().size() == 0) {
            Toast.makeText(getApplicationContext(), "Não foi possível conectar com o servidor", Toast.LENGTH_LONG).show();
        } else {
            mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
            mRecyclerView.setHasFixedSize(true);

            mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);

            mAdapter = new OpportunitiesAdapter(this, mList);
            mRecyclerView.setAdapter(mAdapter);
        }
    }

    @Override
    public void onFailure(Call<List<Opportunity>> call, Throwable t) {
        progressDialog.dismiss();
        Toast.makeText(getApplicationContext(), "Falha de conexão", Toast.LENGTH_LONG).show();
    }
}

package br.unb.unbsolidaria.voluntary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.unb.unbsolidaria.R;
import br.unb.unbsolidaria.adapter.OpportunitiesAdapter;
import br.unb.unbsolidaria.entities.Opportunity;
import br.unb.unbsolidaria.entities.Voluntary;
import br.unb.unbsolidaria.persistency.Database;

public class ViewOpportunities extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public static final String VIEW_MESSAGE = "br.unb.unbsolidaria.VIEWOPP";
    List<Opportunity> mList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_opportunities_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);


        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Database bd = Database.getInstance(getApplicationContext());
        mList = bd.getOpportunitiesList();

        mAdapter = new OpportunitiesAdapter(this, mList, (Voluntary) getIntent().getSerializableExtra("user"));
        mRecyclerView.setAdapter(mAdapter);
    }

}

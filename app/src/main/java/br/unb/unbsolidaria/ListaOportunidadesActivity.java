package br.unb.unbsolidaria;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.unb.unbsolidaria.Adapter.OportunidadesAdapter;
import br.unb.unbsolidaria.entidades.Oportunidade;
import br.unb.unbsolidaria.entidades.Organizacao;
import br.unb.unbsolidaria.fragments.OportunidadesFragment;
import br.unb.unbsolidaria.persistencia.BancoDeDados;

public class ListaOportunidadesActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_oportunidades);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);


        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        List<Oportunidade> mList= getSetOportinidadesList(10);

        mAdapter = new OportunidadesAdapter(this,mList);
        mRecyclerView.setAdapter(mAdapter);
    }

    //TODO - chamar recycler view
    // ver aqui https://github.com/LucasRez/Recycler-View-Example/blob/master/app/src/main/java/com/lucasrez/recyclerviewproj/MainActivity.java

    public List<Oportunidade> getSetOportinidadesList(int qtd){
//        String[] titulo = new String[]{"Unb Solidaria", "EduBot", "Voluntarios"};
//        String[] descricao = new String[]{"Desenvolve aplicativos","Aulas de robotica", "Somos legais"};
//        String[] local = new String[]{"UNB","SG 11", "Asa Norte"};
//        int[] vagas = new int[]{10,5,20};
//        int[] photos = new int[]{R.drawable.logo, R.drawable.logo, R.drawable.logo};
//        List<Oportunidade> listAux = new ArrayList<>();
//
//        for(int i = 0; i < qtd; i++){
//            Oportunidade o = new Oportunidade(i, local[i % local.length], vagas[i % vagas.length], titulo[i % titulo.length],
//                    descricao[i % descricao.length],getCalendar("01/01/2017"), getCalendar("01/02/2017"), new Organizacao(), photos[i % photos.length]);
//            listAux.add(o);
//        }

        BancoDeDados bd = BancoDeDados.getInstance();
        List<Oportunidade> listAux = bd.getOportunidades();
        return(listAux);
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

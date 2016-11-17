package br.unb.unbsolidaria.entidades;

//import android.icu.util.Calendar;
import java.util.Calendar;

/**
 * Created by lucasrez on 02/11/16.
 */

public class Oportunidade {
    //TODO: discutir feature de aprovação por parte da Organização
    //não há entidade no banco de dados
    private boolean requerAprovacao;
    //ID da Oportunidade
    private int mID;
    //Local
    //TODO: classe Local para conter informações tais como CEP
    private String mLocal;
    //Organização Resp.
    //TODO: classe de Organização
    private Organizacao mOrg;
    //Quantidade de vagas
    private int mVagas;
    //Título
    private String mTitulo;
    //Descrição
    //TODO: definir limite da descrição (precisa estar acordado com o appWeb)
    private String mDescricao;
    //TODO: dias pontuais e repetições
    //Data de Início
    private Calendar mInicio;
    //Data de Fim
    private Calendar mFim;

    public Oportunidade (){
    }

    public Oportunidade(int mID, String mLocal, int mVagas, String mTitulo,
                        String mDescricao, Calendar mInicio, Calendar mFim,
                        Organizacao org) {
        this.mID = mID;
        this.mLocal = mLocal;
        this.mVagas = mVagas;
        this.mTitulo = mTitulo;
        this.mDescricao = mDescricao;
        this.mInicio = mInicio;
        this.mFim = mFim;
        this.mOrg = org;
    }

    public int getID() {
        return mID;
    }

    public void setID(int mID) {
        this.mID = mID;
    }

    public String getLocal() {
        return mLocal;
    }

    public void setLocal(String mLocal) {
        this.mLocal = mLocal;
    }

    public int getVagas() {
        return mVagas;
    }

    public void setVagas(int mVagas) {
        this.mVagas = mVagas;
    }

    public String getTitulo() {
        return mTitulo;
    }

    public void setTitulo (String mTitulo) {
        this.mTitulo = mTitulo;
    }

    public String getDescricao() {
        return mDescricao;
    }

    public void setDescricao(String mDescricao) {
        this.mDescricao = mDescricao;
    }

    public Calendar getInicio() {
        return mInicio;
    }

    public void setInicio(Calendar mInicio) {
        this.mInicio = mInicio;
    }

    public Calendar getFim() {
        return mFim;
    }

    public void setFim(Calendar mFim) {
        this.mFim = mFim;
    }

    public Organizacao getOrg() {
        return mOrg;
    }

    public void setOrg(Organizacao mOrg) {
        this.mOrg = mOrg;
    }
}

package br.unb.unbsolidaria.entidades;


/**
 * Created by chris on 02/11/16.
 */

public class Organizacao {

    //ID Organizacao
    private int mId;
    //CPF
    private String mCnpj;
    //Nome juridico
    private String mNomeJuridico;
    //Nome comercial
    private String mNomeComercial;
    //email
    private String mEmail;
    //telefone
    private String mTelefone;
    //Site
    private String mWebSite;
    //descricao
    private String mDescricao;
    //endereco
    private String mEndereco;
    //CEP
    private String mCep;


    //Construtores

    public Organizacao() {
    }

    public Organizacao(int mId, String mCnpj, String mNomeJuridico,
                       String mNomeComercial, String mEmail, String mTelefone,
                       String mWebSite, String mDescricao, String mEndereco,
                       String mCep) {
        this.mId = mId;
        this.mCnpj = mCnpj;
        this.mNomeJuridico = mNomeJuridico;
        this.mNomeComercial = mNomeComercial;
        this.mEmail = mEmail;
        this.mTelefone = mTelefone;
        this.mWebSite = mWebSite;
        this.mDescricao = mDescricao;
        this.mEndereco = mEndereco;
        this.mCep = mCep;
    }

    //Getters e Setters

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getCnpj() {
        return mCnpj;
    }

    public void setCnpj(String mCnpj) {
        this.mCnpj = mCnpj;
    }

    public String getNomeJuridico() {
        return mNomeJuridico;
    }

    public void setNomeJuridico(String mNomeJuridico) {
        this.mNomeJuridico = mNomeJuridico;
    }

    public String getNomeComercial() {
        return mNomeComercial;
    }

    public void setNomeComercial(String mNomeComercial) {
        this.mNomeComercial = mNomeComercial;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getTelefone() {
        return mTelefone;
    }

    public void setTelefone(String mTelefone) {
        this.mTelefone = mTelefone;
    }

    public String getWebSite() {
        return mWebSite;
    }

    public void setWebSite(String mWebSite) {
        this.mWebSite = mWebSite;
    }

    public String getDescricao() {
        return mDescricao;
    }

    public void setDescricao(String mDescricao) {
        this.mDescricao = mDescricao;
    }

    public String getEndereco() {
        return mEndereco;
    }

    public void setEndereco(String mEndereco) {
        this.mEndereco = mEndereco;
    }

    public String getCep() {
        return mCep;
    }

    public void setCep(String mCep) {
        this.mCep = mCep;
    }
}

package br.unb.unbsolidaria.entidades;

import android.icu.util.Calendar;

import java.util.Date;

/**
 * Created by lucasrez on 02/11/16.
 * - Non-public, non-static field names start with m
 * - Static field names start with s.
 * - Other fields start with a lower case letter.
 * - Public static final fields (constants) are ALL_CAPS_WITH_UNDERSCORES.
 */
//TODO: verificar se ha algo mais a ser adicionado
public class Voluntario {
    //ID
    private int mId;
    //CPF
    private String mCpf;
    //Nome
    private String mNome;
    //Sobrenome
    private String mSobrenome;
    //Data de nascimento
    private Calendar mDataNascimento;
    //email
    private String mEmail;
    //telefone
    private String mTelefone;
    //descricao
    private String mDescricao;
    //matricula
    private String mMatricula;
    //endereco
    private String mEndereco;
    //sexo
    private String mSexo;
    //ativo
    private boolean mAtivo;

    //construtor

    public Voluntario() {
    }

    public Voluntario(int id, String cpf, String nome, String sobrenome,
                      Calendar dataNascimento, String email, String telefone,
                      String descricao, String matricula, String endereco,
                      String sexo, boolean ativo) {
        this.mId = id;
        this.mCpf = cpf;
        this.mNome = nome;
        this.mSobrenome = sobrenome;
        this.mDataNascimento = dataNascimento;
        this.mEmail = email;
        this.mTelefone = telefone;
        this.mDescricao = descricao;
        this.mMatricula = matricula;
        this.mEndereco = endereco;
        this.mSexo = sexo;
        this.mAtivo = ativo;
    }

    //getters

    public int getId() {
        return mId;
    }

    public String getCpf() {
        return mCpf;
    }

    public String getNome() {
        return mNome;
    }

    public String getSobrenome() {
        return mSobrenome;
    }

    public Calendar getDataNascimento() {
        return mDataNascimento;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getTelefone() {
        return mTelefone;
    }

    public String getDescricao() {
        return mDescricao;
    }

    public String getMatricula() {
        return mMatricula;
    }

    public String getEndereco() {
        return mEndereco;
    }

    public String getSexo() {
        return mSexo;
    }

    public boolean isAtivo() {
        return mAtivo;
    }

    //setters

    public void setNome(String mNome) {
        this.mNome = mNome;
    }

    public void setSobrenome(String mSobrenome) {
        this.mSobrenome = mSobrenome;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public void setTelefone(String mTelefone) {
        this.mTelefone = mTelefone;
    }

    public void setDescricao(String mDescricao) {
        this.mDescricao = mDescricao;
    }

    public void setEndereco(String mEndereco) {
        this.mEndereco = mEndereco;
    }

    public void setSexo(String mSexo) {
        //TODO: resolver polemica do sexo
        this.mSexo = mSexo;
    }

    public void setAtivo(boolean mAtivo) {
        this.mAtivo = mAtivo;
    }
}

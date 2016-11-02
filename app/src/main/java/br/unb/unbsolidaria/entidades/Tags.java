package br.unb.unbsolidaria.entidades;

/**
 * Created by lucasrez on 02/11/16.
 */

public class Tags {
    // ID Banco de Dados
    private String mId;
    // Nome
    private String mNome;
    // Descrição da tag
    private String mDescricao;
    
    public Tags() {

    }
    public Tags(String mId, String mNome, String mDescricao) {
        this.mId = mId;
        this.mNome = mNome;
        this.mDescricao = mDescricao;
    }

    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }

    public String getNome() {
        return mNome;
    }

    public void setNome(String mNome) {
        this.mNome = mNome;
    }

    public String getDescricao() {
        return mDescricao;
    }

    public void setDescricao(String mDescricao) {
        this.mDescricao = mDescricao;
    }
}

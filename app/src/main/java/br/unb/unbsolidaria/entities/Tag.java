package br.unb.unbsolidaria.entities;

/**
 * Created by lucasrez on 02/11/16.
 */

public class Tag {
    // ID Banco de Dados
    private int id;
    // Nome
    private String name;
    // Descrição da tag
    private String description;

    public Tag() {

    }

    public Tag(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

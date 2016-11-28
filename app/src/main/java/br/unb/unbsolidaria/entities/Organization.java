package br.unb.unbsolidaria.entities;


/**
 * Created by chris on 02/11/16.
 */

public class Organization {

    //ID Organization
    private int id;
    //CPF
    private String cnpj;
    //Nome juridico
    private String legalName;
    //Nome comercial
    private String commercialName;
    //email
    private String email;
    //telefone
    private String phoneNumber;
    //Site
    private String website;
    //descricao
    private String description;
    //endereco
    private String address;
    //CEP
    private String cep;


    //Construtores

    public Organization() {
    }

    public Organization(int id, String cnpj, String legalName,
                        String commercialName, String email, String phoneNumber,
                        String website, String description, String address,
                        String cep) {
        this.id = id;
        this.cnpj = cnpj;
        this.legalName = legalName;
        this.commercialName = commercialName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.website = website;
        this.description = description;
        this.address = address;
        this.cep = cep;
    }

    //Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getCommercialName() {
        return commercialName;
    }

    public void setCommercialName(String commercialName) {
        this.commercialName = commercialName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}

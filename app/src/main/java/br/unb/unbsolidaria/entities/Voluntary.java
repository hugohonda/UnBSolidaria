package br.unb.unbsolidaria.entities;

//TODO: decidir se é viável o uso da livraria ICU. Razão: disponível somente a partir da API 24 (Android 7.0)
//import android.icu.util.Calendar;

import java.util.Calendar;

/**
 * Created by lucasrez on 02/11/16.
 * - Non-public, non-static field names start with m
 * - Static field names start with s.
 * - Other fields start with a lower case letter.
 * - Public static final fields (constants) are ALL_CAPS_WITH_UNDERSCORES.
 */
//TODO: verificar se ha algo mais a ser adicionado
public class Voluntary {
    //ID
    private int id;
    //CPF
    private String cpf;
    //Nome
    private String name;
    //Sobrenome
    private String surname;
    //Data de nascimento
    private Calendar birthDate;
    //email
    private String email;
    //telefone
    private String phoneNumber;
    //descricao
    private String description;
    //matricula
    private String unbRegistrationNumber;
    //endereco
    private String address;
    //sexo
    private String gender;
    //ativo
    private boolean active;

    //construtor

    public Voluntary() {
    }

    public Voluntary(int id, String cpf, String name, String surname,
                     Calendar birthDate, String email, String phoneNumber,
                     String description, String unbRegistrationNumber, String address,
                     String gender, boolean active) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.unbRegistrationNumber = unbRegistrationNumber;
        this.address = address;
        this.gender = gender;
        this.active = active;
    }

    //getters

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Calendar getBirthDate() {
        return birthDate;
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

    public String getDescription() {
        return description;
    }

    //setters

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnbRegistrationNumber() {
        return unbRegistrationNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        //TODO: resolver polemica do sexo
        this.gender = gender;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

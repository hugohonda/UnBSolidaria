package br.unb.unbsolidaria.entities;

//import android.icu.util.Calendar;

import java.util.Calendar;

/**
 * Created by lucasrez on 02/11/16.
 */

public class Opportunity {
    //TODO: discutir feature de aprovação por parte da Organização
    //não há entidade no banco de dados
    private boolean needsApproval;
    //ID da Opportunity
    private String id;
    //Local
    //TODO: classe Local para conter informações tais como CEP
    private String address;
    //Organização Resp.
    private Organization organization;
    //Quantidade de vagas
    private int nPositions;
    //Título
    private String title;
    //Descrição
    //TODO: definir limite da descrição (precisa estar acordado com o appWeb)
    private String description;
    //TODO: dias pontuais e repetições
    //Data de Início
    private Calendar startDate;
    //Data de Fim
    private Calendar endDate;


    //// TODO: 24/11/2016 modificar quando for pegar a foto do server
    //para teste pelo res
    private int photo;

    public Opportunity() {
    }

    public Opportunity(String id, String address, int nPositions, String title,
                       String description, Calendar startDate, Calendar endDate,
                       Organization organization, int photo) {
        this.id = id;
        this.address = address;
        this.nPositions = nPositions;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.organization = organization;
        this.photo = photo;
    }

    public Opportunity(String id, String address, int nPositions, String title,
                       String description, Calendar startDate, Calendar endDate,
                       Organization organization) {
        this.id = id;
        this.address = address;
        this.nPositions = nPositions;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.organization = organization;
    }


    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getLocal() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getVagas() {
        return nPositions;
    }

    public void setNPositions(int nPositions) {
        this.nPositions = nPositions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}

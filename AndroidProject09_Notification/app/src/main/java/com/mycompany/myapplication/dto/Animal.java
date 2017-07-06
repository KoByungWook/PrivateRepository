package com.mycompany.myapplication.dto;

import java.util.Date;

public class Animal {
    private int ano;
    private int aphoto;
    private String aname;
    private Date adate;
    private String adesc;

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getAphoto() {
        return aphoto;
    }

    public void setAphoto(int aphoto) {
        this.aphoto = aphoto;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Date getAdate() {
        return adate;
    }

    public void setAdate(Date adate) {
        this.adate = adate;
    }

    public String getAdesc() {
        return adesc;
    }

    public void setAdesc(String adesc) {
        this.adesc = adesc;
    }
}

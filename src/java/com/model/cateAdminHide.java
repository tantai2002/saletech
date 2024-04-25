/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author duong
 */
public class cateAdminHide {
    private int id;
    private String name;
    private int cateAdmin_id;
    private String nameserv;

    public cateAdminHide() {
    }

    public cateAdminHide(int id, String name, int cateAdmin_id, String nameserv) {
        this.id = id;
        this.name = name;
        this.cateAdmin_id = cateAdmin_id;
        this.nameserv = nameserv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCateAdmin_id() {
        return cateAdmin_id;
    }

    public void setCateAdmin_id(int cateAdmin_id) {
        this.cateAdmin_id = cateAdmin_id;
    }

    public String getNameserv() {
        return nameserv;
    }

    public void setNameserv(String nameserv) {
        this.nameserv = nameserv;
    }

    
    
}

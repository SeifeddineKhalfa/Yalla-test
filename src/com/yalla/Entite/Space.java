/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yalla.Entite;

import java.sql.Timestamp;
import java.time.*;
import java.time.LocalDate;

/**
 * 
 * @author SEIF
 */
public class Space {
   
    private int id;
    private String name;
    private Timestamp availableStartDate; //todo: check format
    private Timestamp availableEndDate;
    private String location;
    private String category;
    private User user;
    
    
    public Space(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Space(String name, Timestamp availableStartDate, Timestamp availableEndDate, String location, String category) {
        this.name = name;
        this.availableStartDate = availableStartDate;
        this.availableEndDate = availableEndDate;
        this.location = location;
        this.category = category;
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

    public Timestamp getAvailableStartDate() {
        return availableStartDate;
    }

    public void setAvailableStartDate(Timestamp availableStartDate) {
        this.availableStartDate = availableStartDate;
    }

    public Timestamp getAvailableEndDate() {
        return availableEndDate;
    }

    public void setAvailableEndDate(Timestamp availableEndDate) {
        this.availableEndDate = availableEndDate;
    }
    
    

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Space{" + "id=" + id + ", name=" + name + ", availableStartDate=" + availableStartDate + ", availableEndDate=" + availableEndDate + ", location=" + location + ", category=" + category + '}';
    }


    
    
}

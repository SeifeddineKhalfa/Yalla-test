/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yalla.Entite;

import java.sql.Timestamp;

/**
 *
 * @author SEIF
 */
public class Reservation {
    private int id;
    private Timestamp startDate; 
    private Timestamp endDate;
    private User user;
    private Space space;

    public Reservation(Timestamp startDate, Timestamp endDate, User user, Space space) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
        this.space = space;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }
    
    
}

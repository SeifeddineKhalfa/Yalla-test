/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yalla.Reservation;

import com.yalla.Entite.*;
import com.yalla.Service.SpaceService;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author SEIF
 */
public class SpaceReservation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Space sp1 = new Space("New gym", java.sql.Timestamp.valueOf("2021-06-20 00:00:00"), java.sql.Timestamp.valueOf("2021-06-30 22:00:00"), "Nabeul", "Terrain de foot");
        SpaceService ser = new SpaceService();
        

        //adding a new space with prepared statement function (dates are static)
        try {
            ser.addPST(sp1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

       
        //get space by id
//        try {
//            Space sp = ser.getById(5);
//            System.out.println(sp);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
        
        //delete space byId
//        try {
//            ser.DeleteByID(4);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }

        
        List<Space> spacesList = null;
        try {
            spacesList = ser.readAll();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        for (Space s : spacesList) {
            System.out.println(s);
        }
    }

}

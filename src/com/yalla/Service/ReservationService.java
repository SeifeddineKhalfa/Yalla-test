/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yalla.Service;

import com.yalla.Entite.*;
import com.yalla.Utils.DataSource;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author SEIF
 */
public class ReservationService implements IService<Reservation> {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ReservationService() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void add(Reservation t) throws SQLException {

//        String req = "INSERT INTO `space` ( `nom`, `prenom`, `age`) VALUES ( '" + t.getNom() + "', '" + t.getPrenom() + "', '" + t.getAge() + "');";
//        ste.executeUpdate(req);
        System.out.println("Reservation ajouté");

    }

    @Override
    public void addPST(Reservation t) throws SQLException {
       String req = "INSERT INTO `reservation` (`startDate`, `endDate`) VALUES (?,?);";  
        PreparedStatement pst=con.prepareStatement(req);
        pst.setTimestamp(2, t.getStartDate());
        pst.setTimestamp(3, t.getEndDate());
        pst.executeUpdate();
        System.out.println("Ajout avec pst");
    }
    
    @Override
    public void update (Reservation t) throws SQLException
    {
        String req = "UPDATE `reservation` SET `startDate` = '" 
                + t.getStartDate()+ "', `endDate` = '" + t.getEndDate()+  "' WHERE id = '" + t.getId() +"'";
        ste.executeUpdate(req);
        System.out.println("Space modifiedé");
    }

    @Override
    public List<Reservation> readAll() throws SQLException 
    {
       List<Reservation> li=new ArrayList<>();
       ResultSet rs=ste.executeQuery("select * from reservation");
       
        while (rs.next()) {
            int foundId = rs.getInt("id");
            Timestamp startDate = rs.getTimestamp("startDate");
            Timestamp endDate = rs.getTimestamp("endDate");
            //Reservation reservation = new Reservation(startDate, endDate, user, space);
            //li.add(reservation);
        }
       
       return li;
    }

    
    @Override
    public void deleteById(Reservation res) throws SQLException {

        String req = "DELETE FROM `reservation` WHERE id = '" + res.getId() +"'";
        ste.executeUpdate(req);
        System.out.println("Reservation deleted");
    }
    
//    public Reservation getById(int id) throws SQLException{
//
//        ResultSet rs = ste.executeQuery("select * from space where id = '" + id +"'");
//        Space reservation = null;
//        while (rs.next()) {
//          int foundId = rs.getInt("id");
//          Timestamp startDate = rs.getTimestamp("startDate");
//          Timestamp endDate = rs.getTimestamp("endDate");
//          
//          //reservation = new Reservation(startDate, endDate, user, space);
//        }
//        
//       //return reservation;
//
//    }

}

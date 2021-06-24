/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yalla.Service;

import com.yalla.Entite.Space;
import com.yalla.Utils.DataSource;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author SEIF
 */
public class SpaceService implements IService<Space> {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public SpaceService() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void add(Space t) throws SQLException {

//        String req = "INSERT INTO `space` ( `nom`, `prenom`, `age`) VALUES ( '" + t.getNom() + "', '" + t.getPrenom() + "', '" + t.getAge() + "');";
//        ste.executeUpdate(req);
        System.out.println("Space ajouté");

    }

    @Override
    public void addPST(Space t) throws SQLException {
       String req = "INSERT INTO `space` (`name`, `availableStartDate`, `availableEndDate`, `location`, `category`, `user_id`) VALUES (?,?,?,?,?, ?);";  
        PreparedStatement pst=con.prepareStatement(req);
        pst.setString(1, t.getName());
        //pst.setDate(2, new java.sql.Date(t.getAvailableStartDate()));
        pst.setTimestamp(2, t.getAvailableStartDate());
        pst.setTimestamp(3, t.getAvailableEndDate());
        pst.setString(4, t.getLocation());
        pst.setString(5, t.getCategory());
        pst.setInt(6, t.getUser().getId());
        pst.executeUpdate();
        System.out.println("Ajout avec pst");
    }
    
    @Override
    public void update (Space t) throws SQLException
    {
        String req = "UPDATE `space` SET `name` = '" + t.getName() + "', `location` = '" + t.getLocation()+ "', `category` = '" + t.getCategory()+ "', `availableStartDate` = '" 
                + t.getAvailableStartDate()+ "', `availableEndDate` = '" + t.getAvailableEndDate()+  "' WHERE id = '" + t.getId() +"'";
        ste.executeUpdate(req);
        System.out.println("Space modifiedé");
    }

    @Override
    public List<Space> readAll() throws SQLException 
    {
       List<Space> li=new ArrayList<>();
       ResultSet rs=ste.executeQuery("select * from space");
       
        while (rs.next()) {
            int id=rs.getInt("id");
            String name = rs.getString("name");
            int foundId = rs.getInt("id");
            Timestamp availableStartTime = rs.getTimestamp("availableStartDate");
            Timestamp availableEndTime = rs.getTimestamp("availableEndDate");
            String location = rs.getString("location");
            String category = rs.getString("category");
            Space sp = new Space(id, name);
            li.add(sp);
        }
       
       return li;
    }

    
    @Override
    public void deleteById(Space s) throws SQLException {

        String req = "DELETE FROM `space` WHERE id = '" + s.getId() +"'";
        ste.executeUpdate(req);
        System.out.println("Space deleted");
    }
    
    public Space getById(int id) throws SQLException{

        ResultSet rs = ste.executeQuery("select * from space where id = '" + id +"'");
        Space sp = null;
        while (rs.next()) {
          String name = rs.getString("name");
          int foundId = rs.getInt("id");
          Timestamp availableStartTime = rs.getTimestamp("availableStartDate");
          Timestamp availableEndTime = rs.getTimestamp("availableEndDate");
          String location = rs.getString("location");
          String category = rs.getString("category");
          
          sp = new Space(name, availableStartTime, availableEndTime, location, category);
        }
        
       return sp;

    }

}

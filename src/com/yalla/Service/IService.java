/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yalla.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author SEIF
 * @param <T> 
 */
public interface IService<T> {
    
    void add(T t) throws SQLException;
    void addPST(T t) throws SQLException;
    void update(T t) throws SQLException;
    void deleteById(T t) throws SQLException;
    List<T> readAll() throws SQLException;
    
}

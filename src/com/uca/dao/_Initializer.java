
package com.uca.dao;

import java.sql.*;

public class _Initializer {

 public static void Init(){
 Connection connection = _Connector.getInstance();
  try {
 PreparedStatement statement;

 statement = connection.prepareStatement("DROP TABLE eleveGom;");
 statement.executeUpdate(); 
 statement = connection.prepareStatement("DROP TABLE professeurs;");
 statement.executeUpdate(); 
 statement = connection.prepareStatement("DROP TABLE eleves;");
 statement.executeUpdate(); 
 statement = connection.prepareStatement("DROP TABLE goms;");
 statement.executeUpdate(); 

 // Init professeurs 
 statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS professeurs (id int primary key auto_increment, firstname varchar(100), lastname varchar(100),password varchar(100)); ");
 statement.executeUpdate(); 
 statement = connection.prepareStatement("INSERT INTO professeurs (firstName, lastname, password) VALUES(?, ?, ?);");
 statement.setString(1, "Loris");
 statement.setString(2, "CROCE");
 statement.setString(3, "mdp123");
 statement.executeUpdate();

 
 
 //Init eleves
 statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS eleves (id int primary key auto_increment, firstname varchar(100), lastname varchar(100)); ");
 statement.executeUpdate(); 

 statement = connection.prepareStatement("INSERT INTO eleves (firstName, lastname) VALUES(?, ?);");
 statement.setString(1, "Cynthia");
 statement.setString(2, "LOURENC0");
 statement.executeUpdate();
 statement = connection.prepareStatement("INSERT INTO eleves (firstName, lastname) VALUES(?, ?);");
 statement.setString(1, "Louane");
 statement.setString(2, "MECHOUD");
 statement.executeUpdate();
 statement = connection.prepareStatement("INSERT INTO eleves (firstName, lastname) VALUES(?, ?);");
 statement.setString(1, "Nourrane");
 statement.setString(2, "MALLEPEYRE");
 statement.executeUpdate();

 //Init Gommettes
 statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS goms (id int primary key auto_increment, description varchar(100), color varchar(100)); ");
 statement.executeUpdate();
 statement = connection.prepareStatement("INSERT INTO goms (description, color) VALUES(?, ?);");
 statement.setString(1, "Bonne Conduite");
 statement.setString(2, "vert");
 statement.executeUpdate();
 statement.setString(1, "Mauvaise Conduite");
 statement.setString(2, "rouge");
 statement.executeUpdate();

 
 
 statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS eleveGom (id int primary key auto_increment, date varchar(100), motif varchar(100), idEleve int, FOREIGN KEY (idEleve) REFERENCES eleves (id),idProf int, FOREIGN KEY (idProf) REFERENCES professeurs (id), idGom int, FOREIGN KEY (idGom) REFERENCES goms (id));");
 statement.executeUpdate();

 statement = connection.prepareStatement("INSERT INTO eleveGom (date, motif, idEleve, idGom, idProf) VALUES(?, ?, ?, ?, ?);");
 statement.setString(1, "2022-05-12");
 statement.setString(2, "A fini son projet a temps");
 statement.setString(3, "1");
 statement.setString(4, "1");
 statement.setString(5, "1");
 statement.executeUpdate();
 
 // statement = connection.prepareStatement("INSERT INTO eleveGom ( idEleve, eleveFirstName,idGom) VALUES(?, ?, ?);");
 // statement.setString(1, "5");
 // statement.setString(2, (select customer_id from customer where name = 'John'));
 // statement.setString(3, "5");
 // statement.executeUpdate();
 

 } catch (Exception e){
 System.out.println(e.toString());
 throw new RuntimeException("could not create database !");
 }
 }
}
    
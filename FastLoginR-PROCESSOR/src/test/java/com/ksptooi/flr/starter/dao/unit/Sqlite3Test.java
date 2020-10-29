package com.ksptooi.flr.starter.dao.unit;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class Sqlite3Test {


    @Test
    public void T(){

        try{

            Class.forName("org.sqlite.JDBC");

            String url = "jdbc:sqlite:plugins/sqlite3.db";
            System.out.println("db url "+url);
            Connection conn = DriverManager.getConnection(url);
            System.out.println(conn.getMetaData().getDriverVersion());

        }catch (Exception e){
            e.printStackTrace();
        }


    }

}

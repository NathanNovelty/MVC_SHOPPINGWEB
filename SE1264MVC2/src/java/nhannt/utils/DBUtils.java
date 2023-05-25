/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhannt.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Trung Nhan
 */
public class DBUtils implements Serializable {

    public static Connection makeConnection() throws NamingException, SQLException {
        Context context = new InitialContext();
        Context webAppContext = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) webAppContext.lookup("SE1264DS");
        Connection con = ds.getConnection();

//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String url = "jdbc:sqlserver://localhost:1433;databaseName=PRJ321";
//        Connection  con = DriverManager.getConnection(url,"sa","trungnhan137");
//        
//        return con;
        return con;
    }
}

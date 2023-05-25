/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhannt.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import nhannt.utils.DBUtils;

/**
 *
 * @author Trung Nhan
 */
public class StudentDAO implements Serializable {

    public boolean checkLogin(String username, String password) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "Select username, password From Student Where username =? and password =?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);

                rs = stm.executeQuery();
                if (rs.next()) {
                    return true;
                }

            } //end if con != null

        } finally {

            if (rs != null) {
                rs.close();
            }

            if (con != null) {

            }

            if (stm != null) {
                stm.close();
            }

            if (con != null) {
                con.close();
            }
        }

        return false;
    }
    private List<StudentDTO> listUser;

    public List<StudentDTO> getListUser() {
        return listUser;
    }

    public void searchLastName(String searchValue) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * From Student Where Username LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");

                rs = stm.executeQuery();
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String lastname = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");

                    StudentDTO dto = new StudentDTO(username, password, lastname, role);
                    if (this.listUser == null) {
                        this.listUser = new ArrayList<>();

                    }
                    this.listUser.add(dto);
                }
            }//end if con
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
//        return false;
    }

    public boolean deletePK(String pk) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "Delete From Student Where username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, pk);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }

            } //end if con != null

        } finally {

            if (con != null) {

            }

            if (stm != null) {
                stm.close();
            }

            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean updatePassRole(String username, String lastname, boolean role) throws SQLException, NamingException {
        
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "Update Student Set lastname =?, isAdmin =? Where username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1,  lastname);
                stm.setBoolean(2, role);
                stm.setString(3, username);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }

            } //end if con != null

        } finally {

            if (con != null) {

            }

            if (stm != null) {
                stm.close();
            }

            if (con != null) {
                con.close();
            }
        }
        
        return false;
    }
}

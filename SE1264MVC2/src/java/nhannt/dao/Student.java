/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhannt.dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NhanN
 */
@Entity
//@Table(name = "Student", catalog = "PRJ321", schema = "SA")
@Table(name = "Student", catalog = "PRJ321", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findByUsername", query = "SELECT s FROM Student s WHERE s.username = :username")
    , @NamedQuery(name = "Student.findByPassword", query = "SELECT s FROM Student s WHERE s.password = :password")
    , @NamedQuery(name = "Student.findByLastname", query = "SELECT s FROM Student s WHERE s.lastname = :lastname")
    , @NamedQuery(name = "Student.findByIsAdmin", query = "SELECT s FROM Student s WHERE s.isAdmin = :isAdmin")
    , @NamedQuery(name = "Student.findByLikeLastName",
            query = "SELECT s FROM Student s WHERE s.lastname LIKE :lastname")
//    , @NamedQuery(name = "Student.deleteByUserName", query = "DELETE FROM WHERE")

})

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "username", nullable = false, length = 250)
    private String username;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 250)
    private String password;
    @Basic(optional = false)
    @Column(name = "lastname", nullable = false, length = 250)
    private String lastname;
    @Column(name = "isAdmin")
    private Boolean isAdmin;

    public Student() {
    }

    public Student(String username) {
        this.username = username;
    }

    public Student(String username, String password, String lastname) {
        this.username = username;
        this.password = password;
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nhannt.dao.Student[ username=" + username + " ]";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhannt.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author NhanN
 */
public class StudentBLO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SE1264MVC2PU");

    public void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public boolean checkLogin(String username, String password) {
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT s.username, s.password, s.lastname, s.isAdmin FROM Student s WHERE s.username = :username AND s.password = :password";

        Query query = em.createQuery(jpql);
        query.setParameter("username", username);
        query.setParameter("password", password);

        try {
            query.getSingleResult();
            return true;
        } catch (NoResultException | NonUniqueResultException ex) {
            System.out.println("Error: " + ex);
            return false;
        }
    }

    public List searchLikeLastname(String searchValue) {
        EntityManager em = emf.createEntityManager();

        String jpql = "Student.findByLikeLastName";

        Query query = em.createNamedQuery(jpql);
        query.setParameter("lastname", "%" + searchValue + "%");

        List result = query.getResultList();

        return result;
    }

    public boolean deletePK(String pk) {
        EntityManager em = emf.createEntityManager();

//        Query query = em.createNativeQuery("DELETE FROM Student s WHERE s.username = :username");
//        query.setParameter("username", pk);
//
//        int row = query.executeUpdate();
//        if (row > 0) {
//            return true;
//        }
        Student stu = em.find(Student.class, pk);
        if (stu != null) {
            em.getTransaction().begin();
            em.remove(stu);
            em.getTransaction().commit();
            return true;
        }
        
        return false;
    }
    
    public boolean updateRecord(String username, String password ,boolean isAdmin){
        EntityManager em = emf.createEntityManager();
        
        Student stu = em.find(Student.class, username);
        if (stu != null) {
            stu.setIsAdmin(isAdmin);
            stu.setPassword(password);
            em.getTransaction().begin();
            em.merge(stu);
            em.getTransaction().commit();
            
            return true;
        }
        
        return false;
    }
}

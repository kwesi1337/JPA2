/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author josephawwal
 */
public class Tester {

    public static void main(String[] args) {

        Persistence.generateSchema("pu", null);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        
         try {
             
             em.getTransaction().begin();
             em.getTransaction().commit();
             
         } finally {
             
             if (em != null){
                 
                 em.close();
                 
             }
         }

    }

}

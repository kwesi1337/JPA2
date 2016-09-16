/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Employee;
import static entity.Employee_.id;
import entity.Person;
import entity.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author josephawwal
 */
public class facade  {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private static EntityManager em =  emf.createEntityManager();
    private static addDelete<Person> addPerson = new addDelete();
    private static addDelete<Student> addStudent = new addDelete();
    private static addDelete<Employee> addEmployee = new addDelete();
    
    private static class addDelete<Type>{
        
        
        public void add(Type obj){
        try {
        
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        
    } finally {
            
            if (em!= null){
                
                em.close();
                
            }
        }
    }
        
        public void delete(Type obj){
            
            try {
                
                em.getTransaction().begin();
                em.remove(obj);
                em.getTransaction().commit();
            } finally {
                
                if (em != null){
                    
                    em.close();
                    
                }
            }
        }
        
        public void addPerson(Person p){
            
            addPerson.add(p);
            
        }
        
        public void addStudent(Student p){
            
            addStudent.add(p);
        }
        
        public void addEmployee(Employee p){
            
            addEmployee.add(p);
            
        }
        
        public Person findPerson(int id){
            
            return em.find(Person.class, id);
            
        }
        
        public Student findStudent(int id){
            
            return em.find(Student.class, id);
            
            
        }
        
        public Employee findEmployee(int id){
            
            return em.find(Employee.class, id);
            
        }
        
        
        public void deletePerson(Person p){
            
            addPerson.delete(p);
            
        }
        
        public void deleteStudent(Student p){
            
            addStudent.delete(p);
            
        }
        
        
        public void deleteEmployee(Employee p){
            
            addEmployee.delete(p);
            
        }

    @Override
    public String toString() {
        return "facade.facade[ id=" + id + " ]";
    }
    
}
    
}


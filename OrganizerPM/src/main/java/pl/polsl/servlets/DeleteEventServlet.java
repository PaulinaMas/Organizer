/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.persistence.jpa.jpql.Assert;
import pl.polsl.entities.Event;
import pl.polsl.entities.Owner;

/**
 *
 * @author pauli
 */


@WebServlet(name = "DeleteEvent", urlPatterns = {"/DeleteEvent"})
public class DeleteEventServlet extends HttpServlet {
    
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_OrganizerWeb_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
         String deleteids = request.getParameter("deleteid");
         String ow = (String)request.getSession().getAttribute("owner");
    Query query1 = em.createNamedQuery("Owner.findByName");
       query1.setParameter("name", ow);
       Owner own =  (Owner)query1.getResultList().get(0);
       int ido = own.getId();
         try{
             int deleteid = Integer.parseInt(deleteids);
             
    
     Query query2 = em.createQuery("select e from Event e where e.id = :id and e.owner.id = :ido");
    query2.setParameter("id", deleteid);
     query2.setParameter("ido", ido);
     em.getTransaction().begin();
    if(query2.getResultList().isEmpty())
    {
        request.setAttribute("addoredit", "Wrong ID");   
         request.setAttribute("added", "Enter a valid ID");
         request.getRequestDispatcher("/addedititem.jsp").forward(request, response);
        em.getTransaction().rollback();
    }
    else
    {
        Query query = em.createQuery("Delete  from Event e where e.id = :id and e.owner.id = :ido");
        query.setParameter("id", deleteid);
     query.setParameter("ido", ido);
         query.executeUpdate();
    em.getTransaction().commit();
    }
    em.close();
   
             
         }
         catch(NumberFormatException nfe){
              request.setAttribute("addoredit", "Wrong ID");   
         request.setAttribute("added", "Enter a valid ID");
         request.getRequestDispatcher("/addedititem.jsp").forward(request, response);
         em.close();
         }

        
           request.setAttribute("comunicat", "Item deleted succesfully!");
         request.getRequestDispatcher("/deleteitems.jsp").forward(request, response);
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_OrganizerWeb_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
         String deleteids = request.getParameter("deleteid");
         String ow = (String)request.getSession().getAttribute("owner");
    Query query1 = em.createNamedQuery("Owner.findByName");
       query1.setParameter("name", ow);
       Owner own =  (Owner)query1.getResultList().get(0);
       int ido = own.getId();
         try{
             int deleteid = Integer.parseInt(deleteids);
             
    
     Query query2 = em.createQuery("select e from Event e where e.id = :id and e.owner.id = :ido");
    query2.setParameter("id", deleteid);
     query2.setParameter("ido", ido);
     em.getTransaction().begin();
    if(query2.getResultList().isEmpty())
    {
        request.setAttribute("addoredit", "Wrong ID");   
         request.setAttribute("added", "Enter a valid ID");
         request.getRequestDispatcher("/addedititem.jsp").forward(request, response);
        em.getTransaction().rollback();
    }
    else
    {
        Query query = em.createQuery("Delete  from Event e where e.id = :id and e.owner.id = :ido");
        query.setParameter("id", deleteid);
     query.setParameter("ido", ido);
         query.executeUpdate();
    em.getTransaction().commit();
    }
    em.close();
   
             
         }
         catch(NumberFormatException nfe){
              request.setAttribute("addoredit", "Wrong ID");   
         request.setAttribute("added", "Enter a valid ID");
         request.getRequestDispatcher("/addedititem.jsp").forward(request, response);
         em.close();
         }

        
           request.setAttribute("comunicat", "Item deleted succesfully!");
         request.getRequestDispatcher("/deleteitems.jsp").forward(request, response);
      
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

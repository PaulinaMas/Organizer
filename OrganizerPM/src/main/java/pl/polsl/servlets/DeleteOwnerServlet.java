/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.polsl.entities.Owner;

/**
 *
 * @author pauli
 */
@WebServlet(name = "DeleteOwnerServlet", urlPatterns = {"/DeleteOwnerServlet"})
public class DeleteOwnerServlet extends HttpServlet {

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
         String deleteusername = request.getParameter("deleteusername");
         Query query = em.createNamedQuery("Owner.findByName");
         query.setParameter("name", deleteusername);
         if(query.getResultList().isEmpty())
         {
         request.setAttribute("noparameters", "User doesn't exists!");
         request.getRequestDispatcher("/noparameters.jsp").forward(request, response); 
         }
         Owner ow = (Owner)query.getResultList().get(0);
         int id = ow.getId();
         
         em.getTransaction().begin();
         Query query1 = em.createQuery("Delete from Event e where e.owner.id = :ido");
     query1.setParameter("ido", id);
         query1.executeUpdate();
    em.getTransaction().commit();
    
    em.getTransaction().begin();
     Query query2 = em.createQuery("Delete from Owner o where o.id = :ido");
     query2.setParameter("ido", id);
    query2.executeUpdate();
    em.getTransaction().commit();
         em.close();
                    request.setAttribute("comunicat", "User deleted succesfully!");
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
         String deleteusername = request.getParameter("deleteusername");
         Query query = em.createNamedQuery("Owner.findByName");
         query.setParameter("name", deleteusername);
         if(query.getResultList().isEmpty())
         {
         request.setAttribute("noparameters", "User doesn't exists!");
         request.getRequestDispatcher("/noparameters.jsp").forward(request, response); 
         }
         Owner ow = (Owner)query.getResultList().get(0);
         int id = ow.getId();
         
         em.getTransaction().begin();
         Query query1 = em.createQuery("Delete from Event e where e.owner.id = :ido");
     query1.setParameter("ido", id);
         query1.executeUpdate();
    em.getTransaction().commit();
    
    em.getTransaction().begin();
     Query query2 = em.createQuery("Delete from Owner o where o.id = :ido");
     query2.setParameter("ido", id);
    query2.executeUpdate();
    em.getTransaction().commit();
         em.close();
                    request.setAttribute("comunicat", "User deleted succesfully!");
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

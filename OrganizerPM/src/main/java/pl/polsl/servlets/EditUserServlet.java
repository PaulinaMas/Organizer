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
@WebServlet(name = "EditUserServlet", urlPatterns = {"/EditUserServlet"})
public class EditUserServlet extends HttpServlet {

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
           String newuser = request.getParameter("newuser");
        String olduser = request.getParameter("olduser");
EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_OrganizerWeb_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Owner.findByName");
        query.setParameter("name", olduser);
        if(query.getResultList().isEmpty())
        {
         request.setAttribute("noparameters", "User doesn't exists!");
         request.getRequestDispatcher("/noparameters.jsp").forward(request, response); 
        }
        Owner ow = (Owner)query.getResultList().get(0);
        Query query1 = em.createQuery("Select o from Owner o where o.name like :name");
         query1.setParameter("name", newuser);
         if(query1.getResultList().isEmpty())
         {
        em.getTransaction().begin();
        ow.setName(newuser);
         em.getTransaction().commit();
         request.setAttribute("addoredit", "Username edited succesfully!");   
         request.setAttribute("added", "Old name: "+olduser+" New name: "+newuser);
         }
         else
         {
         request.setAttribute("noparameters", "Username already used!");
         request.getRequestDispatcher("/noparameters.jsp").forward(request, response); 
         }
         
         request.getRequestDispatcher("/addedititem.jsp").forward(request, response);
         em.close();

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
        
        String newuser = request.getParameter("newuser");
        String olduser = request.getParameter("olduser");
EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_OrganizerWeb_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Owner.findByName");
        query.setParameter("name", olduser);
        if(query.getResultList().isEmpty())
        {
         request.setAttribute("noparameters", "User doesn't exists!");
         request.getRequestDispatcher("/noparameters.jsp").forward(request, response); 
        }
        Owner ow = (Owner)query.getResultList().get(0);
        Query query1 = em.createQuery("Select o from Owner o where o.name like :name");
         query1.setParameter("name", newuser);
         if(query1.getResultList().isEmpty())
         {
        em.getTransaction().begin();
        ow.setName(newuser);
         em.getTransaction().commit();
         request.setAttribute("addoredit", "Username edited succesfully!");   
         request.setAttribute("added", "Old name: "+olduser+" New name: "+newuser);
         }
         else
         {
         request.setAttribute("noparameters", "Username already used!");
         request.getRequestDispatcher("/noparameters.jsp").forward(request, response); 
         }
         
         request.getRequestDispatcher("/addedititem.jsp").forward(request, response);
         em.close();

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

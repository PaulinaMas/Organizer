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
import pl.polsl.entities.Event;
import pl.polsl.entities.Owner;

/**
 *
 * @author pauli
 */
@WebServlet(name = "ShowUsersServlet", urlPatterns = {"/ShowUsersServlet"})
public class ShowUsersServlet extends HttpServlet {

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
         Query query = em.createNamedQuery("Owner.findAll");
         List<Owner> results = query.getResultList();
           em.close();
        String temp = "";
        int counter=1;
        for(Owner ev : results)
        {
             temp+="<br><br>Owner nr." + counter;
             temp+=("<br>Id: " + ev.getId());
            temp+=("<br>Name: " + ev.getName());
            counter++;
        }
        if(results.isEmpty())
        {
            temp+="<br>No users!";
        }
         request.setAttribute("finded", temp);
         request.getRequestDispatcher("/showitems.jsp").forward(request, response);

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
         Query query = em.createNamedQuery("Owner.findAll");
         List<Owner> results = query.getResultList();
           em.close();
        String temp = "";
        int counter=1;
        for(Owner ev : results)
        {
             temp+="<br><br>Owner nr." + counter;
             temp+=("<br>Id: " + ev.getId());
            temp+=("<br>Name: " + ev.getName());
            counter++;
        }
        if(results.isEmpty())
        {
            temp+="<br>No users!";
        }
         request.setAttribute("finded", temp);
         request.getRequestDispatcher("/showitems.jsp").forward(request, response);
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

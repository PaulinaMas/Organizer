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
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.polsl.entities.Event;

import pl.polsl.entities.Owner;

/**
 *
 * @author Paulina Maslowska
 * @version 4.0
 */
@WebServlet(name = "SearchEvent", urlPatterns = {"/SearchEvent"})
public class SearchEventServlet extends HttpServlet {
       

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//       // out.print(request.getAttribute("finded"));
//        }
//    }

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
      
     String findname = request.getParameter("findname");
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_OrganizerWeb_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

       String ow = (String)request.getSession().getAttribute("owner");
       
       
       Query query1 = em.createNamedQuery("Owner.findByName");
       query1.setParameter("name", ow);
       Owner own =  (Owner)query1.getResultList().get(0);
       int ido = own.getId();
          Query query = em.createNamedQuery("Event.findByName");
          query.setParameter("name", findname);
          query.setParameter("id", ido);
           List<Event> results = query.getResultList();
        em.close();
        String temp = "";
        int counter=1;
        for(Event ev : results)
        {
             temp+="<br><br>Event nr." + counter;
            temp+=("<br>Name: " + ev.getName());
            temp+=("<br>Date: " + ev.getDate());
            temp+=("<br>Time: " + ev.getTime());
            temp+=("<br>Note: " + ev.getNote());
            temp+=("<br>Priority: " + ev.getPriority());
            counter++;
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

        String findname = request.getParameter("findname");
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_OrganizerWeb_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

       String ow = (String)request.getSession().getAttribute("owner");
       
       
       Query query1 = em.createNamedQuery("Owner.findByName");
       query1.setParameter("name", ow);
       Owner own =  (Owner)query1.getResultList().get(0);
       int ido = own.getId();
          Query query = em.createNamedQuery("Event.findByName");
          query.setParameter("name", findname);
          query.setParameter("id", ido);
           List<Event> results = query.getResultList();
        em.close();
        String temp = "";
        int counter=1;
        for(Event ev : results)
        {
             temp+="<br><br>Event nr." + counter;
            temp+=("<br>Name: " + ev.getName());
            temp+=("<br>Date: " + ev.getDate());
            temp+=("<br>Time: " + ev.getTime());
            temp+=("<br>Note: " + ev.getNote());
            temp+=("<br>Priority: " + ev.getPriority());
            counter++;
        }

        request.setAttribute("finded", temp);
        //processRequest(request, response);
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

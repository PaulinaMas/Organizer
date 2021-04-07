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
@WebServlet(name = "EditEvent", urlPatterns = {"/EditEvent"})
public class EditEventServlet extends HttpServlet {

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
        String editid = request.getParameter("editid");
        String addname = request.getParameter("addname");
         String adddate = request.getParameter("adddate");
         String addtime = request.getParameter("addtime");
         String addnote = request.getParameter("addnote");
         String addpriority = request.getParameter("priority");

    String ow = (String)request.getSession().getAttribute("owner");
    Query query1 = em.createNamedQuery("Owner.findByName");
       query1.setParameter("name", ow);
       Owner own =  (Owner)query1.getResultList().get(0);
       int ido = own.getId();
       
       try{
       int editidint = Integer.parseInt(editid);
       Query query = em.createNamedQuery("Event.findById");
          query.setParameter("id", editidint);
          query.setParameter("ide", ido);
          if(query.getResultList().isEmpty())
          {
              request.setAttribute("addoredit", "Item doesn't exists!");   
         request.setAttribute("added", "Wrong ID");
          }
          else
          {
               Event result = (Event)query.getResultList().get(0);
               em.getTransaction().begin();
    result.setDate(adddate);
    result.setName(addname);
    result.setNote(addnote);
    result.setPriority(addpriority);
    result.setTime(addtime);
    em.getTransaction().commit();
    
      String temp = "";
            temp+=("<br>Name: " + result.getName());
            temp+=("<br>Date: " + result.getDate());
            temp+=("<br>Time: " + result.getTime());
            temp+=("<br>Note: " + result.getNote());
            temp+=("<br>Priority: " + result.getPriority());
          request.setAttribute("addoredit", "Item edited succesfully!");   
         request.setAttribute("added", temp);
          }
          em.close();
       }
       catch(NumberFormatException nfe){
            request.setAttribute("addoredit", "Wrong ID");   
         request.setAttribute("added", "Enter a valid ID");
         request.getRequestDispatcher("/addedititem.jsp").forward(request, response);
         em.close();
       }
       
          
   
         request.getRequestDispatcher("/addedititem.jsp").forward(request, response);

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
        String editid = request.getParameter("editid");
        String addname = request.getParameter("addname");
         String adddate = request.getParameter("adddate");
         String addtime = request.getParameter("addtime");
         String addnote = request.getParameter("addnote");
         String addpriority = request.getParameter("priority");

    String ow = (String)request.getSession().getAttribute("owner");
    Query query1 = em.createNamedQuery("Owner.findByName");
       query1.setParameter("name", ow);
       Owner own =  (Owner)query1.getResultList().get(0);
       int ido = own.getId();
       
       try{
       int editidint = Integer.parseInt(editid);
       Query query = em.createNamedQuery("Event.findById");
          query.setParameter("id", editidint);
          query.setParameter("ide", ido);
          if(query.getResultList().isEmpty())
          {
              request.setAttribute("addoredit", "Item doesn't exists!");   
         request.setAttribute("added", "Wrong ID");
          }
          else
          {
               Event result = (Event)query.getResultList().get(0);
               em.getTransaction().begin();
    result.setDate(adddate);
    result.setName(addname);
    result.setNote(addnote);
    result.setPriority(addpriority);
    result.setTime(addtime);
    em.getTransaction().commit();
    
      String temp = "";
            temp+=("<br>Name: " + result.getName());
            temp+=("<br>Date: " + result.getDate());
            temp+=("<br>Time: " + result.getTime());
            temp+=("<br>Note: " + result.getNote());
            temp+=("<br>Priority: " + result.getPriority());
          request.setAttribute("addoredit", "Item edited succesfully!");   
         request.setAttribute("added", temp);
          }
          em.close();
       }
       catch(NumberFormatException nfe){
            request.setAttribute("addoredit", "Wrong ID");   
         request.setAttribute("added", "Enter a valid ID");
         request.getRequestDispatcher("/addedititem.jsp").forward(request, response);
         em.close();
       }
       
          
   
         request.getRequestDispatcher("/addedititem.jsp").forward(request, response);

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

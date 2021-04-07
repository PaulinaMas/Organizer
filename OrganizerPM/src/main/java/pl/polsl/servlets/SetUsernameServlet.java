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
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.polsl.exception.NoParametersException;
import pl.polsl.entities.Owner;

/**
 *
 * @author pauli
 */
@WebServlet(name = "SetUsername", urlPatterns = {"/SetUsername"})
public class SetUsernameServlet extends HttpServlet {
     
 public void persist(Object object, EntityManager em) {
       // EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_OrganizerWeb_war_1.0-SNAPSHOTPU");
        //EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } 
    }
     

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        }
    }

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
        
        String username = request.getParameter("username");
        try{
            validateUsername(username);
        }
        catch(NoParametersException e){
            em.close();
             request.setAttribute("noparameters", "No username was set!");
            request.getRequestDispatcher("/noparameters.jsp").forward(request, response);  
        }
        Query query = em.createNamedQuery("Owner.findByName");
        query.setParameter("name", username);
        if(query.getResultList().isEmpty())
        {
        Owner owner = new Owner();
        SetUsernameServlet s = new SetUsernameServlet();
        owner.setName(username);
        s.persist(owner, em);
        em.close();
        
        }
        request.getSession().setAttribute("owner", username);
        request.setAttribute("owner", username);
        request.getRequestDispatcher("/mainpage.jsp").forward(request, response);  
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private void validateUsername(String username) throws NoParametersException
    {
        if(username.isEmpty())
        {
            throw new NoParametersException();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_OrganizerWeb_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        String username = request.getParameter("username");
        try{
            validateUsername(username);
        }
        catch(NoParametersException e){
            em.close();
             request.setAttribute("noparameters", "No username was set!");
            request.getRequestDispatcher("/noparameters.jsp").forward(request, response);  
        }
        Query query = em.createNamedQuery("Owner.findByName");
        query.setParameter("name", username);
        if(query.getResultList().isEmpty())
        {
        Owner owner = new Owner();
        SetUsernameServlet s = new SetUsernameServlet();
        owner.setName(username);
        s.persist(owner, em);
        em.close();
        
        }
        request.getSession().setAttribute("owner", username);
        request.setAttribute("owner", username);
        request.getRequestDispatcher("/mainpage.jsp").forward(request, response);  
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

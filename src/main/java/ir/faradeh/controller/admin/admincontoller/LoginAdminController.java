/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.controller.admin.admincontoller;

import ir.faradeh.business.internal.AdminBusiness;
import ir.faradeh.exception.NotFoundUsernameException;
import ir.faradeh.exception.WrongPasswordException;
import ir.faradeh.model.entity.AdminEntity;
import ir.faradeh.utility.UtilMethod;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mohammad
 */
@WebServlet(name = "LoginAdminController", urlPatterns = {"/loginadmin"})
public class LoginAdminController extends HttpServlet {

    @EJB
    private AdminBusiness adminBusiness;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");

        try {
            AdminEntity entity = adminBusiness.loginAdmin(username, UtilMethod.hash(password));
            HttpSession session = request.getSession();
            session.setAttribute("user", entity);
            response.sendRedirect("/Faradeh/privates/admin/dashboard.html");
        } catch (NotFoundUsernameException | WrongPasswordException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            request.getRequestDispatcher("/err/error.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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

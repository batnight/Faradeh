/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.controller.admin.institutioncontroller;

import ir.faradeh.business.internal.InstitutionBusiness;
import ir.faradeh.exception.FailedDeleteInstitutionException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohammad
 */
@WebServlet(name = "DeleteInstitutionController", urlPatterns = {"/privates/admin/deleteinstitution"})
public class DeleteInstitutionController extends HttpServlet {

    @EJB
    private InstitutionBusiness institutionBusiness;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
String id = request.getParameter("Id");
        try {
            institutionBusiness.deleteInstitution(id);
            response.sendRedirect("/Faradeh/privates/admin/institutions");
        } catch (FailedDeleteInstitutionException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            request.getRequestDispatcher("/err/error.jsp").forward(request, response);
        }
    }

}

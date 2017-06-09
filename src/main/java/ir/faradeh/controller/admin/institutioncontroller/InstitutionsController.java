/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ir.faradeh.controller.admin.institutioncontroller;

import ir.faradeh.business.internal.InstitutionBusiness;
import ir.faradeh.exception.ExistInstitutionNameException;
import ir.faradeh.exception.FailedCreateInstitutionException;
import ir.faradeh.model.entity.InstitutionEntity;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "InstitutionsController", urlPatterns = {"/privates/admin/institutions"})
public class InstitutionsController extends HttpServlet {

    @EJB
    private InstitutionBusiness institutionBusiness;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<InstitutionEntity> list = institutionBusiness.findAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/privates/admin/institutions.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InstitutionEntity institutionEntity = new InstitutionEntity();
        institutionEntity.setInstitutionAddress(request.getParameter("InstitutionAddress"));
        institutionEntity.setInstitutionEmail(request.getParameter("InstitutionEmail"));
        institutionEntity.setInstitutionName(request.getParameter("InstitutionName"));
        institutionEntity.setInstitutionPhoneNumber(request.getParameter("InstitutionPhoneNumber"));
        institutionEntity.setInstitutionWebsite(request.getParameter("InstitutionWebsite"));

        try {
            institutionBusiness.add(institutionEntity);
            doGet(request, response);
        } catch (ExistInstitutionNameException | FailedCreateInstitutionException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            request.getRequestDispatcher("/err/error.jsp").forward(request, response);
        }

    }

}

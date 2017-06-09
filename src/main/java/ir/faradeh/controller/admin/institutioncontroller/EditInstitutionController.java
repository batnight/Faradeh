/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.controller.admin.institutioncontroller;

import ir.faradeh.business.internal.InstitutionBusiness;
import ir.faradeh.exception.FailedEditInstitutionException;
import ir.faradeh.model.entity.InstitutionEntity;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
@WebServlet(name = "EditInstitutionController", urlPatterns = {"/privates/admin/editinstitution"})
public class EditInstitutionController extends HttpServlet {

    @EJB
    private InstitutionBusiness institutionBusiness;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InstitutionEntity entity;
        String id = req.getParameter("Id");
        entity = institutionBusiness.getById(id);
        req.setAttribute("entity", entity);

        req.getRequestDispatcher("/privates/admin/institution.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> param = new HashMap<>();
        Map map = req.getParameterMap();

        for (Object key : map.keySet()) {
            if (!((String) key).equalsIgnoreCase("id")) {
                param.put((String) key, req.getParameter((String) key));
            }
        }
        String id = req.getParameter("Id");

        try {
            institutionBusiness.editInstitution(id, param);
            resp.sendRedirect("/Faradeh/privates/admin/institutions");
        } catch (FailedEditInstitutionException ex) {
            req.setAttribute("errorMessage", ex.getMessage());
            req.getRequestDispatcher("/err/error.jsp").forward(req, resp);
        }
    }

}

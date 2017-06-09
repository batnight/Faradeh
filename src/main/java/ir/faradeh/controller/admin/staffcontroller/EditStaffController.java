/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.controller.admin.staffcontroller;

import ir.faradeh.business.internal.PersonBusiness;
import ir.faradeh.exception.FailedEditUserException;
import ir.faradeh.model.entity.AccountEntity;
import ir.faradeh.model.entity.PersonEntity;
import ir.faradeh.utility.UtilMethod;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
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
@WebServlet(name = "EditStaffController", urlPatterns = {"/private/admin/staff/edit"})
public class EditStaffController extends HttpServlet {

    @EJB
    private PersonBusiness personBusiness;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("Id");

        PersonEntity entity = personBusiness.getPersonById(id);

        req.setAttribute("entity", entity);
        req.getRequestDispatcher("/privates/admin/staff/staff.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HashMap<String, Object> personParam = new HashMap<>();
        HashMap<String, Object> accountParam = new HashMap<>();
        Map map = req.getParameterMap();
        for (Object key : map.keySet()) {
            if (!((String) key).equalsIgnoreCase("id") && !((String) key).equalsIgnoreCase("password") && !((String) key).equalsIgnoreCase("username")) {
                personParam.put((String) key, req.getParameter((String) key));
            }
        }
        AccountEntity accountEntity = personBusiness.selectAccountByUsername(req.getParameter("NationalId"));
        accountParam.put("Username", req.getParameter("NationalId"));
        if (!req.getParameter("Password").equals("")) {
            accountParam.put("Password", UtilMethod.hash(req.getParameter("Password")));
        }

        String personId = req.getParameter("PersonId");
        String accountId = req.getParameter("AccountId");

        try {
            personBusiness.editPerson(accountId, accountParam, personId, personParam);
            resp.sendRedirect("/Faradeh/privates/admin/staff/staffs");
        } catch (FailedEditUserException ex) {
            req.setAttribute("errorMessage", ex.getMessage());
            req.getRequestDispatcher("/err/error.jsp").forward(req, resp);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.controller.admin.admincontoller;

import ir.faradeh.business.internal.AdminBusiness;
import ir.faradeh.exception.FailedEditUserException;
import ir.faradeh.model.entity.AdminEntity;
import ir.faradeh.utility.UtilMethod;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EditAdminController", urlPatterns = {"/privates/admin/editadmin"})
public class EditAdminController extends HttpServlet {

    @EJB
    private AdminBusiness adminBusiness;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminEntity adminEntity;
        String id = request.getParameter("Id");
        adminEntity = adminBusiness.getAdminById(id);
        request.setAttribute("entity", adminEntity);

        request.getRequestDispatcher("/Faradeh/privates/admin/admin.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HashMap<String, Object> param = new HashMap<>();
        Map map = request.getParameterMap();
        for (Object key : map.keySet()) {
            if (!((String) key).equalsIgnoreCase("id") && !((String) key).equalsIgnoreCase("password")) {
                param.put((String) key, request.getParameter((String) key));
            }
        }
        if (!request.getParameter("Password").equals("")) {
            param.put("Password", UtilMethod.hash(request.getParameter("Password")));
        }
        String id = request.getParameter("Id");
        try {
            adminBusiness.editAdmin(id, param);
            response.sendRedirect("/Faradeh/privates/admin/admins");
        } catch (FailedEditUserException e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/err/error.jsp").forward(request, response);
        }
    }

}

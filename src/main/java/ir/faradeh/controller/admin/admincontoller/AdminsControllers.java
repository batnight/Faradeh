/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.controller.admin.admincontoller;

import ir.faradeh.business.internal.AdminBusiness;
import ir.faradeh.exception.ExistEmailException;
import ir.faradeh.exception.ExistUsernameException;
import ir.faradeh.exception.FailedDeleteUserException;
import ir.faradeh.exception.FailedEditUserException;
import ir.faradeh.exception.FailedRegisterException;
import ir.faradeh.model.entity.AdminEntity;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
@WebServlet(name = "AdminsControllers", urlPatterns = {"/privates/admin/admins"})
public class AdminsControllers extends HttpServlet {

    @EJB
    private AdminBusiness adminBusiness;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<AdminEntity> list = adminBusiness.getListOfAdmins();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/privates/admin/admins.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminEntity entity = new AdminEntity();
        entity.setUsername(request.getParameter("Username"));
        entity.setPassword(request.getParameter("Password"));
        entity.setEmail(request.getParameter("Email"));
        entity.setMobileNumber(request.getParameter("MobileNumber"));
        entity.setHomeNumber(request.getParameter("HomeNumber"));
        entity.setFirstName(request.getParameter("FirstName"));
        entity.setLastName(request.getParameter("LastName"));

        try {
            adminBusiness.registerAdmin(entity);
            doGet(request, response);
        } catch (ExistUsernameException | ExistEmailException | FailedRegisterException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            request.getRequestDispatcher("/err/error.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminEntity adminEntity = new AdminEntity();
        HashMap<String, Object> param = new HashMap<>();
        Map map = req.getParameterMap();
        for (Object key : map.keySet()) {
            if (!((String) key).equalsIgnoreCase("id")) {
                param.put((String) key, req.getParameter((String) key));
            }
        }
        String id = req.getParameter("Id");
        try {
            adminBusiness.editAdmin(id, param);
        } catch (FailedEditUserException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("/err/error.jsp").forward(req, resp);
        }
    }

}

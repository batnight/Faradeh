/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.controller.admin.rolecontroller;

import ir.faradeh.business.internal.RoleBusiness;
import ir.faradeh.exception.FailedEditRoleException;
import ir.faradeh.model.entity.RoleEntity;
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
@WebServlet(name = "EditRoleController", urlPatterns = {"/privates/admin/role/edit"})
public class EditRoleController extends HttpServlet {

    @EJB
    private RoleBusiness roleBusiness;

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
            roleBusiness.edit(id, param);
            resp.sendRedirect("/Faradeh/privates/admin/role/roles");
        } catch (FailedEditRoleException ex) {
            req.setAttribute("errorMessage", ex.getMessage());
            req.getRequestDispatcher("/privates/err/error.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoleEntity entity;
        String id = req.getParameter("Id");
        entity = roleBusiness.getById(id);

        req.setAttribute("entity", entity);

        req.getRequestDispatcher("/privates/admin/role/role.jsp").forward(req, resp);
    }

}

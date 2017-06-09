/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.controller.admin.rolecontroller;

import ir.faradeh.business.internal.RoleBusiness;
import ir.faradeh.exception.ExistRoleNameException;
import ir.faradeh.exception.FailedCreateRoleException;
import ir.faradeh.model.entity.RoleEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "RolesController", urlPatterns = {"/privates/admin/role/roles"})
public class RolesController extends HttpServlet {
    @EJB
    private RoleBusiness roleBusiness;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RoleEntity> list = roleBusiness.findAll();
        req.setAttribute("list", list);
        
        req.getRequestDispatcher("/privates/admin/role/roles.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoleEntity roleEntity = new RoleEntity();
        
        roleEntity.setRoleNameEn(req.getParameter("RoleNameEN"));
        roleEntity.setRoleNameFa(req.getParameter("RoleNameFA"));
        
        try {
            roleBusiness.add(roleEntity);
            resp.sendRedirect("/Faradeh/privates/admin/role/roles");
        } catch (ExistRoleNameException | FailedCreateRoleException ex) {
            req.setAttribute("errorMessage", ex.getMessage());
            req.getRequestDispatcher("/privates/err/error.jsp").forward(req, resp);
        }
    }

}

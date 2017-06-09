/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.controller.admin.staffcontroller;

import ir.faradeh.business.internal.InstitutionBusiness;
import ir.faradeh.business.internal.RoleBusiness;
import ir.faradeh.model.entity.InstitutionEntity;
import ir.faradeh.model.entity.RoleEntity;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ProviceAddStaffFormController", urlPatterns = {"/private/admin/staff/provide"})
public class ProviceAddStaffFormController extends HttpServlet {

    @EJB
    private RoleBusiness roleBusiness;
    @EJB
    private InstitutionBusiness institutionBusiness;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RoleEntity> listOfRole = roleBusiness.findAll();
        List<InstitutionEntity> listOfInstitution = institutionBusiness.findAll();
        
        req.setAttribute("listOfRole", listOfRole);
        req.setAttribute("listOfInstitution", listOfInstitution);
        
        req.getRequestDispatcher("/privates/admin/staff/addstaff.jsp").forward(req, resp);
    }

}

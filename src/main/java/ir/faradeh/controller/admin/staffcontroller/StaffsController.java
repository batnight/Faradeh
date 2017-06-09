/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.controller.admin.staffcontroller;

import ir.faradeh.business.internal.PersonBusiness;
import ir.faradeh.exception.FailedRegisterException;
import ir.faradeh.model.entity.AccountEntity;
import ir.faradeh.model.entity.PersonEntity;
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
@WebServlet(name = "StaffsController", urlPatterns = {"/privates/admin/staff/staffs"})
public class StaffsController extends HttpServlet {
    
    @EJB
    private PersonBusiness personBusiness;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PersonEntity> list = personBusiness.findAllPerson();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/private/admin/staff/staffs.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersonEntity entity = new PersonEntity();
        AccountEntity accountEntity = new AccountEntity();
        
        entity.setFirstName(req.getParameter("FirstName"));
        entity.setLastName(req.getParameter("LastName"));
        entity.setMobileNumber(req.getParameter("MobileNumber"));
        entity.setEmail(req.getParameter("Email"));
        entity.setBirthCertificate(req.getParameter("BirthCertification"));
        entity.setNationalId(req.getParameter("NationalId"));
        entity.setPlaceOfBirth(req.getParameter("PlaceOfBirth"));
        
        accountEntity.setUsername(req.getParameter("NationalId"));
        accountEntity.setPassword(req.getParameter("NationalId"));
        
        String institutionName = req.getParameter("InstitutionName");
        String roleName = req.getParameter("RoleNameFA");
        
        try {
            personBusiness.addPerson(accountEntity, entity, roleName, institutionName);
            resp.sendRedirect("/Faradeh/private/admin/staff/staffs");
        } catch (FailedRegisterException ex) {
           req.setAttribute("errorMessage", ex.getMessage());
           req.getRequestDispatcher("/err/error.jsp").forward(req, resp);
        }
        
    }
    
}

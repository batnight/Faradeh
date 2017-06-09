/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.business.internal;

import ir.faradeh.dao.impl.AdminDao;
import ir.faradeh.exception.ExistEmailException;
import ir.faradeh.exception.ExistUsernameException;
import ir.faradeh.exception.FailedDeleteUserException;
import ir.faradeh.exception.FailedEditUserException;
import ir.faradeh.exception.FailedRegisterException;
import ir.faradeh.exception.NotFoundUsernameException;
import ir.faradeh.exception.WrongPasswordException;
import ir.faradeh.model.entity.AdminEntity;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import org.bson.types.ObjectId;

/**
 *
 * @author Mohammad
 */
@Stateless
public class AdminBusiness {

    public List<AdminEntity> getListOfAdmins() {
        AdminDao adminDao = new AdminDao(AdminEntity.class);

        return adminDao.findList(null);
    }

    public AdminEntity getAdminById(String id) {
        HashMap<String, Object> param = new HashMap<>();
        AdminDao adminDao = new AdminDao(AdminEntity.class);

        param.put("_id", new ObjectId(id));

        return adminDao.find(param);
    }

    private AdminEntity getAdminByEmail(String email) {
        HashMap<String, Object> param = new HashMap<>();
        AdminDao adminDao = new AdminDao(AdminEntity.class);

        param.put("Email", email);

        return adminDao.find(param);
    }

    private AdminEntity getAdminByUsername(String username) {
        HashMap<String, Object> param = new HashMap<>();
        AdminDao adminDao = new AdminDao(AdminEntity.class);

        param.put("Username", username);

        return adminDao.find(param);
    }

    public AdminEntity getAdminByUsernameAndPassword(String username, String password) {
        HashMap<String, Object> param = new HashMap<>();
        AdminDao adminDao = new AdminDao(AdminEntity.class);

        param.put("Username", username);
        param.put("Password", password);

        return adminDao.find(param);
    }

    public AdminEntity registerAdmin(AdminEntity adminEntity) throws ExistUsernameException, ExistEmailException, FailedRegisterException {
        if (getAdminByEmail(adminEntity.getEmail()) != null) {
            throw new ExistEmailException();
        }
        if (getAdminByUsername(adminEntity.getUsername()) != null) {
            throw new ExistUsernameException();
        }
        AdminDao adminDao = new AdminDao(AdminEntity.class);
        adminEntity.setCreateDate(new Date());

        AdminEntity entity;
        if ((entity = adminDao.insert(adminEntity)) != null) {
            return entity;
        } else {
            throw new FailedRegisterException();
        }
    }

    public AdminEntity loginAdmin(String username, String password) throws NotFoundUsernameException, WrongPasswordException {
        if (getAdminByUsername(username) == null) {
            throw new NotFoundUsernameException();
        }
        AdminEntity entity;
        if ((entity = getAdminByUsernameAndPassword(username, password)) != null) {
            return entity;
        } else {
            throw new WrongPasswordException();
        }
    }

    public AdminEntity editAdmin(String id, HashMap<String, Object> parameter) throws FailedEditUserException {
        AdminDao dao = new AdminDao(AdminEntity.class);
        AdminEntity entity;
        if ((entity = dao.merge(new ObjectId(id), parameter)) != null) {
            return entity;
        } else {
            throw new FailedEditUserException();
        }
    }

    public boolean deleteAdmin(String id) throws FailedDeleteUserException {
        AdminDao ad = new AdminDao(AdminEntity.class);
        if (ad.delete(new ObjectId(id))) {
            return true;
        } else {
            throw new FailedDeleteUserException();
        }
    }
}

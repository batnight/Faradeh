/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.business.internal;

import ir.faradeh.dao.impl.RoleDao;
import ir.faradeh.exception.ExistRoleNameException;
import ir.faradeh.exception.FailedCreateRoleException;
import ir.faradeh.exception.FailedDeleteRoleException;
import ir.faradeh.exception.FailedEditRoleException;
import ir.faradeh.model.entity.RoleEntity;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import org.bson.types.ObjectId;

/**
 *
 * @author Mohammad
 */
@Stateless
public class RoleBusiness {

    RoleDao roleDao = null;

    public RoleBusiness() {
        roleDao = new RoleDao(RoleEntity.class);
    }

    public RoleEntity getByName(RoleEntity entity) {
        HashMap<String, Object> param = new HashMap<>();
        if (entity.getRoleNameFa() != null) {
            param.put("RoleNameFA", entity.getRoleNameFa());
        }
        if (entity.getRoleNameEn() != null) {
            param.put("RoleNameEN", entity.getRoleNameEn());
        }
        return roleDao.find(param);
    }

    public RoleEntity add(RoleEntity entity) throws ExistRoleNameException, FailedCreateRoleException {
        if (getByName(entity) != null) {
            throw new ExistRoleNameException();
        }
        RoleEntity roleEntity;

        if ((roleEntity = roleDao.insert(entity)) != null) {
            return roleEntity;
        } else {
            throw new FailedCreateRoleException();
        }
    }

    public RoleEntity edit(String id, HashMap<String, Object> param) throws FailedEditRoleException {
        RoleEntity entity;
        if ((entity = roleDao.merge(new ObjectId(id), param)) != null) {
            return entity;
        } else {
            throw new FailedEditRoleException();
        }
    }

    public List<RoleEntity> findAll() {
        return roleDao.findList(null);
    }

    public boolean delete(String id) throws FailedDeleteRoleException {
        if (roleDao.delete(new ObjectId(id))) {
            return true;
        } else {
            throw new FailedDeleteRoleException();
        }
    }

}

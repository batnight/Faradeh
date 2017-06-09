/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ir.faradeh.dao.impl;

import ir.faradeh.dao.AbstractFacade;
import ir.faradeh.model.entity.RoleEntity;

/**
 *
 * @author Mohammad
 */
public class RoleDao extends AbstractFacade<RoleEntity>{

    public RoleDao(Class<RoleEntity> entityClass) {
        super(entityClass);
    }
    
}

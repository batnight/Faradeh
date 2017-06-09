/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ir.faradeh.dao.impl;

import ir.faradeh.dao.AbstractFacade;
import ir.faradeh.model.entity.PersonEntity;

/**
 *
 * @author Mohammad
 */
public class PersonDao extends AbstractFacade<PersonEntity>{

    public PersonDao(Class<PersonEntity> entityClass) {
        super(entityClass);
    }
    
}

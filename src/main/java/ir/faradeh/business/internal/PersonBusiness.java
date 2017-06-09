/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.business.internal;

import ir.faradeh.dao.impl.AccountDao;
import ir.faradeh.dao.impl.PersonDao;
import ir.faradeh.exception.FailedDeleteUserException;
import ir.faradeh.exception.FailedEditUserException;
import ir.faradeh.exception.FailedRegisterException;
import ir.faradeh.model.entity.AccountEntity;
import ir.faradeh.model.entity.InstitutionEntity;
import ir.faradeh.model.entity.PersonEntity;
import ir.faradeh.model.entity.RoleEntity;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.bson.types.ObjectId;

/**
 *
 * @author Mohammad
 */
@Stateless
public class PersonBusiness {

    @EJB
    private RoleBusiness roleBusiness;
    @EJB
    private InstitutionBusiness institutionBusiness;

    PersonDao personDao = null;
    AccountDao accountDao = null;

    public PersonBusiness() {
        personDao = new PersonDao(PersonEntity.class);
        accountDao = new AccountDao(AccountEntity.class);
    }

    public AccountEntity selectAccountByUsernameAndPassword(String username, String password) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("Username", username);
        param.put("Password", password);
        return accountDao.find(param);
    }

    public AccountEntity selectAccountByUsername(String username) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("Username", username);

        return accountDao.find(param);
    }

    public boolean removePerson(String id) throws FailedDeleteUserException {
        if (personDao.delete(new ObjectId(id))) {
            return true;
        } else {
            throw new FailedDeleteUserException();
        }
    }

    public List<PersonEntity> findAllPerson() {
        return personDao.findList(null);
    }

    public PersonEntity getPersonById(String id) {
        HashMap<String, Object> personsParam = new HashMap<>();
        personsParam.put("_id", new ObjectId(id));

        return personDao.find(personsParam);
    }

    public List<PersonEntity> findAllPersonByAccount(AccountEntity entity) {
        HashMap<String, Object> personsParam = new HashMap<>();
        personsParam.put("account", entity);

        return personDao.findList(personsParam);
    }

    public PersonEntity addPerson(AccountEntity accountEntity, PersonEntity personEntity, String roleName, String InstitutionName) throws FailedRegisterException {
        AccountEntity account;
        RoleEntity role = new RoleEntity();
        role.setRoleNameFa(roleName);

        InstitutionEntity institutionEntity = institutionBusiness.getByName(InstitutionName);
        RoleEntity roleEntity = roleBusiness.getByName(role);

        account = selectAccountByUsername(accountEntity.getUsername());
        if (account == null) {
            account = accountDao.insert(accountEntity);
        }
        personEntity.setAccount(account);
        personEntity.setRole(roleEntity);
        personEntity.setInstitution(institutionEntity);
        List<PersonEntity> listPerson;
        if ((listPerson = findAllPersonByAccount(account)) != null) {
            for (PersonEntity pe : listPerson) {
                if (personEntity.isDefaultInstitution()) {
                    HashMap<String, Object> params = new HashMap<>();
                    params.put("DefaultInstitution", false);
                    personDao.merge(pe.getId(), params);
                }
            }
        }
        personEntity.setDefaultInstitution(true);

        PersonEntity person;
        if ((person = personDao.insert(personEntity)) != null) {
            return person;
        } else {
            throw new FailedRegisterException();
        }

    }

    public List<PersonEntity> findAllPersonByInstitution(String institution) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("institution", institutionBusiness.getByName(institution));
        return personDao.findList(param);
    }

    public PersonEntity editPerson(String accountId, HashMap<String, Object> accountParam, String personId, HashMap<String, Object> personParam) throws FailedEditUserException {
        PersonEntity personEntity;

        if (accountDao.merge(new ObjectId(accountId), accountParam) != null) {

            if ((personEntity = personDao.merge(new ObjectId(personId), personParam)) != null) {
                return personEntity;
            } else {
                throw new FailedEditUserException();
            }
        } else {
            throw new FailedEditUserException();
        }
    }

    public PersonEntity editPerson(ObjectId personId, HashMap<String, Object> personParam) throws FailedEditUserException {
        PersonEntity personEntity = null;
        if ((personEntity = personDao.merge(personId, personParam)) != null) {
            return personEntity;
        } else {
            throw new FailedEditUserException();
        }
    }

}

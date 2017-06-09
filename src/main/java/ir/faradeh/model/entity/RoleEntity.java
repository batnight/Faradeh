/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.model.entity;


import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 *
 * @author sorena
 */
@Entity("role")
public class RoleEntity {

    @Id
    private ObjectId _id;
    @Property("RoleNameFA")
    private String roleNameFa;
    @Property("RoleNameEN")
    private String roleNameEN;

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getRoleNameFa() {
        return roleNameFa;
    }

    public void setRoleNameFa(String roleNameFa) {
        this.roleNameFa = roleNameFa;
    }

    public String getRoleNameEn() {
        return roleNameEN;
    }

    public void setRoleNameEn(String roleNameEN) {
        this.roleNameEN = roleNameEN;
    }

}

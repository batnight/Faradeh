/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.model.entity;


import ir.faradeh.utility.UtilMethod;
import java.util.Date;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 *
 * @author sorena
 */
@Entity("admin")
public class AdminEntity {

    @Id
    private ObjectId _id;
    @Property("FirstName")
    private String firstName;
    @Property("LastName")
    private String lastName;
    @Property("Email")
    private String email;
    @Property("HomeNumber")
    private String homeNumber;
    @Property("MobileNumber")
    private String mobileNumber;
    @Property("Username")
    private String username;
    @Property("Password")
    private String password;
    @Property("CreateDate")
    private Date createDate;
    @Property("ModifyDate")
    private Date modifyDate;

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public void setPassword(String password) {
        this.password = UtilMethod.hash(password);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

}

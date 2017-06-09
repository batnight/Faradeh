/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.model.entity;


import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 *
 * @author sorena
 */
@Entity("institution")
public class InstitutionEntity {

    @Id
    private ObjectId _id;
    @Property("InstitutionName")
    private String institutionName;
    @Property("InstitutionAddress")
    private String institutionAddress;
    @Property("InstitutionPhoneNumber")
    private String institutionPhoneNumber;
    @Property("InstitutionWebsite")
    private String institutionWebsite;
    @Property("InstitutionEmail")
    private String institutionEmail;
    @Property("CreateDate")
    private Date createDate;
    @Property("ModifyDate")
    private Date modifyDate;
    @Embedded
    private List<SemesterEntity> semesters;
    @Embedded
    private List<ProgramEntity> programs;
    @Embedded
    private List<RoomEntity> rooms;

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInstitutionAddress() {
        return institutionAddress;
    }

    public void setInstitutionAddress(String institutionAddress) {
        this.institutionAddress = institutionAddress;
    }

    public String getInstitutionPhoneNumber() {
        return institutionPhoneNumber;
    }

    public void setInstitutionPhoneNumber(String institutionPhoneNumber) {
        this.institutionPhoneNumber = institutionPhoneNumber;
    }

    public String getInstitutionWebsite() {
        return institutionWebsite;
    }

    public void setInstitutionWebsite(String institutionWebsite) {
        this.institutionWebsite = institutionWebsite;
    }

    public String getInstitutionEmail() {
        return institutionEmail;
    }

    public void setInstitutionEmail(String institutionEmail) {
        this.institutionEmail = institutionEmail;
    }

    public List<SemesterEntity> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<SemesterEntity> semesters) {
        this.semesters = semesters;
    }

    public List<ProgramEntity> getPrograms() {
        return programs;
    }

    public void setPrograms(List<ProgramEntity> programs) {
        this.programs = programs;
    }

    public List<RoomEntity> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomEntity> rooms) {
        this.rooms = rooms;
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

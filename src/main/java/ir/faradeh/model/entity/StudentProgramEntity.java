/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.model.entity;
 
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
 
//@Embedded
public class StudentProgramEntity {

    @Id
    private ObjectId id;

    @Property("ProgramName")
    private String programName;
    @Embedded
    private List<StudentSemesterEntity> semesters;

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getId() {
        return id;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramName() {
        return programName;
    }

    public List<StudentSemesterEntity> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<StudentSemesterEntity> semesters) {
        this.semesters = semesters;
    }

    public StudentProgramEntity() {
    }

}

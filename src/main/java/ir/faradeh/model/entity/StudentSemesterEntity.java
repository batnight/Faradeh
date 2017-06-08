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
public class StudentSemesterEntity {

    @Id
    private ObjectId id;

    @Property("Semester")
    private String semester;
    @Embedded
    private List<StudentClassEntity> classes;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSemester() {
        return semester;
    }

    public List<StudentClassEntity> getClasses() {
        return classes;
    }

    public void setClasses(List<StudentClassEntity> classes) {
        this.classes = classes;
    }

    public StudentSemesterEntity() {
    }

}

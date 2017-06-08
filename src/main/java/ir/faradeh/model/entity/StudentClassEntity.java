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
import org.mongodb.morphia.annotations.Reference;


 
public class StudentClassEntity {

    @Id
    private ObjectId _id;
    @Property("Grade")
    private float grade;
    @Embedded
    private List<TuitionEntity> tuitions;
    @Reference
    private ClassEntity classReferences;

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public List<TuitionEntity> getTuitions() {
        return tuitions;
    }

    public void setTuitions(List<TuitionEntity> tuitions) {
        this.tuitions = tuitions;
    }

    public ClassEntity getClassReferences() {
        return classReferences;
    }

    public void setClassReferences(ClassEntity classReferences) {
        this.classReferences = classReferences;
    }

}

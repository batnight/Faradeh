/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.model.entity;


import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 *
 * @author sorena
 */

public class CourseEntity {

    @Id
    private ObjectId _id;
    @Property("CourseName")
    private String courseName;
    @Property("CourseId")
    private String courseId;
    @Embedded
    private List<CourseTypeEntity> courseTypes;

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public List<CourseTypeEntity> getCourseType() {
        return courseTypes;
    }

    public void setCourseType(List<CourseTypeEntity> courseType) {
        this.courseTypes = courseType;
    }

    public CourseEntity() {
    }

}

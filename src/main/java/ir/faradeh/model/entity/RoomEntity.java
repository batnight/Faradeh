/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.faradeh.model.entity;

 
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 *
 * @author sorena
 */
 
public class RoomEntity {

    @Id
    private ObjectId id;
    @Property("RoomName")
    private String roomName;
    @Property("RoomEducationCapacity")
    private int roomEducationCapacity;//ظرفیت آموزشی کلاس
    @Property("RoomExaminationCapacity")
    private int roomExaminationCapacity;//ظرفیت کلاس برای امتحان
    @Property("HasVideoProjector")
    private boolean hasVideoProjector;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomEducationCapacity() {
        return roomEducationCapacity;
    }

    public void setRoomEducationCapacity(int roomEducationCapacity) {
        this.roomEducationCapacity = roomEducationCapacity;
    }

    public int getRoomExaminationCapacity() {
        return roomExaminationCapacity;
    }

    public void setRoomExaminationCapacity(int roomExaminationCapacity) {
        this.roomExaminationCapacity = roomExaminationCapacity;
    }

    public boolean isHasVideoProjector() {
        return hasVideoProjector;
    }

    public void setHasVideoProjector(boolean hasVideoProjector) {
        this.hasVideoProjector = hasVideoProjector;
    }

    public RoomEntity() {
    }
}

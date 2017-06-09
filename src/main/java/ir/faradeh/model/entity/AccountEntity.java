package ir.faradeh.model.entity;




import ir.faradeh.utility.UtilMethod;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 *
 * @author sorena
 */
@Entity("account")
public class AccountEntity {

    @Id
    private ObjectId _id;
    @Property("Username")
    private String username;
    @Property("Password")
    private String password;

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = UtilMethod.hash(password);
    }

}

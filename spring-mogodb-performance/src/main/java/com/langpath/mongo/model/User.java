package com.langpath.mongo.model;

import com.model_old.enums.Role;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sebastian on 2016-04-27.
 */
@Data
@Document(collection = "users")
public class User implements Serializable{

    @Indexed
    private String nick;

    @Indexed
    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private Role role;

    private Map<ObjectId, Word> wordGroups;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return nick.equals(user.nick) && (email != null ? email.equals(user.email) : user.email == null);

    }

    @Override
    public int hashCode() {
        int result = nick.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public User removeWordGroup(String wgId) {
        getWordGroups().remove(new ObjectId(wgId));
        return this;
    }
}

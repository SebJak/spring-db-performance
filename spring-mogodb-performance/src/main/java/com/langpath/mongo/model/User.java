package com.langpath.mongo.model;

import com.model_old.enums.Role;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sebastian on 2016-04-27.
 */
@Data
@Builder
@Document(collection = "users")
public class User implements Serializable{

    @Id
    private String id;

    @Indexed
    private String nick;

    @Indexed
    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private Role role;

    @Builder.Default
    private Map<String, WordGroup> wordGroups = new HashMap<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return nick.equals(user.nick) && email.equals(user.email);

    }

    @Override
    public int hashCode() {
        int result = nick.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    public User removeWordGroup(String wgId) {
        getWordGroups().remove(wgId);
        return this;
    }

    public User addWordGroup(WordGroup wg) {
        getWordGroups().put(wg.getId(), wg);
        return this;
    }

    public User updateWordGroup(WordGroup wg) {
        getWordGroups().put(wg.getId(), wg);
        return this;
    }
}

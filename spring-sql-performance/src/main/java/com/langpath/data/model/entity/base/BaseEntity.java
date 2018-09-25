package com.langpath.data.model.entity.base;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sebastian on 2016-03-16.
 *
 * Base entity. Keeps only common values.
 */
@Setter
@Getter
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Getter(AccessLevel.NONE)
    final static long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "serial")
    private Long id;

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity that = (BaseEntity) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

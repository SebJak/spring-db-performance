package com.langpath.data.model.entity.base;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sebastian on 2016-03-16.
 *
 * Base entity. Keeps only common values.
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Getter(AccessLevel.NONE)
    final static long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
}

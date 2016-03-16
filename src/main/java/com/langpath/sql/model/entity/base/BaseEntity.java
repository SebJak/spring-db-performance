package com.langpath.sql.model.entity.base;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sebastian on 2016-03-16.
 */
@MappedSuperclass
@Data
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private Long id;
}

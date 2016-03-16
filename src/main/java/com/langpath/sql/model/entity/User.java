package com.langpath.sql.model.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Sebastian on 2016-03-14.
 */
@Entity
@Table(name="USERS")
@Data
public class User implements Serializable{

    @Id
    private Long id;

    private String name;
}

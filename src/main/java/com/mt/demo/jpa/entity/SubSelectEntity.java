package com.mt.demo.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * SubSelectEntity
 *
 * @author mt.luo
 * @description:
 */
@Data
@Entity
@Subselect("select d.id as id, d.name as dog_name, c.name as cat_name from dog_tb d left join cat_tb c on d.id=c.id")
@Synchronize({"dog_tb", "cat_tb"})
public class SubSelectEntity implements Serializable {

    private static final long serialVersionUID = -3795682088296075408L;
    @Id
    private Long id;

    private String dogName;

    private String catName;
}

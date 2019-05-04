package com.mt.demo.jpa.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * DogEntity
 *
 * @author mt.luo
 * @description:
 */
@Data
@Entity
@Table(name = "dog_tb")
@EqualsAndHashCode(callSuper = false)
public class DogEntity extends AnimalEntity<Long> {


    private static final long serialVersionUID = 7456065103323391049L;

    private String wang;
}

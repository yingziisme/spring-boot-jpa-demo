package com.mt.demo.jpa.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * DogEntity
 *
 * @author mt.luo
 * @description:
 */
@Data
@Entity
@Table(name = "cat_tb")
@EqualsAndHashCode(callSuper = false)
@NamedQueries(value = {
        @NamedQuery(name = "CatEntity.findCatBySex", query = "select n from CatEntity n where n.sex = ?1"),
        @NamedQuery(name = "CatEntity.findView", query = "select new com.mt.demo.jpa.entity.view.CatView(n.id, n.name) from CatEntity n "),
        @NamedQuery(name = "CatEntity.findView2", query = "select n.id as id, n.name as name from CatEntity n")
})
public class CatEntity extends AnimalEntity<Long> {


    private static final long serialVersionUID = 7456065103323391049L;

    private String miao;
}

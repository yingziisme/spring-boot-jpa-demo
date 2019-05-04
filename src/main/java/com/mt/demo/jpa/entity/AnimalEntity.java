package com.mt.demo.jpa.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * AnimalEntity
 *
 * @author mt.luo
 * @description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
public abstract class AnimalEntity<ID> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;


    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "gmt_create", nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "gmt_update", nullable = true, insertable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField
    protected Date gmtUpdate;

    private String name;

    private Integer age;

    private String sex;

    private Integer height;

    private Integer weight;

    private Long pid;

}

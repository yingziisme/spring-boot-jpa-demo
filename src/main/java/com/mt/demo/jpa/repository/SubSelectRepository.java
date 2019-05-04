package com.mt.demo.jpa.repository;

import com.mt.demo.jpa.entity.SubSelectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * SubSelectRepository
 *
 * @author mt.luo
 * @description:
 */
public interface SubSelectRepository extends JpaRepository<SubSelectEntity, Long>, JpaSpecificationExecutor<SubSelectEntity>, Serializable {
}

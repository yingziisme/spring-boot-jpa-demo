package com.mt.demo.jpa.repository;

import com.mt.demo.jpa.entity.DogEntity;
import com.mt.demo.jpa.entity.view.DogView;
import com.mt.demo.jpa.entity.view.DogView2;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * DogRepository
 *
 * @author mt.luo
 * @description:
 */
public interface DogRepository extends BaseRepository<DogEntity, Long> {

    @Query("select new com.mt.demo.jpa.entity.view.DogView(n .id, n .name) from DogEntity n")
    List<DogView> findDogView();

    @Query("select n .id as id, n .name as name from DogEntity n")
    List<DogView2> findDogView2();

    @NonNull
    List<DogEntity> findAll(Specification specification);

}

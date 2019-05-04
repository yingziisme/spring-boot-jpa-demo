package com.mt.demo.jpa.repository;

import com.mt.demo.jpa.entity.CatEntity;
import com.mt.demo.jpa.entity.NameEntity;
import com.mt.demo.jpa.entity.view.CatView;
import com.mt.demo.jpa.entity.view.CatView2;
import com.mt.demo.jpa.entity.view.NamesOnly;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * DogRepository
 *
 * @author mt.luo
 * @description:
 */
public interface CatRepository extends BaseRepository<CatEntity, Long> {

    List<CatEntity> findByAgeAndWeight(int age, int weight);

    List<CatEntity> findByAgeLessThan(int age);

    List<CatEntity> findByNameEndingWith(String name);

    List<CatEntity> findCatBySex(String sex);

    List<CatView> findView();

    List<CatView2> findView2();

    List<NamesOnly> findByAge(int age);

    List<NameEntity> findByAgeGreaterThan(int age);

    <T> List<T> findByAgeGreaterThan(int age, Class<T> type);

    <T> List<T> findBy(Class<T> type);

    <T> Page<T> findBy(Pageable pageable, Class<T> type);

    @Query(nativeQuery = true, value = "select c.id as id, c.name as name from cat_tb c  union all select d.id as id, d.name as name from dog_tb d",
            countQuery = "select count(*) from (select c.id as id from cat_tb c  union all select d.id as id from dog_tb d) a")
    <T> Page<T> findUnion(Pageable pageable, Class<T> type);

    @Query("select new com.mt.demo.jpa.entity.view.CatView(c.id , d.name) from CatEntity c left join DogEntity d on c.id = d.id")
    <T> Page<T> findQuery(Pageable pageable, Class<T> type);

    @Query("select c.id as id, d.name as name from CatEntity c left join DogEntity d on c.id = d.id")
    <T> Page<T> findQuery2(Pageable pageable, Class<T> type);
}

package com.mt.demo.jpa.controller;

import com.alibaba.fastjson.JSON;
import com.mt.demo.jpa.entity.view.CatView;
import com.mt.demo.jpa.entity.view.CatView2;
import com.mt.demo.jpa.repository.CatRepository;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * TestController
 *
 * @author mt.luo
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/chapter/eight")
public class ChapterEightController {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CatRepository catRepository;


    @ApiOperation(value = "查询", httpMethod = "GET")
    @GetMapping("/search")
    public List<CatView> search() {
        Query query = entityManager.createNativeQuery("select id as id, name as name from cat_tb");

        List<CatView> list = query.getResultList();
        log.info("list: {}", JSON.toJSONString(list));
        return list;
    }

    @ApiOperation(value = "查询union", httpMethod = "GET")
    @GetMapping("/search/union")
    public List<CatView> searchUnion() {
        Query query = entityManager.createNativeQuery("select c.id as id, c.name as name from cat_tb c  union all select d.id as id, d.name as name from dog_tb d");

        List<CatView> list = query.getResultList();
        log.info("list: {}", JSON.toJSONString(list));
        return list;
    }

    @ApiOperation(value = "union query查询", httpMethod = "GET")
    @GetMapping("/left/union")
    public Page<CatView> findUnion(@RequestParam int pageSize, @RequestParam int pageNum) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return catRepository.findUnion(pageable, CatView.class);
    }

    @ApiOperation(value = "union query查询2", httpMethod = "GET")
    @GetMapping("/left/union2")
    public Page<CatView2> findUnion2(@RequestParam int pageSize, @RequestParam int pageNum) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return catRepository.findUnion(pageable, CatView2.class);
    }

    @ApiOperation(value = "left join query查询", httpMethod = "GET")
    @GetMapping("/left/join")
    public Page<CatView> leftJoin(@RequestParam int pageSize, @RequestParam int pageNum) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return catRepository.findQuery(pageable, CatView.class);
    }

    @ApiOperation(value = "left join query查询2", httpMethod = "GET")
    @GetMapping("/left/join2")
    public Page<CatView2> leftJoin2(@RequestParam int pageSize, @RequestParam int pageNum) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return catRepository.findQuery2(pageable, CatView2.class);
    }
}

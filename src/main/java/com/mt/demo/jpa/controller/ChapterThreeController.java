package com.mt.demo.jpa.controller;

import com.github.wenhao.jpa.Specifications;
import com.mt.demo.jpa.entity.CatEntity;
import com.mt.demo.jpa.repository.CatRepository;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TestController
 *
 * @author mt.luo
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/chapter/three")
public class ChapterThreeController {

    @Autowired
    private CatRepository catRepository;

    @ApiOperation(value = "获取所有的猫", httpMethod = "GET")
    @GetMapping("/find/cat")
    public List<CatEntity> findCat() {
        return catRepository.findAll();
    }

    @ApiOperation(value = "findById", httpMethod = "GET")
    @GetMapping("/find/cat/{id}")
    public CatEntity findOneCatById(@PathVariable Long id) {
        return catRepository.findById(id).orElse(null);
    }

    @ApiOperation(value = "分页查询", httpMethod = "GET")
    @GetMapping("/find/cat/page")
    public Page<CatEntity> findCatByPage(@RequestParam int pageSize, @RequestParam int pageNum) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return catRepository.findAll(pageable);
    }

    @ApiOperation(value = "分页排序查询", httpMethod = "GET")
    @GetMapping("/find/cat/order")
    public Page<CatEntity> findCatByPageOrder(@RequestParam int pageSize, @RequestParam int pageNum) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, new Sort(Sort.Direction.DESC, "id"));
        return catRepository.findAll(pageable);
    }

    @ApiOperation(value = "分页条件查询", httpMethod = "GET")
    @GetMapping("/find/cat/search")
    public Page<CatEntity> findCatByPageOrder(@RequestParam int pageSize, @RequestParam int pageNum, @RequestParam String miao) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, new Sort(Sort.Direction.DESC, "id"));
        Specification<CatEntity> specification = Specifications.<CatEntity>and().eq(!StringUtils.isEmpty(miao), "miao", miao).build();
        return catRepository.findAll(specification, pageable);
    }
}

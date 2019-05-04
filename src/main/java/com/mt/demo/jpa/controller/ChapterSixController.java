package com.mt.demo.jpa.controller;

import com.mt.demo.jpa.entity.NameEntity;
import com.mt.demo.jpa.entity.view.NamesOnly;
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

import java.util.List;

/**
 * TestController
 *
 * @author mt.luo
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/chapter/six")
public class ChapterSixController {

    @Autowired
    private CatRepository catRepository;

    @ApiOperation(value = "find", httpMethod = "GET")
    @GetMapping("/find")
    public List<NamesOnly> find(@RequestParam int age) {
        return catRepository.findByAge(age);
    }

    @ApiOperation(value = "find2", httpMethod = "GET")
    @GetMapping("/find2")
    public List<NameEntity> find2(@RequestParam int age) {
        return catRepository.findByAgeGreaterThan(age);
    }

    @ApiOperation(value = "findType", httpMethod = "GET")
    @GetMapping("/find/type")
    public List<NamesOnly> findType() {
        return catRepository.findBy(NamesOnly.class);
    }

    @ApiOperation(value = "findType2", httpMethod = "GET")
    @GetMapping("/find/type2")
    public List<NameEntity> findType2() {
        return catRepository.findBy(NameEntity.class);
    }

    @ApiOperation(value = "findTypeAge", httpMethod = "GET")
    @GetMapping("/find/type/age")
    public List<NamesOnly> findTypeAge(@RequestParam int age) {
        return catRepository.findByAgeGreaterThan(age, NamesOnly.class);
    }

    @ApiOperation(value = "findTypeAge2", httpMethod = "GET")
    @GetMapping("/find/type/age2")
    public List<NameEntity> findTypeAge2(@RequestParam int age) {
        return catRepository.findByAgeGreaterThan(age, NameEntity.class);
    }

    @ApiOperation(value = "findTypePage", httpMethod = "GET")
    @GetMapping("/find/type/page")
    public Page<NamesOnly> findTypePage(@RequestParam int pageSize, @RequestParam int pageNum) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return catRepository.findBy(pageable, NamesOnly.class);
    }

    @ApiOperation(value = "findTypePage2", httpMethod = "GET")
    @GetMapping("/find/type/page2")
    public Page<NameEntity> findTypePage2(@RequestParam int pageSize, @RequestParam int pageNum) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return catRepository.findBy(pageable, NameEntity.class);
    }

}

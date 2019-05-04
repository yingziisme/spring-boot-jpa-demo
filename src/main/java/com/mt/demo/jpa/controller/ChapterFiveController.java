package com.mt.demo.jpa.controller;

import com.mt.demo.jpa.entity.SubSelectEntity;
import com.mt.demo.jpa.repository.SubSelectRepository;
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
 * ChapterFiveController
 *
 * @author mt.luo
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/chapter/five")
public class ChapterFiveController {

    @Autowired
    private SubSelectRepository subSelectRepository;

    @ApiOperation(value = "findAll", httpMethod = "GET")
    @GetMapping("/find")
    public List<SubSelectEntity> findAll() {
        return subSelectRepository.findAll();
    }

    @ApiOperation(value = "findPage", httpMethod = "GET")
    @GetMapping("/page")
    public Page<SubSelectEntity> findPage(@RequestParam int pageSize, @RequestParam int pageNum) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return subSelectRepository.findAll(pageable);
    }
}

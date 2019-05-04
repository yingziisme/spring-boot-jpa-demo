package com.mt.demo.jpa.controller;

import com.github.wenhao.jpa.Specifications;
import com.mt.demo.jpa.dto.ChapterSevenDTO;
import com.mt.demo.jpa.entity.CatEntity;
import com.mt.demo.jpa.repository.CatRepository;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ChapterSevenController
 *
 * @author mt.luo
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/chapter/seven")
public class ChapterSevenController {

    @Autowired
    private CatRepository catRepository;


    @ApiOperation(value = "and条件查询", httpMethod = "POST")
    @PostMapping("/search/cat/and")
    public List<CatEntity> searchCatAnd(@RequestBody ChapterSevenDTO chapterSevenDTO) {
        Specification<CatEntity> specification = Specifications.<CatEntity>and()
                .gt(null != chapterSevenDTO.getAge(), "age", chapterSevenDTO.getAge())
                .lt(null != chapterSevenDTO.getHeight(), "height", chapterSevenDTO.getHeight())
                .eq(null != chapterSevenDTO.getWeight(), "weight", chapterSevenDTO.getWeight()).build();
        return catRepository.findAll(specification);
    }

    @ApiOperation(value = "or条件查询", httpMethod = "POST")
    @PostMapping("/search/cat/or")
    public List<CatEntity> searchCatOr(@RequestBody ChapterSevenDTO chapterSevenDTO) {
        Specification<CatEntity> specification = Specifications.<CatEntity>or()
                .gt(null != chapterSevenDTO.getAge(), "age", chapterSevenDTO.getAge())
                .lt(null != chapterSevenDTO.getHeight(), "height", chapterSevenDTO.getHeight())
                .eq(null != chapterSevenDTO.getWeight(), "weight", chapterSevenDTO.getWeight()).build();
        return catRepository.findAll(specification);
    }

    @ApiOperation(value = "复杂条件查询", httpMethod = "POST")
    @PostMapping("/search/cat")
    public List<CatEntity> searchCat(@RequestBody ChapterSevenDTO chapterSevenDTO) {
        Specification<CatEntity> specification = Specifications.<CatEntity>or()
                .gt(null != chapterSevenDTO.getAge(), "age", chapterSevenDTO.getAge())
                .lt(null != chapterSevenDTO.getHeight(), "height", chapterSevenDTO.getHeight()).build();
        Specification<CatEntity> specification1 = Specifications.<CatEntity>and()
                .eq(null != chapterSevenDTO.getSex(), "sex", chapterSevenDTO.getSex())
                .eq(null != chapterSevenDTO.getName(), "name", chapterSevenDTO.getName()).build();
        Specification<CatEntity> specification2 = Specifications.<CatEntity>and().predicate(specification).predicate(specification1)
                .lt(null != chapterSevenDTO.getWeight(), "weight", chapterSevenDTO.getWeight()).build();

        return catRepository.findAll(specification2);
    }
}

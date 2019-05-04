package com.mt.demo.jpa.controller;

import com.mt.demo.jpa.entity.CatEntity;
import com.mt.demo.jpa.entity.view.CatView;
import com.mt.demo.jpa.entity.view.CatView2;
import com.mt.demo.jpa.entity.view.DogView;
import com.mt.demo.jpa.entity.view.DogView2;
import com.mt.demo.jpa.repository.CatRepository;
import com.mt.demo.jpa.repository.DogRepository;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ChapterFourController
 *
 * @author mt.luo
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/chapter/four")
public class ChapterFourController {

    @Autowired
    private CatRepository catRepository;

    @Autowired
    private DogRepository dogRepository;

    @ApiOperation(value = "findByAgeAndWeight", httpMethod = "GET")
    @GetMapping("/find/age/weight")
    public List<CatEntity> findCat(@RequestParam int age, @RequestParam int weight) {
        return catRepository.findByAgeAndWeight(age, weight);
    }

    @ApiOperation(value = "findByAgeLessThan", httpMethod = "GET")
    @GetMapping("/find/age/less")
    public List<CatEntity> findCat(@RequestParam int age) {
        return catRepository.findByAgeLessThan(age);
    }

    @ApiOperation(value = "findByNameEndingWith", httpMethod = "GET")
    @GetMapping("/find/name/ending")
    public List<CatEntity> findCat(@RequestParam String name) {
        return catRepository.findByNameEndingWith(name);
    }

    @ApiOperation(value = "findCatBySex", httpMethod = "GET")
    @GetMapping("/find/sex")
    public List<CatEntity> findCatBySex(@RequestParam String sex) {
        return catRepository.findCatBySex(sex);
    }

    @ApiOperation(value = "findCatView", httpMethod = "GET")
    @GetMapping("/find/cat/view")
    public List<CatView> findCatView() {
        return catRepository.findView();
    }

    @ApiOperation(value = "findCatView2", httpMethod = "GET")
    @GetMapping("/find/cat/view2")
    public List<CatView2> findCatView2() {
        return catRepository.findView2();
    }

    @ApiOperation(value = "findDogView", httpMethod = "GET")
    @GetMapping("/find/dog/view")
    public List<DogView> findDogView() {
        return dogRepository.findDogView();
    }

    @ApiOperation(value = "findDogView2", httpMethod = "GET")
    @GetMapping("/find/dog/view2")
    public List<DogView2> findDogView2() {
        return dogRepository.findDogView2();
    }


}

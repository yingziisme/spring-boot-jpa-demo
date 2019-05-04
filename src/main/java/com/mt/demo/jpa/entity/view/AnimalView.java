package com.mt.demo.jpa.entity.view;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * AnimalView
 *
 * @author mt.luo
 * @description:
 */
@Data
@AllArgsConstructor
public class AnimalView {
    private Long id;
    private String name;
    private String type;
}

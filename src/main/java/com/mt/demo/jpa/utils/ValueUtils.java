package com.mt.demo.jpa.utils;

import com.mt.demo.jpa.entity.CatEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * ValueUtils
 *
 * @author mt.luo
 * @description:
 */
@Slf4j
@Component
public class ValueUtils {
    public String getName(CatEntity catEntity) {
        log.info("catEntity: {}", catEntity);
        return "aaa_" + catEntity.getName();
    }
}

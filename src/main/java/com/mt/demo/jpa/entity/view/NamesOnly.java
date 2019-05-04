package com.mt.demo.jpa.entity.view;

import org.springframework.beans.factory.annotation.Value;

/**
 * NamesOnly
 *
 * @author mt.luo
 * @description:
 */
public interface NamesOnly {
    String getName();

    @Value("#{target.name + ' ' + target.id}")
    String getFullName();

    @Value("#{@valueUtils.getName(target)}")
    String getValue();
}

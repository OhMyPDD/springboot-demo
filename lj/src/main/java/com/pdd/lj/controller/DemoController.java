package com.pdd.lj.controller;

import com.pdd.lj.entity.RocOrderTrack;
import com.pdd.lj.mapper.RocOrderTrackDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pdd
 * @date 2021/2/13 下午10:58
 */
@RestController
@RequestMapping("/springboot")
public class DemoController {

    @Autowired
    private RocOrderTrackDao rocOrderTrackDao;

    @RequestMapping("/hello")
    public String sayHello() {
        RocOrderTrack rocOrderTrack=rocOrderTrackDao.queryRecentOneById("1263069864046629581");
        return String.valueOf(rocOrderTrack.getCurrentStatusCode());
    }
}
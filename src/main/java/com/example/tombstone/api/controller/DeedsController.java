package com.example.tombstone.api.controller;

import com.example.tombstone.api.service.DeedsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 
 *
 * @author zhy
 * @email 2434017367@qq.com
 * @date 2019-12-14 12:32:20
 */
@RestController
@RequestMapping("api/deeds")
public class DeedsController {
    @Autowired
    private DeedsService deedsService;

}

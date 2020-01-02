package com.example.tombstone.controller;

import com.example.tombstone.config.ConfigEntity;
import com.example.tombstone.utils.FileUtlis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;

/**
 * @email 2434017367@qq.com
 * @author: zhy
 * @date: 2019/12/16
 * @time: 11:09
 */

@Controller
public class baseController {

    @Autowired
    private ConfigEntity config;

    /**
     * 图片获取
     * @param imageName
     * @param response
     * @throws Exception
     */
    @GetMapping("/getImage/{imageName}")
    public void getImage(@PathVariable(value = "imageName") String imageName, HttpServletResponse response) throws Exception {
        response.setContentType("image/jpeg");

        // 拼接图片路径
        String imageUrl = config.getImagePath() + imageName;
        File iamgeFile = new File(imageUrl);

        // 判断图片是否存在
        if (iamgeFile.exists()){
            FileInputStream fileInputStream = new FileInputStream(iamgeFile);
            ServletOutputStream outputStream = response.getOutputStream();

            FileUtlis.flow(fileInputStream, outputStream);
        }
    }


}

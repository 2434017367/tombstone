package com.example.tombstone.api.controller;

import com.example.tombstone.api.entity.FigureEntity;
import com.example.tombstone.api.service.FigureService;
import com.example.tombstone.config.ConfigEntity;
import com.example.tombstone.constans.StatusConstans;
import com.example.tombstone.utils.R;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;


/**
 * 
 *
 * @author zhy
 * @email 2434017367@qq.com
 * @date 2019-12-14 12:32:20
 */
@RestController
@RequestMapping("api/figure")
public class FigureController {
    @Autowired
    private FigureService figureService;

    @Autowired
    private ConfigEntity configEntity;

    @PostMapping("/add")
    public R add(@RequestBody FigureEntity figure, HttpSession session){

//        System.out.println(new Gson().toJson(figure));

        // 获取路径
        String path =session.getServletContext().getRealPath("/images") + "/";

        System.out.println("path = " + path);

        return figureService.add(figure, path);
    }

    @GetMapping("/queryPage")
    public R queryPage(@RequestParam Map<String, Object> param){
        return figureService.queryPage(param);
    }

    @GetMapping("/info")
    public R info(String id){
        if (StringUtils.isEmpty(id)){
            return R.error("id为空");
        }else {
            return figureService.info(id);
        }
    }

    @PostMapping("/update")
    public R update(@RequestBody FigureEntity figure, HttpSession session){

//        System.out.println(new Gson().toJson(figure));

        // 获取路径
//        String path =session.getServletContext().getRealPath("/images") + "/";

        String path = configEntity.getImagePath();

        System.out.println("path = " + path);

        return figureService.update(figure, path);
    }

    @DeleteMapping("/delete/{id}")
    public R delete(@PathVariable("id") String id){
        FigureEntity figureEntity = new FigureEntity();
        figureEntity.setId(id);
        figureEntity.setStatus(StatusConstans.DELETE);
        figureService.updateById(figureEntity);

        return R.ok();
    }


    @PostMapping("/updateStatus")
    public R updateStatus(@RequestParam(value = "id", required = true) String id,@RequestParam(value = "status", required = true) Integer status){
        if (StatusConstans.NORMAL.equals(status) || StatusConstans.PROHIBIT.equals(status)){
            FigureEntity figureEntity = new FigureEntity();
            figureEntity.setId(id);
            figureEntity.setStatus(status);
            figureService.updateById(figureEntity);
        }

        return R.ok();
    }





}

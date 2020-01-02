package com.example.tombstone.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.tombstone.api.entity.FigureEntity;
import com.example.tombstone.api.service.FigureService;
import com.example.tombstone.constans.StatusConstans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @email 2434017367@qq.com
 * @author: gyh
 * @date: 2019/12/14
 * @time: 15:56
 */

@Controller
public class indexController {

    @Autowired
    private FigureService figureService;

    @GetMapping("/")
    public String index(HttpSession session){
        Object ip = session.getAttribute("ip");
        if (ip == null){
            return "redirect:/login.html";
        }else {
            return "redirect:main";
        }
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpServletRequest request){
        System.out.println("username = " + username);
        System.out.println("password = " + password);

        if ("admin".equals(username) && "admin".equals(password)){

            // 获取客户端id
            String ip = request.getRemoteAddr();

            // 保存ip信息到session中
            HttpSession session = request.getSession();
            session.setAttribute("ip", ip);

            return "redirect:main";
        }else {
            return "redirect:/login.html";
        }

    }

    @GetMapping("/outLogin")
    public String outLogin(HttpSession session){
        session.removeAttribute("ip");
        return "redirect:login.html";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/commentList/{id}")
    public String toCommentList(@PathVariable("id") String id, HttpServletRequest request){
        request.setAttribute("id", id);
        return "commentList";
    }



    @RequestMapping("/demo/{id}")
    public String demo(@PathVariable("id") String id, HttpServletRequest request){

        FigureEntity figureEntity = figureService.getOne(new QueryWrapper<FigureEntity>().eq("id", id).eq("status", StatusConstans.NORMAL));
        if (figureEntity == null){
            return "redirect:error/404";
        }else{
            request.setAttribute("id", id);
            return "demo";
        }

    }

}

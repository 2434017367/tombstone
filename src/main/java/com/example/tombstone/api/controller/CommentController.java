package com.example.tombstone.api.controller;

import com.example.tombstone.api.entity.CommentEntity;
import com.example.tombstone.api.service.CommentService;
import com.example.tombstone.constans.StatusConstans;
import com.example.tombstone.utils.CommUtils;
import com.example.tombstone.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;


/**
 * 
 *
 * @author zhy
 * @email 2434017367@qq.com
 * @date 2019-12-14 12:32:20
 */
@RestController
@RequestMapping("api/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/comment")
    public R comment(CommentEntity comment){
        comment.setId(CommUtils.getUuid());
        comment.setCreateDate(new Date());
        comment.setStatus(StatusConstans.UNREVIEWED);

        commentService.save(comment);

        return R.ok();
    }


    @GetMapping("/queryPage/{figureId}")
    public R queryPage(@PathVariable("figureId") String figureId,@RequestParam Map<String, Object> param){

        return commentService.queryPage(figureId, param);

    }

    @PostMapping("/updateStatus")
    public R updateStatus(@RequestParam(value = "id", required = true) String id,@RequestParam(value = "status", required = true) Integer status){
        if (StatusConstans.NORMAL.equals(status) || StatusConstans.PROHIBIT.equals(status)){
            CommentEntity commentEntity = new CommentEntity();
            commentEntity.setId(id);
            commentEntity.setStatus(status);
            commentService.updateById(commentEntity);
        }

        return R.ok();
    }

    @DeleteMapping("/delete/{id}")
    public R delete(@PathVariable("id") String id){
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(id);
        commentEntity.setStatus(StatusConstans.DELETE);

        commentService.updateById(commentEntity);
        return R.ok();
    }

}

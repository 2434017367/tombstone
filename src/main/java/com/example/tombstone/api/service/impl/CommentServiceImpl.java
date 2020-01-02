package com.example.tombstone.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.tombstone.api.dao.CommentDao;
import com.example.tombstone.api.entity.CommentEntity;
import com.example.tombstone.api.service.CommentService;
import com.example.tombstone.constans.StatusConstans;
import com.example.tombstone.utils.CommUtils;
import com.example.tombstone.utils.PageUtils;
import com.example.tombstone.utils.R;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentDao, CommentEntity> implements CommentService {

    @Override
    public R queryPage(String figureId, Map<String, Object> param) {
        Page page = PageUtils.getPage(param);

        String name = String.valueOf(param.get("name"));
        String status = String.valueOf(param.get("status"));

        IPage iPage = this.getBaseMapper().selectPage(page, new QueryWrapper<CommentEntity>().eq("figure_id", figureId)
                                                                                .like(CommUtils.isNotEmpty(name), "name", name)
                                                                                .eq(CommUtils.isNotEmpty(status), "status", status)
                                                                                .ne("status", StatusConstans.DELETE)
                                                                                .orderByDesc("create_date"));

        return PageUtils.getPageResult(iPage);


    }
}

package com.example.tombstone.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.tombstone.api.dao.FigureDao;
import com.example.tombstone.api.entity.CommentEntity;
import com.example.tombstone.api.entity.DeedsEntity;
import com.example.tombstone.api.entity.FigureEntity;
import com.example.tombstone.api.service.CommentService;
import com.example.tombstone.api.service.DeedsService;
import com.example.tombstone.api.service.FigureService;
import com.example.tombstone.constans.StatusConstans;
import com.example.tombstone.utils.CommUtils;
import com.example.tombstone.utils.FileUtlis;
import com.example.tombstone.utils.PageUtils;
import com.example.tombstone.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("figureService")
public class FigureServiceImpl extends ServiceImpl<FigureDao, FigureEntity> implements FigureService {

    @Autowired
    private DeedsService deedsService;

    @Autowired
    private CommentService commentService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public R add(FigureEntity figure,String path) {
        // 图片上传处理
        // 获取uuid当做文件名
        String fileName = CommUtils.getUuid();
        try {
            String image = FileUtlis.base64Upload(path, fileName, figure.getImage());
            figure.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("图像保存失败");
        }

        String figureId = CommUtils.getUuid();
        figure.setId(figureId);
        figure.setCreateDate(new Date());
        figure.setStatus(StatusConstans.NORMAL);

        List<DeedsEntity> deedsList = figure.getDeedsList();

        if (deedsList != null && deedsList.size() > 0) {
            for (DeedsEntity deedsEntity : deedsList) {
                deedsEntity.setFigureId(figureId);
                deedsEntity.setId(CommUtils.getUuid());
                deedsEntity.setCreateDate(new Date());
                deedsEntity.setStatus(StatusConstans.NORMAL);
            }

            deedsService.saveBatch(deedsList);
        }

        // 保存
        this.save(figure);

        return R.ok();
    }

    @Override
    public R queryPage(Map<String, Object> param) {
        IPage page = PageUtils.getPage(param);

        String name = String.valueOf(param.get("name"));
        String status = String.valueOf(param.get("status"));

        IPage iPage = this.getBaseMapper().selectPage(page, new QueryWrapper<FigureEntity>()
                                                .like(CommUtils.isNotEmpty(name), "name", name)
                                                .eq(CommUtils.isNotEmpty(status), "status", status)
                                                .ne("status", StatusConstans.DELETE)
                                                .orderByDesc("create_date"));

        R pageResult = PageUtils.getPageResult(iPage);

        return pageResult;
    }

    @Override
    public R info(String id) {
        FigureEntity figureEntity = this.getById(id);

        List<DeedsEntity> deedslist = deedsService.getBaseMapper().selectList(new QueryWrapper<DeedsEntity>().eq("figure_id", id).orderByAsc("deeds_date"));

        List<CommentEntity> commentList = commentService.getBaseMapper().selectList(new QueryWrapper<CommentEntity>().eq("figure_id", id).eq("status", StatusConstans.NORMAL).orderByDesc("create_date"));

        figureEntity.setDeedsList(deedslist);

        figureEntity.setCommentList(commentList);

        return R.ok().put("data", figureEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public R update(FigureEntity figure,String path){
        // 图片上传处理
        // 获取uuid当做文件名
        String fileName = CommUtils.getUuid();
        try {
            String image = FileUtlis.base64Upload(path, fileName, figure.getImage());
            figure.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("图像保存失败");
        }

        String figureId = figure.getId();

        List<DeedsEntity> deedsList = figure.getDeedsList();

        // 删除事件
        deedsService.getBaseMapper().delete(new QueryWrapper<DeedsEntity>().eq("figure_id", figureId));

        // 重新插入
        if (deedsList != null && deedsList.size() > 0) {
            for (DeedsEntity deedsEntity : deedsList) {
                deedsEntity.setFigureId(figureId);
                deedsEntity.setId(CommUtils.getUuid());
                deedsEntity.setCreateDate(new Date());
                deedsEntity.setStatus(StatusConstans.NORMAL);
            }

            deedsService.saveBatch(deedsList);
        }

        // 更新
        this.updateById(figure);

        return R.ok();

    }

}

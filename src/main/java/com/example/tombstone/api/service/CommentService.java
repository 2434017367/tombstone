package com.example.tombstone.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.tombstone.api.entity.CommentEntity;
import com.example.tombstone.utils.R;

import java.util.Map;

/**
 * 
 *
 * @author zhy
 * @email 2434017367@qq.com
 * @date 2019-12-14 12:32:20
 */
public interface CommentService extends IService<CommentEntity> {

    R queryPage(String figureId, Map<String, Object> param);
}


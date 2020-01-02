package com.example.tombstone.api.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.tombstone.api.entity.CommentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author zhy
 * @email 2434017367@qq.com
 * @date 2019-12-14 12:32:20
 */
@Mapper
public interface CommentDao extends BaseMapper<CommentEntity> {
	
}

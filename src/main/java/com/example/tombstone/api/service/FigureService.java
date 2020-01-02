package com.example.tombstone.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.tombstone.api.entity.FigureEntity;
import com.example.tombstone.utils.R;

import java.util.Map;

/**
 * 
 *
 * @author zhy
 * @email 2434017367@qq.com
 * @date 2019-12-14 12:32:20
 */
public interface FigureService extends IService<FigureEntity> {

    R add(FigureEntity figure, String path);

    R queryPage(Map<String, Object> param);

    R info(String id);

    R update(FigureEntity figure,String path);
}


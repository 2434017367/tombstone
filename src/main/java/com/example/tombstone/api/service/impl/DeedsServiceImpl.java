package com.example.tombstone.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.tombstone.api.dao.DeedsDao;
import com.example.tombstone.api.entity.DeedsEntity;
import com.example.tombstone.api.service.DeedsService;
import org.springframework.stereotype.Service;


@Service("deedsService")
public class DeedsServiceImpl extends ServiceImpl<DeedsDao, DeedsEntity> implements DeedsService {


}

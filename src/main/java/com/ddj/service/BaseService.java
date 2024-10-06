package com.ddj.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

/**
 * @Author: icho
 * @Date: 2024/10/4 21:25
 * @Describe:
 */
@Service
public class BaseService implements IService<T> {


    @Override
    public boolean saveBatch(Collection<T> entityList) {
        return IService.super.saveBatch(entityList);
    }

    @Override
    public boolean saveBatch(Collection<T> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<T> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(T entity) {
        return false;
    }

    @Override
    public T getOne(Wrapper<T> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<T> queryWrapper) {
        return Collections.emptyMap();
    }

    @Override
    public <V> V getObj(Wrapper<T> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<T> getBaseMapper() {
        return null;
    }

    @Override
    public Class<T> getEntityClass() {
        return null;
    }
}

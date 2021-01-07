package com.lxw.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxw.entity.EbookEntry;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lxw
 * @since 2020-12-28
 */
public interface EbookEntryMapper extends BaseMapper<EbookEntry> {
    /***
     * 分页查询
     * @param page
     * @param querywarrapper
     * @return
     */
    IPage<EbookEntry> findById(Page<EbookEntry> page, @Param(Constants.WRAPPER) QueryWrapper<EbookEntry> querywarrapper);
}

package com.lxw.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxw.entity.EbookEntry;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lxw
 * @since 2020-12-28
 */
public interface EbookEntryService extends IService<EbookEntry> {
    /***
     * 分页查询
     * @param page
     * @param querywarrapper
     * @return
     */
    IPage<EbookEntry> findById(Page<EbookEntry> page, @Param(Constants.WRAPPER) QueryWrapper<EbookEntry> querywarrapper);
}

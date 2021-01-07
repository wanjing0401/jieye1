package com.lxw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxw.entity.EbookEntry;
import com.lxw.mapper.EbookEntryMapper;
import com.lxw.service.EbookEntryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxw
 * @since 2020-12-28
 */
@Service
public class EbookEntryServiceImpl extends ServiceImpl<EbookEntryMapper, EbookEntry> implements EbookEntryService {
    @Autowired(required = false)
    private EbookEntryMapper ebookEntryMapper;
    @Override
    public IPage<EbookEntry> findById(Page<EbookEntry> page, QueryWrapper<EbookEntry> querywarrapper) {
        return ebookEntryMapper.findById(page,querywarrapper);
    }
}

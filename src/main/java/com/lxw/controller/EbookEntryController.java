package com.lxw.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxw.entity.EbookCategory;
import com.lxw.entity.EbookEntry;
import com.lxw.service.EbookCategoryService;
import com.lxw.service.EbookEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lxw
 * @since 2020-12-28
 */
@Controller
public class EbookEntryController {

    @Autowired(required = false)
    private EbookEntryService ebookEntryService;

    @Autowired
    private EbookCategoryService ebookCategoryService;

    @RequestMapping("/aa")
    public String aa(){
        return "aa";
    }
    @PostMapping("/index")
    public String index(Integer categoryId, Integer pageNum, Model model) {
        /*   List<EbookEntry> ebookEntryList = ebookEntryService.list();*/
        if (pageNum == null) {
            pageNum = 1;
        }
        Page<EbookEntry> page = new Page<>(pageNum, 1);
        QueryWrapper<EbookEntry> queryWrapper = new QueryWrapper<>();
        //判断图书品种编号是否为空或者零，否则查询全部
        if (categoryId != null && categoryId != 0) {
            queryWrapper.eq("category_id", categoryId);
        }
        /***
         *getCurrent 当前页数
         * getPages 总页数
         * getSize 每页显示条数
         * getTotal 总条数
         * getRecords 数据
         */
        IPage<EbookEntry> ebookEntryServiceById = ebookEntryService.findById(page, queryWrapper);
        /*System.out.println(ebookEntryServiceById.getRecords());*/
        model.addAttribute("pageInfo", ebookEntryServiceById);
        ebookEntryServiceById.getRecords().get(0).getCreateTime();
        List<EbookCategory> ebookCategoryList = ebookCategoryService.list();
        model.addAttribute("ebookCategoryList", ebookCategoryList);
        return "index";
    }

    @RequestMapping("/update")
    public String update(Integer id, Model model) {
        EbookEntry byId = ebookEntryService.getById(id);
        model.addAttribute("EbookEntry", byId);
        System.out.println(byId.getTitle() + byId.getCreateTime());
        return "update";
    }

    @RequestMapping("/updateIng")
    public String updateIng(EbookEntry ebookEntry, String createTime) throws ParseException {
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        /**
         * 先把String类型的时间转换为Date类型
         */
        Date date = new java.sql.Date(ebookEntry.getCreateTime().getTime());
        ebookEntry.setCreateTime(date);
        //默认图书品种
        ebookEntry.setCategoryId(1);
        ebookEntryService.updateById(ebookEntry);
        return "redirect:/index";
    }

    @RequestMapping("/deleteById")
    public String deleteById(Integer id) {
        ebookEntryService.removeById(id);
        return "redirect:/index";
    }

    @RequestMapping("/insert")
    public String insert() {
        return "insert";
    }

    @RequestMapping("/insertIng")
    public String insertIng(EbookEntry ebookEntry,String createTime) {
        Date date = new java.sql.Date(ebookEntry.getCreateTime().getTime());
        ebookEntry.setCreateTime(date);
        //默认图书品种
        ebookEntry.setCategoryId(1);
        ebookEntryService.save(ebookEntry);
        return "redirect:/index";
    }
}


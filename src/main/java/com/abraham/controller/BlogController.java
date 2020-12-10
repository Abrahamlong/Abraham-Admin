package com.abraham.controller;

import com.abraham.service.BlogService;
import com.abraham.utils.Result;
import com.abraham.vo.BlogManagementVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 后台管理博客功能接口
 *
 * @author: Long
 * @date Create in 10:21 2020/11/10
 */
@Controller
@RequestMapping("/admin/blog")
public class BlogController {

    @Resource
    private BlogService blogService;

    @RequestMapping("/list")
    public String management(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Model model){
        PageHelper.startPage(pageNum,10);
        List<BlogManagementVO> blogManagementVOList = blogService.queryAllByCondition(new BlogManagementVO());
        PageInfo<BlogManagementVO> blogPageInfo = new PageInfo<>(blogManagementVOList);
        model.addAttribute("blogPageInfo", blogPageInfo);
        model.addAttribute("blogList", blogManagementVOList);
        return "admin/blog/management";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){

        return "admin/blog/blog-add";
    }

    @RequestMapping("/toDetail")
    public String toDetail(){

        return "admin/blog/detail";
    }

    @RequestMapping("/toEdit")
    public String toEdit(){

        return "admin/blog/blog-edit";
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Result deleteBlog(){

        return Result.success("");
    }

}

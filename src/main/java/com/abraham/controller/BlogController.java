package com.abraham.controller;

import com.abraham.entity.Blog;
import com.abraham.entity.BlogType;
import com.abraham.service.BlogService;
import com.abraham.service.BlogTypeService;
import com.abraham.service.UserService;
import com.abraham.utils.Result;
import com.abraham.vo.BlogManagementVO;
import com.abraham.vo.BlogTypeVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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

    @Resource
    private BlogTypeService blogTypeService;

    @Resource
    private UserService userService;

    /**
     * 博客列表展示
     * @param pageNum 分页页数
     * @param model 数据传输
     * @return 博客列表(管理)页面
     */
    @RequestMapping("/list")
    public String management(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Model model){
        PageHelper.startPage(pageNum,10);
        List<BlogManagementVO> blogManagementVOList = blogService.queryAll();
        PageInfo<BlogManagementVO> blogPageInfo = new PageInfo<>(blogManagementVOList);
        model.addAttribute("blogPageInfo", blogPageInfo);
        model.addAttribute("blogList", blogManagementVOList);
        return "admin/blog/blog-list";
    }

    /**
     * 跳转到博客新增页面
     * @param model 数据传输
     * @return 博客新增页面
     */
    @RequestMapping("/add")
    public String toAdd(Model model){
        List<BlogTypeVO> blogTypes = blogTypeService.queryAll();
        model.addAttribute("blogTypes", blogTypes);
        return "admin/blog/blog-add";
    }

    /**
     * 博客新增
     * @param blog 博客对象
     * @param session 登录信息
     * @return 结果信息
     */
    @ResponseBody
    @RequestMapping("/addBlog")
    public Result addBlog(Blog blog, HttpSession session){
        System.out.println(blog);
        Boolean flag = blogService.queryByTitle(blog.getBlogTitle());
        if (!flag) {
            Result.error("博客标题已存在，请重新输入！！");
        }
        blog.setCreateUser(123L);
//        blog.setCreateUser(userService.queryByUsername((String) session.getAttribute("username")));
        int count = blogService.insert(blog);
        if (count == 0) {
            Result.error("博客新增失败，请重试！！");
        }
        return Result.success("博客新增成功！！");
    }

    /**
     * 跳转到博客编辑页面
     * @param blogId 博客Id
     * @param model 数据传输
     * @return 博客编辑页面
     */
    @RequestMapping("/edit/{id}")
    public String toEdit(@PathVariable("id") Long blogId, Model model){
        BlogManagementVO blog = blogService.queryById(blogId);
        List<BlogTypeVO> blogTypes = blogTypeService.queryAll();
        model.addAttribute("blog", blog);
        model.addAttribute("blogTypes", blogTypes);
        return "admin/blog/blog-edit";
    }

    /**
     * 博客编辑
     * @param blog 博客对象
     * @param oldBlogTitle 编辑前的博客标题
     * @return 结果信息
     */
    @ResponseBody
    @RequestMapping("/editBlog")
    public Result editBlog(Blog blog, String oldBlogTitle){
        System.out.println(blog);
        if (!oldBlogTitle.equals(blog.getBlogTitle())) {
            Boolean flag = blogService.queryByTitle(blog.getBlogTitle());
            if (!flag) {
                Result.error("博客标题已存在，请重新输入！！");
            }
        }
        int count = blogService.update(blog);
        if (count == 0) {
            Result.error("博客修改失败，请重试！！");
        }
        return Result.success("博客修改成功！！");
    }

    /**
     * 更新发布状态
     * @param blogId 博客Id
     * @param published 发布状态信息
     * @return 结果信息
     */
    @ResponseBody
    @RequestMapping("/updatePublished")
    public Result updatePublished(Long blogId, Integer published){
        System.out.println(blogId + "  " + published);
        int count = blogService.updatePublished(blogId, published);
        if (count == 0) {
            Result.error("博客发布状态修改失败，请重试！！");
        }
        return Result.success("博客发布状态修改成功~");
    }

    /**
     * 博客删除
     * @param blogId 博客Id
     * @return 结果信息
     */
    @ResponseBody
    @RequestMapping("/delete/{id}")
    public Result deleteBlog(@PathVariable("id") Long blogId){
        System.out.println(blogId);
        boolean flag = blogService.deleteById(blogId);
        if (!flag) {
            Result.error("博客删除失败，请重试!!");
        }
        return Result.success("博客删除成功~");
    }

    /**
     * 博客搜索
     * @param blogManagementVO 博客搜索条件实体
     * @param type 博客类型
     * @param model 数据传输
     * @return 博客列表页面
     */
    @RequestMapping("/search")
    public String searchBlog(BlogManagementVO blogManagementVO, String type, Model model){
        System.out.println(blogManagementVO);
        System.out.println(type);
        BlogType blogType = blogTypeService.queryByName(type);
        if (blogType != null) {
            blogManagementVO.setTypeId(blogType.getTypeId());
        }
//        PageHelper.startPage(1);
        List<BlogManagementVO> blogManagementVOList = blogService.queryAllByCondition(blogManagementVO);
        PageInfo<BlogManagementVO> pageInfo = new PageInfo<>(blogManagementVOList);
        blogManagementVOList.forEach(System.out::println);
        model.addAttribute("blogList", blogManagementVO);
        model.addAttribute("blogPageInfo", pageInfo);
        return "admin/blog/blog-list";
    }

    /**
     * 博客详情页面(后台)
     * @param blogId 博客Id
     * @param model 数据传输
     * @return 结果信息
     */
    @RequestMapping("/detail/{id}")
    public String toDetail(@PathVariable("id") String blogId, Model model){

        return "admin/blog/blog-detail";
    }
}

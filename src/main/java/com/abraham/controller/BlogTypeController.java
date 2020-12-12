package com.abraham.controller;

import com.abraham.entity.BlogType;
import com.abraham.service.BlogTypeService;
import com.abraham.service.UserService;
import com.abraham.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description: 博客类型功能请求页面
 * @author: Long
 * @date Create in 11:44 2020/12/2
 */
@Controller
@RequestMapping("/admin/management/types-management")
public class BlogTypeController {

    @Resource
    private BlogTypeService blogTypeService;

    @Resource
    private UserService userService;

    /**
     * 博客类型数据列表展示
     * @param pageNum 分页页数
     * @param model 数据传输
     * @return 博客类型列表页面
     */
    @RequestMapping("")
    public String list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Model model){
        PageHelper.startPage(pageNum,10);
        List<BlogType> blogTypes = blogTypeService.queryAllByCondition(new BlogType());
        PageInfo<BlogType> blogTypePageInfo = new PageInfo<>(blogTypes);
        model.addAttribute("blogTypePageInfo", blogTypePageInfo);
        model.addAttribute("blogTypes", blogTypes);
        return "admin/management/types-list";
    }

    /**
     * 跳转到博客类型页面
     * @return 博客类型新增页面
     */
    @RequestMapping("/add")
    public String toAdd(){
        return "admin/management/types-add";
    }

    /**
     * 博客类型新增
     * @param blogType 前端传输的对象数据
     * @param session 登录信息
     * @return 结果信息
     */
    @ResponseBody
    @RequestMapping(value = "/addType", method = RequestMethod.POST)
    public Result addType(BlogType blogType, HttpSession session){
        BlogType type = blogTypeService.queryByName(blogType.getTypeName());
        if (type != null){
            return Result.error("新增的类型名称已存在，请重新输入!!");
        }
        blogType.setCreateUser(1L);
//        blogType.setCreateUser(userService.queryByUsername((String) session.getAttribute("username")));
        BlogType count = blogTypeService.insert(blogType);
        if (count == null){
            return Result.error("博客类型新增失败，请重新输入!!");
        }
        return Result.success("博客类型新增成功!!");
    }

    /**
     * 跳转到博客类型编辑页面
     * @param id 博客类型id
     * @param model 向前端传递的数据对象
     * @return 博客类型新增页面
     */
    @RequestMapping("/edit/{id}")
    public String toEdit(@PathVariable("id") Long id, Model model){
        BlogType blogType = blogTypeService.queryById(id);
        model.addAttribute("type",blogType);
        return "admin/management/types-edit";
    }

    /**
     * 博客类型编辑
     * @param blogType 前端传输的对象数据
     * @param oldTypeName 修改前的博客类型名称
     * @param session 登录信息
     * @return 结果信息
     */
    @ResponseBody
    @RequestMapping(value = "/editType", method = RequestMethod.POST)
    public Result editType(BlogType blogType, String oldTypeName, HttpSession session){
        if (!oldTypeName.equals(blogType.getTypeName())) {
            BlogType type = blogTypeService.queryByName(blogType.getTypeName());
            if (type != null) {
                return Result.error("编辑的类型名称已存在，请重新输入!!");
            }
        }
        blogType.setCreateUser(2L);
//        blogType.setCreateUser(userService.queryByUsername((String) session.getAttribute("username")));
        BlogType count = blogTypeService.update(blogType);
        System.out.println(count);
        if (count == null){
            return Result.error("博客类型编辑失败，请重新输入!!");
        }
        return Result.success("博客类型编辑成功!!");
    }

    /**
     * 博客类型状态更新
     * @param typeId 博客类型Id
     * @param status 博客类型状态
     * @return 结果信息
     */
    @ResponseBody
    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    public Result updateStatus(Long typeId, Integer status){
        int count = blogTypeService.updateStatusById(typeId, status);
        if (count == 0){
            return Result.error("博客类型状态更新失败，请重新操作!!");
        }
        return Result.success("博客类型状态更新成功!!");
    }

    /**
     * 博客类型删除
     * @param id 要删除的博客类型的对应id
     * @return 结果信息
     */
    @ResponseBody
    @RequestMapping("/deleteType/{id}")
    public Result deleteType(@PathVariable("id") Long id){
        boolean b = blogTypeService.deleteById(id);
        if (!b) {
           return Result.error("该条数据没有被删除!!");
        }
        return Result.success("该条数据已经被删除!!");
    }
}

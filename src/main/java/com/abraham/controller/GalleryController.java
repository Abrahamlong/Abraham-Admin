package com.abraham.controller;

import com.abraham.entity.Gallery;
import com.abraham.service.GalleryService;
import com.abraham.service.UserService;
import com.abraham.utils.Result;
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
 * @Description: 图库管理控制层接口
 * @author: Long
 * @date Create in 11:09 2020/12/14
 */
@Controller
@RequestMapping("/admin/management/gallery")
public class GalleryController {

    @Resource
    private GalleryService galleryService;

    @Resource
    private UserService userService;

    /**
     * 图库管理列表展示
     * @param pageNum 分页页数
     * @param model 数据传输
     * @return 图库管理列表页面
     */
    @RequestMapping("")
    public String list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Model model){
        PageHelper.startPage(pageNum,10);
        List<Gallery> galleryList = galleryService.queryAllByCondition(new Gallery());
        PageInfo<Gallery> pageInfo = new PageInfo<>(galleryList);
        model.addAttribute("galleryList", galleryList);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/management/gallery-list";
    }

    /**
     * 跳转到图库管理图片新增页面
     * @return 图库管理图片新增页面
     */
    @RequestMapping("/add")
    public String toAdd(){
        return "admin/management/gallery-add";
    }

    /**
     * 图库管理图片新增处理
     * @param gallery 新增图片的实体信息
     * @param session 登录信息
     * @return 结果信息
     */
    @ResponseBody
    @RequestMapping("/addGallery")
    public Result addGallery(Gallery gallery, HttpSession session){
//        gallery.setCreateUser(userService.queryByUsername((String) session.getAttribute("username")));
        gallery.setCreateUser(520L);
        int count = galleryService.insert(gallery);
        if (count == 0) {
            return Result.error("图片新增失败，请重试！！");
        }
        return Result.success("图片新增成功~");
    }

    /**
     * 跳转到图库管理图片编辑页面
     * @param pictureId 图片Id
     * @param model 数据传输
     * @return 图库管理图片编辑页面
     */
    @RequestMapping("/edit/{id}")
    public String toEdit(@PathVariable("id") Long pictureId, Model model){
        Gallery gallery = galleryService.queryById(pictureId);
        model.addAttribute("gallery", gallery);
        return "admin/management/gallery-edit";
    }

    /**
     * 图库管理图片编辑处理
     * @param gallery 编辑图片的实体信息
     * @return 及认购信息
     */
    @ResponseBody
    @RequestMapping("/editGallery")
    public Result editGallery(Gallery gallery){
        Gallery count = galleryService.update(gallery);
        if (count == null) {
            return Result.error("图片编辑失败，请重试！！");
        }
        return Result.success("图片编辑成功~");
    }

    /**
     * 图库管理图片删除
     * @param pictureId 图片Id
     * @return 结果信息
     */
    @ResponseBody
    @RequestMapping("/deleteGallery/{id}")
    public Result delete(@PathVariable("id") Long pictureId){
        boolean flag = galleryService.deleteById(pictureId);
        if (!flag) {
            return Result.error("图片删除失败，请重试！！");
        }
        return Result.success("图片删除成功~");
    }

    /**
     * 跳转到图库管理图片详情展示页面（后台）
     * @param model 数据传输
     * @return 图库管理图片详情展示页面
     */
    @RequestMapping("/show")
    public String toShow(Model model){

        return "admin/management/gallery-show";
    }
}

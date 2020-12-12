package com.abraham.controller;

import com.abraham.entity.FriendLink;
import com.abraham.service.FriendLinkService;
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
 * @Description: 友链管理控制层接口
 * @author: Long
 * @date Create in 16:17 2020/12/11
 */
@Controller
@RequestMapping("/admin/management/friendLink")
public class FriendLinkController {

    @Resource
    private FriendLinkService friendLinkService;

    @Resource
    private UserService userService;

    @RequestMapping("")
    public String list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Model model){
        PageHelper.startPage(pageNum,10);
        List<FriendLink> friendLinks = friendLinkService.queryAllByCondition(new FriendLink());
        PageInfo<FriendLink> pageInfo = new PageInfo<>(friendLinks);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("friendLinks", friendLinks);
        return "admin/management/friendLink-list";
    }

    @RequestMapping("/add")
    public String toAdd(){
        return "admin/management/friendLink-add";
    }

    @ResponseBody
    @RequestMapping("/addFriendLink")
    public Result addFriendLink(FriendLink friendLink, HttpSession session){
        friendLink.setCreateUser(520L);
//        friendLink.setCreateUser(userService.queryByUsername((String) session.getAttribute("username")));
        int count = friendLinkService.insert(friendLink);
        if (count == 0) {
            return Result.error("友链新增错误，请重试！！");
        }
        return Result.success("友链新增成功~");
    }

    @RequestMapping("/edit/{id}")
    public String toEdit(@PathVariable("id") Long friendLinkId, Model model){
        System.out.println(friendLinkId);
        FriendLink friendLink = friendLinkService.queryById(friendLinkId);
        model.addAttribute("friendLink", friendLink);
        return "admin/management/friendLink-edit";
    }

    @ResponseBody
    @RequestMapping("/editFriendLink")
    public Result editFriendLink(FriendLink friendLink){
        int count = friendLinkService.update(friendLink);
        if (count == 0) {
            return Result.error("友链编辑失败，请重试！！");
        }
        return Result.success("友链编辑成功~");
    }

    @ResponseBody
    @RequestMapping("/updateStatus")
    public Result updateStatus(Long friendLinkId, Integer status){
        int count = friendLinkService.updateStatus(friendLinkId, status);
        if (count == 0) {
            return Result.error("友链状态修改失败，请重试~");
        }
        return Result.success("友链状态修改成功~");
    }

    @ResponseBody
    @RequestMapping("/deleteFriendLink/{id}")
    public Result delete(@PathVariable("id") Long friendLinkId){
        boolean flag = friendLinkService.deleteById(friendLinkId);
        if (!flag) {
            return Result.error("友链删除失败，请重试~");
        }
        return Result.success("友链删除成功~");
    }
}

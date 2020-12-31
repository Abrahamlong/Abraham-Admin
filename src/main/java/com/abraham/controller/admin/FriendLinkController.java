package com.abraham.controller.admin;

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

    /**
     * 友链管理列表展示
     * @param pageNum 分页信息
     * @param model 数据传输
     * @return 友链管理列表页面
     */
    @RequestMapping("")
    public String list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Model model){
        PageHelper.startPage(pageNum,10);
        List<FriendLink> friendLinks = friendLinkService.queryAllByCondition(new FriendLink());
        PageInfo<FriendLink> pageInfo = new PageInfo<>(friendLinks);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("friendLinks", friendLinks);
        return "admin/management/friendLink-list";
    }

    /**
     * 跳转到友链管理新增页面
     * @return 友链管理新增页面
     */
    @RequestMapping("/add")
    public String toAdd(){
        return "admin/management/friendLink-add";
    }

    /**
     * 友链管理新增处理
     * @param friendLink 友链新增的实体信息
     * @param session 登录信息
     * @return 结果信息
     */
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

    /**
     * 跳转到友链管理编辑页面
     * @param friendLinkId 友链Id
     * @param model 数据传输
     * @return 友链管理编辑页面
     */
    @RequestMapping("/edit/{id}")
    public String toEdit(@PathVariable("id") Long friendLinkId, Model model){
        System.out.println(friendLinkId);
        FriendLink friendLink = friendLinkService.queryById(friendLinkId);
        model.addAttribute("friendLink", friendLink);
        return "admin/management/friendLink-edit";
    }

    /**
     * 友链管理编辑处理
     * @param friendLink 友链编辑的实体信息
     * @return 结果信息
     */
    @ResponseBody
    @RequestMapping("/editFriendLink")
    public Result editFriendLink(FriendLink friendLink){
        int count = friendLinkService.update(friendLink);
        if (count == 0) {
            return Result.error("友链编辑失败，请重试！！");
        }
        return Result.success("友链编辑成功~");
    }

    /**
     * 更新友链状态信息
     * @param friendLinkId 友链Id
     * @param status 友链状态信息
     * @return 结果信息
     */
    @ResponseBody
    @RequestMapping("/updateStatus")
    public Result updateStatus(Long friendLinkId, Integer status){
        int count = friendLinkService.updateStatus(friendLinkId, status);
        if (count == 0) {
            return Result.error("友链状态修改失败，请重试~");
        }
        return Result.success("友链状态修改成功~");
    }

    /**
     * 友链删除处理
     * @param friendLinkId 友链Id
     * @return 结果信息
     */
    @ResponseBody
    @RequestMapping("/deleteFriendLink/{id}")
    public Result delete(@PathVariable("id") Long friendLinkId){
        boolean flag = friendLinkService.deleteById(friendLinkId);
        if (!flag) {
            return Result.error("友链删除失败，请重试~");
        }
        return Result.success("友链删除成功~");
    }

    /**
     * 跳转到友链详情展示页面（后台）
     * @param model 数据传输
     * @return 友链详情展示页面
     */
    @RequestMapping("/show")
    public String toShow(Model model){
        List<FriendLink> friendLinks = friendLinkService.queryAllByCondition(new FriendLink());
        model.addAttribute("friendLinks", friendLinks);
        model.addAttribute("imgLink", "/img/member-img/mail-4.jpg");
        return "admin/management/friendLink-show";
    }
}

package com.abraham.controller;

import com.abraham.entity.Memo;
import com.abraham.service.MemoService;
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
 * @Description: 备忘录功能请求页面
 * @author: Long
 * @date Create in 13:14 2020/11/30
 */
@Controller
@RequestMapping("admin/abraham/memo")
public class MemoController {

    @Resource
    private MemoService memoService;

    @Resource
    private UserService userService;

    /**
     * 备忘录数据列表展示
     * @param pageNum 分页页数
     * @param model 数据传输
     * @return 备忘录列表页面
     */
    @RequestMapping("")
    public String todoList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Model model){
        Memo memo = new Memo();
        PageHelper.startPage(pageNum,10);
        List<Memo> memos = memoService.queryAllByCondition(memo);
        PageInfo<Memo> memoPageInfo = new PageInfo<>(memos);
        model.addAttribute("memos", memos);
        model.addAttribute("memoPageInfo", memoPageInfo);
        return "admin/abraham/memo-list";
    }

    /**
     * 跳转到备忘录新增页面
     * @param model 数据传输
     * @param session 登录信息
     * @return 备忘录新增页面
     */
    @RequestMapping("/toAdd")
    public String toAdd(Model model, HttpSession session){
//        Long userId = userService.queryByUsername((String) session.getAttribute("username"));
        Long userId = 520L;
        model.addAttribute("createUser", userId);
        return "admin/abraham/memo-add";
    }

    /**
     * 备忘录新增
     * @param memo 备忘录对象
     * @return 结果信息
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result addMemo(Memo memo){
        System.out.println(memo);
        Memo count = memoService.insert(memo);
        if (count == null){
            return Result.error("备忘录新增失败，请重新输入!!");
        }
        return Result.success("备忘录新增成功!!");
    }

    /**
     * 跳转到备忘录编辑页面
     * @param id 备忘录Id
     * @param model 数据传输
     * @return 备忘录编辑页面
     */
    @RequestMapping("/toEdit/{id}")
    public String toEdit(@PathVariable("id") Long id, Model model){
        Memo memo = memoService.queryById(id);
        model.addAttribute("memo", memo);
        return "admin/abraham/memo-edit";
    }

    /**
     * 备忘录编辑
     * @param memo 备忘录对象
     * @return 结果信息
     */
    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Result editMemo(Memo memo){
        System.out.println(memo);
        Memo count = memoService.update(memo);
        if (count == null){
            return Result.error("备忘录编辑失败，请重新输入!!");
        }
        return Result.success("备忘录编辑成功!!");
    }

    /**
     * 备忘录状态更新
     * @param memoId 备忘录Id
     * @param status 备忘录状态
     * @return 结果信息
     */
    @ResponseBody
    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    public Result updateStatus(Long memoId, Integer status){
        int count = memoService.updateStatusById(memoId, status);
        if (count == 0){
            return Result.error("备忘录状态更新失败，请重新操作!!");
        }
        return Result.success("备忘录状态更新成功!!");
    }

    /**
     * 备忘录删除
     * @param id 备忘录Id
     * @return 结果信息
     */
    @ResponseBody
    @RequestMapping("/deleteMemo/{id}")
    public Result deleteMemo(@PathVariable("id") Long id){
        boolean flag = memoService.deleteById(id);
        if (!flag) {
            return Result.error("该条数据没有被删除!!");
        }
        return Result.success("该条数据已经被删除!!");
    }
}

package com.abraham.admin;

import com.abraham.service.BlogService;
import com.abraham.vo.BlogManagementVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @author: Long
 * @date Create in 11:41 2020/12/10
 */
@SpringBootTest
public class BlogServiceTest {

    @Resource
    private BlogService blogService;

    @Test
    public void testQueryAll(){
        List<BlogManagementVO> blogManagementVOS = blogService.queryAll();
        for (BlogManagementVO blog : blogManagementVOS) {
            System.out.println(blog);
        }
    }

    @Test
    void testQueryAllByCondition(){
//        PageHelper.startPage(1, 1000);
        List<BlogManagementVO> blogManagementVOList = blogService.queryAllByCondition(new BlogManagementVO());
        PageInfo<BlogManagementVO> pageInfo = new PageInfo<>(blogManagementVOList);
        System.out.println(pageInfo);
        blogManagementVOList.forEach(System.out::println);
    }
}

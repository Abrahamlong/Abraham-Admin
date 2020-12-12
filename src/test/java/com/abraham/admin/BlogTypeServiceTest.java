package com.abraham.admin;

import com.abraham.entity.BlogType;
import com.abraham.service.BlogTypeService;
import com.abraham.vo.BlogTypeVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @Description: 博客类型service的测试类
 *
 * @author: Long
 * @date Create in 14:30 2020/12/2
 */
@SpringBootTest
public class BlogTypeServiceTest {

    @Resource
    private BlogTypeService blogTypeService;

    @Test
    public void testQueryAllByCondition(){
        PageHelper.startPage(1,10);
        List<BlogType> blogTypes = blogTypeService.queryAllByCondition(new BlogType());
        PageInfo<BlogType> blogTypePageInfo = new PageInfo<>(blogTypes);
        blogTypes.forEach(System.out::println);
        System.out.println(blogTypePageInfo);
    }

    @Test
    public void testQueryByName(){
        BlogType blogType = new BlogType();
        blogType.setTypeName("类型新增测试2");
        blogType.setTypeStatus(1);
        blogType.setCreateUser(520L);
        BlogType insert = blogTypeService.insert(blogType);
        System.out.println(insert);
    }

    @Test
    void testDateFormat() throws ParseException {
        String str = "Wed Apr 22 14:35:58 CST 2020";
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date date = (Date) sdf.parse(str);
        String formatStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
        System.out.println(formatStr);
    }

    @Test
    void testGetUser(){
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject);
    }

    @Test
    void testQueryAll(){
        List<BlogTypeVO> blogTypeVOS = blogTypeService.queryAll();
        for (BlogTypeVO blogTypeVO : blogTypeVOS) {
            System.out.println(blogTypeVO);
        }
    }
}

package com.abraham.admin;

import com.abraham.entity.Memo;
import com.abraham.service.MemoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Long
 * @date 2020/11/28
 */
@SpringBootTest
public class MemoServiceTest {

    @Resource
    MemoService memoService;

    @Test
    void testQueryAllByCondition(){
        Memo memo = new Memo();
        PageHelper.startPage(1, 15);
        List<Memo> memos = memoService.queryAllByCondition(memo);
        PageInfo<Memo> memoPageInfo = new PageInfo<>(memos);
        System.out.println(memoPageInfo);
        memos.forEach(System.out::println);
    }
}

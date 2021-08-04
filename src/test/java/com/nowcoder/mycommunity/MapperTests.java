package com.nowcoder.mycommunity;

import com.nowcoder.mycommunity.dao.DiscussPostMapper;
import com.nowcoder.mycommunity.dao.UserMapper;
import com.nowcoder.mycommunity.entity.DiscussPost;
import com.nowcoder.mycommunity.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;


@SpringBootTest
@ContextConfiguration(classes = MycommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelect(){
        System.out.println(userMapper);
        User user = userMapper.selectById(101);
        System.out.println(user);
        user = userMapper.selectByName("liubei");
        System.out.println(user);
        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setUsername("刘佳乐");
        user.setPassword("123456789");
        user.setEmail("123456");

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
    }

    @Test
    public void testUpdate(){
        int rows  = userMapper.updateStatus(152, 1);
        System.out.println(rows);
        rows = userMapper.updateHeader(152, "http://www.nowcoder.com/101.png");
        System.out.println(rows);
        rows = userMapper.updatePassword(152, "88888");
        System.out.println(rows);
    }

    @Test
    public void testSelectDiscussPosts(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for(DiscussPost post : list){
            System.out.println(post);
        }
    }

    @Test
    public void testSelectDiscussPostRows(){
        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
    }

}

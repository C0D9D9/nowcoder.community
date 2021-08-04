package com.nowcoder.mycommunity.dao;

import com.nowcoder.mycommunity.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectById(int id);

    //搜索用户
    User selectByName(String username);

    //搜索用户
    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);

}

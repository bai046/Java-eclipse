package com.ying.dao;

import com.ying.pojo.User;
import com.ying.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class UserDaoTest {
    @Test
    public void test() {
        SqlSession sqlSession =
                MybatisUtils.getSqlSession();
        UserDao userDao =
                sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }
}

package com.pn.mapper;

import com.pn.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {




        //增加一些操作
        public List<User> selectUser() {
            User user = new User(5, "小王", "185161");
            UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
            mapper.addUser(user);
            mapper.deleteUser(5);

            return mapper.selectUser();
        }

        //新增
        public int addUser(User user) {
            return getSqlSession().getMapper(UserMapper.class).addUser(user);
        }

        //删除
        public int deleteUser(int id) {
            return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
        }
    }


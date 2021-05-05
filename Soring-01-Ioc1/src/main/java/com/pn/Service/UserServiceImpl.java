package com.pn.Service;

import com.pn.dao.UserDao;
import com.pn.dao.UserDaoImpl;
import com.pn.dao.UserDaoMysql;

public class UserServiceImpl implements UserService{

   /* //一开始写死，引入dao层接口
  private UserDao userDao=new UserDaoImpl();
  //当dao层有多个实现同一接口时 重新new一个添加方法或者直接把
    //new UserDaoImpl();改为UserDaoMysql();不方便
    //private UserDao userDao=new UserDaoMysql();
    private UserDao userDao2=new UserDaoMysql();
    public void getUser() {
        userDao.getUser();
        userDao2.getUser();
    }*/
     private  UserDao userDao;
     //利用set进行动态实现值的注入 程序由主动性变为被动接受的对象
    //不用管理程序的对象创建，耦合性降低 IOC原型
    public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }
    public void getUser() {
        userDao.getUser();
    }

}

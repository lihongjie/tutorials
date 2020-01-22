package xiaojiang.mybatisdemo.dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import xiaojiang.mybatisdemo.entity.User;

import java.util.List;

public class UserDaoTest {
    UserDao userDao;
    @Before
    public void setUp() throws Exception {
        userDao = new UserDao();
    }
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void selectUserById() throws Exception{
        User user = userDao.selectUserById(2);
        System.out.println(user);
        Assert.assertNotNull(user);
    }

    @Test
    public void selectUserChoose() throws Exception{

        User dto = new User();
        dto.setName("H");
        User user = userDao.selectUserChoose(dto);
        System.out.println(user);
        Assert.assertNotNull(user);
    }

    @Test
    public void selectUserByName() throws Exception{
        List<User> users = userDao.selectUserByName("江");
        System.out.println(users);
        Assert.assertNotNull(users);
    }

    @Test
    public void insertUser() throws Exception {
        User user = new User();
        user.setId(5);
        user.setName("小郑");
        user.setSex("女");
        Assert.assertEquals(1,userDao.insertUser(user));
    }

    @Test
    public void updateUser() throws Exception {
        User user = userDao.selectUserById(5);
        user.setName("大郑");
        Assert.assertEquals(1,userDao.updateUser(user));
    }

    @Test
    public void deleteUser() throws Exception {
        Assert.assertEquals(1,userDao.deleteUser(5));
    }
}
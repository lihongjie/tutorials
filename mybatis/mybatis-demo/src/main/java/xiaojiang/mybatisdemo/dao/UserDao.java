/**
 * FileName: UserDao
 * Author:   小江
 * Date:     2019/2/4 22:50
 * History:
 */
package xiaojiang.mybatisdemo.dao;

import org.apache.ibatis.session.SqlSession;
import xiaojiang.mybatisdemo.entity.User;
import xiaojiang.mybatisdemo.utils.SqlSessionFactoryUtil;

import java.util.List;

public class UserDao {
    /**
    *@Author 小江  [com.zhbit]
    *@Date 2019/2/4 22:51
    *Description   根据用户id查找用户对象
    */
    public User selectUserById(int id) {
        User user = null;
        //打开一个会话
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession(true);
        //查询单个对象
        user = sqlSession.selectOne("xiaojiang.mybatisdemo.mapper.userMapper.selectUserById",id);
        //关闭会话
        SqlSessionFactoryUtil.closeSession(sqlSession);
        return user;
    }

    public User selectUserChoose(User dto) {
        User user = null;
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession(true);
        //查询单个对象
        user = sqlSession.selectOne("xiaojiang.mybatisdemo.mapper.userMapper.selectUserChoose", dto);
        //关闭会话
        SqlSessionFactoryUtil.closeSession(sqlSession);
        return user;
    }

    /**
    *@Author 小江  [com.zhbit]
    *@Date 2019/2/11 17:49
    *Description   根据用户名称查找用户集合
    */
    public List<User> selectUserByName(String name){
        List<User> users = null;
        //打开一个会话
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession(true);
        //查询多个对象
        users = sqlSession.selectList("xiaojiang.mybatisdemo.mapper.userMapper.selectUserByName",name);
        //关闭会话
        SqlSessionFactoryUtil.closeSession(sqlSession);
        return users;
    }

    /**
    *@Author 小江  [com.zhbit]
    *@Date 2019/2/11 17:50
    *Description   插入用户
    */
    public int insertUser(User user){
        int rows = 0;
        //打开一个会话
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession(true);
        //查询多个对象
        rows = sqlSession.insert("xiaojiang.mybatisdemo.mapper.userMapper.insertUser",user);
        //关闭会话
        SqlSessionFactoryUtil.closeSession(sqlSession);
        return rows;
    }

    /**
    *@Author 小江  [com.zhbit]
    *@Date 2019/2/11 17:50
    *Description   修改用户
    */
    public int updateUser(User user){
        int rows = 0;
        //打开一个会话
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession(true);
        //查询多个对象
        rows = sqlSession.update("xiaojiang.mybatisdemo.mapper.userMapper.updateUser",user);
        //关闭会话
        SqlSessionFactoryUtil.closeSession(sqlSession);
        return rows;
    }

    /**
    *@Author 小江  [com.zhbit]
    *@Date 2019/2/11 17:51
    *Description   删除用户
    */
    public int deleteUser(int id){
        int rows = 0;
        //打开一个会话
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession(true);
        //查询多个对象
        rows = sqlSession.update("xiaojiang.mybatisdemo.mapper.userMapper.deleteUser",id);
        //关闭会话
        SqlSessionFactoryUtil.closeSession(sqlSession);
        return rows;
    }
}
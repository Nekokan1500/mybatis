import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.arthur.learn.mybatis.mapper.ParameterMapper;
import com.arthur.learn.mybatis.mapper.UserMapper;
import com.arthur.learn.mybatis.util.SqlSessionUtils;
import com.arthur.learn.mybatis.entity.User;

public class MyBatisTest {

    @Test
    public void testMyBatisCUD() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);    // set autocommit = true
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //int i = userMapper.insertUser();
        //int i = userMapper.updateUser();
        int i = userMapper.deleteUser();
        System.out.println(i);
    }

    @Test
    public void testGetUser() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);    // set autocommit = true
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //User user = userMapper.getUserById();
        List<User> users = userMapper.getAllUser();
        users.forEach(System.out::println);
        //System.out.println(user);
    }

    @Test
    public void testGetAllUsers() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        parameterMapper.getAllUsers().forEach(user -> System.out.println(user));
    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        User user = parameterMapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void testCheckLogin() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        User user = parameterMapper.checkLogin("Zhang Ziyi", "fast1234");
        System.out.println(user);
    }

    @Test
    public void testCheckLoginByMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Zhang Ziyi");
        map.put("password", "fast1234");
        User user = parameterMapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        int ret = parameterMapper.insertUser(new User(null, "Marcia Dong", "123456", "San Diego", "1388888888"));
        System.out.println(ret);
    }

    @Test
    public void testCheckLoginByParam() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        User user = parameterMapper.checkLoginByParam("Zhang Ziyi", "fast1234");
        System.out.println(user);
    }
}

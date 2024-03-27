import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
}

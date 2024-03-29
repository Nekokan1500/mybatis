import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.arthur.learn.mybatis.mapper.SQLMapper;
import com.arthur.learn.mybatis.entity.User;
import com.arthur.learn.mybatis.util.SqlSessionUtils;

public class SQLMapperTest {
    
    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> users = mapper.getUserByLike("a");
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void testDeleteUsers(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int ret = mapper.deleteUsers("5,6");
        System.out.println(ret);
    }

    @Test
    public void testGetAllUsers(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> users = mapper.getUsersByTableName("t_user");
        System.out.println(users);
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(null, "Fenghua Zhao", "123456", "Irvine", "858-123-4567");
        mapper.insertUser(user);
        System.out.println(user.getId());
    }
}

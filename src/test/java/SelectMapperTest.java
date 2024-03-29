import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.arthur.learn.mybatis.entity.User;
import com.arthur.learn.mybatis.mapper.SelectMapper;
import com.arthur.learn.mybatis.util.SqlSessionUtils;

public class SelectMapperTest {

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        User user = selectMapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void testGetAllUsers() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        List<User> users = selectMapper.getAllUsers();
        users.forEach(System.out::println);
    }

    @Test
    public void testGetUserCount() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        int count = selectMapper.getUserCount();
        System.out.println(count);
    }

    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(selectMapper.getUserByIdToMap(1));
    }

    @Test
    public void testGetAllUsersToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        //System.out.println(selectMapper.getAllUsersToMap());
        System.out.println(selectMapper.getAllUsersToMap2());
    }
}

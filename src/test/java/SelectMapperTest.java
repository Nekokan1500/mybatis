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

}

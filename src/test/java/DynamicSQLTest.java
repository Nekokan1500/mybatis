import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.arthur.learn.mybatis.entity.Emp;
import com.arthur.learn.mybatis.mapper.DynamicSQLMapper;
import com.arthur.learn.mybatis.util.SqlSessionUtils;

public class DynamicSQLTest {
    
    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empList = mapper.getEmpByCondition(new Emp(null, "Arthur", null, null, null));
        System.out.println(empList);
    }

    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empList = mapper.getEmpByChoose(new Emp(null, "Arthur", null, null, null));
        System.out.println(empList);
    }

    @Test
    public void testBatchDelete(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int ret = mapper.deleteMoreByArray(new Integer[]{4,5});
        System.out.println(ret);
    }

    @Test
    public void testBatchInsert(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "a", 23, "M", "123@qq.com");
        Emp emp2 = new Emp(null, "a", 23, "M", "123@qq.com");
        Emp emp3 = new Emp(null, "a", 23, "M", "123@qq.com");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        int ret = mapper.insertMoreByList(emps);
        System.out.println(ret);
    }
}

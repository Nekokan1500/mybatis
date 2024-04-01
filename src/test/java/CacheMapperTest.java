import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.arthur.learn.mybatis.entity.Emp;
import com.arthur.learn.mybatis.mapper.CacheMapper;
import com.arthur.learn.mybatis.util.SqlSessionUtils;

public class CacheMapperTest {
    
    @Test
    public void testGetEmpById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper1 = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);
        CacheMapper mapper2 = sqlSession.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpById(1);
        System.out.println(emp2);
    }

    @Test
    public void testLv1Cache(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpById(1);
        System.out.println(emp1);
        mapper.insertEmp(new Emp(null, "b", 24, "M", "123@mail.com"));
        // sqlSession.clearCache();
        Emp emp2 = mapper.getEmpById(1);
        System.out.println(emp2);
    }

    @Test 
    public void testLv2Cache(){
        try{
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CacheMapper mapper = sqlSession1.getMapper(CacheMapper.class);
            System.out.println(mapper.getEmpById(1));
            sqlSession1.close();
            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpById(1));
            sqlSession2.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        
    }

}

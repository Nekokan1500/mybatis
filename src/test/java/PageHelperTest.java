import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.arthur.learn.mybatis.mapper.EmpMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

public class PageHelperTest {

    /**
     * limit, index, pageSize
     * index: starting index of current page
     * pageSize: number of rows per page
     * pageNum: page number of current page
     * index = (pageNum - 1) * pageSize
     */

    @Test
    public void testPageHelper() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //Page<Object> page = PageHelper.startPage(1, 4);
            PageHelper.startPage(1, 4);
            /*
            List<Emp> emps = mapper.selectByExample(null);
            PageInfo<Emp> pageInfo = new PageInfo<>(emps, 5);
            emps.forEach(emp -> System.out.println(emp));
            */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

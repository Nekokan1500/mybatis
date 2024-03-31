import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.arthur.learn.mybatis.entity.Dept;
import com.arthur.learn.mybatis.entity.Emp;
import com.arthur.learn.mybatis.mapper.DeptMapper;
import com.arthur.learn.mybatis.mapper.EmpMapper;
import com.arthur.learn.mybatis.util.SqlSessionUtils;

public class ResultMapTest {

    @Test
    public void testGetAllEmps() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> users = empMapper.getAllEmps();
        System.out.println(users);
    }

    @Test
    public void testEmpJoinDept() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.getEmpAndDept(3);
        System.out.println(emp);
    }

    @Test
    public void testEmpJoinDeptByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.getEmpAndDeptByStepOne(1);
        System.out.println(emp.getEmpName());
    }

    @Test
    public void testGetDpetAndEmps(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.getDeptAndEmps(1);
        System.out.println(dept);

    }
    
    @Test
    public void testDeptJoinEmpByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.getDeptAndEmpsStepOne(1);
        System.out.println(dept);
    }
}

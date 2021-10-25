package cn.itnanls.dao;

import cn.itnanls.entity.Dept;
import cn.itnanls.entity.Employee;
import cn.itnanls.entity.User;
import cn.itnanls.mapper.DeptMapper;
import cn.itnanls.mapper.EmployeeMapper;
import cn.itnanls.utils.CacheUtil;
import com.mysql.cj.Session;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class DeptMapperTest {
    SqlSessionFactory sqlSessionFactory=null;
    DeptMapper deptMapper=null;
    SqlSession session=null;
    @Before
    public void before(){
        //构建一个session工厂
        InputStream resource = User.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        sqlSessionFactory = sqlSessionFactoryBuilder.build(resource);
        //获取session
        session=sqlSessionFactory.openSession();
        //回去代理对象
        deptMapper = session.getMapper(DeptMapper.class);
    }

    @Test
    public void selectAllDeptsTest(){
        List<Dept> depts = deptMapper.selectAllDepts();
        for (Dept dept : depts) {
            System.out.println(dept);
        }
    }

    @Test
    public void selectAllDeptsCacheTest(){
        Map<String,Object> cache =new HashMap<>(8);
        List<Dept> depts = deptMapper.selectAllDepts();
        cache.put("selectAllDeptsTest",depts);
        for (Dept dept : depts) {
            System.out.println(dept);
        }
        //下一次查询的时候先去缓存看看 看看有没有
        System.out.println("第二次---------");
        List<Dept> depts2=null;
        boolean flag = cache.containsKey("selectAllDeptsTest");
        if (flag){
            System.out.println("走缓存");
            depts2=(List<Dept>)cache.get("selectAllDeptsTest");
        }else {
            System.out.println("走sql");
            depts2=deptMapper.selectAllDepts();
        }
        for (Dept dept2 : depts2) {
            System.out.println(dept2);
        }
    }

    /**
     * 一级缓存mybatis默认是开启的 一级缓存是sqlsession级别的缓存
     */
    @Test
    public void selectAllDeptsCache1Test(){
        Map<String,Object> cache =new HashMap<>(8);
        //执行方法
        System.out.println("第一次走数据库sql");
        List<Dept> depts = deptMapper.selectAllDepts();
        for (Dept dept : depts) {
            System.out.println(dept);
        }
        System.out.println("第二次走缓存");
        List<Dept> depts2 = deptMapper.selectAllDepts();
        for (Dept dept2 : depts2) {
            System.out.println(dept2);
        }
    }

    @Test
    public void selectAllDeptsCache1sxTest(){
        Map<String,Object> cache =new HashMap<>(8);
        //执行方法
        System.out.println("第一次走数据库sql");
        List<Dept> depts = deptMapper.selectAllDepts();
        for (Dept dept : depts) {
            System.out.println(dept);
        }
        session.commit();
        SqlSession session2 =sqlSessionFactory.openSession();
        DeptMapper deptmapper2 = session2.getMapper(DeptMapper.class);
        System.out.println("第二次走缓存");
        List<Dept> depts2 = deptmapper2.selectAllDepts();
        for (Dept dept2 : depts2) {
            System.out.println(dept2);
        }
    }


    /**
     * 二级缓存是mapper(命名空间)级别的缓存 需要我们自己开启
     */
    @Test
    public void selectAllDeptsCache2Test(){
        Map<String,Object> cache =new HashMap<>(8);
        //执行方法
        System.out.println("第一次走数据库sql");
        List<Dept> depts = deptMapper.selectAllDepts();
        for (Dept dept : depts) {
            System.out.println(dept);
        }
        session.commit();
        SqlSession session2 =sqlSessionFactory.openSession();
        DeptMapper deptmapper2 = session2.getMapper(DeptMapper.class);
        System.out.println("第二次走缓存");
        List<Dept> depts2 = deptmapper2.selectAllDepts();
        for (Dept dept2 : depts2) {
            System.out.println(dept2);
        }
    }

    @Test
    public void testEhcache(){
      final CacheManager cacheManager=new CacheManager((this.getClass().getClassLoader().getResourceAsStream("ehcache.xml")));
        String[] cacheNames = cacheManager.getCacheNames();
        Cache dept = cacheManager.getCache("dept");
        Element element=new Element("id","aaa");
        dept.put(element);
        System.out.println(dept.get("id").getObjectValue());
    }

    @Test
    public void selectAllDeptsCache3zdyTest(){
        Map<String,Object> cache =new HashMap<>(8);
        //执行方法
        System.out.println("第一次走数据库sql");
        List<Dept> depts = deptMapper.selectAllDepts();
        CacheUtil.put("dept","selectAllDeptsCache3zdyTest",depts);
        for (Dept dept : depts) {
            System.out.println(dept);
        }
        session.commit();
        session =sqlSessionFactory.openSession();
        //去缓存拿，如果有就拿出来
        List<Dept> depts2=null;
        Object object = CacheUtil.get("dept", "selectAllDeptsCache3zdyTest");
        if (object==null){
            //去数据库查询
            DeptMapper mapper = session.getMapper(DeptMapper.class);
            depts2 = mapper.selectAllDepts();
        }else {
            depts2= (List<Dept>) object;
        }
        //如果有其他的事务修改了dept的内容 ，手动调用CacheUtil.delete()方法把缓存干掉

        for (Dept dept : depts2) {
            System.out.println(dept);
        }
    }
    @After
    public void  after(){
        session.commit();
        //如果遇到问题要回滚
        //session.rollback();
        session.close();
    }
}

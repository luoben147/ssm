package com.luoben.test;

import com.luoben.dao.AccountDao;
import com.luoben.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    /**
     * 查询
     * @throws Exception
     */
    @Test
    public void run1() throws Exception {
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //创建SqlSession
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        List<Account> list = dao.findAll();

        for(Account account :list){
            System.out.println(account);
        }

        //关闭资源
        session.close();
        is.close();
    }

    /**
     * 保存
     * @throws Exception
     */
    @Test
    public void run2() throws Exception {
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //创建SqlSession
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //保存
        Account account=new Account();
        account.setName("滴滴");
        account.setMoney(333d);

        dao.saveAccount(account);
        //提交事务
        session.commit();

        //关闭资源
        session.close();
        is.close();
    }

}

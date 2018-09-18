package com.demo.tempsprboot.dao;

import com.demo.tempsprboot.pojos.Demo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoDaoTest {

    @Autowired
    DemoDao demoDao;

    private Demo demo;

    @Before
    public void setUp() throws Exception {
        demo = Demo.builder().id("001").name("张三").age("18").build();
    }

    @Test
    public void testFindAll(){
        demoDao.save(demo);

        Assert.assertEquals("001",demoDao.findAll().get(0).getId());
    }

}
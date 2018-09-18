package com.demo.tempsprboot.dao;

import com.demo.tempsprboot.pojos.Demo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoDaoTest {

    @Autowired
    DemoDao demoDao;

    private Demo demo;

    @Before
    public void setUp() throws Exception {
        demo = Demo.builder().id("005").name("aaa").age("18").build();
    }

    @Test
    public void testAddDemo() {
        Assert.assertEquals(1,demoDao.addDemo(demo));

    }
}
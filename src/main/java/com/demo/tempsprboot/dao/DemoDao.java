package com.demo.tempsprboot.dao;

import com.demo.tempsprboot.pojos.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemoDao extends JpaRepository<Demo, String> {
    List<Demo> findAll();
}

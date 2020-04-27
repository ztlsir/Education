package com.ztlsir.homework.dao;

import com.ztlsir.homework.entity.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeworkDao extends JpaRepository<Homework,String> {
}

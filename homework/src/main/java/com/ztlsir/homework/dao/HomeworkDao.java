package com.ztlsir.homework.dao;

import com.ztlsir.homework.entity.Homeworks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeworkDao extends JpaRepository<Homeworks,String> {
}

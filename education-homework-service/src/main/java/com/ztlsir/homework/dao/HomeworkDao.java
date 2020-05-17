package com.ztlsir.homework.dao;

import com.ztlsir.homework.entity.HomeworkPO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeworkDao extends JpaRepository<HomeworkPO,String> {
}

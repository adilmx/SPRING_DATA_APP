package com.adilmx.spring_data_app.dao;

import com.adilmx.spring_data_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

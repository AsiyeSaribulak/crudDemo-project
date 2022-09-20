package com.etiya.proje3.repository;

import com.etiya.proje3.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
}

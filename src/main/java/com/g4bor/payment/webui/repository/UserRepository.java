package com.g4bor.payment.webui.repository;

import com.g4bor.payment.webui.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}

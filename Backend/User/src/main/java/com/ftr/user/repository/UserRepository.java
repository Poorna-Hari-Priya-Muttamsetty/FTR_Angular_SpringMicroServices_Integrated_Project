package com.ftr.user.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ftr.user.entity.User;

@Qualifier("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
	@Query("select u from User u where u.email_id = ?1")
	Optional<User> findByEmailId(String email_id);
}

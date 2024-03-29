package com.example.goodWriting.domain.post.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.goodWriting.domain.post.domain.Post;
import com.example.goodWriting.domain.user.domain.User;

public interface PostRepository extends JpaRepository<Post,Long> {
		List<Post> findAllByOrderByIdDesc();
		boolean existsByUrl(String url);
}

package com.example.demo.Reposatories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entities.Supermarket;

public interface SupermarketReposatory extends JpaRepository<Supermarket, Long> {
	@Query("select s from Supermarket s where s.activation ='Y'")
	List<Supermarket> findAllActiveSupermarkets();

	@Query("select s from Supermarket s where s.activation ='N'")
	List<Supermarket> findAllNotActiveSupermarkets();
}

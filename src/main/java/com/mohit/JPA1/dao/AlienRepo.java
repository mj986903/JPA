package com.mohit.JPA1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mohit.JPA1.model.Alien;

@Repository
// public interface AlienRepo extends CrudRepository<Alien,Integer>{
public interface AlienRepo extends JpaRepository<Alien,Integer>{
	List<Alien> findByTech(String tech);
	List<Alien> findByAidGreaterThan(int aid);
	
	// @Query("FROM ALIEN WHERE TECH=?1 ORDER BY aname")
	// List<Alien> findByTechSorted(String tech);
}

package com.cos.blog.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductionRepository extends JpaRepository<Production, Integer>{

	@Query("select * from product where date like  %:month%")
	List<Production> searchByProductionLike(@Param("month") String month);
	
//	List<Production> findByProductionDateContaining(String month);
	
}

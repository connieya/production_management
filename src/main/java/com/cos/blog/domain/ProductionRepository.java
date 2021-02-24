package com.cos.blog.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductionRepository extends JpaRepository<Production, Integer>{

	@Query(value = "select * from product where date like %:month% order by substring_index(Date,'-',-1)" ,nativeQuery = true)
	List<Production> searchByProductiondateLike(@Param("month") String month);
	
	List<Production> findByProductionDateContaining(String month);
	
	@Query(value = "select * from product where target = ?1" ,nativeQuery = true)
	List<Production> findByTarget(int target);
	
	@Query(value = "select * from product where date =?1", nativeQuery = true)
	Production findByDate(String date);
}

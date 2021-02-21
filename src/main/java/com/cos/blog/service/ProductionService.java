package com.cos.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.domain.Production;
import com.cos.blog.domain.ProductionRepository;
import com.cos.blog.dto.ProductionDto;

@Service
public class ProductionService {
	
	@Autowired
	ProductionRepository productionRepository;
	
	@Transactional
	public void 데이터입력하기(Production dto) {
		
		System.out.println("service 데이터 값 : " +dto  );
		productionRepository.save(dto);
		
	}
	
	@Transactional
	public List<Production> 데이터가져오기(String month) {
		
		return productionRepository.searchByProductionLike(month);
		//return productionRepository.findByProductionDateContaining(month);
		
	}
}

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
		
		return productionRepository.searchByProductiondateLike(month);
//		return productionRepository.findByProductionDateContaining(month);
		
	}
	
	@Transactional
	public List<Production> 입력한목표치리스트(int target){
		
		return productionRepository.findByTarget(target);
	}
	
	@Transactional
	public Production 선택한날짜데이터가져오기(String day) {
		
		return productionRepository.findByDate(day);
	}
	
	@Transactional
	public void 선택할날짜데이터수정하기(int id, Production productResp) {
		
		Production product = productionRepository.findById(id)
				.orElseThrow( () -> {
					return new IllegalArgumentException("글 찾기 실패: 아이디를 찾을수없습니다");
				});
		
		product.setProduct(productResp.getProduct());
		product.setTarget(productResp.getTarget());
		
	}
	@Transactional
	public void 선택한날짜데이터삭제하기(int id) {
		productionRepository.deleteById(id);
	}
}

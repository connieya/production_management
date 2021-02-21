package com.cos.blog.domain;


import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Production {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="Id" , nullable =false)
	private int id;
	
//	@Column(columnDefinition = "varchar(100) defalut, 'A001")
	@Column(name="Kind" ,nullable =false)
	private String kind = "A001";
	
	@Column(name="Target" ,nullable = false)
	private int target;
	
	@Column(name ="Product" ,nullable = false)
	private int product;
	
	
//	@CreationTimestamp 현재 시간을 입력하는 어노테이션
	@Column(name ="Date" , nullable = false)
	private String productionDate;

}

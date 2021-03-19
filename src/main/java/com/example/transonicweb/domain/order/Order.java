package com.example.transonicweb.domain.order;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="order_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    //注文番号
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	//ISBN番号
	@Column(length = 40, nullable = false)
	private String isbn;
	//注文日
	@Column(nullable = false)	
	private Date orderDate;
	//注文個数
	@Column(nullable = false)
	private int numOfOrder;
	//全受領フラグ
	@Column(nullable = false)	
	private boolean receiptFlg;
}

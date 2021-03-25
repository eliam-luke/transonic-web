package com.example.transonicweb.domain.order;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@EntityListeners(AuditingEntityListener.class)
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
	
    @Column(updatable = false, nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(updatable = false, nullable = false)
    @CreatedBy
    private String createdBy;

    @Column(nullable = false)
    @LastModifiedBy
    private String updatedBy;
}

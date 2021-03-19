package com.example.transonicweb.domain.product;

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
@Table(name="product_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	
	@Column(length= 40, nullable = false)
	private String isbn;
	
	@Column(length=10, nullable=false)
	private String genre;
	
	@Column(length=20, nullable=false)
	private String author;
	
	@Column(length=20, nullable=false)
	private String title;
	
	@Column
	private int stock;
	
    @Column
	private Boolean status;

    //出版社
	@Column(length=50, nullable=true)
	private String publisher;
	//発行年
	@Column(nullable = true)
	private int publicationYear;
	//単価
	@Column(nullable = true)
	private int unitPrice;
}

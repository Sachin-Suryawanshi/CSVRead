package com.thinkitive.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table
public class AmazonProduct {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long amazonProductId;
//	@Type(type = "uuid-char")
//	@GenericGenerator(
//			name = "UUID",
//			strategy = "org.hibernate.id.UUIDGenerator")
	
	private String articleNumber;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productId")
	private Product product;
	public AmazonProduct() {
		// TODO Auto-generated constructor stub
	}
	public AmazonProduct(Long amazonProductId, String articleNumber, Product product) {
		super();
		this.amazonProductId = amazonProductId;
		this.articleNumber = articleNumber;
		this.product = product;
	}
	public Long getAmazonProductId() {
		return amazonProductId;
	}
	public void setAmazonProductId(Long amazonProductId) {
		this.amazonProductId = amazonProductId;
	}
	public String getArticleNumber() {
		return articleNumber;
	}
	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "AmazonProduct [amazonProductId=" + amazonProductId + ", articleNumber=" + articleNumber + ", product="
				+ product + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amazonProductId == null) ? 0 : amazonProductId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AmazonProduct other = (AmazonProduct) obj;
		if (amazonProductId == null) {
			if (other.amazonProductId != null)
				return false;
		} else if (!amazonProductId.equals(other.amazonProductId))
			return false;
		return true;
	}
	
	
	

}

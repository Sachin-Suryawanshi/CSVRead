package com.thinkitive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectTask1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjectTask1Application.class, args);
	}
//	@Autowired
//	ProductRepository productRepo;
//	
//	@Autowired
//	AmazonProductRepository amzRepo;
//	@Override
//	public void run(String... args) throws Exception {
//	Product p=new Product();
//	p.setProductName("Abc");
//	AmazonProduct ap=new AmazonProduct();
//	ap.setArticleNumber("12233");
//	p.setAmazonProduct(ap);
//	ap.setProduct(p);
//	amzRepo.save(ap);
//	
//		
//	}

}

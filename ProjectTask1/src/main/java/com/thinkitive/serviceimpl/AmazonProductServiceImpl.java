package com.thinkitive.serviceimpl;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.entity.AmazonProduct;
import com.thinkitive.repository.AmazonProductRepository;
import com.thinkitive.services.AmazonProductService;
@Service
public class AmazonProductServiceImpl implements AmazonProductService {
	//String excelFilePath = "src/main/resources/demo.xlsx";
	@Autowired
	AmazonProductRepository amazonProductRepository;
	
	@Override
	public AmazonProduct addAmazonProduct(AmazonProduct amazonProduct) {
		
		amazonProductRepository.save(amazonProduct);
	

		return amazonProduct;
	}

}

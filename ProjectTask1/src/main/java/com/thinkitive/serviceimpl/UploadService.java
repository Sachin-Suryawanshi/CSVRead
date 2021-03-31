package com.thinkitive.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.thinkitive.entity.AmazonProduct;
import com.thinkitive.entity.Product;
import com.thinkitive.repository.AmazonProductRepository;
import com.thinkitive.repository.ProductRepository;

@Service
public class UploadService {
	@Autowired
	AmazonProductRepository amazonRepository;
	@Autowired
	AmazonProductServiceImpl amazonProductService;
	@Autowired
	ProductServiceImpl productServiceImpl;
	@Autowired
	ProductRepository productRepository;

	public void upload(MultipartFile file) throws Throwable {
		Path tempDir = Files.createTempDirectory("");
		File tempFile = tempDir.resolve(file.getOriginalFilename()).toFile();
		file.transferTo(tempFile);
		Workbook workBook = WorkbookFactory.create(tempFile);
		Sheet sheet = workBook.getSheetAt(0);
		Iterator<Row> rows = sheet.iterator();
		while (rows.hasNext()) {
			Row currentRow = rows.next();
			Iterator<Cell> cellInRow = currentRow.iterator();
			int cellIdx = 0;
			Product product = new Product();
			AmazonProduct amazonProduct = new AmazonProduct();
			while (cellInRow.hasNext()) {
				Cell currentCell = cellInRow.next();

				switch (cellIdx) {
				case 0:
					String productName = currentCell.getStringCellValue();
					System.out.println(productName);
					product.setProductName(productName);
					break;
				case 1:
					Long articleNumber = (long) currentCell.getNumericCellValue();
					amazonProduct.setArticleNumber(Long.toString(articleNumber));
					System.out.println(articleNumber);
					break;
				case 2:
					Long productId = (long) currentCell.getNumericCellValue();
					product.setProductId(productId);
					System.out.println(productId);
					break;
				case 3:
					Long amzId = (long) currentCell.getNumericCellValue();
					amazonProduct.setAmazonProductId(amzId);
					System.out.println(amzId);
					break;
				}
				product.setAmazonProduct(amazonProduct);
				cellIdx++;

			}
			
//			amazonProduct.setProduct(product);
			System.out.println(product);
//			if(amazonRepository.findByArticleNumber(amazonProduct.getArticleNumber())==null && productRepository.findById(product.getProductId())==null)
//			{
			productServiceImpl.addProduct(product);
			System.out.println("Added");

		}

	}

}

//switch(currentCell.getCellType())
//{
//
//case STRING:String productName=currentCell.getStringCellValue();
//System.out.println(productName);
//break;
//case NUMERIC:
//Long id=(long) currentCell.getNumericCellValue();
//Long productId=(long) currentCell.getNumericCellValue();
//System.out.println(id);
//break;
//}

//Stream<Row> rowStream=StreamSupport.stream(sheet.spliterator(), false);
//rowStream.forEach(row->{
//	Stream<Cell> cellStream=StreamSupport.stream(row.spliterator(), false);
//	List<String> cellVals=cellStream.map(cell->{
//		String cellVal=cell.getStringCellValue();
//		return cellVal;
//	}).collect(Collectors.toList());
//	System.out.println(cellVals);
//});

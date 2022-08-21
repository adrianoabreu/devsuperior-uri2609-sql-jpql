package com.devsuperior.uri2609;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import com.devsuperior.uri2609.repositories.CategoryRepository;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("*** Resultado SQL ***");
		List<CategorySumProjection> list = repository.search1();
		List<CategorySumDTO> resultSQL = list.stream().map(x -> new CategorySumDTO(x)).collect(Collectors.toList());
		
		for(CategorySumDTO obj : resultSQL) {
			System.out.println(obj);
		}
		
		System.out.println("\n");
		
		System.out.println("*** Resultado JPQL ***");
		List<CategorySumDTO> resultJPQL = repository.search2();
		
		for(CategorySumDTO obj : resultJPQL) {
			System.out.println(obj);
		}
	}
}

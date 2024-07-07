package com.javatechie.aws.lambda;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.Order;
import com.javatechie.aws.lambda.respository.OrderDao;

@SpringBootApplication
@RestController
@RequestMapping("/orders")
public class SpringbootAwsApplication {

	@Autowired
	OrderDao orderDao;

	@GetMapping
	public List<Order> getBooks() {
		return orderDao.buildOrders().stream().sorted(Comparator.comparing(Order::getPrice)).collect(Collectors.toList());// //
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAwsApplication.class, args);
	}

}

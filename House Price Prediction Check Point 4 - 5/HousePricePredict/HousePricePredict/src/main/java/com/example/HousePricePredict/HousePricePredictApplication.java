package com.example.HousePricePredict;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HousePricePredictApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HousePricePredictApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Cetak URL aplikasi ke konsol
		System.out.println("House Price Prediction Application is running at: http://localhost:8081/");
	}
}

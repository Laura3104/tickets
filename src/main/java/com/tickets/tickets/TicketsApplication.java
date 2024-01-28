package com.tickets.tickets;

import com.tickets.tickets.service.DataMigrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketsApplication implements CommandLineRunner {

	private final DataMigrationService dataMigrationService;

	@Autowired
	public TicketsApplication(DataMigrationService dataMigrationService) {
		this.dataMigrationService = dataMigrationService;
	}

	public static void main(String[] args) {
		SpringApplication.run(TicketsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dataMigrationService.migrateData();
	}
}

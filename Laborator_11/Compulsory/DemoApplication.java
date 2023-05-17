package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		Player player1 = new Player("player1", 'A');
		Player player2 = new Player("player2", 'B');
		Player player3 = new Player("player3", 'C');
		Player player4 = new Player("player4", 'C');
		Player player5 = new Player("player5", 'D');
		Player player6 = new Player("player6", 'E');

		PlayerService playerService = new PlayerService();

		playerService.addPlayer(player1);
		playerService.addPlayer(player2);
		playerService.addPlayer(player3);
		playerService.addPlayer(player4);
		playerService.addPlayer(player5);
		playerService.addPlayer(player6);

		SpringApplication.run(DemoApplication.class, args);
	}

}

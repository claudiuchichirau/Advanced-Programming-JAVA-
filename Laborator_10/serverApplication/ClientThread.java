package org.example.compulsory.serverApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ClientThread extends Thread {
    private final Socket clientSocket;
    private final GameServer gameServer;

    public ClientThread(Socket clientSocket, GameServer gameServer) {
        this.clientSocket = clientSocket;
        this.gameServer = gameServer;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true))
        {
            out.println("Connected to the server.");
            while (true) {
                String request = in.readLine();
                if (request == null) {
                    break;
                }

                String[] parts = request.split(" ");
                String command = parts[0];

                out.println("Server received the request [" + command + "]");

                System.out.println("Server received the request [" + command + "]");

                switch (command) {
                    case "create":
                        if (parts.length != 2) {
                            out.println("Invalid command syntax.");
                            break;
                        }
                        out.println("Game created!");
                        break;

                    case "play":
//                        if (parts.length != 4) {
//                            out.println("Invalid command syntax.");
//                            break;
//                        }
//                        String gameToPlay = parts[1];
//                        String playerToPlay = parts[2];
//                        String move = parts[3];
//                        Game gameToPlayObj = null;
//                        for (Game g : games) {
//                            if (g.getName().equals(gameToPlay)) {
//                                gameToPlayObj = g;
//                                break;
//                            }
//                        }
//                        if (gameToPlayObj == null) {
//                            out.println("Game not found: " + gameToPlay);
//                        } else {
//                            String playResult = gameToPlayObj.play(playerToPlay, move);
//                            out.println(playResult);
//                            if (playResult.contains("wins!")) {
//                                games.remove(gameToPlayObj);
//                            }
//                        }
//                        break;
                    case "stop":
                        if (parts.length != 1) {
                            out.println("Invalid command syntax.");
                            break;
                        }
                        out.println("Client stopped.");
                        gameServer.stopServer();
                        break;
                    case "exit":
                        System.out.println("Client stopped.");
                    default:
                        out.println("Invalid command: [" + command + "]");
                        break;

                }
            }
        } catch (IOException i) {
            System.out.println(i);
            return;
        }
    }
}


package com.mygdx.Handle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net.Protocol;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.ServerSocketHints;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;

import java.io.*;

public class GameServer {
	
	public void runSocket() {
		// to the server
		new Thread(new Runnable() {
			@Override
			public void run() {
				ServerSocketHints hints = new ServerSocketHints();
				hints.acceptTimeout = 5000;
				ServerSocket server = Gdx.net.newServerSocket(Protocol.TCP, 25016, hints);
				while(true) {
					final Socket client = server.accept(null);
					System.out.println("Client connected: " + client.getRemoteAddress());
					new Thread(new Runnable() {
						int connectionId;
						@Override
						public void run() {
								try {
									BufferedReader message = new BufferedReader(new InputStreamReader(
											client.getInputStream()));
									while(true) {
										String msg =message.readLine();
										Gdx.app.log("Got: ", msg);
										if (msg == null || msg.contains("GET /ping")) {
											break;
										}
										client.getOutputStream().write((client.getRemoteAddress()+"\n").getBytes());	
									}
								} catch (IOException e) {
									Gdx.app.log("Satus", "an error occured", e);
								}
						}	
					}).start();
				}
			}			
		}).start();				
	}
}

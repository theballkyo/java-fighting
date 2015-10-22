package com.mygdx.Handle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net.Protocol;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;

public class GameClient {
	
	SocketHints hints;
	Socket client;
	
	public GameClient() {
		
	}
	public void connect() {
		new Thread(new Runnable() {
			public void run() {
				hints = new SocketHints();
				hints.connectTimeout = 1000;
				hints.tcpNoDelay = true;
				client = Gdx.net.newClientSocket(Protocol.TCP, "localhost", 25016, hints);
			}
		}).start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(!client.isConnected()){ }
		Gdx.app.log(client.getRemoteAddress(), " is connected");
	}
	
	public void ping() {
		Gdx.app.log("Status", "Start Ping");
		synchronized(this){
		try {
			client.getOutputStream().write("PING\n".getBytes());
			client.getOutputStream().flush();
			String response = new BufferedReader(new InputStreamReader(client.getInputStream())).readLine();
			Gdx.app.log("Server msg", response);
		} catch (IOException e) {
			Gdx.app.log("PingPongSocketExample", "an error occured", e);
		}
		this.notify();
		}
		Gdx.app.log("Status", "End Ping");
	}
	
	public void updateCharactor(String name, int x, int y) {
		try {
			client.getOutputStream().write(String.format("name %s %d %d\n", name, x,y).getBytes());
			String response = new BufferedReader(new InputStreamReader(client.getInputStream())).readLine();
			Gdx.app.log("Okay", "!" + response);
		} catch (IOException e) {
			Gdx.app.log("PingPongSocketExample", "an error occured", e);
		}

	}
}

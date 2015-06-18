package com.udp.main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP {

	public static void main(String[] args) throws Exception {
				
		Scanner input = new Scanner(System.in);
	
		DatagramSocket clienteSocket = new DatagramSocket();
		
		InetAddress endereçoIP = InetAddress.getByName("localhost");
		byte[] enviaDados = new byte[1024];
		byte[] recebeDados = new byte[1024];
		
		String dados = "renata";
		
		enviaDados = dados.getBytes();
		
		DatagramPacket enviaPacote = new DatagramPacket(enviaDados, enviaDados.length, endereçoIP, 9988);
	
		clienteSocket.send(enviaPacote);
		
		
		
		DatagramPacket recebePacote = new DatagramPacket(recebeDados, recebeDados.length);
		
		clienteSocket.receive(recebePacote);
		
		String resposta = new String(recebePacote.getData());
		
		System.out.println("Servidor: "+ resposta);
		
		
		input.close();
		clienteSocket.close();		
	}

}

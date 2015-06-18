package com.udp.main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP {

	public static void main(String[] args) throws Exception {
		
		DatagramSocket ServidorSocket = new DatagramSocket(9988);
		byte[] dadosRecebidos = new byte[1024];
		byte[] dadosEnvidados = new byte[1024];
		
		while(true){
			DatagramPacket pacoteRecebido = new DatagramPacket(dadosRecebidos, dadosRecebidos.length);
			
			ServidorSocket.receive(pacoteRecebido);
			
			InetAddress endereçoIP = pacoteRecebido.getAddress();
			int porta = pacoteRecebido.getPort();
			
			String dadosTemp = new String(pacoteRecebido.getData());
			String dadosToSend = "";
			
				if(dadosTemp.equals("guarapari")){
					dadosToSend = "Buzios";
				}else if(dadosTemp.equals("renata")){
					dadosToSend = "Amor da Minha Vida";
				}else if(dadosTemp.equals("bolacha")){
					dadosToSend = "Biscoito";
				}else if(dadosTemp.equals("traz um")){
					dadosToSend = "Insenso pra mim velho, namoral!";
				}else{
					dadosToSend = "meu pai";
				}			
			
			dadosEnvidados = dadosToSend.getBytes();
		
			DatagramPacket pacoteEnviado = new DatagramPacket(dadosEnvidados, dadosEnvidados.length, endereçoIP, porta);
			
			ServidorSocket.send(pacoteEnviado);
			
			System.out.println(dadosTemp);

		}
	}

}

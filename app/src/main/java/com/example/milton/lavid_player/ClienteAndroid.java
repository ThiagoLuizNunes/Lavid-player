package com.example.milton.lavid_player;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by Milton on 20/07/2015.
 */
public class ClienteAndroid {

    int serverPorta;
    String hostName;
    String msg;
    byte[] bytes;
    byte[] buffer;
    InetAddress host;
    DatagramSocket socket;
    DatagramPacket packet;
    DatagramPacket packetReply;

    public ClienteAndroid(int serverPorta, String hostName, String msg) {
        this.serverPorta = serverPorta;
        this.hostName = hostName;
        this.msg = msg;

        //while (true) {

            try {

                socket = new DatagramSocket();
                bytes = msg.getBytes();
                host = InetAddress.getByName(hostName);
                DatagramPacket packetResquest = new DatagramPacket(bytes, msg.length(), host , serverPorta);
                socket.send(packetResquest);
                Log.i("Mandando Requisição", "<LAVID>");

                buffer = new byte[1000];
                packetReply = new DatagramPacket(buffer, buffer.length);
                socket.setSoTimeout(2000);
                socket.receive(packetReply);
                String doServidor = "Do Servidor " + packetReply.getAddress() + ", porta: " + packetReply.getPort() +
                        ": " + new String(packetReply.getData(), 0 , packetReply.getLength());
                //Log.i("Pacoto Recebido", "<LAVID>");
                Log.i(doServidor, "<LAVID>");

            }
            catch (SocketException e1) {
                Log.e("Socker Exception","");
                e1.printStackTrace();
            } catch (UnknownHostException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        //}
    }
}

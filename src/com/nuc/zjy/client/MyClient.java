package com.nuc.zjy.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @项目名称：ticket
 * @类名称：MyClient
 * @类描述：
 * 
 * @author 赵建银
 * @email 384144795@qq.com
 * @date 2017-7-8
 * @time 上午8:07:25
 * @version 1.0
 */
public class MyClient {

	Socket s = null;
	ObjectInputStream objectInputStream = null;
	ObjectOutputStream objectOutputStream = null;

	public void Connected() {
		try {
			s = new Socket("127.0.0.1", 9898);
			objectOutputStream = new ObjectOutputStream(s.getOutputStream());
			objectInputStream = new ObjectInputStream(s.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Thread(new ClientThread()).start();
	}

	class ClientThread implements Runnable {
		@Override
		public void run() {
			Object object = null;
			try {
				objectOutputStream.writeObject(object);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
}

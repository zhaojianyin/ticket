package com.nuc.zjy.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.nu.zjy.entity.CheCi;
import com.nu.zjy.entity.Order;
import com.nu.zjy.entity.Ticket;
import com.nuc.zjy.role.Customer;

/**
 * @项目名称：ticket
 * @类名称：MyServer
 * @类描述：服务端
 * 
 * @author 赵建银
 * @email 384144795@qq.com
 * @date 2017-7-7
 * @time 下午3:01:50
 * @version 1.0
 */
public class MyServer {

	Socket s = null;
	ServerSocket ss = null;
	boolean started = false;
	boolean flag = false;
	static Socket socket = null;
	ObjectOutputStream objectOutputStreamfile = null;
	ObjectInputStream objectInputStreamfile = null;
	File userFile = null;
	File ticketFile = null;
	File oderFile = null;
	File checiFile = null;
	Object object = null;
	List<Ticket> list_ticke = new ArrayList<>();
	List<Order> list_order = new ArrayList<>();
	List<CheCi> list_checi = new ArrayList<>();
	List<Customer> list_user = new ArrayList<>();

	public static void main(String[] args) {
		new MyServer().connected();
	}

	/**
	 * 初始化文件
	 */
	public void init() {
		userFile = new File("user.txt");
		ticketFile = new File("ticket.txt");
		oderFile = new File("order.txt");
		checiFile = new File("checi.txt");
		try {
			if (!userFile.exists()) {
				userFile.createNewFile();
			}
			if (!ticketFile.exists()) {
				ticketFile.createNewFile();
			}
			if (!oderFile.exists()) {
				oderFile.createNewFile();
			}
			if (!checiFile.exists()) {
				checiFile.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 客户端连接
	 */
	public void connected() {
		init();
		try {
			ss = new ServerSocket(9898);
			started = true;
			while (started) {
				socket = ss.accept();
				ClientThread clientThread = new ClientThread(socket);
				new Thread(clientThread).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @类名称：ClientThread
	 * @类描述： 接收客户端信息的线程
	 * 
	 * @author 赵建银
	 */
	class ClientThread implements Runnable {

		Socket socket = null;
		ObjectInputStream objectInputStream = null;
		ObjectOutputStream objectOutputStream = null;

		public ClientThread(Socket socket) {
			this.socket = socket;
			try {
				objectInputStream = new ObjectInputStream(
						socket.getInputStream());
				objectOutputStream = new ObjectOutputStream(
						socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/**
		 * 向客户端发送读取的文件内容
		 */
		public void send() {
			
		}

		/**
		 * 接收客户端信息
		 */
		public void recive() {
			try {
				object = objectInputStream.readObject();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			recive();
			if (object != null) {
				save(object);
			} else {
				System.out.println("对象为空");
			}
		}

		public void save(Object object) {
			try {
				if (object instanceof Customer) {
					objectOutputStreamfile = new ObjectOutputStream(
							new FileOutputStream(userFile, true));
					
					// TODO 此处添加是否存在该用户
					objectOutputStreamfile.writeObject(object);
					System.out.println(object);
				} else if (object instanceof Ticket) {
					objectOutputStreamfile = new ObjectOutputStream(
							new FileOutputStream(ticketFile, true));
					// TODO 此处添加是否存在该用户
					objectOutputStreamfile.writeObject(object);
					System.out.println(object);
				} else if (object instanceof CheCi) {
					objectOutputStreamfile = new ObjectOutputStream(
							new FileOutputStream(checiFile, true));
					// TODO 此处添加是否存在该用户
					objectOutputStreamfile.writeObject(object);
				} else if (object instanceof Order) {
					objectOutputStreamfile = new ObjectOutputStream(
							new FileOutputStream(oderFile, true));
					// TODO 此处添加是否存在该用户
					objectOutputStreamfile.writeObject(object);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		public List<Ticket> readTicket() {
			try {
				Ticket ticket = null;
				objectInputStreamfile = new ObjectInputStream(
						new FileInputStream(ticketFile));
				while (objectInputStreamfile.readObject() != null) {
					ticket = (Ticket) objectInputStreamfile.readObject();
					list_ticke.add(ticket);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return list_ticke;
		}

		public List<Order> readOrder() {
			try {
				Order order = null;
				objectInputStreamfile = new ObjectInputStream(
						new FileInputStream(oderFile));
				while (objectInputStreamfile.readObject() != null) {
					order = (Order) objectInputStreamfile.readObject();
					list_order.add(order);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return list_order;
		}

		public List<Customer> readUser() {
			try {
				Customer customer = null;
				objectInputStreamfile = new ObjectInputStream(
						new FileInputStream(ticketFile));
				while (objectInputStreamfile.readObject() != null) {
					customer = (Customer) objectInputStreamfile.readObject();
					list_user.add(customer);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return list_user;
		}

		public List<CheCi> readCheci() {
			try {
				CheCi cheCi = null;
				objectInputStreamfile = new ObjectInputStream(
						new FileInputStream(ticketFile));
				while (objectInputStreamfile.readObject() != null) {
					cheCi = (CheCi) objectInputStreamfile.readObject();
					list_checi.add(cheCi);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return list_checi;
		}
	}

}

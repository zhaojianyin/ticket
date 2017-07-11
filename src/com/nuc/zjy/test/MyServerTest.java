package com.nuc.zjy.test;

import java.io.ObjectOutputStream;
import java.net.Socket;

import org.junit.Before;
import org.junit.Test;

import com.nu.zjy.entity.Customer;

/**
 * @项目名称：ticket
 * @类名称：MyServerTest
 * @类描述：
 * 
 * @author 赵建银
 * @email 384144795@qq.com
 * @date 2017-7-7
 * @time 下午3:48:57
 * @version 1.0
 */
public class MyServerTest {

	Socket s = null;
	ObjectOutputStream objectOutputStream = null;

	@Before
	public void testconnect() {
		try {
			s = new Socket("127.0.0.1", 9898);
			objectOutputStream = new ObjectOutputStream(s.getOutputStream());
			System.out.println("Client Connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testrecive() {
		try {
			Customer manager = new Customer("0003", "赵建银", "12345678",
					"142201199510313375", "成年人");
			objectOutputStream.writeObject(manager);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package com.nuc.zjy.frame;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @项目名称：ticket
 * @类名称：WindowFrame
 * @类描述：启动显示frame
 * 
 * @author 赵建银
 * @date 2017-7-14
 * @time 上午8:04:22
 * @version 1.0
 */
public class WindowFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1122987388244324735L;

	/**
	 * Create the frame.
	 */
	public WindowFrame() {
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 25));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 80, 700, 490);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("欢迎使用急速订票系统");
		label.setFont(new Font("宋体", Font.PLAIN, 30));
		label.setBounds(191, 23, 305, 177);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("中北大学软件学院赵建银");
		label_1.setBounds(258, 369, 217, 15);
		getContentPane().add(label_1);
	}
}

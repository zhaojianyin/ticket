package com.nuc.zjy.frame;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/** 
 * @项目名称：ticket   
 * @类名称：OrderFrame   
 * @类描述：  
 *
 * @author 赵建银
 * @email 384144795@qq.com 
 * @date 2017-7-8 
 * @time 下午4:15:10 
 * @version 1.0 
 */
public class OrderFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7670676814176478734L;
	private JPanel contentPane;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderFrame frame = new OrderFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "  ", "", "", "", "", "", null, null},
				{null, null, null, "", null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\u8F66\u6B21", "\u8D77\u70B9", "\u7EC8\u70B9", "\u51FA\u53D1\u65F6\u95F4", "\u5EA7\u4F4D\u53F7", "\u7C7B\u578B", "\u4EF7\u683C", "\u8D2D\u4E70\u65E5\u671F", "\u662F\u5426\u4F7F\u7528"
			}
		));
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setBounds(0, 0, 424, 240);
		contentPane.add(table_1);
		
	}
}

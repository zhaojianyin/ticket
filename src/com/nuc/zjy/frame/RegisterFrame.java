package com.nuc.zjy.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.ImageIcon;

/**
 * @项目名称：ticket
 * @类名称：Register
 * @类描述：注册frame
 * 
 * @author 赵建银
 * @date 2017-7-8
 * @time 上午8:32:59
 * @version 1.0
 */
public class RegisterFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1533490500855350549L;
	private JPanel contentPane;
	private JTextField txt_account;
	private JPasswordField jpwd;
	private JPasswordField jpwd_ok;
	private JTextField txt_name;
	private JTextField txt_carid;
	private JButton btn_cancle;
	private ClientContext clientContext;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;

	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}

	/**
	 * 初始化Frame
	 */
	public RegisterFrame() {
		setTitle("用户注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 80, 700, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txt_account = new JTextField();
		txt_account.setBounds(396, 79, 132, 21);
		contentPane.add(txt_account);
		txt_account.setColumns(10);

		JLabel label = new JLabel("账号");
		label.setBounds(217, 82, 54, 15);
		contentPane.add(label);

		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(217, 177, 54, 15);
		contentPane.add(label_1);

		jpwd = new JPasswordField();
		jpwd.setBounds(396, 174, 132, 21);
		contentPane.add(jpwd);

		jpwd_ok = new JPasswordField();
		jpwd_ok.setBounds(396, 230, 132, 21);
		contentPane.add(jpwd_ok);

		JLabel label_2 = new JLabel("确认密码");
		label_2.setBounds(217, 233, 54, 15);
		contentPane.add(label_2);

		JButton btn_register = new JButton("注册");
		btn_register.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\注册.png"));
		btn_register.setBounds(184, 355, 93, 23);
		contentPane.add(btn_register);
		btn_register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.register();
			}
		});

		JLabel label_3 = new JLabel("用户名");
		label_3.setBounds(217, 130, 54, 15);
		contentPane.add(label_3);

		txt_name = new JTextField();
		txt_name.setBounds(396, 127, 132, 21);
		contentPane.add(txt_name);
		txt_name.setColumns(10);

		JLabel label_4 = new JLabel("身份证号");
		label_4.setBounds(217, 290, 54, 15);
		contentPane.add(label_4);

		txt_carid = new JTextField();
		txt_carid.setBounds(396, 287, 132, 21);
		contentPane.add(txt_carid);
		txt_carid.setColumns(10);

		btn_cancle = new JButton("取消");
		btn_cancle.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\取消.png"));
		btn_cancle.setBounds(406, 355, 93, 23);
		contentPane.add(btn_cancle);

		label_5 = new JLabel("用户注册");
		label_5.setFont(new Font("宋体", Font.PLAIN, 20));
		label_5.setBounds(278, 9, 236, 60);
		contentPane.add(label_5);

		label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\账号 (2).png"));
		label_6.setBounds(184, 85, 54, 15);
		contentPane.add(label_6);

		label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\密码 (1).png"));
		label_7.setBounds(184, 177, 54, 15);
		contentPane.add(label_7);

		label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\密码 (1).png"));
		label_8.setBounds(184, 236, 54, 15);
		contentPane.add(label_8);

		label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\账号 (2).png"));
		label_9.setBounds(184, 130, 54, 15);
		contentPane.add(label_9);

		label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\身份证 证件.png"));
		label_10.setBounds(184, 290, 54, 15);
		contentPane.add(label_10);
		btn_cancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.exit(RegisterFrame.this);
			}
		});
	}

	/**
	 * 获取用户账号
	 * 
	 * @return 用户id
	 */
	public String getCarId() {
		return txt_carid.getText().trim();
	}

	/**
	 * 获取用户姓名
	 * 
	 * @return 用户姓名
	 */
	public String getCustomrtName() {
		return txt_name.getText().trim();
	}

	/**
	 * 获取确认密码值
	 * 
	 * @return 确认密码
	 */
	public String getPasswordOK() {
		return new String(jpwd_ok.getPassword()).trim();
	}

	/**
	 * 获取用户密码
	 * 
	 * @return 用户密码
	 */
	public String getPassWord() {
		return new String(jpwd.getPassword()).trim();
	}

	/**
	 * 获取用户账号
	 * 
	 * @return 用户账号
	 */
	public String getAccount() {
		return txt_account.getText().trim();
	}

}

package com.nuc.zjy.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;

/**
 * @项目名称：ticket
 * @类名称：LoginFrame
 * @类描述：登录frame
 * 
 * @author 赵建银
 * @date 2017-7-12
 * @time 下午3:06:10
 * @version 1.0
 */
public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3229380059607508098L;
	private ClientContext clientContext;
	private JPanel contentPane;
	private JTextField txt_id;// 用户账号
	private JPasswordField jpasswd;// 密码
	private JButton btn_login;// 登录按钮
	private JButton btn_cancle;// 取消按钮
	private JButton btnNewButton;//
	private JComboBox<String> comboBox;// 类型选择框
	private String type = "管理员";// 默认类型

	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}

	/**
	 * 初始化登录界面
	 */
	public LoginFrame() {
		setTitle("用户登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 80, 700, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("用户名");
		label.setBackground(Color.BLACK);
		label.setForeground(Color.BLACK);
		label.setBounds(217, 121, 54, 15);
		contentPane.add(label);
		// 账号输入框
		txt_id = new JTextField();
		txt_id.setBounds(351, 118, 110, 21);
		contentPane.add(txt_id);
		txt_id.setColumns(10);

		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(217, 182, 54, 15);
		contentPane.add(label_1);

		// 登录按钮
		btn_login = new JButton("登录");
		btn_login.setBounds(112, 355, 93, 23);
		contentPane.add(btn_login);

		btn_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.login();// 登录
			}
		});

		// 取消按钮
		btn_cancle = new JButton("取消");
		btn_cancle.setBounds(445, 355, 93, 23);
		contentPane.add(btn_cancle);
		btn_cancle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.exit(LoginFrame.this);// 退出
			}
		});

		// 密码输入框
		jpasswd = new JPasswordField();
		jpasswd.setBounds(351, 179, 110, 21);
		contentPane.add(jpasswd);

		// 注册按钮
		btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientContext.show_register();
			}
		});
		btnNewButton.setBounds(276, 355, 93, 23);
		contentPane.add(btnNewButton);

		// 选择框
		comboBox = new JComboBox<String>();
		comboBox.setBounds(351, 239, 110, 21);
		comboBox.addItem("管理员");
		comboBox.addItem("用户");
		contentPane.add(comboBox);
		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				ItemStateChanged(e);
			}
		});

		JLabel label_2 = new JLabel("类型");
		label_2.setBounds(217, 242, 54, 15);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("登录系统");
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(276, 27, 110, 40);
		contentPane.add(label_3);
	}

	/**
	 * 
	 * @param evt
	 *            组件
	 */
	private void ItemStateChanged(ItemEvent evt) {
		type = comboBox.getSelectedItem().toString().trim();
	}

	/**
	 * 获取用户密码
	 * 
	 * @return 用户密码
	 */
	public String getPassword() {
		return new String(jpasswd.getPassword());

	}

	/**
	 * 获取用户账号
	 * 
	 * @return 用户id
	 */
	public String getuerid() {
		return txt_id.getText();
	}

	/**
	 * 获取用户类型
	 * 
	 * @return 用户类型
	 */
	public String getCmtype() {
		return type;
	}
}

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

/**
 * @项目名称：ticket
 * @类名称：LoginFrame
 * @类描述：
 * 
 * @author 赵建银
 * @email 384144795@qq.com
 * @date 2017-7-8
 * @time 上午9:58:48
 * @version 1.0
 */
public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3229380059607508098L;
	private ClientContext clientContext;
	private JPanel contentPane;
	private JTextField txt_id;
	private JPasswordField jpasswd;

	private JButton btn_login;
	private JButton btn_cancle;
	private JButton btnNewButton;
	private JComboBox<String> comboBox;
	private JLabel label_2;
	private String type = "管理员";

	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("用户登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("用户名");
		label.setBackground(Color.BLACK);
		label.setForeground(Color.BLACK);
		label.setBounds(95, 68, 54, 15);
		contentPane.add(label);

		txt_id = new JTextField();
		txt_id.setBounds(170, 65, 110, 21);
		contentPane.add(txt_id);
		txt_id.setColumns(10);

		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(95, 106, 54, 15);
		contentPane.add(label_1);

		btn_login = new JButton("登录");
		btn_login.setBounds(27, 228, 93, 23);
		contentPane.add(btn_login);

		btn_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.login();
			}
		});

		btn_cancle = new JButton("取消");
		btn_cancle.setBounds(294, 228, 93, 23);
		contentPane.add(btn_cancle);
		btn_cancle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.exit(LoginFrame.this);
			}
		});

		jpasswd = new JPasswordField();
		jpasswd.setBounds(170, 103, 110, 21);
		contentPane.add(jpasswd);

		btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientContext.show_register();
			}
		});
		btnNewButton.setBounds(170, 228, 93, 23);
		contentPane.add(btnNewButton);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(170, 150, 110, 21);
		comboBox.addItem("管理员");
		comboBox.addItem("用户");
		contentPane.add(comboBox);
		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				ItemStateChanged(e);
			}
		});

		label_2 = new JLabel("类型");
		label_2.setBounds(95, 153, 54, 15);
		contentPane.add(label_2);
	}

	/**
	 * @param evt
	 *            组件
	 */
	private void ItemStateChanged(ItemEvent evt) {
		type = comboBox.getSelectedItem().toString().trim();
	}

	public String getPassword() {
		return new String(jpasswd.getPassword());

	}

	public String getuerid() {
		return txt_id.getText();
	}

	public String getCmtype() {
		return type;
	}

}

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

/**
 * @项目名称：ticket
 * @类名称：Register
 * @类描述：
 * 
 * @author 赵建银
 * @email 384144795@qq.com
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

	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}

	/**
	 * Create the frame.
	 */
	public RegisterFrame() {
		setTitle("用户注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txt_account = new JTextField();
		txt_account.setBounds(195, 37, 132, 21);
		contentPane.add(txt_account);
		txt_account.setColumns(10);

		JLabel label = new JLabel("账号");
		label.setBounds(98, 40, 54, 15);
		contentPane.add(label);

		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(98, 105, 54, 15);
		contentPane.add(label_1);

		jpwd = new JPasswordField();
		jpwd.setBounds(195, 102, 132, 21);
		contentPane.add(jpwd);

		jpwd_ok = new JPasswordField();
		jpwd_ok.setBounds(195, 139, 132, 21);
		contentPane.add(jpwd_ok);

		JLabel label_2 = new JLabel("确认密码");
		label_2.setBounds(98, 142, 54, 15);
		contentPane.add(label_2);

		JButton btn_register = new JButton("注册");
		btn_register.setBounds(119, 228, 93, 23);
		contentPane.add(btn_register);
		btn_register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.register();
			}
		});

		JLabel label_3 = new JLabel("用户名");
		label_3.setBounds(98, 74, 54, 15);
		contentPane.add(label_3);

		txt_name = new JTextField();
		txt_name.setBounds(195, 71, 132, 21);
		contentPane.add(txt_name);
		txt_name.setColumns(10);

		JLabel label_4 = new JLabel("身份证号");
		label_4.setBounds(98, 180, 54, 15);
		contentPane.add(label_4);

		txt_carid = new JTextField();
		txt_carid.setBounds(195, 177, 132, 21);
		contentPane.add(txt_carid);
		txt_carid.setColumns(10);

		btn_cancle = new JButton("取消");
		btn_cancle.setBounds(234, 228, 93, 23);
		contentPane.add(btn_cancle);
		btn_cancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.exit(RegisterFrame.this);
			}
		});
	}

	/**
	 * @return 用户id
	 */
	public String getCarId() {
		return txt_carid.getText().trim();
	}

	/**
	 * @return 用户姓名
	 */
	public String getCustomrtName() {
		return txt_name.getText().trim();
	}

	/**
	 * @return 确认密码
	 */
	public String getPasswordOK() {
		return new String(jpwd_ok.getPassword()).trim();
	}

	/**
	 * @return 用户密码
	 */
	public String getPassWord() {
		return new String(jpwd.getPassword()).trim();
	}

	public String getAccount() {
		return txt_account.getText().trim();
	}

}

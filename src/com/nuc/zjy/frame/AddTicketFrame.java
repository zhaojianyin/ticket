package com.nuc.zjy.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * @项目名称：ticket
 * @类名称：AddTicket
 * @类描述：
 * 
 * @author 赵建银
 * @date 2017-7-10
 * @time 下午1:56:29
 * @version 1.0
 */
public class AddTicketFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9056774030939082633L;
	private JPanel contentPane;
	private JTextField txt_end;
	private JTextField txt_number;
	private JTextField txt_start;
	private JTextField txt_price;
	private JTextField txt_starttime;
	private JTextField txt_jici;
	private ClientContext clientContext;
	private JComboBox<String> cb_type;
	private String type = "头等舱";

	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}

	/**
	 * Create the frame.
	 */
	public AddTicketFrame() {
		setTitle("添加机票");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("机次");
		label.setBounds(131, 84, 54, 15);
		contentPane.add(label);

		JLabel lblNewLabel = new JLabel("票价");
		lblNewLabel.setBounds(131, 204, 54, 15);
		contentPane.add(lblNewLabel);

		txt_end = new JTextField();
		txt_end.setBounds(312, 158, 110, 21);
		contentPane.add(txt_end);
		txt_end.setColumns(10);

		JLabel label_1 = new JLabel("机票类型");
		label_1.setBounds(131, 271, 54, 15);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("机票数量");
		label_2.setBounds(131, 309, 54, 15);
		contentPane.add(label_2);

		txt_number = new JTextField();
		txt_number.setBounds(312, 306, 110, 21);
		contentPane.add(txt_number);
		txt_number.setColumns(10);

		JButton btn_save = new JButton("添加");
		btn_save.setBounds(142, 357, 93, 23);
		contentPane.add(btn_save);
		btn_save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.addModel();
				clientContext.addTicket();
			}
		});

		cb_type = new JComboBox<String>();
		cb_type.addItem("头等舱");
		cb_type.addItem("商务舱");
		cb_type.addItem("经济舱");
		cb_type.setBounds(312, 268, 110, 21);
		cb_type.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				ItemStateChanged(e);
			}
		});

		contentPane.add(cb_type);

		JLabel lblNewLabel_1 = new JLabel("添加机票");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(201, 10, 101, 52);
		contentPane.add(lblNewLabel_1);

		JButton btn_cancle = new JButton("取消");
		btn_cancle.setBounds(312, 357, 93, 23);
		contentPane.add(btn_cancle);
		btn_cancle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.exit(AddTicketFrame.this);
			}
		});

		JLabel label_3 = new JLabel("起点");
		label_3.setBounds(131, 120, 54, 15);
		contentPane.add(label_3);

		txt_start = new JTextField();
		txt_start.setBounds(312, 117, 110, 21);
		contentPane.add(txt_start);
		txt_start.setColumns(10);

		JLabel label_4 = new JLabel("终点");
		label_4.setBounds(131, 161, 54, 15);
		contentPane.add(label_4);

		txt_price = new JTextField();
		txt_price.setBounds(312, 201, 110, 21);
		contentPane.add(txt_price);
		txt_price.setColumns(10);

		JLabel label_5 = new JLabel("起飞时间");
		label_5.setBounds(131, 229, 54, 15);
		contentPane.add(label_5);

		txt_starttime = new JTextField();
		txt_starttime.setBounds(312, 232, 110, 21);
		contentPane.add(txt_starttime);
		txt_starttime.setColumns(10);

		txt_jici = new JTextField();
		txt_jici.setBounds(312, 81, 110, 21);
		contentPane.add(txt_jici);
		txt_jici.setColumns(10);
	}

	/**
	 * @param evt
	 *            组件
	 */
	private void ItemStateChanged(java.awt.event.ItemEvent evt) {
		type = cb_type.getSelectedItem().toString().trim();
	}

	/**
	 * @return 飞机航班
	 */
	public String getJici() {
		return txt_jici.getText().toString().trim();
	}

	/**
	 * @return 飞机起点
	 */
	public String getStart() {
		return txt_start.getText().toString().trim();
	}

	/**
	 * @return 飞机终点
	 */
	public String getEnd() {
		return txt_end.getText().toString().trim();
	}

	/**
	 * @return 起飞时间
	 */
	public String getStartTime() {
		return txt_starttime.getText().toString().trim();
	}

	/**
	 * 
	 * @return 机票价格
	 */
	public double getPrice() {
		return Double.parseDouble(txt_price.getText().toString().trim());
	}

	/**
	 * @return 机票类型
	 */
	public String getJCType() {
		return type;
	}

	/**
	 * @return 机票数量
	 */
	public int getNumber() {
		return Integer.parseInt(txt_number.getText().toString().trim());
	}

}

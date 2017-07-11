package com.nuc.zjy.frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.nu.zjy.entity.Customer;
import com.nu.zjy.entity.Model;

public class MainFrame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3969800148969845741L;
	CardLayout card = new CardLayout();
	private JToolBar toolBar;
	private JButton btn_find;
	private JButton btn_order;
	private JButton btn_message;
	private JButton btn_help;
	private JButton btn_inst;
	private String cardname[] = { "查询", "我的订单", "我的信息", "帮助", "介绍" };
	private JTextField txt_start;
	private JLabel label_1;
	private JTextField txt_end;
	private JLabel label_2;
	private JTextField txt_starttime;
	private ClientContext clientContext;
	private JButton btn_panel_find;
	private Vector<String> a = new Vector<String>();
	JPanel cardPanel = new JPanel();
	JPanel controlpaPanel = new JPanel();

	JPanel find_Panel = new JPanel();
	JPanel order_Panel = new JPanel();
	JPanel message_Panel = new JPanel();
	JPanel help_Panel = new JPanel();
	JPanel ins_Panel = new JPanel();
	private JLabel label_9;
	private JLabel label_type;
	private JLabel label_cardid;
	private JLabel label_id;
	private JTable table;
	private JLabel label_name;
	private Vector<String> objects;
	private DefaultTableModel defaultTableModel;

	// 定义构造函数

	public MainFrame() {
		setTitle("主界面");

		setSize(804, 536);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLocationRelativeTo(null);
		cardPanel.setLayout(card);
		// 循环，在cardPanel面板对象中添加五个按钮
		// 因为cardPanel面板对象为卡片布局，因此只显示最先添加的组件

		find_Panel.setLayout(null);
		order_Panel.setLayout(null);
		message_Panel.setLayout(null);
		help_Panel.setLayout(null);
		ins_Panel.setLayout(null);
		cardPanel.add(cardname[0], find_Panel);

		JLabel label = new JLabel("起点");
		label.setBounds(27, 27, 54, 15);
		find_Panel.add(label, BorderLayout.NORTH);

		txt_start = new JTextField();
		txt_start.setBounds(54, 24, 93, 21);
		find_Panel.add(txt_start, BorderLayout.NORTH);
		txt_start.setColumns(10);

		label_1 = new JLabel("终点");
		label_1.setBounds(182, 27, 54, 15);
		find_Panel.add(label_1, BorderLayout.NORTH);

		txt_end = new JTextField();
		txt_end.setBounds(238, 24, 85, 22);
		find_Panel.add(txt_end, BorderLayout.NORTH);
		txt_end.setColumns(10);

		label_2 = new JLabel("时间");
		label_2.setBounds(379, 27, 54, 15);
		find_Panel.add(label_2, BorderLayout.NORTH);

		txt_starttime = new JTextField();
		txt_starttime.setBounds(452, 24, 102, 22);
		find_Panel.add(txt_starttime, BorderLayout.NORTH);
		txt_starttime.setColumns(10);

		btn_panel_find = new JButton("查询");
		btn_panel_find.setBounds(604, 23, 93, 23);
		find_Panel.add(btn_panel_find, BorderLayout.SOUTH);
		btn_panel_find.addActionListener(this);
		JPanel panel = new JPanel();
		panel.setBounds(10, 132, 765, 287);
		find_Panel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		a.add("航班");
		a.add("起点");
		a.add("终点");
		a.add("起飞时间");
		a.add("机票类型");
		a.add("机票价格");
		a.add("剩余数量");
		JTableHeader tableHeader = table.getTableHeader();
		defaultTableModel = new DefaultTableModel(objects, a);
		table.setModel(defaultTableModel);
		panel.add(tableHeader, BorderLayout.NORTH);
		panel.add(table, BorderLayout.CENTER);
		cardPanel.add(cardname[1], order_Panel);
		cardPanel.add(cardname[2], message_Panel);

		JLabel label_4 = new JLabel("姓名：");
		label_4.setBounds(246, 45, 54, 15);
		message_Panel.add(label_4);

		label_name = new JLabel("");
		label_name.setBounds(411, 45, 229, 15);
		message_Panel.add(label_name);

		JLabel label_5 = new JLabel("账号：");
		label_5.setBounds(246, 111, 54, 15);
		message_Panel.add(label_5);

		JLabel label_6 = new JLabel("身份证号：");
		label_6.setBounds(246, 170, 77, 15);
		message_Panel.add(label_6);

		label_id = new JLabel("");
		label_id.setBounds(423, 111, 217, 15);
		message_Panel.add(label_id);

		label_cardid = new JLabel("");
		label_cardid.setBounds(411, 170, 229, 15);
		message_Panel.add(label_cardid);
		cardPanel.add(cardname[3], help_Panel);

		JLabel label_7 = new JLabel("使用方法：点击查询，输入对应信息，查询车票。");
		label_7.setBounds(276, 38, 326, 85);
		help_Panel.add(label_7);

		JLabel label_3 = new JLabel("点击我的订单显示所有订单");
		label_3.setBounds(322, 129, 203, 15);
		help_Panel.add(label_3);

		JLabel label_10 = new JLabel("点击帮助显示软件使用信息");
		label_10.setBounds(322, 195, 203, 15);
		help_Panel.add(label_10);

		JLabel label_11 = new JLabel("点击介绍，显示软件的信息");
		label_11.setBounds(307, 243, 218, 15);
		help_Panel.add(label_11);
		cardPanel.add(cardname[4], ins_Panel);

		JLabel label_8 = new JLabel("谢谢使用我们的软件，我们会持续更新");
		label_8.setBounds(296, 83, 337, 15);
		ins_Panel.add(label_8);

		JLabel label_12 = new JLabel("联系人：赵建银");
		label_12.setBounds(343, 207, 133, 15);
		ins_Panel.add(label_12);

		JLabel lblqqcom = new JLabel("联系人邮箱：384144795@qq.com");
		lblqqcom.setBounds(304, 265, 224, 15);
		ins_Panel.add(lblqqcom);
		label_9 = new JLabel("类型");
		label_9.setBounds(246, 235, 54, 15);
		message_Panel.add(label_9);

		label_type = new JLabel("");
		label_type.setBounds(455, 235, 185, 15);
		message_Panel.add(label_type);

		// 定义容器对象为当前窗体容器对象

		Container container = getContentPane();

		// 将 cardPanel面板放置在窗口边界布局的中间，窗口默认为边界布局

		container.add(cardPanel, BorderLayout.CENTER);

		// 将controlpaPanel面板放置在窗口边界布局的南边，

		container.add(controlpaPanel, BorderLayout.NORTH);
		toolBar = new JToolBar();
		controlpaPanel.add(toolBar);

		btn_find = new JButton(cardname[0]);
		btn_find.addActionListener(this);
		toolBar.add(btn_find);

		btn_order = new JButton(cardname[1]);
		btn_order.addActionListener(this);
		toolBar.add(btn_order);

		btn_message = new JButton(cardname[2]);
		btn_message.addActionListener(this);
		toolBar.add(btn_message);

		btn_help = new JButton(cardname[3]);
		btn_help.addActionListener(this);
		toolBar.add(btn_help);

		btn_inst = new JButton(cardname[4]);
		btn_inst.addActionListener(this);
		toolBar.add(btn_inst);

	}

	// 实现按钮的监听触发时的处理
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn_find)) {
			card.show(cardPanel, cardname[0]);
		} else if (e.getSource().equals(btn_order)) {
			card.show(cardPanel, cardname[1]);
		} else if (e.getSource().equals(btn_message)) {
			card.show(cardPanel, cardname[2]);
			showmessage();// 显示信息
		} else if (e.getSource().equals(btn_help)) {
			card.show(cardPanel, cardname[3]);
		} else if (e.getSource().equals(btn_inst)) {
			card.show(cardPanel, cardname[4]);
		} else if (e.getSource().equals(btn_panel_find)) {
			objects = format(findTicket());
			defaultTableModel = new DefaultTableModel(objects, a);
			table.setModel(defaultTableModel);
		}
	}

	private Vector format(Vector<Model> vector) {
		Vector v = new Vector();
		for (int i = 0; i < vector.size(); i++) {
			Vector<String> vector2 = new Vector<String>();
			vector2.add(vector.get(i).getJici());
			vector2.add(vector.get(i).getStart());
			vector2.add(vector.get(i).getEnd());
			vector2.add(vector.get(i).getStarttime());
			vector2.add(vector.get(i).getType());
			vector2.add(vector.get(i).getPrice() + "");
			vector2.add(vector.get(i).getNumber() + "");

			v.add(vector2);
			System.out.println(vector2);
		}
		return v;

	}

	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}

	/**
	 * 返回输入要查询的航班信息
	 * 
	 * @return 航班信息
	 */
	public Model getFindModel() {
		Model model = new Model();
		String start = txt_start.getText().toString().trim();
		String end = txt_end.getText().toString().trim();
		String startTime = txt_starttime.getText().toString().trim();
		model.setStart(start);
		model.setEnd(end);
		model.setStarttime(startTime);
		return model;
	}

	/**
	 * 查找机票
	 */
	public Vector<Model> findTicket() {
		return clientContext.findTicket(getFindModel());
	}

	/**
	 * 显示用户属性
	 */
	public void showmessage() {
		// 获取用户信息
		Customer customer = clientContext.getLogin_cuCustomer();
		// 测试数据
		// Customer customer = new Customer("1001", "赵建银", "1234", "12343214",
		// "未成年");
		label_id.setText(customer.getiD());
		label_name.setText(customer.getName());
		label_cardid.setText(customer.getCardId());
		label_type.setText(customer.getType());
	}
}

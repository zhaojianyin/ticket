package com.nuc.zjy.frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.ibm.icu.text.SimpleDateFormat;
import com.nu.zjy.entity.Customer;
import com.nu.zjy.entity.Model;
import com.nu.zjy.entity.Order;

/**
 * @项目名称：ticket
 * @类名称：MainFrame
 * @类描述：用户主界面
 * 
 * @author 赵建银
 * @date 2017-7-9
 * @time 下午4:43:49
 * @version 1.0
 */
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
	private JButton btn_cancle;
	private String cardname[] = { "查询", "我的订单", "我的信息", "帮助", "介绍" };
	private JTextField txt_start;
	private JLabel label_1;
	private JTextField txt_end;
	private JLabel label_2;
	private JTextField txt_starttime;
	private ClientContext clientContext;
	private JButton btn_panel_find;
	private JButton btn_add_order;
	private Vector<String> a = new Vector<String>();
	private Vector<String> a_order = new Vector<String>();
	private Vector<String> objects;
	private Vector<String> objects_order;
	private JPanel cardPanel = new JPanel();
	private JPanel controlpaPanel = new JPanel();
	private JPanel find_Panel = new JPanel();
	private JPanel order_Panel = new JPanel();
	private JPanel message_Panel = new JPanel();
	private JPanel help_Panel = new JPanel();
	private JPanel ins_Panel = new JPanel();
	private JLabel label_9;
	private JLabel label_type;
	private JLabel label_cardid;
	private JLabel label_id;
	private JTable table;
	private JLabel label_name;
	private DefaultTableModel defaultTableModel;
	private DefaultTableModel dtm_order;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JTextField txt_add_order;
	private JLabel label_18;
	private JComboBox<String> comboBox_order;
	private String type = "头等舱";
	private JTable table_order;
	private JScrollPane panel_2;
	private JLabel label_19;
	private JLabel label_20;
	private JLabel lblNewLabel;
	private JLabel label_21;
	private JTextField txt_order_jici;
	private JLabel money;
	private JLabel label_22;
	private JLabel time;

	/**
	 * 初始化界面信息
	 */
	public MainFrame() {
		setTitle("主界面");

		setSize(804, 572);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLocationRelativeTo(null);
		cardPanel.setLayout(card);
		// 循环，在cardPanel面板对象中添加五个按钮
		// 因为cardPanel面板对象为卡片布局，因此只显示最先添加的组件

		find_Panel.setLayout(null);
		message_Panel.setLayout(null);
		help_Panel.setLayout(null);
		ins_Panel.setLayout(null);
		cardPanel.add(cardname[0], find_Panel);

		JLabel label = new JLabel("起点");
		label.setBounds(61, 66, 54, 15);
		find_Panel.add(label, BorderLayout.NORTH);

		txt_start = new JTextField();
		txt_start.setBounds(104, 63, 93, 21);
		find_Panel.add(txt_start, BorderLayout.NORTH);
		txt_start.setColumns(10);

		label_1 = new JLabel("终点");
		label_1.setBounds(271, 66, 54, 15);
		find_Panel.add(label_1, BorderLayout.NORTH);

		txt_end = new JTextField();
		txt_end.setBounds(300, 63, 85, 22);
		find_Panel.add(txt_end, BorderLayout.NORTH);
		txt_end.setColumns(10);

		label_2 = new JLabel("时间");
		label_2.setBounds(479, 66, 54, 15);
		find_Panel.add(label_2, BorderLayout.NORTH);

		txt_starttime = new JTextField();
		txt_starttime.setBounds(512, 63, 102, 22);
		find_Panel.add(txt_starttime, BorderLayout.NORTH);
		txt_starttime.setColumns(10);

		btn_panel_find = new JButton("查询");
		btn_panel_find
				.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\查询.png"));
		btn_panel_find.setBounds(651, 62, 93, 23);
		find_Panel.add(btn_panel_find, BorderLayout.SOUTH);
		btn_panel_find.addActionListener(this);
		JScrollPane panel = new JScrollPane();
		panel.setBounds(10, 132, 765, 287);
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		a.add("航班");
		a.add("起点");
		a.add("终点");
		a.add("起飞时间");
		a.add("机票类型");
		a.add("机票价格");
		a.add("剩余数量");
		defaultTableModel = new DefaultTableModel(objects, a);
		table.setModel(defaultTableModel);
		panel.add(table);
		table.setPreferredSize(new Dimension(745, 1000));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel.setViewportView(table);
		find_Panel.add(panel);
		label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\起点.png"));
		label_13.setBounds(40, 66, 54, 18);
		find_Panel.add(label_13);

		label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\起点.png"));
		label_14.setBounds(253, 66, 54, 15);
		find_Panel.add(label_14);

		label_15 = new JLabel("");
		label_15.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\时间.png"));
		label_15.setBounds(448, 66, 54, 15);
		find_Panel.add(label_15);

		label_16 = new JLabel("机票信息查询");
		label_16.setFont(new Font("宋体", Font.PLAIN, 20));
		label_16.setBounds(311, 10, 236, 40);
		find_Panel.add(label_16);

		txt_add_order = new JTextField();
		txt_add_order.setBounds(104, 431, 93, 21);
		find_Panel.add(txt_add_order);
		txt_add_order.setColumns(10);

		JLabel label_17 = new JLabel("航班号");
		label_17.setBounds(40, 434, 54, 15);
		find_Panel.add(label_17);

		comboBox_order = new JComboBox<String>();

		comboBox_order.setBounds(329, 429, 130, 23);
		comboBox_order.setModel(new DefaultComboBoxModel<String>(new String[] {
				"头等舱", "经济舱", "商务舱" }));
		comboBox_order.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				ItemStateChanged(e);
			}
		});
		find_Panel.add(comboBox_order);

		label_18 = new JLabel("机票类型");
		label_18.setBounds(271, 434, 54, 15);
		find_Panel.add(label_18);

		btn_add_order = new JButton("预定");
		btn_add_order.setBounds(651, 430, 93, 23);
		btn_add_order.addActionListener(this);
		find_Panel.add(btn_add_order);

		label_22 = new JLabel("当前时间");
		label_22.setBounds(538, 25, 54, 15);
		find_Panel.add(label_22);

		time = new JLabel("");
		time.setBounds(593, 10, 185, 43);
		find_Panel.add(time);
		cardPanel.add(cardname[1], order_Panel);
		a_order.add("用户姓名");
		a_order.add("航班");
		a_order.add("起点");
		a_order.add("终点");
		a_order.add("起飞时间");
		a_order.add("机票类型");
		a_order.add("机票价格");
		a_order.add("座位号");
		a_order.add("购票时间");
		order_Panel.setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 0, 768, 50);
		order_Panel.add(panel_1);
		panel_1.setLayout(null);

		label_19 = new JLabel("订单信息");
		label_19.setFont(new Font("宋体", Font.PLAIN, 20));
		label_19.setBounds(277, 10, 134, 30);
		panel_1.add(label_19);

		label_20 = new JLabel("总金额");
		label_20.setFont(new Font("宋体", Font.PLAIN, 16));
		label_20.setBounds(515, 19, 54, 15);
		panel_1.add(label_20);

		money = new JLabel("");
		money.setFont(new Font("宋体", Font.PLAIN, 18));
		money.setBounds(610, 10, 111, 25);
		panel_1.add(money);

		panel_2 = new JScrollPane();
		panel_2.setBounds(10, 60, 768, 350);
		order_Panel.add(panel_2);
		table_order = new JTable();
		table_order.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		dtm_order = new DefaultTableModel(objects_order, a_order);
		table_order.setModel(dtm_order);
		table_order.setPreferredSize(new Dimension(750, 1000));
		table_order.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_order.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_2.setViewportView(table_order);
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 416, 768, 72);
		order_Panel.add(panel_3);
		panel_3.setLayout(null);

		lblNewLabel = new JLabel("退票");
		lblNewLabel.setBounds(10, 10, 69, 50);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_3.add(lblNewLabel);

		label_21 = new JLabel("航班号");
		label_21.setFont(new Font("宋体", Font.PLAIN, 14));
		label_21.setBounds(116, 30, 54, 15);
		panel_3.add(label_21);

		txt_order_jici = new JTextField();
		txt_order_jici.setBounds(180, 27, 92, 21);
		panel_3.add(txt_order_jici);
		txt_order_jici.setColumns(10);

		btn_cancle = new JButton("退票");
		btn_cancle.setBounds(354, 26, 93, 23);
		btn_cancle.addActionListener(this);
		panel_3.add(btn_cancle);

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
		label_id.setBounds(411, 111, 217, 15);
		message_Panel.add(label_id);

		label_cardid = new JLabel("");
		label_cardid.setBounds(411, 170, 229, 15);
		message_Panel.add(label_cardid);
		cardPanel.add(cardname[3], help_Panel);

		JLabel label_7 = new JLabel("使用方法：点击查询，输入对应信息，查询车票。");
		label_7.setBounds(276, 38, 370, 85);
		help_Panel.add(label_7);

		JLabel label_3 = new JLabel("点击我的订单显示所有订单");
		label_3.setBounds(341, 133, 256, 15);
		help_Panel.add(label_3);

		JLabel label_10 = new JLabel("点击帮助显示软件使用信息");
		label_10.setBounds(343, 193, 203, 15);
		help_Panel.add(label_10);

		JLabel label_11 = new JLabel("点击介绍，显示软件的信息");
		label_11.setBounds(341, 242, 218, 15);
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
		label_type.setBounds(411, 235, 185, 15);
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
		btn_find.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\查询.png"));
		btn_find.addActionListener(this);
		toolBar.add(btn_find);

		btn_order = new JButton(cardname[1]);
		btn_order.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\订单.png"));
		btn_order.addActionListener(this);
		toolBar.add(btn_order);

		btn_message = new JButton(cardname[2]);
		btn_message
				.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\个人信息.png"));
		btn_message.addActionListener(this);
		toolBar.add(btn_message);

		btn_help = new JButton(cardname[3]);
		btn_help.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\帮助.png"));
		btn_help.addActionListener(this);
		toolBar.add(btn_help);

		btn_inst = new JButton(cardname[4]);
		btn_inst.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\简介.png"));
		btn_inst.addActionListener(this);
		toolBar.add(btn_inst);
		new Thread(new TimeThread()).start();

	}

	/**
	 * @param e
	 *            组件
	 */
	private void ItemStateChanged(ItemEvent e) {
		type = comboBox_order.getSelectedItem().toString().trim();
	}

	// 实现按钮的监听触发时的处理
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn_find)) {
			card.show(cardPanel, cardname[0]);
		} else if (e.getSource().equals(btn_order)) {
			card.show(cardPanel, cardname[1]);
			showorder();
		} else if (e.getSource().equals(btn_message)) {
			card.show(cardPanel, cardname[2]);
			showmessage();// 显示信息
		} else if (e.getSource().equals(btn_help)) {
			card.show(cardPanel, cardname[3]);
		} else if (e.getSource().equals(btn_inst)) {
			card.show(cardPanel, cardname[4]);
		} else if (e.getSource().equals(btn_panel_find)) {
			showTable();
		} else if (e.getSource().equals(btn_add_order)) {
			addOrder();
			showTable();
		} else if (e.getSource().equals(btn_cancle)) {
			int val = JOptionPane.showConfirmDialog(MainFrame.this, "确定退订吗？");
			if (val == JOptionPane.YES_OPTION) {
				returnorder();
			}
		}
	}

	/**
	 * 退票
	 */
	private void returnorder() {
		String jcstr = txt_order_jici.getText().toString();
		clientContext.returnorder(jcstr);
		showorder();
	}

	/**
	 * 添加订单
	 */
	private void addOrder() {
		String jici = txt_add_order.getText().toString().trim();
		clientContext.addOrder(jici, type, "add");
	}

	/**
	 * 显示订单信息
	 */
	private void showorder() {
		Vector<Order> vector = findOrder();
		formatorder(vector);
		table_order.setModel(dtm_order);
		money.setText(getmoney() + "");
	}

	/**
	 * 格式化订单信息
	 * 
	 * @param vector
	 *            订单集合
	 */
	private void formatorder(Vector<Order> vector) {
		dtm_order.setRowCount(0);
		for (int i = 0; i < vector.size(); i++) {
			Vector<String> vector2 = new Vector<String>();
			vector2.add(vector.get(i).getName());
			vector2.add(vector.get(i).getTicket().getJici());
			vector2.add(vector.get(i).getModel().getStart());
			vector2.add(vector.get(i).getModel().getEnd());
			vector2.add(vector.get(i).getModel().getStarttime());
			vector2.add(vector.get(i).getTicket().getType());
			vector2.add(vector.get(i).getTicket().getPrice() + "");
			vector2.add(vector.get(i).getTicket().getZuowei());
			vector2.add(vector.get(i).getBuyTime());
			dtm_order.addRow(vector2);
		}
	}

	/**
	 * 查找订单
	 * 
	 * @return 订单信息
	 */
	private Vector<Order> findOrder() {
		Customer customer = clientContext.getLogin_cuCustomer();
		return clientContext.findOrder(customer.getName());
	}

	/**
	 * 显示表格信息
	 */
	private void showTable() {
		Vector<Model> vector = findModel();
		if (vector.size() > 0) {
			format(vector);
			table.setModel(defaultTableModel);
		} else {
			JOptionPane.showMessageDialog(MainFrame.this, "没有找到航班");
		}

	}

	/**
	 * 格式化表格信息
	 * 
	 * @param vector
	 *            航班信息
	 */
	private void format(Vector<Model> vector) {
		defaultTableModel.setRowCount(0);
		for (int i = 0; i < vector.size(); i++) {
			Vector<String> vector2 = new Vector<String>();
			vector2.add(vector.get(i).getJici());
			vector2.add(vector.get(i).getStart());
			vector2.add(vector.get(i).getEnd());
			vector2.add(vector.get(i).getStarttime());
			vector2.add(vector.get(i).getType());
			vector2.add(vector.get(i).getPrice() + "");
			vector2.add(vector.get(i).getNumber() + "");
			defaultTableModel.addRow(vector2);
		}
	}

	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}

	/**
	 * 返回输入要查询的航班信息
	 * 
	 * @return 航班信息
	 */
	private Model getFindModel() {
		Model model = new Model();
		String start = txt_start.getText().toString().trim();
		String end = txt_end.getText().toString().trim();
		String startTime = txt_starttime.getText().toString().trim();
		if (start.equals("") || end.equals("") || startTime.equals("")) {
			JOptionPane.showMessageDialog(MainFrame.this, "请输入正确的信息");
		} else {
			model.setStart(start);
			model.setEnd(end);
			model.setStarttime(startTime);
		}
		return model;
	}

	/**
	 * 查找机票
	 */
	private Vector<Model> findModel() {
		return clientContext.findModel(getFindModel());
	}

	/**
	 * 显示用户属性
	 */
	private void showmessage() {
		Customer customer = clientContext.getLogin_cuCustomer();
		label_id.setText(customer.getiD());
		label_name.setText(customer.getName());
		label_cardid.setText(customer.getCardId());
		label_type.setText(customer.getType());
	}

	/**
	 * @return 获取订单金额
	 */
	private double getmoney() {
		return clientContext.getMoney();

	}

	/**
	 * @项目名称：ticket
	 * @类名称：TimeThread
	 * @类描述： 时间显示线程
	 * 
	 * @author 赵建银
	 * @date 2017-7-14
	 * @time 上午9:00:23
	 * @version 1.0
	 */
	class TimeThread implements Runnable {

		SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				int w = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1;
				if (w < 0)
					w = 0;
				time.setText(simFormat.format(new Date()) + "  " + weekDays[w]);
			}
		}
	}
}

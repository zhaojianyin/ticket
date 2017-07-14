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
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
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

import com.nu.zjy.entity.Model;

/**
 * @项目名称：ticket
 * @类名称：Manager_MainFrame
 * @类描述：管理员界面
 * 
 * @author 赵建银
 * @date 2017-7-10
 * @time 下午4:44:52
 * @version 1.0
 */
public class Manager_MainFrame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3969800148969845741L;
	CardLayout card = new CardLayout();
	private JToolBar toolBar;
	private JButton btn_find;
	private JButton btn_order;
	private JButton btn_update;
	private JButton btn_message;
	private JButton btn_delete_panel;
	private String cardname[] = { "查询", "添加航班信息", "修改航班信息", "我的信息", "帮助", "介绍" };
	private JTextField txt_start;
	private JLabel label_1;
	private JTextField txt_end;
	private JLabel label_2;
	private JTextField txt_starttime;
	private ClientContext clientContext;
	private JButton btn_panel_find;
	private Vector<String> a = new Vector<String>();
	private JPanel cardPanel = new JPanel();
	private JPanel controlpaPanel = new JPanel();
	private JPanel find_Panel = new JPanel();
	private JPanel add_Panel = new JPanel();
	private JPanel update_Panel = new JPanel();
	private JPanel message_Panel = new JPanel();
	private JPanel help_Panel = new JPanel();
	private JPanel ins_Panel = new JPanel();
	private JLabel lblAdmin;
	private JTable table = new JTable();;
	private JLabel label_name;
	private Vector<String> objects;
	private DefaultTableModel defaultTableModel;
	private JTextField txt_add_jici;
	private JTextField txt_add_start;
	private JTextField txt_add_end;
	private JTextField txt_add_starttime;
	private JTextField txt_add_price;
	private JTextField txt_add_number;
	private JTextField txt_update_jici;
	private JTextField txt_update_start;
	private JTextField txt_update_end;
	private JTextField txt_update_starttime;
	private JTextField txt_update_price;
	private JTextField txt_update_number;
	private String type = "头等舱";
	private String type_update = "头等舱";
	private JLabel label_16;

	private JComboBox<String> cb_type;
	private JComboBox<String> cb_type_update;
	private JButton btn_add;
	private JButton btn_update_panel;
	private JButton btn_help;
	private JButton btn_ins;
	private JTextField txt_delete_jici;

	/**
	 * 初始化管理员界面
	 */
	public Manager_MainFrame() {
		setTitle("管理员主界面");

		setSize(804, 536);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLocationRelativeTo(null);
		cardPanel.setLayout(card);
		// 循环，在cardPanel面板对象中添加五个按钮
		// 因为cardPanel面板对象为卡片布局，因此只显示最先添加的组件

		find_Panel.setLayout(null);
		add_Panel.setLayout(null);
		message_Panel.setLayout(null);
		help_Panel.setLayout(null);
		ins_Panel.setLayout(null);
		update_Panel.setLayout(null);
		cardPanel.add(cardname[0], find_Panel);

		JLabel label = new JLabel("起点");
		label.setBounds(20, 56, 54, 15);
		find_Panel.add(label, BorderLayout.NORTH);

		txt_start = new JTextField();
		txt_start.setBounds(68, 53, 93, 21);
		find_Panel.add(txt_start, BorderLayout.NORTH);
		txt_start.setColumns(10);

		label_1 = new JLabel("终点");
		label_1.setBounds(186, 56, 54, 15);
		find_Panel.add(label_1, BorderLayout.NORTH);

		txt_end = new JTextField();
		txt_end.setBounds(232, 53, 85, 22);
		find_Panel.add(txt_end, BorderLayout.NORTH);
		txt_end.setColumns(10);

		label_2 = new JLabel("时间");
		label_2.setBounds(369, 56, 54, 15);
		find_Panel.add(label_2, BorderLayout.NORTH);

		txt_starttime = new JTextField();
		txt_starttime.setBounds(433, 53, 102, 22);
		find_Panel.add(txt_starttime, BorderLayout.NORTH);
		txt_starttime.setColumns(10);

		btn_panel_find = new JButton("查询");
		btn_panel_find.setBounds(619, 52, 93, 23);
		find_Panel.add(btn_panel_find, BorderLayout.SOUTH);
		btn_panel_find.addActionListener(this);
		JScrollPane panel = new JScrollPane();
		panel.setBounds(10, 132, 765, 287);
		find_Panel.add(panel);
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
		JLabel label_17 = new JLabel("机票信息查询");
		label_17.setFont(new Font("宋体", Font.PLAIN, 20));
		label_17.setBounds(313, 10, 160, 33);
		find_Panel.add(label_17);

		JLabel label_32 = new JLabel("删除航班信息");
		label_32.setBounds(32, 429, 129, 15);
		find_Panel.add(label_32);

		JLabel label_33 = new JLabel("航班号");
		label_33.setBounds(155, 429, 54, 15);
		find_Panel.add(label_33);

		txt_delete_jici = new JTextField();
		txt_delete_jici.setBounds(212, 429, 136, 21);
		find_Panel.add(txt_delete_jici);
		txt_delete_jici.setColumns(10);

		btn_delete_panel = new JButton("删除");
		btn_delete_panel.setBounds(413, 425, 93, 23);
		btn_delete_panel.addActionListener(this);
		find_Panel.add(btn_delete_panel);

		// 添加
		cardPanel.add(cardname[1], add_Panel);
		JLabel label_6 = new JLabel("航班号");
		label_6.setBounds(294, 28, 54, 15);
		add_Panel.add(label_6);

		txt_add_jici = new JTextField();
		txt_add_jici.setBounds(444, 25, 116, 21);
		add_Panel.add(txt_add_jici);
		txt_add_jici.setColumns(10);

		JLabel label_9 = new JLabel("起点");
		label_9.setBounds(294, 79, 54, 15);
		add_Panel.add(label_9);

		txt_add_start = new JTextField();
		txt_add_start.setBounds(446, 76, 114, 21);
		add_Panel.add(txt_add_start);
		txt_add_start.setColumns(10);

		JLabel label_13 = new JLabel("终点");
		label_13.setBounds(294, 127, 54, 15);
		add_Panel.add(label_13);

		txt_add_end = new JTextField();
		txt_add_end.setBounds(446, 124, 114, 21);
		add_Panel.add(txt_add_end);
		txt_add_end.setColumns(10);

		JLabel label_14 = new JLabel("起飞时间");
		label_14.setBounds(294, 177, 54, 15);
		add_Panel.add(label_14);

		txt_add_starttime = new JTextField();
		txt_add_starttime.setBounds(444, 174, 116, 21);
		add_Panel.add(txt_add_starttime);
		txt_add_starttime.setColumns(10);

		JLabel lblNewLabel = new JLabel("机票类型");
		lblNewLabel.setBounds(294, 240, 54, 15);
		add_Panel.add(lblNewLabel);

		cb_type = new JComboBox<String>();
		cb_type.setModel(new DefaultComboBoxModel<String>(new String[] { "头等舱",
				"经济舱", "商务舱" }));
		cb_type.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				ItemStateChanged(e);
			}
		});
		cb_type.setBounds(444, 237, 116, 21);
		add_Panel.add(cb_type);

		JLabel label_15 = new JLabel("机票价格");
		label_15.setBounds(294, 344, 54, 15);
		add_Panel.add(label_15);

		txt_add_price = new JTextField();
		txt_add_price.setBounds(446, 341, 114, 21);
		add_Panel.add(txt_add_price);
		txt_add_price.setColumns(10);

		btn_add = new JButton("添加");
		btn_add.addActionListener(this);
		btn_add.setBounds(355, 407, 93, 23);
		add_Panel.add(btn_add);

		label_16 = new JLabel("机票数量");
		label_16.setBounds(294, 294, 54, 15);
		add_Panel.add(label_16);

		txt_add_number = new JTextField();
		txt_add_number.setBounds(444, 291, 117, 21);
		add_Panel.add(txt_add_number);
		txt_add_number.setColumns(10);

		JLabel label_18 = new JLabel("添");
		label_18.setFont(new Font("宋体", Font.PLAIN, 20));
		label_18.setBounds(76, 28, 54, 52);
		add_Panel.add(label_18);

		JLabel label_20 = new JLabel("加");
		label_20.setFont(new Font("宋体", Font.PLAIN, 20));
		label_20.setBounds(76, 90, 54, 49);
		add_Panel.add(label_20);

		JLabel label_21 = new JLabel("航");
		label_21.setFont(new Font("宋体", Font.PLAIN, 20));
		label_21.setBounds(76, 147, 54, 45);
		add_Panel.add(label_21);

		JLabel label_22 = new JLabel("班");
		label_22.setFont(new Font("宋体", Font.PLAIN, 20));
		label_22.setBounds(76, 198, 79, 57);
		add_Panel.add(label_22);

		JLabel label_27 = new JLabel("信");
		label_27.setFont(new Font("宋体", Font.PLAIN, 20));
		label_27.setBounds(76, 264, 79, 45);
		add_Panel.add(label_27);

		JLabel label_28 = new JLabel("息");
		label_28.setFont(new Font("宋体", Font.PLAIN, 20));
		label_28.setBounds(76, 323, 54, 36);
		add_Panel.add(label_28);

		// 更新panel
		JLabel label_16 = new JLabel("航班号");
		label_16.setBounds(295, 28, 54, 15);
		update_Panel.add(label_16);

		txt_update_jici = new JTextField();
		txt_update_jici.setBounds(469, 25, 116, 21);
		update_Panel.add(txt_update_jici);
		txt_update_jici.setColumns(10);

		JLabel label_19 = new JLabel("起点");
		label_19.setBounds(295, 76, 54, 15);
		update_Panel.add(label_19);

		txt_update_start = new JTextField();
		txt_update_start.setBounds(471, 73, 114, 21);
		update_Panel.add(txt_update_start);
		txt_update_start.setColumns(10);

		JLabel label_23 = new JLabel("终点");
		label_23.setBounds(295, 127, 54, 15);
		update_Panel.add(label_23);

		txt_update_end = new JTextField();
		txt_update_end.setBounds(471, 121, 114, 21);
		update_Panel.add(txt_update_end);
		txt_update_end.setColumns(10);

		JLabel label_24 = new JLabel("起飞时间");
		label_24.setBounds(295, 177, 54, 15);
		update_Panel.add(label_24);

		txt_update_starttime = new JTextField();
		txt_update_starttime.setBounds(469, 174, 116, 21);
		update_Panel.add(txt_update_starttime);
		txt_update_starttime.setColumns(10);

		JLabel lbl = new JLabel("机票类型");
		lbl.setBounds(295, 240, 54, 15);
		update_Panel.add(lbl);

		cb_type_update = new JComboBox<String>();
		cb_type_update.setModel(new DefaultComboBoxModel<String>(new String[] {
				"头等舱", "经济舱", "商务舱" }));
		cb_type_update.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				ItemStateChanged(e);
			}
		});
		cb_type_update.setBounds(469, 237, 116, 21);
		update_Panel.add(cb_type_update);

		JLabel label_25 = new JLabel("机票价格");
		label_25.setBounds(295, 344, 54, 15);
		update_Panel.add(label_25);

		txt_update_price = new JTextField();
		txt_update_price.setBounds(471, 341, 114, 21);
		update_Panel.add(txt_update_price);
		txt_update_price.setColumns(10);

		btn_update_panel = new JButton("修改");
		btn_update_panel.addActionListener(this);
		btn_update_panel.setBounds(336, 405, 93, 23);
		update_Panel.add(btn_update_panel);

		label_16 = new JLabel("机票数量");
		label_16.setBounds(295, 294, 54, 15);
		update_Panel.add(label_16);

		txt_update_number = new JTextField();
		txt_update_number.setBounds(468, 291, 117, 21);
		update_Panel.add(txt_update_number);
		txt_update_number.setColumns(10);
		cardPanel.add(cardname[2], update_Panel);

		JLabel label_118 = new JLabel("更");
		label_118.setFont(new Font("宋体", Font.PLAIN, 20));
		label_118.setBounds(76, 28, 54, 52);
		update_Panel.add(label_118);

		JLabel label_200 = new JLabel("新");
		label_200.setFont(new Font("宋体", Font.PLAIN, 20));
		label_200.setBounds(76, 90, 54, 49);
		update_Panel.add(label_200);

		JLabel label_211 = new JLabel("航");
		label_211.setFont(new Font("宋体", Font.PLAIN, 20));
		label_211.setBounds(76, 147, 54, 45);
		update_Panel.add(label_211);

		JLabel label_221 = new JLabel("班");
		label_221.setFont(new Font("宋体", Font.PLAIN, 20));
		label_221.setBounds(76, 198, 79, 57);
		update_Panel.add(label_221);

		JLabel label_271 = new JLabel("信");
		label_271.setFont(new Font("宋体", Font.PLAIN, 20));
		label_271.setBounds(76, 264, 79, 45);
		update_Panel.add(label_271);

		JLabel label_281 = new JLabel("息");
		label_281.setFont(new Font("宋体", Font.PLAIN, 20));
		label_281.setBounds(76, 323, 54, 36);
		update_Panel.add(label_281);

		// message panel
		cardPanel.add(cardname[3], message_Panel);

		JLabel label_4 = new JLabel("姓名：");
		label_4.setBounds(272, 50, 54, 15);
		message_Panel.add(label_4);

		label_name = new JLabel("赵建银");
		label_name.setBounds(439, 50, 229, 15);
		message_Panel.add(label_name);

		JLabel label_5 = new JLabel("账号：");
		label_5.setBounds(272, 109, 54, 15);
		message_Panel.add(label_5);

		lblAdmin = new JLabel("admin");
		lblAdmin.setBounds(439, 109, 217, 15);
		message_Panel.add(lblAdmin);
		cardPanel.add(cardname[4], help_Panel);

		JLabel label_7 = new JLabel("使用方法：点击查询，输入对应信息，查询车票。");
		label_7.setBounds(229, 36, 326, 85);
		help_Panel.add(label_7);

		JLabel label_3 = new JLabel("点击添加机票添加航班信息");
		label_3.setBounds(293, 131, 203, 15);
		help_Panel.add(label_3);

		JLabel label_10 = new JLabel("点击帮助显示软件使用信息");
		label_10.setBounds(293, 300, 203, 15);
		help_Panel.add(label_10);

		JLabel label_11 = new JLabel("点击介绍，显示软件的信息");
		label_11.setBounds(293, 348, 218, 15);
		help_Panel.add(label_11);

		JLabel label_30 = new JLabel("点击修改航班信息修改航班信息");
		label_30.setBounds(293, 186, 178, 15);
		help_Panel.add(label_30);

		JLabel label_31 = new JLabel("点击删除航班删除航班信息");
		label_31.setBounds(293, 243, 178, 15);
		help_Panel.add(label_31);
		cardPanel.add(cardname[5], ins_Panel);

		JLabel label_8 = new JLabel("谢谢使用我们的软件，我们会持续更新");
		label_8.setBounds(285, 89, 337, 15);
		ins_Panel.add(label_8);

		JLabel label_12 = new JLabel("联系人：赵建银");
		label_12.setBounds(334, 207, 133, 15);
		ins_Panel.add(label_12);

		JLabel lblqqcom = new JLabel("联系人邮箱：384144795@qq.com");
		lblqqcom.setBounds(310, 260, 224, 15);
		ins_Panel.add(lblqqcom);

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

		btn_update = new JButton(cardname[2]);
		btn_update.addActionListener(this);
		toolBar.add(btn_update);

		btn_message = new JButton(cardname[3]);
		btn_message.addActionListener(this);
		toolBar.add(btn_message);

		btn_help = new JButton(cardname[4]);
		btn_help.addActionListener(this);
		toolBar.add(btn_help);

		btn_ins = new JButton(cardname[5]);
		btn_ins.addActionListener(this);
		toolBar.add(btn_ins);
	}

	// 实现按钮的监听触发时的处理
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn_find)) {
			card.show(cardPanel, cardname[0]);
		} else if (e.getSource().equals(btn_order)) {
			card.show(cardPanel, cardname[1]);
		} else if (e.getSource().equals(btn_update)) {
			card.show(cardPanel, cardname[2]);
		} else if (e.getSource().equals(btn_message)) {
			card.show(cardPanel, cardname[3]);
		} else if (e.getSource().equals(btn_help)) {
			card.show(cardPanel, cardname[4]);
		} else if (e.getSource().equals(btn_ins)) {
			card.show(cardPanel, cardname[5]);
		} else if (e.getSource().equals(btn_panel_find)) {
			Vector<Model> vector = findModel();
			if (vector != null) {
				format(vector);
				table.setModel(defaultTableModel);
			}
		} else if (e.getSource().equals(btn_add)) {
			clientContext.add();
		} else if (e.getSource().equals(btn_delete_panel)) {
			int val = JOptionPane.showConfirmDialog(Manager_MainFrame.this,
					"确定删除吗？");
			if (val == JOptionPane.YES_OPTION) {
				clientContext.deleteModel();
				Vector<Model> vector = findModel();
				if (vector != null) {
					format(vector);
					table.setModel(defaultTableModel);
				}
			}
		} else if (e.getSource().equals(btn_update_panel)) {
			clientContext.update();
		}
	}

	/**
	 * 格式化航班信息
	 * 
	 * @param vector
	 *            航班集合
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
	 * 查找航班信息
	 */
	private Vector<Model> findModel() {
		return clientContext.findModel(getFindModel());
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
		return txt_add_jici.getText().toString().trim();
	}

	/**
	 * @return 飞机起点
	 */
	public String getStart() {
		return txt_add_start.getText().toString().trim();
	}

	/**
	 * @return 飞机终点
	 */
	public String getEnd() {
		return txt_add_end.getText().toString().trim();
	}

	/**
	 * @return 起飞时间
	 */
	public String getStartTime() {
		return txt_add_starttime.getText().toString().trim();
	}

	/**
	 * 
	 * @return 机票价格
	 */
	public String getPrice() {
		return txt_add_price.getText().toString().trim();
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
	public String getNumber() {
		return txt_add_number.getText().toString().trim();
	}

	/**
	 * @return 删除时的航班号
	 */
	public String getDeleteJici() {
		return txt_delete_jici.getText().toString().trim();
	}

	/**
	 * @return 飞机航班
	 */
	public String getupdateJici() {
		return txt_update_jici.getText().toString().trim();
	}

	/**
	 * @return 飞机起点
	 */
	public String getupdateStart() {
		return txt_update_start.getText().toString().trim();
	}

	/**
	 * @return 飞机终点
	 */
	public String getupdateEnd() {
		return txt_update_end.getText().toString().trim();
	}

	/**
	 * @return 起飞时间
	 */
	public String getupdateStartTime() {
		return txt_update_starttime.getText().toString().trim();
	}

	/**
	 * 
	 * @return 机票价格
	 */
	public String getupdatePrice() {
		return txt_update_price.getText().toString().trim();
	}

	/**
	 * @return 机票类型
	 */
	public String getJCupdateType() {
		return type_update;
	}

	/**
	 * 获取机票数量
	 * 
	 * @return 机票数量
	 */
	public String getupdateNumber() {
		return txt_update_number.getText().toString().trim();
	}
}

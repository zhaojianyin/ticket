package com.nuc.zjy.frame;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/** 
* @项目名称：ticket   
* @类名称：MainFrame   
* @类描述：  
*
* @author 赵建银
* @email 384144795@qq.com 
* @date 2017-7-7 
* @time 上午10:16:20 
* @version 1.0 
*/
public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7594139566626332999L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("车票预定");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		JLabel label = new JLabel("某默默");
		getContentPane().add(label, "8, 4, left, default");

		JLabel label_2 = new JLabel("→");
		getContentPane().add(label_2, "12, 4");

		JLabel label_1 = new JLabel("某某");
		getContentPane().add(label_1, "26, 4");

		JLabel label_3 = new JLabel("出发日期");
		getContentPane().add(label_3, "6, 8");

		textField = new JTextField();
		textField.setText("2017-07-07");
		getContentPane().add(textField, "10, 8, 9, 1, fill, default");
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("出发时间");
		getContentPane().add(lblNewLabel, "6, 10");

		textField_1 = new JTextField();
		textField_1.setText("00：00-24：00");
		getContentPane().add(textField_1, "10, 10, 9, 1, fill, default");
		textField_1.setColumns(10);

		JLabel label_4 = new JLabel("座位");
		getContentPane().add(label_4, "6, 12");

		textField_2 = new JTextField();
		textField_2.setText("不限");
		getContentPane().add(textField_2, "10, 12, 6, 1, fill, default");
		textField_2.setColumns(10);

		JButton button = new JButton("查询");
		getContentPane().add(button, "6, 16, 21, 1");

		JLabel label_5 = new JLabel("最近常用路线");
		getContentPane().add(label_5, "9, 20, 9, 1");

		JLabel lblNewLabel_1 = new JLabel("西安");
		getContentPane().add(lblNewLabel_1, "2, 22, 2, 1");

		JLabel label_6 = new JLabel("-");
		getContentPane().add(label_6, "4, 22");

		JLabel label_7 = new JLabel("大同");
		getContentPane().add(label_7, "6, 22");

		JLabel lblNewLabel_2 = new JLabel("呣呣");
		getContentPane().add(lblNewLabel_2, "2, 24");

		JLabel label_8 = new JLabel("-");
		getContentPane().add(label_8, "4, 24");

		JLabel lblNewLabel_3 = new JLabel("呣呣");
		getContentPane().add(lblNewLabel_3, "6, 24");

		JLabel lblNewLabel_4 = new JLabel("呣呣");
		getContentPane().add(lblNewLabel_4, "2, 26");

		JLabel label_9 = new JLabel("-");
		getContentPane().add(label_9, "4, 26");

		JLabel lblNewLabel_5 = new JLabel("呣呣");
		getContentPane().add(lblNewLabel_5, "6, 26");

	}
}

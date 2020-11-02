package com.work.calculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame
{

	private JPanel	contentPane;
	/**
	 * 计算结果
	 */
	private JTextField txtJiSuanJieGuo;
	/**
	 * 第一个数
	 */
	double shuA;
	/**
	 * 第二个数
	 */
	double  shuB;
	
	double shu;

	//f

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Calculator()
	{
		setResizable(false);
		setTitle("\u8BA1\u7B97\u5668");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 347);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7F16\u8F91(E)");
		mnNewMenu.setMnemonic('E');
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u590D\u5236(C)");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u7C98\u8D34(V)");
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("\u67E5\u770B");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u6807\u51C6\u578B(T)");
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, 0));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u79D1\u5B66\u578B(S)");
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu_1.add(separator_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u6570\u5B57\u5206\u7EC4(I)");
		mntmNewMenuItem_5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, 0));
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("\u5E2E\u52A9(H)");
		mnNewMenu_2.setMnemonic('H');
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u5E2E\u52A9\u4E3B\u9898(H)");
		mntmNewMenuItem_6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, 0));
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JSeparator separator = new JSeparator();
		mnNewMenu_2.add(separator);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u5173\u4E8E\u8BA1\u7B97\u5668(A)");
		mntmNewMenuItem_7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0));
		mnNewMenu_2.add(mntmNewMenuItem_7);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtJiSuanJieGuo = new JTextField();
		txtJiSuanJieGuo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtJiSuanJieGuo.setToolTipText("\u8BA1\u7B97\u7ED3\u679C");
		txtJiSuanJieGuo.setText("0.");
		txtJiSuanJieGuo.setBounds(10, 0, 334, 29);
		contentPane.add(txtJiSuanJieGuo);
		txtJiSuanJieGuo.setColumns(20);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtJiSuanJieGuo.setText("7");
			}
		});
		btn7.setBounds(40, 64, 52, 37);
		contentPane.add(btn7);
		
		JButton btnChu = new JButton("4");
		btnChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtJiSuanJieGuo.setText("4");
			}
		});
		btnChu.setBounds(40, 119, 52, 37);
		contentPane.add(btnChu);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO 按下1
				txtJiSuanJieGuo.setText("1");
			}
		});
		btn1.setBounds(40, 178, 52, 37);
		contentPane.add(btn1);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtJiSuanJieGuo.setText("0");
			}
		});
		btn0.setBounds(40, 236, 52, 37);
		contentPane.add(btn0);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtJiSuanJieGuo.setText("8");
			}
		});
		btn8.setBounds(102, 64, 52, 37);
		contentPane.add(btn8);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtJiSuanJieGuo.setText("5");
			}
		});
		btn5.setBounds(102, 119, 52, 37);
		contentPane.add(btn5);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtJiSuanJieGuo.setText("2");
			}
		});
		btn2.setBounds(102, 178, 52, 37);
		contentPane.add(btn2);
		
		JButton btnZhengYuFu = new JButton("+/-");
		btnZhengYuFu.setBounds(102, 236, 52, 37);
		contentPane.add(btnZhengYuFu);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtJiSuanJieGuo.setText("9");
			}
		});
		btn9.setBounds(164, 64, 52, 37);
		contentPane.add(btn9);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtJiSuanJieGuo.setText("6");
			}
		});
		btn6.setBounds(164, 119, 52, 37);
		contentPane.add(btn6);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtJiSuanJieGuo.setText("3");
			}
		});
		btn3.setBounds(164, 178, 52, 37);
		contentPane.add(btn3);
		
		JButton btnDian = new JButton(".");
		btnDian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtJiSuanJieGuo.setText(""+txtJiSuanJieGuo.getText()+".");
			}
		});
		btnDian.setBounds(164, 236, 52, 37);
		contentPane.add(btnDian);
		
		JButton button_11 = new JButton("/");
		button_11.setBounds(226, 64, 52, 37);
		contentPane.add(button_11);
		
		JButton btn7Cheng = new JButton("*");
		btn7Cheng.setBounds(226, 119, 52, 37);
		contentPane.add(btn7Cheng);
		
		JButton btnJian = new JButton("-");
		btnJian.setBounds(226, 178, 52, 37);
		contentPane.add(btnJian);
		
		JButton btnJia = new JButton("+");
		btnJia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//+++++
				txtJiSuanJieGuo.setText(""+txtJiSuanJieGuo.getText()+"+");
			}
		});
		btnJia.setBounds(226, 236, 52, 37);
		contentPane.add(btnJia);
		
		JButton btnQuYu = new JButton("%");
		btnQuYu.setBounds(288, 119, 52, 37);
		contentPane.add(btnQuYu);
		
		JButton btnDaoShu = new JButton("1/x");
		btnDaoShu.setBounds(288, 178, 52, 37);
		contentPane.add(btnDaoShu);
		
		JButton btnDeng = new JButton("=");
		btnDeng.setBounds(288, 236, 52, 37);
		contentPane.add(btnDeng);
		
		JButton btnSqrt = new JButton("sqr");
		btnSqrt.setBounds(288, 64, 52, 37);
		contentPane.add(btnSqrt);
		
		JButton btnClear = new JButton("clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO 清空
				txtJiSuanJieGuo.setText("0.");
			}
		});
		btnClear.setBounds(251, 31, 93, 23);
		contentPane.add(btnClear);
	}
}

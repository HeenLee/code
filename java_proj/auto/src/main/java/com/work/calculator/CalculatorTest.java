package com.work.calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorTest extends JFrame {


		
		/**
		 * 进入应用
		 * @param args
		 */
			public static void main(String[] args)
			{
				EventQueue.invokeLater(new Runnable()
				{
					public void run()
					{
						try
						{
							Calculator frame = new Calculator();
							frame.setVisible(true);
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
					}
				});
			}

}

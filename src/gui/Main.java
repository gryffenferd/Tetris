package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Tetris");
		frame.setSize(210, 140);
		frame.setLocationRelativeTo(null);

		frame.setLayout(new FlowLayout());
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});			
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.gray);
		frame.setContentPane(panel);
		
		JButton button = new JButton("      Solo       ");
		button.setSize(200, 10);
		JButton button2 = new JButton("  VS Offline  ");
		JButton button3 = new JButton("  VS Online   ");
		
		panel.add(button);
		panel.add(button2);
		panel.add(button3);	
		
		button.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Do Something Clicked");
			}
		});
		
		button2.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Do Something Clicked 2");
			}
		});
		
		button3.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Do Something Clicked 3");
			}
		});
		
	    frame.setVisible(true);	    
	}
}

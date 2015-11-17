package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame implements ActionListener{
	
	public Frame() {
		this.setTitle("Tetris");
		this.setSize(210, 140);
		this.setLocationRelativeTo(null);

		this.setLayout(new FlowLayout());

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(Color.gray);
		this.setContentPane(panel);

		JButton button = new JButton("      Solo       ");
		JButton button2 = new JButton("  VS Offline  ");
		JButton button3 = new JButton("  VS Online   ");
		
		button.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		
		panel.add(button);
		panel.add(button2);
		panel.add(button3);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SoloFrame tetris = new SoloFrame();
		this.setVisible(false);
	}
}

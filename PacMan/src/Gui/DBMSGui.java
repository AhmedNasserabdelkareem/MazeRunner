package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import eg.edu.alexu.csd.oop.db.cs53.MyDatabase;
import eg.edu.alexu.csd.oop.db.cs53.ParserFiltrer;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class DBMSGui {

	public static JFrame frame;
	public static JTextField textField= new JTextField();
	public static JTextArea textArea = new JTextArea();
	public static JButton btnEnter = new JButton("Enter");
	public static JScrollPane c ;
	public static JLabel lblQuery = new JLabel("Query");




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBMSGui window = new DBMSGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DBMSGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 809, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField.setBackground(Color.BLACK);
		textField.setForeground(Color.GREEN);
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setBounds(12, 55, 767, 55);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblQuery.setForeground(Color.GREEN);
		lblQuery.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuery.setBounds(12, 13, 71, 29);
		frame.getContentPane().add(lblQuery);
		
		btnEnter.setForeground(Color.GREEN);
		btnEnter.setBackground(Color.BLACK);
		frame.getRootPane().setDefaultButton(btnEnter);
		
		btnEnter.setBounds(682, 17, 97, 25);
		frame.getContentPane().add(btnEnter);
		textArea.setForeground(Color.GREEN);
		textArea.setBackground(Color.BLACK);
		
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		c = new JScrollPane(textArea);
		c.setBounds(12, 179,767, 260);
		frame.getContentPane().add(c);
	}
}

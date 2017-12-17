package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import eg.edu.alexu.csd.oop.db.cs53.MyDatabase;
import eg.edu.alexu.csd.oop.jdbc.cs53.JarReflection;
import eg.edu.alexu.csd.oop.jdbc.cs53.MyConnection;
import eg.edu.alexu.csd.oop.jdbc.cs53.MyDriver;
import eg.edu.alexu.csd.oop.jdbc.cs53.MyStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class JdbcGui {

	public static JFrame frame;
	public static JTextField textField_1 = new JTextField();
	public static JFileChooser plugChooser = new JFileChooser();
	public static JTextArea textArea = new JTextArea();
	public static JButton btnNewButton_1 = new JButton("Open Connection");
	public static JButton btnSelectDriver = new JButton("Select Driver");
	public static JButton btnOpenStatement = new JButton("Open Statement");
	public static JPanel panel = new JPanel();
	public static JButton btnEnterUrl = new JButton("Enter URL");
	public static JButton btnCloseConnection = new JButton("Close Connection");
	public static JButton button = new JButton("Enter");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JdbcGui window = new JdbcGui();
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
	public JdbcGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1094, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnNewButton_1.setBounds(32, 152, 186, 38);
		frame.getContentPane().add(btnNewButton_1);

		btnSelectDriver.setBounds(32, 13, 186, 38);
		frame.getContentPane().add(btnSelectDriver);

		btnOpenStatement.setBounds(32, 223, 186, 38);
		frame.getContentPane().add(btnOpenStatement);

		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(254, 13, 810, 418);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		textField_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_1.setBounds(197, 13, 492, 48);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblQuery = new JLabel("Query :");
		lblQuery.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblQuery.setBounds(12, 13, 147, 48);
		panel.add(lblQuery);

		frame.getRootPane().setDefaultButton(button);

		button.setBounds(701, 15, 97, 48);
		panel.add(button);

		JLabel lblNewLabel = new JLabel("Results :");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblNewLabel.setBounds(12, 85, 125, 39);
		panel.add(lblNewLabel);

		textArea.setForeground(Color.RED);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 18));

		textArea.setEditable(false);
		textArea.setBounds(12, 148, 680, 257);
		JScrollPane c = new JScrollPane(textArea);
		c.setBounds(12, 148, 780, 257);
		// p.getContentPane().add(c);
		panel.add(c);

		btnCloseConnection.setBounds(32, 290, 186, 38);
		frame.getContentPane().add(btnCloseConnection);

		btnEnterUrl.setBounds(32, 82, 186, 38);
		frame.getContentPane().add(btnEnterUrl);
	}
}

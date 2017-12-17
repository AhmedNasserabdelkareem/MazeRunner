package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Gui.JdbcGui;
import eg.edu.alexu.csd.oop.db.cs53.MyDatabase;
import eg.edu.alexu.csd.oop.jdbc.cs53.JarReflection;
import eg.edu.alexu.csd.oop.jdbc.cs53.MyConnection;
import eg.edu.alexu.csd.oop.jdbc.cs53.MyDriver;
import eg.edu.alexu.csd.oop.jdbc.cs53.MyStatement;

public class JDBCController {
	private static JdbcGui jdbc = new JdbcGui();
	private static JarReflection ref= new JarReflection();
	private static MyConnection con = new MyConnection();
	private static MyStatement stat ;
	private static Driver driver = new MyDriver();
	private static MyDatabase Db = new MyDatabase();
	private static String acceptedUrl ="";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jdbc.btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dbName = JOptionPane.showInputDialog("Enter DataBase Name "+ ": ");
				Properties info = new Properties();
				String loc = Db.createDatabase(dbName, true);
				File dbDir = new File(loc);
				info.put("path", dbDir);
				try {
					con =(MyConnection) driver.connect(acceptedUrl, info);
					jdbc.textArea.append("Connection is Opened Successfully.... "+"\n");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Connection IS Dropped");
				}
				//driver.connect(url, info)
			}
		});
		jdbc.btnSelectDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userselection = jdbc.plugChooser.showOpenDialog(jdbc.frame);
				if (userselection == JFileChooser.APPROVE_OPTION) {
					String path = jdbc.plugChooser.getSelectedFile().getAbsolutePath();
					 driver =ref.returnDrive(path);
						jdbc.textArea.append("Driver is Chosen Successfully.... "+"\n");

				}
			}
		});
		jdbc.btnOpenStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stat= new MyStatement(con);
					stat = (MyStatement) con.createStatement();
					jdbc.textArea.append("Statement is Created......"+"\n");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Statement IS Failed");
				}				
			}
		});
		jdbc.textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				jdbc.textField_1.setText("");
			}
		});
		jdbc.button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int x=	stat.executeUpdate(jdbc.textField_1.getText().toString());
				jdbc.textArea.append(String.valueOf(x)+"\n");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		jdbc.btnCloseConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jdbc.textArea.append("Connection is Closed......"+"\n");
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		jdbc.btnEnterUrl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = JOptionPane.showInputDialog("Enter URL "+ ": ");
				acceptedUrl =url;
				try {
					if (driver.acceptsURL(url.toString())) {
						jdbc.textArea.append("Url is Valid...."+"\n");
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "URL IS Invalid");
				}
			}
		});
		jdbc.main(args);
		

	}

}

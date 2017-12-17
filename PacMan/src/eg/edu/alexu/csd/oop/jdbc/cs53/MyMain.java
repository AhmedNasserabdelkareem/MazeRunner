package eg.edu.alexu.csd.oop.jdbc.cs53;

import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import eg.edu.alexu.csd.oop.db.cs53.MyDatabase;

public class MyMain {
	static JFileChooser plugChooser = new JFileChooser();


	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
/*		int userselection = plugChooser.showSaveDialog(new Frame());
		if (userselection == JFileChooser.APPROVE_OPTION) {
			String path = plugChooser.getSelectedFile().getAbsolutePath();
			JarReflection x = new JarReflection();
			Driver driver =x.returnDrive(path);*/
		MyDatabase DB = new MyDatabase();
		MyDriver driver = new MyDriver();
		driver.acceptsURL("jdbc:xmldb://localhost");
		Properties info = new Properties();
		String loc = DB.createDatabase("data1", true);
		File dbDir = new File(loc);
		info.put("path", dbDir);
		Connection connection = driver.connect("jdbc:xmldb://localhost", info);
		MyStatement sta = (MyStatement) connection.createStatement();
		//System.out.println(sta.execute("create database mohamedData"));
		System.out.println(sta.executeUpdate("CREATE TABLE table_name9(column_name1 varchar, column_name2 int, column_name3 varchar)"));
		System.out.println(sta.executeUpdate(
				"INSERT INTO table_name9(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)"));
		System.out.println(sta.executeUpdate(
				"INSERT INTO table_name9(column_NAME1, COLUMN_name3, column_name2) VALUES ('value2', 'value4', 5)"));
		System.out.println(sta.executeUpdate(
				"update table_name9 set column_NAME1='mohamed' , COLUMN_name3 = \"ali\""));
		System.out.println(sta.executeUpdate("drop TABLE table_name9"));
	
		}
}


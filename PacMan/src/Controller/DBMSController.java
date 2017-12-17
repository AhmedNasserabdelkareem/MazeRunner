package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Map;

import Gui.DBMSGui;
import eg.edu.alexu.csd.oop.db.cs53.MyDatabase;
import eg.edu.alexu.csd.oop.db.cs53.ParserFiltrer;


public class DBMSController {
	private static MyDatabase x = new MyDatabase();
	private static String current="";
	private static DBMSGui db = new DBMSGui();

	public static void main(String[] args) {
		db.textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				db.textField.setText("");
			}
		});
		
		db.btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					x.currentDB=current;
					Object[][] cd =x.executeQuery(db.textField.getText().toString());
					for(int i=0;i<cd.length;i++){
						for(int j=0;j<cd[0].length;j++){
							db.textArea.append(cd[i][j]+"\t");
						}
						db.textArea.append("\n");
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
				}
				try {
				//	ProcessParser x = new ProcessParser(textField.getText().toString());
					ParserFiltrer d = new ParserFiltrer();
					if(d.isCreateDataBase(db.textField.getText().toString())){
						Map<String, Object> c =d.getInfo(db.textField.getText().toString());
						x.createDatabase((String) c.get("DataBaseName"), true);
						current=x.currentDB;

					}
					
					if(x.executeStructureQuery(db.textField.getText().toString())){
						db.textArea.append("True"+"\n");
					}else{
						db.textArea.append("False"+"\n");

					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
				}
				try {
					x.currentDB=current;
					String c = String.valueOf(x.executeUpdateQuery(db.textField.getText().toString()));
					db.textArea.append(c+"\n");
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
				}
			}
		});
		
		db.main(args);	
	}
}

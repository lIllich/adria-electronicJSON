package package1;

import java.io.IOException;

import java.sql.*;

import package2.ComboBoxWindow;
import package2.DataBase;
import package2.ExportWindow;
import package2.LoadWindow;


public class Main {

	public static void main(String[] args) throws IOException, InterruptedException, SQLException {
		
		
		LoadWindow input = new LoadWindow();
		input.initFrame();
		
		while(!input.bool) Thread.sleep(50);
			
		SystemList json = new SystemList();
		json.loadJSON(input.link.getText().toString());
//		json.loadJSON("E:\\Luka\\01 - RiTeh\\4.semestar\\Strucna Praksa 1\\test.json");
		
		
		
		ComboBoxWindow changer = new ComboBoxWindow(json);
		changer.initFrame();
		
		while(!changer.bool) Thread.sleep(50);
		
		ExportWindow save = new ExportWindow(json);
		save.initFrame();
		
		DataBase d_base = new DataBase();
		d_base.connectToDataBase("jdbc:mysql://localhost:3306", "root", "admin");
		
		for(Sustav s : json.system) {
			d_base.initDataBase(json.system.indexOf(s) + 1);
			d_base.saveToDataBase(s, json.system.indexOf(s) + 1);
		}
	}

}
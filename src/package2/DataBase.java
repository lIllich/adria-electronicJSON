package package2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import package1.Blinds;
import package1.HVAC;
import package1.Lights;
import package1.Room;
import package1.Sustav;

public class DataBase {
	
	Connection con;
	
	public void connectToDataBase(String url, String user, String password) {
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initDataBase(int n) throws SQLException {
		
		con.createStatement().execute("drop database Sustav" + n + ";");
		con.createStatement().execute("create database Sustav" + n + ";");
		con.createStatement().execute("use Sustav" + n + ";");
		
		createSystem();
		createDashboard();
		createLights();
		createHVAC();
		createBlinds();
		createRoom();
				
			
	}
	
	public void saveToDataBase(Sustav s, int n) throws SQLException {
		con.createStatement().execute("use sustav" + n + ";");
		System.out.println("Sys "+n);
		
		StringBuffer sb = new StringBuffer("insert into systemm(num, ID, type, locationID, general_room, general_logo, general_background, general_theme, general_title, general_comm, general_lang, general_show_lights, general_show_blinds, general_show_room, general_show_dashboard, general_dev_mode, general_lockMobileInPortrait, general_lockTabletInLandscape) values(");
		sb.append(n+", ");
		sb.append("'"+s.iD+"', ");
		sb.append("'"+s.type+"', ");
		sb.append("'"+s.locationID+"', ");
		sb.append("'"+s.configuration.general.room+"', ");
		sb.append("'"+s.configuration.general.logo+"', ");
		if(s.configuration.general.background.isEmpty()) sb.append("null, "); else sb.append("'"+s.configuration.general.background+"', ");
		if(s.configuration.general.colorTheme.isEmpty()) sb.append("null, "); else sb.append("'"+s.configuration.general.colorTheme+"', ");
		sb.append("'"+s.configuration.general.title+"', ");
		sb.append("'"+s.configuration.general.comm+"', ");
		sb.append("'"+s.configuration.general.lang+"', ");
		sb.append(s.configuration.general.showLights+", ");
		sb.append(s.configuration.general.showBlinds+", ");
		sb.append(s.configuration.general.showRoom+", ");
		sb.append(s.configuration.general.showDashboard+", ");
		sb.append(s.configuration.general.devMode+", ");
		sb.append(s.configuration.general.lockMobileInPortrait+", ");
		sb.append(s.configuration.general.lockTabletInLandscape+");");
		con.createStatement().execute(sb.toString());
		
		sb = new StringBuffer("insert into dashboard(cell1_type, cell1_data, cell1_title, cell2_type, cell2_data, cell2_title, cell3_type, cell3_data, cell3_title, cell4_type, cell4_data, cell4_title, cell5_type, cell5_data, cell5_title, cell6_type, cell6_data, cell6_title) values(");
		sb.append("'"+s.configuration.dashboard.cell1.type+"', ");
		sb.append("'"+s.configuration.dashboard.cell1.data+"', ");
		sb.append("'"+s.configuration.dashboard.cell1.title+"', ");
		sb.append("'"+s.configuration.dashboard.cell2.type+"', ");
		sb.append("'"+s.configuration.dashboard.cell2.data+"', ");
		sb.append("'"+s.configuration.dashboard.cell2.title+"', ");
		sb.append("'"+s.configuration.dashboard.cell3.type+"', ");
		sb.append("'"+s.configuration.dashboard.cell3.data+"', ");
		sb.append("'"+s.configuration.dashboard.cell3.title+"', ");
		sb.append("'"+s.configuration.dashboard.cell4.type+"', ");
		sb.append("'"+s.configuration.dashboard.cell4.data+"', ");
		sb.append("'"+s.configuration.dashboard.cell4.title+"', ");
		sb.append("'"+s.configuration.dashboard.cell5.type+"', ");
		sb.append("'"+s.configuration.dashboard.cell5.data+"', ");
		sb.append("'"+s.configuration.dashboard.cell5.title+"', ");
		sb.append("'"+s.configuration.dashboard.cell6.type+"', ");
		sb.append("'"+s.configuration.dashboard.cell6.data+"', ");
		sb.append("'"+s.configuration.dashboard.cell6.title+"');");
//		System.out.println(sb);
		con.createStatement().execute(sb.toString());
		
		for(Lights l : s.configuration.light) {
//			System.out.println("system " + n + " new lights");
			sb = new StringBuffer("insert into lights(ID, text, iconOn, iconOff, control, status, showw, dimmable) values(");
			sb.append(l.ID+", ");
			sb.append("'"+l.text+"', ");
			sb.append("'"+l.iconOn+"', ");
			sb.append("'"+l.iconOff+"', ");
			sb.append("'"+l.control+"', ");
			sb.append("'"+l.status+"', ");
			sb.append(l.show+", ");
			sb.append(l.dimmable+");");
			
			con.createStatement().execute(sb.toString());
		}
		
		HVAC h = s.configuration.hvac;
		sb = new StringBuffer("insert into hvac(tempset_showw, tempset_control, tempset_unit, tempset_iconOn, tempset_iconOff, tempset_text, tempset_status, tempsetplus_showw, tempsetplus_control, tempsetplus_iconOn, tempsetplus_iconOff, tempsetplus_text, tempsetplus_status, tempsetminus_showw, tempsetminus_control, tempsetminus_iconOn, tempsetminus_iconOff, tempsetminus_text, tempsetminus_status, tempmeas_showw, tempmeas_control, tempmeas_unit, tempmeas_text, tempmeas_status, controloff_showw, controloff_iconOn, controloff_iconOff, controloff_control, controloff_text, controloff_status, controllow_showw, controllow_iconOn, controllow_iconOff, controllow_control, controllow_text, controllow_status, controlmid_showw, controlmid_iconOn, controlmid_iconOff, controlmid_control, controlmid_text, controlmid_status, controlhigh_showw, controlhigh_iconOn, controlhigh_iconOff, controlhigh_control, controlhigh_text, controlhigh_status, controlauto_showw, controlauto_iconOn, controlauto_iconOff, controlauto_control, controlauto_text, controlauto_status) values(");
		sb.append(h.tempSet.show+", ");
		sb.append("'"+h.tempSet.control+"', ");
		sb.append("'"+h.tempSet.unit+"', ");
		sb.append("'"+h.tempSet.iconOn+"', ");
		sb.append("'"+h.tempSet.iconOff+"', ");
		sb.append("'"+h.tempSet.text+"', ");
		sb.append("'"+h.tempSet.status+"', ");
		
		sb.append(h.tempSetPlus.show+", ");
		sb.append("'"+h.tempSetPlus.control+"', ");
		sb.append("'"+h.tempSetPlus.iconOn+"', ");
		sb.append("'"+h.tempSetPlus.iconOff+"', ");
		sb.append("'"+h.tempSetPlus.text+"', ");
		sb.append("'"+h.tempSetPlus.status+"', ");
		
		sb.append(h.tempSetMinus.show+", ");
		sb.append("'"+h.tempSetMinus.control+"', ");
		sb.append("'"+h.tempSetMinus.iconOn+"', ");
		sb.append("'"+h.tempSetMinus.iconOff+"', ");
		sb.append("'"+h.tempSetMinus.text+"', ");
		sb.append("'"+h.tempSetMinus.status+"', ");
		
		sb.append(h.tempSetMeas.show+", ");
		sb.append("'"+h.tempSetMeas.control+"', ");
		sb.append("'"+h.tempSetMeas.unit+"', ");
		sb.append("'"+h.tempSetMeas.text+"', ");
		sb.append("'"+h.tempSetMeas.status+"', ");
		
		sb.append(h.controlOff.show+", ");
		sb.append("'"+h.controlOff.iconOn+"', ");
		sb.append("'"+h.controlOff.iconOff+"', ");
		sb.append("'"+h.controlOff.control+"', ");
		sb.append("'"+h.controlOff.text+"', ");
		sb.append("'"+h.controlOff.status+"', ");
		
		sb.append(h.controlLow.show+", ");
		sb.append("'"+h.controlLow.iconOn+"', ");
		sb.append("'"+h.controlLow.iconOff+"', ");
		sb.append("'"+h.controlLow.control+"', ");
		sb.append("'"+h.controlLow.text+"', ");
		sb.append("'"+h.controlLow.status+"', ");
		
		sb.append(h.controlMid.show+", ");
		sb.append("'"+h.controlMid.iconOn+"', ");
		sb.append("'"+h.controlMid.iconOff+"', ");
		sb.append("'"+h.controlMid.control+"', ");
		sb.append("'"+h.controlMid.text+"', ");
		sb.append("'"+h.controlMid.status+"', ");
		
		sb.append(h.controlHigh.show+", ");
		sb.append("'"+h.controlHigh.iconOn+"', ");
		sb.append("'"+h.controlHigh.iconOff+"', ");
		sb.append("'"+h.controlHigh.control+"', ");
		sb.append("'"+h.controlHigh.text+"', ");
		sb.append("'"+h.controlHigh.status+"', ");
		
		sb.append(h.controlAuto.show+", ");
		sb.append("'"+h.controlAuto.iconOn+"', ");
		sb.append("'"+h.controlAuto.iconOff+"', ");
		sb.append("'"+h.controlAuto.control+"', ");
		sb.append("'"+h.controlAuto.text+"', ");
		sb.append("'"+h.controlAuto.status+"');");
		con.createStatement().execute(sb.toString());

		for(Blinds b : s.configuration.blinds) {
			sb = new StringBuffer("insert into blinds(ID, name, showw, dir1_show, dir1_text, dir1_iconOn, dir1_iconOff, dir1_control, dir1_status, dir2_show, dir2_text, dir2_iconOn, dir2_iconOff, dir2_control, dir2_status) values(");
			sb.append("'"+b.ID+"', ");
			sb.append("'"+b.name+"', ");
			sb.append(b.show+", ");
			sb.append(b.direction1.show+", ");
			sb.append("'"+b.direction1.text+"', ");
			sb.append("'"+b.direction1.iconOn+"', ");
			sb.append("'"+b.direction1.iconOff+"', ");
			sb.append("'"+b.direction1.control+"', ");
			sb.append("'"+b.direction1.status+"', ");
			sb.append(b.direction2.show+", ");
			sb.append("'"+b.direction2.text+"', ");
			sb.append("'"+b.direction2.iconOn+"', ");
			sb.append("'"+b.direction2.iconOff+"', ");
			sb.append("'"+b.direction2.control+"', ");
			sb.append("'"+b.direction2.status+"');");
			
			con.createStatement().execute(sb.toString());
		}
		
		Room r = s.configuration.room;
		sb = new StringBuffer("insert into room(validFrom, validTo, digialKey_ID, digialKey_show, digialKey_text, digialKey_iconOn, digialKey_iconOff, digialKey_control, digialKey_status, dnd_ID, dnd_show, dnd_text, dnd_iconOn, dnd_iconOff, dnd_control, dnd_status, sos_ID, sos_show, sos_text, sos_iconOn, sos_iconOff, sos_control, sos_status, mur_ID, mur_show, mur_text, mur_iconOn, mur_iconOff, mur_control, mur_status, wakeup_ID, wakeup_show, wakeup_text, wakeup_iconOn, wakeup_iconOff, wakeup_control, wakeup_status) values(");
		sb.append("'"+r.validFrom+"', ");
		sb.append("'"+r.validTo+"', ");
		
		sb.append("'"+r.digitalKey.ID+"', ");
		sb.append(r.digitalKey.show+", ");
		sb.append("'"+r.digitalKey.text+"', ");
		sb.append("'"+r.digitalKey.iconOn+"', ");
		sb.append("'"+r.digitalKey.iconOff+"', ");
		sb.append("'"+r.digitalKey.control+"', ");
		sb.append("'"+r.digitalKey.status+"', ");
		
		sb.append("'"+r.dnd.ID+"', ");
		sb.append(r.dnd.show+", ");
		sb.append("'"+r.dnd.text+"', ");
		sb.append("'"+r.dnd.iconOn+"', ");
		sb.append("'"+r.dnd.iconOff+"', ");
		sb.append("'"+r.dnd.control+"', ");
		sb.append("'"+r.dnd.status+"', ");
		
		sb.append("'"+r.sos.ID+"', ");
		sb.append(r.sos.show+", ");
		sb.append("'"+r.sos.text+"', ");
		sb.append("'"+r.sos.iconOn+"', ");
		sb.append("'"+r.sos.iconOff+"', ");
		sb.append("'"+r.sos.control+"', ");
		sb.append("'"+r.sos.status+"', ");
		
		sb.append("'"+r.mur.ID+"', ");
		sb.append(r.mur.show+", ");
		sb.append("'"+r.mur.text+"', ");
		sb.append("'"+r.mur.iconOn+"', ");
		sb.append("'"+r.mur.iconOff+"', ");
		sb.append("'"+r.mur.control+"', ");
		sb.append("'"+r.mur.status+"', ");
		
		sb.append("'"+r.wakeup.ID+"', ");
		sb.append(r.wakeup.show+", ");
		sb.append("'"+r.wakeup.text+"', ");
		sb.append("'"+r.wakeup.iconOn+"', ");
		sb.append("'"+r.wakeup.iconOff+"', ");
		sb.append("'"+r.wakeup.control+"', ");
		sb.append("'"+r.wakeup.status+"');");
		

		
		System.out.println(sb);
		con.createStatement().execute(sb.toString());
	}


	private void createRoom() throws SQLException {
		con.createStatement().execute("create table room("
				+ "validFrom VARCHAR(50),"
				+ "validTo VARCHAR(50),"
				
				+ "digialKey_ID VARCHAR(20),"
				+ "digialKey_show BIT,"
				+ "digialKey_text VARCHAR(20),"
				+ "digialKey_iconOn VARCHAR(20),"
				+ "digialKey_iconOff VARCHAR(20),"
				+ "digialKey_control VARCHAR(20),"
				+ "digialKey_status VARCHAR(20),"
				
				+ "dnd_ID VARCHAR(20),"
				+ "dnd_show BIT,"
				+ "dnd_text VARCHAR(20),"
				+ "dnd_iconOn VARCHAR(20),"
				+ "dnd_iconOff VARCHAR(20),"
				+ "dnd_control VARCHAR(20),"
				+ "dnd_status VARCHAR(20),"
				
				+ "sos_ID VARCHAR(20),"
				+ "sos_show BIT,"
				+ "sos_text VARCHAR(20),"
				+ "sos_iconOn VARCHAR(20),"
				+ "sos_iconOff VARCHAR(20),"
				+ "sos_control VARCHAR(20),"
				+ "sos_status VARCHAR(20),"
				
				+ "mur_ID VARCHAR(20),"
				+ "mur_show BIT,"
				+ "mur_text VARCHAR(20),"
				+ "mur_iconOn VARCHAR(20),"
				+ "mur_iconOff VARCHAR(20),"
				+ "mur_control VARCHAR(20),"
				+ "mur_status VARCHAR(20),"
				
				+ "wakeup_ID VARCHAR(20),"
				+ "wakeup_show BIT,"
				+ "wakeup_text VARCHAR(20),"
				+ "wakeup_iconOn VARCHAR(20),"
				+ "wakeup_iconOff VARCHAR(20),"
				+ "wakeup_control VARCHAR(20),"
				+ "wakeup_status VARCHAR(20)"				
				+ ");");
	}

	private void createBlinds() throws SQLException {
		con.createStatement().execute("create table blinds("
				+ "ID VARCHAR(20),"
				+ "name VARCHAR(20),"
				+ "showw BIT,"
				+ "dir1_show BIT,"
				+ "dir1_text VARCHAR(20),"
				+ "dir1_iconOn VARCHAR(20),"
				+ "dir1_iconOff VARCHAR(20),"
				+ "dir1_control VARCHAR(20),"
				+ "dir1_status VARCHAR(20),"
				+ "dir2_show BIT,"
				+ "dir2_text VARCHAR(20),"
				+ "dir2_iconOn VARCHAR(20),"
				+ "dir2_iconOff VARCHAR(20),"
				+ "dir2_control VARCHAR(20),"
				+ "dir2_status VARCHAR(20)"
				+ ");");
	}

	private void createHVAC() throws SQLException {
		con.createStatement().execute("create table hvac("
				+ "tempset_showw BIT,"
				+ "tempset_control VARCHAR(20),"
				+ "tempset_unit VARCHAR(20),"
				+ "tempset_iconOn VARCHAR(20),"
				+ "tempset_iconOff VARCHAR(20),"
				+ "tempset_text VARCHAR(20),"
				+ "tempset_status VARCHAR(20),"
				
				+ "tempsetplus_showw BIT,"
				+ "tempsetplus_control VARCHAR(20),"
				+ "tempsetplus_iconOn VARCHAR(20),"
				+ "tempsetplus_iconOff VARCHAR(20),"
				+ "tempsetplus_text VARCHAR(20),"
				+ "tempsetplus_status VARCHAR(20),"
				
				+ "tempsetminus_showw BIT,"
				+ "tempsetminus_control VARCHAR(20),"
				+ "tempsetminus_iconOn VARCHAR(20),"
				+ "tempsetminus_iconOff VARCHAR(20),"
				+ "tempsetminus_text VARCHAR(20),"
				+ "tempsetminus_status VARCHAR(20),"
				
				+ "tempmeas_showw BIT,"
				+ "tempmeas_control VARCHAR(20),"
				+ "tempmeas_unit VARCHAR(20),"
				+ "tempmeas_text VARCHAR(20),"
				+ "tempmeas_status VARCHAR(20),"
				
				+ "controloff_showw BIT,"
				+ "controloff_iconOn VARCHAR(20),"
				+ "controloff_iconOff VARCHAR(20),"
				+ "controloff_control VARCHAR(20),"
				+ "controloff_text VARCHAR(20),"
				+ "controloff_status VARCHAR(20),"
				
				+ "controllow_showw BIT,"
				+ "controllow_iconOn VARCHAR(20),"
				+ "controllow_iconOff VARCHAR(20),"
				+ "controllow_control VARCHAR(20),"
				+ "controllow_text VARCHAR(20),"
				+ "controllow_status VARCHAR(20),"
				
				+ "controlmid_showw BIT,"
				+ "controlmid_iconOn VARCHAR(20),"
				+ "controlmid_iconOff VARCHAR(20),"
				+ "controlmid_control VARCHAR(20),"
				+ "controlmid_text VARCHAR(20),"
				+ "controlmid_status VARCHAR(20),"
				
				+ "controlhigh_showw BIT,"
				+ "controlhigh_iconOn VARCHAR(20),"
				+ "controlhigh_iconOff VARCHAR(20),"
				+ "controlhigh_control VARCHAR(20),"
				+ "controlhigh_text VARCHAR(20),"
				+ "controlhigh_status VARCHAR(20),"
				
				+ "controlauto_showw BIT,"
				+ "controlauto_iconOn VARCHAR(20),"
				+ "controlauto_iconOff VARCHAR(20),"
				+ "controlauto_control VARCHAR(20),"
				+ "controlauto_text VARCHAR(20),"
				+ "controlauto_status VARCHAR(20)"
				+ ");");
	}

	private void createLights() throws SQLException {
		con.createStatement().execute("create table lights("
				+ "ID INT,"
				+ "text VARCHAR(40),"
				+ "iconOn VARCHAR(40),"
				+ "iconOff VARCHAR(40),"
				+ "control VARCHAR(40),"
				+ "status VARCHAR(40),"
				+ "showw BIT,"
				+ "dimmable BIT"
				+ ");");
	}

	private void createDashboard() throws SQLException {
		con.createStatement().execute("create table dashboard("
				+ "cell1_type VARCHAR(60),"
				+ "cell1_data VARCHAR(60),"
				+ "cell1_title VARCHAR(60),"
				+ "cell2_type VARCHAR(60),"
				+ "cell2_data VARCHAR(60),"
				+ "cell2_title VARCHAR(60),"
				+ "cell3_type VARCHAR(60),"
				+ "cell3_data VARCHAR(60),"
				+ "cell3_title VARCHAR(60),"
				+ "cell4_type VARCHAR(60),"
				+ "cell4_data VARCHAR(60),"
				+ "cell4_title VARCHAR(60),"
				+ "cell5_type VARCHAR(60),"
				+ "cell5_data VARCHAR(60),"
				+ "cell5_title VARCHAR(20),"
				+ "cell6_type VARCHAR(20),"
				+ "cell6_data VARCHAR(60),"
				+ "cell6_title VARCHAR(60)"
				+ ");");
	}

	private void createSystem() throws SQLException {
		con.createStatement().execute("create table Systemm("
				+ "num INT,"
				+ "ID VARCHAR(20),"
				+ "type VARCHAR(20),"
				+ "locationID VARCHAR(20),"
				
				+ "general_room VARCHAR(20),"
				+ "general_logo VARCHAR(20),"
				+ "general_background VARCHAR(20),"
				+ "general_theme VARCHAR(20),"
				+ "general_title VARCHAR(20),"
				+ "general_comm VARCHAR(20),"
				+ "general_lang VARCHAR(20),"
				+ "general_show_lights BIT,"
				+ "general_show_blinds BIT,"
				+ "general_show_room BIT,"
				+ "general_show_dashboard BIT,"
				+ "general_dev_mode BIT,"
				+ "general_lockMobileInPortrait BIT,"
				+ "general_lockTabletInLandscape BIT"
				+ ");");
	}

	
}

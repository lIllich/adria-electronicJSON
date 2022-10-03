package package2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import package1.SystemList;

public class ComboBoxWindow implements ActionListener, KeyListener {
	
	public SystemList json;
	JFrame frame;
	JFrame confirm;
	
	JComboBox<String> cb_num;
	JComboBox<String> cb_sys;
	JComboBox<String> cb_conf;
	JComboBox<String> cb_dshb;
	JComboBox<String> cb_lght;
	JComboBox<String> cb_hvac;
	JComboBox<String> cb_room;
	JComboBox<String> cb_blnd;
	
	JLabel first_top;
	JLabel second_top;
	JLabel l_num;
	JLabel l_sys;
	JLabel l_conf;
	JLabel l_dshb;
	JLabel l_lght;
	JLabel l_hvac;
	JLabel l_room;
	JLabel l_blnd;
	
	JLabel dir1 = new JLabel("DIRECTION 1");
	JLabel dir2 = new JLabel("DIRECTION 2");
	
	JLabel v_background = new JLabel("background:");
	JLabel v_colorTheme = new JLabel("color_theme:");
	JLabel v_comm = new JLabel("comm:");
	JLabel v_control2 = new JLabel("control:");
	JLabel v_control = new JLabel("control:");
	JLabel v_data = new JLabel("data:");
	JLabel v_devMode = new JLabel("dev_mode:");
	JLabel v_dimmable = new JLabel("dimmable:");
	JLabel v_iconOff2 = new JLabel("iconOff:");
	JLabel v_iconOff = new JLabel("iconOff:");
	JLabel v_iconOn2 = new JLabel("iconOn:");
	JLabel v_iconOn = new JLabel("iconOn:");
	JLabel v_id = new JLabel("ID:");
	JLabel v_lang = new JLabel("lang:");
	JLabel v_locationId = new JLabel("locationID:");
	JLabel v_lockMobileInPortrait = new JLabel("lockMobileInPortrait:");
	JLabel v_lockTabletInLandscape = new JLabel("lockTabletInLandscape:");
	JLabel v_logo = new JLabel("logo:");
	JLabel v_name = new JLabel("name:");
	JLabel v_room = new JLabel("room:");
	JLabel v_show2 = new JLabel("show:");
	JLabel v_show3 = new JLabel("show:");
	JLabel v_show = new JLabel("show:");
	JLabel v_showBlinds = new JLabel("show_blinds:");
	JLabel v_showDashboard = new JLabel("show_dashboard:");
	JLabel v_showHvac = new JLabel("show_hvac:");
	JLabel v_showLights = new JLabel("show_lights:");
	JLabel v_showRoom = new JLabel("show_room:");
	JLabel v_status2 = new JLabel("status:");
	JLabel v_status = new JLabel("status:");
	JLabel v_text2 = new JLabel("text:");
	JLabel v_text = new JLabel("text:");
	JLabel v_title = new JLabel("title:");
	JLabel v_type = new JLabel("type:");
	JLabel v_unit = new JLabel("unit");
	JLabel v_validFrom = new JLabel("validFrom:");
	JLabel v_validTo = new JLabel("validTo:");
	
	JTextField t_background = new JTextField();
	JTextField t_colorTheme = new JTextField();
	JTextField t_comm = new JTextField();
	JTextField t_control2 = new JTextField();
	JTextField t_control = new JTextField();
	JTextField t_data = new JTextField();
	JTextField t_devMode = new JTextField();
	JTextField t_dimmable = new JTextField();
	JTextField t_iconOff2 = new JTextField();
	JTextField t_iconOff = new JTextField();
	JTextField t_iconOn2 = new JTextField();
	JTextField t_iconOn = new JTextField();
	JTextField t_id = new JTextField();
	JTextField t_lang = new JTextField();
	JTextField t_locationId = new JTextField();
	JTextField t_lockMobileInPortrait = new JTextField();
	JTextField t_lockTabletInLandscape = new JTextField();
	JTextField t_logo = new JTextField();
	JTextField t_name = new JTextField();
	JTextField t_room = new JTextField();
	JTextField t_show2 = new JTextField();
	JTextField t_show3 = new JTextField();
	JTextField t_show = new JTextField();
	JTextField t_showBlinds = new JTextField();
	JTextField t_showDashboard = new JTextField();
	JTextField t_showHvac = new JTextField();
	JTextField t_showLights = new JTextField();
	JTextField t_showRoom = new JTextField();
	JTextField t_status2 = new JTextField();
	JTextField t_status = new JTextField();
	JTextField t_text2 = new JTextField();
	JTextField t_text = new JTextField();
	JTextField t_title = new JTextField();
	JTextField t_type = new JTextField();
	JTextField t_unit = new JTextField();
	JTextField t_validFrom = new JTextField();
	JTextField t_validTo = new JTextField();
	
	JButton show;
	JButton save;
	JButton export;
	JButton cancel;
	JButton ret;
	JButton leave;
	
	public Boolean bool = false;
	
	int monitorHeight;
	int monitorWidth;
	
	int greaterNumOfLights;
	int greaterNumOfBlinds;
	int num = -1, sys = -1, conf = -1, dash = -1, light = -1, hvac = -1, blind = -1, room = -1;
	final int frameWidth = 1150;
	final int frameHeight = 700;
	final int label_start = 20;
	final int label_start2 = 370;
	final int label_len = 165;
	final int cbox_start = 185;
	final int btnWidth = 150;
	final int btnHeight = 30;
	
	final int tf_start = 550;
	final int tf_len = 300;
	
	public ComboBoxWindow(SystemList json) {
		this.json = new SystemList();
		this.json = json;
		
		t_background.addKeyListener(this);
		t_colorTheme.addKeyListener(this);
		t_comm.addKeyListener(this);
		t_control2.addKeyListener(this);
		t_control.addKeyListener(this);
		t_data.addKeyListener(this);
		t_devMode.addKeyListener(this);
		t_dimmable.addKeyListener(this);
		t_iconOff2.addKeyListener(this);
		t_iconOff.addKeyListener(this);
		t_iconOn2.addKeyListener(this);
		t_iconOn.addKeyListener(this);
		t_id.addKeyListener(this);
		t_lang.addKeyListener(this);
		t_locationId.addKeyListener(this);
		t_lockMobileInPortrait.addKeyListener(this);
		t_lockTabletInLandscape.addKeyListener(this);
		t_logo.addKeyListener(this);
		t_name.addKeyListener(this);
		t_room.addKeyListener(this);
		t_show2.addKeyListener(this);
		t_show3.addKeyListener(this);
		t_show.addKeyListener(this);
		t_showBlinds.addKeyListener(this);
		t_showDashboard.addKeyListener(this);
		t_showHvac.addKeyListener(this);
		t_showLights.addKeyListener(this);
		t_showRoom.addKeyListener(this);
		t_status2.addKeyListener(this);
		t_status.addKeyListener(this);
		t_text2.addKeyListener(this);
		t_text.addKeyListener(this);
		t_title.addKeyListener(this);
		t_type.addKeyListener(this);
		t_unit.addKeyListener(this);
		t_validFrom.addKeyListener(this);
		t_validTo.addKeyListener(this);
		
	}

	public void initFrame() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		monitorWidth = (int) screenSize.getWidth();
		monitorHeight = (int) screenSize.getHeight();
		
		greaterNumOfLights = findTheGreaterNumOfLights();
		greaterNumOfBlinds = findTheGreaterNumOfBlinds();
//		System.out.println(greaterNumOfBlinds);
		
		final boolean isComponentsEditable = false;
		
		show = new JButton("Show/Refresh");
		show.setBounds(50, 180, btnWidth, btnHeight);
		show.setEnabled(false);
		show.addActionListener(this);
		
		save = new JButton("Save Variables");
		save.setBounds(frameWidth -50 -btnWidth, frameHeight -170 -btnHeight, btnWidth, btnHeight);
		save.setEnabled(false);
		save.addActionListener(this);
		
		export = new JButton("Export & Exit");
		export.setBounds(frameWidth -50 -btnWidth, frameHeight -60 -btnHeight, btnWidth, btnHeight);
		export.setEnabled(false);
		export.addActionListener(this);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(frameWidth -50 -btnWidth, frameHeight -95 -btnHeight, btnWidth, btnHeight);
		cancel.setEnabled(true);
		cancel.addActionListener(this);
		
		first_top = new JLabel("CHOOSE CONFIGURATION TO SHOW");
		first_top.setBounds(label_start + 25, 3, 250, 30);
		first_top.setVisible(true);
		
		second_top = new JLabel("CHECK OR UPDATE VARIABLES");
		second_top.setBounds(label_start + 375, 3, 250, 30);
		second_top.setVisible(true);
		
		l_num = new JLabel("Set Number Of System         :");
		l_num.setBounds(label_start, 30, label_len, 30);
		l_num.setVisible(true);
		
		l_sys = new JLabel("Set Part Of System                :");
		l_sys.setBounds(label_start, 65, label_len, 30);
		l_sys.setVisible(true);
		
		l_conf = new JLabel("Set Part Of Configuration     :");
		l_conf.setBounds(label_start, 100, label_len, 30);
		l_conf.setVisible(false);
		
		l_dshb = new JLabel("Set Part Of Dashboard          :");
		l_dshb.setBounds(label_start, 135, label_len, 30);
		l_dshb.setVisible(false);
		
		l_lght = new JLabel("Set Number Of Light             :");
		l_lght.setBounds(label_start, 135, label_len, 30);
		l_lght.setVisible(false);
		
		l_hvac = new JLabel("Set Part Of HVAC                   :");
		l_hvac.setBounds(label_start, 135, label_len, 30);
		l_hvac.setVisible(false);
		
		l_blnd = new JLabel("Set Number Of Blind             :");
		l_blnd.setBounds(label_start, 135, label_len, 30);
		l_blnd.setVisible(false);
		
		l_room = new JLabel("Set Part Of Room                   :");
		l_room.setBounds(label_start, 135, label_len, 30);
		l_room.setVisible(false);
		
		String[] s1 = new String[json.system.size()+1];
		s1[0] = "";
		for(Integer i = 1; i < json.system.size()+1; i++) s1[i] = i.toString();
		cb_num = new JComboBox<String>(s1);
		cb_num.setBounds(cbox_start, 30, 120, 30);
		cb_num.setEditable(isComponentsEditable);
		cb_num.addActionListener(this);
		
		String[] s2 = {"", "variables", "configuration"};
		cb_sys = new JComboBox<String>(s2);
		cb_sys.setBounds(cbox_start, 65, 120, 30);
		cb_sys.setEditable(isComponentsEditable);
		cb_sys.addActionListener(this);
		
		String[] s3 = {"", "general", "dashboards", "lights", "hvac" , "blinds" , "room"};
		cb_conf = new JComboBox<String>(s3);
		cb_conf.setBounds(cbox_start, 100, 120, 30);
		cb_conf.setEditable(isComponentsEditable);
		cb_conf.addActionListener(this);
		cb_conf.setVisible(false);
		
		String[] s5 = {"", "Cell 1", "Cell 2", "Cell 3", "Cell 4", "Cell 5", "Cell 6"};
		cb_dshb = new JComboBox<String>(s5);
		cb_dshb.setBounds(cbox_start, 135, 120, 30);
		cb_dshb.setEditable(isComponentsEditable);
		cb_dshb.addActionListener(this);
		cb_dshb.setVisible(false);
		
		String[] s6 = new String[greaterNumOfLights + 1];
		s6[0] = "";
		for(Integer i = 1; i < greaterNumOfLights + 1; i++) s6[i] = "Light " + i.toString();
		cb_lght = new JComboBox<String>(s6);
		cb_lght.setBounds(cbox_start, 135, 120, 30);
		cb_lght.setEditable(isComponentsEditable);
		cb_lght.addActionListener(this);
		cb_lght.setVisible(false);
		
		String[] s7 = {"", "temp_set", "temp_set_plus", "temp_set_minus", "temp_meas", 
						"control_off", "control_low", "control_mid", "control_high", "control_auto"};
		cb_hvac = new JComboBox<String>(s7);
		cb_hvac.setBounds(cbox_start, 135, 120, 30);
		cb_hvac.setEditable(isComponentsEditable);
		cb_hvac.addActionListener(this);
		cb_hvac.setVisible(false);
		
		String[] s8 = new String[greaterNumOfBlinds + 1];
		s8[0] = "";
		for(Integer i = 1; i < greaterNumOfBlinds + 1; i++) s8[i] = "Blind " + i.toString();
		cb_blnd = new JComboBox<String>(s8);
		cb_blnd.setBounds(cbox_start, 135, 120, 30);
		cb_blnd.setEditable(isComponentsEditable);
		cb_blnd.addActionListener(this);
		cb_blnd.setVisible(false);
		
		String[] s9 = {"", "variables", "digital_key", "dnd", "sos", "mur", "wakeup"};
		cb_room = new JComboBox<String>(s9);
		cb_room.setBounds(cbox_start, 135, 120, 30);
		cb_room.setEditable(isComponentsEditable);
		cb_room.addActionListener(this);
		cb_room.setVisible(false);
		
		
		frame = new JFrame("jsonModifier - Change file");
		frame.setSize(frameWidth, frameHeight);
		frame.setLocation(monitorWidth/2 - frameWidth/2, monitorHeight/2 - frameHeight/2);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(first_top);
		frame.add(second_top);
		frame.add(l_num);
		frame.add(l_sys);
		frame.add(l_conf);
		frame.add(l_dshb);
		frame.add(l_lght);
		frame.add(l_hvac);
		frame.add(l_room);
		frame.add(l_blnd);
		
		frame.add(cb_num);
		frame.add(cb_sys);
		frame.add(cb_conf);
		frame.add(cb_dshb);
		frame.add(cb_lght);
		frame.add(cb_hvac);
		frame.add(cb_blnd);
		frame.add(cb_room);
		
		frame.add(dir1);
		frame.add(dir2);
		
		frame.add(v_background);
		frame.add(v_colorTheme);
		frame.add(v_comm);
		frame.add(v_control2);
		frame.add(v_control);
		frame.add(v_data);
		frame.add(v_devMode);
		frame.add(v_dimmable);
		frame.add(v_iconOff2);
		frame.add(v_iconOff);
		frame.add(v_iconOn2);
		frame.add(v_iconOn);
		frame.add(v_id);
		frame.add(v_lang);
		frame.add(v_locationId);
		frame.add(v_lockMobileInPortrait);
		frame.add(v_lockTabletInLandscape);
		frame.add(v_logo);
		frame.add(v_name);
		frame.add(v_room);
		frame.add(v_show2);
		frame.add(v_show3);
		frame.add(v_show);
		frame.add(v_showBlinds);
		frame.add(v_showDashboard);
		frame.add(v_showHvac);
		frame.add(v_showLights);
		frame.add(v_showRoom);
		frame.add(v_status2);
		frame.add(v_status);
		frame.add(v_text2);
		frame.add(v_text);
		frame.add(v_title);
		frame.add(v_type);
		frame.add(v_unit);
		frame.add(v_validFrom);
		frame.add(v_validTo);
		
		frame.add(t_background);
		frame.add(t_colorTheme);
		frame.add(t_comm);
		frame.add(t_control2);
		frame.add(t_control);
		frame.add(t_data);
		frame.add(t_devMode);
		frame.add(t_dimmable);
		frame.add(t_iconOff2);
		frame.add(t_iconOff);
		frame.add(t_iconOn2);
		frame.add(t_iconOn);
		frame.add(t_id);
		frame.add(t_lang);
		frame.add(t_locationId);
		frame.add(t_lockMobileInPortrait);
		frame.add(t_lockTabletInLandscape);
		frame.add(t_logo);
		frame.add(t_name);
		frame.add(t_room);
		frame.add(t_show2);
		frame.add(t_show3);
		frame.add(t_show);
		frame.add(t_showBlinds);
		frame.add(t_showDashboard);
		frame.add(t_showHvac);
		frame.add(t_showLights);
		frame.add(t_showRoom);
		frame.add(t_status2);
		frame.add(t_status);
		frame.add(t_text2);
		frame.add(t_text);
		frame.add(t_title);
		frame.add(t_type);
		frame.add(t_unit);
		frame.add(t_validFrom);
		frame.add(t_validTo);
		
		frame.add(show);
		frame.add(save);
		frame.add(export);
		frame.add(cancel);
		
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
	} 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == save) {
			saveVariables();
			export.setEnabled(true);
			return;
		}
		else if(e.getSource() == ret) {
			confirm.dispose();
		}
		else if(e.getSource() == leave) {
			confirm.dispose();
			frame.dispose();
		}
		else if(e.getSource() == export) {
			frame.dispose();
			bool = true;			
		}
		else if(e.getSource() == cancel) {
			JLabel message = new JLabel("<html>Are you sure you want to leave?<br/>All unexported changes will be lost!</html>", SwingConstants.CENTER);
			message.setBounds(25, 30, 240, 50);
			message.setVisible(true);
			
			ret = new JButton("Return");
			ret.setBounds(160, 100, 80, 30);
			ret.setEnabled(true);
			ret.addActionListener(this);
			
			leave = new JButton("Leave");
			leave.setBounds(50, 100, 80, 30);
			leave.setEnabled(true);
			leave.addActionListener(this);
			
			confirm = new JFrame("Leave Program");
			confirm.setSize(300, 200);
			confirm.setLocation(monitorWidth/2 - 300/2, monitorHeight/2 - 200/2);		
			confirm.add(message);
			confirm.add(leave);
			confirm.add(ret);
			confirm.setLayout(null);
			confirm.setVisible(true);
			confirm.setResizable(false);
			
			return;
		}
		
		dir1.setVisible(false);
		dir2.setVisible(false);
		
		v_background.setVisible(false);
		v_colorTheme.setVisible(false);
		v_comm.setVisible(false);
		v_control.setVisible(false);
		v_control2.setVisible(false);
		v_data.setVisible(false);
		v_devMode.setVisible(false);
		v_dimmable.setVisible(false);
		v_iconOff.setVisible(false);
		v_iconOff2.setVisible(false);
		v_iconOn.setVisible(false);
		v_iconOn2.setVisible(false);
		v_id.setVisible(false);
		v_lang.setVisible(false);
		v_locationId.setVisible(false);
		v_lockMobileInPortrait.setVisible(false);
		v_lockTabletInLandscape.setVisible(false);
		v_logo.setVisible(false);
		v_name.setVisible(false);
		v_room.setVisible(false);
		v_show.setVisible(false);
		v_show2.setVisible(false);
		v_show3.setVisible(false);
		v_showBlinds.setVisible(false);
		v_showDashboard.setVisible(false);
		v_showHvac.setVisible(false);
		v_showLights.setVisible(false);
		v_showRoom.setVisible(false);
		v_status.setVisible(false);
		v_status2.setVisible(false);
		v_text.setVisible(false);
		v_text2.setVisible(false);
		v_title.setVisible(false);
		v_title.setVisible(false);
		v_type.setVisible(false);
		v_unit.setVisible(false);
		v_validFrom.setVisible(false);
		v_validTo.setVisible(false);
		
		t_background.setVisible(false);
		t_colorTheme.setVisible(false);
		t_comm.setVisible(false);
		t_control2.setVisible(false);
		t_control.setVisible(false);
		t_data.setVisible(false);
		t_devMode.setVisible(false);
		t_dimmable.setVisible(false);
		t_iconOff2.setVisible(false);
		t_iconOff.setVisible(false);
		t_iconOn2.setVisible(false);
		t_iconOn.setVisible(false);
		t_id.setVisible(false);
		t_lang.setVisible(false);
		t_locationId.setVisible(false);
		t_lockMobileInPortrait.setVisible(false);
		t_lockTabletInLandscape.setVisible(false);
		t_logo.setVisible(false);
		t_name.setVisible(false);
		t_room.setVisible(false);
		t_show2.setVisible(false);
		t_show3.setVisible(false);
		t_show.setVisible(false);
		t_showBlinds.setVisible(false);
		t_showDashboard.setVisible(false);
		t_showHvac.setVisible(false);
		t_showLights.setVisible(false);
		t_showRoom.setVisible(false);
		t_status2.setVisible(false);
		t_status.setVisible(false);
		t_text2.setVisible(false);
		t_text.setVisible(false);
		t_title.setVisible(false);
		t_type.setVisible(false);
		t_unit.setVisible(false);
		t_validFrom.setVisible(false);
		t_validTo.setVisible(false);
		
		
		if(e.getSource() == show) {
			System.out.println("Refresh Variables");
			
			if(num > 0) {
				if(sys == 1) showSysVariables();
				if(sys == 2) {
					if(conf == 1) showGeneral();
					if(conf == 2 && dash > 0) showDashboard();
					if(conf == 3 && light > 0) showLight();
					if(conf == 4 && hvac > 0) showHVAC();
					if(conf == 5 && blind > 0) showBlind();
					if(conf == 6 && room > 0) showRoom();
				}
			}
		}
		else if(e.getSource() == cb_num) {
			num = cb_num.getSelectedIndex();
			System.out.println("Number " + num);
		}
		else if(e.getSource() == cb_sys) {
			sys = cb_sys.getSelectedIndex();
			System.out.println("System " + sys);
		}
		else if(e.getSource() == cb_conf) {
			conf = cb_conf.getSelectedIndex();
			System.out.println("Configuration " + conf);
		}
		else if(e.getSource() == cb_dshb) {
			dash = cb_dshb.getSelectedIndex();
			System.out.println("Dashboard " + dash);
		}
		else if(e.getSource() == cb_lght) {
			light = cb_lght.getSelectedIndex();
			System.out.println("Light " + light);
		}
		else if(e.getSource() == cb_hvac) {
			hvac = cb_hvac.getSelectedIndex();
			System.out.println("HVAC " + hvac);
		}
		else if(e.getSource() == cb_blnd) {
			blind = cb_blnd.getSelectedIndex();
			System.out.println("Blind " + blind);
		}
		else if(e.getSource() == cb_room) {
			room = cb_room.getSelectedIndex();
			System.out.println("Room " + room);
		}
		
		
		show.setEnabled(false);

		cb_conf.setVisible(false);
		cb_dshb.setVisible(false);
		cb_lght.setVisible(false);
		cb_hvac.setVisible(false);
		cb_blnd.setVisible(false);
		cb_room.setVisible(false);
		l_conf.setVisible(false);
		l_dshb.setVisible(false);
		l_lght.setVisible(false);
		l_hvac.setVisible(false);
		l_blnd.setVisible(false);
		l_room.setVisible(false);
		
		if(num > 0) {
			if(sys == 1) show.setEnabled(true);
			else if(sys == 2) {
				cb_conf.setVisible(true);
				l_conf.setVisible(true);
				if(conf == 1) show.setEnabled(true);
				else if (conf == 2) {
					cb_dshb.setVisible(true);
					l_dshb.setVisible(true);
					if(dash > 0) show.setEnabled(true);
				}
				else if (conf == 3) {
					lightSync();
					
					cb_lght.setVisible(true);
					l_lght.setVisible(true);
					if(light > 0) show.setEnabled(true);
				}
				else if (conf == 4) {
					cb_hvac.setVisible(true);
					l_hvac.setVisible(true);
					if(hvac > 0) show.setEnabled(true);
				}
				else if (conf == 5) {
					blindSync();
					
					cb_blnd.setVisible(true);
					l_blnd.setVisible(true);
					if(blind > 0) show.setEnabled(true);
				}
				else if (conf == 6) {
					cb_room.setVisible(true);
					l_room.setVisible(true);			
					if(room > 0) show.setEnabled(true);
				}
			}
		}
	}

	private void saveVariables() {
		save.setEnabled(false);
		
		if(sys == 1) {
			json.system.get(num-1).iD = t_id.getText();
			json.system.get(num-1).type = t_type.getText();
			json.system.get(num-1).locationID = t_locationId.getText();
		}
		else if(sys > 1) {
			if(conf == 1) {
				json.system.get(num-1).configuration.general.room = t_room.getText();
				json.system.get(num-1).configuration.general.logo = t_logo.getText();
				json.system.get(num-1).configuration.general.background = t_background.getText();
				json.system.get(num-1).configuration.general.colorTheme = t_colorTheme.getText();
				json.system.get(num-1).configuration.general.title = t_title.getText();
				json.system.get(num-1).configuration.general.comm = t_comm.getText();
				json.system.get(num-1).configuration.general.lang = t_lang.getText();
				json.system.get(num-1).configuration.general.showLights = (t_showLights.getText().contentEquals("true")) ? true : false;
				json.system.get(num-1).configuration.general.showHvac = (t_showHvac.getText().contentEquals("true")) ? true : false;
				json.system.get(num-1).configuration.general.showBlinds = (t_showBlinds.getText().contentEquals("true")) ? true : false;
				json.system.get(num-1).configuration.general.showRoom = (t_showRoom.getText().contentEquals("true")) ? true : false;
				json.system.get(num-1).configuration.general.showDashboard = (t_showDashboard.getText().contentEquals("true")) ? true : false;
				json.system.get(num-1).configuration.general.devMode = (t_devMode.getText().contentEquals("true")) ? true : false;
				json.system.get(num-1).configuration.general.lockMobileInPortrait = (t_lockMobileInPortrait.getText().contentEquals("true")) ? true : false;
				json.system.get(num-1).configuration.general.lockTabletInLandscape = (t_lockTabletInLandscape.getText().contentEquals("true")) ? true : false;
				
			}
			else if (conf == 2) {
				switch (dash) {
					case 1:
						json.system.get(num-1).configuration.dashboard.cell1.type = t_type.getText();
						json.system.get(num-1).configuration.dashboard.cell1.data = t_data.getText();
						json.system.get(num-1).configuration.dashboard.cell1.title = (t_title.getText() == null) ? null : "";
						break;
					case 2:
						json.system.get(num-1).configuration.dashboard.cell2.type = t_type.getText();
						json.system.get(num-1).configuration.dashboard.cell2.data = t_data.getText();
						json.system.get(num-1).configuration.dashboard.cell2.title = (t_title.getText() == null) ? null : "";
						break;
					case 3:
						json.system.get(num-1).configuration.dashboard.cell3.type = t_type.getText();
						json.system.get(num-1).configuration.dashboard.cell3.data = t_data.getText();
						json.system.get(num-1).configuration.dashboard.cell3.title = (t_title.getText() == null) ? null : "";
						break;
					case 4:
						json.system.get(num-1).configuration.dashboard.cell4.type = t_type.getText();
						json.system.get(num-1).configuration.dashboard.cell4.data = t_data.getText();
						json.system.get(num-1).configuration.dashboard.cell4.title = (t_title.getText() == null) ? null : "";
						break;
					case 5:
						json.system.get(num-1).configuration.dashboard.cell5.type = t_type.getText();
						json.system.get(num-1).configuration.dashboard.cell5.data = t_data.getText();
						json.system.get(num-1).configuration.dashboard.cell5.title = (t_title.getText() == null) ? null : "";
						break;
					case 6:
						json.system.get(num-1).configuration.dashboard.cell6.type = t_type.getText();
						json.system.get(num-1).configuration.dashboard.cell6.data = t_data.getText();
						json.system.get(num-1).configuration.dashboard.cell6.title = (t_title.getText() == null) ? null : "";
						break;
				}
			}
			else if (conf == 3) {
				json.system.get(num-1).configuration.light.get(light-1).ID = Integer.parseInt(t_id.getText());
				json.system.get(num-1).configuration.light.get(light-1).show = t_show.getText().contains("true") ? true : false;
				json.system.get(num-1).configuration.light.get(light-1).text = t_text.getText();
				json.system.get(num-1).configuration.light.get(light-1).iconOn = t_iconOn.getText();
				json.system.get(num-1).configuration.light.get(light-1).iconOff = t_iconOff.getText();
				json.system.get(num-1).configuration.light.get(light-1).dimmable = t_dimmable.getText().contains("true") ? true : false;
				json.system.get(num-1).configuration.light.get(light-1).control = t_control.getText();
				json.system.get(num-1).configuration.light.get(light-1).status = t_status.getText();
			}
			else if (conf == 4) {
				switch (hvac) {
					case 1:
						json.system.get(num-1).configuration.hvac.tempSet.show = t_show.getText().contains("true") ? true : false;
						json.system.get(num-1).configuration.hvac.tempSet.control = t_control.getText();
						json.system.get(num-1).configuration.hvac.tempSet.unit = t_unit.getText();
						json.system.get(num-1).configuration.hvac.tempSet.iconOn = t_iconOn.getText();
						json.system.get(num-1).configuration.hvac.tempSet.iconOff = t_iconOff.getText();
						json.system.get(num-1).configuration.hvac.tempSet.text = t_text.getText();
						json.system.get(num-1).configuration.hvac.tempSet.status = t_status.getText();
						break;
					case 2:
						json.system.get(num-1).configuration.hvac.tempSetPlus.show = t_show.getText().contains("true") ? true : false;
						json.system.get(num-1).configuration.hvac.tempSetPlus.control = t_control.getText();
						json.system.get(num-1).configuration.hvac.tempSetPlus.iconOn = t_iconOn.getText();
						json.system.get(num-1).configuration.hvac.tempSetPlus.iconOff = t_iconOff.getText();
						json.system.get(num-1).configuration.hvac.tempSetPlus.text = t_text.getText();
						json.system.get(num-1).configuration.hvac.tempSetPlus.status = t_status.getText();
						break;
					case 3:
						json.system.get(num-1).configuration.hvac.tempSetMinus.show = t_show.getText().contains("true") ? true : false;
						json.system.get(num-1).configuration.hvac.tempSetMinus.control = t_control.getText();
						json.system.get(num-1).configuration.hvac.tempSetMinus.iconOn = t_iconOn.getText();
						json.system.get(num-1).configuration.hvac.tempSetMinus.iconOff = t_iconOff.getText();
						json.system.get(num-1).configuration.hvac.tempSetMinus.text = t_text.getText();
						json.system.get(num-1).configuration.hvac.tempSetMinus.status = t_status.getText();
						break;
					case 4:
						json.system.get(num-1).configuration.hvac.tempMeas.show = t_show.getText().contains("true") ? true : false;
						json.system.get(num-1).configuration.hvac.tempMeas.control = t_control.getText();
						json.system.get(num-1).configuration.hvac.tempMeas.text = t_text.getText();
						json.system.get(num-1).configuration.hvac.tempMeas.status = t_status.getText();
						break;
					case 5:
						json.system.get(num-1).configuration.hvac.controlOff.show = t_show.getText().contains("true") ? true : false;
						json.system.get(num-1).configuration.hvac.controlOff.control = t_control.getText();
						json.system.get(num-1).configuration.hvac.controlOff.iconOn = t_iconOn.getText();
						json.system.get(num-1).configuration.hvac.controlOff.iconOff = t_iconOff.getText();
						json.system.get(num-1).configuration.hvac.controlOff.text = t_text.getText();
						json.system.get(num-1).configuration.hvac.controlOff.status = t_status.getText();
						break;
					case 6:
						json.system.get(num-1).configuration.hvac.controlLow.show = t_show.getText().contains("true") ? true : false;
						json.system.get(num-1).configuration.hvac.controlLow.control = t_control.getText();
						json.system.get(num-1).configuration.hvac.controlLow.iconOn = t_iconOn.getText();
						json.system.get(num-1).configuration.hvac.controlLow.iconOff = t_iconOff.getText();
						json.system.get(num-1).configuration.hvac.controlLow.text = t_text.getText();
						json.system.get(num-1).configuration.hvac.controlLow.status = t_status.getText();
						break;
					case 7:
						json.system.get(num-1).configuration.hvac.controlMid.show = t_show.getText().contains("true") ? true : false;
						json.system.get(num-1).configuration.hvac.controlMid.control = t_control.getText();
						json.system.get(num-1).configuration.hvac.controlMid.iconOn = t_iconOn.getText();
						json.system.get(num-1).configuration.hvac.controlMid.iconOff = t_iconOff.getText();
						json.system.get(num-1).configuration.hvac.controlMid.text = t_text.getText();
						json.system.get(num-1).configuration.hvac.controlMid.status = t_status.getText();
						break;
					case 8:
						json.system.get(num-1).configuration.hvac.controlHigh.show = t_show.getText().contains("true") ? true : false;
						json.system.get(num-1).configuration.hvac.controlHigh.control = t_control.getText();
						json.system.get(num-1).configuration.hvac.controlHigh.iconOn = t_iconOn.getText();
						json.system.get(num-1).configuration.hvac.controlHigh.iconOff = t_iconOff.getText();
						json.system.get(num-1).configuration.hvac.controlHigh.text = t_text.getText();
						json.system.get(num-1).configuration.hvac.controlHigh.status = t_status.getText();
						break;
					case 9:
						json.system.get(num-1).configuration.hvac.controlAuto.show = t_show.getText().contains("true") ? true : false;
						json.system.get(num-1).configuration.hvac.controlAuto.control = t_control.getText();
						json.system.get(num-1).configuration.hvac.controlAuto.iconOn = t_iconOn.getText();
						json.system.get(num-1).configuration.hvac.controlAuto.iconOff = t_iconOff.getText();
						json.system.get(num-1).configuration.hvac.controlAuto.text = t_text.getText();
						json.system.get(num-1).configuration.hvac.controlAuto.status = t_status.getText();
						break;
				}
			}
			else if (conf == 5) {
				json.system.get(num-1).configuration.blinds.get(blind-1).ID = t_id.getText();
				json.system.get(num-1).configuration.blinds.get(blind-1).name = t_name.getText();
				json.system.get(num-1).configuration.blinds.get(blind-1).show = t_show.getText().contains("true") ? true : false;
				json.system.get(num-1).configuration.blinds.get(blind-1).direction1.show = t_show2.getText().contains("true") ? true : false;
				json.system.get(num-1).configuration.blinds.get(blind-1).direction1.text = t_text.getText();
				json.system.get(num-1).configuration.blinds.get(blind-1).direction1.iconOn = t_iconOn.getText();
				json.system.get(num-1).configuration.blinds.get(blind-1).direction1.iconOff = t_iconOff.getText();
				json.system.get(num-1).configuration.blinds.get(blind-1).direction1.control = t_control.getText();
				json.system.get(num-1).configuration.blinds.get(blind-1).direction1.status = t_status.getText();
				json.system.get(num-1).configuration.blinds.get(blind-1).direction2.show = t_show3.getText().contains("true") ? true : false;
				json.system.get(num-1).configuration.blinds.get(blind-1).direction2.text = t_text2.getText();
				json.system.get(num-1).configuration.blinds.get(blind-1).direction2.iconOn = t_iconOn2.getText();
				json.system.get(num-1).configuration.blinds.get(blind-1).direction2.iconOff = t_iconOff2.getText();
				json.system.get(num-1).configuration.blinds.get(blind-1).direction2.control = t_control2.getText();
				json.system.get(num-1).configuration.blinds.get(blind-1).direction2.status = t_status2.getText();
			}
			else if (conf == 6) {
				switch (room) {
					case 1:
						json.system.get(num-1).configuration.room.validFrom = t_validFrom.getText();
						json.system.get(num-1).configuration.room.validTo = t_validTo.getText();
						break;
					case 2:
						json.system.get(num-1).configuration.room.digitalKey.ID = t_id.getText();
						json.system.get(num-1).configuration.room.digitalKey.show = t_show.getText().contains("true") ? true : false;
						json.system.get(num-1).configuration.room.digitalKey.text = t_text.getText();
						json.system.get(num-1).configuration.room.digitalKey.iconOn = t_iconOn.getText();
						json.system.get(num-1).configuration.room.digitalKey.iconOff = t_iconOff.getText();
						json.system.get(num-1).configuration.room.digitalKey.control = t_control.getText();
						json.system.get(num-1).configuration.room.digitalKey.status = t_status.getText();
						break;
					case 3:
						json.system.get(num-1).configuration.room.dnd.ID = t_id.getText();
						json.system.get(num-1).configuration.room.dnd.show = t_show.getText().contains("true") ? true : false;
						json.system.get(num-1).configuration.room.dnd.text = t_text.getText();
						json.system.get(num-1).configuration.room.dnd.iconOn = t_iconOn.getText();
						json.system.get(num-1).configuration.room.dnd.iconOff = t_iconOff.getText();
						json.system.get(num-1).configuration.room.dnd.control = t_control.getText();
						json.system.get(num-1).configuration.room.dnd.status = t_status.getText();
						break;
					case 4:
						json.system.get(num-1).configuration.room.sos.ID = t_id.getText();
						json.system.get(num-1).configuration.room.sos.show = t_show.getText().contains("true") ? true : false;
						json.system.get(num-1).configuration.room.sos.text = t_text.getText();
						json.system.get(num-1).configuration.room.sos.iconOn = t_iconOn.getText();
						json.system.get(num-1).configuration.room.sos.iconOff = t_iconOff.getText();
						json.system.get(num-1).configuration.room.sos.control = t_control.getText();
						json.system.get(num-1).configuration.room.sos.status = t_status.getText();
						break;
					case 5:
						json.system.get(num-1).configuration.room.mur.ID = t_id.getText();
						json.system.get(num-1).configuration.room.mur.show = t_show.getText().contains("true") ? true : false;
						json.system.get(num-1).configuration.room.mur.text = t_text.getText();
						json.system.get(num-1).configuration.room.mur.iconOn = t_iconOn.getText();
						json.system.get(num-1).configuration.room.mur.iconOff = t_iconOff.getText();
						json.system.get(num-1).configuration.room.mur.control = t_control.getText();
						json.system.get(num-1).configuration.room.mur.status = t_status.getText();
						break;
					case 6:
						json.system.get(num-1).configuration.room.wakeup.ID = t_id.getText();
						json.system.get(num-1).configuration.room.wakeup.show = t_show.getText().contains("true") ? true : false;
						json.system.get(num-1).configuration.room.wakeup.text = t_text.getText();
						json.system.get(num-1).configuration.room.wakeup.iconOn = t_iconOn.getText();
						json.system.get(num-1).configuration.room.wakeup.iconOff = t_iconOff.getText();
						json.system.get(num-1).configuration.room.wakeup.control = t_control.getText();
						json.system.get(num-1).configuration.room.wakeup.status = t_status.getText();
						break;
				}
			}
		}
	}
	

	private void showRoom() {
		System.out.println("Show Room");
		
		if(room == 1) {
			v_validFrom.setBounds(label_start2, 30, label_len, 30);
			v_validTo.setBounds(label_start2, 65, label_len, 30);
			
			v_validFrom.setVisible(true);
			v_validTo.setVisible(true);
			
			t_validFrom.setBounds(tf_start, 30, tf_len, 30);
			t_validTo.setBounds(tf_start, 65, tf_len, 30);
			
			t_validFrom.setText(json.system.get(num - 1).configuration.room.validFrom);
			t_validTo.setText(json.system.get(num - 1).configuration.room.validTo);
			
			t_validFrom.setVisible(true);
			t_validTo.setVisible(true);
		}
		else if (room > 1) {
			v_id.setBounds(label_start2, 30, label_len, 30);
			v_show.setBounds(label_start2, 65, label_len, 30);
			v_text.setBounds(label_start2, 100, label_len, 30);
			v_iconOn.setBounds(label_start2, 135, label_len, 30);
			v_iconOff.setBounds(label_start2, 170, label_len, 30);
			v_control.setBounds(label_start2, 205, label_len, 30);
			v_status.setBounds(label_start2, 240, label_len, 30);
			
			v_id.setVisible(true);
			v_show.setVisible(true);
			v_text.setVisible(true);
			v_iconOn.setVisible(true);
			v_iconOff.setVisible(true);
			v_control.setVisible(true);
			v_status.setVisible(true);
			
			t_id.setBounds(tf_start, 30, tf_len, 30);
			t_show.setBounds(tf_start, 65, tf_len, 30);
			t_text.setBounds(tf_start, 100, tf_len, 30);
			t_iconOn.setBounds(tf_start, 135, tf_len, 30);
			t_iconOff.setBounds(tf_start, 170, tf_len, 30);
			t_control.setBounds(tf_start, 205, tf_len, 30);
			t_status.setBounds(tf_start, 240, tf_len, 30);
			
			switch(room) {
				case 2:
					t_id.setText(json.system.get(num - 1).configuration.room.digitalKey.ID);
					t_show.setText(json.system.get(num - 1).configuration.room.digitalKey.show.toString());
					t_text.setText(json.system.get(num - 1).configuration.room.digitalKey.text);
					t_iconOn.setText(json.system.get(num - 1).configuration.room.digitalKey.iconOn);
					t_iconOff.setText(json.system.get(num - 1).configuration.room.digitalKey.iconOff);
					t_control.setText(json.system.get(num - 1).configuration.room.digitalKey.control);
					t_status.setText(json.system.get(num - 1).configuration.room.digitalKey.status);
					break;
				case 3:
					t_id.setText(json.system.get(num - 1).configuration.room.dnd.ID);
					t_show.setText(json.system.get(num - 1).configuration.room.dnd.show.toString());
					t_text.setText(json.system.get(num - 1).configuration.room.dnd.text);
					t_iconOn.setText(json.system.get(num - 1).configuration.room.dnd.iconOn);
					t_iconOff.setText(json.system.get(num - 1).configuration.room.dnd.iconOff);
					t_control.setText(json.system.get(num - 1).configuration.room.dnd.control);
					t_status.setText(json.system.get(num - 1).configuration.room.dnd.status);
					break;
				case 4:
					t_id.setText(json.system.get(num - 1).configuration.room.sos.ID);
					t_show.setText(json.system.get(num - 1).configuration.room.sos.show.toString());
					t_text.setText(json.system.get(num - 1).configuration.room.sos.text);
					t_iconOn.setText(json.system.get(num - 1).configuration.room.sos.iconOn);
					t_iconOff.setText(json.system.get(num - 1).configuration.room.sos.iconOff);
					t_control.setText(json.system.get(num - 1).configuration.room.sos.control);
					t_status.setText(json.system.get(num - 1).configuration.room.sos.status);
					break;
				case 5:
					t_id.setText(json.system.get(num - 1).configuration.room.mur.ID);
					t_show.setText(json.system.get(num - 1).configuration.room.mur.show.toString());
					t_text.setText(json.system.get(num - 1).configuration.room.mur.text);
					t_iconOn.setText(json.system.get(num - 1).configuration.room.mur.iconOn);
					t_iconOff.setText(json.system.get(num - 1).configuration.room.mur.iconOff);
					t_control.setText(json.system.get(num - 1).configuration.room.mur.control);
					t_status.setText(json.system.get(num - 1).configuration.room.mur.status);
					break;
				case 6:
					t_id.setText(json.system.get(num - 1).configuration.room.wakeup.ID);
					t_show.setText(json.system.get(num - 1).configuration.room.wakeup.show.toString());
					t_text.setText(json.system.get(num - 1).configuration.room.wakeup.text);
					t_iconOn.setText(json.system.get(num - 1).configuration.room.wakeup.iconOn);
					t_iconOff.setText(json.system.get(num - 1).configuration.room.wakeup.iconOff);
					t_control.setText(json.system.get(num - 1).configuration.room.wakeup.control);
					t_status.setText(json.system.get(num - 1).configuration.room.wakeup.status);
					break;
				default:
					System.err.println("error while showing room variables");
					break;
			}
			
			t_id.setVisible(true);
			t_show.setVisible(true);
			t_text.setVisible(true);
			t_iconOn.setVisible(true);
			t_iconOff.setVisible(true);
			t_control.setVisible(true);
			t_status.setVisible(true);
			
		}
		else System.err.println("error while showing room variables");
	}
	
	private void showBlind() {
		System.out.println("Show Blind");
		v_id.setBounds(label_start2, 30, label_len, 30);
		v_name.setBounds(label_start2, 65, label_len, 30);
		v_show.setBounds(label_start2, 100, label_len, 30);
		dir1.setBounds(label_start2 + 40, 135, label_len, 30);
		v_show2.setBounds(label_start2, 170, label_len, 30);
		v_text.setBounds(label_start2, 205, label_len, 30);
		v_iconOn.setBounds(label_start2, 240, label_len, 30);
		v_iconOff.setBounds(label_start2, 275, label_len, 30);
		v_control.setBounds(label_start2, 310, label_len, 30);
		v_status.setBounds(label_start2, 345, label_len, 30);
		dir2.setBounds(label_start2 + 40, 380, label_len, 30);
		v_show3.setBounds(label_start2, 415, label_len, 30);
		v_text2.setBounds(label_start2, 450, label_len, 30);
		v_iconOn2.setBounds(label_start2, 485, label_len, 30);
		v_iconOff2.setBounds(label_start2, 520, label_len, 30);
		v_control2.setBounds(label_start2, 555, label_len, 30);
		v_status2.setBounds(label_start2, 590, label_len, 30);
		
		v_id.setVisible(true);
		v_name.setVisible(true);
		v_show.setVisible(true);
		dir1.setVisible(true);
		v_show2.setVisible(true);
		v_text.setVisible(true);
		v_iconOn.setVisible(true);
		v_iconOff.setVisible(true);
		v_control.setVisible(true);
		v_status.setVisible(true);
		dir2.setVisible(true);
		v_show3.setVisible(true);
		v_text2.setVisible(true);
		v_iconOn2.setVisible(true);
		v_iconOff2.setVisible(true);
		v_control2.setVisible(true);
		v_status2.setVisible(true);

		t_id.setBounds(tf_start, 30, tf_len, 30);
		t_name.setBounds(tf_start, 65, tf_len, 30);
		t_show.setBounds(tf_start, 100, tf_len, 30);
		t_show2.setBounds(tf_start, 170, tf_len, 30);
		t_text.setBounds(tf_start, 205, tf_len, 30);
		t_iconOn.setBounds(tf_start, 240, tf_len, 30);
		t_iconOff.setBounds(tf_start, 275, tf_len, 30);
		t_control.setBounds(tf_start, 310, tf_len, 30);
		t_status.setBounds(tf_start, 345, tf_len, 30);
		t_show3.setBounds(tf_start, 415, tf_len, 30);
		t_text2.setBounds(tf_start, 450, tf_len, 30);
		t_iconOn2.setBounds(tf_start, 485, tf_len, 30);
		t_iconOff2.setBounds(tf_start, 520, tf_len, 30);
		t_control2.setBounds(tf_start, 555, tf_len, 30);
		t_status2.setBounds(tf_start, 590, tf_len, 30);
		
		t_id.setText(json.system.get(num - 1).configuration.blinds.get(blind - 1).ID);
		t_name.setText(json.system.get(num - 1).configuration.blinds.get(blind - 1).name);
		t_show.setText(json.system.get(num - 1).configuration.blinds.get(blind - 1).show.toString());
		t_show2.setText(json.system.get(num - 1).configuration.blinds.get(blind - 1).direction1.show.toString());
		t_text.setText(json.system.get(num - 1).configuration.blinds.get(blind - 1).direction1.text);
		t_iconOn.setText(json.system.get(num - 1).configuration.blinds.get(blind - 1).direction1.iconOn);
		t_iconOff.setText(json.system.get(num - 1).configuration.blinds.get(blind - 1).direction1.iconOff);
		t_control.setText(json.system.get(num - 1).configuration.blinds.get(blind - 1).direction1.control);
		t_status.setText(json.system.get(num - 1).configuration.blinds.get(blind - 1).direction1.status);
		t_show3.setText(json.system.get(num - 1).configuration.blinds.get(blind - 1).direction2.show.toString());
		t_text2.setText(json.system.get(num - 1).configuration.blinds.get(blind - 1).direction2.text);
		t_iconOn2.setText(json.system.get(num - 1).configuration.blinds.get(blind - 1).direction2.iconOn);
		t_iconOff2.setText(json.system.get(num - 1).configuration.blinds.get(blind - 1).direction2.iconOff);
		t_control2.setText(json.system.get(num - 1).configuration.blinds.get(blind - 1).direction2.control);
		t_status2.setText(json.system.get(num - 1).configuration.blinds.get(blind - 1).direction2.status);
		
		t_id.setVisible(true);
		t_name.setVisible(true);
		t_show.setVisible(true);
		t_show2.setVisible(true);
		t_text.setVisible(true);
		t_iconOn.setVisible(true);
		t_iconOff.setVisible(true);
		t_control.setVisible(true);
		t_status.setVisible(true);
		t_show3.setVisible(true);
		t_text2.setVisible(true);
		t_iconOn2.setVisible(true);
		t_iconOff2.setVisible(true);
		t_control2.setVisible(true);
		t_status2.setVisible(true);
	}
	
	private void showHVAC() {
		System.out.println("Show Hvac");
		
		if(hvac == 1) {
			v_show.setBounds(label_start2, 30, label_len, 30);
			v_control.setBounds(label_start2, 65, label_len, 30);
			v_unit.setBounds(label_start2, 100, label_len, 30);
			v_iconOn.setBounds(label_start2, 135, label_len, 30);
			v_iconOff.setBounds(label_start2, 170, label_len, 30);
			v_text.setBounds(label_start2, 205, label_len, 30);
			v_status.setBounds(label_start2, 240, label_len, 30);
			
			v_show.setVisible(true);
			v_control.setVisible(true);
			v_unit.setVisible(true);
			v_iconOn.setVisible(true);
			v_iconOff.setVisible(true);
			v_text.setVisible(true);
			v_status.setVisible(true);
			
			t_show.setBounds(tf_start, 30, tf_len, 30);
			t_control.setBounds(tf_start, 65, tf_len, 30);
			t_unit.setBounds(tf_start, 100, tf_len, 30);
			t_iconOn.setBounds(tf_start, 135, tf_len, 30);
			t_iconOff.setBounds(tf_start, 170, tf_len, 30);
			t_text.setBounds(tf_start, 205, tf_len, 30);
			t_status.setBounds(tf_start, 240, tf_len, 30);
			
			t_show.setText(json.system.get(num - 1).configuration.hvac.tempSet.show.toString());
			t_control.setText(json.system.get(num - 1).configuration.hvac.tempSet.control);
			t_unit.setText(json.system.get(num - 1).configuration.hvac.tempSet.unit);
			t_iconOn.setText(json.system.get(num - 1).configuration.hvac.tempSet.iconOn);
			t_iconOff.setText(json.system.get(num - 1).configuration.hvac.tempSet.iconOff);
			t_text.setText(json.system.get(num - 1).configuration.hvac.tempSet.text);
			t_status.setText(json.system.get(num - 1).configuration.hvac.tempSet.status);
			
			t_show.setVisible(true);
			t_control.setVisible(true);
			t_unit.setVisible(true);
			t_iconOn.setVisible(true);
			t_iconOff.setVisible(true);
			t_text.setVisible(true);
			t_status.setVisible(true);
		}
		else if (hvac > 1 && hvac != 4) {
			v_show.setBounds(label_start2, 30, label_len, 30);
			v_control.setBounds(label_start2, 65, label_len, 30);
			v_iconOn.setBounds(label_start2, 100, label_len, 30);
			v_iconOff.setBounds(label_start2, 135, label_len, 30);
			v_text.setBounds(label_start2, 170, label_len, 30);
			v_status.setBounds(label_start2, 205, label_len, 30);
			
			v_show.setVisible(true);
			v_control.setVisible(true);
			v_iconOn.setVisible(true);
			v_iconOff.setVisible(true);
			v_text.setVisible(true);
			v_status.setVisible(true);
			
			t_show.setBounds(tf_start, 30, tf_len, 30);
			t_control.setBounds(tf_start, 65, tf_len, 30);
			t_iconOn.setBounds(tf_start, 100, tf_len, 30);
			t_iconOff.setBounds(tf_start, 135, tf_len, 30);
			t_text.setBounds(tf_start, 170, tf_len, 30);
			t_status.setBounds(tf_start, 205, tf_len, 30);
			
			if (hvac == 2) {
				t_show.setText(json.system.get(num - 1).configuration.hvac.tempSetPlus.show.toString());
				t_control.setText(json.system.get(num - 1).configuration.hvac.tempSetPlus.control);
				t_iconOn.setText(json.system.get(num - 1).configuration.hvac.tempSetPlus.iconOn);
				t_iconOff.setText(json.system.get(num - 1).configuration.hvac.tempSetPlus.iconOff);
				t_text.setText(json.system.get(num - 1).configuration.hvac.tempSetPlus.text);
				t_status.setText(json.system.get(num - 1).configuration.hvac.tempSetPlus.status);
			}
			else if (hvac == 3) {
				t_show.setText(json.system.get(num - 1).configuration.hvac.tempSetMinus.show.toString());
				t_control.setText(json.system.get(num - 1).configuration.hvac.tempSetMinus.control);
				t_iconOn.setText(json.system.get(num - 1).configuration.hvac.tempSetMinus.iconOn);
				t_iconOff.setText(json.system.get(num - 1).configuration.hvac.tempSetMinus.iconOff);
				t_text.setText(json.system.get(num - 1).configuration.hvac.tempSetMinus.text);
				t_status.setText(json.system.get(num - 1).configuration.hvac.tempSetMinus.status);
			}
			else if (hvac == 5) {
				t_show.setText(json.system.get(num - 1).configuration.hvac.controlOff.show.toString());
				t_control.setText(json.system.get(num - 1).configuration.hvac.controlOff.control);
				t_iconOn.setText(json.system.get(num - 1).configuration.hvac.controlOff.iconOn);
				t_iconOff.setText(json.system.get(num - 1).configuration.hvac.controlOff.iconOff);
				t_text.setText(json.system.get(num - 1).configuration.hvac.controlOff.text);
				t_status.setText(json.system.get(num - 1).configuration.hvac.controlOff.status);
			}
			else if (hvac == 6) {
				t_show.setText(json.system.get(num - 1).configuration.hvac.controlLow.show.toString());
				t_control.setText(json.system.get(num - 1).configuration.hvac.controlLow.control);
				t_iconOn.setText(json.system.get(num - 1).configuration.hvac.controlLow.iconOn);
				t_iconOff.setText(json.system.get(num - 1).configuration.hvac.controlLow.iconOff);
				t_text.setText(json.system.get(num - 1).configuration.hvac.controlLow.text);
				t_status.setText(json.system.get(num - 1).configuration.hvac.controlLow.status);
			}
			else if (hvac == 7) {
				t_show.setText(json.system.get(num - 1).configuration.hvac.controlMid.show.toString());
				t_control.setText(json.system.get(num - 1).configuration.hvac.controlMid.control);
				t_iconOn.setText(json.system.get(num - 1).configuration.hvac.controlMid.iconOn);
				t_iconOff.setText(json.system.get(num - 1).configuration.hvac.controlMid.iconOff);
				t_text.setText(json.system.get(num - 1).configuration.hvac.controlMid.text);
				t_status.setText(json.system.get(num - 1).configuration.hvac.controlMid.status);
			}
			else if (hvac == 8) {
				t_show.setText(json.system.get(num - 1).configuration.hvac.controlHigh.show.toString());
				t_control.setText(json.system.get(num - 1).configuration.hvac.controlHigh.control);
				t_iconOn.setText(json.system.get(num - 1).configuration.hvac.controlHigh.iconOn);
				t_iconOff.setText(json.system.get(num - 1).configuration.hvac.controlHigh.iconOff);
				t_text.setText(json.system.get(num - 1).configuration.hvac.controlHigh.text);
				t_status.setText(json.system.get(num - 1).configuration.hvac.controlHigh.status);
			}
			else if (hvac == 9) {
				t_show.setText(json.system.get(num - 1).configuration.hvac.controlAuto.show.toString());
				t_control.setText(json.system.get(num - 1).configuration.hvac.controlAuto.control);
				t_iconOn.setText(json.system.get(num - 1).configuration.hvac.controlAuto.iconOn);
				t_iconOff.setText(json.system.get(num - 1).configuration.hvac.controlAuto.iconOff);
				t_text.setText(json.system.get(num - 1).configuration.hvac.controlAuto.text);
				t_status.setText(json.system.get(num - 1).configuration.hvac.controlAuto.status);
			}
			
			t_show.setVisible(true);
			t_control.setVisible(true);
			t_iconOn.setVisible(true);
			t_iconOff.setVisible(true);
			t_text.setVisible(true);
			t_status.setVisible(true);
		}
		else if (hvac == 4) {
			v_show.setBounds(label_start2, 30, label_len, 30);
			v_control.setBounds(label_start2, 65, label_len, 30);
			v_text.setBounds(label_start2, 100, label_len, 30);
			v_status.setBounds(label_start2, 135, label_len, 30);
			
			v_show.setVisible(true);
			v_control.setVisible(true);
			v_text.setVisible(true);
			v_status.setVisible(true);
			
			t_show.setBounds(tf_start, 30, tf_len, 30);
			t_control.setBounds(tf_start, 65, tf_len, 30);
			t_text.setBounds(tf_start, 100, tf_len, 30);
			t_status.setBounds(tf_start, 135, tf_len, 30);
			
			t_show.setText(json.system.get(num - 1).configuration.hvac.tempSet.show.toString());
			t_control.setText(json.system.get(num - 1).configuration.hvac.tempSet.control);
			t_text.setText(json.system.get(num - 1).configuration.hvac.tempSet.text);
			t_status.setText(json.system.get(num - 1).configuration.hvac.tempSet.status);
			
			t_show.setVisible(true);
			t_control.setVisible(true);
			t_text.setVisible(true);
			t_status.setVisible(true);
		}
		else System.err.println("error while showing room variables");
		
	}

	private void showLight() {
		System.out.println("Show Light");
		
		v_id.setBounds(label_start2, 30, label_len, 30);
		v_show.setBounds(label_start2, 65, label_len, 30);
		v_text.setBounds(label_start2, 100, label_len, 30);
		v_iconOn.setBounds(label_start2, 135, label_len, 30);
		v_iconOff.setBounds(label_start2, 170, label_len, 30);
		v_dimmable.setBounds(label_start2, 205, label_len, 30);
		v_control.setBounds(label_start2, 240, label_len, 30);
		v_status.setBounds(label_start2, 275, label_len, 30);
		
		v_id.setVisible(true);
		v_show.setVisible(true);
		v_text.setVisible(true);
		v_iconOn.setVisible(true);
		v_iconOff.setVisible(true);
		v_dimmable.setVisible(true);
		v_control.setVisible(true);
		v_status.setVisible(true);
		
		t_id.setBounds(tf_start, 30, tf_len, 30);
		t_show.setBounds(tf_start, 65, tf_len, 30);
		t_text.setBounds(tf_start, 100, tf_len, 30);
		t_iconOn.setBounds(tf_start, 135, tf_len, 30);
		t_iconOff.setBounds(tf_start, 170, tf_len, 30);
		t_dimmable.setBounds(tf_start, 205, tf_len, 30);
		t_control.setBounds(tf_start, 240, tf_len, 30);
		t_status.setBounds(tf_start, 275, tf_len, 30);
		
		t_id.setText(json.system.get(num - 1).configuration.light.get(light - 1).ID.toString());
		t_show.setText(json.system.get(num - 1).configuration.light.get(light - 1).show.toString());
		t_text.setText(json.system.get(num - 1).configuration.light.get(light - 1).text);
		t_iconOn.setText(json.system.get(num - 1).configuration.light.get(light - 1).iconOn);
		t_iconOff.setText(json.system.get(num - 1).configuration.light.get(light - 1).iconOff);
		t_dimmable.setText(json.system.get(num - 1).configuration.light.get(light - 1).dimmable.toString());
		t_control.setText(json.system.get(num - 1).configuration.light.get(light - 1).control);
		t_status.setText(json.system.get(num - 1).configuration.light.get(light - 1).status);
		
		t_id.setVisible(true);
		t_show.setVisible(true);
		t_text.setVisible(true);
		t_iconOn.setVisible(true);
		t_iconOff.setVisible(true);
		t_dimmable.setVisible(true);
		t_control.setVisible(true);
		t_status.setVisible(true);
		
	}

	private void showDashboard() {
		System.out.println("Show Dashboard");
		
		v_type.setBounds(label_start2, 30, label_len, 30);
		v_data.setBounds(label_start2, 65, label_len, 30);
		v_title.setBounds(label_start2, 100, label_len, 30);
		
		v_type.setVisible(true);
		v_data.setVisible(true);
		v_title.setVisible(true);
		
		t_type.setBounds(tf_start, 30, tf_len, 30);
		t_data.setBounds(tf_start, 65, tf_len, 30);
		t_title.setBounds(tf_start, 100, tf_len, 30);
		
		switch (dash) {
			case 1:
				t_type.setText(json.system.get(num - 1).configuration.dashboard.cell1.type);
				t_data.setText(json.system.get(num - 1).configuration.dashboard.cell1.data);
				t_title.setText(json.system.get(num - 1).configuration.dashboard.cell1.title);
				break;
			case 2:
				t_type.setText(json.system.get(num - 1).configuration.dashboard.cell2.type);
				t_data.setText(json.system.get(num - 1).configuration.dashboard.cell2.data);
				t_title.setText(json.system.get(num - 1).configuration.dashboard.cell2.title);
				break;
			case 3:
				t_type.setText(json.system.get(num - 1).configuration.dashboard.cell3.type);
				t_data.setText(json.system.get(num - 1).configuration.dashboard.cell3.data);
				t_title.setText(json.system.get(num - 1).configuration.dashboard.cell3.title);
				break;
			case 4:
				t_type.setText(json.system.get(num - 1).configuration.dashboard.cell4.type);
				t_data.setText(json.system.get(num - 1).configuration.dashboard.cell4.data);
				t_title.setText(json.system.get(num - 1).configuration.dashboard.cell4.title);
				break;
			case 5:
				t_type.setText(json.system.get(num - 1).configuration.dashboard.cell5.type);
				t_data.setText(json.system.get(num - 1).configuration.dashboard.cell5.data);
				t_title.setText(json.system.get(num - 1).configuration.dashboard.cell5.title);
				break;
			case 6:
				t_type.setText(json.system.get(num - 1).configuration.dashboard.cell6.type);
				t_data.setText(json.system.get(num - 1).configuration.dashboard.cell6.data);
				t_title.setText(json.system.get(num - 1).configuration.dashboard.cell6.title);
				break;
			default:
				System.err.println("error in dashboard");
				
		}
		
		
		t_type.setVisible(true);
		t_data.setVisible(true);
		t_title.setVisible(true);
		
	}

	private void showGeneral() {
		System.out.println("show General");
		
		v_room.setBounds(label_start2, 30, label_len, 30);
		v_logo.setBounds(label_start2, 65, label_len, 30);
		v_background.setBounds(label_start2, 100, label_len, 30);
		v_colorTheme.setBounds(label_start2, 135, label_len, 30);
		v_title.setBounds(label_start2, 170, label_len, 30);
		v_comm.setBounds(label_start2, 205, label_len, 30);
		v_lang.setBounds(label_start2, 240, label_len, 30);
		v_showLights.setBounds(label_start2, 275, label_len, 30);
		v_showHvac.setBounds(label_start2, 310, label_len, 30);
		v_showBlinds.setBounds(label_start2, 345, label_len, 30);
		v_showRoom.setBounds(label_start2, 380, label_len, 30);
		v_showDashboard.setBounds(label_start2, 415, label_len, 30);
		v_devMode.setBounds(label_start2, 450, label_len, 30);
		v_lockMobileInPortrait.setBounds(label_start2, 485, label_len, 30);
		v_lockTabletInLandscape.setBounds(label_start2, 520, label_len, 30);
		
		v_room.setVisible(true);
		v_logo.setVisible(true);
		v_background.setVisible(true);
		v_colorTheme.setVisible(true);
		v_title.setVisible(true);
		v_comm.setVisible(true);
		v_lang.setVisible(true);
		v_showLights.setVisible(true);
		v_showHvac.setVisible(true);
		v_showBlinds.setVisible(true);
		v_showRoom.setVisible(true);
		v_showDashboard.setVisible(true);
		v_devMode.setVisible(true);
		v_lockMobileInPortrait.setVisible(true);
		v_lockTabletInLandscape.setVisible(true);
		
		t_room.setBounds(tf_start, 30, tf_len, 30);
		t_logo.setBounds(tf_start, 65, tf_len, 30);
		t_background.setBounds(tf_start, 100, tf_len, 30);
		t_colorTheme.setBounds(tf_start, 135, tf_len, 30);
		t_title.setBounds(tf_start, 170, tf_len, 30);
		t_comm.setBounds(tf_start, 205, tf_len, 30);
		t_lang.setBounds(tf_start, 240, tf_len, 30);
		t_showLights.setBounds(tf_start, 275, tf_len, 30);
		t_showHvac.setBounds(tf_start, 310, tf_len, 30);
		t_showBlinds.setBounds(tf_start, 345, tf_len, 30);
		t_showRoom.setBounds(tf_start, 380, tf_len, 30);
		t_showDashboard.setBounds(tf_start, 415, tf_len, 30);
		t_devMode.setBounds(tf_start, 450, tf_len, 30);
		t_lockMobileInPortrait.setBounds(tf_start, 485, tf_len, 30);
		t_lockTabletInLandscape.setBounds(tf_start, 520, tf_len, 30);
		
		t_room.setText(json.system.get(num - 1).configuration.general.room);
		t_logo.setText(json.system.get(num - 1).configuration.general.logo);
		t_background.setText(json.system.get(num - 1).configuration.general.background);
		t_colorTheme.setText(json.system.get(num - 1).configuration.general.colorTheme);
		t_title.setText(json.system.get(num - 1).configuration.general.title);
		t_comm.setText(json.system.get(num - 1).configuration.general.comm);
		t_lang.setText(json.system.get(num - 1).configuration.general.lang);
		t_showLights.setText(json.system.get(num - 1).configuration.general.showLights.toString());
		t_showHvac.setText(json.system.get(num - 1).configuration.general.showHvac.toString());
		t_showBlinds.setText(json.system.get(num - 1).configuration.general.showBlinds.toString());
		t_showRoom.setText(json.system.get(num - 1).configuration.general.room);
		t_showDashboard.setText(json.system.get(num - 1).configuration.general.showDashboard.toString());
		t_devMode.setText(json.system.get(num - 1).configuration.general.devMode.toString());
		t_lockMobileInPortrait.setText(json.system.get(num - 1).configuration.general.lockMobileInPortrait.toString());
		t_lockTabletInLandscape.setText(json.system.get(num - 1).configuration.general.lockTabletInLandscape.toString());
		
		t_room.setVisible(true);
		t_logo.setVisible(true);
		t_background.setVisible(true);
		t_colorTheme.setVisible(true);
		t_title.setVisible(true);
		t_comm.setVisible(true);
		t_lang.setVisible(true);
		t_showLights.setVisible(true);
		t_showHvac.setVisible(true);
		t_showBlinds.setVisible(true);
		t_showRoom.setVisible(true);
		t_showDashboard.setVisible(true);
		t_devMode.setVisible(true);
		t_lockMobileInPortrait.setVisible(true);
		t_lockTabletInLandscape.setVisible(true);
	}

	private void showSysVariables() {
		System.out.println("Show System Valiables");
		
		v_id.setBounds(label_start2, 30, label_len, 30);
		v_type.setBounds(label_start2, 65, label_len, 30);
		v_locationId.setBounds(label_start2, 100, label_len, 30);
		
		v_id.setVisible(true);
		v_type.setVisible(true);
		v_locationId.setVisible(true);

		t_id.setBounds(tf_start, 30, tf_len, 30);
		t_id.setText(json.system.get(num - 1).iD);
		t_id.setVisible(true);
		
		t_type.setBounds(tf_start, 65, tf_len, 30);
		t_type.setText(json.system.get(num - 1).type);
		t_type.setVisible(true);
		
		t_locationId.setBounds(tf_start, 100, tf_len, 30);
		t_locationId.setText(json.system.get(num - 1).locationID);
		t_locationId.setVisible(true);
		
	}

	private void lightSync() {
		int n = json.system.get(cb_num.getSelectedIndex()-1).configuration.light.size();
		for(int i = cb_lght.getItemCount(); i < greaterNumOfLights + 1; i++) cb_lght.addItem("Light " + i);
		if(n < greaterNumOfLights) for(int i = greaterNumOfLights + 1; i > n + 1; i--) cb_lght.removeItemAt(n + 1);
	}

	private void blindSync() {
		int n = json.system.get(cb_num.getSelectedIndex()-1).configuration.blinds.size();
		for(int i = cb_blnd.getItemCount(); i < greaterNumOfBlinds + 1; i++) cb_blnd.addItem("Blind " + i);			
		if(n < greaterNumOfBlinds) for(int i = greaterNumOfBlinds + 1; i > n + 1; i--) cb_blnd.removeItemAt(n + 1);
	}
	
	private int findTheGreaterNumOfLights() {
		int n = 0;
		for(int i = 0; i < json.system.size(); i++) if(json.system.get(i).configuration.light.size() > n) n = json.system.get(i).configuration.light.size();	
		return n;
	}
	
	private int findTheGreaterNumOfBlinds() {
		int n = 0;
		for(int i = 0; i < json.system.size(); i++) if(json.system.get(i).configuration.blinds.size() > n) n = json.system.get(i).configuration.blinds.size();
		return n;
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
		save.setEnabled(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}

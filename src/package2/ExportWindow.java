package package2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import package1.SystemList;

public class ExportWindow implements ActionListener{
	
	SystemList json;
	int monitorWidth, monitorHeight;
	int frameWidth = 700;
	int frameHeight = 200;
	
	JFrame frame;
	JButton existing_file;
	JButton new_file;
	JButton ok;
	JFileChooser fc;
	JLabel notif;
	
	public ExportWindow(SystemList json) {
		this.json = json;
	}

	public void initFrame() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		monitorWidth = (int) screenSize.getWidth();
		monitorHeight = (int) screenSize.getHeight();
		
		frame = new JFrame("jsonModifier - Export File");
		frame.setSize(frameWidth, frameHeight);
		frame.setLocation(monitorWidth/2 - frameWidth/2, monitorHeight/2 - frameHeight/2);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		existing_file = new JButton("Save to Existing File");
		existing_file.setBounds(30+150, 30, 150, 30);
		existing_file.addActionListener(this);
		
		new_file = new JButton("Save New File");
		new_file.setBounds(210+150, 30, 150, 30);
		new_file.addActionListener(this);
		
		notif = new JLabel("File is succesfuly saved!");
		notif.setBounds(280, 65, 150, 30);
		notif.setVisible(false);
		
		ok = new JButton("OK");
		ok.setBounds(310, 100, 70, 30);
		ok.setVisible(false);
		ok.setEnabled(true);
		ok.addActionListener(this);
		
		frame.add(notif);
		frame.add(ok);
		frame.add(existing_file);
		frame.add(new_file);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == existing_file) {
			try {
				json.writeJSON(json.input.toString());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			notif.setVisible(true);
			ok.setVisible(true);
		}
		else if(e.getSource() == new_file) {
			fc = new JFileChooser("Save As");
			fc.showSaveDialog(frame);
			StringBuffer link = new StringBuffer(fc.getSelectedFile().getPath());
			
			if(!link.substring(link.length()-5, link.length()).contentEquals(".json")) link.append(".json");
			try {
				json.writeJSON(link.toString());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			notif.setVisible(true);
			ok.setVisible(true);
		} else if(e.getSource() == ok) {
			frame.dispose();
		}
		
	}

}

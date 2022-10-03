package package2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LoadWindow implements ActionListener {
	
	public JTextField link = new JTextField();
	public boolean bool = false;
	JButton next;
	JFrame frame;
	JButton browse;
	StringBuffer sb = new StringBuffer();
	
	public LoadWindow() {
	}
	
	public void initFrame() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int monitorWidth = (int) screenSize.getWidth();
		int monitorHeight = (int) screenSize.getHeight();
				
		int frameWidth = 650;
		int frameHeight = 180;
		
		
		frame = new JFrame("jsonModifier - Load file");
		frame.setSize(frameWidth, frameHeight);
		frame.setLocation(monitorWidth/2 - frameWidth/2, monitorHeight/2 - frameHeight/2);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel input = new JLabel("Input file:");
		input.setBounds(30, 30, 100, 30);
		JLabel message = new JLabel("JavaScript Open Notation files ONLY");
		message.setBounds(90, 65, 400, 30);
		link = new JTextField();
		link.setBounds(85, 30, 400, 30);
		link.setEditable(false);
		
		next = new JButton("Next");
		next.setBounds(490, 65, 100, 30);
		next.addActionListener(this);
		next.setEnabled(false);
		
		browse = new JButton("Browse");
		browse.setBounds(490, 30, 100, 30);
		browse.addActionListener(this);
		
		if(link.getText().contains(".json")) next.setEnabled(true);
		
		frame.add(input);
		frame.add(link);
		frame.add(browse);
		frame.add(next);
		frame.add(message);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == next) {
			frame.dispose();
			bool = true;
		}
		else if(e.getSource() == browse) {
			JFileChooser fc = new JFileChooser();
	    	fc.setFileFilter(new FileNameExtensionFilter("JavaScript Open Notation File (*.json)", "json"));
			fc.showOpenDialog(null);
			link.setText(fc.getSelectedFile().toString());
			if(link.getText().contains(".json")) next.setEnabled(true);
		}
		
	}


	
}

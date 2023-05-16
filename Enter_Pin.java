package ATM_INTERFACE;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class Enter_Pin {

	public Enter_Pin(){
		JFrame epframe=new JFrame("ATM Pin");
		JButton epbutton=new JButton("Enter");
		JButton backbutton=new JButton("Go Back Home");
		JLabel eplabel=new JLabel("Enter Pin(3 Digits)");
		JPasswordField epin=new JPasswordField(7);
		JPanel eplabelpanel,epinpanel,epbuttonpanel,backbuttonpanel;
		Toolkit toolKit = epframe.getToolkit();
		Dimension size = toolKit.getScreenSize();
		epframe.setLocation(size.width/3 - epframe.getWidth()/3, size.height/3 - epframe.getHeight()/3);
		epframe.setSize(400,200);
		epframe.setLayout(new BoxLayout(epframe.getContentPane(),BoxLayout.Y_AXIS));
		
		eplabelpanel=new JPanel();
		epinpanel=new JPanel();
		epbuttonpanel=new JPanel();
		backbuttonpanel=new JPanel();
		
		eplabelpanel.add(eplabel);
		epinpanel.add(epin);
		epbuttonpanel.add(epbutton);
		backbuttonpanel.add(backbutton);
		
		epframe.add(eplabelpanel);
		epframe.add(epinpanel);
		epframe.add(epbuttonpanel);
		epframe.add(backbuttonpanel);
		
		epframe.setVisible(true);
		
		epbutton.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(HomeScreen.GPinDetails.size()==0) {
					JOptionPane.showMessageDialog(epframe, "Not Registerred", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(epin.getText().length()!=3) {
					JOptionPane.showMessageDialog(epframe, "Enter valid Pin", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					new sav_cur();
					epframe.dispose();
				}
			}
			
		});
		
		backbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new HomeScreen();
				epframe.dispose();
				
			}
			
		});
		
	}
}

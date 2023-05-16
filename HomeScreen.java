package ATM_INTERFACE;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class HomeScreen {

	public static int balance=0;
	public static List<Object> GPinDetails=new ArrayList<>();
	
	public HomeScreen() {
		
		JFrame homescreen = new JFrame("JAVA ATM");
		JLabel home_label=new JLabel("welcome to JAVA Bank");
		Toolkit toolKit = homescreen.getToolkit();
		Dimension size = toolKit.getScreenSize();
		homescreen.setLocation(size.width/3 - homescreen.getWidth()/3, size.height/3 - homescreen.getHeight()/3);
		//JLabel pic_label;
		homescreen.add(home_label);
		JPanel homelabelpanel,pinlabelpanel,gpinlabelpanel;
		homescreen.setResizable(false);
		homelabelpanel=new JPanel();
		pinlabelpanel=new JPanel();
		gpinlabelpanel=new JPanel();
		
		
		//ImageIcon i=new ImageIcon(getClass().getResource("bob.png"));
		//pic_label=new JLabel(i);
		//pic_label.setSize(400,400);
		//homescreen.add(pic_label);
		
		homescreen.setLayout(new BoxLayout(homescreen.getContentPane(),BoxLayout.Y_AXIS));
		//homescreen.setLayout(new FlowLayout());
		JLabel pin_label=new JLabel("Enter your ATM pin");
		JButton pin=new JButton("Enter Pin");
		pin.setPreferredSize(new Dimension(200,30));
		JLabel gpin_label=new JLabel("Genarate your New ATM pin");
		JButton gpin=new JButton("Generate Pin");
		gpin.setPreferredSize(new Dimension(200,30));
		
		
		//layout manager to decide where the buttons and labels are place
		homescreen.setSize(400, 250);
		homelabelpanel.add(home_label);
		pinlabelpanel.add(pin_label);
		pinlabelpanel.add(pin);
		gpinlabelpanel.add(gpin_label);
		gpinlabelpanel.add(gpin);
		
		homescreen.add(homelabelpanel);
		homescreen.add(pinlabelpanel);
		homescreen.add(gpinlabelpanel);
		
		homescreen.setVisible(true);
		homescreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//enter atm pin event
		pin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Enter_Pin();
				homescreen.dispose();
			}
			
		});
		
		//generate new atm pin event
		gpin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Generate_pin();
				homescreen.dispose();
			}
			
		});
		
	}
	public static void main(String []args) {
		
		 new HomeScreen();
	}
}

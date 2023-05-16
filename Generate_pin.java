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
import javax.swing.JTextField;

public class Generate_pin {

	
	public Generate_pin(){
		
		JPasswordField New_pin,Confirm_pin;
		JTextField Acc_no,ConfirmAcc_no;
		JPanel l1panel,New_pinpanel,Confirm_pinpanel,Acc_nopanel,ConfirmAcc_nopanel,pl_panel,cpl_panel,al_panel,cal_panel,checkpanel,backpanel;
	
		JFrame gframe=new JFrame("BOB ATM");
		gframe.setSize(400, 400);
		Toolkit toolKit = gframe.getToolkit();
		Dimension size = toolKit.getScreenSize();
		gframe.setLocation(size.width/3 - gframe.getWidth()/3, size.height/3 - gframe.getHeight()/3);
		
		JLabel l1=new JLabel("Generate New ATM..");
		
		New_pin=new JPasswordField(7);
		New_pin.setPreferredSize(new Dimension(200,20));
		Confirm_pin=new JPasswordField(7);
		Confirm_pin.setPreferredSize(new Dimension(200,20));
		Acc_no=new JTextField(11);
		Acc_no.setPreferredSize(new Dimension(200,20));
		ConfirmAcc_no=new JTextField(11);
		ConfirmAcc_no.setPreferredSize(new Dimension(200,20));
		
		JLabel pl=new JLabel("Enter New Pin(3 Digit)");
		JLabel cpl=new JLabel("Confirm New Pin");
		JLabel al=new JLabel("Enter Account Number(5 Digit)");
		JLabel cal=new JLabel("Confirm account Number");
		
		JButton check=new JButton("Generate");
		JButton back=new JButton("Go Back Home");
		
		l1panel=new JPanel();
		New_pinpanel=new JPanel();
		Confirm_pinpanel=new JPanel();
		Acc_nopanel=new JPanel();
		ConfirmAcc_nopanel=new JPanel();
		pl_panel=new JPanel();
		cpl_panel=new JPanel();
		al_panel=new JPanel();
		cal_panel=new JPanel();
		checkpanel=new JPanel();
		backpanel=new JPanel();
		
		gframe.setLayout(new BoxLayout(gframe.getContentPane(),BoxLayout.Y_AXIS));
		
		l1panel.add(l1);
		New_pinpanel.add(New_pin);
		Confirm_pinpanel.add(Confirm_pin);
		Acc_nopanel.add(Acc_no);
		ConfirmAcc_nopanel.add(ConfirmAcc_no);
		pl_panel.add(pl);
		cpl_panel.add(cpl);
		al_panel.add(al);
		cal_panel.add(cal);
		checkpanel.add(check);
		backpanel.add(back);
		
		gframe.add(l1panel);
		gframe.add(al_panel);
		gframe.add(Acc_nopanel);
		gframe.add(cal_panel);
		gframe.add(ConfirmAcc_nopanel);
		gframe.add(pl_panel);
		gframe.add(New_pinpanel);
		gframe.add(cpl_panel);
		gframe.add(Confirm_pinpanel);
		gframe.add(checkpanel);
		gframe.add(backpanel);
		
		gframe.setVisible(true);
		
		check.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				if(New_pin.getText().length()==0&&Confirm_pin.getText().length()==0&&Acc_no.getText().length()==0&&ConfirmAcc_no.getText().length()==0) {
					JOptionPane.showMessageDialog(gframe,"All fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
				}
				//else if(New_pin.getPassword().length!=3&&Confirm_pin.getPassword().length!=3&&Acc_no.getText().length()!=5&&ConfirmAcc_no.getText().length()!=5) {
				//	JOptionPane.showMessageDialog(gframe,"Enter Proper Information", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
				//}
				else {
					HomeScreen.GPinDetails.clear();
					HomeScreen.GPinDetails.add(Acc_no.getText());
					HomeScreen.GPinDetails.add(ConfirmAcc_no.getText());
					HomeScreen.GPinDetails.add(New_pin.getText());
					HomeScreen.GPinDetails.add(Confirm_pin.getText());
					
				}
				
			  if(HomeScreen.GPinDetails.get(0).equals(HomeScreen.GPinDetails.get(1))&&(Acc_no.getText().length()==5)&&(ConfirmAcc_no.getText().length()==5)&&HomeScreen.GPinDetails.get(2).equals(HomeScreen.GPinDetails.get(3))&&(New_pin.getText().length()==3)&&(Confirm_pin.getText().length()==3)) {
					JOptionPane.showMessageDialog(gframe,"PIN Generation Successfull!!", "Success", JOptionPane.INFORMATION_MESSAGE);
					new HomeScreen();
					gframe.dispose();
				}
				else{
						JOptionPane.showMessageDialog(gframe,"Account Number (OR) ATM pins Mismatch ", "Try Again", JOptionPane.ERROR_MESSAGE);
						
				}
			}
			
		});
		
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new HomeScreen();
				gframe.dispose();
				
			}
			
		});
		

	}
}

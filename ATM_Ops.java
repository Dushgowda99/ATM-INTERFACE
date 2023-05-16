package ATM_INTERFACE;

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
import java.util.Random;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ATM_Ops{
	static int totdeposit=0;
	static int totwithdrawn=0;
	static int totfastwithdrawn=0;
	static int bc=0,dc=0,wc=0,fwc=0;
	public ATM_Ops() {
		JFrame opsframe;
		JButton checkbalance,depositcash,withdrawcash,withdrawfastcash,exit,printreceipt;
		JLabel opslabel;
		JPanel opspanel,checkpanel,depositpanel,withdrawcashpanel,withdrawfastcashpanel,exitpanel,printreceiptpanel;
		
		opsframe = new JFrame("ATM Operations");
		opsframe.setSize(400,400);
		opslabel=new JLabel("");
		
		Toolkit toolKit = opsframe.getToolkit();
		Dimension size = toolKit.getScreenSize();
		opsframe.setLocation(size.width/3 - opsframe.getWidth()/3, size.height/3 - opsframe.getHeight()/3);
		
		checkbalance=new JButton("Balance");
		depositcash=new JButton("Deposit");
		withdrawcash=new JButton("Withdraw");
		withdrawfastcash=new JButton("Fast Cash");
		printreceipt=new JButton("Print Receipt");
		exit=new JButton("Exit");
		
		checkbalance.setPreferredSize(new Dimension(200,30));
		depositcash.setPreferredSize(new Dimension(200,30));
		withdrawcash.setPreferredSize(new Dimension(200,30));
		withdrawfastcash.setPreferredSize(new Dimension(200,30));
		printreceipt.setPreferredSize(new Dimension(200,30));
		exit.setPreferredSize(new Dimension(200,30));
		
		opspanel=new JPanel();
		checkpanel=new JPanel();
		depositpanel=new JPanel();
		withdrawcashpanel=new JPanel();
		withdrawfastcashpanel=new JPanel();
		printreceiptpanel=new JPanel();
		exitpanel=new JPanel();
		
		opspanel.add(opslabel);
		checkpanel.add(checkbalance);
		depositpanel.add(depositcash);
		withdrawcashpanel.add(withdrawcash);
		withdrawfastcashpanel.add(withdrawfastcash);
		printreceiptpanel.add(printreceipt);
		exitpanel.add(exit);
		
		opsframe.setLayout(new BoxLayout(opsframe.getContentPane(),BoxLayout.Y_AXIS));
		
		opsframe.add(opspanel);
		opsframe.add(checkpanel);
		opsframe.add(depositpanel);
		opsframe.add(withdrawcashpanel);
		opsframe.add(withdrawfastcashpanel);
		opsframe.add(printreceiptpanel);
		opsframe.add(exitpanel);
		
		opsframe.setVisible(true);
		
		//checking balance
		checkbalance.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				bc++;
				if(true) {
					JOptionPane.showMessageDialog(opsframe,"Your Balance is "+ Integer.toString(HomeScreen.balance)+" Rupees Only","Balance",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
		
		//depositing money
		depositcash.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dc++;
				opsframe.dispose();
				
				JFrame dframe=new JFrame("Depositing Cash Window");
				JLabel depositlabel=new JLabel("Deposit Cash in Multiples of (50s,100s,200s,500s & 2000s) only");
				JTextField deposittextbox=new JTextField(6);
				JButton depositbutton=new JButton("Deposit");
				JButton backbutton=new JButton("Back");
				
				Toolkit toolKit = dframe.getToolkit();
				Dimension size = toolKit.getScreenSize();
				dframe.setLocation(size.width/3 - dframe.getWidth()/3, size.height/3 - dframe.getHeight()/3);
				
				JPanel depositlabelpanel,deposittextboxpanel,depositbuttonpanel,backbuttonpanel;
				
				depositlabelpanel=new JPanel();
				deposittextboxpanel=new JPanel();
				depositbuttonpanel=new JPanel();
				backbuttonpanel=new JPanel();
				
				dframe.setSize(400, 200);
				dframe.setLayout(new BoxLayout(dframe.getContentPane(),BoxLayout.Y_AXIS));
				
				depositlabelpanel.add(depositlabel);
				deposittextboxpanel.add(deposittextbox);
				depositbuttonpanel.add(depositbutton);
				backbuttonpanel.add(backbutton);
				
				dframe.add(depositlabelpanel);
				dframe.add(deposittextboxpanel);
				dframe.add(depositbuttonpanel);
				dframe.add(backbuttonpanel);
				
				dframe.setVisible(true);
				
				depositbutton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(Integer.parseInt(deposittextbox.getText())%50!=0||deposittextbox.getText().isEmpty()) {
							JOptionPane.showMessageDialog(dframe, "Please, Enter Amount in muliples of 50s", "DENOMINATION FAULT", JOptionPane.ERROR_MESSAGE);
						}
						else {
							HomeScreen.balance=HomeScreen.balance+Integer.parseInt(deposittextbox.getText());
							totdeposit+=Integer.parseInt(deposittextbox.getText());
							JOptionPane.showMessageDialog(dframe, deposittextbox.getText()+".00 Rupees Deposited Successfully!!", "CREDITED", JOptionPane.INFORMATION_MESSAGE);
							new ATM_Ops();
							dframe.dispose();
						}
						
					}
				});
				backbutton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						dframe.dispose();
						new ATM_Ops();
					}
					
				});
				
			}
			
		});
		
		withdrawcash.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				wc++;
				opsframe.dispose();
				
				JFrame wframe=new JFrame("Withdrawing Cash Window");
				JLabel withdrawlabel=new JLabel("Withdraw Cash in Multiples of (100s,200s,500s & 2000s) only");
				JTextField withdrawtextbox=new JTextField(6);
				JButton withdrawbutton=new JButton("WithDraw");
				JButton backbutton=new JButton("Back");
				
				Toolkit toolKit = wframe.getToolkit();
				Dimension size = toolKit.getScreenSize();
				wframe.setLocation(size.width/3 - wframe.getWidth()/3, size.height/3 - wframe.getHeight()/3);
				
				JPanel withdrawlabelpanel,withdrawtextboxpanel,withdrawbuttonpanel,backbuttonpanel;
				
				withdrawlabelpanel=new JPanel();
				withdrawtextboxpanel=new JPanel();
				withdrawbuttonpanel=new JPanel();
				backbuttonpanel=new JPanel();
				 
				wframe.setSize(400, 200);
				wframe.setLayout(new BoxLayout(wframe.getContentPane(),BoxLayout.Y_AXIS));
				
				withdrawlabelpanel.add(withdrawlabel);
				withdrawtextboxpanel.add(withdrawtextbox);
				withdrawbuttonpanel.add(withdrawbutton);
				backbuttonpanel.add(backbutton);
				
				wframe.add(withdrawlabelpanel);
				wframe.add(withdrawtextboxpanel);
				wframe.add(withdrawbuttonpanel);
				wframe.add(backbuttonpanel);
				
				wframe.setVisible(true);
				
				withdrawbutton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						if(Integer.parseInt(withdrawtextbox.getText())>HomeScreen.balance) {
							JOptionPane.showMessageDialog(wframe, "INSUFFICIENT BALANCE ", "LOW BALANCE", JOptionPane.ERROR_MESSAGE);
						}
						else if(Integer.parseInt(withdrawtextbox.getText())%100!=0||withdrawtextbox.getText().isEmpty()) {
							JOptionPane.showMessageDialog(wframe, "Please, Enter Amount in muliples of 100s", "DENOMINATION FAULT", JOptionPane.ERROR_MESSAGE);
						}
						else {
							HomeScreen.balance=HomeScreen.balance-Integer.parseInt(withdrawtextbox.getText());
							JOptionPane.showMessageDialog(wframe, withdrawtextbox.getText()+".00 Rupees withdrawn Successfully!!", "DEBITED", JOptionPane.INFORMATION_MESSAGE);
							totwithdrawn+=Integer.parseInt(withdrawtextbox.getText());
							new ATM_Ops();
							wframe.dispose();
						}
					}
					
				});
				backbutton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						wframe.dispose();
						new ATM_Ops();
					}
					
				});
			}
			
		});

		withdrawfastcash.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				fwc++;
				JFrame wfframe=new JFrame("Withdrawing Fast Cash Window");
				
				Toolkit toolKit = wfframe.getToolkit();
				Dimension size = toolKit.getScreenSize();
				wfframe.setLocation(size.width/3 - wfframe.getWidth()/3, size.height/3 - wfframe.getHeight()/3);
				
				JButton withdrawfastcashbutton1=new JButton("WithDraw 100");
				JButton withdrawfastcashbutton2=new JButton("WithDraw 200");
				JButton withdrawfastcashbutton3=new JButton("WithDraw 500");
				JButton withdrawfastcashbutton4=new JButton("WithDraw 2000");
				
				JPanel withdrawfastcashpanel1,withdrawfastcashpanel2,withdrawfastcashpanel3,withdrawfastcashpanel4;
				
				withdrawfastcashpanel1=new JPanel();
				withdrawfastcashpanel2=new JPanel();
				withdrawfastcashpanel3=new JPanel();
				withdrawfastcashpanel4=new JPanel();
				
				wfframe.setSize(400, 400);
				wfframe.setLayout(new BoxLayout(wfframe.getContentPane(),BoxLayout.Y_AXIS));
				
				withdrawfastcashpanel1.add(withdrawfastcashbutton1);
				withdrawfastcashpanel2.add(withdrawfastcashbutton2);
				withdrawfastcashpanel3.add(withdrawfastcashbutton3);
				withdrawfastcashpanel4.add(withdrawfastcashbutton4);
				
				wfframe.add(withdrawfastcashpanel1);
				wfframe.add(withdrawfastcashpanel2);
				wfframe.add(withdrawfastcashpanel3);
				wfframe.add(withdrawfastcashpanel4);
				
				wfframe.setVisible(true);
				withdrawfastcashbutton1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						opsframe.dispose();
						if(HomeScreen.balance<100) {
							JOptionPane.showMessageDialog(wfframe, "Balance Insufficient!", "LOW BALANCE", JOptionPane.ERROR_MESSAGE);
						}
						else {
							HomeScreen.balance=HomeScreen.balance-100;
						JOptionPane.showMessageDialog(wfframe, "100 Rupees Withdrawal Successfull!", "DEBITED", JOptionPane.INFORMATION_MESSAGE);
						totfastwithdrawn+=100;
						new ATM_Ops();
						wfframe.dispose();
						}
					}
					
				});
				withdrawfastcashbutton2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						opsframe.dispose();
						if(HomeScreen.balance<200) {
							JOptionPane.showMessageDialog(wfframe, "Balance Insufficient!", "LOW BALANCE", JOptionPane.ERROR_MESSAGE);
						}
						else {
							HomeScreen.balance=HomeScreen.balance-200;
						JOptionPane.showMessageDialog(wfframe, "200 Rupees Withdrawal Successfull!", "DEBITED", JOptionPane.INFORMATION_MESSAGE);
						totfastwithdrawn+=200;
						new ATM_Ops();
						wfframe.dispose();
						}
					}
					
				});
				withdrawfastcashbutton3.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						opsframe.dispose();
						if(HomeScreen.balance<500) {
							JOptionPane.showMessageDialog(wfframe, "Balance Insufficient!", "LOW BALANCE", JOptionPane.ERROR_MESSAGE);
						}
						else {
							HomeScreen.balance=HomeScreen.balance-500;
						JOptionPane.showMessageDialog(wfframe, "500 Rupees Withdrawal Successfull!", "DEBITED", JOptionPane.INFORMATION_MESSAGE);
						totfastwithdrawn+=500;
						new ATM_Ops();
						wfframe.dispose();
						}
					}
					
				});
				withdrawfastcashbutton4.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						opsframe.dispose();
						if(HomeScreen.balance<2000) {
							JOptionPane.showMessageDialog(wfframe, "Balance Insufficient!", "LOW BALANCE", JOptionPane.ERROR_MESSAGE);
						}
						else {
							HomeScreen.balance=HomeScreen.balance-2000;
						JOptionPane.showMessageDialog(wfframe, "2000 Rupees Withdrawal Successfull!", "DEBITED", JOptionPane.INFORMATION_MESSAGE);
						totfastwithdrawn+=2000;
						new ATM_Ops();
						wfframe.dispose();
						}
					}
					
				});
			}
			
		});
		
		
		printreceipt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame pframe=new JFrame("Printing Receipt");
				pframe.setSize(320,320);
				JTextArea textarea=new JTextArea();
				textarea.setSize(200,200);
				
				Toolkit toolKit = pframe.getToolkit();
				Dimension size = toolKit.getScreenSize();
				pframe.setLocation(size.width/3 - pframe.getWidth()/3, size.height/3 - pframe.getHeight()/3);
				
				Random rnd = new Random();
			    int number = rnd.nextInt(999999);
			    
				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 
				String formatDateTime = now.format(format);
				
				String pr1="**********************RECIEPT***********************\n";
				String bl1="\n";
				String wee="*********************JAVA BANK**********************\n";
				String bl2="\n";
				String pr2="Date and Time of Transaction : "+formatDateTime+"\n";
				String pr3="Transaction ID : "+String.valueOf(number)+"\n";
				String pr4="Account Number : XXX"+String.valueOf(HomeScreen.GPinDetails.get(0)).substring(3, 5)+"\n";
				String bl3="\n";
				String pr5="Account Credited for a Total Amount of : Rs."+totdeposit+"\n";
				String pr6="Number of deposits : "+dc;
				String bl4="\n";
				String pr7="Account Debited for a Total Amount of : Rs."+totwithdrawn+"\n";
				String pr8="Number of withdrawals : "+wc;
				String bl5="\n";
				String pr9="Account was Fast withdrawn for Amount : Rs."+totfastwithdrawn+"\n";
				String pr10="Number of Fast withdrawals : "+fwc;
				String bl6="\n";
				String pr11="Balance : Rs."+ HomeScreen.balance +"\n";
				String pr12="Number of Balance Checks : "+bc;
				String bl7="\n";
				String tee="******************HAVE A GOOD DAY*******************\n";
				textarea.setText(pr1+bl1+wee+bl2+pr2+pr3+pr4+bl3+pr5+pr6+bl4+pr7+pr8+bl5+pr9+pr10+bl6+pr11+pr12+bl7+tee);
				pframe.add(textarea);
				textarea.setLineWrap(true);
				textarea.setEditable(false);
				pframe.setVisible(true);
			}
			
		});
		
		
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new HomeScreen();
				opsframe.dispose();
			}
			
		});
		


	}
}

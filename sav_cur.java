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

public class sav_cur {

	public sav_cur() {
		JFrame scframe;
		JButton savb,curb,backhome;
		JLabel sclabel;
		JPanel sclabelpanel,savbpanel,curbpanel,backhomepanel;
		
		scframe=new JFrame("Account type");
		sclabel=new JLabel("Type of account?");
		savb=new JButton("Savings");
		curb=new JButton("Current");
		backhome=new JButton("Go Back Home");
		
		Toolkit toolKit = scframe.getToolkit();
		Dimension size = toolKit.getScreenSize();
		scframe.setLocation(size.width/3 - scframe.getWidth()/3, size.height/3 - scframe.getHeight()/3);
		
		sclabelpanel=new JPanel();
		savbpanel=new JPanel();
		curbpanel=new JPanel();
		backhomepanel=new JPanel();
		
		sclabelpanel.add(sclabel);
		savbpanel.add(savb);
		curbpanel.add(curb);
		backhomepanel.add(backhome);
		
		scframe.setSize(400,200);
		scframe.setLayout(new BoxLayout(scframe.getContentPane(),BoxLayout.Y_AXIS));
		
		scframe.add(sclabelpanel);
		scframe.add(savbpanel);
		scframe.add(curbpanel);
		scframe.add(backhomepanel);
		
		scframe.setVisible(true);
		
		savb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ATM_Ops();
				scframe.dispose();
			}
			
		});
		
		curb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(scframe, "Looks like your Account is default Savings type","",JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		
		backhome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				scframe.dispose();
				new HomeScreen();
				
			}
			
		});
	}
}

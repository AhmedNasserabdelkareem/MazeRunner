package PacManGit;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Options extends JFrame {
ImageFlyWeight fly =ImageFlyWeight.getinstance();
	private JPanel contentPane;
	private JLabel bombimage;
	private JLabel bigBombimage;
	private JLabel treeimage;
	private JLabel spaceimage;
	private JLabel wallimage;
	private JLabel giftimage;
	private JLabel ammoimage;
	public JButton back_BTN = new JButton("BACK");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Options frame = new Options();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Options() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new java.awt.Color(152, 230, 152));
		
		JLabel bombname = new JLabel("BOMB");
		bombname.setFont(new Font("Tahoma", Font.BOLD, 14));
		bombname.setBounds(50, 33, 111, 23);
		contentPane.add(bombname);
		
		 bombimage = new JLabel("", fly.getImageIcon("bomb"), JLabel.CENTER);
		bombimage.setBounds(50, 68,22, 22);
		contentPane.add(bombimage);

		
		JLabel giftname = new JLabel("gift");
		giftname.setFont(new Font("Tahoma", Font.BOLD, 14));
		giftname.setBounds(150, 33, 111, 23);
		contentPane.add(giftname);
		
		 giftimage = new JLabel("", fly.getImageIcon("gift"), JLabel.CENTER);
		giftimage.setBounds(150, 68,22, 22);
		contentPane.add(giftimage);
		
		JLabel treename = new JLabel("tree");
		treename.setFont(new Font("Tahoma", Font.BOLD, 14));
		treename.setBounds(250, 33, 111, 23);
		contentPane.add(treename);
		
		 treeimage = new JLabel("", fly.getImageIcon("tree"), JLabel.CENTER);
		treeimage.setBounds(250, 68,22, 22);
		contentPane.add(treeimage);
		
		JLabel bigbombname = new JLabel("bigbomb");
		bigbombname.setFont(new Font("Tahoma", Font.BOLD, 14));
		bigbombname.setBounds(350, 33, 111, 23);
		contentPane.add(bigbombname);
		
		 bigBombimage = new JLabel("", fly.getImageIcon("bigBomb"), JLabel.CENTER);
		bigBombimage.setBounds(350, 68,22, 22);
		contentPane.add(bigBombimage);
		
		
		JLabel spacename = new JLabel("space");
		spacename.setFont(new Font("Tahoma", Font.BOLD, 14));
		spacename.setBounds(450, 33, 111, 23);
		contentPane.add(spacename);
		
		 spaceimage = new JLabel("", fly.getImageIcon("space"), JLabel.CENTER);
		spaceimage.setBounds(450, 68,22, 22);
		contentPane.add(spaceimage);
		
		JLabel wallname = new JLabel("wall");
		wallname.setFont(new Font("Tahoma", Font.BOLD, 14));
		wallname.setBounds(550, 33, 111, 23);
		contentPane.add(wallname);
		
		 wallimage = new JLabel("", fly.getImageIcon("wall"), JLabel.CENTER);
		wallimage.setBounds(550, 68,22, 22);
		contentPane.add(wallimage);
		
		
		
		JLabel ammoname = new JLabel("ammo");
		ammoname.setFont(new Font("Tahoma", Font.BOLD, 14));
		ammoname.setBounds(650, 33, 111, 23);
		contentPane.add(ammoname);
		
		 ammoimage = new JLabel("", fly.getImageIcon("ammo"), JLabel.CENTER);
		ammoimage.setBounds(650, 68,22, 22);
		contentPane.add(ammoimage);
		
		
		JButton giftbtn = new JButton("Replace");
		giftbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser= new JFileChooser("pictures");
			    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			    chooser.showOpenDialog(getParent());
			    fly.setImageIcon("gift", chooser.getSelectedFile().getAbsolutePath());
			 //  System.out.println(fly.getImageIcon("gift"));
			    contentPane.remove(giftimage);
			    giftimage= new JLabel("", fly.getImageIcon("gift"), JLabel.CENTER);
			    giftimage.setBounds(150, 68,22, 22);
			    contentPane.add(giftimage);
			    contentPane.revalidate();
			    contentPane.repaint();
			}
		});
		giftbtn.setBounds(150, 96, 89, 23);
		contentPane.add(giftbtn);
		
		
		JButton treebtn = new JButton("Replace");
		treebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser= new JFileChooser("pictures");
			    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			    chooser.showOpenDialog(getParent());
			    fly.setImageIcon("tree", chooser.getSelectedFile().getAbsolutePath());
				 //  System.out.println(fly.getImageIcon("gift"));
				    contentPane.remove(treeimage);
				    treeimage= new JLabel("", fly.getImageIcon("tree"), JLabel.CENTER);
				    treeimage.setBounds(250, 68,22, 22);
				    contentPane.add(treeimage);
				    contentPane.revalidate();
				    contentPane.repaint();			    
			    

			}
		});
		treebtn.setBounds(250, 96, 89, 23);
		contentPane.add(treebtn);

		JButton bombbtn = new JButton("Replace");
		bombbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser= new JFileChooser("pictures");
			    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			    chooser.showOpenDialog(getParent());
			   // System.out.println(chooser.getSelectedFile());
			    fly.setImageIcon("bomb", chooser.getSelectedFile().getAbsolutePath());
			    contentPane.remove(bombimage);
			    bombimage= new JLabel("", fly.getImageIcon("bomb"), JLabel.CENTER);
			    bombimage.setBounds(50, 68,22, 22);
			    contentPane.add(bombimage);
			    contentPane.revalidate();
			    contentPane.repaint();	
			    

			}
		});

		bombbtn.setBounds(50, 96, 89, 23);
		contentPane.add(bombbtn);
		JButton bigbombbtn = new JButton("Replace");
		bigbombbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser= new JFileChooser("pictures");
			    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			    chooser.showOpenDialog(getParent());
			   // System.out.println(chooser.getSelectedFile());
			    fly.setImageIcon("bigBomb", chooser.getSelectedFile().getAbsolutePath());
			    contentPane.remove(bigBombimage);
			    bigBombimage= new JLabel("", fly.getImageIcon("bigBomb"), JLabel.CENTER);
			    bigBombimage.setBounds(350, 68,22, 22);
			    contentPane.add(bigBombimage);
			    contentPane.revalidate();
			    contentPane.repaint();	
			    

			    

			}
		});
		bigbombbtn.setBounds(350, 96, 89, 23);
		contentPane.add(bigbombbtn);

		
		
		
		

		JButton spacebtn = new JButton("Replace");
		spacebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser= new JFileChooser("pictures");
			    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			    chooser.showOpenDialog(getParent());
			   // System.out.println(chooser.getSelectedFile());
			    fly.setImageIcon("space", chooser.getSelectedFile().getAbsolutePath());
			    contentPane.remove(spaceimage);
			    spaceimage= new JLabel("", fly.getImageIcon("space"), JLabel.CENTER);
			    spaceimage.setBounds(50, 68,22, 22);
			    contentPane.add(spaceimage);
			    contentPane.revalidate();
			    contentPane.repaint();	
			    

			}
		});

		spacebtn.setBounds(450, 96, 89, 23);
		contentPane.add(spacebtn);
		

		JButton wallbtn = new JButton("Replace");
		wallbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser= new JFileChooser("pictures");
			    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			    chooser.showOpenDialog(getParent());
			   // System.out.println(chooser.getSelectedFile());
			    fly.setImageIcon("wall", chooser.getSelectedFile().getAbsolutePath());
			    contentPane.remove(wallimage);
			    wallimage= new JLabel("", fly.getImageIcon("wall"), JLabel.CENTER);
			    wallimage.setBounds(50, 68,22, 22);
			    contentPane.add(wallimage);
			    contentPane.revalidate();
			    contentPane.repaint();	
			    

			}
		});

		wallbtn.setBounds(550, 96, 89, 23);
		contentPane.add(wallbtn);
		
		
		
		
		
		JButton ammobtn = new JButton("Replace");
		ammobtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser= new JFileChooser("pictures");
			    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			    chooser.showOpenDialog(getParent());
			   // System.out.println(chooser.getSelectedFile());
			    fly.setImageIcon("ammo", chooser.getSelectedFile().getAbsolutePath());
			    contentPane.remove(ammoimage);
			    ammoimage= new JLabel("", fly.getImageIcon("ammo"), JLabel.CENTER);
			    ammoimage.setBounds(650, 68,22, 22);
			    contentPane.add(ammoimage);
			    contentPane.revalidate();
			    contentPane.repaint();	
			    

			}
		});

		ammobtn.setBounds(650, 96, 89, 23);
		contentPane.add(ammobtn);
		
		
		back_BTN.setBounds(483, 233, 89, 23);
		contentPane.add(back_BTN);
	}
}

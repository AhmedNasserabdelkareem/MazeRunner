package PacManGit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.Messaging.SyncScopeHelper;

import Objects.Ammo;
import Objects.Interactables;
import Objects.Player;

public class SecondGUI {
	public GUI gui = new GUI();
	private static JPanel player = null;
	private static JPanel bullet = new JPanel();

	private static JPanel contentPane;
	private static ArrayList<ImageIcon> pl = new ArrayList<>();
	private static JPanel playerPanel = null;
	private static JPanel bulletPanel = null;

	private static JPanel scorePanel = new JPanel();
	private static JPanel[][] mazepics;
	static int k = 0, n = 22,imagewidth=60;
	boolean flag = false;
	//private static ArrayList<JPanel> ammos = new ArrayList<>();
	private static JLabel score;
	private static ArrayList<JLabel> lives = new ArrayList<>();
	// private KeyListener key;
	private Interactables maze[][];
	ImageFlyWeight fly =ImageFlyWeight.getinstance();

	public SecondGUI() {

	}

	public void draw() {
		gui.setBounds(0, 0, 1000, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		gui.setContentPane(contentPane);
		JPanel mazePanel = new JPanel();
		mazePanel.setBounds(0, 0, 682, 735);
		scorePanel = new JPanel();
		scorePanel.setBounds(682, 0, 382, 735);
		scorePanel.setLayout(null);
		// scorePanel.setBackground(Color.black);
		score = new JLabel("Score: 01200");
		JLabel time = new JLabel("time  :00:00");
		score.setLocation(35, 10);
		score.setSize(180, 25);

		for (int i = 0; i < 4; i++) {
			lives.add(new JLabel("", fly.getImageIcon("fullHeart"), JLabel.CENTER));
			lives.get(i).setBounds(10 + imagewidth * i, 90, imagewidth, imagewidth);
			scorePanel.add(lives.get(i));
		}
		score.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		scorePanel.add(score);
		time.setLocation(35, 50);
		time.setSize(180, 25);
		time.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		scorePanel.add(time);
		contentPane.add(scorePanel);
		mazepics = new JPanel[maze.length][maze[0].length];
		// int n = 20;
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				JLabel label = null;
				if (maze[i][j].getClass().getSimpleName().equals("Stones")) {
					label = new JLabel("", fly.getImageIcon("wall"), JLabel.CENTER);
				} else if (maze[i][j].getClass().getSimpleName().equals("FullBomb")) {
					label = new JLabel("", fly.getImageIcon("bigBomb"), JLabel.CENTER);

				} else if (maze[i][j].getClass().getSimpleName().equals("HalfBomb")) {
					label = new JLabel("", fly.getImageIcon("bomb"), JLabel.CENTER);

				} else if (maze[i][j].getClass().getSimpleName().equals("Tree")) {
					label = new JLabel("", fly.getImageIcon("tree"), JLabel.CENTER);
				} else if (maze[i][j].getClass().getSimpleName().equals("Ammo")
						|| maze[i][j].getClass().getSimpleName().equals("Health")
						|| maze[i][j].getClass().getSimpleName().equals("Spirit")) {
					// System.out.println(fly.getImageIcon("gift"));
					label = new JLabel("", fly.getImageIcon("gift"), JLabel.CENTER);
				} else {
					label = new JLabel("", fly.getImageIcon("space"), JLabel.CENTER);
				}
				// label.setBounds(i*10, j*10,20, 100);
				mazepics[i][j] = new JPanel(new BorderLayout());
				// mazepics[i][j].setLayout(null);
				mazepics[i][j].add(label, BorderLayout.CENTER);

				mazepics[i][j].setBounds(n * j + 1, n * i + 1, n, n);

				mazePanel.add(mazepics[i][j]);
			}

		}

		pl = fly.getImageIconList("Down");
		JLabel pacman = new JLabel("", pl.get(k), JLabel.CENTER);
		// JLabel pacman = new JLabel();
		k++;
		player = new JPanel(new BorderLayout());
		player.setBounds(n, n, n, n);
		// pacman.setOpaque(true);
		pacman.setBackground(new Color(0, 0, 0, 0));
		player.add(pacman);
		// System.out.println(pacman);
		// player.setOpaque(true);
		player.setBackground(new Color(0, 0, 0, 0));
		contentPane.setLayout(null);
		
		bulletPanel = new JPanel();
		bulletPanel.setBounds(0, 0, 1000, 1000);
		bulletPanel.setLayout(null);
		bulletPanel.add(bullet);
		bulletPanel.setBackground(new Color(0, 0, 0, 0));
	
		playerPanel = new JPanel();
		playerPanel.setBounds(0, 0, 1000, 1000);
		playerPanel.setLayout(null);
		playerPanel.add(player);
		playerPanel.setBackground(new Color(0, 0, 0, 0));
		// panel.setLayout(null);
		contentPane.add(bulletPanel);
		bulletPanel.setVisible(true);
		contentPane.add(playerPanel);
		contentPane.add(mazePanel);
		playerPanel.setVisible(true);
		JButton btnNewButton = new JButton("button");
		btnNewButton.setBounds(700, 10, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				/*
				 * if(!flag) { flag = true; }else { flag = false; } { k++;
				 * //panel.revalidate(); panel.remove(player); //
				 * panel.getGraphics().clearRect(0, 0, 1000, 1000);
				 * player.setLocation(n , n*20-(k*5) ); JLabel pacman = new
				 * JLabel("", pl.get(k%16), JLabel.CENTER); k++;
				 * player.removeAll(); player.add(pacman); panel.add(player);
				 * panel.revalidate(); panel.repaint(); contentPane.repaint();
				 * 
				 * 
				 * 
				 * }
				 */

				Player player = new Player();
				player.setOldDirection("Up");
				player.setindexX(n * 4);

				player.setindexY(n * 8);
				updatePlayer(player);
				// contentPane.repaint();
				/*
				 * mazepics[2][2] = new JPanel(new BorderLayout()); int n = 27;
				 * mazepics[2][2] = new JPanel(new BorderLayout());
				 */
				/*
				 * mazepics[2][2].removeAll(); mazepics[2][2].revalidate();
				 * mazepics[2][2].repaint(); mazepics[2][2].add(label);
				 * //mazepics[2][2].setBounds(n * 2, n * 2, n, n);
				 * mazepics[2][2].repaint();
				 */
				// mazePanel.add(mazepics[2][2]);
				// contentPane.add(mazePanel);

				// mazePanel.setLayout(null);
				// contentPane.getGraphi

			}
		});
		mazePanel.setLayout(null);
		mazePanel.add(btnNewButton);
		// gui.addKeyListener(key);
		gui.setVisible(true);
		// mazePanel.setLayout(null);
	}

	public void updatArray(int i, int j) {
		mazepics[i][j].removeAll();
		JLabel label = new JLabel("", fly.getImageIcon("space"), JLabel.CENTER);
		mazepics[i][j].revalidate();
		mazepics[i][j].add(label);
		mazepics[i][j].repaint();
	}

	

	public void setarray(Interactables[][] arr) {
		this.maze = arr;

	}

	public void updateScore(Player playr) {

		scorePanel.remove(score);
		score = new JLabel("Score: " + playr.getScore() * k);
		score.setLocation(35, 10);
		score.setSize(180, 25);
		score.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		scorePanel.add(score);
		scorePanel.revalidate();
		scorePanel.repaint();
		contentPane.repaint();
		// System.out.println("fini");

	}

	public void updateHearts(int lifes) {
		if (!flag) {
			flag=true;
			for (int i = 0; i < lives.size(); i++) {
				scorePanel.remove(lives.get(i));
			}
			int hearts = lifes / 2;
			lives.clear();
			for (int i = 0; i < hearts; i++) {
				lives.add(new JLabel("", fly.getImageIcon("fullHeart"), JLabel.CENTER));
				lives.get(i).setBounds(10 + imagewidth * i, 90, imagewidth, imagewidth);
				scorePanel.add(lives.get(i));
			}
			if (lifes % 2 != 0) {
				
				lives.add(new JLabel("", fly.getImageIcon("halfHeart"), JLabel.CENTER));
				lives.get(lives.size()-1).setBounds(10 + imagewidth *(lives.size()-1) , 90, imagewidth, imagewidth);
				System.out.println(lives.size());
				scorePanel.add(lives.get(lives.size() - 1));
			}
			/*
			 * lives.add(new JLabel("", fly.getImageIcon("gift"),
			 * JLabel.CENTER)); scorePanel.add(lives.get(lives.size()-1));
			 * lives.get(lives.size()-1).setBounds(10+22*lives.size()-1, 90, 22,
			 * 22);
			 */scorePanel.revalidate();
			scorePanel.repaint();
			contentPane.repaint();
		}
	}
	public void updatePlayer(Player playr) {
		String direction = null;
		if (playr.getOldDirection().equals("Stop")) {
			if (playr.getRotationDir().equals("Stop"))
				return;
			// System.out.println("player "+playr.getindexX()+"
			// "+playr.getindexY());
			direction = playr.getRotationDir();

			k--;
		} else
			direction = playr.getOldDirection();
		pl = fly.getImageIconList(direction);
		playerPanel.remove(player);
		player.setLocation(playr.getindexX(), playr.getindexY());
		// System.out.println(playr.getOldDirection());
		JLabel pacman = new JLabel("", pl.get(k % 16), JLabel.CENTER);
		// JLabel pacman = new JLabel();
		pacman.setBackground(new Color(0, 0, 0, 0));
		k++;
		player.removeAll();
		player.add(pacman);
		playerPanel.add(player);
		playerPanel.revalidate();
		playerPanel.repaint();
		contentPane.repaint();
		// System.out.println("here");

	}
	public void updateAmmos(Ammo amos)
	{
		String direction = null;
		if (amos.getOldDirection().equals("Stop")) {
			if (amos.getRotationDir().equals("Stop"))
				return;
			// System.out.println("player "+amos.getindexX()+"
			// "+amos.getindexY());
			direction = amos.getRotationDir();

			k--;
		} else
			direction = amos.getOldDirection();
		pl = fly.getImageIconList(direction);
		bulletPanel.remove(bullet);
		bullet.setLocation(amos.getindexX()-12, amos.getindexY()-12);
		bullet.setSize(20,20);
		// System.out.println(amos.getOldDirection());
		JLabel pacman = new JLabel("", fly.getImageIcon("ammo"), JLabel.CENTER);
		// JLabel pacman = new JLabel();
		pacman.setBackground(new Color(0, 0, 0, 0));
		//k++;
		bullet.setBackground(new Color(0, 0, 0,0));
		bullet.removeAll();
		bullet.add(pacman);
		bulletPanel.add(bullet);
		bulletPanel.revalidate();
		bulletPanel.repaint();
		contentPane.repaint();
		// System.out.println("here");
		
		/*System.out.println(amos.size());
		for(JPanel panel:ammos)
		{
			panel.removeAll();
			player.remove(panel);
		}
		player.repaint();
		contentPane.repaint();
		//player.revalidate();
		//ammos.clear();
		ammos= new ArrayList<>();
		
		for(int i=0;i<amos.size();i++)
		{
			//JLabel bullet = new JLabel("", fly.getImageIcon("ammo"), JLabel.CENTER);
			JLabel bullet= new JLabel();
			bullet.setBackground(new Color(0, 0, 1));
			//System.out.println(amos.get(i).getindexX()+" "+amos.get(i).getindexY());
			
			bullet.setSize(10,10);
			ammos.add(new JPanel());
			ammos.get(i).setSize(10,10);
			//ammos.get(i).setBackground(new Color(0, 0, 0,0));
			ammos.get(i).setLocation(amos.get(i).getindexX()-10,amos.get(i).getindexY()-10);
			ammos.get(i).add(bullet);
			playerPanel.add(ammos.get(i));
		}
		playerPanel.revalidate();
		playerPanel.repaint();
		contentPane.repaint();
		
		*/
		
	}
}

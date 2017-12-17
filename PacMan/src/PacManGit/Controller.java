package PacManGit;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import Objects.Ammo;
import Objects.FullBomb;
import Objects.HalfBomb;
import Objects.Interactables;
import Objects.Spirit;
import Objects.Stones;
import Objects.Tree;

public class Controller {
	public GamingEngine gamingEngine = new GamingEngine();
	public Thread playerTherad = new Thread(new movePlayer());
	public SecondGUI g;
	public MainMenu menu = new MainMenu();
	private Options option = new Options();
	// private Thread[] shotsTherad = { new Thread(new moveShot()), new
	// Thread(new moveShot()), new Thread(new moveShot()),
	// new Thread(new moveShot()), new Thread(new moveShot()), new Thread(new
	// moveShot()) };
	public boolean end = false;
	KeyListener keyLi = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int keyCode = e.getKeyCode();
			String temp = KeyEvent.getKeyText(keyCode);
			// System.out.println(temp);
			if (temp.equals("Up") || temp.equals("Down") || temp.equals("Right") || temp.equals("Left")) {

				gamingEngine.player.setNewDirection(temp);
			}
			if (temp.equals("Space")) {
				int ammos = gamingEngine.player.getAmmo();
				gamingEngine.player.setAmmo(--ammos);
				moveShot ammoThread = new moveShot();
				ammoThread.ammoIndex = gamingEngine.createAmmo();
				Thread thread = new Thread(ammoThread);
				Ammo ammo = gamingEngine.getAmmo(ammoThread.ammoIndex);
				ammo.setindexX(gamingEngine.player.getindexX() + 22);
				ammo.setindexY(gamingEngine.player.getindexY() + 11);
				if(!gamingEngine.player.getOldDirection().equals("Stop")){
					ammo.setOldDirection(gamingEngine.player.getOldDirection());
				}else{
					ammo.setOldDirection(gamingEngine.player.getRotationDir());
				}
				thread.start();				
			}
			if(temp.equals("W") || temp.equals("D") || temp.equals("S") || temp.equals("A")){
				String nd = gamingEngine.player.getNewDirection();
				String od = gamingEngine.player.getOldDirection();
				if(nd.equals("Stop") && od.equals("Stop")){
					String rd = gamingEngine.player.getRotationDir();
					switch(temp){
					case "W":
						rd = "Up";
						break;
					case "D":
						rd = "Right";
						break;
					case "A":
						rd = "Left";
						break;
					case "S":
						rd = "Down";
						break;						
					}
					gamingEngine.player.setRotationDir(rd);
				}
			}

		}
	};

	private class movePlayer implements Runnable {
		public void run() {
			try {
				boolean stop = false;
				for (; !stop;) {
					Thread.sleep(95);
					// System.out.println(key);
					String oldDir = gamingEngine.player.getOldDirection();
					String newDir = gamingEngine.player.getNewDirection();
					int ID = gamingEngine.player.getIR();
					int JR = gamingEngine.player.getJD();
					int IL = gamingEngine.player.getIL();
					int JL = gamingEngine.player.getJL();
					int ISmall = gamingEngine.player.getISmall();
					int JSmall = gamingEngine.player.getJSmall();
					boolean B1 = false;
					boolean B2 = false;
					// isdied game . isdied stop = true;
					// player existance = false
					if (newDir.equals("Stop")) {
						switch (oldDir) {
						case "Up":
							if (ISmall == 0) {
								B2 = gamingEngine.isThereBlock(IL - 1, JR);
								B1 = gamingEngine.isThereBlock(IL - 1, JL);
							}
							// System.out.println("here");

							break;
						case "Down":
							if (ISmall == 0) {
								B2 = gamingEngine.isThereBlock(IL + 1, JR);
								B1 = gamingEngine.isThereBlock(IL + 1, JL);
							}
							break;
						case "Right":
							if (JSmall == 0) {
								B2 = gamingEngine.isThereBlock(IL, JL + 1);
								B1 = gamingEngine.isThereBlock(ID, JL + 1);
							}
							break;
						case "Left":
							if (JSmall == 0) {
								B2 = gamingEngine.isThereBlock(IL, JL - 1);
								B1 = gamingEngine.isThereBlock(ID, JL - 1);
							}
							break;
						}
						if (B1 || B2) {
							oldDir = "Stop";
							gamingEngine.player.setOldDirection(oldDir);
						}
					} else {
						switch (newDir) {
						case "Up":
							if (ISmall == 0) {
								B2 = gamingEngine.isThereBlock(IL - 1, JR);
								B1 = gamingEngine.isThereBlock(IL - 1, JL);
							}
							break;
						case "Down":
							if (ISmall == 0) {
								B2 = gamingEngine.isThereBlock(IL + 1, JR);
								B1 = gamingEngine.isThereBlock(IL + 1, JL);
							}
							break;
						case "Right":
							if (JSmall == 0) {
								B2 = gamingEngine.isThereBlock(IL, JL + 1);
								B1 = gamingEngine.isThereBlock(ID, JL + 1);
							}
							break;
						case "Left":
							if (JSmall == 0) {
								B2 = gamingEngine.isThereBlock(IL, JL - 1);
								B1 = gamingEngine.isThereBlock(ID, JL - 1);
							}
							break;
						}
						if (!(B1 || B2)) {
							oldDir = newDir;
							newDir = "Stop";
							gamingEngine.player.setOldDirection(oldDir);
							gamingEngine.player.setNewDirection(newDir);
						} else {
							B1 = false;
							B2 = false;
							switch (oldDir) {
							case "Up":
								if (ISmall == 0) {
									B2 = gamingEngine.isThereBlock(IL - 1, JR);
									B1 = gamingEngine.isThereBlock(IL - 1, JL);
								}
								// System.out.println("here");

								break;
							case "Down":
								if (ISmall == 0) {
									B2 = gamingEngine.isThereBlock(IL + 1, JR);
									B1 = gamingEngine.isThereBlock(IL + 1, JL);
								}
								break;
							case "Right":
								if (JSmall == 0) {
									B2 = gamingEngine.isThereBlock(IL, JL + 1);
									B1 = gamingEngine.isThereBlock(ID, JL + 1);
								}
								break;
							case "Left":
								if (JSmall == 0) {
									B2 = gamingEngine.isThereBlock(IL, JL - 1);
									B1 = gamingEngine.isThereBlock(ID, JL - 1);
								}
								break;
							}
							if (B1 || B2) {
								oldDir = "Stop";
								gamingEngine.player.setOldDirection(oldDir);
							}
						}
					}

					int positionY = gamingEngine.player.getindexY();
					int positionX = gamingEngine.player.getindexX();
					switch (oldDir) {
					case "Up":

						positionY -= 1;
						// p.repaint();
						break;
					case "Down":
						positionY += 1;
						// p.repaint();
						break;
					case "Right":
						positionX += 1;
						// p.repaint();
						break;
					case "Left":
						positionX -= 1;
						// p.repaint();
						break;
					}
					// System.out.println(positionX + " "+ positionY +" "+ B1+ "
					// "+ B2+ " "+ IL + " "+ JL + " "+ ID+ " "+
					// JR + " " + ISmall + " "+ JSmall);
					gamingEngine.player.setindexX(positionX);
					gamingEngine.player.setindexY(positionY);
					gamingEngine.player.setScore(3);
					g.updatePlayer(gamingEngine.player);
					g.updateScore(gamingEngine.player);
					g.updateHearts(7);

				}
			} catch (InterruptedException e) {
				System.out.println("llll");
			}catch(ClassCastException f)
			{
				System.out.println(f);
			}
		}

	}

	private class moveShot implements Runnable {
		public int ammoIndex;

		public void run() {
			try {
				boolean stop = false;
				for (; !stop;) {
					Thread.sleep(10);
					Ammo myAmmo = gamingEngine.getAmmo(ammoIndex);
					String Dir = myAmmo.getOldDirection();
					int ID = myAmmo.getIR();
					int JR = myAmmo.getJD();
					int IL = myAmmo.getIL();
					int JL = myAmmo.getJL();
					//char next1 = 'a';
					//char next2 = 'a';
					boolean B1 = false;
					boolean B2 = false;
					
					

					switch (Dir) {
					case "Up":
						B1 = gamingEngine.AmmoisDestroyed(IL, JR);
						B2 = gamingEngine.AmmoisDestroyed(IL, JL);
						break;
					case "Down":
						B1 = gamingEngine.AmmoisDestroyed(IL, JR);
						B2 = gamingEngine.AmmoisDestroyed(IL, JL);
						break;
					case "Right":
						B1 = gamingEngine.AmmoisDestroyed(IL, JL);
						B2 = gamingEngine.AmmoisDestroyed(ID, JL);
						break;
					case "Left":
						B1 = gamingEngine.AmmoisDestroyed(IL, JL - 1);
						B2 = gamingEngine.AmmoisDestroyed(ID, JL - 1);
						break;
					}
					
					
					if(B1 || B2){
						stop = true;
						myAmmo.setExistance(false);
						
						//g.updateAmmos();
						// ammo animation
						// destroyed in the method (Done in gamIngEngine)
						//I will Update ammo in gui in  main thread if there more than thread
					}

					/*if (next1 == 'W' || next2 == 'W') {
						myAmmo.setExistance(false);
						stop = true;
						// ammo animation
					} else if (next1 == 'T' || next2 == 'T') {
						myAmmo.setExistance(false);
						stop = true;
						// ammo animation
						// destroy
					} else if (next1 == 'B' || next2 == 'B') {
						myAmmo.setExistance(false);
						stop = true;
						// ammo animation
						// destroy
					}*/

					int positionY = myAmmo.getindexY();
					int positionX = myAmmo.getindexX();
					switch (Dir) {
					case "Up":

						positionY -= 1;
						// p.repaint();
						break;
					case "Down":
						positionY += 1;
						// p.repaint();
						break;
					case "Right":
						positionX += 1;
						// p.repaint();
						break;
					case "Left":
						positionX -= 1;
						// p.repaint();
						break;
					}
					myAmmo.setindexX(positionX);
					myAmmo.setindexY(positionY);
					/*Iterator i = gamingEngine.CellIterator;
					ArrayList<Ammo> li = new ArrayList<>();
					gamingEngine.CellIterator.getInstance();
					while(i.hasNext()){
						li.add((Ammo)i.next());
					}*/
					g.updateAmmos(myAmmo);
					
				}
			} catch (InterruptedException e) {

			}
		}
	}

	public static void main(String args[]) throws InterruptedException {
		Controller control = new Controller();
		initializeMenuButtons(control);
		control.menu.frmMainmenu.setVisible(true);
		
		//control.playerTherad.join(11);
		/*while(control.playerTherad.isAlive()){
			Iterator i = control.gamingEngine.CellIterator;
			ArrayList<Ammo> li = new ArrayList<>();
			control.gamingEngine.CellIterator.getInstance();
			while(i.hasNext()){
				li.add((Ammo)i.next());
			}
			control.g.updateAmmos(li);
		}*/
		

		// update player

		/*
		 * EventQueue.invokeLater(new Runnable() { public void run() { try { //
		 * PaintGui window = new PaintGui(); control.frmPaint.setVisible(true);
		 * } catch (Exception e) { e.printStackTrace(); } } });
		 */

		

		// t.interrupt();

		/*
		 * t2 = new Thread(new moveShot()); t2.start(); long startTime =
		 * System.currentTimeMillis();
		 */
		// while (control.playerTherad.isAlive()) {
		
	}

	private static void initializeMenuButtons(Controller c) {
		c.menu.easyBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				c.gamingEngine.map.getMazeGenerator().setEasyLevel();
				c.menu.frmMainmenu.setVisible(false);
				initializeGame(c);
			}
		});
		c.menu.Option.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				c.option.setVisible(true);
			}
		});
		c.menu.normalBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				c.gamingEngine.map.getMazeGenerator().setNormalLevel();
				c.menu.frmMainmenu.setVisible(false);
				initializeGame(c);
			}
		});
		c.menu.Hard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				c.gamingEngine.map.getMazeGenerator().setHardLevel();
				c.menu.frmMainmenu.setVisible(false);
				initializeGame(c);
			}
		});
		c.option.back_BTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.option.setVisible(false);
			}
		});
	}
	private static void initializeGame(Controller c) {
		Interactables[][] maze = c.gamingEngine.map.getCharMaze();
		c.g = new SecondGUI();
		c.g.setarray(maze);
		c.g.gui.addKeyListener(c.keyLi);
		c.g.gui.setFocusable(true);
		c.g.draw();
		c.playerTherad.start();
		
		//while (!c.end) {
			/*try {
				c.playerTherad.join(27);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			// absorver update all
			//
		//}
	}
	
}

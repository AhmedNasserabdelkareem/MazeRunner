package PacManGit;


import java.util.ArrayList;

import Objects.Ammo;
import Objects.AmmoGift;
import Objects.FullBomb;
import Objects.HalfBomb;
import Objects.Health;
import Objects.Interactables;
import Objects.Player;
import Objects.Spirit;
import Objects.Stones;
import Objects.Tree;

public class GamingEngine {
	
	public Player player = new Player();
	public FlyWeight map = new FlyWeight();
	public Iterator CellIterator = new Iterator();
	private AmmoPool ammoPool = new AmmoPool();
// bassam iterator
	public int createAmmo() {
		// TODO Auto-generated method stub
		Ammo ammo =  ammoPool.create();
		int index = ammo.getOrderIndex();
		CellIterator.add(ammo);
		//get object from pool
		// int index = ammo.getIndex;
		// ammo.setIndexX(player.getIndexX());
		//	ammo.setIndexY(player.getIndexY());
	
		//bassam add
		
		//return index;
		return index;
	}
	public Ammo getAmmo(int ammoIndex) {
		// TODO Auto-generated method stub
		CellIterator.getInstance();
		while(CellIterator.hasNext()){
			Interactables c = CellIterator.next(); 
			if(c.getClass().getSimpleName().toString().equals("Ammo")){
				Ammo x = (Ammo) c;
				if(x.getOrderIndex()==ammoIndex){
					return x;
				}
				
			}
		}
		return null;
	}
	/*public char getAmmoNext(int iR, int jR) {
		// TODO Auto-generated method stub
		return 0;
	}*/
	public void actWithComponent (int i , int j){
		Interactables[][] x =map.getCharMaze();
		String c = x[i][j].getClass().getSimpleName().toString();
		if(c.equals("HalfBomb")){
			
		}else if (c.equals("FullBomb")){
			//player.setExistance(false);
			player.setSpirit(player.getSpirit()-2);
			player.setindexX(1);
			player.setindexY(1);
			player.setAmmo(6);
			player.setScore(0);
			player.setNewDirection("Stop");
			player.setOldDirection("Stop");
			player.setRotationDir("Stop");
		}else if (c.equals("Health")){
			player.setHealth(player.getHealth()+1);
		}else if (c.equals("Spirit")){
			player.setSpirit(player.getSpirit()+2);
		}else if (c.equals("Ammo")){
			player.setAmmo(player.getAmmo()+1);
		}else {
			
		}
		
	}
	public boolean isThereBlock(int iR, int jL) {
		// TODO Auto-generated method stub
		Interactables[][] x =map.getCharMaze();
		String c = x[iR][jL].getClass().getSimpleName().toString();
		//System.out.println(c + " "+iR+ " "+ jL );
		if(x[iR][jL].getClass().getSimpleName().toString().equals("Stones")||x[iR][jL].getClass().getSimpleName().toString().equals("Tree")){
			
			return true;
			
		}
		return false;
	}
	
	public boolean AmmoisDestroyed(int x, int y) {
		Interactables[][] xd = map.getCharMaze();
		String temp = xd[x][y].getClass().getSimpleName().toString();
		if (temp.equals("Spirit")) {
			Spirit flag = (Spirit) xd[x][y];
			flag.setExistance(false);
			map.setCharMaze(xd);
			return true;
		} else if (temp.equals("Tree")) {
			Tree flag = (Tree) xd[x][y];
			flag.setExistance(false);
			map.setCharMaze(xd);
			return true;
		} else if (temp.equals("HalfBomb")) {
			HalfBomb flag = (HalfBomb) xd[x][y];
			flag.setExistance(false);
			map.setCharMaze(xd);
			return true;
		} else if (temp.equals("FullBomb")) {
			FullBomb flag = (FullBomb) xd[x][y];
			flag.setExistance(false);
			map.setCharMaze(xd);
			return true;
		} else if (temp.equals("AmmoGift")) {
			AmmoGift flag = (AmmoGift) xd[x][y];
			flag.setExistance(false);
			map.setCharMaze(xd);
			return true;
		} else if (temp.equals("Stones")) {
			Stones flag = (Stones) xd[x][y];
			flag.setExistance(false);
			map.setCharMaze(xd);
			return true;
		} else if (temp.equals("Health")) {
			Health flag = (Health) xd[x][y];
			flag.setExistance(false);
			map.setCharMaze(xd);
			return true;
		} else {

			return false;
		}

	}
	
	
}

package PacManGit;

import Objects.Ammo;
import Objects.FullBomb;
import Objects.HalfBomb;
import Objects.Interactables;
import Objects.PathFree;
import Objects.Player;
import Objects.Spirit;
import Objects.Stones;
import Objects.Tree;


public class Observer {
	Player myPlayer = new Player();
	Interactables [][] interacArray ;
	SecondGUI gui = new SecondGUI();
	GamingEngine gamemaze = new GamingEngine();
	public Observer (Player x ){
		myPlayer = x;
	}
	
	
	void updateArray () {
		interacArray=gamemaze.map.getCharMaze();
		for(int i=0;i<interacArray.length;i++ ){
			for(int j=0;j<interacArray[0].length;j++){
				String temp =interacArray[i][j].getClass().getSimpleName().toString();
				if(temp.equals("Spirit")){
					Spirit flag = (Spirit) interacArray[i][j];
					if(flag.isExisted()==false){
						interacArray[i][j]= new PathFree();
						gamemaze.map.setCharMaze(interacArray);
						gui.updatArray(i, j);
					}

				}else if (temp.equals("Tree")){
					Tree flag = (Tree) interacArray[i][j];
					if(flag.isExisted()==false){
						interacArray[i][j]= new PathFree();
						gamemaze.map.setCharMaze(interacArray);
						gui.updatArray(i, j);
					}

				}else if (temp.equals("HalfBomb")){
					HalfBomb flag = (HalfBomb) interacArray[i][j];
					if(flag.isExisted()==false){
						interacArray[i][j]= new PathFree();
						gamemaze.map.setCharMaze(interacArray);
						gui.updatArray(i, j);
					}

				}else if (temp.equals("FullBomb")){
					FullBomb flag = (FullBomb) interacArray[i][j];
					if(flag.isExisted()==false){
						interacArray[i][j]= new PathFree();
						gamemaze.map.setCharMaze(interacArray);
						gui.updatArray(i, j);
					}

				}else if (temp.equals("Ammo")){
					Ammo flag = (Ammo) interacArray[i][j];
					if(flag.isExisted()==false){
						interacArray[i][j]= new PathFree();
						gamemaze.map.setCharMaze(interacArray);
						gui.updatArray(i, j);
					}

				}else if (temp.equals("Stones")){
					Stones flag = (Stones) interacArray[i][j];
					if(flag.isExisted()==false){
						interacArray[i][j]= new PathFree();
						gamemaze.map.setCharMaze(interacArray);
						gui.updatArray(i, j);
					}

				}
			/*	if(temp.equals("Spirit")|temp.equals("Tree")||temp.equals("HalfBomb")||temp.equals("FullBomb")||temp.equals("Ammo")){
					
					gui.updatArray(i, j);
				}*/
			}
		}
		
	}
	public int updateTime(){
		return myPlayer.getAmmo(); 
		
	}
	public int updateAmmo (){
		return myPlayer.getAmmo();
	}
	public int updateBlood (){
		return myPlayer.getHealth();
	}
	public int updateHealth (){
		return myPlayer.getSpirit();
	}
}

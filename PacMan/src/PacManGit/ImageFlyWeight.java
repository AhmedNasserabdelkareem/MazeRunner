package PacManGit;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import Objects.Interactables;

public class ImageFlyWeight {
	private ImageIcon bomb;
	private ImageIcon bigBomb;
	private ImageIcon tree;
	private  ImageIcon space;
	private ImageIcon wall;
	private ImageIcon gift;
	private ImageIcon fullHeart;
	private ImageIcon halfHeart;
	private ImageIcon ammo;
	private ImageIcon door;
	private static ImageFlyWeight obj = null;
	ArrayList<ImageIcon> playerleft;
	ArrayList<ImageIcon> playerright;
	ArrayList<ImageIcon> playerup;
	ArrayList<ImageIcon> playerdown;

	public static ImageFlyWeight getinstance() {
		if (obj == null) {
			obj= new ImageFlyWeight();
				}
	return obj;
	}

	private ImageFlyWeight() {
		wall = new ImageIcon("pictures\\wall.png");
		bomb = new ImageIcon("pictures\\bomb.png");
		bigBomb = new ImageIcon("pictures\\bigbomb.png");
		tree = new ImageIcon("pictures\\tree.png");
		space = new ImageIcon("pictures\\space.png");
		gift = new ImageIcon("pictures\\gift1.png");
		fullHeart = new ImageIcon("pictures\\FullHeart.png");
		halfHeart = new ImageIcon("pictures\\HalfHeart.png");
		ammo= new ImageIcon("pictures\\FireBall.png");
		door= new ImageIcon("pictures\\door.png");

		playerdown = new ArrayList<>();
		playerleft = new ArrayList<>();
		playerright = new ArrayList<>();
		playerup = new ArrayList<>();
		// System.out.println((System.getProperty("user.dir"))+"\\Resources\\left\\player2"
		// + 0 + ".png");
		for (int i = 0; i < 16; i++) {
			playerleft.add(new ImageIcon("Resources\\left\\player2" + i + ".png"));
		}
		for (int i = 0; i < 16; i++) {
			playerright.add(new ImageIcon("Resources\\right\\player1" + i + ".png"));
		}
		for (int i = 0; i < 16; i++) {
			playerup.add(new ImageIcon("Resources\\up\\player0" + i + ".png"));
		}
		for (int i = 0; i < 16; i++) {
			playerdown.add(new ImageIcon("Resources\\down\\player3" + i + ".png"));
		}
	}

	public ArrayList<ImageIcon> getImageIconList(String direction) {
		switch (direction) {
		case "Left":
			return playerleft;
		case "Right":
			return playerright;
		case "Up":
			return playerup;
		case "Down":
			return playerdown;
		default:
			return null;

		}
	}

	public ImageIcon getImageIcon(String type) {
		switch (type) {
		case "bomb":
			return bomb;
		case "tree":
			return tree;
		case "wall":
			return wall;
		case "bigBomb":
			return bigBomb;
		case "space":
			return space;
		case "gift":
			return gift;
		case "fullHeart":
			return fullHeart;
		case "halfHeart":
			return halfHeart;
		case "ammo":
			return ammo;
		case "door":
			return door;
		default:
			return null;
		}
	}
	public void setImageIcon(String type,String path) {
		switch (type) {
		case "bomb":
			bomb= new ImageIcon(path);
			break;
		case "tree":
			  tree= new ImageIcon(path);
				break;
		case "wall":
			  wall= new ImageIcon(path);
				break;
		case "bigBomb":
			  bigBomb= new ImageIcon(path);
				break;
		case "space":
			  space= new ImageIcon(path);
			  System.out.println(space);
				break;
		case "gift":
			  gift= new ImageIcon(path);
				break;
		case "fullHeart":
			  fullHeart= new ImageIcon(path);
				break;
		case "halfHeart":
			  halfHeart= new ImageIcon(path);
				break;
		case "ammo":
			  ammo= new ImageIcon(path);
				break;
		case "door":
			  door= new ImageIcon(path);
				break;
		default:
			  ;
		}
	}
}

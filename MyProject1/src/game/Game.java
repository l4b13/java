package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game extends JFrame implements Runnable{
	ArrayList<Unit> units = new ArrayList<>(); 
	ArrayList<Unit> slcUnits = new ArrayList<>();
	//ArrayList<Boolean> sUnits = new ArrayList<>(); 
	ArrayList<Wall> walls = new ArrayList<>(); 
	ArrayList<Weapon> weapons = new ArrayList<>();
	int col=14;
	int row=10;
	Area area = new Area(col, row);
	int left = 100;
	int top = 100;
	int sizeX = 50;
	int sizeY = 50;
	int selected=0;
	boolean isWork = true;
	@Override
	public void run() {
		while(isWork) {
			for (int _i = 0; _i < units.size(); _i++) {
				units.get(_i).tick();
				
				for	(int _j = 0; _j < weapons.size(); _j++) {
					if(units.get(_i).getX() == weapons.get(_j).getX() && units.get(_i).getY() == weapons.get(_j).getY()) {
						if(units.get(_i).getWeapon() == null) {
							units.get(_i).setWeapon(weapons.get(_j));
						}
					}
				}
				
				if (units.get(_i).getLife() <= 0) {
					if (slcUnits.contains(units.get(_i))) {
						slcUnits.remove(units.get(_i));
					}
					area.remove(units.get(_i).getX(), units.get(_i).getY());
					if (units.get(_i).getWeapon() != null) units.get(_i).dropWeapon();
					units.remove(units.get(_i));
				}
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
	}
	public static void main(String[] args) {
		Game game = new Game();
		new Thread(game).start();
	}
	public Game(){
		setBounds(0, 0, 1200, 800);
		setDefaultCloseOperation(2);
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getX()<left || e.getY()<top) {
					return;
				}
				//System.out.println(e.getX()+","+e.getY());
				int tx = (e.getX()-left)/sizeX;
				int ty = (e.getY()-top)/sizeY;
				if(!(tx>=0 && tx<col && ty>=0 && ty<row)) {
					return;
				}
				if(e.getButton()==1) {
					
					for (int _i = 0; _i < units.size(); _i++) {
						if(units.get(_i).getX()==tx & units.get(_i).getY()==ty) {
							//selected = _i;
							if(slcUnits.contains(units.get(_i))) {
								slcUnits.remove(units.get(_i));
							}else {
								slcUnits.add(units.get(_i));
							}
						}
					}
				}else if(e.getButton()==3){
					for (Unit unit : slcUnits) {
						unit.setTx(tx);
						unit.setTy(ty);
					}
				}
				repaint();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				for (Unit unit : slcUnits) {
					if(e.getKeyCode()==66) {
						unit.build();
					}else if(e.getKeyCode()==68) {
						unit.destroy();
					}else if(e.getKeyCode()==87) {
						unit.setAbilities(new WallAbilities(walls, area));
					}else if(e.getKeyCode()==69) {
						unit.setAbilities(new BlankAbilities());
					}else if(e.getKeyCode()==71) {
						unit.dropWeapon();
					}
				}
			}
		});
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				isWork = false;
			}
		});
		this.setVisible(true);
		UnitFactory unitFactory = new RookUnitFactory();
		units.add(unitFactory.createUnit(1,2,0));
		units.add(unitFactory.createUnit(4,3,0));
		units.add(unitFactory.createUnit(6,7,1));
//		units.add(new RookUnit(1,2,0));
//		units.add(new RookUnit(4,3,0));
//		units.add(new RookUnit(6,7,1));
		unitFactory = new DiagUnitFactory();
		units.add(unitFactory.createUnit(5,5,0));
//		units.add(new DiagUnit(5,5,0));
		unitFactory = new ElephUnitFactory();
		units.add(unitFactory.createUnit(6,5,1));
//		units.add(new ElephUnit(6,5,1));
		walls.add(new Wall(2,4));
		walls.add(new Wall(2,5));
		walls.add(new Wall(2,6));
		weapons.add(new Weapon(1,1,"??????",5));
		weapons.add(new Weapon(9,9,"???",15));
		//area.setUnits(units);
		//Abilities abil = new WallAbilities(walls, area);
		for (int _i = 0; _i < units.size(); _i++) {
			units.get(_i).setArea(area);
			units.get(_i).setAbilities(new BattleAbilities(units, area));
			units.get(_i).setScanner(new UnitScanner(units));
		}
		for (int _i = 0; _i < walls.size(); _i++) {
			walls.get(_i).setArea(area);
		}
		area.print();

	}
	@Override
	public void paint(Graphics g) {
		this.createBufferStrategy(2);
		BufferStrategy bs = this.getBufferStrategy();
		g = bs.getDrawGraphics();
		
		super.paint(g);
		paintWeapons(g);
		paintGrid(g);
		paintWalls(g);
		paintUnits(g);
		
		bs.show();
	}
	private void paintWalls(Graphics g) {
		for (int _i = 0; _i < walls.size(); _i++) {
			int cx = left+walls.get(_i).getX()*sizeX;
			int cy = top+walls.get(_i).getY()*sizeY;
			BufferedImage bi;
			try {
				bi = ImageIO.read(new File("wall.jpg"));
				g.drawImage(bi, cx, cy, sizeX, sizeY, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private void paintUnits(Graphics g) {
		for (int _i = 0; _i < units.size(); _i++) {
//			if(units.get(_i).getTx()>item.getX()) {
//				offset = 3;
//			}
			int cx = left+units.get(_i).getX()*sizeX;
			int cy = top+units.get(_i).getY()*sizeY;
			//g.setColor(Color.yellow);
			//g.fillArc(cx, cy, sizeX, sizeY, 45+units.get(_i).getDir()*90, 275);
//			BufferedImage bi;
//			try {
//				bi = ImageIO.read(new File("dragon0.png"));
//				g.drawImage(bi, cx, cy, sizeX, sizeY, null);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			SpriteSheet sheet = new SpriteSheet();
			g.drawImage(sheet.getBufferedImage(units.get(_i).getFrame(), units.get(_i).getTrend()), cx, cy, sizeX, sizeY, null);
			//g.fillArc(cx, cy, sizeX, sizeY, (8-units.get(_i).getTrend())*45+45, 90);
			g.setColor(Color.green);
			g.drawRect(cx, cy, 21, 5);
			if(units.get(_i).getCoalition()==0) {
				g.setColor(Color.red);
			}else {
				g.setColor(Color.blue);
			}
			g.fillRect(cx+1, cy+1, units.get(_i).getLife()/5, 4);
			g.setColor(Color.red);
			g.drawString(units.get(_i).getClass().getSimpleName(), cx, cy);
		}
		for (Unit unit : slcUnits) {
			g.setColor(Color.red);
			g.drawOval(left+unit.getX()*sizeX,
					top+unit.getY()*sizeY, sizeX, sizeY);
		}

	}
	private void paintGrid(Graphics g) {
		g.setColor(Color.red);
		for (int _i = 0; _i < col+1; _i++) {
			g.drawLine(left+_i*sizeX, top, left+_i*sizeX, left+row*sizeY);
		}
		g.setColor(Color.blue);
		for (int _i = 0; _i < row+1; _i++) {
			g.drawLine(left, top+_i*sizeY, left+col*sizeY, top+_i*sizeY);
		}		
	}
	private void paintWeapons(Graphics g) {
		for (int _i = 0; _i < weapons.size(); _i++) {
			int cx = left+weapons.get(_i).getX()*sizeX;
			int cy = top+weapons.get(_i).getY()*sizeY;
			BufferedImage bi;
			try {
				String wName = weapons.get(_i).getName();
				String wFileName = "";
				switch (wName) {
				case "???":
					wFileName = "Frostmourne.png";
					break;
				case "??????":
					wFileName = "Ace1.png";
					break;
				default:
					break;
				}
				bi = ImageIO.read(new File(wFileName));
				g.drawImage(bi, cx, cy, sizeX, sizeY, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

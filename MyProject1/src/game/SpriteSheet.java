package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class SpriteSheet extends JFrame{
	ArrayList<BufferedImage> frames = new ArrayList<BufferedImage>();
	private int sprNumber;
	public SpriteSheet() {
		BufferedImage img;
		try {
			img = ImageIO.read(new File("Dragon.png"));
			for(int _n=0; _n<5; _n++) {
				for(int _i=0; _i<6; _i++) {
					BufferedImage dragon = img.getSubimage(_n*img.getWidth()/5, _i*(img.getHeight()-32)/6,
							img.getWidth()/5, (img.getHeight()-32)/6);
					frames.add(dragon);
				}
			}
			sprNumber = frames.size();
			for(int _n=3; _n>0; _n--) {
				for(int _i=sprNumber*_n/5; _i<sprNumber*(_n+1)/5; _i++) {
					BufferedImage tempBi = new BufferedImage(img.getWidth()/5, (img.getHeight()-32)/6, BufferedImage.TYPE_INT_ARGB);
					Graphics g = tempBi.getGraphics();
					g.drawImage(frames.get(_i), 0+tempBi.getWidth(), 0, -tempBi.getWidth(), tempBi.getHeight(), null);
					frames.add(tempBi);
				}
			}
			sprNumber = frames.size();
			//System.out.println(sprNumber);
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public BufferedImage getBufferedImage(int row, int col) {
		int sprRow = sprNumber/8;
		int index = col*sprRow+row;
		return frames.get(index);
	}
	/*проверочная часть*/
	public static void main(String[] args) {
		SpriteSheet sheet = new SpriteSheet();
		sheet.setBounds(0,0,1200,800);
		sheet.setDefaultCloseOperation(2);
		sheet.setVisible(true);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(int _i=0; _i<sprNumber; _i++) {
			g.drawImage(frames.get(_i), _i*35, 100, 35, 35, null);
			g.drawImage(getBufferedImage(_i/5,_i%5), _i*35, 200, 35, 35, null);
		}
	}
}

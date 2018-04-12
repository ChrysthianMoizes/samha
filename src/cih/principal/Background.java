package cih.principal;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Background extends JPanel{

    String image = "";
    
    public Background() {
        
    }
    
    public Background(String image) {
        this.image = image;
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D gr = (Graphics2D) g.create();
        
        try{
            BufferedImage buffer = ImageIO.read( new File(image));
            gr.drawImage(buffer, null, 0, 0);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

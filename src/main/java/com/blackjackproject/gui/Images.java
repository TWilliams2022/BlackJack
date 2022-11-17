package com.blackjackproject.gui;

import javax.swing.*;
import java.awt.*;

public class Images extends JPanel {

    private final Image image;


    public Images(String img){
        this.image = new ImageIcon(img).getImage();
        Dimension size = new Dimension(image.getWidth(null),image.getHeight(null));
        setSize(size);
        setLayout(null);

    }

    @Override
    public void paintComponent(Graphics g){
        g.drawImage(image,0,0,this.getWidth(),this.getHeight(),null);

    }

}

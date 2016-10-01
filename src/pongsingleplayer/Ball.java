/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pongsingleplayer;

import java.awt.Graphics2D;
import java.util.Random;

/**
 *
 * @author Dad
 */
public class Ball {
    Random random = new Random();
    float x;
    float y;
    int radius = 10;
    float direction;
    int speed;
    
    public void render(Graphics2D g2d){
        g2d.fillOval((int)x, (int)y, radius*2, radius*2);
    }
    
    public void update(){
        x += speed * Math.cos(direction);
        y += speed * Math.sin(direction);
    }
    
    public void start(){
        speed = 3;
        changeDirection();
    }
    
    public void changeDirection(){
        direction = random.nextFloat()*(float)Math.PI;
        System.out.println("direction:" + direction);
    }
    
    public void changeNegativeDirection(){
        direction = -random.nextFloat()*(float)Math.PI;
        System.out.println("direction:" + direction);
    }

    public int getX() {
        return (int)x;
    }

    public int getY() {
        return (int)y;
    }

    public int getRadius() {
        return radius;
    }
    
}

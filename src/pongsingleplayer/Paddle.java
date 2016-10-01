/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pongsingleplayer;

import java.awt.Graphics2D;

/**
 *
 * @author Dad
 */
public class Paddle {
    private int length = 75;
    private int height = 20;
    private int x;
    private int y = PongSinglePlayer.SIZE - 100;
    
    public void render(Graphics2D g2d){
        g2d.fillRect(x, y, length, height);
    }
    
    public void update(GameKeyAdapter gameKeyAdapter){
        if(gameKeyAdapter.left){
            if(x > 0)
                x -= 2;
        }
        if(gameKeyAdapter.right){
            if(x + length < PongSinglePlayer.SIZE)
                x += 2;
        }
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pongsingleplayer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Dad
 */
public class GamePanel extends JPanel implements ActionListener{
    GameKeyAdapter gameKeyAdapter = new GameKeyAdapter();
    Paddle paddle;
    Ball ball;
    int score;
    boolean gameOver;
    boolean justHit;

    public GamePanel(){
        paddle = new Paddle();
        ball = new Ball();
        ball.start();
        
        Timer timer = new Timer(25, this);
        timer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        paddle.render(g2d);
        ball.render(g2d);
        g2d.drawString("score:" + Integer.toString(score), 20, 20);
        if(gameOver){
            g2d.drawString("Game over!", PongSinglePlayer.SIZE/2, PongSinglePlayer.SIZE/2);
            g2d.drawString("press right arrow to start again", PongSinglePlayer.SIZE/2, PongSinglePlayer.SIZE/2 + 50);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        update();
        if(!gameOver){
            paddle.update(gameKeyAdapter);
            ball.update();
        }
    }
    
    public void update(){
        if(gameOver && gameKeyAdapter.right){
            ball.x = 0;
            ball.y = 0;
            score = 0;
            gameOver = false;
        }
        
        if(ball.getX() < 0){
            ball.x = 0;
            if(!justHit)
                ball.changeDirection();
            else 
                ball.changeNegativeDirection();
        }
        if(ball.getX() + ball.getRadius()*2 > PongSinglePlayer.SIZE){
            ball.x = PongSinglePlayer.SIZE - ball.getRadius()*2;
            if(!justHit)
                ball.changeDirection();
            else 
                ball.changeNegativeDirection();
        }
        if(ball.getY() < 0){
            ball.y = 0;
            ball.changeDirection();
            score++;
            justHit = false;
        }
        if(ball.getX() + ball.getRadius()*2 >= paddle.getX() && ball.getX() <= paddle.getX() + paddle.getLength()
                && ball.getY() + ball.getRadius()*2 >= paddle.getY() && ball.getY() <= paddle.getY()){
            ball.changeNegativeDirection();
            justHit = true;
        }
        if(ball.getY() > PongSinglePlayer.SIZE){
            gameOver = true;
        }
    }
}


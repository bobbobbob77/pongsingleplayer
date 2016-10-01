/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pongsingleplayer;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Dad
 */
public class PongSinglePlayer extends JFrame{
    public static final int SIZE = 500;
    public PongSinglePlayer(){
        init();
    }
    
    public void init(){
        GamePanel gamePanel = new GamePanel();
        add(gamePanel);
        addKeyListener(gamePanel.gameKeyAdapter);
        
        setResizable(false);
        pack();
        
        setFocusable(true);
        setTitle("Pong Single Player");
        setSize(SIZE, SIZE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                JFrame pongSinglePlayer = new PongSinglePlayer();
                pongSinglePlayer.setVisible(true);
            }
            
        });
    }
    
}

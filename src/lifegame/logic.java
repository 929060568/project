package lifegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;  

import javax.swing.JPanel;

public class logic extends JPanel{
 protected int world[][]={{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
 protected int[][] nextStatus = new int[world.length][world[0].length];  
 
 protected int[][] tempStatus = new int[world.length][world[0].length];  
 private int DELAY_TIME=500;
 private int h=30;
 private int w=30;
private Timer timer;
public logic() {
	 for (int row = 0; row < world.length; row++) {  
	        for (int col = 0; col < world[0].length; col++) {  
	            nextStatus[row][col] = world[row][col];  
	            tempStatus[row][col] = world[row][col];  
	        }  
	    }  
	Graphics g = null;
	this.paintComponents(g);
}
protected void paintComponent(Graphics g) {
	 super.paintComponent(g);
	 g.setColor(Color.BLACK);
	 for(int i=0;i<world.length;i++)
		 for(int j=0;j<world[0].length;j++) {
			 if(tempStatus[i][j]==0)
				 g.fillRect(j*w, i*h, w,h );
			 else {
				 g.drawRect(j*w, i*h, w,h );
			 }
		 }
		 }
public void changeCellstatus() {
	 for (int row = 0; row < nextStatus.length; row++) {  
         for (int col = 0; col < nextStatus[row].length; col++) {  
               switch(neiborCellnum(row,col)) {
               case 0:  
               case 1:  
               case 4:  
               case 5:  
               case 6:  
               case 7:  
               case 8:  
                   nextStatus[row][col] = 0;  
                   break;  
               case 2:  
                   nextStatus[row][col] = tempStatus[row][col];  
                   break;  
               case 3:  
                   nextStatus[row][col] = 1;  
                   break;  
               }
         }  
     }  
}

public int neiborCellnum(int row,int col) {
   int r,c;int count=0;
    for (r = row - 1; r <= row + 1; r++) {  
        for (c = col - 1; c <= col + 1; c++) {  
            if (r < 0 || r >= tempStatus.length || c < 0  
                    || c >= tempStatus[0].length) {  
                continue;  
            }  
            if (tempStatus[r][c] == 1) {  
                count++;  
            }  
        }  
    }  
    if(tempStatus[row][col]==1) 
    	count--;
    return count;
}
public void startAnimation() {  
   
    // 创建计时器  
    timer = new Timer(DELAY_TIME, new ActionListener() {  
    	  
        @Override  
        public void actionPerformed(ActionEvent e) {  
            changeCellstatus();  
            copyWorldMap();
            repaint();   
        }  
    });  
    // 开启计时器  
    timer.start();  
}  
public void copyWorldMap() {  
     for (int row = 0; row < nextStatus.length; row++) {  
         for (int col = 0; col < nextStatus[row].length; col++) {  
             tempStatus[row][col] = nextStatus[row][col];  
         }  
     }  
 }  
 }


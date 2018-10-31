package lifegame;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class lifegame {
	private JFrame frame;
    private JButton sbutton;
    private logic logic=new logic();;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lifegame window = new lifegame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public lifegame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frame = new JFrame();
        sbutton=new JButton("¿ªÊ¼");
        sbutton.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent arg0) {
        		logic.startAnimation();
        	}
        });
        sbutton.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
        sbutton.setBounds(173,613,200,30);
		frame.setBounds(100, 100, 600,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        frame.getContentPane().add(sbutton);
		JPanel panel1=new JPanel();
		panel1.setBounds(0, 0, 582, 600);
		frame.getContentPane().add(panel1);
		panel1.setLayout(new BorderLayout(0, 0));
		panel1.add(logic);
	}
}

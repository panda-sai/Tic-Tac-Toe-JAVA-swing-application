import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GameGUI implements ActionListener
{
	JFrame f;
	int count;
int coins;// added this to check git tutorial
	String player1;
	String player2;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	JButton b7;
	JButton b8;
	JButton b9;
	JTextField tf;
	
	GameGUI()
	{
		count=0;
		f= new JFrame("Tic Tac Toe");
		//f.setDefaultCloseOpertion(f.EXIT_ON_CLOSE);
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(3,3));
		
		player1=JOptionPane.showInputDialog(f,"Enter Player-X Name"); 
		player2=JOptionPane.showInputDialog(f,"Enter Player-O Name");
		
		b1 = new JButton(" ");
		b1.addActionListener(this);
		b2 = new JButton(" ");
		b2.addActionListener(this);
		b3 = new JButton(" ");
		b3.addActionListener(this);
		b4 = new JButton(" ");
		b4.addActionListener(this);
		b5 = new JButton(" ");
		b5.addActionListener(this);
		b6 = new JButton(" ");
		b6.addActionListener(this);
		b7 = new JButton(" ");
		b7.addActionListener(this);
		b8 = new JButton(" ");
		b8.addActionListener(this);
		b9 = new JButton(" ");
		b9.addActionListener(this);
		
		grid.add(b1);
		grid.add(b2);
		grid.add(b3);
		grid.add(b4);
		grid.add(b5);
		grid.add(b6);
		grid.add(b7);
		grid.add(b8);
		grid.add(b9);
		
		tf= new JTextField(player1+", its your turn");
		
		JPanel main = new JPanel();
		main.setLayout(new GridLayout(2,1));
		
		main.add(tf);
		main.add(grid);
		
		f.setSize(750,750);
		f.add(main);
		f.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JButton clicked = (JButton)e.getSource();
		
		
		
		if(count%2==0)
		{
			
			tf.setText(player2+", its your turn");
			if(clicked.getText().equals(" "))
			{
				clicked.setText("X");
				count++;
				
				if(getWinner()==true)
				{
					JOptionPane.showMessageDialog(f,"Congratulations "+player1+", you have won the match in "+count+" moves.\nIts treat time!!!");
					f.setVisible(false);
				}
				
				if(count>=9)
				{
					JOptionPane.showMessageDialog(f,"Its a DRAW MATCH\nWell played guys");	
					f.setVisible(false);
				}
				
			}
			else
			{
				JOptionPane.showMessageDialog(f,"Block Already Selected");
			}
		}
		else if(count%2!=0)
		{
			tf.setText(player1+", its your turn");
			if(clicked.getText().equals(" "))
			{
				clicked.setText("O");
				count++;
				
				if(getWinner()==true)
				{
					JOptionPane.showMessageDialog(f,"Congratulations "+player2+", you have won the match in "+count+" moves.\nIts treat time!!!");
					f.setVisible(false);
				}
				
				if(count>=9)
				{
					JOptionPane.showMessageDialog(f,"Its a DRAW MATCH\nWell played guys");	
					f.setVisible(false);
				}
				
			}
			else
			{
				 JOptionPane.showMessageDialog(f,"Block Already Selected");
			}
		}
	}
	
	public boolean getWinner()
	{
		if(b1.getText().equals(b4.getText()) && b4.getText().equals(b7.getText()) && !(b1.getText().equals(" ")))
		{
			return true;
		}
		if(b2.getText().equals(b5.getText()) && b5.getText().equals(b8.getText()) && !(b2.getText().equals(" ")))
		{
			return true;
		}
		if(b3.getText().equals(b6.getText()) && b6.getText().equals(b9.getText()) && !(b3.getText().equals(" ")))
		{
			return true;
		}
		if(b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText()) && !(b1.getText().equals(" ")))
		{
			return true;
		}
		if(b4.getText().equals(b5.getText()) && b5.getText().equals(b6.getText()) && !(b4.getText().equals(" ")))
		{
			return true;
		}
		if(b7.getText().equals(b8.getText()) && b8.getText().equals(b9.getText()) && !(b8.getText().equals(" ")))
		{
			return true;
		}
		if(b1.getText().equals(b5.getText()) && b5.getText().equals(b9.getText()) && !(b1.getText().equals(" ")))
		{
			return true;
		}
		if(b3.getText().equals(b5.getText()) && b5.getText().equals(b7.getText()) && !(b3.getText().equals(" ")))
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	
	public static void main(String args[])
	{
		new GameGUI();
		
	}	
	
}
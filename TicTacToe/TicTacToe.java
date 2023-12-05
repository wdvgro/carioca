import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class TicTacToe implements ActionListener {
    private JFrame frame;
    JPanel west = new JPanel();
    JPanel east = new JPanel();
    JPanel south = new JPanel();
    JPanel ttt = new JPanel();
    Random random = new Random();
    JLabel textfield = new JLabel();
    JPanel title_panel = new JPanel();
    JButton[] buttons = new JButton[9];
    JButton rbutton = new JButton("return");
    LineBorder border = new LineBorder(Color.BLACK,2);
    LineBorder pborder = new LineBorder(new Color(174,129,40),40);
    boolean player1_turn;

    public TicTacToe() {
        initialize();
    }

    public void initialize(){
        frame = new JFrame();
        this.frame.setTitle("Tic-Tac-Toe");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
        this.frame.setBackground(new Color(244,177,47));

		textfield.setForeground(new Color(250,250,250));
        textfield.setBackground(new Color(244,177,47));
		textfield.setFont(new Font("Ink Free",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
        title_panel.setBackground(new Color(244,177,47));
        
        rbutton.setPreferredSize(new Dimension(200,70));
        rbutton.setForeground(Color.WHITE);
        rbutton.setBackground(Color.BLUE);
        rbutton.setFont(new Font("Arial",Font.BOLD, 32));
        west.add(rbutton);
        west.setLayout(new FlowLayout(FlowLayout.LEFT,80,5));
        west.setBackground(new Color(244,177,47));
        east.setLayout(new FlowLayout(FlowLayout.LEFT,80,5));
        east.setBackground(new Color(244,177,47));
        south.setLayout(new FlowLayout(FlowLayout.LEFT,40,15));
        south.setBackground(new Color(244,177,47));
        ttt.setLayout(new FlowLayout(FlowLayout.TRAILING,10,10));
        ttt.setLayout(new GridLayout(3,3));
		ttt.setBackground(new Color(150,150,150));

        title_panel.add(textfield);
        ttt.setBorder(pborder);
        ttt.setPreferredSize(new Dimension(200,200));
        this.frame.add(south, BorderLayout.SOUTH);
        this.frame.add(west, BorderLayout.WEST);
        this.frame.add(east, BorderLayout.EAST);
        this.frame.add(title_panel,BorderLayout.NORTH);
        this.frame.add(ttt,BorderLayout.CENTER);
        this.frame.setVisible(true);

        for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			ttt.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,100));
            buttons[i].setBorder(border);
            buttons[i].setPreferredSize(new Dimension(20,20));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
        

        
    }    

    @Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1_turn=false;
						textfield.setText("O turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1_turn=true;
						textfield.setText("X turn");
						check();
					}
				}
			}			
		}
	}
    public void firstTurn() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("X turn");
		}
		else {
			player1_turn=false;
			textfield.setText("O turn");
		}
	}

    public void check() {
		//check X win conditions
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
			xWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			xWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			xWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(2,4,6);
		}
		//check O win conditions
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			oWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			oWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			oWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(2,4,6);
		}
	}
	
	public void xWins(int a,int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X wins");
        
	}
	public void oWins(int a,int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O wins");
        
	}
}

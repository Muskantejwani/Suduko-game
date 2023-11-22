package Hii;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Panal extends JPanel implements ActionListener {
    Suduko game;
    static JTextField[][] cells;
    JPanel[][] paneles;
     JPanel center, bPanel;
    JButton start,solve,check,exit;
    int score=0;
    int[][] temp = new int[9][9];
    int[][] matrices = new int[9][9];
    public JTextField newtextfield() {
        JTextField j = new JTextField("");
        j.setFont(new Font(Font.DIALOG, Font.TYPE1_FONT, 20));
      j.setHorizontalAlignment(JTextField.CENTER);      
     return j;    
    }
    public Panal() {
        center = new JPanel();  //main panel
        center.setLayout(new GridLayout(3, 3)); 
        setLayout(new BorderLayout());
        add(center);  //add main panel to frame 
         
        cells = new JTextField[9][9];
        paneles = new JPanel[3][3];   
        for (int i=0; i<3; i++) {
        for (int j=0; j<3; j++) {
        paneles[i][j] = new JPanel();
        paneles[i][j].setLayout(new GridLayout(3, 3));
        center.add(paneles[i][j]);
}}
        for (int j=0; j<9; j++) {
        for (int i=0; i<9; i++) {
       cells[j][i] = newtextfield();
       
        //if fm remainder is greater than 0 than it ++ b/c grid has already a num and we can only add textfield
        //where number is zero
       int fm = (j+1)/3;
        if ((j+1)%3>0) {
        fm++;
}
        int cm = (i+1)/3;
        if ((i+1)%3>0) {
        cm++;
 }
      paneles[fm-1][cm-1].add(cells[j][i]);   //add cells to panel 
}}       
        bPanel = new JPanel();    
        bPanel.setBackground(Color.pink);
        bPanel.setLayout(new GridLayout(8, 8, 8, 3));       
       check = new JButton("Check Game");
        check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               for (int i = 0; i < 9; i++) {
               for (int j = 0; j < 9; j++) {
          if (!cells[i][j].isEditable()) {
          continue;
           } else if (cells[i][j].getText().equals(String.valueOf(matrices[i][j]))){
           cells[i][j].setBackground(Color.green);
         } else if (cells[i][j].getText().isEmpty()) {
           cells[i][j].setBackground(Color.WHITE);
       ////  continue;
          } else {
          cells[i][j].setBackground(Color.red);
  }}}
}});
        exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }});
        start = new JButton("start");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               restgame();
                Suduko.setlevel(2);
                Suduko.newGame();
                }
        });
       
        solve = new JButton("  solve ");
        solve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
            cells[i][j].setText(String.valueOf(matrices[i][j]));
}}}});
        bPanel.add(start);   
       //add new game button to 
        
        bPanel.add(check);        
        bPanel.add(solve);
        bPanel.add(exit); 
        add(bPanel, "East");         
    }
    public void setarray(int[][] matrices, int[][] temp) {
        for (int i=0; i<9; i++) {
        for (int j=0; j<9; j++) {
        this.temp[i][j] = temp[i][j];
        this.matrices[i][j] = matrices[i][j];
}}}
    public void setTextLable() {
        for (int i=0; i<9; i++) {
        for (int j=0; j<9; j++) {
       if (this.temp[i][j]!=0) {
      cells[i][j].setText(String.valueOf(this.temp[i][j]));
      cells[i][j].setEditable(false);
      cells[i][j].setBackground(Color.yellow);
} else {
    cells[i][j].setText("");
}        
}}}
    public static void restgame() {
   for (int i = 0; i < 9; i++) {
    for (int j = 0; j < 9; j++) {
    cells[i][j].setEditable(true);
  cells[i][j].setBackground(Color.WHITE);
}}}
    public void actionPerformed(ActionEvent e) {
         Suduko.setlevel(2);
         Suduko.newGame();
    }}

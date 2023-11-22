package Hii;
import java.util.*;
import javax.swing.JFrame;
public class Suduko extends JFrame{
   static JFrame f=new JFrame();
   static Panal p;
      static int[][] matrices;
    static int[][] temp;
    static Random ran = new Random();
    static int l=1;
   int score = 0;
    public static void main(String[] args) {       
        matrices = new int[9][9];
        temp = new int[9][9];
        f.setResizable(false);
        f.setSize(800, 700);
        f.setTitle("Suduko Game");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       p = new Panal();
       f.setContentPane(p);
        f.setVisible(true);
    }
    public static void newGame() {
        int k = 0;
        ArrayList<Integer> randomnum = rannum();       
        for (int i=0; i<9; i++) {
        for (int j=0; j<9; j++) {
        matrices[i][j] = 0;
      if (((j+2)%2)==0 && ((i+2)%2)==0) {
       matrices[i][j] = randomnum.get(k);
       k++;
       if (k==9) {
       k=0;                     
}
                ////  System.out.println(matrices[i][j]);
}}}
  if (search(matrices)) {
 }         
      int rann = ran.nextInt(l);  
        int c=0;
        for (int i=0; i<9; i++) {
        for (int j=0; j<9; j++) {
        temp[i][j] = 0;
        //if c is less (zero) than rann so that numbers not show b/c these are textlabel
      if (c<rann) {
            c++;
            continue;
}
       else {
      rann = ran.nextInt(l);
    c=0;
   // the numbers that are visible store in temp here
    temp[i][j]=matrices[i][j];
}}}      
       p.setarray(matrices, temp);
        p.setTextLable();
    }
    public static int[][] freeelements(int[][] matrices) {
        int cellsno=0;
        for (int i=0; i<9; i++) {
        for (int j=0; j<9; j++) {
        if (matrices[i][j]==0) {
        // total numbers without even colomns 0 cells can be=36
         cellsno++;
}}}
        int[][] freeindexes=new int[cellsno][2];
        int count=0;
        for (int i=0; i<9; i++) {
        for (int j=0; j<9; j++) {
        if (matrices[i][j] == 0) {              	
         freeindexes[count][0] = i;
         freeindexes[count][1] = j;
           count++;               
}}}
        return freeindexes;
}
   public static boolean search(int[][] matrices) {
        int[][] freeindexes = freeelements(matrices);
        int k=0;
        boolean found = false;
           while (!found) {
            //get free element one by one
            int i = freeindexes[k][0];
            int j = freeindexes[k][1];
            // if element equal 0 give 1 to first test
            if (matrices[i][j] == 0) {
                matrices[i][j] = 1;
}
            // now check 1 if is avaible
            if (isSafe(i, j, matrices)) {
                //if free is equal k = board sloved
               if (k+1 == freeindexes.length) {
              found=true;
            } else {
            k++;
}}
            else if (matrices[i][j] < 9) {
            matrices[i][j] = matrices[i][j] + 1;
 } 
            //now if element value eqaule 9 backtrack to later element
            else {
           while (matrices[i][j] == 9) {
         matrices[i][j] = 0;   
                 //to see if k reach 0 index so its decrement goes false
            if (k == 0) {
            return false;
   }
          k--; //backtrack to later element
      i = freeindexes[k][0];
       j = freeindexes[k][1];
  }
         matrices[i][j] = matrices[i][j]+1;
            }}
        return true;
    }
    public static boolean isSafe(int i, int j, int[][] matrix) {
        // Check   row
        for (int column=0; column<9; column++) {
        if (column!=j && matrix[i][column] == matrix[i][j]) {
        return false;
}}
        // Check  column
        for (int row=0; row<9; row++) {
       if (row!=i && matrix[row][j] == matrix[i][j]) {
       return false;
}}
        // Check matrix
        for (int row=(i/3)*3; row<(i/3)*3+3; row++) {//      i=5 ,j=2   || row =3  col=0   ||i=3  j=0
        for (int col=(j/3)*3; col<(j/3)*3+3; col++) {
        if (row!=i && col != j && matrix[row][col] == matrix[i][j]) {
        return false;
}}}
        return true;
}
    public static ArrayList<Integer> rannum() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (Integer i=1; i<10; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;
    }
    public static void setlevel(int lev) {
        l = lev;
    }
}



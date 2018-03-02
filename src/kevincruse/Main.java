package kevincruse;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        final int ROWS=20;
        final int COLUMNS=5;
        double[][]scores=new double[ROWS][COLUMNS];
        String[]names=new String[ROWS];
        int position=0;
        int c=0;
        int r=0;
        String mystring="",line=null;
        FileInputStream fis=new FileInputStream("C:\\Users\\kevin\\OneDrive\\Documents\\bowlers2.txt");
        BufferedReader br=new BufferedReader(new InputStreamReader(fis));
        for(r=1;r<=10;r++) {
            line=br.readLine();
            names[r]=line;
            for(c=1;c<=3;c++) {
                line=br.readLine();
                scores[r][c]=Integer.valueOf(line); //readline returns a str, so we needed to convert to int
            }
        }
        br.close();
        for(r=1;r<=10;r++) {
            System.out.printf("%20s",names[r]);
            for(c=1;c<=3;c++) {
                System.out.printf("%10.0f",scores[r][c]);
            }
            System.out.println();
        }
    }
}
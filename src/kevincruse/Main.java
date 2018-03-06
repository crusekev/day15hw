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
        FileInputStream fis=new FileInputStream("C:\\Users\\kevin\\OneDrive\\Documents\\grades.txt");
        BufferedReader br=new BufferedReader(new InputStreamReader(fis));
        for(r=1;r<=7;r++) {
            line=br.readLine();
            names[r]=line;
            for(c=1;c<=3;c++) {
                line=br.readLine();
                scores[r][c]=Integer.valueOf(line); //readline returns a str, so we needed to convert to int
            }
        }
        br.close();
        for(r=1;r<=7;r++) {
            System.out.printf("%-20s",names[r]);
            for(c=1;c<=3;c++) {
                System.out.printf("%-10.0f",scores[r][c]);
            }
            System.out.println();
        }
        for(r=1;r<=7;r++) { //change 7s to 10s for hw
            for(c=1;c<=3;c++) {
                scores[r][4]=scores[r][4]+scores[r][c];
            }
            scores[r][4]=scores[r][4]/3.0;
        }
        for(r=1;r<=7;r++) {
            System.out.printf("%-20s",names[r]);
            for(c=1;c<=4;c++) {
                System.out.printf("%-10.0f",scores[r][c]);
            }
            System.out.println();
        }
        System.out.println("\n");
        names[8]="Exam Average"; //11 for hw
        for(c=1;c<=3;c++) {
            for(r=1;r<=7;r++) {
                scores[8][c]=scores[8][c]+scores[r][c]; //8 needs to be 11 for hw
            }
            scores[8][c]=scores[8][c]/7.0;
        }
        for(r=1;r<=8;r++) {
            System.out.printf("%-20s",names[r]);
            for(c=1;c<=4;c++) {
                //possibly make the averages double here
                if(r==8&&c==4) {
                    break;
                }
                System.out.printf("%10.0f",scores[r][c]);
            }
            System.out.println();
        }
        //column 4 should be double bc its average and the last row as well
        double lowest=101.0; //301.0 for hw
        String lowname="";
        for(r=1;r<=7;r++) {
            //just looking at averages here
            if(scores[r][4]<lowest) {
                lowest=scores[r][4];
                lowname=names[r];
            }
        }
        System.out.printf("%.2f was made by %2s \n",lowest,lowname);
        double highest=-1.0; //for hw scores
    }
}
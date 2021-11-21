package com.company;

import java.util.Scanner;

public class Spiller {
    int spillerForm = 7; //det her er dyrets form paa boardet
    int currentColumn;
    int currentRow;
    int spillerPosition;
    int spillerID;
    int columnMove;
    int rowMove;
    int ryk = 1;

    //private static String tast = new String(new char.replace("\0", "-"); //Erstatter ordet med tegnet -

    void spillerID() {
        spillerPosition = currentRow + currentColumn;
    }
    void myPosition() {
        System.out.println("Spiller position" + spillerPosition + " currentrow: " + currentRow + " currentcolumn:  " + currentColumn);
    }

    /*void move() {
        Scanner s = new Scanner(System.in);
        Gameboard g = new Gameboard();
        String brugerInput = s.next();
        if (brugerInput.equals("w")){
            op();
        } else if (brugerInput.equals("s")){
            ned();
        } else if (brugerInput.equals("d")){
            højre();
        } else if (brugerInput.equals("a")){
            venstre();
        }
    }*/

    /*void moveSpiller(){
        Scanner s = new Scanner(System.in);
        String brugerInput = s.next();
        Gameboard g = new Gameboard();
        if (brugerInput.equals("w")){
            op();
            g.gameBoardArray[rowMove][columnMove] = 5;
            System.out.println("Det virker");
        } else if (brugerInput.equals("s")){
            ned();
            g.gameBoardArray[rowMove][columnMove] = 5;
        } else if (brugerInput.equals("d")){
            højre();
            g.gameBoardArray[rowMove][columnMove] = 5;
        } else if (brugerInput.equals("a")){
            venstre();
            g.gameBoardArray[rowMove][columnMove] = 5;
        }
    }*/


    void venstre() {
        rowMove = currentRow;
        columnMove = currentColumn - ryk;
    }

    void højre() {
        rowMove = currentRow;
        columnMove = currentColumn + ryk;
    }

    void op(){
        columnMove = currentColumn;
        rowMove = currentRow + ryk;
    }
    void ned(){
        columnMove = currentColumn;
        rowMove = currentRow + ryk;
    }

}


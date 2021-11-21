package com.company;


import java.util.Random;
import java.util.Scanner;

public class Gameboard {
    int rows;
    int columns;
    int[][] gameBoardArray;
    int obstacles;
    int forsøg = 10;
    Dyr[] dyrArray;
    int animals;
    int liveAnimals;
    Boolean isTaken;
    Spiller[] spillerArray;



    void setup() {
        gameBoardArray = new int[rows][columns]; //nye variable af typen int som er array som er i 2 dimensioner = dimensionerne rows og columss (x og y)
        //liveAnimals = animals; //liveanimals er = det antal dyr som der er blevet defineret i main
        for (int row = 0; row < gameBoardArray.length; row++) //for hver raekke 0-5 bygger vi 0-5 kolonner
        {
            for (int col = 0; col < gameBoardArray[row].length; col++) //danner kolonner pr raekker ved næste række op til linje 10 igen (excel)
            {
                gameBoardArray[row][col] = 0; //Bestemmer hvilket nummer arrayet skal indeholde.
            }
        }
        placeObstacles();
        placeSpiller();
        placeAnimals();

    }

    void draw(){
        System.out.println("Tegner nyt board");
        for (int row = 0; row < gameBoardArray.length; row++) //for hver raekke 0-5 bygger vi 0-5 kolonner
        {
            for (int col = 0; col < gameBoardArray[row].length; col++) //danner kolonner pr raekker ved næste række op til linje 10 igen (excel)
            {
                System.out.print(gameBoardArray[row][col]); //printer forloop, det vi ser
            }
            System.out.println(); //linje mellemrum
        }
        moveSpiller();
    }

    //Placerer forhindringer
    void placeObstacles(){
        Random r = new Random();
        for (int o = 0; o < obstacles; o++) {
            int obstacleRow = r.nextInt(rows);
            int obstacleColumn = r.nextInt(columns);
            gameBoardArray[obstacleRow][obstacleColumn] = 5; //Bestemer symbolet på obstacle
        }

    }

    void placeAnimals() {
        Random r = new Random();
        dyrArray = new Dyr[animals];

        for (int o = 0; o < dyrArray.length; o++) {
            //animals skal placeres random i vores boardgame
            int animalRow = r.nextInt(rows); //formel/ her findes random placering mellem 1 og rows
            int animalColumn = r.nextInt(columns); //her findes random kolonne mellem 1 og columns
            gameBoardArray[animalRow][animalColumn] = 1; //Symbolet på

            isOccupied(animalRow, animalColumn);
            if (isTaken == false) { //hvis feltet ikke er taget sa kan der godt placeres et dyr
                gameBoardArray[animalRow][animalColumn] = 1; //vi kan kun placere et dyr hvis der ikke var noget i feltet//definerer dyr som 1

                //Nyt dyr
                Dyr nytDyr = new Dyr();
                nytDyr.myId = o;
                nytDyr.currentColumn = animalColumn;
                nytDyr.currentRow = animalRow;
                nytDyr.myPosition();
                dyrArray[o] = nytDyr;

            } else {
                liveAnimals -= 1;
                dyrArray[o] = null;
            }
        }

    }

    void isOccupied(int r, int c) { //viser om der er plads på row and/or columns
        if (gameBoardArray[r][c] == 0) { //hvis der står 4 så er der optaget
            isTaken = false; //false pladsen er fri
        } else {
            isTaken = true; //true pladsen er optaget

        }
    }

    void placeSpiller(){
        Spiller s = new Spiller();
        s.spillerPosition = gameBoardArray[3][3];
        System.out.println("Spillerpos er 3,3");
        gameBoardArray[3][3] = s.spillerForm;
    }


    void moveSpiller(){
            Scanner s = new Scanner(System.in);
            String brugerInput = s.next();
            Spiller g = new Spiller();
            spillerArray = new Spiller[5];
        for (int o = 0; o < spillerArray.length; o++) {
            //animals skal placeres random i vores boardgame
            int spillerRow = g.currentRow; //formel/ her findes random placering mellem 1 og rows
            int spillerColumn = g.currentColumn; //her findes random kolonne mellem 1 og columns
            gameBoardArray[spillerRow][spillerColumn] = 0;
            if (brugerInput.equals("w")){
                g.op();
                gameBoardArray[g.rowMove][g.columnMove] = 5;
                System.out.println("Det virker, w");
            } else if (brugerInput.equals("s")){
                g.ned();
                gameBoardArray[g.rowMove][g.columnMove] = 5;
                System.out.println("Det virker, s");
            } else if (brugerInput.equals("d")){
                g.højre();
                gameBoardArray[g.rowMove][g.columnMove] = 5;
            } else if (brugerInput.equals("a")){
                g.venstre();
                gameBoardArray[g.rowMove][g.columnMove] = 5;
            }

            Spiller nySpiller = new Spiller();
            nySpiller.spillerPosition = o;
            nySpiller.currentColumn = spillerRow;
            nySpiller.currentRow = spillerColumn;
            //nySpiller.myPosition();
            spillerArray[o] = nySpiller;

        }

    }
}

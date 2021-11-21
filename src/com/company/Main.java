package com.company;

public class Main {

    public static void main(String[] args) {
	Gameboard g = new Gameboard();
    Spiller s = new Spiller();
    g.rows = 6;
    g.columns = 6;
    g.obstacles = 4; //Her bestemmer jeg hvor mange obstacles der skal være
        g.animals = 4;
    g.setup();
    g.draw();
    //s.move();
    g.moveSpiller();
    }
}

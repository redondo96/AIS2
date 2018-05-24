package es.codeurjc.ais.tictactoe;

import es.codeurjc.ais.tictactoe.TicTacToeGame.Cell;

import org.junit.Assert;
import org.junit.Test;


public class BoardTest {


    @Test
    public void winHorizontalTest() {
        Board bard = new Board();
        for (int i = 0; i < 9; i++) {
            if (i == 0){
                Cell cero = bard.getCell(0);
                cero.value = "x";
            }
            else if (i == 3) {
                Cell tres = bard.getCell(3);
                tres.value = "o";
            }
            else if (i == 1) {
                Cell uno = bard.getCell(1);
                uno.value = "x";
            }
            else if (i == 4) {
                Cell cuatro = bard.getCell(4);
                cuatro.value = "o";
            }
            else if (i == 2) {
                Cell dos = bard.getCell(2);
                dos.value = "x";
            }
        }
        int[] winner = bard.getCellsIfWinner("x");
        int[] comparator = {0, 1, 2};
        assert !bard.checkDraw();  //Trivial
        Assert.assertArrayEquals(winner, comparator);
    }

    @Test
    public void winDiagonalTest() {
        Board bard = new Board();
        for (int i = 0; i < 9; i++) {
            if (i == 0){
                Cell cero = bard.getCell(0);
                cero.value = "x";
            }
            else if (i == 3) {
                Cell tres = bard.getCell(3);
                tres.value = "o";
            }
            else if (i == 4) {
                Cell cuatro = bard.getCell(4);
                cuatro.value = "x";
            }
            else if (i == 5) {
                Cell cinco = bard.getCell(5);
                cinco.value = "o";
            }
            else if (i == 8) {
                Cell ocho = bard.getCell(8);
                ocho.value = "x";
            }
        }
        int[] winner = bard.getCellsIfWinner("x");
        int[] comparator = {0, 4, 8};
        assert !bard.checkDraw();  //Trivial
        Assert.assertArrayEquals(winner, comparator);
    }

    @Test
    public void winVerticalTest() {
        Board bard = new Board();
        for (int i = 0; i < 9; i++) {
            if (i == 0){
                Cell cero = bard.getCell(0);
                cero.value = "x";
            }
            else if (i == 2) {
                Cell dos = bard.getCell(2);
                dos.value = "o";
            }
            else if (i == 3) {
                Cell tres = bard.getCell(3);
                tres.value = "x";
            }
            else if (i == 1) {
                Cell uno = bard.getCell(1);
                uno.value = "o";
            }
            else if (i == 6) {
                Cell seis = bard.getCell(6);
                seis.value = "x";
            }
        }
        int[] winner = bard.getCellsIfWinner("x");
        int[] comparator = {0, 3, 6};
        assert !bard.checkDraw();  //Trivial
        Assert.assertArrayEquals(winner, comparator);
    }

    @Test
    public void drawTest() {
        Board bard = new Board();
        for (int i = 0; i < 9; i++) {
            if (i == 0){
                Cell cero = bard.getCell(0);
                cero.value = "x";
            }
            else if (i == 1) {
                Cell uno = bard.getCell(1);
                uno.value = "x";
            }
            else if (i == 2) {
                Cell dos = bard.getCell(2);
                dos.value = "o";
            }
            else if (i == 3) {
                Cell tres = bard.getCell(3);
                tres.value = "o";
            }
            else if (i == 4) {
                Cell cuatro = bard.getCell(4);
                cuatro.value = "o";
            }
            else if (i == 5) {
                Cell cinco = bard.getCell(5);
                cinco.value = "x";
            }
            else if (i == 6) {
                Cell seis = bard.getCell(6);
                seis.value = "x";
            }
            else if (i == 7) {
                Cell siete = bard.getCell(7);
                siete.value = "o";
            }
            else {
                Cell ocho = bard.getCell(8);
                ocho.value = "x";
            }
        }
        // Si es null, nadie gana
        int[] firstDrawer = bard.getCellsIfWinner("x");
        Assert.assertNull(firstDrawer);
        int[] secondDrawer = bard.getCellsIfWinner("o");
        Assert.assertNull(secondDrawer);
        assert bard.checkDraw(); //Si todas estan llenas, es que hay empate
    }
//    @Test
//    public void checkDrawTest() {
//        TicTacToeGame geim = new TicTacToeGame();
//        Player paco = new Player(1,"Paco", "Paco");
//        Player pepe = new Player(2, "Pepe", "Pepe");
//        geim.addPlayer(paco);
//        geim.addPlayer(pepe);
//        geim.mark(0);
//        geim.mark(1);
//        geim.mark(2);
//        geim.mark(3);
//        geim.mark(4);
//        geim.mark(5);
//        geim.mark(6);
//        geim.mark(7);
//        geim.mark(8);
//        System.out.println(geim.checkDraw());
//        assert geim.checkDraw();
//
//    }

}
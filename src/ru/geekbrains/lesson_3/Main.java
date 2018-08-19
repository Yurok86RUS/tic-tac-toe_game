package ru.geekbrains.lesson_3;

import java.util.Scanner;

public class Main {

    /*
    настройки
     */

    private static char[][] map; //поле
    private static int Size = 3; //размерность

    private static final char DotEmpty = '*'; //символ пустоты
    public static final char DotX = 'X'; //крестики
    public static final char DotO = 'O'; //нолики

    public static Scanner scaner = new Scanner(System.in);

    public static void main(String[] args) {

    initMap();
    printMap();

/*    while (true){

        humanTurn();
        if (isEndGame(DotX)) {
            break;
        }


        computerTurn();
        if (isEndGame(DotO)) {
            break;
        }


    }

        System.out.println("Игра окончена!");
*/
    }

    //Метод подготовки поля
    private static void initMap(){
        map = new char[Size][Size];
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++){
                map[i][j] = DotEmpty;
            }
        }
    }

    //метод отрисовки поля
    private static void printMap(){
        for (int i = 0; i <= Size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < Size; i++){
            System.out.print((i + 1) + " " );
            for (int j = 0; j < Size; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}

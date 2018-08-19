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

   while (true){

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

    //Ход человека
    private static void humanTurn(){
        int x, y; //строка и столбец
        do {
            System.out.println("Введите координаты через пробел");
            y = scaner.nextInt() - 1;
            x = scaner.nextInt() - 1;
        }while (!isCellValid(x, y));

        map[y][x] = DotX;
    }

    //валидность введенных координат
    private static boolean isCellValid(int x, int y){
        boolean result = true;

        if (x < 0 || x >= Size || y < 0 || y >= Size){
            result = false;
        }

        if (map[y][x] != DotEmpty){
            result = false;
        }

        return result;
    }
}

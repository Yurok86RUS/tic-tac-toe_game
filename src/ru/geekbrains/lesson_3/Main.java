package ru.geekbrains.lesson_3;

import java.util.Random;
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

    private static boolean Stuped = false;

    public static Scanner scaner = new Scanner(System.in);
    private static Random ramdom = new Random();

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
            System.out.println("Введите координаты через пробел ");
            System.out.println();
            y = scaner.nextInt() - 1;
            x = scaner.nextInt() - 1;
        }while (!isCellValid(x, y));

        map[y][x] = DotX;
    }

    //Ход компьютера
    private static void computerTurn(){
        int x = -1;
        int y = -1;

        if (Stuped) {
            do {
                x = ramdom.nextInt(Size);
                y = ramdom.nextInt(Size);
            } while (!isCellValid(x, y));
        }
        else {
            boolean oneTurn = true;
            boolean result = false;
        for (int i = 0; i < Size; i++){
            for (int j = 0; j < Size; j++){
                if (map[i][j] == DotEmpty){

                    if (i == 1 & j == 1){
                        if (map[0][0] == DotO || map[0][1] == DotO || map[0][2] == DotO ||
                            map[0][0] == DotO || map[0][1] == DotO || map[0][2] == DotO ||
                            map[0][0] == DotO || map[0][1] == DotO || map[0][2] == DotO){
                            y = i;
                            x = j;
                            result = true;
                        }
                    }

                    if (i == 0 & j == 0){
                        if (map[0][1] == DotO || map[1][1] == DotO || map[1][0] == DotO){
                            y = i;
                            x = j;
                            result = true;
                        }
                    }

                    if (i == 0 & j == 1){
                        if (map[0][0] == DotO || map[1][1] == DotO || map[0][2] == DotO){
                            y = i;
                            x = j;
                            result = true;
                        }
                    }

                    if (i == 0 & j == 2){
                        if (map[0][1] == DotO || map[1][1] == DotO || map[1][2] == DotO){
                            y = i;
                            x = j;
                            result = true;
                        }
                    }

                    if (i == 1 & j == 0){
                        if (map[0][0] == DotO || map[1][1] == DotO || map[2][0] == DotO){
                            y = i;
                            x = j;
                            result = true;
                        }
                    }

                    if (i == 1 & j == 2){
                        if (map[0][2] == DotO || map[1][1] == DotO || map[2][2] == DotO){
                            y = i;
                            x = j;
                            result = true;
                        }
                    }

                    if (i == 2 & j == 0){
                        if (map[1][0] == DotO || map[1][1] == DotO || map[2][1] == DotO){
                            y = i;
                            x = j;
                            result = true;
                        }
                    }

                    if (i == 2 & j == 1){
                        if (map[2][0] == DotO || map[1][1] == DotO || map[2][2] == DotO){
                            y = i;
                            x = j;
                            result = true;
                        }
                    }

                    if (i == 2 & j == 2){
                        if (map[1][2] == DotO || map[1][1] == DotO || map[2][1] == DotO){
                            y = i;
                            x = j;
                            result = true;
                        }
                    }

                    if (result) {
                        oneTurn = false;
                        break;
                    }
                }
            }
            if (oneTurn = false){
                break;
            }
            else oneTurn = true;
        }
        if (oneTurn) {
            do {
                x = ramdom.nextInt(Size);
                y = ramdom.nextInt(Size);
            } while (!isCellValid(x, y));
        }
        }

        System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x +1));
        map[y][x] = DotO;

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

    //окончание игры
    private static boolean isEndGame(char winSumbol){
        boolean result = false;

        printMap();

        //игра продоожится?
        if (checkWin(winSumbol)){
            System.out.println("Победа за " + winSumbol);
            result = true;
        }
        if (isMapFull()){
            System.out.println("Ничья!");
            result = true;
        }

        return result;
    }

    private static boolean isMapFull(){
        boolean result = true;

        for (int i = 0; i < Size; i++){
            for (int j = 0; j < Size; j++){
                if (map[i][j] == DotEmpty)
                    result = false;
            }
        }
        return result;
    }

    private static boolean checkWin(char winSumbol){
        boolean result = false;

        if (
                (map[0][0] == winSumbol && map[0][1] == winSumbol && map [0][2] == winSumbol) ||
                (map[1][0] == winSumbol && map[1][1] == winSumbol && map [1][2] == winSumbol) ||
                (map[2][0] == winSumbol && map[2][1] == winSumbol && map [2][2] == winSumbol) ||
                (map[0][0] == winSumbol && map[1][0] == winSumbol && map [2][0] == winSumbol) ||
                (map[0][1] == winSumbol && map[1][1] == winSumbol && map [2][1] == winSumbol) ||
                (map[0][2] == winSumbol && map[1][2] == winSumbol && map [2][2] == winSumbol) ||
                (map[0][0] == winSumbol && map[1][1] == winSumbol && map [2][2] == winSumbol) ||
                (map[2][0] == winSumbol && map[1][1] == winSumbol && map [0][2] == winSumbol)){
            result = true;
        }
        return result;
    }
}

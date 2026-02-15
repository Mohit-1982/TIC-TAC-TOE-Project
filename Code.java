package TicTacToe;

import java.util.Scanner;

public class GameTicTacToe {
    private static String name1;
    private static String name2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        playerIntro(sc);
        System.out.println();
        assignXO();
        game();
    }
    static void game() {
        char[][] arr = new char[3][3];
        int n;
        int m;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Row And Column");
        int i = 0;
        while(i < 9) {
            System.out.print(name1 + " X's Turn : ");
            n = sc.nextInt();
            m = sc.nextInt();
            if(n > 2 || n < 0 || m < 0 || m > 2) {
                System.out.println("Invalid Choice !! Try Again");
                continue;
            }
            if(arr[n][m] != '\u0000') {
                System.out.println("Cell Already Filled Try Again!!!");
                continue;
            }
            arr[n][m] = 'X';
            print(arr);
            i++;
            boolean win = winCheck(arr, 'X');
                if(win) {
                    System.out.println(name1 + " Won The Game ");
                    return;
                }
            if(i == 9) break;
            System.out.print(name2 + " O's Turn : ");
            n = sc.nextInt();
            m = sc.nextInt();
            if(n > 2 || n < 0 || m < 0 || m > 2) {
                System.out.println("Invalid Choice !! Try Again");
                continue;
            }
            if(arr[n][m] != '\u0000') {
                System.out.println("Cell Already Filled Try Again!!!");
                continue;
            }
            arr[n][m] = 'O';
            print(arr);
            i++;
            boolean win2 = winCheck(arr, 'O');
                if(win2) {
                    System.out.println(name2 + " Won The Game ");
                    return;
                }
            }
        }
    static boolean winCheck(char[][] arr, char playerAssigned) {
        int row = 0;
        int col = 0;
        //Diagonal Check
        char firstCol = playerAssigned;
        boolean diaCheck = true;
        while(row < arr.length && col < arr[0].length) {
            if(arr[row][col] != firstCol) {
                diaCheck = false;
                break;
            }
            row++;
            col++;
        }
        //Reverse Diagonal Check
        row = 0;
        col = 2;
        char revDia = playerAssigned;
        boolean revDiaCheck = true;
        while(row < arr.length && col >= 0) {
            if(arr[row][col] != revDia) {
                revDiaCheck = false;
                break;
            }
            row++;
            col--;
        }
        //Row Check
        boolean rowCheck = false;
        char strtOfRow = playerAssigned;
        for(row = 0; row < arr.length; row++) {
            boolean currRowCheck = true;
            for(col = 0; col < arr[0].length; col++) {
                if(arr[row][col] != strtOfRow) {
                    currRowCheck = false;
                    break;
                }
            }
            if(currRowCheck) {
               rowCheck = true;
            }
        }
        //Column Check
        boolean colCheck = false;
        char strtOfCol = playerAssigned;
        for(col = 0; col < arr[0].length; col++) {
            boolean currColCheck = true;
            for(row = 0; row < arr.length; row++) {
                if(arr[row][col] != strtOfCol) {
                    currColCheck = false;
                    break;
                }
            }
            if(currColCheck) {
                colCheck = true;
            }
        }

        //Return All these in an Array
        return rowCheck || colCheck || diaCheck || revDiaCheck;
    }
    static void assignXO() {
        System.out.println("X is Assigned to : " + name1);
        System.out.println("O is Assigned to : " + name2);
    }
    static void print(char[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        System.out.println();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void playerIntro(Scanner sc) {
        System.out.print("Welcome To The TIC-TAC-TOE Game");
        System.out.println();

        System.out.print("Enter Player's 1 Name : ");
        name1 = sc.nextLine();

        System.out.print("Enter Player's 2 Name : ");
        name2 = sc.nextLine();
        System.out.print("Welcome " + name1 + " and " + name2);
    }
}

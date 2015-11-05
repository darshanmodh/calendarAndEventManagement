
import java.util.Random;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jigar
 */import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.util.Random;
public class nfanull {
    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */





    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        boolean a = false;

        char state = 'A';
        int i;
        char[] str = new char[100];
        String str1;
        Scanner b = new Scanner(System.in);
        System.out.println("enter your string");
        str1 = b.nextLine();
        str = str1.toCharArray();

        for (i = 0; i < str.length; i++) {
            if (str[i] == '0' && state == 'A') {
                Random r = new Random();
               String alphabet = "EC";
                state = alphabet.charAt(r.nextInt(alphabet.length()));
               
                a = true;
                System.out.println(str[i] + " is accepted and goes to state "+state);
                continue;
            } else if (str[i] == '1' && state == 'A') {

               // Random r = new Random();
               // String alphabet = "CB";
                //state = alphabet.charAt(r.nextInt(alphabet.length()));
                state='B';
                a = true;
                System.out.println(str[i] + " is accepted and goes to state " + state);
                continue;
            } else if (str[i] == '1' && state == 'B') {
                Random r = new Random();
               String alphabet = "AB";
                state = alphabet.charAt(r.nextInt(alphabet.length()));
                a = true;
                System.out.println(str[i] + " is accepted and goes to state "+state);
                continue;
            } 
            else if (str[i] == '0' && state == 'B') {
                state = 'E';
                a = true;
                System.out.println(str[i] + " is accepted and goes to state D");
                continue;
            } else if (str[i] == '1' && state == 'C') {
                state = 'D';
                a = true;
                System.out.println(str[i] + " is accepted and goes to state D");
                continue;
            } else if (str[i] == '0' && state == 'D') {
                Random r = new Random();
               String alphabet = "AE";
                state = alphabet.charAt(r.nextInt(alphabet.length()));
                //state = 'A';
                a = true;
                System.out.println(str[i] + " is accepted and goes to state "+state);
                continue;
            } else if ((str[i] == '0' || str[i] == '1') && state == 'E') {
                state = 'P';
                a = true;

                //System.out.println(str[i]+" is accepted and goes to state E");
                break;
            } else {
                a = false;
                System.out.println(str[i] + " is rejected and because of invalid character");
                break;
            }

        }
        if (a == true && state == 'E') {
            System.out.print("your string is accepted");
            System.out.println("\n");
        } else if (a == true && state == 'P') {
            System.out.print("your string is partially accepted up to ");
            for (int k = 0; k < i; k++) {
                System.out.print("" + str[k]);
            }
            System.out.println("\n");
        } else {
            System.out.println("your string is rejected");
            System.out.println("\n");
        }

    }
}


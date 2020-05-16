package com.arian;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {

        ArrayList mainJoueur = new ArrayList();
        ArrayList mainOrdi = new ArrayList();
        mainOrdi.add("MainOrdi");
        mainJoueur.add("MainJoueur");

        mainOrdi = premierTirage(mainOrdi);
        mainJoueur = premierTirage(mainJoueur);
        int pointsJoueur =  calculateurPoints(mainJoueur);
        int pointsOrdi = calculateurPoints(mainOrdi);

        System.out.println("main joueur : " + mainJoueur + " points joueur : " + pointsJoueur);
        System.out.println("main ordi : " + mainOrdi + " points ordi : " + pointsOrdi);
        



    }

    public static ArrayList tirage(ArrayList main){
        //Prends en entrée la main du joueur ou l'ordi en ArrayList
        //et y ajoute une nouvelle carte dans la main
        //Retourn la nouvelle main en ArrayList

        Random random = new Random();
        int indexCartes = random.nextInt(13); //13 parce que 13 cartes par famille
        main.add(indexCartes);

        return main;
    }

    public static ArrayList premierTirage(ArrayList main){
        //Prends en entrée 2 ArrayList, la main et la liste des cartes et retourne la main avec les 2 premières cartes
        //Tire les deux premières cartes de la main

        for (int i = 1;i<=2;i++){
            main = tirage(main);
        }

        return main;
    }

    public static int calculateurPoints(ArrayList main){
        //Prends en entrée une main et calcule les points de la main
        //Retourn un int des points
        
        Scanner scan = new Scanner(System.in);
        final int VALEUR_VALET_DAME_ROI = 10;
        int points = 0;

        for(int i = 1; i < main.size();i++) {

            if (main.get(0) == "MainOrdi" && (int) main.get(i) == 1 && points <= 10) {
                //Si c'est la main du joueur on donner la valeur de 11 a son as seulement si il a plus de 10 points
                //lorsqu'il tire la carte.

                int valeurAs = 11;
                points = points + valeurAs;
            }
            else if ( main.get(0) == "MainJoueur" && (int) main.get(i) == 1){
                //Si c'est la main du joueur on lui dit combien de points il a pour l'instnat et on lui demande si il veut
                //que son as vaille 1 ou 11 pts

                System.out.println("Vous avez "+points+" points");
                System.out.print("Voulez vous que votre As compte 1 ou 11pts : ");
                int valeurAs = scan.nextInt();
                points = points + valeurAs;
            }
            else if ((int) main.get(i) > 10)
                //Le valet, la dame, le roi (11,12,13) valent 10 pts au blackjack

                points = points + VALEUR_VALET_DAME_ROI;
            else
                points = points + (int) main.get(i);
        }
        return points;
    }
}

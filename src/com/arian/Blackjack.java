package com.arian;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList mainJoueur = new ArrayList();
        ArrayList mainOrdi = new ArrayList();
        mainOrdi.add("MainOrdi");
        mainJoueur.add("MainJoueur");

        mainOrdi = premierTirage(mainOrdi);
        mainJoueur = premierTirage(mainJoueur);
        int pointsOrdi = calculateurPoints(mainOrdi);
        
        while(true){
            System.out.println("\n["+mainOrdi.get(0) +", " + mainOrdi.get(1) + "] nombres de carte : "+ (mainOrdi.size()-1));
            System.out.println(mainJoueur);

            System.out.print("\nVoulez vous une nouvelle carte (1.Oui 2.Non) : ");
            int choix = scan.nextInt();

            if(choix == 1){
                mainJoueur = tirage(mainJoueur);
            }
            else if(pointsOrdi <= 17){
                mainOrdi = tirage(mainOrdi);
                pointsOrdi = calculateurPoints(mainOrdi);
            }
            else if(pointsOrdi > 17 && choix == 2){
                quiVaGagner(mainJoueur,mainOrdi);
                break;
            }
        }
    }

    public static ArrayList tirage(ArrayList main){
        //Prends en entrée la main du joueur ou l'ordi en ArrayList
        //et y ajoute une nouvelle carte dans la main
        //Retourn la nouvelle main en ArrayList

        Random random = new Random();
        int indexCartes = 1+random.nextInt(13); //13 parce que 13 cartes par famille et +1 pour que random aille de 1 a 13 pas de 0 a 12
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

                System.out.println(main);
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

    public static void quiVaGagner(ArrayList mainJoueur, ArrayList mainOrdi){
        System.out.println("\n"+mainJoueur);
        System.out.println(mainOrdi);
        int pointsJoueur = calculateurPoints(mainJoueur);
        int pointsOrdi = calculateurPoints(mainOrdi);

        if(pointsJoueur > 21 && pointsOrdi > 21)
            System.out.println("Match nul les deux joueurs ont dépassé 21 points. Vous avez "+pointsJoueur+" et l'ordi a "+pointsOrdi+" points");
        else if(pointsJoueur > 21)
            System.out.println("Vous avez perdu! Vous avez "+pointsJoueur+" points et l'ordi a "+pointsOrdi+" points");
        else if(pointsOrdi > 21)
            System.out.println("Vous avez gagné!! Vous avez "+pointsJoueur+" points et l'ordi a "+pointsOrdi+" points");
        else if(pointsJoueur > pointsOrdi)
            System.out.println("Vous avez gagné!! Vous avez "+pointsJoueur+" points et l'ordi a "+pointsOrdi+" points");
        else
            System.out.println("Vous avez perdu! Vous avez "+pointsJoueur+" points et l'ordi a "+pointsOrdi+" points");
    }
}

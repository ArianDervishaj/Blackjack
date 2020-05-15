package com.arian;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Blackjack {
    public static void main(String[] args) {

        ArrayList listeToutesCartes = listeToutesCartesGenerateur();
        ArrayList mainJoueur = new ArrayList();
        ArrayList mainOrdi = new ArrayList();


        for (int j =0;j < 5;j++){
            ArrayList[] mainJoueurEtListeToutesCartes = tirage(mainJoueur, listeToutesCartes);
            mainJoueur = mainJoueurEtListeToutesCartes[0];
            listeToutesCartes = mainJoueurEtListeToutesCartes[1];

        }
        System.out.println(mainJoueur);
        System.out.println(listeToutesCartes);


    }

    public static ArrayList[] tirage(ArrayList main, ArrayList listeToutesCartes){
        //Prends en entrée la main du joueur ou l'ordi en ArrayList et la liste de toutes les cartes en Array liste
        //et y ajoute une nouvelle carte dans la main et enleve la carte tirée de la liste de toutes les cartes
        //Retourne une Array de la nouvelle main en ArrayList et de la nouvelle liste de toutes les cartes en ArrayList

        Random random = new Random();

        int indexCartes = random.nextInt(listeToutesCartes.size()-1);
        main.add(listeToutesCartes.get(indexCartes));
        listeToutesCartes.remove(indexCartes);

        ArrayList[] valeurRetourne = {main, listeToutesCartes};
        return valeurRetourne ;


    }

    public static ArrayList listeToutesCartesGenerateur(){
        //Genere les 52 cartes d'un jeu de cartes, en 4 familles de 13 cartes

        final int NOMBRECARTESPARFAMILLE = 13;
        final int NOMBRECARTESTOTAL = 52;
        final int DECALAGE = 1;

        ArrayList listeCartesTotales = new ArrayList();

        for(int i=0;i <NOMBRECARTESTOTAL;i++){
            int numeroCartes = i % NOMBRECARTESPARFAMILLE + DECALAGE;
            listeCartesTotales.add(numeroCartes);
        }
        return listeCartesTotales;
    }

    public static void premierTirage(ArrayList main, ArrayList listeToutesCartes){
        for (int i = 0;i<2;i++){
            ArrayList[] retourner = tirage(main, listeToutesCartes);
            main = retourner[0];
            listeToutesCartes = retourner[1];
        }



    }
}

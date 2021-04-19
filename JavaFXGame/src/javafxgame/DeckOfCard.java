/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxgame;

import java.util.ArrayList;
import javafx.scene.image.Image;
import java.util.Random;
import javafx.scene.image.ImageView;

/**
 *
 * @author beaut
 */
public class DeckOfCard {

    private Image imagecards;
    private int[] card = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    ArrayList<Integer> deckList = new ArrayList<>();
    private String[] nameImages = new String[10];
    private int[] temp = new int[10];
    private int Maxnum = 10;
    private Random r = new Random();
    private int ran2;
    private long start;
    private long end = 0;

    public DeckOfCard() {
    }

    public void setImagecards(Image name) {
        imagecards = name;
    }

    public Image getImagecards() {
        return imagecards;
    }

    public String[] nameImage(int z) {
        switch (z) {
            case 1 -> {
                for (int i = 0; i < 10; i++) {
                    nameImages[i] = "/card1/" + temp[i] + ".png";
                }
            }
            case 2 -> {
                for (int i = 0; i < 10; i++) {
                    nameImages[i] = "/card2/" + temp[i] + ".png";
                }
            }
            case 3 -> {
                for (int i = 0; i < 10; i++) {
                    nameImages[i] = "/card3/" + temp[i] + ".png";
                }
            }
            default -> {
            }
        }
        return nameImages;
    }

    public void time() {
        start = System.currentTimeMillis();
        while (end - start <= 1000) {
            end = System.currentTimeMillis();
        }
        System.out.println("YO");
    }

    public int deckCard(int x) {
        for (int i = 4; i < 10; i++) {
            deckList.add(temp[i]);
        }
        deckList.remove(x);
        return deckList.get(0);
    }

    public int[] ran() {
        for (int i = 1; i <= 10; i++) {
            ran2 = r.nextInt(Maxnum);
            temp[i - 1] = card[ran2];
            Maxnum--;
            for (int j = ran2; j < Maxnum; j++) {
                card[j] = card[j + 1];
            }
            int[] numcop = new int[Maxnum];
            System.arraycopy(card, 0, numcop, 0, Maxnum);
            card = new int[Maxnum];
            System.arraycopy(numcop, 0, card, 0, Maxnum);
        }
        return temp;
    }

}

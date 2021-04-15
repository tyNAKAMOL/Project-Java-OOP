/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxgame;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.util.Random;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import java.util.concurrent.TimeUnit;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author beaut
 */
public class FXMLGameController implements Initializable {

    @FXML
    private AnchorPane menu, singlePlayer, multiplePlayer, howToPlay;
    @FXML
    private Button btn_singleplayer, btn_Mutiplayer, btn_howtoplay, btn_Stand, btn_Hit, PlayMuti, btn_standmutiple, btn_Hitmutiple;
    @FXML
    private ImageView btn_turnS, firstcard1, firstcard2, cardplayer1_2, card1_1, card2_1, card2_2, card1_3, card2_3, card1_4, card1_5;
    @FXML
    private ImageView btn_turnH, btn_turnM, imagecard2, ImagesCard1, imagecard3, cardback, card1, card2_4, card2_5;
    @FXML
    private ImageView im1, im2, im3, im4, im5, im6;
    @FXML
    private Button btn_playgame, btn_nextplayer;
    @FXML
    private Text textnum, textf, textplay, textnoplay, textplayer, textBJ;

    private String[] name = new String[10];
    private int[] deck = new int[10];
    private boolean player1;
    private boolean player2;
    private boolean cardp1_3 = false;
    private boolean cardp1_4 = false;
    private boolean cardp1_5 = false;
    private boolean cardp2_3 = false;
    private boolean cardp2_4 = false;
    private boolean cardp2_5 = false;
    private boolean standplayer1 = false;
    private boolean standplayer2 = false;
    private int countp1 = 2;
    private int countp2 = 2;
    private int countimage = 4;
    private boolean closeCard = false;
    private int count = 0;
    private int sum1 = 0;
    private int sum2 = 0;
    private ArrayList<Integer> p1 = new ArrayList<>();
    private ArrayList<Integer> p2 = new ArrayList<>();
    private Random r = new Random();
    private Image[] image = new Image[10];
    private DeckOfCard card2 = new DeckOfCard();
    private DeckOfCard card = new DeckOfCard();
    private TranslateTransition TCplayer2_back = new TranslateTransition();
    private TranslateTransition TCplayer2_1 = new TranslateTransition();
    private TranslateTransition TCplayer2_2 = new TranslateTransition();
    private TranslateTransition TCplayer1_back = new TranslateTransition();
    private TranslateTransition TCplayer1_1 = new TranslateTransition();
    private TranslateTransition TCplayer1_2 = new TranslateTransition();
    private TranslateTransition T = new TranslateTransition();

    /**
     * Initializes the controller class.
     *
     */
    @FXML
    private void handleButtonAction(MouseEvent event) {
        menu.setVisible(true);
        System.out.print("Chlick");
        if (event.getTarget() == btn_singleplayer) {
            singlePlayer.setVisible(true);
            multiplePlayer.setVisible(false);
        } else if (event.getTarget() == btn_Mutiplayer) {
            multiplePlayer.setVisible(true);
            singlePlayer.setVisible(false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void handleMouseClickS(MouseEvent event) {
        singlePlayer.setVisible(true);
        multiplePlayer.setVisible(false);
        menu.setVisible(false);
        howToPlay.setVisible(false);
    }

    @FXML
    private void handleMouseClickHowtoplay(MouseEvent event) {
        singlePlayer.setVisible(false);
        multiplePlayer.setVisible(false);
        menu.setVisible(false);
        howToPlay.setVisible(true);
    }

    @FXML
    private void handleMouseClickMuti(MouseEvent event) {
        multiplePlayer.setVisible(true);
        singlePlayer.setVisible(false);
        menu.setVisible(false);
        howToPlay.setVisible(false);
    }

    @FXML
    private void handleMouseClickturnS(MouseEvent event) {
        menu.setVisible(true);
        singlePlayer.setVisible(false);
        multiplePlayer.setVisible(false);
        howToPlay.setVisible(false);
    }

    @FXML
    private void handleMouseClickturnH(MouseEvent event) {
        menu.setVisible(true);
        singlePlayer.setVisible(false);
        multiplePlayer.setVisible(false);
        howToPlay.setVisible(false);
    }

    private void handleMouseClickturn(MouseEvent event) {
        menu.setVisible(true);
        singlePlayer.setVisible(false);
        multiplePlayer.setVisible(false);
        howToPlay.setVisible(false);
    }

    @FXML
    private void handleMouseClickturnM(MouseEvent event) {
        menu.setVisible(true);
        singlePlayer.setVisible(false);
        multiplePlayer.setVisible(false);
        howToPlay.setVisible(false);
    }

//----------------------------sigleplayer------------------------//
    @FXML
    private void handleButtonp(MouseEvent event) {
        btn_playgame.relocate(510, 283);
        btn_Stand.relocate(809, 358);
        btn_Hit.relocate(726, 358);

        deck = card.ran();
        name = card.nameImage();
        for (int i = 0; i < 10; i++) {
            image[i] = new Image(name[i]);
        }

        Image imageback = new Image("/JavaFXGAME/images/backsidecard.jpg");
        cardback.setImage(imageback);
        card1.setImage(image[3]);
        ImagesCard1.setImage(image[0]);
        imagecard2.setImage(image[1]);
        textnum.setText((deck[0] + deck[1]) + "/21");
        textf.setText(deck[3] + "+?/21");
    }

    @FXML
    private void handleButtonHit(MouseEvent event) {
        imagecard3.setImage(image[2]);
        textnum.setText((deck[0] + deck[1] + deck[2]) + "/21");
    }

    @FXML
    private void handleButtonStand(MouseEvent event) {
    }

    //----------------------MutiplePlayer--------------------------//
    @FXML
    private void handleButtonplayMutiplae(MouseEvent event) {
        //DeckOfCard card2 = new DeckOfCard();
        deck = card2.ran();
        name = card2.nameImage();
        for (int i = 0; i < 10; i++) {
            image[i] = new Image(name[i]);
        }
        PlayMuti.relocate(965, 285);
        im6.relocate(960, 223);
        im5.relocate(965, 223);
        im4.relocate(970, 223);
        im3.relocate(974, 223);
        im2.relocate(978, 223);
        im1.relocate(982, 223);
        btn_standmutiple.relocate(977, 417);
        btn_Hitmutiple.relocate(977, 461);
        btn_nextplayer.relocate(965, 285);
        textBJ.relocate(-1000, 400);
        Image imageback = new Image("/JavaFXGAME/images/backsidecard.jpg");
        firstcard1.setImage(imageback);
        cardplayer1_2.setImage(image[2]);
        firstcard2.setImage(imageback);
        card1_1.setImage(image[0]);
        card2_1.setImage(image[1]);
        card2_2.setImage(image[3]);
        textplayer.setText("Player 1");

        if (deck[2] > deck[3]) {
            player1 = true;
            closeCard = true;
            p1.add(deck[0]);
            p1.add(deck[2]);
            firstcard2.setScaleX(0.6);
            firstcard2.setScaleY(0.6);

            System.out.println("1");
            TCplayer2_back.setNode(firstcard2);
            TCplayer2_back.setDuration(Duration.millis(300));
            TCplayer2_back.setDelay(Duration.millis(1000));
            TCplayer2_back.setToY(-250);
            TCplayer2_back.setToX(150);
            TCplayer2_back.play();

            card2_1.setScaleX(0.6);
            card2_1.setScaleY(0.6);
            TCplayer2_1.setNode(card2_1);
            TCplayer2_1.setDuration(Duration.millis(300));
            TCplayer2_1.setDelay(Duration.millis(1000));
            TCplayer2_1.setToY(-250);
            TCplayer2_1.setToX(150);
            TCplayer2_1.play();

            card2_2.setScaleX(0.6);
            card2_2.setScaleY(0.6);
            TCplayer2_2.setNode(card2_2);
            TCplayer2_2.setDuration(Duration.millis(300));
            TCplayer2_2.setDelay(Duration.millis(1000));
            TCplayer2_2.setToY(-250);
            TCplayer2_2.setToX(150);
            TCplayer2_2.play();

            //------------------player1----------------------//
            TCplayer1_back.setNode(firstcard1);
            TCplayer1_back.setDuration(Duration.millis(300));
            TCplayer1_back.setDelay(Duration.millis(1000));
            TCplayer1_back.setToX(-100);
            TCplayer1_back.play();

            TCplayer1_1.setNode(card1_1);
            TCplayer1_1.setDuration(Duration.millis(300));
            TCplayer1_1.setDelay(Duration.millis(1000));
            TCplayer1_1.setToX(-100);
            TCplayer1_1.play();

            TCplayer1_2.setNode(cardplayer1_2);
            TCplayer1_2.setDuration(Duration.millis(300));
            TCplayer1_2.setDelay(Duration.millis(1000));
            TCplayer1_2.setToX(-100);
            TCplayer1_2.play();
            T.setNode(textplay);
            T.setDuration(Duration.millis(1000));
            T.setToX(50);
            textplay.setText(deck[2] + "+?/21");
            T.play();
            textnoplay.setText(deck[3] + "+?/21");

        } else {
            player2 = true;
            closeCard = true;
            System.out.println("2");
            p2.add(deck[1]);
            p2.add(deck[3]);
            TCplayer1_back.setNode(firstcard1);
            TCplayer1_back.setDelay(Duration.millis(300));
            TCplayer1_back.setDuration(Duration.millis(1000));
            TCplayer1_back.setToY(-250);
            TCplayer1_back.setToX(-100);
            TCplayer1_back.play();

            TCplayer1_1.setNode(card1_1);
            TCplayer1_1.setDelay(Duration.millis(300));
            TCplayer1_1.setDuration(Duration.millis(1000));
            TCplayer1_1.setToY(-250);
            TCplayer1_1.setToX(-100);
            TCplayer1_1.play();

            TCplayer1_2.setNode(cardplayer1_2);
            TCplayer1_2.setDuration(Duration.millis(300));
            TCplayer1_2.setDelay(Duration.millis(1000));
            TCplayer1_2.setToY(-250);
            TCplayer1_2.setToX(-100);
            TCplayer1_2.play();

            //-----------------player2----------------------//       
            TCplayer2_back.setNode(firstcard2);
            TCplayer2_back.setDuration(Duration.millis(300));
            TCplayer2_back.setDelay(Duration.millis(1000));
            TCplayer2_back.setToX(150);
            TCplayer2_back.play();

            TCplayer2_1.setNode(card2_1);
            TCplayer2_1.setDuration(Duration.millis(300));
            TCplayer2_1.setDelay(Duration.millis(1000));
            TCplayer2_1.setToX(150);
            TCplayer2_1.play();

            TCplayer2_2.setNode(card2_2);
            TCplayer2_2.setDuration(Duration.millis(300));
            TCplayer2_2.setDelay(Duration.millis(1000));
            TCplayer2_2.setToX(150);
            TCplayer2_2.play();
            T.setNode(textplay);
            T.setDuration(Duration.millis(1000));
            T.setToX(50);
            textplay.setText(deck[3] + "+?/21");
            T.play();
            textnoplay.setText(deck[2] + "+?/21");
            firstcard1.setScaleX(0.6);
            firstcard1.setScaleY(0.6);
            card1_1.setScaleX(0.6);
            card1_1.setScaleY(0.6);
            cardplayer1_2.setScaleX(0.6);
            cardplayer1_2.setScaleY(0.6);
        }
    }

    @FXML
    private void handleButtonopenCard1(MouseEvent event) {
        closeCard = false;
        if (player1) {
            firstcard1.relocate(2000, 223);
            if (countp1 > 2) {
                textplay.setText((sum1) + "/21");
            } else {
                textplay.setText((deck[0] + deck[2]) + "/21");
            }
            firstcard1.setScaleX(0.6);
            firstcard1.setScaleY(0.6);
        }
        System.out.println(closeCard);
    }

    @FXML
    private void handleButtonopenCard2(MouseEvent event) {
        closeCard = false;
        if (player2) {
            firstcard2.relocate(2000, 223);
            if (countp2 > 2) {
                textplay.setText((sum2) + "/21");
            } else {
                textplay.setText((deck[1] + deck[3]) + "/21");
            }
            firstcard2.setScaleX(0.6);
            firstcard2.setScaleY(0.6);
        }
        System.out.println(closeCard);
    }

    @FXML
    private void handleButtoncloseCard1(MouseEvent event) {
        closeCard = true;
        if (player1) {
            firstcard1.relocate(597, 247);
            if (countp1 > 2) {
                textplay.setText((sum1 - deck[0]) + "+?/21");
            } else {
                textplay.setText(deck[2] + "+?/21");
            }
            firstcard1.setScaleX(1);
            firstcard1.setScaleY(1);
        }
        System.out.println(closeCard);
    }

    @FXML
    private void handleButtoncloseCard2(MouseEvent event) {
        closeCard = true;
        if (player2) {
            firstcard2.relocate(355, 247);
            if (countp2 > 2) {
                textplay.setText((sum2 - deck[1]) + "+?/21");
            } else {
                textplay.setText(deck[3] + "+?/21");
            }
            firstcard2.setScaleX(1);
            firstcard2.setScaleY(1);
        }
        System.out.println(closeCard);
    }

    @FXML
    private void handleButtonHitMutiple(MouseEvent event) {
        if (player1) {
            countp1++;
            p1.add(deck[countimage]);
            //card1_3.setImage(image[countimage]);
            if ((countp1 == 3) && (cardp1_3 == false)) {
                card1_3.setImage(image[countimage]);
                System.out.println("card1-3");
            }
            if ((countp1 == 4) && (cardp1_4 == false)) {
                card1_4.setImage(image[countimage]);
                System.out.println("card1-4");
            }
            if ((countp1 == 5) && (cardp1_5 == false)) {
                card1_5.setImage(image[countimage]);
                System.out.println("card1-5");
            }
            for (int x = 0; x < p1.size(); x++) {
                sum1 += p1.get(x);
            }
            System.out.println(p1);
            System.out.println("closecard = " + closeCard);
            System.out.println("Sum = " + sum1);
            if (closeCard) {
                textplay.setText(sum1 - deck[0] + "+?/21");
            } else {
                textplay.setText((sum1) + "/21");
            }
            countimage++;
            if ((countp1 == 3) && (cardp1_3 == false)) {
                cardp1_3 = true;
            }
            if ((countp1 == 4) && (cardp1_4 == false)) {
                cardp1_4 = true;
            }
            if ((countp1 == 5) && (cardp1_5 == false)) {
                cardp1_5 = true;
            }
        } else {
            countp2++;
            p2.add(deck[countimage]);
            if ((countp2 == 3) && (cardp2_3 == false)) {
                card2_3.setImage(image[countimage]);
                System.out.println("card2-3");
            }
            if ((countp2 == 4) && (cardp2_4 == false)) {
                card2_4.setImage(image[countimage]);
                System.out.println("card2-4");
            }
            if ((countp2 == 5) && (cardp2_5 == false)) {
                card2_5.setImage(image[countimage]);
                System.out.println("card2-5");
            }
            for (int x = 0; x < p2.size(); x++) {
                sum2 += p2.get(x);
            }
            System.out.println(p2);
            System.out.println("closecard = " + closeCard);
            System.out.println("Sum = " + sum2);
            if (closeCard) {
                textplay.setText((sum2 - deck[1]) + "+?/21");
            } else {
                textplay.setText((sum2) + "/21");
            }
            countimage++;
            if ((countp2 == 3) && (cardp2_3 == false)) {
                cardp2_3 = true;
            }
            if ((countp2 == 4) && (cardp2_4 == false)) {
                cardp2_4 = true;
            }
            if ((countp2 == 5) && (cardp2_5 == false)) {
                cardp2_5 = true;
            }
        }
        btn_standmutiple.relocate(965, 285);
        btn_Hitmutiple.relocate(965, 285);
        btn_nextplayer.relocate(978, 428);
    }

    @FXML
    private void handleButtonStandMutiple(MouseEvent event) {
        if (player1) {
            standplayer1 = true;
        }
        if (player2) {
            standplayer2 = true;
        }
        if (standplayer1 == true && standplayer2 == true) {
            System.out.println("end");
            btn_standmutiple.relocate(-965, 285);
            btn_Hitmutiple.relocate(-965, 285);
            btn_nextplayer.relocate(-978, 428);
        } else {
            btn_standmutiple.relocate(965, 285);
            btn_Hitmutiple.relocate(965, 285);
            btn_nextplayer.relocate(978, 428);
        }

    }

    @FXML
    private void handleButtonnextplayer(MouseEvent event) {
        btn_standmutiple.relocate(977, 417);
        btn_Hitmutiple.relocate(977, 461);
        btn_nextplayer.relocate(965, 285);
        //-------------------------case1---------------------//
        if (player1) {
            firstcard2.setScaleX(1);
            firstcard2.setScaleY(1);
            TCplayer2_back.setNode(firstcard2);
            TCplayer2_back.setDuration(Duration.millis(300));
            TCplayer2_back.setDelay(Duration.millis(300));
            TCplayer2_back.setToY(5);
            TCplayer2_back.play();

            card2_1.setScaleX(1);
            card2_1.setScaleY(1);
            TCplayer2_1.setNode(card2_1);
            TCplayer2_1.setDuration(Duration.millis(300));
            TCplayer2_1.setDelay(Duration.millis(300));
            TCplayer2_1.setToY(5);
            TCplayer2_1.play();

            card2_2.setScaleX(1);
            card2_2.setScaleY(1);
            TCplayer2_2.setNode(card2_2);
            TCplayer2_2.setDuration(Duration.millis(300));
            TCplayer2_2.setDelay(Duration.millis(300));
            TCplayer2_2.setToY(5);
            TCplayer2_2.play();

            //--------------------player1--------------------//
            firstcard1.setScaleX(0.6);
            firstcard1.setScaleY(0.6);
            TCplayer1_back.setNode(firstcard1);
            TCplayer1_back.setDelay(Duration.millis(300));
            TCplayer1_back.setDuration(Duration.millis(300));
            TCplayer1_back.setToY(-250);
            TCplayer1_back.play();

            card1_1.setScaleX(0.6);
            card1_1.setScaleY(0.6);
            TCplayer1_1.setNode(card1_1);
            TCplayer1_1.setDelay(Duration.millis(300));
            TCplayer1_1.setDuration(Duration.millis(300));
            TCplayer1_1.setToY(-250);
            TCplayer1_1.play();

            cardplayer1_2.setScaleX(0.6);
            cardplayer1_2.setScaleY(0.6);
            TCplayer1_2.setNode(cardplayer1_2);
            TCplayer1_2.setDuration(Duration.millis(300));
            TCplayer1_2.setDelay(Duration.millis(300));
            TCplayer1_2.setToY(-250);
            TCplayer1_2.play();
            if (cardp1_3) {
                TranslateTransition TCplayer1_3 = new TranslateTransition();
                card1_3.setScaleX(0.6);
                card1_3.setScaleY(0.6);
                TCplayer1_3.setNode(card1_3);
                TCplayer1_3.setDuration(Duration.millis(300));
                TCplayer1_3.setDelay(Duration.millis(300));
                TCplayer1_3.setToY(-250);
                TCplayer1_3.play();
            }
            if (cardp1_4) {
                TranslateTransition TCplayer1_4 = new TranslateTransition();
                card1_4.setScaleX(0.6);
                card1_4.setScaleY(0.6);
                TCplayer1_4.setNode(card1_4);
                TCplayer1_4.setDuration(Duration.millis(300));
                TCplayer1_4.setDelay(Duration.millis(300));
                TCplayer1_4.setToY(-250);
                TCplayer1_4.play();
            }
            if (cardp1_5) {
                TranslateTransition TCplayer1_5 = new TranslateTransition();
                card1_5.setScaleX(0.6);
                card1_5.setScaleY(0.6);
                TCplayer1_5.setNode(card1_5);
                TCplayer1_5.setDuration(Duration.millis(300));
                TCplayer1_5.setDelay(Duration.millis(300));
                TCplayer1_5.setToY(-250);
                TCplayer1_5.play();
            }
            if (cardp2_3) {
                TranslateTransition TCplayer2_3 = new TranslateTransition();
                card2_3.setScaleX(1);
                card2_3.setScaleY(1);
                TCplayer2_3.setNode(card2_3);
                TCplayer2_3.setDuration(Duration.millis(300));
                TCplayer2_3.setDelay(Duration.millis(300));
                TCplayer2_3.setToY(5);
                TCplayer2_3.play();
            }
            if (cardp2_4) {
                TranslateTransition TCplayer2_4 = new TranslateTransition();
                card2_4.setScaleX(1);
                card2_4.setScaleY(1);
                TCplayer2_4.setNode(card2_4);
                TCplayer2_4.setDuration(Duration.millis(300));
                TCplayer2_4.setDelay(Duration.millis(300));
                TCplayer2_4.setToY(5);
                TCplayer2_4.play();
            }
            if (cardp2_5) {
                TranslateTransition TCplayer2_5 = new TranslateTransition();
                card2_5.setScaleX(1);
                card2_5.setScaleY(1);
                TCplayer2_5.setNode(card2_5);
                TCplayer2_5.setDuration(Duration.millis(300));
                TCplayer2_5.setDelay(Duration.millis(300));
                TCplayer2_5.setToY(5);
                TCplayer2_5.play();
            }
        }
        if (player2) {
            firstcard1.setScaleX(1);
            firstcard1.setScaleY(1);
            TCplayer1_back.setNode(firstcard1);
            TCplayer1_back.setDelay(Duration.millis(300));
            TCplayer1_back.setDuration(Duration.millis(300));
            TCplayer1_back.setToY(5);
            //TCplayer1_back.setToX(50);
            TCplayer1_back.play();

            card1_1.setScaleX(1);
            card1_1.setScaleY(1);
            TCplayer1_1.setNode(card1_1);
            TCplayer1_1.setDelay(Duration.millis(300));
            TCplayer1_1.setDuration(Duration.millis(300));
            TCplayer1_1.setToY(5);
            TCplayer1_1.play();

            cardplayer1_2.setScaleX(1);
            cardplayer1_2.setScaleY(1);
            TCplayer1_2.setNode(cardplayer1_2);
            TCplayer1_2.setDuration(Duration.millis(300));
            TCplayer1_2.setDelay(Duration.millis(300));
            TCplayer1_2.setToY(5);
            TCplayer1_2.play();

            //-----------------player2----------------------// 
            firstcard2.setScaleX(0.6);
            firstcard2.setScaleY(0.6);
            TCplayer2_back.setNode(firstcard2);
            TCplayer2_back.setDuration(Duration.millis(300));
            TCplayer2_back.setDelay(Duration.millis(300));
            TCplayer2_back.setToY(-250);
            TCplayer2_back.play();

            card2_1.setScaleX(0.6);
            card2_1.setScaleY(0.6);
            TCplayer2_1.setNode(card2_1);
            TCplayer2_1.setDuration(Duration.millis(300));
            TCplayer2_1.setDelay(Duration.millis(300));
            TCplayer2_1.setToY(-250);
            TCplayer2_1.play();

            card2_2.setScaleX(0.6);
            card2_2.setScaleY(0.6);
            TCplayer2_2.setNode(card2_2);
            TCplayer2_2.setDuration(Duration.millis(300));
            TCplayer2_2.setDelay(Duration.millis(300));
            TCplayer2_2.setToY(-250);
            TCplayer2_2.play();
            T.setNode(textplay);
            T.setDuration(Duration.millis(300));
            T.setToX(50);
            T.play();
            if (cardp1_3) {
                TranslateTransition TCplayer1_3 = new TranslateTransition();
                card1_3.setScaleX(1);
                card1_3.setScaleY(1);
                TCplayer1_3.setNode(card1_3);
                TCplayer1_3.setDuration(Duration.millis(300));
                TCplayer1_3.setDelay(Duration.millis(300));
                TCplayer1_3.setToY(5);
                TCplayer1_3.play();
            }
            if (cardp1_4) {
                TranslateTransition TCplayer1_4 = new TranslateTransition();
                card1_4.setScaleX(1);
                card1_4.setScaleY(1);
                TCplayer1_4.setNode(card1_4);
                TCplayer1_4.setDuration(Duration.millis(300));
                TCplayer1_4.setDelay(Duration.millis(300));
                TCplayer1_4.setToY(5);
                TCplayer1_4.play();
            }
            if (cardp1_5) {
                TranslateTransition TCplayer1_5 = new TranslateTransition();
                card1_5.setScaleX(1);
                card1_5.setScaleY(1);
                TCplayer1_5.setNode(card1_5);
                TCplayer1_5.setDuration(Duration.millis(300));
                TCplayer1_5.setDelay(Duration.millis(300));
                TCplayer1_5.setToY(5);
                TCplayer1_5.play();
            }
            if (cardp2_3) {
                TranslateTransition TCplayer2_3 = new TranslateTransition();
                card2_3.setScaleX(0.6);
                card2_3.setScaleY(0.6);
                TCplayer2_3.setNode(card2_3);
                TCplayer2_3.setDuration(Duration.millis(300));
                TCplayer2_3.setDelay(Duration.millis(300));
                TCplayer2_3.setToY(-250);
                TCplayer2_3.play();
            }
            if (cardp2_4) {
                TranslateTransition TCplayer2_4 = new TranslateTransition();
                card2_4.setScaleX(0.6);
                card2_4.setScaleY(0.6);
                TCplayer2_4.setNode(card2_4);
                TCplayer2_4.setDuration(Duration.millis(300));
                TCplayer2_4.setDelay(Duration.millis(300));
                TCplayer2_4.setToY(-250);
                TCplayer2_4.play();
            }
            if (cardp2_5) {
                TranslateTransition TCplayer2_5 = new TranslateTransition();
                card2_5.setScaleX(0.6);
                card2_5.setScaleY(0.6);
                TCplayer2_5.setNode(card2_5);
                TCplayer2_5.setDuration(Duration.millis(300));
                TCplayer2_5.setDelay(Duration.millis(300));
                TCplayer2_5.setToY(-250);
                TCplayer2_5.play();
            }
        }
        if (player1) {
            player2 = true;
            player1 = false;
            textplayer.setText("Player 1");
            if (countp1 > 2) {
                textnoplay.setText((sum1 - deck[0]) + "+?/21");
            } else {
                textnoplay.setText(deck[2] + "+?/21");
            }
            if (countp2 > 2) {
                textplay.setText((sum2 - deck[1]) + "+?/21");
            } else {
                textplay.setText(deck[3] + "+?/21");
            }
        } else {
            player1 = true;
            player2 = false;
            textplayer.setText("Player 2");
            if (countp2 > 2) {
                textnoplay.setText((sum2 - deck[1]) + "+?/21");
            } else {
                textnoplay.setText(deck[3] + "+?/21");
            }
            if (countp1 > 2) {
                textplay.setText((sum1 - deck[0]) + "+?/21");
            } else {
                textplay.setText(deck[2] + "+?/21");
            }
        }
    }

}

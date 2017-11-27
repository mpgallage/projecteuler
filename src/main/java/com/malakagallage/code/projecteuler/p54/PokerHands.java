package com.malakagallage.code.projecteuler.p54;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : maal (Malaka Gallage)
 * @since : 24/11/17
 */
public class PokerHands {

    public static void main(String[] args) throws IOException {

        List<Game> games = decode();
        int player1Count = 0;
        int player2Count = 0;
        int tieCount = 0;

        for (Game g : games) {
            int result = compare(g);
            if (result == 0) {
                tieCount++;
            } else if (result == 1) {
                player1Count++;
            } else {
                player2Count++;
            }
        }

        System.out.println(player1Count + " " + player2Count + " " + tieCount);

    }


    private static List<Game> decode() throws IOException {

        List<Game> games = new ArrayList<Game>();

        FileReader fr = new FileReader("src/main/resources/p054_poker.txt");
        BufferedReader br = new BufferedReader(fr);

        String line;

        while ((line =br.readLine()) != null) {

            String[] split = line.split("\\s");
            Game game = new Game();

            for (int i = 0; i < 10; i++) {
                String r = split[i].substring(0,1);
                String s = split[i].substring(1);

                Card card = new Card(Card.SUIT.valueOf(s), Card.RANK.valueOf("N" + r));
                if (i < 5) {
                    game.getHand1()[i] = card;
                } else {
                    game.getHand2()[i - 5] = card;
                }
            }
            games.add(game);
        }

        return games;
    }


    private static int compare(Game game) {

        HandValue handValue1 = game.valueHand(game.getHand1());
        HandValue handValue2 = game.valueHand(game.getHand2());

        Game.HAND_RANK handRank1 = handValue1.getHandRank();
        Game.HAND_RANK handRank2 = handValue2.getHandRank();

        int value1 = handRank1.getValue();
        int value2 = handRank2.getValue();

        if ( value1 > value2) {
            return 1;

        } else if (value1 == value2) {

            if (handRank1 == Game.HAND_RANK.FOUR_OF_A_KIND) {
                return handValue1.getFourValue() > handValue2.getFourValue() ? 1 : 2;

            } else if (handRank1 == Game.HAND_RANK.THREE_OF_A_KIND) {
                return handValue1.getThreeValue() > handValue2.getThreeValue() ? 1 : 2;

            } else if (handRank1 == Game.HAND_RANK.FULL_HOUSE) {
                if (handValue1.getThreeValue() == handValue2.getThreeValue()) {
                    if (handValue1.getFirstTwoValue() != handValue2.getFirstTwoValue()) {
                        return handValue1.getFirstTwoValue() > handValue2.getFirstTwoValue() ? 1 : 2;
                    }

                } else {
                    return handValue1.getThreeValue() > handValue2.getThreeValue() ? 1 : 2;
                }

            } else if (handRank1 == Game.HAND_RANK.TWO_PAIRS) {
                if (handValue1.getSecondTwoValue() == handValue2.getSecondTwoValue()) {
                    if (handValue1.getFirstTwoValue() != handValue2.getFirstTwoValue()) {
                        return handValue1.getFirstTwoValue() > handValue2.getFirstTwoValue() ? 1 : 2;
                    }

                } else {
                    return handValue1.getSecondTwoValue() > handValue2.getSecondTwoValue() ? 1 : 2;
                }

            } else if (handRank1 == Game.HAND_RANK.ONE_PAIR) {
                if (handValue1.getFirstTwoValue() != handValue2.getFirstTwoValue()) {
                    return handValue1.getFirstTwoValue() > handValue2.getFirstTwoValue() ? 1 : 2;
                }

            } else if (handRank1 == Game.HAND_RANK.HIGH_CARD) {
                for (int i = 4; i >= 0; i--) {
                    if (handValue1.getLeftOvers()[i] != handValue2.getLeftOvers()[i]) {
                        return handValue1.getLeftOvers()[i] > handValue2.getLeftOvers()[i] ? 1 : 2;
                    }
                }
            }
        }
        return 0;
    }
}

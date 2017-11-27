package com.malakagallage.code.projecteuler.p54;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : maal (Malaka Gallage)
 * @since : 24/11/17
 */
public class Game {

    private Card[] hand1 = new Card[5];
    private Card[] hand2 = new Card[5];


    public Card[] getHand1() {
        return hand1;
    }

    public Card[] getHand2() {
        return hand2;
    }

    public enum HAND_RANK {

        HIGH_CARD(0), // Highest value card.
        ONE_PAIR(10), // Two cards of the same value.
        TWO_PAIRS(20), // Two different pairs.
        THREE_OF_A_KIND(30), // Three cards of the same value.
        STRAIGHT(40), // All cards are consecutive values.
        FLUSH(50), // All cards of the same suit.
        FULL_HOUSE(60), // Three of a kind and a pair.
        FOUR_OF_A_KIND(70), // Four cards of the same value.
        STRAIGHT_FLUSH(80), // All cards are consecutive values of same suit.
        ROYAL_FLUSH(90); // Ten, Jack, Queen, King, Ace, in same suit.

        private final int value;

        HAND_RANK(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public HandValue valueHand(Card[] hand) {

        HandValue handValue = new HandValue();

        Arrays.sort(hand, new Comparator<Card>() {
            public int compare(Card o1, Card o2) {
                return Integer.compare(o1.getRank().getValue(), o2.getRank().getValue());
            }
        });

        if (isSameSuite(hand)) {

            if (isConsecutive(hand)) {

                if (hand[0].getRank() == Card.RANK.NT) {
                    handValue.setHandRank(HAND_RANK.ROYAL_FLUSH);

                } else {
                    handValue.setHandRank(HAND_RANK.STRAIGHT_FLUSH);
                }

            } else {
                handValue.setHandRank(HAND_RANK.FLUSH);
            }
            handValue.getLeftOvers()[4] = hand[4].getRank().getValue();

        } else if (isConsecutive(hand)) {
            handValue.setHandRank(HAND_RANK.STRAIGHT);
            handValue.getLeftOvers()[4] = hand[4].getRank().getValue();

        } else {
            handValue = checkDups(hand);
        }

        return handValue;
    }

    private boolean isConsecutive(Card[] hand) {
        boolean cons = true;

        for (int i = 1; i < hand.length; i++) {
            if (hand[i].getRank().getValue() != hand[i-1].getRank().getValue() + 1) {
                cons = false;
                break;
            }
        }
        return cons;
    }

    private boolean isSameSuite(Card[] hand) {
        boolean same = true;

        for (int i = 1; i < hand.length; i++) {
            if (hand[i].getSuit() != hand[i-1].getSuit()) {
                same = false;
                break;
            }
        }
        return same;
    }

    private HandValue checkDups(Card[] hand) {

        HandValue handValue = new HandValue();

        for (int i = 0, j; i < hand.length; i=j) {

            for (j = i + 1; j <= hand.length; j++) {

                int diff;

                if (j != 5 && hand[i].getRank().getValue() == hand[j].getRank().getValue()) {
                    // continue;

                } else if ((diff = j - i) > 1){

                    switch (diff) {
                        case 2:
                            if (handValue.getFirstTwoValue() == 0) {
                                handValue.setFirstTwoValue(hand[i].getRank().getValue());
                            } else {
                                handValue.setSecondTwoValue(hand[i].getRank().getValue());
                            }
                            break;
                        case 3:
                            if (handValue.getThreeValue() == 0) {
                                handValue.setThreeValue(hand[i].getRank().getValue());
                            }
                            break;
                        case 4:
                            if (handValue.getFourValue() == 0) {
                                handValue.setFourValue(hand[i].getRank().getValue());
                            }
                            break;
                        default:
                            break;
                    }

                    break;

                } else {
                    handValue.getLeftOvers()[i] = hand[i].getRank().getValue();
                    break;
                }
            }

        }

        if (handValue.getFourValue() != 0) {
            handValue.setHandRank(HAND_RANK.FOUR_OF_A_KIND);
        } else if (handValue.getThreeValue() != 0) {
            if (handValue.getFirstTwoValue() != 0) {
                handValue.setHandRank(HAND_RANK.FULL_HOUSE);
            } else {
                handValue.setHandRank(HAND_RANK.THREE_OF_A_KIND);
            }
        } else if (handValue.getFirstTwoValue() != 0) {
            if (handValue.getSecondTwoValue() != 0) {
                handValue.setHandRank(HAND_RANK.TWO_PAIRS);
            } else {
                handValue.setHandRank(HAND_RANK.ONE_PAIR);
            }
        } else {
            handValue.setHandRank(HAND_RANK.HIGH_CARD);
        }

        return handValue;
    }
}

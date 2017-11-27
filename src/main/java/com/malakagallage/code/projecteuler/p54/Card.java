package com.malakagallage.code.projecteuler.p54;

/**
 * @author : maal (Malaka Gallage)
 * @since : 24/11/17
 */
public class Card {

    private SUIT suit;
    private RANK rank;

    public SUIT getSuit() {
        return suit;
    }

    public RANK getRank() {
        return rank;
    }

    public Card(SUIT suit, RANK rank) {
        this.suit = suit;
        this.rank = rank;
    }


    enum SUIT {
        H,D,C,S;
    }

    enum RANK {
        N2(2),
        N3(3),
        N4(4),
        N5(5),
        N6(6),
        N7(7),
        N8(8),
        N9(9),
        NT(10),
        NJ(11),
        NQ(12),
        NK(13),
        NA(14);

        private final int value;

        RANK(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}

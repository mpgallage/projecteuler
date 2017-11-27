package com.malakagallage.code.projecteuler.p54;

/**
 * @author : maal (Malaka Gallage)
 * @since : 24/11/17
 */
public class HandValue {

    private Game.HAND_RANK handRank;

    private int fourValue;
    private int threeValue;

    private int firstTwoValue;
    private int secondTwoValue;

    private int[] leftOvers = new int[5];


    public Game.HAND_RANK getHandRank() {
        return handRank;
    }

    public void setHandRank(Game.HAND_RANK handRank) {
        this.handRank = handRank;
    }

    public int getFourValue() {
        return fourValue;
    }

    public void setFourValue(int fourValue) {
        this.fourValue = fourValue;
    }

    public int getThreeValue() {
        return threeValue;
    }

    public void setThreeValue(int threeValue) {
        this.threeValue = threeValue;
    }

    public int getFirstTwoValue() {
        return firstTwoValue;
    }

    public void setFirstTwoValue(int firstTwoValue) {
        this.firstTwoValue = firstTwoValue;
    }

    public int getSecondTwoValue() {
        return secondTwoValue;
    }

    public void setSecondTwoValue(int secondTwoValue) {
        this.secondTwoValue = secondTwoValue;
    }

    public int[] getLeftOvers() {
        return leftOvers;
    }
}

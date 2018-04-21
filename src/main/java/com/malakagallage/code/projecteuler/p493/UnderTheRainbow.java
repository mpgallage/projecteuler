package com.malakagallage.code.projecteuler.p493;

import com.malakagallage.code.projecteuler.util.EulerUtils;

/**
 * @author : maal (Malaka Gallage)
 * @since : 12/04/18
 */
public class UnderTheRainbow {


	public static void main(String[] args) {

        System.out.println(7 * (1 - (EulerUtils.nCr(60, 20)/ EulerUtils.nCr(70, 20))));
    }


}

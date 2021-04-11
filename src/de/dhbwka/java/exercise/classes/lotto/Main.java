package de.dhbwka.java.exercise.classes.lotto;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int ballsToDraw = 6;
		int maxBalls = 49;
		Lotto lotto = new Lotto(ballsToDraw, maxBalls);
		int[] randomTip = new int[ballsToDraw];
		Random random = new Random();
		for (int i = 0; i < randomTip.length; i++) {
			randomTip[i] = random.nextInt(maxBalls + 1);
		}
		System.out.println("The makeTip method:");
		lotto.makeTip();
		System.out.println("toString with no drawing before:");
		System.out.println(lotto.toString());
		System.out.println("Drawing:");
		System.out.println(lotto.draw());
		System.out.println("toString after drawing:");
		System.out.println(lotto.toString());
		System.out.println("correctTips method:");
		System.out.println(lotto.correctTips());
		System.out.println("Random tip:");
		lotto.makeTip(randomTip); 
		System.out.println(Arrays.toString(lotto.getTip()));
	}

}

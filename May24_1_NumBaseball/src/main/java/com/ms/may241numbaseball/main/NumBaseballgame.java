package com.ms.may241numbaseball.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
//첫 접속했을때 답을 뽑아야
//그 답을 향해 가야

//답을 기억하고 있는 심판:홍길동

//판정하는 심판: 김길동->답 모르는데?
public class NumBaseballgame {
	private String gameAns;
	private int turn;
	private static final NumBaseballgame NBG = new NumBaseballgame();

	public NumBaseballgame() {
	}

	public static NumBaseballgame getNBG() {
		return NBG;
	}

	public void getgameAns() {
		Random r = new Random();
		int ans = r.nextInt(976) + 12;
		gameAns = String.format("%03d", ans);
		// 3자리고정시키면서 한자리 혹은 두자리 걱정x
		if (gameAns.charAt(0) == gameAns.charAt(1) || gameAns.charAt(1) == gameAns.charAt(2)
				|| gameAns.charAt(2) == gameAns.charAt(0)) {
			getgameAns();

		}
		System.out.println(gameAns);
		turn=0;

	}

	public void judge(HttpServletRequest request) {
		turn++;
		String userAns = request.getParameter("n");
		int strike=0;
		int ball=0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (gameAns.charAt(i) == userAns.charAt(j)) {
					if (i == j) {
						
						strike++;

					} else {
						
						ball++;
					}
					break;
				}

			}

		}
		request.setAttribute("s", strike);
		request.setAttribute("b",ball);
		if (strike==3) {
			request.setAttribute("t", turn+"턴만에 삼진");
			getgameAns();
			
		}
	}

}

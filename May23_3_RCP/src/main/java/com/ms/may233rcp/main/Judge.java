package com.ms.may233rcp.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class Judge {
	private int win;
	private int lose;
	private int draw;

	private static final Judge JDG = new Judge();

	public Judge() {
	}

	public static Judge getJDG() {
		return JDG;

	}

	public void start(HttpServletRequest request) {
		request.setAttribute("uh", "img/start.gif");
		request.setAttribute("ch", "img/start.gif");

	}

	public void getJudge(HttpServletRequest request) {
		int userHand = Integer.parseInt(request.getParameter("hand"));
		int comHand = new Random().nextInt(3) + 1;
		request.setAttribute("uh", "img/h" + userHand + ".jpg");
		request.setAttribute("ch", "img/h" + comHand + ".jpg");

		if (userHand - comHand == -1 || userHand - comHand == 2) {
			request.setAttribute("result", "패배");
			lose++;

		} else if (userHand - comHand == -2 || userHand - comHand == 1) {
			request.setAttribute("result", "승리");
			win++;

		} else {
			request.setAttribute("result", "무");
			draw++;
		}

		String wdl = String.format("%d승 %d무 %d패", win, draw, lose);
		request.setAttribute("wdl", wdl);
	}

}

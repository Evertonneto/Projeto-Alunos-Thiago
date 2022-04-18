package br.edu.unipe.main;

import java.util.Scanner;

public class InputKeyboard {
	
	private Scanner input = new Scanner(System.in);
	
	public String getInputString() {
		return input.nextLine();
	}
	
	public int getInputInterger() {
		return Integer.parseInt(input.nextLine());
	}
	
	public double getInputDouble() {
		return input.nextDouble();
	}

}


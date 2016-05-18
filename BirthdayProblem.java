import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BirthdayProblem {

	public static double birthdaySim(int numPeople, int numTrials) {
		Random generator = new Random();
		int count = 0;
		ArrayList<Integer> birthdays = new ArrayList<Integer>();

		for (int j = 0; j < numTrials; j++) {
			for (int i = 0; i < numPeople; i++) {
				birthdays.add(generator.nextInt(365) + 1);
			}

			Set s = new HashSet(birthdays);
			if (s.size() != numPeople) {
				count++;
			}
		
			birthdays.clear();
		}
		
		return (count / (double) numTrials) * 100;
	}
	
	public static double expectedProb(int numPeople) {
		double prob = 1, intermediate = 1;
		for (int i = 1; i < numPeople; i++) {
			intermediate = intermediate * (365 - i) / 365;
		}
		
		return (prob - intermediate) * 100;
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Number of people: ");
		int numPeople = keyboard.nextInt();

		System.out.print("Number of trials: ");
		int numTrials = keyboard.nextInt();
		
		System.out.println("Expected probability: " + expectedProb(numPeople) + "%");
		System.out.println("Probability of matches: " + birthdaySim(numPeople, numTrials) + "%");
	}

}

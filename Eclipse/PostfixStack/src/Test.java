import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: April 1, 2021 Last Date Modified: April 2, 2021
 *
 * Class to test the application of stacks and queues
 */
public class Test {

	public static void main(String[] args) {
		// Part 1
		Stack<Integer> postfixStack = new Stack<>();
		Scanner keyboard = new Scanner(System.in);
		String postfix;
		String operation = null;

		do {
			try { // looking for pop error
				System.out.println("Enter a postfix expression: "); // prompting the user
				postfix = keyboard.nextLine();
				String[] tokens = postfix.split(" ");
				for (int i = 0; i < tokens.length; i++) {
					if (Character.isDigit(tokens[i].charAt(0))) { // first element is a digit
						int operand = Integer.parseInt(tokens[i]);
						postfixStack.push(operand);
					} else { // operation

						int op1 = postfixStack.pop();
						int op2 = postfixStack.pop();

						switch (tokens[i]) {
						case "+":
							postfixStack.push(op2 + op1);
							break;
						case "-":
							postfixStack.push(op2 - op1); // order with subtraction and division matters
							break;
						case "*":
							postfixStack.push(op2 * op1);
							break;
						case "/":
							postfixStack.push(op2 / op1);
							break;
						}
					}

				}

				int result = postfixStack.pop();

				if (postfixStack.empty()) {
					System.out.println("Postfix expression result: " + result);
				} else {
					System.out.println("Malformed expression.");
				}
				System.out.println("Do you want to evaluate another postfix expression? (yes/no): ");
				// prompt user to run again
				operation = keyboard.nextLine().toLowerCase(); // make lowercase just in case
			} catch (EmptyStackException e) { // handling the pop exception
				System.out.println("postfix expression malformed.");
			}
		} while (!operation.equals("no")); // user entering no stops the first part of the program

		// Part 2

		LinkedList<Integer> customerQueue = new LinkedList<>();
		// given values
		int simulationTime = 60 * 8;
		double arrivalRate = (double) 25 / 60;
		int serviceTime = 5;
		int time;
		int customers = 0;
		int teller = 0;
		int totalWaitingTime = 0;
		int totalQueueSize = 0;

		for (time = 0; time < simulationTime; time++) {

			// arrivals
			double random = Math.random();
			if (random < arrivalRate) {
				customerQueue.offer(time);
				customers++;
			}
			// servicing
			if (teller == 0 && customerQueue.size() != 0) {
				int arrivalTime = customerQueue.poll();
				totalWaitingTime += (time - arrivalTime);
				teller = 5;
			} else if (teller != 0) { // elapsing the service time
				teller--;
			}
			totalQueueSize += customerQueue.size();
		}
		while (customerQueue.size() != 0) {
			int t = customerQueue.poll(); //polls remaining customers adds adds their waiting time to the total
			totalWaitingTime += (simulationTime - t);
		}
		// program output as formatted strings
		System.out.println("\nSimulation Parameters: ");
		System.out.println(String.format("Simulation time: %d", simulationTime));
		System.out.println(String.format("Arrival Rate: %-4.2f", arrivalRate));
		System.out.println(String.format("Service Time: %d", serviceTime));
		// I chose String.format here to limit the decimal places displayed
		System.out.println("\nSimulation output: ");
		System.out.println("Number of customers: " + customers);
		double averageQueueSize = (double) totalQueueSize / simulationTime;
		System.out.println(String.format("Average number of customers waiting in the queue: %-4.2f", averageQueueSize));
		double averageWaitingTime = (double) totalWaitingTime / customers;
		System.out.println(String.format("Average waiting time per customer: %-4.2f", averageWaitingTime));
	}
}

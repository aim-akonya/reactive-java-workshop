package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise7 {

	public static void main(String[] args) throws IOException {

		// Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

		// Print all values from intNumbersFlux that's greater than 5
		// TODO: Write code here
		ReactiveSources.intNumbersFlux().filter(val -> val > 5).subscribe(System.out::println);

		// Print 10 times each value from intNumbersFlux that's greater than 5
		// TODO: Write code here
		ReactiveSources.intNumbersFlux().filter(val -> val > 5).map(entry -> entry * 10).subscribe(System.out::println);

		// Print 10 times each value from intNumbersFlux for the first 3 numbers emitted
		// that's greater than 5
		// TODO: Write code here
		ReactiveSources.intNumbersFlux().filter(entry -> entry > 5).take(3).map(entry -> entry * 10)
				.subscribe(System.out::println);

		// Print each value from intNumbersFlux that's greater than 20. Print -1 if no
		// elements are found
		// TODO: Write code here
		ReactiveSources.intNumbersFlux().filter(value -> value > 20).defaultIfEmpty(-1).subscribe(System.out::println);

		// Switch ints from intNumbersFlux to the right user from userFlux

		ReactiveSources.intNumbersFlux().flatMap(i -> ReactiveSources.userFlux().filter(user -> user.getId() == i))
				.subscribe(System.out::println);

		// Print only distinct numbers from intNumbersFluxWithRepeat

		ReactiveSources.intNumbersFluxWithRepeat().distinct().subscribe(System.out::println);

		// Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
		ReactiveSources.intNumbersFluxWithRepeat().distinctUntilChanged().subscribe(System.out::println);

		System.out.println("Press a key to end");
		System.in.read();
	}

}

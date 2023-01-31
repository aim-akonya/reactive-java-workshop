package io.javabrains.reactiveworkshop;

public class Exercise1 {

	public static void main(String[] args) {

		// Use StreamSources.intNumbersStream() and StreamSources.userStream()

		// Print all numbers in the intNumbersStream stream
		StreamSources.intNumbersStream().forEach(entry -> System.out.println(entry));

		// Print numbers from intNumbersStream that are less than 5
		StreamSources.intNumbersStream().filter(entry -> entry < 5).forEach(entry -> System.out.println(entry));

		// Print the second and third numbers in intNumbersStream that's greater than 5
		StreamSources.intNumbersStream().filter(entry -> entry < 5).skip(1).limit(2)
				.forEach(entry -> System.out.println(entry));

		// Print the first number in intNumbersStream that's greater than 5.
		// If nothing is found, print -1
		int value = StreamSources.intNumbersStream().filter(entry -> entry > 5).findFirst().orElse(-1);
		System.out.println(value);

		// Print first names of all users in userStream
		StreamSources.userStream().map(entry -> entry.getFirstName()).forEach(name -> System.out.println(name));

		// Print first names in userStream for users that have IDs from number stream
		StreamSources.userStream()
				.filter(entry -> StreamSources.intNumbersStream().anyMatch(number -> number == entry.getId()))
				.forEach(entry -> System.out.println(entry));

		// or
		StreamSources.intNumbersStream().flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
				.forEach(entry -> System.out.println(entry.getFirstName()));

		// parallel streams
		StreamSources.userStream().parallel().forEach(entry -> System.out.println(entry.getFirstName()));
	}
}

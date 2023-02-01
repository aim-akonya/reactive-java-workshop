package io.javabrains.reactiveworkshop;

import java.io.IOException;

import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;

public class Exercise5 {

	public static void main(String[] args) throws IOException {

		// Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

		// Subscribe to a flux using the error and completion hooks
		// TODO: Write code here
		ReactiveSources.intNumbersFlux().subscribe(number -> System.out.println(number), err -> err.printStackTrace(),
				() -> System.out.println("Completed message"));

		// Subscribe to a flux using an implementation of BaseSubscriber
		// TODO: Write code here
		ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

		System.out.println("Press a key to end");
		System.in.read();
	}
}

class MySubscriber<T> extends BaseSubscriber<T> {

	@Override
	public void hookOnSubscribe(Subscription subscription) {
		System.out.println("Subscription happened");
		this.request(1);
	}

	@Override
	public void hookOnNext(T value) {
		System.out.println(value + "received");
		this.request(1);
	}
}

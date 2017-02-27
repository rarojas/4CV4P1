package com.escom.distribuidos.cliente.async;

import java.util.concurrent.Callable;

public class AsyncRequest<T> implements Runnable {

	private final Callable<T> task;
	private final AsyncRequestListener<T> callback;

	public AsyncRequest(Callable<T> task, AsyncRequestListener<T> callback) {
		this.task = task;
		this.callback = callback;
	}

	@Override
	public void run() {
		try {
			T result = task.call();
			callback.onComplete(result);
		} catch (Exception e) {
			e.printStackTrace();
			callback.onError(e);
		}

	}

}

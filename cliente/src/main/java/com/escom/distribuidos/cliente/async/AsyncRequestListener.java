package com.escom.distribuidos.cliente.async;

public interface AsyncRequestListener<T> {

	void onComplete(T result);

	void onError(Exception e);
}

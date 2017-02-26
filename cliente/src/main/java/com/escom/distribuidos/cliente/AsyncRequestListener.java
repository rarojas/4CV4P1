package com.escom.distribuidos.cliente;

public interface AsyncRequestListener<T> {

	void onComplete(T result);

	void onError(Exception e);
}

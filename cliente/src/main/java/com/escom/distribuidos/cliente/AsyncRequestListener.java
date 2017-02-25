package com.escom.distribuidos.cliente;

public interface AsyncRequestListener<T> {

	void onComplete(T result);
}

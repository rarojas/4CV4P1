package com.escom.distribuidos.cliente;

import java.io.IOException;

import com.escom.distribuidos.core.socket.Peticion;

public interface SocketInterface {

	<T> T sendRequest(Peticion peticion);

	void close() throws IOException;

}

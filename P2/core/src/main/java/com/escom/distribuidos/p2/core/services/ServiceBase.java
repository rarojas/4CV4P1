package com.escom.distribuidos.p2.core.services;

import java.io.Serializable;
import java.util.List;

public interface ServiceBase<T, DTO> extends Serializable {

	void save(DTO dto);

	void update(DTO dto);

	DTO get(Serializable id);

	List<DTO> get();

	void delete(DTO dto);
}

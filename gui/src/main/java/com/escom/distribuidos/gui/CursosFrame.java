package com.escom.distribuidos.gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.escom.distribuidos.cliente.AsyncRequestListener;
import com.escom.distribuidos.cliente.Cliente;
import com.escom.distribuidos.cliente.CursosServices;
import com.escom.distribuidos.core.reflection.ReflectionUtils;
import com.escom.distribuidos.model.CursoEntity;

public class CursosFrame extends JInternalFrame {

	private static final long serialVersionUID = 5768806463114248961L;
	private static CursosFrame INSTANCE;
	private CursosServices cursosServices;
	private JTable alumnosTable;
	private DefaultTableModel model;

	private CursosFrame() {
		super("Cursos", true, true, true);
		initialize();
	}

	public static CursosFrame getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CursosFrame();
		}
		return INSTANCE;
	}

	private void initialize() {
		setSize(300, 300);
		setLocation(30, 30);
		model = new DefaultTableModel();
		String[] columns = ReflectionUtils.getColumnNames(CursoEntity.class);
		for (String column : columns) {
			model.addColumn(column);
		}
		alumnosTable = new JTable(model);
		alumnosTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scroll = new JScrollPane(alumnosTable);
		add(scroll, BorderLayout.CENTER);

		cursosServices = new CursosServices(Cliente.getInstance());
		cursosServices.all(new AsyncRequestListener<List<CursoEntity>>() {
			@Override
			public void onComplete(List<CursoEntity> result) {
				for (CursoEntity cursoEntity : result) {
					model.addRow(ReflectionUtils.getValues(cursoEntity, CursoEntity.class));
				}
			}
		});
	}
}

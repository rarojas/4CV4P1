package com.escom.distribuidos.gui;


import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.escom.distribuidos.cliente.AlumnosServices;
import com.escom.distribuidos.cliente.AsyncRequestListener;
import com.escom.distribuidos.cliente.Cliente;
import com.escom.distribuidos.core.reflection.ReflectionUtils;
import com.escom.distribuidos.model.AlumnoEntity;

public class AlumnosFrame extends JInternalFrame {

	private static final long serialVersionUID = 5768806463114248961L;
	private static AlumnosFrame INSTANCE;
	private AlumnosServices alumnosServices;
	private JTable alumnosTable;
	private DefaultTableModel model;

	private void initialize() {
		setSize(300, 300);
		setLocation(30, 30);
		model = new DefaultTableModel();
		String[] columns = ReflectionUtils.getColumnNames(AlumnoEntity.class);
		for (String column : columns) {
			model.addColumn(column);
		}
		alumnosTable = new JTable(model);
		alumnosTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scroll = new JScrollPane(alumnosTable);
		add(scroll, BorderLayout.CENTER);

		alumnosServices = new AlumnosServices(Cliente.getInstance());
		alumnosServices.all(new AsyncRequestListener<List<AlumnoEntity>>() {
			@Override
			public void onComplete(List<AlumnoEntity> result) {
				for (AlumnoEntity alumnoEntity : result) {
					model.addRow(ReflectionUtils.getValues(alumnoEntity, AlumnoEntity.class));
				}
			}
		});
	}

	public AlumnosFrame() {
		super("Alumnos", true, true, true);
		initialize();
	}

	public static AlumnosFrame getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AlumnosFrame();
		}
		return INSTANCE;
	}
}

package com.escom.distribuidos.gui.frames;


import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.escom.distribuidos.cliente.Cliente;
import com.escom.distribuidos.cliente.async.AsyncRequestListener;
import com.escom.distribuidos.cliente.services.AsignacionServices;
import com.escom.distribuidos.core.reflection.ReflectionUtils;
import com.escom.distribuidos.model.Asignacion;

public class AsignacionFrame extends JInternalFrame {

	private static final long serialVersionUID = 5768806463114248961L;
	private static AsignacionFrame INSTANCE;
	private AsignacionServices asignacionServices;
	private JTable alumnosTable;
	private DefaultTableModel model;

	private void initialize() {
		setSize(300, 300);
		setLocation(30, 30);
		model = new DefaultTableModel();
		String[] columns = ReflectionUtils.getColumnNames(Asignacion.class);
		for (String column : columns) {
			model.addColumn(column);
		}
		alumnosTable = new JTable(model);
		alumnosTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scroll = new JScrollPane(alumnosTable);
		add(scroll, BorderLayout.CENTER);

		asignacionServices = new AsignacionServices(Cliente.getInstance());
		asignacionServices.all(new AsyncRequestListener<List<Asignacion>>() {
			@Override
			public void onComplete(List<Asignacion> result) {
				for (Asignacion alumnoEntity : result) {
					model.addRow(ReflectionUtils.getValues(alumnoEntity, Asignacion.class));
				}
			}
			@Override
			public void onError(Exception e) {
			}
		});
	}

	public AsignacionFrame() {
		super("Asignacion", true, true, true);
		initialize();
	}

	public static AsignacionFrame getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AsignacionFrame();
		}
		return INSTANCE;
	}
}

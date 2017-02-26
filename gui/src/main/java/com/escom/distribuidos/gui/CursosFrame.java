package com.escom.distribuidos.gui;

import java.awt.BorderLayout;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
	private JTable cursoTable;
	private DefaultTableModel model;
	private FormCurso panel;

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
		cursoTable = new JTable(model);
		cursoTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scroll = new JScrollPane(cursoTable);
		add(scroll, BorderLayout.CENTER);

		panel = new FormCurso();
		add(panel, BorderLayout.WEST);

		cursosServices = new CursosServices(Cliente.getInstance());
		cursosServices.all(new AsyncRequestListener<List<CursoEntity>>() {
			@Override
			public void onComplete(List<CursoEntity> result) {
				for (CursoEntity cursoEntity : result) {
					model.addRow(ReflectionUtils.getValues(cursoEntity, CursoEntity.class));
				}
			}

			@Override
			public void onError(Exception e) {

			}
		});

		cursoTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = cursoTable.getSelectedRow();
				if (row != -1) {
					Vector data = (Vector) model.getDataVector().elementAt(row);
					panel.txtNombre.setText((String) data.get(1));

					Calendar cal = Calendar.getInstance();
					cal.setTime((Date) data.get(2));
					panel.txtFInicio.getModel().setDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
							cal.get(Calendar.DAY_OF_MONTH));
					panel.txtFInicio.getModel().setSelected(true);

					cal.setTime((Date) data.get(3));
					panel.txtFTermino.getModel().setDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
							cal.get(Calendar.DAY_OF_MONTH));
					panel.txtFTermino.getModel().setSelected(true);

					panel.textCosto.setText(((BigDecimal) data.get(4)).toString());
					cursosServices.getCursoByAlumno((int) data.get(0), new AsyncRequestListener<List<CursoEntity>>() {

						@Override
						public void onError(Exception e) {

						}

						@Override
						public void onComplete(List<CursoEntity> result) {
							DefaultListModel<CursoEntity> model = new DefaultListModel<>();
							for (CursoEntity curso : result) {
								model.addElement(curso);
							}
							panel.list.setModel(model);
						}
					});


				}
			}
		});



	}
}

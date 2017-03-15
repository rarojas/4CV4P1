package com.escom.distribuidos.gui.frames;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.escom.distribuidos.cliente.Cliente;
import com.escom.distribuidos.cliente.async.AsyncRequestListener;
import com.escom.distribuidos.cliente.services.AlumnosServices;
import com.escom.distribuidos.core.reflection.ReflectionUtils;
import com.escom.distribuidos.gui.FormCurso;
import com.escom.distribuidos.gui.form.FormAlumno;
import com.escom.distribuidos.model.AlumnoEntity;
import com.escom.distribuidos.model.CursoEntity;

public class AlumnosFrame extends JInternalFrame {

	private static final long serialVersionUID = 5768806463114248961L;
	private static AlumnosFrame INSTANCE;
	private AlumnosServices alumnosServices;
	private JTable alumnosTable;
	private DefaultTableModel model;
	private FormAlumno panel;

	

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
		
		panel = new FormAlumno();
		add(panel, BorderLayout.WEST);
		
		alumnosServices = new AlumnosServices(Cliente.getInstance());
		getAlumnos();
		
		
		panel.btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setModel();
				alumnosServices.save(panel.model, new AsyncRequestListener<Integer>() {
					@Override
					public void onError(Exception e) {
						JOptionPane.showMessageDialog(null, "Error :(");
					}

					@Override
					public void onComplete(Integer result) {
						JOptionPane.showMessageDialog(null, "Ok");
						getAlumnos();

					}
				});
			}
		});

		panel.btnNuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.model = new AlumnoEntity();
				panel.updateDataUI();

			}
		});
		
		
		panel.btnBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				alumnosServices.delete(panel.model.getIdAlumno(), new AsyncRequestListener<Integer>() {
					@Override
					public void onError(Exception e) {
						JOptionPane.showMessageDialog(null, "Error :(");
					}

					@Override
					public void onComplete(Integer result) {
						JOptionPane.showMessageDialog(null, "Ok");
						getAlumnos();
					}
				});
			}
		});

		alumnosTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = alumnosTable.getSelectedRow();
				if (row != -1) {

					Vector data = (Vector) model.getDataVector().elementAt(row);
					
					panel.model.setIdAlumno((int) data.get(0));
					panel.model.setNombre((String) data.get(1));
					panel.model.setPaterno((String) data.get(2));
					panel.model.setMaterno((String) data.get(3));
					panel.model.setEmail((String) data.get(4));
					panel.model.setCalle((String) data.get(5));
					panel.model.setNumero((String) data.get(6));
					panel.model.setColonia((String) data.get(7));
					panel.model.setDelegacion((String) data.get(8));
					panel.model.setEntidad((String) data.get(9));
					panel.model.setNoTelefono((String) data.get(10));

					panel.updateDataUI();

				}
			}
		});
	}
	
	
	public void getAlumnos(){
		while (model.getRowCount() > 0) {
			for (int i = 0; i < model.getRowCount(); ++i) {
				model.removeRow(i);
			}
		}
	    alumnosServices.all(new AsyncRequestListener<List<AlumnoEntity>>() {
			@Override
			public void onComplete(List<AlumnoEntity> result) {
				for (AlumnoEntity alumnoEntity : result) {
					model.addRow(ReflectionUtils.getValues(alumnoEntity, AlumnoEntity.class));
				}
			}
			@Override
			public void onError(Exception e) {
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

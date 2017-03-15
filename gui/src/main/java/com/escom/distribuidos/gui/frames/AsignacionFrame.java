package com.escom.distribuidos.gui.frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import com.escom.distribuidos.cliente.services.AsignacionServices;
import com.escom.distribuidos.cliente.services.CursosServices;
import com.escom.distribuidos.core.reflection.ReflectionUtils;
import com.escom.distribuidos.gui.form.FormAsignacion;
import com.escom.distribuidos.model.AlumnoEntity;
import com.escom.distribuidos.model.Asignacion;
import com.escom.distribuidos.model.CursoEntity;

public class AsignacionFrame extends JInternalFrame {

	private static final long serialVersionUID = 5768806463114248961L;
	private static AsignacionFrame INSTANCE;
	private AsignacionServices asignacionServices;
	private JTable asignacionTable;
	private DefaultTableModel model;
	private FormAsignacion panel;
	private CursosServices cursosServices;
	private AlumnosServices alumnosServices;

	private void initialize() {
		setSize(300, 300);
		setLocation(30, 30);
		model = new DefaultTableModel();
		String[] columns = ReflectionUtils.getColumnNames(Asignacion.class);
		for (String column : columns) {
			model.addColumn(column);
		}
		asignacionTable = new JTable(model);

		panel = new FormAsignacion();
		add(panel, BorderLayout.WEST);

		asignacionTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scroll = new JScrollPane(asignacionTable);
		add(scroll, BorderLayout.CENTER);

		asignacionServices = new AsignacionServices(Cliente.getInstance());
		alumnosServices = new AlumnosServices(Cliente.getInstance());
		cursosServices = new CursosServices(Cliente.getInstance());

		getAsignaciones();

		panel.btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setModel();
				asignacionServices.save(panel.model, new AsyncRequestListener<Integer>() {
					@Override
					public void onError(Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}

					@Override
					public void onComplete(Integer result) {
						JOptionPane.showMessageDialog(null, "Ok");
						getAsignaciones();

					}
				});
			}
		});

		panel.btnBorrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setModel();
				asignacionServices.delete(panel.model, new AsyncRequestListener<Integer>() {
					@Override
					public void onError(Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}

					@Override
					public void onComplete(Integer result) {
						JOptionPane.showMessageDialog(null, "Ok");
						getAsignaciones();

					}
				});
			}
		});

		asignacionTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = asignacionTable.getSelectedRow();
				if (row != -1) {

					Vector data = (Vector) model.getDataVector().elementAt(row);

					panel.model.setIdAlumno((int) data.get(0));
					panel.model.setIdCurso((int) data.get(1));
					panel.model.setHorario((String) data.get(2));
					panel.model.setTipoCurso((int) data.get(3));

					panel.updateDataUI();

				}
			}
		});

	}

	public void getAsignaciones() {
		while (model.getRowCount() > 0) {
			for (int i = 0; i < model.getRowCount(); ++i) {
				model.removeRow(i);
			}
		}
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

		alumnosServices.all(new AsyncRequestListener<List<AlumnoEntity>>() {

			@Override
			public void onError(Exception e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onComplete(List<AlumnoEntity> result) {
				panel.updateAlumnos(result);
			}
		});

		cursosServices.all(new AsyncRequestListener<List<CursoEntity>>() {

			@Override
			public void onError(Exception e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onComplete(List<CursoEntity> result) {
				panel.updateCursos(result);

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

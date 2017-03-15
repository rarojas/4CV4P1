package com.escom.distribuidos.gui.frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.escom.distribuidos.cliente.Cliente;
import com.escom.distribuidos.cliente.async.AsyncRequestListener;
import com.escom.distribuidos.cliente.services.CursosServices;
import com.escom.distribuidos.core.reflection.ReflectionUtils;
import com.escom.distribuidos.gui.FormCurso;
import com.escom.distribuidos.model.AlumnoEntity;
import com.escom.distribuidos.model.CursoEntity;

import net.sourceforge.jdatepicker.DateModel;

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

	public void getCursos() {
		while (model.getRowCount() > 0) {
			for (int i = 0; i < model.getRowCount(); ++i) {
				model.removeRow(i);
			}
		}
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
		getCursos();

		panel.btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setModel();
				cursosServices.save(panel.model, new AsyncRequestListener<Integer>() {
					@Override
					public void onError(Exception e) {
						JOptionPane.showMessageDialog(null, "Error :(");
					}

					@Override
					public void onComplete(Integer result) {
						JOptionPane.showMessageDialog(null, "Ok");
						getCursos();

					}
				});
			}
		});

		panel.btnNuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.model = new CursoEntity();
				panel.model.setFechaIncio(new Date());
				panel.model.setFechaTermino(new Date());
				panel.model.setCoutaDeRecuperacion(BigDecimal.valueOf(0.0));
				panel.updateDataUI();

			}
		});

		panel.btnBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cursosServices.delete(panel.model.getIdCurso(), new AsyncRequestListener<Integer>() {
					@Override
					public void onError(Exception e) {
						JOptionPane.showMessageDialog(null, "Error :(");
					}

					@Override
					public void onComplete(Integer result) {
						JOptionPane.showMessageDialog(null, "Ok");
						getCursos();
					}
				});
			}
		});

		cursoTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = cursoTable.getSelectedRow();
				if (row != -1) {

					Vector data = (Vector) model.getDataVector().elementAt(row);
					panel.txtNombre.setText((String) data.get(1));

					panel.model.setIdCurso((int) data.get(0));
					panel.model.setNombre((String) data.get(1));
					panel.model.setFechaIncio((Date) data.get(2));
					panel.model.setFechaTermino((Date) data.get(3));
					panel.model.setCoutaDeRecuperacion((BigDecimal) data.get(4));

					panel.updateDataUI();

				}
			}
		});

	}
}

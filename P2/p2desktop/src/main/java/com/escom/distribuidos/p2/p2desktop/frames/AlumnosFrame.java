package com.escom.distribuidos.p2.p2desktop.frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;

import com.escom.distribuidos.p2.core.dto.AlumnoDto;
import com.escom.distribuidos.p2.core.services.AlumnoServices;

public class AlumnosFrame extends JInternalFrame {

	private static final long serialVersionUID = -8855064060742359358L;
	/**
	 *
	 */

	@Autowired
	private AlumnoServices alumnoServices;

	private JTable alumnosTable;

	public AlumnosFrame() {
		super("Alumnos", true, true, true);
		setSize(640, 480);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		alumnosTable = new JTable();
		alumnosTable.setFillsViewportHeight(true);
		alumnosTable.setPreferredScrollableViewportSize(new Dimension(450, 63));
		alumnosTable.setPreferredSize(new Dimension(450, 63));

		// alumnosTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane(alumnosTable);
		scrollPane.getViewport().setPreferredSize(alumnosTable.getPreferredSize());
		getContentPane().add(scrollPane, BorderLayout.CENTER);

	}

	public void init() {
		setVisible(true);
		List<AlumnoDto> alumnos = alumnoServices.get();

		DefaultTableModel dataModel = new DefaultTableModel();
		dataModel.setColumnIdentifiers(new Object[] { "Nombre", "Paterno", "Materno" });

		for (AlumnoDto alumno : alumnos) {
			Object[] rowData = new Object[] { alumno.getNombre(), alumno.getPaterno(), alumno.getMaterno() };
			dataModel.addRow(rowData);
		}

		alumnosTable.setModel(dataModel);
		dataModel.fireTableDataChanged();

	}
}

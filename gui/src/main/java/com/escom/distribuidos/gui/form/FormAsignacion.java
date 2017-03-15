package com.escom.distribuidos.gui.form;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.escom.distribuidos.model.AlumnoEntity;
import com.escom.distribuidos.model.Asignacion;
import com.escom.distribuidos.model.CursoEntity;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import net.sourceforge.jdatepicker.impl.JDatePickerImpl;

public class FormAsignacion extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 2417696886730745442L;

	public JTextField txtNombre;
	public JDatePickerImpl txtFInicio;
	public JDatePickerImpl txtFTermino;
	public JTextField textCosto;
	public JList<CursoEntity> list;

	private JTextField txtHorario;

	private JTextField txtTipo;

	private JComboBox cursoList;

	private JComboBox alumnoList;

	public List<AlumnoEntity> alumnos = new ArrayList<>();
	public List<CursoEntity> cursos = new ArrayList<>();
	public Asignacion model = new Asignacion();

	public JButton btnSave;

	public JButton btnNuevo;

	public JButton btnBorrar;

	/**
	 * Create the panel.
	 */
	public FormAsignacion() {
		setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"),
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		JLabel lblNewLabel = new JLabel("Alumno");
		add(lblNewLabel, "2, 2");
		JLabel lblNewLabel_1 = new JLabel("Curso");
		add(lblNewLabel_1, "2, 4");

		JLabel lblNewLabel_2 = new JLabel("horario");
		add(lblNewLabel_2, "2, 6");

		JLabel lblCosto = new JLabel("tipo");
		add(lblCosto, "2, 8");

		cursoList = new JComboBox();
		add(cursoList, "6, 2, fill, default");

		alumnoList = new JComboBox();
		add(alumnoList, "6, 4, fill, default");

		txtHorario = new JTextField();
		add(txtHorario, "6, 6, fill, default");
		txtHorario.setColumns(10);

		txtTipo = new JTextField();
		add(txtTipo, "6, 8, fill, default");
		txtTipo.setColumns(10);

		btnSave = new JButton("Guardar");
		add(btnSave, "6, 14");

		btnNuevo = new JButton("Nuevo");
		add(btnNuevo, "6, 16");

		btnBorrar = new JButton("Borrar");
		add(btnBorrar, "6, 18");
	}

	public void setModel() {
		model.setHorario(txtHorario.getText());
		model.setTipoCurso(Integer.parseInt(txtTipo.getText()));
		model.setIdAlumno(alumnos.get(alumnoList.getSelectedIndex()).getIdAlumno());
		model.setIdCurso(cursos.get(cursoList.getSelectedIndex()).getIdCurso());
	}

	public void updateAlumnos(List<AlumnoEntity> alumnos) {
		this.alumnos = alumnos;
		alumnoList.removeAllItems();
		for (AlumnoEntity a : alumnos) {
			alumnoList.addItem(a.getNombre() + " " + a.getPaterno() + " -> " + a.getIdAlumno());
		}
	}

	public void updateCursos(List<CursoEntity> cursos) {
		this.cursos = cursos;
		cursoList.removeAllItems();
		for (CursoEntity a : cursos) {
			cursoList.addItem(a.getNombre() + " -> " + a.getIdCurso());
		}
	}

	public void updateDataUI() {

		int indexAlumno = 0;
		for (AlumnoEntity a : alumnos) {
			if (a.getIdAlumno() == model.getIdAlumno())
				alumnoList.setSelectedIndex(indexAlumno);
			indexAlumno++;
		}
		int indexCurso = 0;
		for (CursoEntity c : cursos) {
			if (c.getIdCurso() == model.getIdCurso())
				cursoList.setSelectedIndex(indexCurso);
			indexCurso++;
		}

		txtHorario.setText(model.getHorario());
		txtTipo.setText(((Integer) model.getTipoCurso()).toString());

	}

}

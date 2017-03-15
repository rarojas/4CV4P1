package com.escom.distribuidos.gui;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.escom.distribuidos.model.AlumnoEntity;
import com.escom.distribuidos.model.CursoEntity;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import net.sourceforge.jdatepicker.DateModel;
import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;

public class FormCurso extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = -768608273908209372L;
	public JTextField txtNombre;
	public JDatePickerImpl txtFInicio;
	public JDatePickerImpl txtFTermino;
	public JTextField textCosto;
	public JList<CursoEntity> list;
	public JButton btnSave;
	public JButton btnNuevo;
	public JButton btnBorrar;
	public CursoEntity model = new CursoEntity(); 

	/**
	 * Create the panel.
	 */
	public FormCurso() {
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

		JLabel lblNewLabel = new JLabel("Nombre");
		add(lblNewLabel, "2, 4");
		txtNombre = new JTextField();
		add(txtNombre, "6, 4, fill, default");
		txtNombre.setColumns(10);
		JLabel lblNewLabel_1 = new JLabel("Fecha Inicio");
		add(lblNewLabel_1, "2, 6");
		txtFInicio = (JDatePickerImpl) JDateComponentFactory.createJDatePicker();
		add(txtFInicio, "6, 6, fill, default");
		JLabel lblNewLabel_2 = new JLabel("Fecha Termino");
		add(lblNewLabel_2, "2, 8");
		txtFTermino = (JDatePickerImpl) JDateComponentFactory.createJDatePicker();
		add(txtFTermino, "6, 8, fill, default");

		JLabel lblCosto = new JLabel("Costo");
		add(lblCosto, "2, 10");

		textCosto = new JTextField();
		add(textCosto, "6, 10, fill, default");
		textCosto.setColumns(10);

		list = new JList<>();
		add(list, "2, 12, 1, 5, fill, fill");

		btnSave = new JButton("Guardar");
		add(btnSave, "6, 14");

		btnNuevo = new JButton("Nuevo");
		add(btnNuevo, "6, 16");

		btnBorrar = new JButton("Borrar");
		add(btnBorrar, "6, 18");

	}
	
	
	public void updateDataUI(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(model.getFechaIncio());
		txtFInicio.getModel().setDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.get(Calendar.DAY_OF_MONTH));
		txtFInicio.getModel().setSelected(true);

		cal.setTime(model.getFechaTermino());
		txtFTermino.getModel().setDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.get(Calendar.DAY_OF_MONTH));
		txtFTermino.getModel().setSelected(true);
		textCosto.setText(model.getCoutaDeRecuperacion().toString());
	}
	
	
	public void setModel(){
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setGroupingSeparator(',');
		symbols.setDecimalSeparator('.');
		String pattern = "#,##0.0#";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
		decimalFormat.setParseBigDecimal(true);

		try {
			model.setCoutaDeRecuperacion((BigDecimal) decimalFormat.parse(textCosto.getText()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		model.setNombre(txtNombre.getText());
		Calendar cal = Calendar.getInstance();
		DateModel<?> date = txtFInicio.getModel();
		cal.set(date.getYear(),date.getMonth(),date.getDay());
		model.setFechaIncio(cal.getTime());
		
		date = txtFTermino.getModel();
		cal.set(date.getYear(),date.getMonth(),date.getDay());
		model.setFechaTermino(cal.getTime());
		
	}

}

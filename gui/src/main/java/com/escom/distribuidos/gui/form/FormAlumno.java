package com.escom.distribuidos.gui.form;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.escom.distribuidos.model.AlumnoEntity;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import net.sourceforge.jdatepicker.DateModel;

public class FormAlumno extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = -5800799399550868660L;
	public JTextField txtNombre;
	public JTextField txtPaterno;
	public JTextField txtMaterno;
	public JTextField txtEmail;
	public JTextField txtCalle;
	public JTextField txtNumero;
	public JTextField txtColonia;
	public JTextField txtDelegacion;
	public JTextField txtEntidad;
	public JTextField txtTelefono;
	public JTextField textCosto;
	public AlumnoEntity model = new AlumnoEntity();
	public JButton btnSave;
	public JButton btnNuevo;
	public JButton btnBorrar;

	/**
	 * Create the panel.
	 */
	public FormAlumno() {
		setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), },
				new RowSpec[] { 
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, 
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, 
						FormSpecs.DEFAULT_ROWSPEC,FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,FormSpecs.RELATED_GAP_ROWSPEC,

						}));


		txtNombre = new JTextField();
		add(txtNombre, "6, 2, fill, default");
		txtNombre.setColumns(10);

		txtPaterno = new JTextField();
		add(txtPaterno, "6, 4, fill, default");
		txtPaterno.setColumns(10);

		txtMaterno = new JTextField();
		add(txtMaterno, "6, 6, fill, default");
		txtMaterno.setColumns(10);

		txtEmail = new JTextField();
		add(txtEmail, "6, 8, fill, default");
		txtEmail.setColumns(10);

		txtCalle = new JTextField();
		add(txtCalle, "6,  10, fill, default");
		txtCalle.setColumns(10);

		txtNumero = new JTextField();
		add(txtNumero, "6, 12, fill, default");
		txtNumero.setColumns(10);

		txtColonia = new JTextField();
		add(txtColonia, "6, 14, fill, default");
		txtColonia.setColumns(10);

		txtDelegacion = new JTextField();
		add(txtDelegacion, "6, 16, fill, default");
		txtDelegacion.setColumns(10);

		txtEntidad = new JTextField();
		add(txtEntidad, "6, 18, fill, default");
		txtEntidad.setColumns(10);

		txtTelefono = new JTextField();
		add(txtTelefono, "6, 20, fill, default");
		txtTelefono.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nombre");
		add(lblNewLabel, "2, 2");

		JLabel lblNewLabel_1 = new JLabel("Paterno");
		add(lblNewLabel_1, "2, 4");

		JLabel lblCosto = new JLabel("Materno");
		add(lblCosto, "2, 6");
		
		
		JLabel lblEmail = new JLabel("Email");
		add(lblEmail, "2, 8");

		JLabel lblCalle = new JLabel("Calle");
		add(lblCalle, "2, 10");

		JLabel lblNumero = new JLabel("Numero");
		add(lblNumero, "2, 12");
		
		JLabel lblColonia = new JLabel("Colonia");
		add(lblColonia, "2, 14");

		JLabel lblDelegacion = new JLabel("Delegacion");
		add(lblDelegacion, "2, 16");

		JLabel lblEntidad = new JLabel("Entidad");
		add(lblEntidad, "2, 18");
		
		JLabel lblPhone = new JLabel("Telefono");
		add(lblPhone, "2, 20");
		
		btnSave = new JButton("Guardar");
		add(btnSave, "6,  22");

		btnNuevo = new JButton("Nuevo");
		add(btnNuevo, "6, 23");

		btnBorrar = new JButton("Borrar");
		add(btnBorrar, "6, 24");
	}

	
	public void updateDataUI(){
		txtNombre.setText(model.getNombre());
		txtPaterno.setText(model.getPaterno());
		txtMaterno.setText(model.getMaterno());
		txtCalle.setText(model.getCalle());
		txtNumero.setText(model.getNombre());
		txtColonia.setText(model.getColonia());
		txtEntidad.setText(model.getEntidad());
		txtEmail.setText(model.getEmail());
		txtDelegacion.setText(model.getDelegacion());
		txtTelefono.setText(model.getNoTelefono());

	}
	
	
	public void setModel(){
		model.setNombre(txtNombre.getText());
		model.setPaterno(txtPaterno.getText());
		model.setMaterno(txtMaterno.getText());
		model.setCalle(txtCalle.getText());
		model.setNumero(txtNumero.getText());
		model.setColonia(txtColonia.getText());
		model.setEntidad(txtEntidad.getText());
		model.setEmail(txtEmail.getText());
		model.setDelegacion(txtDelegacion.getText());
		model.setNoTelefono(txtTelefono.getText());
	}
	
}

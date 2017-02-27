package com.escom.distribuidos.gui.form;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

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

	/**
	 * Create the panel.
	 */
	public FormAlumno() {
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


		txtNombre = new JTextField();
		add(txtNombre, "6, 4, fill, default");
		txtNombre.setColumns(10);

		txtPaterno = new JTextField();
		add(txtPaterno, "6, 6, fill, default");
		txtPaterno.setColumns(10);

		txtMaterno = new JTextField();
		add(txtMaterno, "6, 8, fill, default");
		txtMaterno.setColumns(10);

		txtEmail = new JTextField();
		add(txtEmail, "6, 10, fill, default");
		txtEmail.setColumns(10);

		txtCalle = new JTextField();
		add(txtCalle, "6, 12, fill, default");
		txtCalle.setColumns(10);

		txtNumero = new JTextField();
		add(txtNumero, "6, 14, fill, default");
		txtNumero.setColumns(10);

		txtColonia = new JTextField();
		add(txtColonia, "6, 16, fill, default");
		txtColonia.setColumns(10);

		txtDelegacion = new JTextField();
		add(txtDelegacion, "6, 18, fill, default");
		txtDelegacion.setColumns(10);

		txtEntidad = new JTextField();
		add(txtEntidad, "6, 20, fill, default");
		txtEntidad.setColumns(10);

		txtTelefono = new JTextField();
		add(txtTelefono, "6, 22, fill, default");
		txtTelefono.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nombre");
		add(lblNewLabel, "2, 4");

		JLabel lblNewLabel_1 = new JLabel("Fecha Inicio");
		add(lblNewLabel_1, "2, 6");

		JLabel lblCosto = new JLabel("Costo");
		add(lblCosto, "2, 10");

		textCosto = new JTextField();
		add(textCosto, "6, 10, fill, default");
		textCosto.setColumns(10);

		JButton btnSave = new JButton("Guardar");
		add(btnSave, "6, 14");

		JButton btnNuevo = new JButton("Nuevo");
		add(btnNuevo, "6, 16");

		JButton btnBorrar = new JButton("Borrar");
		add(btnBorrar, "6, 18");
	}

}

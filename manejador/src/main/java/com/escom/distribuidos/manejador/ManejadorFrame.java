package com.escom.distribuidos.manejador;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.escom.distribuidos.DBService;
import com.escom.distribuidos.DbServicesProvider;
import com.escom.distribuidos.cliente.async.AsyncRequestListener;
import com.escom.distribuidos.core.dao.BDEnum;

public class ManejadorFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8022380150997113286L;
	private static ManejadorFrame INSTANCE;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private BDEnum bdtype = BDEnum.MYSQL;
	private JList<String> listBD;
	private String selectedTable;
	private String selectedDB;
	private DBService dbService;
	private JList<String> listTables;
	private JList listEstructura;
	private JComboBox comboBox;

	public ManejadorFrame() {
		super("Manejador", true, true, true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 20, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 4, 0, 0));

		JLabel lblNewLabel = new JLabel("Manejador BD");
		panel.add(lblNewLabel);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(BDEnum.values()));
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bdtype = (BDEnum) comboBox.getSelectedItem();
				dbService = DbServicesProvider.getInstance(bdtype);
				showDatabases();
			}
		});
		panel.add(comboBox);

		listBD = new JList();
		contentPane.add(listBD, BorderLayout.WEST);
		listBD.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					selectedDB = listBD.getSelectedValue();

					dbService.showTable(selectedDB, new AsyncRequestListener<List<String>>() {

						@Override
						public void onError(Exception e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void onComplete(List<String> results) {
							DefaultListModel demoList = new DefaultListModel();
							for (String result : results)
								demoList.addElement(result);
							listTables.setModel(demoList);

						}
					});
				}
			}
		});

		listTables = new JList();
		contentPane.add(listTables, BorderLayout.CENTER);
		listTables.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					selectedTable = listTables.getSelectedValue();
					dbService.showTableMeta(selectedDB.concat(".").concat(selectedTable),
							new AsyncRequestListener<Map<String, String>>() {

								@Override
								public void onError(Exception e) {
									// TODO Auto-generated method stub

								}

								@Override
								public void onComplete(Map<String, String> results) {
									DefaultListModel demoList = new DefaultListModel();
									for (Entry<String, String> result : results.entrySet())
										demoList.addElement(result.getKey().concat(" -> ").concat(result.getValue()));
									listEstructura.setModel(demoList);

								}
							});
				}
			}
		});

		listEstructura = new JList();
		contentPane.add(listEstructura, BorderLayout.EAST);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));

		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);

		JButton Run = new JButton("New button");
		panel_1.add(Run);

		Run.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dbService.query(textField.getText(), new AsyncRequestListener<Object>() {

					@Override
					public void onError(Exception e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onComplete(Object result) {
						if (result == null)
							return;
						if (!result.getClass().equals(ArrayList.class)) {

						} else {
							List<String> results = (List<String>) result;
							String[] columns = results.get(0).split(Pattern.quote(","));
							DefaultTableModel defaultTableModel = new DefaultTableModel();
							for (String columnName : columns)
								defaultTableModel.addColumn(columnName);
							List<String[]> rows = new ArrayList<>();
							for (int i = 1; i < results.size(); i++) {
								rows.add(results.get(i).split(Pattern.quote(",")));
							}
							for (String[] data : rows) {
								defaultTableModel.addRow(data);
							}
							table.setModel(defaultTableModel);
						}
					}
				});
			}
		});

		table = new JTable();
		panel_1.add(table);

		dbService = DbServicesProvider.getInstance(bdtype);
		showDatabases();

	}

	public void showDatabases() {
		dbService.showDatabase(new AsyncRequestListener<List<String>>() {

			@Override
			public void onError(Exception e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onComplete(List<String> results) {
				DefaultListModel demoList = new DefaultListModel();
				for (String result : results)
					demoList.addElement(result);
				listBD.setModel(demoList);
			}
		});
	}

	public static ManejadorFrame getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ManejadorFrame();
		}
		return INSTANCE;
	}

}

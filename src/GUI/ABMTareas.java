package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTable;
import javax.swing.JTextField;

import Tareas.EstadoTarea;
import Tareas.Tarea;
import backLogs.Backlog;
import clases.Proyecto;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class ABMTareas extends JPanel {
	private JMenuBar tmenuBar;	
		private JMenuItem mntmTAdmSprints;
		private JMenuItem mntmTSprints;	
		private JMenuItem mntmTTareas;
		private JMenuItem mntmTBacklog;
		private JMenuItem mntmTReportes;
		
	private JLabel lblTarea;
	private JSeparator separatorTarea;
	private JLabel lblTId;
	private JTextField txtTNombre;
	private JLabel lblTnomb;
	private JTextField txtTID;
	private JLabel lblSTipo;
	private JComboBox<String> comboBoxTTipo;
	private JLabel lblTDescripcion;
	private JTextField txtTDescp;
	private JLabel lblTComplejidad;
	private JSpinner spinnerTComp;
	private JLabel lblTEstado;
	private JComboBox<String> comboBoxTEstado;
	private JScrollPane scrollPane_Tareas;
	private JButton btnTSubtareas;
	private JButton btnTDependencias;
	
	private JButton btnTAgregar;
	private JButton btnTModificar;
	private JButton btnTEliminar;
	
	private JLabel lblTSubtareasDependencias;			
	private JScrollPane scrollPane_TSD;
	private JButton btnTAgregarSD;
	private JButton btnTQuitarSD;
	private JScrollPane scrollPane;
	private JLabel lblTareasDisponibles;

	/**
	 * Create the panel.
	 */
	public ABMTareas() {
		
		setLayout(new MigLayout("", "[50][53.00][5][53][5][70.00][131.00][603.00,grow][][603.00,grow]", "[24px:24px][10.00][][15.00][][][15][][15][][15][][15][138.00,grow][15][][15][][15][][108.00,grow][]"));
		
		tmenuBar = new JMenuBar();
		tmenuBar.setMargin(new Insets(0, 15, 0, 15));
			mntmTAdmSprints = new JMenuItem("Administración");
			mntmTAdmSprints.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirAdminSprints();}});
			tmenuBar.add(mntmTAdmSprints);
			mntmTSprints = new JMenuItem("Sprints");
			mntmTSprints.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirABMSprint();}});
			tmenuBar.add(mntmTSprints);
			mntmTTareas = new JMenuItem("Tareas");
			mntmTTareas.setSelected(true);
			mntmTTareas.setBackground(Color.LIGHT_GRAY);
			mntmTTareas.setFont(new Font("Segoe UI", Font.BOLD, 13));
			tmenuBar.add(mntmTTareas);
			mntmTBacklog = new JMenuItem("Backlog");
			mntmTBacklog.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirBacklog();}});
			tmenuBar.add(mntmTBacklog);
			mntmTReportes = new JMenuItem("Reportes");
			mntmTReportes.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirReportes();}});
			tmenuBar.add(mntmTReportes);
		add(tmenuBar, "cell 0 0 10 1,growx,aligny top");
		
		
			
			lblTarea = new JLabel("Tarea");
			lblTarea.setFont(new Font("Tahoma", Font.BOLD, 24));
			add(lblTarea, "cell 1 2 4 1,alignx left,aligny bottom");
			
			scrollPane_Tareas = new JScrollPane();
			add(scrollPane_Tareas, "cell 7 2 3 12,grow");
			
			separatorTarea = new JSeparator();
			separatorTarea.setForeground(Color.BLACK);
			add(separatorTarea, "cell 1 3 5 1,growx,aligny center");
			
			lblSTipo = new JLabel("Tipo:");
			add(lblSTipo, "cell 1 5,alignx center,aligny center");
			
			comboBoxTTipo = new JComboBox();
			comboBoxTTipo.setModel(new DefaultComboBoxModel(new String[] {"Tarea", "Bug", "Historia", "Mejora"}));
			add(comboBoxTTipo, "cell 3 5 3 1,growx");
			
			lblTId = new JLabel("ID:");
			add(lblTId, "cell 1 7,alignx center,aligny center");
			
			txtTID = new JTextField();
			add(txtTID, "cell 3 7 3 1,growx");
			txtTID.setColumns(10);
			
			lblTnomb = new JLabel("Nombre:");
			add(lblTnomb, "cell 1 9,alignx center");
			
			txtTNombre = new JTextField();
			add(txtTNombre, "cell 3 9 3 1,growx");
			txtTNombre.setColumns(10);
			
			lblTEstado = new JLabel("Estado:");
			add(lblTEstado, "cell 1 11,alignx center");
			
			comboBoxTEstado = new JComboBox();
			comboBoxTEstado.setModel(new DefaultComboBoxModel(new String[] {"", "ToDo", "InProgress", "PendingToBuild", "ReadyToTest", "Testing", "Done"}));
			add(comboBoxTEstado, "cell 3 11 3 1,growx");
			
			lblTDescripcion = new JLabel("Descripcion: ");
			add(lblTDescripcion, "cell 1 13,alignx center,aligny top");
			
			txtTDescp = new JTextField();
			add(txtTDescp, "cell 3 13 3 1,grow");
			txtTDescp.setColumns(10);
			
			lblTComplejidad = new JLabel("Complejidad:");
			add(lblTComplejidad, "cell 1 15,alignx center");
			
			spinnerTComp = new JSpinner();
			spinnerTComp.setModel(new SpinnerNumberModel(1, 1, 10, 1));
			add(spinnerTComp, "cell 3 15 3 1,growx");
			
			lblTareasDisponibles = new JLabel("Tareas Disponibles");
			lblTareasDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 16));
			add(lblTareasDisponibles, "cell 9 15,alignx left");
			
			scrollPane = new JScrollPane();
			add(scrollPane, "cell 9 16 1 6,grow");
			
			btnTSubtareas = new JButton("Sub Tareas");
			btnTSubtareas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lblTSubtareasDependencias.setText("Sub Tareas");
				}
			});
			add(btnTSubtareas, "cell 1 17 5 1,alignx center,aligny center");
			
			btnTDependencias = new JButton("Dependencias");
			btnTDependencias.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lblTSubtareasDependencias.setText("Dependencias");
				}
			});
			add(btnTDependencias, "cell 1 19 5 1,alignx center,aligny center");
			
			
			btnTAgregar = new JButton("Agregar");
			btnTAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					txtTID.setEnabled(true);
					Proyecto.getInstance().getBlog().altaTarea(comboBoxTTipo.getSelectedItem().toString(),txtTID.getText(),txtTNombre.getText(),txtTDescp.getText(),EstadoTarea.DONE,null,Integer.parseInt(spinnerTComp.toString()));
					
					//table.setModel(new TareasTM(Proyecto.getInstance().getBlog().getLTareasP()));
				}
			});
			add(btnTAgregar, "cell 1 21");
			
			btnTModificar = new JButton("Modificar");
			btnTModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						/*Tarea tar = Proyecto.getInstance().getBlog().getTarea(table.getValueAt(table.getSelectedRow(), 0).toString());
						txtTID.setText(tar.getId());
						txtTNombre.setText(tar.getNombre());
						txtTDescp.setText(tar.getDescripcion());
						spinnerTComp.setValue(tar.getComplejidad()-1);
						
						txtId.setEnabled(false);
						btnModificar.setEnabled(false);
						Proyecto.getInstance().getBlog().bajaTarea(tar.getId());*/
					}catch(ArrayIndexOutOfBoundsException ex){
						JOptionPane.showMessageDialog(null, "Debe seleccionarse una tarea a modificar.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			add(btnTModificar, "cell 3 21");
		
			btnTEliminar = new JButton("Eliminar");
			btnTEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/*Proyecto.getInstance().bajaTareaBackLog(table.getValueAt(table.getSelectedRow(), 0).toString());
					table.setModel(new TareasTM(Proyecto.getInstance().getBlog().getLTareasP()));*/
				}
			});
			add(btnTEliminar, "cell 5 21");
			
			
			lblTSubtareasDependencias = new JLabel("Dependencias");
			lblTSubtareasDependencias.setFont(new Font("Tahoma", Font.PLAIN, 16));
			add(lblTSubtareasDependencias, "cell 7 15");
			
			scrollPane_TSD = new JScrollPane();
			add(scrollPane_TSD, "cell 7 16 1 6,grow");

			btnTAgregarSD = new JButton("\u00AB");
			btnTAgregarSD.setFont(new Font("Tahoma", Font.PLAIN, 14));
			add(btnTAgregarSD, "cell 8 17,growx,aligny center");

			btnTQuitarSD = new JButton("\u00BB");
			btnTQuitarSD.setFont(new Font("Tahoma", Font.PLAIN, 14));
			add(btnTQuitarSD, "cell 8 19,growx,aligny center");


	}
}

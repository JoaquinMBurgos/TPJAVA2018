package GUI;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.border.MatteBorder;

import GUI.SprintsTM;
import clases.Proyecto;
import clases.SprintNoValido;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Component;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.Button;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JTable;

public class ABMSprints extends JPanel {
	private JMenuBar smenuBar;	
		private JMenuItem mntmSAdmSprints;
		private JMenuItem mntmSSprints;	
		private JMenuItem mntmSTareas;
		private JMenuItem mntmSBacklog;
		private JMenuItem mntmSReportes;
	
	private JLabel lblSprint;
	private JSeparator separatorSpring;			
	private JLabel lblIdSprint;
	private JTextField txtSID;
	private JLabel lblSEstado;
	private JRadioButton rdbtnPlanificado;
	private JRadioButton rdbtnEnCurso;
	private JRadioButton rdbtnFinalizado;
	private JScrollPane scrollPane_Sprints;
	private JTable table;
	
	private JButton btnSAgregar;
	private JButton btnSModificar;
	private JButton btnSEliminar;			
	
	private JLabel lblSTareas;
	private JScrollPane scrollPane_STareas;			
	private JButton btnSAgregarTarea;
	private JButton btnSQuitaTarea;
	private JScrollPane scrollPane_STareasBacklog;
	private JLabel lblTareasEnBacklog;
	private JButton btnSEstadoTarea;
	private JLabel lblNombreSprint;
	private JTextField txtSNombre;
	private JButton btnIniciar;

	/**
	 * Create the panel.
	 */
	
	public ABMSprints() {
		setLayout(new MigLayout("", "[10][53][53][53][10][522,grow][57][522,grow]", "[24px:24px][20.00px][24.00][][15][][15][][15][][15][][15][][][10][][10][][15][39.00][15][][15][][15][][46.00,grow][17.00]"));
		
		smenuBar = new JMenuBar();
		smenuBar.setMargin(new Insets(0, 15, 0, 15));
			mntmSAdmSprints = new JMenuItem("Administración");
			mntmSAdmSprints.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirAdminSprints();}});
			smenuBar.add(mntmSAdmSprints);
			mntmSSprints = new JMenuItem("Sprints");
			mntmSSprints.setSelected(true);
			mntmSSprints.setForeground(Color.BLACK);
			mntmSSprints.setBackground(Color.LIGHT_GRAY);
			mntmSSprints.setHorizontalAlignment(SwingConstants.CENTER);
			mntmSSprints.setFont(new Font("Segoe UI", Font.BOLD, 13));
			smenuBar.add(mntmSSprints);
			mntmSTareas = new JMenuItem("Tareas");
			mntmSTareas.setHorizontalAlignment(SwingConstants.CENTER);
			mntmSTareas.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirABMSTareas();}});
			smenuBar.add(mntmSTareas);
			mntmSBacklog = new JMenuItem("Backlog");
			mntmSBacklog.setHorizontalAlignment(SwingConstants.CENTER);
			mntmSBacklog.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirBacklog();}});
			smenuBar.add(mntmSBacklog);
			mntmSReportes = new JMenuItem("Reportes");
			mntmSReportes.setHorizontalAlignment(SwingConstants.CENTER);
			mntmSReportes.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirReportes();}});
			smenuBar.add(mntmSReportes);
			add(smenuBar, "cell 0 0 8 1,growx,aligny top");
		
			
			
			lblSprint = new JLabel("Sprint");
			lblSprint.setFont(new Font("Tahoma", Font.BOLD, 24));
			add(lblSprint, "cell 0 2 4 1,alignx left,aligny bottom");
			
			separatorSpring = new JSeparator();
			separatorSpring.setForeground(Color.BLACK);
			add(separatorSpring, "cell 0 3 4 1,growx,aligny center");
			
			
			
			lblIdSprint = new JLabel("ID Sprint :");
			lblIdSprint.setFont(new Font("Tahoma", Font.PLAIN, 12));
			add(lblIdSprint, "cell 0 5 4 1");
			
			txtSID = new JTextField();
			add(txtSID, "cell 0 7 4 1,growx");
			txtSID.setColumns(10);
			
			lblNombreSprint = new JLabel("Nombre Sprint :");
			lblNombreSprint.setFont(new Font("Tahoma", Font.PLAIN, 12));
			add(lblNombreSprint, "cell 0 9 4 1");
			
			
			
			lblSEstado = new JLabel("Estado :");
			lblSEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
			add(lblSEstado, "cell 0 13 4 1");
			
			rdbtnPlanificado = new JRadioButton("Planificado");
			rdbtnPlanificado.setSelected(true);
			rdbtnPlanificado.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					rdbtnPlanificado.setSelected(true);
					rdbtnEnCurso.setSelected(false);
					rdbtnFinalizado.setSelected(false);
				}
			});
			
			txtSNombre = new JTextField();
			txtSNombre.setColumns(10);
			add(txtSNombre, "cell 0 11 4 1,growx,aligny top");
			add(rdbtnPlanificado, "cell 2 14");
			
			rdbtnFinalizado = new JRadioButton("Finalizado");
			rdbtnFinalizado.setSelected(false);
			rdbtnFinalizado.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					rdbtnPlanificado.setSelected(false);
					rdbtnEnCurso.setSelected(false);
					rdbtnFinalizado.setSelected(true);
				}
			});
						
						rdbtnEnCurso = new JRadioButton("En Curso");
						rdbtnEnCurso.setSelected(false);
						rdbtnEnCurso.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent arg0) {
								rdbtnPlanificado.setSelected(false);
								rdbtnEnCurso.setSelected(true);
								rdbtnFinalizado.setSelected(false);
							}
						});	
						add(rdbtnEnCurso, "cell 2 16");
			add(rdbtnFinalizado, "cell 2 18");		
			
			btnIniciar = new JButton("Inicia Sprint");
			add(btnIniciar, "cell 1 20 3 1,alignx center,aligny center");
			
			lblSTareas = new JLabel("Tareas en Sprint");
			lblSTareas.setFont(new Font("Tahoma", Font.PLAIN, 16));
			add(lblSTareas, "cell 5 20,alignx left,aligny center");
			
						lblTareasEnBacklog = new JLabel("Tareas en Backlog");
						lblTareasEnBacklog.setFont(new Font("Tahoma", Font.PLAIN, 16));
						add(lblTareasEnBacklog, "cell 7 20");
			
			scrollPane_STareas = new JScrollPane();
			add(scrollPane_STareas, "cell 5 21 1 8,grow");
			
			scrollPane_STareasBacklog = new JScrollPane();
			add(scrollPane_STareasBacklog, "cell 7 21 1 8,grow");
			
			
			
			btnSAgregarTarea = new JButton("\u00AB");
			btnSAgregarTarea.setFont(new Font("Tahoma", Font.PLAIN, 14));
			add(btnSAgregarTarea, "cell 6 22,growx,aligny center");
			
			
			
			btnSAgregar = new JButton("Agregar");
			btnSAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Proyecto.getInstance().altaSprint(txtSID.getText(), txtSNombre.getText());
					JOptionPane.showMessageDialog(null, "Sprint agregado con exito.");
					Proyecto.getInstance().corrersp();
				}
			});
			add(btnSAgregar, "cell 1 28,alignx center,aligny center");
			
			btnSModificar = new JButton("Modificar");
			btnSModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/*table.setEnabled(true);
					txtSID.setEnabled(true);
					Proyecto.getInstance().modificacionSprint(txtSID.getText(), txtSNombre.getText());
					JOptionPane.showMessageDialog(null, "Sprint modificado con exito.");*/
				}
			});
			add(btnSModificar, "cell 2 28,alignx center,aligny center");
			/*scrollPane_3 = new JScrollPane();
		add(scrollPane_3, "cell 17 6 5 1,grow");
		
		table_RTT = new JTable();
		scrollPane_3.setViewportView(table_RTT);
			*/
			scrollPane_Sprints=new JScrollPane();
			add(scrollPane_Sprints, "cell 5 2 3 17,grow");
			
			table = new JTable();
			scrollPane_Sprints.setViewportView(table);
			table.setModel(new SprintsTM(Proyecto.getInstance().getLSprints()));
			/*table = new JTable();
			add(table);
			table.setModel(new SprintsTM(Proyecto.getInstance().getLSprints()));
			table.setAutoscrolls(true);
			
			scrollPane_Sprints = new JScrollPane(table);
			table.setFillsViewportHeight(true);
			add(scrollPane_Sprints, "cell 5 2 3 17,grow");*/
			
			btnSQuitaTarea = new JButton("\u00BB");
			btnSQuitaTarea.setFont(new Font("Tahoma", Font.PLAIN, 14));
			add(btnSQuitaTarea, "cell 6 24,growx,aligny center");
			
			btnSEstadoTarea = new JButton("Estado");
			add(btnSEstadoTarea, "cell 6 26,alignx center");
			
			btnSEliminar = new JButton("Eliminar");
			btnSEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/*try{
						Proyecto.getInstance().bajaSprint(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
						}
						catch(ArrayIndexOutOfBoundsException e){
							JOptionPane.showMessageDialog(null, "Debe existir seleccionar un Sprint a eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
						} catch (SprintNoValido snv) {
							JOptionPane.showMessageDialog(null, "No se pueden eliminar los Sprints EN CURSO o FINALIZADO.", "Error", JOptionPane.ERROR_MESSAGE);
							snv.printStackTrace();
						}
						table.setModel(new SprintsTM(Proyecto.getInstance().getLSprints()));
					}*/
				}
			});
			add(btnSEliminar, "cell 3 28,alignx center,aligny center");
			

		
	}
}

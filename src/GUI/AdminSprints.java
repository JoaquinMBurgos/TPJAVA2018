package GUI;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import clases.Proyecto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import net.miginfocom.swing.MigLayout;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;


public class AdminSprints extends JPanel {
	
	private JMenuBar asmenuBar;	
		private JMenuItem mntmASAdmSprints;
		private JMenuItem mntmASSprints;	
		private JMenuItem mntmASTareas;
		private JMenuItem mntmASBacklog;
		private JMenuItem mntmASReportes;
		private JLabel lblIdSprint;
		private JLabel lblNombreSprint;
		private JLabel lblEstado;
		private JLabel lblEstadoActual;
		private JLabel lblDaActual;
		private JLabel lblDaActual_Actual;
		private JLabel lblCompletitudDeHistorias;
		private JLabel lblCompletitudTotal;
		private JLabel lblDuracin;
		private JLabel lblDuracin_Actual;
		private JLabel lblAvance;
		private JLabel lblAvance_Actual;
		private JSeparator separator;
		private JLabel lblCompletitudDeHistorias_Actual;
		private JLabel lblCompletitudTotal_Actual;
		private JScrollPane scrollPane;
		private JScrollPane scrollPane_1;
		private JLabel lblToDo;
		private JLabel lblInprogress;
		private JScrollPane scrollPane_2;
		private JLabel lblPendingtobuild;
		private JScrollPane scrollPane_3;
		private JScrollPane scrollPane_4;
		private JScrollPane scrollPane_5;
		private JLabel lblReadytotest;
		private JLabel lblTesting;
		private JLabel lblDone;
		private JButton btnSiguiente;
		private JButton button;
		private JButton button_1;
		private JButton button_2;
		private JButton button_3;
		private JButton btnFinalizaSprint;
		private JButton btnAnterior;
		private JButton button_4;
		private JButton button_5;
		private JButton button_6;

	/**
	 * Create the panel.
	 */
	public AdminSprints() {
		setLayout(new MigLayout("", "[135.00][15][98][10][84][15][62.00][88][10][4][15][72.00,grow][30][15][72][30][10][5][74.00,grow][30.00][15][105][10][5][][30]", "[24:24][10px][25px][25px][26][36.00,center][215][][36][215][]"));
		
	
		
		asmenuBar = new JMenuBar();
		asmenuBar.setMargin(new Insets(0, 15, 0, 15));
			mntmASAdmSprints = new JMenuItem("Administración");
			mntmASAdmSprints.setSelected(true);
			mntmASAdmSprints.setForeground(Color.BLACK);
			mntmASAdmSprints.setBackground(Color.LIGHT_GRAY);
			mntmASAdmSprints.setHorizontalAlignment(SwingConstants.CENTER);
			mntmASAdmSprints.setFont(new Font("Segoe UI", Font.BOLD, 13));
			asmenuBar.add(mntmASAdmSprints);
			mntmASSprints = new JMenuItem("Sprints");
			mntmASSprints.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirABMSprint();}});
			asmenuBar.add(mntmASSprints);
			mntmASTareas = new JMenuItem("Tareas");
			mntmASTareas.setHorizontalAlignment(SwingConstants.CENTER);
			mntmASTareas.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirABMSTareas();}});
			asmenuBar.add(mntmASTareas);
			mntmASBacklog = new JMenuItem("Backlog");
			mntmASBacklog.setHorizontalAlignment(SwingConstants.CENTER);
			mntmASBacklog.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirBacklog();}});
			asmenuBar.add(mntmASBacklog);
			mntmASReportes = new JMenuItem("Reportes");
			mntmASReportes.setHorizontalAlignment(SwingConstants.CENTER);
			mntmASReportes.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirReportes();}});
			asmenuBar.add(mntmASReportes);
			add(asmenuBar, "cell 0 0 26 1,growx,aligny top");
		
		lblIdSprint = new JLabel("ID Sprint");
		lblIdSprint.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblIdSprint, "cell 0 2 1 2,alignx center,aligny center");
		
		lblNombreSprint = new JLabel("Nombre Sprint");
		lblNombreSprint.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblNombreSprint, "cell 2 2 3 2,alignx center,aligny center");
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblEstado, "cell 6 2 1 2,alignx center,aligny center");
		
		lblEstadoActual = new JLabel("Estado Actual");
		lblEstadoActual.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblEstadoActual, "cell 7 2 3 2,alignx center,aligny center");
		
		lblDuracin = new JLabel("Duraci\u00F3n:");
		lblDuracin.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblDuracin, "cell 11 2 1 2,alignx center,aligny center");
		
		lblDuracin_Actual = new JLabel("0");
		lblDuracin_Actual.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblDuracin_Actual, "cell 12 2 1 2,alignx center,aligny center");
		
		lblAvance = new JLabel("Avance:");
		lblAvance.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblAvance, "cell 14 2 1 2,alignx center,aligny center");
		
		lblAvance_Actual = new JLabel("0");
		lblAvance_Actual.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblAvance_Actual, "cell 15 2 1 2,alignx center,aligny center");
		
		lblDaActual = new JLabel("D\u00EDa Actual:");
		lblDaActual.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblDaActual, "cell 18 2 1 2,alignx center,aligny center");
		
		lblDaActual_Actual = new JLabel("0");
		lblDaActual_Actual.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblDaActual_Actual, "cell 19 2 1 2,alignx center,aligny center");
		
		JButton btnDiaSiguiente = new JButton("Dia Siguiente");
		add(btnDiaSiguiente, "cell 21 2 1 2,alignx center,aligny center");
		
		lblCompletitudDeHistorias = new JLabel("Completitud de historias:");
		lblCompletitudDeHistorias.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblCompletitudDeHistorias, "cell 24 2,alignx center,aligny center");
		
		lblCompletitudDeHistorias_Actual = new JLabel("0");
		lblCompletitudDeHistorias_Actual.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblCompletitudDeHistorias_Actual, "cell 25 2,alignx center,aligny center");
		
		lblCompletitudTotal = new JLabel("Completitud total:");
		lblCompletitudTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblCompletitudTotal, "cell 24 3,alignx center,aligny center");
		
		lblCompletitudTotal_Actual = new JLabel("0");
		lblCompletitudTotal_Actual.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblCompletitudTotal_Actual, "cell 25 3,alignx center,aligny center");
		
		separator = new JSeparator();
		add(separator, "cell 0 4 26 1,growx,aligny center");
		
		lblToDo = new JLabel("To Do");
		lblToDo.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblToDo, "cell 0 5 3 1,alignx center,aligny center");
		
		lblInprogress = new JLabel("InProgress");
		lblInprogress.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblInprogress, "cell 4 5 4 1,alignx center,aligny center");
		
		lblPendingtobuild = new JLabel("PendingToBuild");
		lblPendingtobuild.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblPendingtobuild, "cell 9 5 7 1,alignx center,aligny center");
		
		lblReadytotest = new JLabel("ReadyToTest");
		lblReadytotest.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblReadytotest, "cell 18 5 4 1,alignx center,aligny center");
		
		lblDone = new JLabel("Done");
		lblDone.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblDone, "cell 23 5 3 1,alignx center,aligny center");
		
		scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 6 3 4,grow");
		
		scrollPane_1 = new JScrollPane();
		add(scrollPane_1, "cell 4 6 4 4,grow");
		
		scrollPane_2 = new JScrollPane();
		add(scrollPane_2, "cell 9 6 7 4,grow");
		
		scrollPane_3 = new JScrollPane();
		add(scrollPane_3, "cell 17 6 5 1,grow");
		
		scrollPane_5 = new JScrollPane();
		add(scrollPane_5, "cell 23 6 3 4,grow");
		
		button_6 = new JButton("\u00AB Anterior");
		add(button_6, "cell 17 7 2 1,alignx left,aligny center");
		
		button_3 = new JButton("Siguiente \u00BB");
		add(button_3, "cell 21 7,alignx right,aligny center");
		
		lblTesting = new JLabel("Testing");
		lblTesting.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblTesting, "cell 17 8 5 1,alignx center,aligny center");
		
		scrollPane_4 = new JScrollPane();
		add(scrollPane_4, "cell 17 9 5 1,grow");
		
		btnSiguiente = new JButton("Siguiente \u00BB");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnSiguiente, "cell 2 10,alignx right,aligny center");
		
		btnAnterior = new JButton("\u00AB Anterior");
		add(btnAnterior, "cell 4 10 2 1,alignx left,aligny center");
		
		button = new JButton("Siguiente \u00BB");
		add(button, "cell 7 10,alignx right,aligny center");
		
		button_4 = new JButton("\u00AB Anterior");
		add(button_4, "cell 10 10 2 1,alignx left,aligny center");
		
		button_1 = new JButton("Siguiente \u00BB");
		add(button_1, "cell 14 10 2 1,alignx right,aligny center");
		
		button_5 = new JButton("\u00AB Anterior");
		add(button_5, "cell 17 10 2 1,alignx left,aligny center");
		
		button_2 = new JButton("Siguiente \u00BB");
		add(button_2, "cell 21 10,alignx right,aligny center");
		
		btnFinalizaSprint = new JButton("Finaliza Sprint");
		add(btnFinalizaSprint, "cell 24 10 2 1,alignx right,aligny center");

	}

	
	
	/*public void setlbls(){
	String clave;
	String descripcion; 
	String estado; 
	String avance;
	String duracion;
	Proyecto proy = Proyecto.getInstance();
	
	proy.setAdmSprintEnCurso(clave,descripcion,estado,avance,duracion); 
	
	lblIdSprint.setText(clave);
	lblNombreSprint.setText(descripcion);
	lblEstadoActual.setText(estado);
	lblDaActual_Actual.setText(duracion);
	lblAvance_Actual.setText(avance);

	}
	
	/*public void cargarTablas(){
		try{
			tableTareas.setModel(new TareasSprintTM(Proyecto.getInstance().getTareasSprintEnCurso()));
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, "Deben cargarse Sprints que administrar.");
		}
	}*/
	
	
}

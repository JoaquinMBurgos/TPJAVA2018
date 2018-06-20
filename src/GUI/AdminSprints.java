package GUI;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import clases.Proyecto;
import clases.Sprint;

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
import tareas.EstadoTarea;

import javax.swing.JSeparator;
import javax.swing.JScrollPane;


public class AdminSprints extends JPanel {
	
	private JMenuBar asmenuBar;	
		private JMenuItem mntmASAdmSprints;
		private JMenuItem mntmASSprints;	
		private JMenuItem mntmASTareas;
		private JMenuItem mntmASBacklog;
		private JMenuItem mntmASHistorico;
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
	private JScrollPane scrollPane_ToDo;
	private JScrollPane scrollPane_Inprogress;
	private JLabel lblToDo;
	private JLabel lblInprogress;
	private JScrollPane scrollPane_Pendingtobuild;
	private JLabel lblPendingtobuild;
	private JScrollPane scrollPane_Readytotest;
	private JScrollPane scrollPane_Testing;
	private JScrollPane scrollPane_Done;
	private JLabel lblReadytotest;
	private JLabel lblTesting;
	private JLabel lblDone;
	private JButton btnToDoSiguiente;
	private JButton btnInProgressSiguiente;
	private JButton btnPendingToBouildSiguiente;
	private JButton btnTestingSiguiente;
	private JButton btnReadyToTestSiguiente;
	private JButton btnFinalizaSprint;
	private JButton btnPendingToBouildAnterior;
	private JButton btnTestingAnterior;
	private JTable table_TD;
	private JTable table_IP;
	private JTable table_PTB;
	private JTable table_RTT;
	private JTable table_T;
	private JTable table_D;
		

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
			mntmASHistorico = new JMenuItem("Historico");
			mntmASHistorico.setHorizontalAlignment(SwingConstants.CENTER);
			mntmASHistorico.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirHistorico();}});
			asmenuBar.add(mntmASHistorico);
			mntmASReportes = new JMenuItem("Reportes");
			mntmASReportes.setHorizontalAlignment(SwingConstants.CENTER);
			mntmASReportes.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirReportes();}});
			asmenuBar.add(mntmASReportes);
			add(asmenuBar, "cell 0 0 26 1,growx,aligny top");
		
		
		if(Proyecto.getInstance().getSprintEnCurso()!=null){
			Sprint s=Proyecto.getInstance().getSprintEnCurso();
			lblIdSprint = new JLabel(s.getClave());
			lblNombreSprint = new JLabel(s.getDescripcion());
			lblEstadoActual = new JLabel("En curso");
			lblDuracin_Actual = new JLabel(String.valueOf(s.duracion()));
			lblAvance_Actual = new JLabel(String.valueOf(s.getAvance()));
			lblDaActual_Actual = new JLabel(s.getfAvance().toString());
		}
		else{
			lblIdSprint = new JLabel("ID Sprint");
			lblNombreSprint = new JLabel("Nombre Sprint");
			lblEstadoActual = new JLabel("Estado Actual");
			lblDuracin_Actual = new JLabel("0");
			lblAvance_Actual = new JLabel("0");
			lblDaActual_Actual = new JLabel("0");
		}
		
		
		//lblIdSprint = new JLabel("ID Sprint");
		lblIdSprint.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblIdSprint, "cell 0 2 1 2,alignx center,aligny center");
		
		//lblNombreSprint = new JLabel("Nombre Sprint");
		lblNombreSprint.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblNombreSprint, "cell 2 2 3 2,alignx center,aligny center");
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblEstado, "cell 6 2 1 2,alignx center,aligny center");
		
		//lblEstadoActual = new JLabel("Estado Actual");
		lblEstadoActual.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblEstadoActual, "cell 7 2 3 2,alignx center,aligny center");
		
		lblDuracin = new JLabel("Duraci\u00F3n:");
		lblDuracin.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblDuracin, "cell 11 2 1 2,alignx center,aligny center");
		
		//lblDuracin_Actual = new JLabel("0");
		lblDuracin_Actual.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblDuracin_Actual, "cell 12 2 1 2,alignx center,aligny center");
		
		lblAvance = new JLabel("Avance:");
		lblAvance.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblAvance, "cell 14 2 1 2,alignx center,aligny center");
		
		//lblAvance_Actual = new JLabel("0");
		lblAvance_Actual.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblAvance_Actual, "cell 15 2 1 2,alignx center,aligny center");
		
		lblDaActual = new JLabel("D\u00EDa Actual:");
		lblDaActual.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblDaActual, "cell 18 2 1 2,alignx center,aligny center");
		
		//lblDaActual_Actual = new JLabel("0");
		lblDaActual_Actual.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblDaActual_Actual, "cell 19 2 1 2,alignx center,aligny center");
		
		JButton btnDiaSiguiente = new JButton("Dia Siguiente");
		btnDiaSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sprint s=Proyecto.getInstance().getSprintEnCurso();
				if(!Proyecto.getInstance().finalizaSprint(s.getClave())){
					Proyecto.getInstance().avance(s.getClave());
					lblAvance_Actual.setText(String.valueOf(s.getAvance()));
					lblDaActual_Actual.setText(s.getfAvance().toString());
				}
				else
					JOptionPane.showMessageDialog(null, "El sprint ya esta finalizado");
				/*if(Proyecto.getInstance().finalizaSprint(s.getClave())){
					lblCompletitudDeHistorias_Actual.setText(String.valueOf(s.estimacionHistoriaSprint()));
					lblCompletitudTotal_Actual.setText(String.valueOf(s.estimacionSprint()));
				}*/
					
				
				//lblAvance_Actual = new JLabel(String.valueOf(s.getAvance()));
				//lblDaActual_Actual = new JLabel(s.getfAvance().toString());
			}
		});
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
		
		lblTesting = new JLabel("Testing");
		lblTesting.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblTesting, "cell 17 8 5 1,alignx center,aligny center");
		
		lblDone = new JLabel("Done");
		lblDone.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblDone, "cell 23 5 3 1,alignx center,aligny center");
		
		
		scrollPane_ToDo = new JScrollPane();
		add(scrollPane_ToDo, "cell 0 6 3 4,grow");
		
		table_TD = new JTable();
		scrollPane_ToDo.setViewportView(table_TD);
		
		scrollPane_Inprogress = new JScrollPane();
		add(scrollPane_Inprogress, "cell 4 6 4 4,grow");
		
		table_IP = new JTable();
		scrollPane_Inprogress.setViewportView(table_IP);
		
		scrollPane_Pendingtobuild = new JScrollPane();
		add(scrollPane_Pendingtobuild, "cell 9 6 7 4,grow");
		
		table_PTB = new JTable();
		scrollPane_Pendingtobuild.setViewportView(table_PTB);
		
		scrollPane_Readytotest = new JScrollPane();
		add(scrollPane_Readytotest, "cell 17 6 5 1,grow");
		
		table_RTT = new JTable();
		scrollPane_Readytotest.setViewportView(table_RTT);
		
		scrollPane_Done = new JScrollPane();
		add(scrollPane_Done, "cell 23 6 3 4,grow");
		
		table_D = new JTable();
		scrollPane_Done.setViewportView(table_D);
		
		scrollPane_Testing = new JScrollPane();
		add(scrollPane_Testing, "cell 17 9 5 1,grow");
		
		table_T = new JTable();
		scrollPane_Testing.setViewportView(table_T);
		
		
		if(Proyecto.getInstance().getSprintEnCurso()!=null){
			Sprint s=Proyecto.getInstance().getSprintEnCurso();
			table_TD.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"TODO")));
			table_IP.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"INPROGRESS")));
			table_PTB.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"PENDINGTOBUILD")));
			table_RTT.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"READYTOTEST")));
			table_T.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"TESTING")));
			table_D.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"DONE")));
		}
		
		btnReadyToTestSiguiente = new JButton("Siguiente \u00BB");
		btnReadyToTestSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sprint s=Proyecto.getInstance().getSprintEnCurso();
				String id=table_RTT.getValueAt(table_RTT.getSelectedRow(), 0).toString();
				EstadoTarea e1=EstadoTarea.valueOf("READYTOTEST");
				s.cambiarEstadoTarea(id,e1.next().toString());
				table_RTT.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"READYTOTEST")));
				table_T.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"TESTING")));
			}
		});
		add(btnReadyToTestSiguiente, "cell 21 7,alignx right,aligny center");
		
		btnToDoSiguiente = new JButton("Siguiente \u00BB");
		btnToDoSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Proyecto.getInstance().cambiarEstadoTarea(idSprint, idT, est);
				Sprint s=Proyecto.getInstance().getSprintEnCurso();
				String id=table_TD.getValueAt(table_TD.getSelectedRow(), 0).toString();
				EstadoTarea e=EstadoTarea.valueOf("TODO");
				s.cambiarEstadoTarea(id,e.next().toString());
				table_TD.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"TODO")));
				table_IP.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"INPROGRESS")));
			}
		});
		add(btnToDoSiguiente, "cell 2 10,alignx right,aligny center");
		
		btnInProgressSiguiente = new JButton("Siguiente \u00BB");
		btnInProgressSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sprint s=Proyecto.getInstance().getSprintEnCurso();
				String id=table_IP.getValueAt(table_IP.getSelectedRow(), 0).toString();
				EstadoTarea e=EstadoTarea.valueOf("INPROGRESS");
				s.cambiarEstadoTarea(id,e.next().toString());
				table_IP.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"INPROGRESS")));
				table_PTB.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"PENDINGTOBUILD")));
			}
		});
		add(btnInProgressSiguiente, "cell 7 10,alignx right,aligny center");
		
		btnPendingToBouildAnterior = new JButton("\u00AB Anterior");
		btnPendingToBouildAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sprint s=Proyecto.getInstance().getSprintEnCurso();
				String id=table_PTB.getValueAt(table_PTB.getSelectedRow(), 0).toString();
				EstadoTarea e1=EstadoTarea.valueOf("PENDINGTOBUILD");
				s.cambiarEstadoTarea(id,e1.previous().toString());
				table_PTB.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"PENDINGTOBUILD")));
				table_TD.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"TODO")));
			}
		});
		add(btnPendingToBouildAnterior, "cell 10 10 2 1,alignx left,aligny center");
		
		btnPendingToBouildSiguiente = new JButton("Siguiente \u00BB");
		btnPendingToBouildSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sprint s=Proyecto.getInstance().getSprintEnCurso();
				String id=table_PTB.getValueAt(table_PTB.getSelectedRow(), 0).toString();
				EstadoTarea e1=EstadoTarea.valueOf("PENDINGTOBUILD");
				s.cambiarEstadoTarea(id,e1.next().toString());
				table_PTB.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"PENDINGTOBUILD")));
				table_RTT.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"READYTOTEST")));
			}
		});
		add(btnPendingToBouildSiguiente, "cell 14 10 2 1,alignx right,aligny center");
		
		btnTestingAnterior = new JButton("\u00AB Anterior");
		btnTestingAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sprint s=Proyecto.getInstance().getSprintEnCurso();
				String id=table_T.getValueAt(table_T.getSelectedRow(), 0).toString();
				EstadoTarea e1=EstadoTarea.valueOf("TESTING");
				s.cambiarEstadoTarea(id,e1.previous().toString());
				table_T.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"TESTING")));
				table_TD.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"TODO")));
			}
		});
		add(btnTestingAnterior, "cell 17 10 2 1,alignx left,aligny center");
		
		btnTestingSiguiente = new JButton("Siguiente \u00BB");
		btnTestingSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sprint s=Proyecto.getInstance().getSprintEnCurso();
				String id=table_T.getValueAt(table_T.getSelectedRow(), 0).toString();
				EstadoTarea e1=EstadoTarea.valueOf("TESTING");
				s.cambiarEstadoTarea(id,e1.next().toString());
				table_T.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"TESTING")));
				table_D.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"DONE")));
			}
		});
		add(btnTestingSiguiente, "cell 21 10,alignx right,aligny center");
		
		btnFinalizaSprint = new JButton("Finaliza Sprint");
		btnFinalizaSprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Proyecto.getInstance().getSprintEnCurso().finalizar();
				if(Proyecto.getInstance().finalizaSprint(Proyecto.getInstance().getSprintEnCurso().getClave())){
					table_D.removeAll();
					table_IP.removeAll();
					table_PTB.removeAll();
					table_RTT.removeAll();
					table_T.removeAll();
					table_TD.removeAll();
					lblIdSprint = new JLabel("ID Sprint");
					lblNombreSprint = new JLabel("Nombre Sprint");
					lblEstadoActual = new JLabel("Estado Actual");
					lblDuracin_Actual = new JLabel("0");
					lblAvance_Actual = new JLabel("0");
					lblDaActual_Actual = new JLabel("0");
					Proyecto.getInstance().getSprintEnCurso().finalizar();
					
				}
				else
					JOptionPane.showMessageDialog(null, "El sprint no finalizo");
				
			}
		});
		add(btnFinalizaSprint, "cell 24 10 2 1,alignx right,aligny center");
		
		
	}

	public void vaciaTabla(DefaultTableModel dtm){
		while(0<dtm.getRowCount())
			dtm.removeRow(0);
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

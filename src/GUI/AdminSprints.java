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
	private JLabel lblTodoACT;
	private JLabel lblInprogressACT;
	private JLabel lblPendingtobuildACT;
	private JLabel lblReadytotestACT;
	private JLabel lblTestingACT;
		

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
		
		lblIdSprint = new JLabel("ID Sprint");
		lblNombreSprint = new JLabel("Nombre Sprint");
		lblEstadoActual = new JLabel("Estado Actual");
		lblDuracin_Actual = new JLabel("0");
		lblAvance_Actual = new JLabel("0");
		lblDaActual_Actual = new JLabel("0");
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
					JOptionPane.showMessageDialog(null, "Ya ha alcanzado la fecha límite del sprint");
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
		
		
		
		
		
		try {
			lblTodoACT = new JLabel((table_TD.getValueAt(table_TD.getSelectedRow(), 0)).toString());
		}
		catch(NullPointerException npe) {
			lblTodoACT = new JLabel("ToDoACT");				
		}
		
		//lblTodoACT = new JLabel("ToDoACT");
		lblTodoACT.setFont(new Font("Tahoma", Font.PLAIN, 5));
		add(lblTodoACT, "cell 2 1,alignx center,aligny center");
		lblTodoACT.setVisible(false);
		
		try {
			lblInprogressACT = new JLabel((table_IP.getValueAt(table_IP.getSelectedRow(), 0)).toString());
			}
		catch(NullPointerException npe) {
			lblInprogressACT = new JLabel("InProgress");
			}
		//lblInprogressACT = new JLabel("InProgress");
		lblInprogressACT.setFont(new Font("Tahoma", Font.PLAIN, 5));
		add(lblInprogressACT, "cell 6 1 2 1,alignx center,growy");
		lblInprogressACT.setVisible(false);
		
		try {
			lblPendingtobuildACT = new JLabel((table_PTB.getValueAt(table_PTB.getSelectedRow(), 0)).toString());
			}
		catch(NullPointerException npe) {
			lblPendingtobuildACT = new JLabel("PendingToBuildACT");
			}
		//lblPendingtobuildACT = new JLabel("PendingToBuildACT");
		lblPendingtobuildACT.setFont(new Font("Tahoma", Font.PLAIN, 5));
		add(lblPendingtobuildACT, "cell 11 1 4 1,alignx center,aligny center");
		lblPendingtobuildACT.setVisible(false);
		
		try {
			lblReadytotestACT = new JLabel((table_PTB.getValueAt(table_PTB.getSelectedRow(), 0)).toString());
			}
		catch(NullPointerException npe) {
			lblReadytotestACT = new JLabel("ReadyToTestACT");
			}
		//lblReadytotestACT = new JLabel("ReadyToTestACT");
		lblReadytotestACT.setFont(new Font("Tahoma", Font.PLAIN, 5));
		add(lblReadytotestACT, "cell 18 1 4 1,alignx center,aligny center");
		lblReadytotestACT.setVisible(false);
		
		try {
			lblTestingACT = new JLabel((table_T.getValueAt(table_T.getSelectedRow(), 0)).toString());
			}
		catch(NullPointerException npe) {
			lblTestingACT = new JLabel("TestingACT");
			}
		//lblTestingACT = new JLabel("TestingACT");
		lblTestingACT.setFont(new Font("Tahoma", Font.PLAIN, 5));
		add(lblTestingACT, "cell 24 1 2 1,alignx center,aligny center");
		lblTestingACT.setVisible(false);
		

		
		
		
		
		scrollPane_ToDo = new JScrollPane();
		add(scrollPane_ToDo, "cell 0 6 3 4,grow");
		
		table_TD = new JTable();
		table_TD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblTodoACT.setText((table_TD.getValueAt(table_TD.getSelectedRow(), 0)).toString());
			}
		});
		scrollPane_ToDo.setViewportView(table_TD);
		
		scrollPane_Inprogress = new JScrollPane();
		add(scrollPane_Inprogress, "cell 4 6 4 4,grow");
		
		table_IP = new JTable();
		table_IP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblInprogressACT.setText((table_IP.getValueAt(table_IP.getSelectedRow(), 0)).toString());
			}
		});
		scrollPane_Inprogress.setViewportView(table_IP);
		
		scrollPane_Pendingtobuild = new JScrollPane();
		add(scrollPane_Pendingtobuild, "cell 9 6 7 4,grow");
		
		table_PTB = new JTable();
		table_PTB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblPendingtobuildACT.setText((table_PTB.getValueAt(table_PTB.getSelectedRow(), 0)).toString());
			}
		});
		scrollPane_Pendingtobuild.setViewportView(table_PTB);
		
		scrollPane_Readytotest = new JScrollPane();
		add(scrollPane_Readytotest, "cell 17 6 5 1,grow");
		
		table_RTT = new JTable();
		table_RTT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblReadytotestACT.setText((table_RTT.getValueAt(table_RTT.getSelectedRow(), 0)).toString());
			}
		});
		scrollPane_Readytotest.setViewportView(table_RTT);
		
		scrollPane_Testing = new JScrollPane();
		add(scrollPane_Testing, "cell 17 9 5 1,grow");
		
		table_T = new JTable();
		table_T.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblTestingACT.setText((table_T.getValueAt(table_T.getSelectedRow(), 0)).toString());
			}
		});
		scrollPane_Testing.setViewportView(table_T);
		
		scrollPane_Done = new JScrollPane();
		add(scrollPane_Done, "cell 23 6 3 4,grow");
		
		table_D = new JTable();
		scrollPane_Done.setViewportView(table_D);
		
		
		
		cargaDatos();
		
		/*if(Proyecto.getInstance().getSprintEnCurso()!=null){
			Sprint s=Proyecto.getInstance().getSprintEnCurso();
			table_TD.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"TODO")));
			table_IP.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"INPROGRESS")));
			table_PTB.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"PENDINGTOBUILD")));
			table_RTT.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"READYTOTEST")));
			table_T.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"TESTING")));
			table_D.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"DONE")));
		}*/
		
		
		
		
		

		
		btnToDoSiguiente = new JButton("Siguiente \u00BB");
		btnToDoSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (lblTodoACT.getText() != "ToDoACT") {
					Sprint s=Proyecto.getInstance().getSprintEnCurso();
					String id=table_TD.getValueAt(table_TD.getSelectedRow(), 0).toString();
					EstadoTarea e=EstadoTarea.valueOf("TODO");
					s.cambiarEstadoTarea(id,e.next().toString());
					table_TD.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"TODO")));
					table_IP.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"INPROGRESS")));
					lblTodoACT.setText("ToDoACT");
				}
			}
		});
		add(btnToDoSiguiente, "cell 2 10,alignx right,aligny center");
		
		btnInProgressSiguiente = new JButton("Siguiente \u00BB");
		btnInProgressSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (lblInprogressACT.getText() != "InProgress") {
					Sprint s=Proyecto.getInstance().getSprintEnCurso();
					String id=table_IP.getValueAt(table_IP.getSelectedRow(), 0).toString();
					EstadoTarea e=EstadoTarea.valueOf("INPROGRESS");
					s.cambiarEstadoTarea(id,e.next().toString());
					table_IP.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"INPROGRESS")));
					table_PTB.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"PENDINGTOBUILD")));
					lblInprogressACT.setText("InProgress");
				}
			}
		});
		add(btnInProgressSiguiente, "cell 7 10,alignx right,aligny center");
		
		btnPendingToBouildAnterior = new JButton("\u00AB Anterior");
		btnPendingToBouildAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblPendingtobuildACT.getText() != "PendingToBuildACT") {
					Sprint s=Proyecto.getInstance().getSprintEnCurso();
					String id=table_PTB.getValueAt(table_PTB.getSelectedRow(), 0).toString();
					EstadoTarea e1=EstadoTarea.valueOf("PENDINGTOBUILD");
					s.cambiarEstadoTarea(id,e1.previous().toString());
					table_PTB.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"PENDINGTOBUILD")));
					table_TD.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"TODO")));
					lblPendingtobuildACT.setText("PendingToBuildACT");
				}	
			}
		});
		add(btnPendingToBouildAnterior, "cell 10 10 2 1,alignx left,aligny center");
		
		btnPendingToBouildSiguiente = new JButton("Siguiente \u00BB");
		btnPendingToBouildSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblPendingtobuildACT.getText() != "PendingToBuildACT") {
					Sprint s=Proyecto.getInstance().getSprintEnCurso();
					String id=table_PTB.getValueAt(table_PTB.getSelectedRow(), 0).toString();
					EstadoTarea e1=EstadoTarea.valueOf("PENDINGTOBUILD");
					s.cambiarEstadoTarea(id,e1.next().toString());
					table_PTB.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"PENDINGTOBUILD")));
					table_RTT.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"READYTOTEST")));
					lblPendingtobuildACT.setText("PendingToBuildACT");
				}
			}
		});
		add(btnPendingToBouildSiguiente, "cell 14 10 2 1,alignx right,aligny center");
		
		btnReadyToTestSiguiente = new JButton("Siguiente \u00BB");
		btnReadyToTestSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblReadytotestACT.getText() != "ReadyToTestACT") {
					Sprint s=Proyecto.getInstance().getSprintEnCurso();
					String id=table_RTT.getValueAt(table_RTT.getSelectedRow(), 0).toString();
					EstadoTarea e1=EstadoTarea.valueOf("READYTOTEST");
					s.cambiarEstadoTarea(id,e1.next().toString());
					table_RTT.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"READYTOTEST")));
					table_T.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"TESTING")));
					lblReadytotestACT.setText("ReadyToTestACT");
				}
			}
		});
		add(btnReadyToTestSiguiente, "cell 21 7,alignx right,aligny center");
		
		btnTestingAnterior = new JButton("\u00AB Anterior");
		btnTestingAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblTestingACT.getText() != "TestingACT") {Sprint s=Proyecto.getInstance().getSprintEnCurso();
					String id=table_T.getValueAt(table_T.getSelectedRow(), 0).toString();
					EstadoTarea e1=EstadoTarea.valueOf("TESTING");
					s.cambiarEstadoTarea(id,e1.previous().toString());
					table_T.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"TESTING")));
					table_TD.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"TODO")));
					lblTestingACT.setText("TestingACT");
				}
			}
		});
		add(btnTestingAnterior, "cell 17 10 2 1,alignx left,aligny center");
		
		btnTestingSiguiente = new JButton("Siguiente \u00BB");
		btnTestingSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblTestingACT.getText() != "TestingACT") {
					Sprint s=Proyecto.getInstance().getSprintEnCurso();
					String id=table_T.getValueAt(table_T.getSelectedRow(), 0).toString();
					EstadoTarea e1=EstadoTarea.valueOf("TESTING");
					s.getTarea(id).setfFin(s.getfAvance());
					s.cambiarEstadoTarea(id,e1.next().toString());
					table_T.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"TESTING")));
					table_D.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"DONE")));
					lblTestingACT.setText("TestingACT");
				}			
			}
		});
		add(btnTestingSiguiente, "cell 21 10,alignx right,aligny center");
		
		btnFinalizaSprint = new JButton("Finaliza Sprint");
		btnFinalizaSprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Proyecto.getInstance().getSprintEnCurso().finalizar();
				if(Proyecto.getInstance().finalizaSprint(Proyecto.getInstance().getSprintEnCurso().getClave())){
					lblTodoACT.setText("ToDoACT");
					lblInprogressACT.setText("InProgress");
					lblPendingtobuildACT.setText("PendingToBuildACT");
					lblReadytotestACT.setText("ReadyToTestACT");
					lblTestingACT.setText("TestingACT");
					table_D.removeAll();
					table_IP.removeAll();
					table_PTB.removeAll();
					table_RTT.removeAll();
					table_T.removeAll();
					table_TD.removeAll();
					lblIdSprint.setText("ID Sprint");
					lblNombreSprint.setText("Nombre Sprint");
					lblEstadoActual.setText("Estado Actual");
					lblDuracin_Actual.setText("0");
					lblAvance_Actual.setText("0");
					lblDaActual_Actual.setText("0");
					Proyecto.getInstance().pasaTareasaBacklog();
					Proyecto.getInstance().getSprintEnCurso().finalizar();
					vaciaTablas();
					InterfazGrafica.getInstance().abrirABMSprint();
				}
				else
					JOptionPane.showMessageDialog(null, "El sprint no finalizo");
				
			}
		});
		add(btnFinalizaSprint, "cell 24 10 2 1,alignx right,aligny center");
		
		
	}

	public void setLblIdSprint(JLabel lblIdSprint) {
		this.lblIdSprint = lblIdSprint;
	}

	public void setLblNombreSprint(JLabel lblNombreSprint) {
		this.lblNombreSprint = lblNombreSprint;
	}

	public void setLblEstado(JLabel lblEstado) {
		this.lblEstado = lblEstado;
	}

	public void setLblDaActual_Actual(JLabel lblDaActual_Actual) {
		this.lblDaActual_Actual = lblDaActual_Actual;
	}

	public void setLblDuracin_Actual(JLabel lblDuracin_Actual) {
		this.lblDuracin_Actual = lblDuracin_Actual;
	}

	public void setLblAvance_Actual(JLabel lblAvance_Actual) {
		this.lblAvance_Actual = lblAvance_Actual;
	}
	
	
	public void cargaDatos(){
		
			if(Proyecto.getInstance().getSprintEnCurso()!=null){
				Sprint s=Proyecto.getInstance().getSprintEnCurso();
				lblIdSprint.setText(s.getClave());
				lblNombreSprint.setText(s.getDescripcion());
				lblEstadoActual.setText("En curso");
				lblDuracin_Actual.setText(String.valueOf(s.duracion()));
				lblAvance_Actual.setText(String.valueOf(s.getAvance()));
				lblDaActual_Actual.setText(s.getfAvance().toString());
				scrollPane_Done.setVisible(true);
				scrollPane_Inprogress.setVisible(true);
				scrollPane_Pendingtobuild.setVisible(true);
				scrollPane_Readytotest.setVisible(true);
				scrollPane_Testing.setVisible(true);
				scrollPane_ToDo.setVisible(true);
				table_TD.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"TODO")));
				table_IP.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"INPROGRESS")));
				table_PTB.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"PENDINGTOBUILD")));
				table_RTT.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"READYTOTEST")));
				table_T.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"TESTING")));
				table_D.setModel(new TareasSprintEnCursoTM(Proyecto.getInstance().getListaEstados(s.getClave(),"DONE")));
			}
			else{
				lblIdSprint.setText("ID Sprint");
				lblNombreSprint.setText("Nombre Sprint");
				lblEstadoActual.setText("Estado Actual");
				lblDuracin_Actual.setText("0");
				lblAvance_Actual.setText("0");
				lblDaActual_Actual.setText("0");
				vaciaTablas();
			}
	}
	
	public void vaciaTablas(){
		scrollPane_Done.setVisible(false);
		scrollPane_Inprogress.setVisible(false);
		scrollPane_Pendingtobuild.setVisible(false);
		scrollPane_Readytotest.setVisible(false);
		scrollPane_Testing.setVisible(false);
		scrollPane_ToDo.setVisible(false);
	}
	
	
}

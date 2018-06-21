package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import clases.Proyecto;
import clases.Sprint;
import net.miginfocom.swing.MigLayout;
import tareas.Tarea;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class Historico extends JPanel {
	
	private JMenuBar hmenuBar;		
		private JMenuItem mntmHAdmSprints;
		private JMenuItem mntmHSprints;	
		private JMenuItem mntmHTareas;
		private JMenuItem mntmHBacklog;
		private JMenuItem mntmHHistorico;	
		private JMenuItem mntmHReportes;	
		
	private JLabel lblSprints;
	
	private JLabel lblSprint;
	private JLabel lblSep_1;
	private JLabel lblIdSprint;
	private JLabel lblSep_2;
	private JLabel lblFinicio;
	private JLabel lblSep_3;
	private JLabel lblFfin;	
		
	private JScrollPane scrollPane_Sprints;
	private JTable table_Sprint;
	private JScrollPane scrollPane_Tareas;
	private JTable table_Tareas;
	private JSeparator separator_0;
	private JSeparator separator_1;
	private JScrollPane scrollPane_Historico;
	private JTable table_Historico;
	
	/**
	 * Create the panel.
	 */
	public Historico() {

		setLayout(new MigLayout("", "[101.00][][115.00][][115][][115,grow][762.00,grow]", "[24px:24px][10][179.00][15][24.00][15][424.00,grow]"));
		
		hmenuBar = new JMenuBar();
			mntmHAdmSprints = new JMenuItem("Administración");
			mntmHAdmSprints.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirAdminSprints();}});
			hmenuBar.add(mntmHAdmSprints);
			mntmHSprints = new JMenuItem("Sprints");
			mntmHSprints.setHorizontalAlignment(SwingConstants.CENTER);
			mntmHSprints.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirABMSprint();}});
			hmenuBar.add(mntmHSprints);
			mntmHTareas = new JMenuItem("Tareas");
			mntmHTareas.setHorizontalAlignment(SwingConstants.CENTER);
			mntmHTareas.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirABMSTareas();}});
			hmenuBar.add(mntmHTareas);
			mntmHBacklog = new JMenuItem("Backlog");
			mntmHBacklog.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirBacklog();}});
			hmenuBar.add(mntmHBacklog);
			mntmHHistorico = new JMenuItem("Historico");
			mntmHHistorico.setHorizontalAlignment(SwingConstants.CENTER);
			mntmHHistorico.setSelected(true);
			mntmHHistorico.setBackground(Color.LIGHT_GRAY);
			mntmHHistorico.setHorizontalAlignment(SwingConstants.CENTER);
			mntmHHistorico.setFont(new Font("Segoe UI", Font.BOLD, 13));
			hmenuBar.add(mntmHHistorico);
			mntmHReportes = new JMenuItem("Reportes");
			mntmHReportes.setHorizontalAlignment(SwingConstants.CENTER);
			mntmHReportes.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirReportes();}});
			hmenuBar.add(mntmHReportes);
			add(hmenuBar, "cell 0 0 8 1,growx,aligny top");

			lblSprint = new JLabel("Sprints \u00BB");
			lblSprint.setFont(new Font("Tahoma", Font.BOLD, 24));
			add(lblSprint, "cell 0 2 2 1,alignx center,aligny center");

			/*if(Proyecto.getInstance().getSprintEnCurso()!=null){
				
				Sprint s=Proyecto.getInstance().getSprint(table_Sprint.getValueAt(table_Sprint.getSelectedRow(), 0).toString());
				lblIdSprint = new JLabel(s.getClave());
				lblFinicio = new JLabel(s.getfInicio().toString());
				lblFfin = new JLabel(s.getFechaFin().toString());

			}
			else{
				lblIdSprint = new JLabel("ID Sprint");
				lblFinicio = new JLabel("Fecha de Inicio");
				lblFfin = new JLabel("Fecha de Finalizacion");

			}*/
			
			
			scrollPane_Sprints=new JScrollPane();
			add(scrollPane_Sprints, "cell 2 2 6 1,grow");
			
			table_Sprint = new JTable();
			scrollPane_Sprints.setViewportView(table_Sprint);
			table_Sprint.setModel(new SprintsTM(Proyecto.getInstance().getLSprints()));
			
			table_Sprint.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					table_Tareas.setModel(new TareasTM(Proyecto.getInstance().getSprint(table_Sprint.getValueAt(table_Sprint.getSelectedRow(), 0).toString()).getListaT()));
					lblIdSprint.setText(Proyecto.getInstance().getSprint(table_Sprint.getValueAt(table_Sprint.getSelectedRow(), 0).toString()).getClave());
					lblFinicio.setText(Proyecto.getInstance().getSprint(table_Sprint.getValueAt(table_Sprint.getSelectedRow(), 0).toString()).getfInicio().toString());
					lblFfin.setText(Proyecto.getInstance().getSprint(table_Sprint.getValueAt(table_Sprint.getSelectedRow(), 0).toString()).getFechaFin().toString());
				}
			});
			
			separator_0 = new JSeparator();
			separator_0.setForeground(Color.BLACK);
			add(separator_0, "cell 0 3 8 1,growx,aligny center");
			
			lblSprint = new JLabel("Sprint");
			lblSprint.setFont(new Font("Tahoma", Font.BOLD, 12));
			add(lblSprint, "cell 0 4,alignx center,aligny center");
			
			lblSep_1 = new JLabel(" - ");
			lblSep_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			add(lblSep_1, "cell 1 4,alignx center,aligny center");
			
			lblIdSprint = new JLabel("ID Sprint");
			lblIdSprint.setFont(new Font("Tahoma", Font.BOLD, 12));
			add(lblIdSprint, "cell 2 4,alignx center,aligny center");
			
			lblSep_2 = new JLabel(" - ");
			lblSep_2.setFont(new Font("Tahoma", Font.BOLD, 12));
			add(lblSep_2, "cell 3 4,alignx center,aligny center");
			
			lblFinicio = new JLabel("Fecha de Inicio");
			lblFinicio.setFont(new Font("Tahoma", Font.BOLD, 12));
			add(lblFinicio, "cell 4 4,alignx center,aligny center");

			lblSep_3 = new JLabel(" - ");
			lblSep_3.setFont(new Font("Tahoma", Font.BOLD, 12));
			add(lblSep_3, "cell 5 4,alignx center,aligny center");
			
			lblFfin = new JLabel("Fecha de Finalizacion");
			lblFfin.setFont(new Font("Tahoma", Font.BOLD, 12));
			add(lblFfin, "cell 6 4,alignx center,aligny center");
			
			separator_1 = new JSeparator();
			separator_1.setForeground(Color.BLACK);
			add(separator_1, "cell 0 5 8 1,growx,aligny center");
					
						
			scrollPane_Tareas = new JScrollPane();
			add(scrollPane_Tareas, "cell 0 6 6 1,grow");
			
			table_Tareas = new JTable();
			scrollPane_Tareas.setViewportView(table_Tareas);
			
						
						
						
			scrollPane_Historico = new JScrollPane();
			add(scrollPane_Historico, "cell 6 6 2 1,grow");
			
			table_Historico = new JTable();
			scrollPane_Historico.setViewportView(table_Historico);
			table_Tareas.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					table_Historico.setModel(new HistoricoTM(Proyecto.getInstance().getSprint(table_Sprint.getValueAt(table_Sprint.getSelectedRow(), 0).toString()).getTarea(table_Tareas.getValueAt(table_Tareas.getSelectedRow(),0).toString()).getLhist()));
					
				}
			});
			
			revalidate();
			repaint();

		
	}
}

package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import clases.Proyecto;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Reportes extends JPanel {
	private JMenuBar rmenuBar;	
		private JMenuItem mntmRAdmSprints;	
		private JMenuItem mntmRSprints;	
		private JMenuItem mntmRTareas;
		private JMenuItem mntmRBacklog;
		private JMenuItem mntmRHistorico;
		private JMenuItem mntmRReportes;
		
	private JButton btnRankingSprings;
	private JButton btnReporteSprint;
	private JButton btnReporteBurndown;
	
	private JScrollPane scrollPane_1;
	private JTable table1;
	private JScrollPane scrollPane_2;
	private JTable table2;
	private JScrollPane scrollPane_3;
	private JTable table3;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel lblEstimacionTareasCompletadas;
	private JLabel label_2;
		/**
		 * Create the panel.
		 */
	
		public Reportes() {
			setLayout(new MigLayout("", "[6.00px][123.00px][13.00][619,grow][309.00][309.00]", "[24px:24px][2.00][40.00][23px][17.00][23px][17][][223.00][65][347.00px]"));
			
			rmenuBar = new JMenuBar();
			rmenuBar.setMargin(new Insets(0, 15, 0, 15));
				mntmRAdmSprints = new JMenuItem("Administración");
				mntmRAdmSprints.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {	
						InterfazGrafica.getInstance().abrirAdminSprints();}});
				rmenuBar.add(mntmRAdmSprints);
				mntmRSprints = new JMenuItem("Sprints");
				mntmRSprints.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {	
						InterfazGrafica.getInstance().abrirABMSprint();}});
				rmenuBar.add(mntmRSprints);
				mntmRTareas = new JMenuItem("Tareas");
				mntmRTareas.setHorizontalAlignment(SwingConstants.CENTER);
				mntmRTareas.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {	
						InterfazGrafica.getInstance().abrirABMSTareas();}});
				rmenuBar.add(mntmRTareas);
				mntmRBacklog = new JMenuItem("Backlog");
				mntmRBacklog.setHorizontalAlignment(SwingConstants.CENTER);
				mntmRBacklog.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {	
						InterfazGrafica.getInstance().abrirBacklog();}});
				rmenuBar.add(mntmRBacklog);
				mntmRHistorico = new JMenuItem("Historico");
				mntmRHistorico.setHorizontalAlignment(SwingConstants.CENTER);
				mntmRHistorico.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {	
						InterfazGrafica.getInstance().abrirHistorico();}});
				rmenuBar.add(mntmRHistorico);
				mntmRReportes = new JMenuItem("Reportes");
				mntmRReportes.setSelected(true);
				mntmRReportes.setForeground(Color.BLACK);
				mntmRReportes.setBackground(Color.LIGHT_GRAY);
				mntmRReportes.setHorizontalAlignment(SwingConstants.CENTER);
				mntmRReportes.setFont(new Font("Segoe UI", Font.BOLD, 13));
				rmenuBar.add(mntmRReportes);
				add(rmenuBar, "cell 0 0 12 1,growx,aligny top");
				
				

				btnRankingSprings = new JButton("Ranking Sprints");
				btnRankingSprings.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						table1.setModel(new SprintsTM(Proyecto.getInstance().RankingEstimacion()));
						//table2.setVisible(false);
						//table3.setVisible(false);
					}
				});
				add(btnRankingSprings, "cell 1 3,growx,aligny center");
				
				btnReporteSprint = new JButton("Reporte Sprint ");
				btnReporteSprint.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						table1.setModel(new SprintsTM(Proyecto.getInstance().getSprintsFinalizados()));
					}
				});
				
				lblEstimacionTareasCompletadas = new JLabel("Estimacion Tareas Completadas: ");
				lblEstimacionTareasCompletadas.setFont(new Font("Tahoma", Font.BOLD, 12));
				add(lblEstimacionTareasCompletadas, "cell 4 3,alignx right,aligny center");
				
				label_2 = new JLabel("0");
				label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
				add(label_2, "cell 5 3,alignx left,aligny center");
				add(btnReporteSprint, "cell 1 5,growx,aligny center");
				
				btnReporteBurndown = new JButton("Reporte Burndown");
				add(btnReporteBurndown, "cell 1 7,growx,aligny center");
				
				scrollPane_1 = new JScrollPane();
				add(scrollPane_1, "cell 3 1 1 10,grow");
				
				table1 = new JTable();
				scrollPane_1.setViewportView(table1);
				table1.addMouseListener(new MouseListener() {
					
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
						//table2.setVisible(true);
						//table3.setVisible(true);
						label_2.setText(String.valueOf(Proyecto.getInstance().getSprint(table1.getValueAt(table1.getSelectedRow(), 0).toString()).estimacionTareasReporte("completadas")));
						label.setText(String.valueOf(Proyecto.getInstance().getSprint(table1.getValueAt(table1.getSelectedRow(), 0).toString()).estimacionTareasReporte("no completadas")));
						table2.setModel(new TareasTM(Proyecto.getInstance().getSprint(table1.getValueAt(table1.getSelectedRow(), 0).toString()).tareasCompletadas()));
						table3.setModel(new TareasTM(Proyecto.getInstance().getSprint(table1.getValueAt(table1.getSelectedRow(), 0).toString()).tareasNoCompletadas()));
					}
				});
				
				scrollPane_2 = new JScrollPane();
				add(scrollPane_2, "cell 4 4 2 5,grow");
				
				table2=new JTable();
				scrollPane_2.setViewportView(table2);
				//table2.setVisible(false);
				
				lblNewLabel = new JLabel("Estimacion Tareas No Completadas: ");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
				add(lblNewLabel, "cell 4 9,alignx right,aligny center");
				
				label = new JLabel("0");
				label.setFont(new Font("Tahoma", Font.PLAIN, 12));
				add(label, "cell 5 9,alignx left,aligny center");
				
				scrollPane_3 = new JScrollPane();
				add(scrollPane_3, "cell 4 10 2 1,grow");
				
				table3 = new JTable();
				scrollPane_3.setViewportView(table3);
				//table3.setVisible(false);
		}
	}
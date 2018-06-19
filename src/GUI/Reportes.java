package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

public class Reportes extends JPanel {
	private JMenuBar rmenuBar;	
		private JMenuItem mntmRAdmSprints;	
		private JMenuItem mntmRSprints;	
		private JMenuItem mntmRTareas;
		private JMenuItem mntmRBacklog;
		private JMenuItem mntmRReportes;
		
	private JButton btnRankingSprings;
	private JButton btnReporteSprint;
	private JButton btnReporteBurndown;
		
	private JScrollPane scrollPane_RankingSprings;
	private JTable table;
		/**
		 * Create the panel.
		 */
	
		public Reportes() {
			setLayout(new MigLayout("", "[6.00px][123.00px][13.00][1159.00,grow]", "[24px:24px][2.00][40.00][23px][17.00][23px][17][][12][500.00px,grow]"));
			
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
				mntmRReportes = new JMenuItem("Reportes");
				mntmRReportes.setSelected(true);
				mntmRReportes.setForeground(Color.BLACK);
				mntmRReportes.setBackground(Color.LIGHT_GRAY);
				mntmRReportes.setHorizontalAlignment(SwingConstants.CENTER);
				mntmRReportes.setFont(new Font("Segoe UI", Font.BOLD, 13));
				rmenuBar.add(mntmRReportes);
				add(rmenuBar, "cell 0 0 10 1,growx,aligny top");
				
				

				btnRankingSprings = new JButton("Ranking Sprints");
				btnRankingSprings.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						table.setModel(new SprintsTM(Proyecto.getInstance().RankingEstimacion()));
					}
				});
				add(btnRankingSprings, "cell 1 3,growx,aligny center");
				
				btnReporteSprint = new JButton("Reporte Sprint ");
				add(btnReporteSprint, "cell 1 5,growx,aligny center");
				
				btnReporteBurndown = new JButton("Reporte Burndown");
				add(btnReporteBurndown, "cell 1 7,growx,aligny center");
				
				scrollPane_RankingSprings = new JScrollPane();
				add(scrollPane_RankingSprings, "cell 3 2 1 8,grow");
				
				table=new JTable();
				scrollPane_RankingSprings.setViewportView(table);

		}
	}
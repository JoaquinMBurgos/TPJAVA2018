package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import clases.Proyecto;
import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Backlog extends JPanel {
	private JMenuBar bmenuBar;		
		private JMenuItem mntmBAdmSprints;
		private JMenuItem mntmBSprints;	
		private JMenuItem mntmBTareas;
		private JMenuItem mntmBBacklog;
		private JMenuItem mntmBHistorico;	
		private JMenuItem mntmBReportes;	
		
		private JScrollPane scrollPane_Backlog;
		private JTable table;


	
	/**
	 * Create the panel.
	 */
	public Backlog() {

		setLayout(new MigLayout("", "[1284.00px,grow]", "[24px:24px][11.00][685,grow]"));
		
		bmenuBar = new JMenuBar();
			mntmBAdmSprints = new JMenuItem("Administración");
			mntmBAdmSprints.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirAdminSprints();}});
			bmenuBar.add(mntmBAdmSprints);
			mntmBSprints = new JMenuItem("Sprints");
			mntmBSprints.setHorizontalAlignment(SwingConstants.CENTER);
			mntmBSprints.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirABMSprint();}});
			bmenuBar.add(mntmBSprints);
			mntmBTareas = new JMenuItem("Tareas");
			mntmBTareas.setHorizontalAlignment(SwingConstants.CENTER);
			mntmBTareas.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirABMSTareas();}});
			bmenuBar.add(mntmBTareas);
			mntmBBacklog = new JMenuItem("Backlog");
			mntmBBacklog.setSelected(true);
			mntmBBacklog.setBackground(Color.LIGHT_GRAY);
			mntmBBacklog.setHorizontalAlignment(SwingConstants.CENTER);
			mntmBBacklog.setFont(new Font("Segoe UI", Font.BOLD, 13));
			bmenuBar.add(mntmBBacklog);
			mntmBHistorico = new JMenuItem("Historico");
			mntmBHistorico.setHorizontalAlignment(SwingConstants.CENTER);
			mntmBHistorico.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirHistorico();}});
			bmenuBar.add(mntmBHistorico);
			mntmBReportes = new JMenuItem("Reportes");
			mntmBReportes.setHorizontalAlignment(SwingConstants.CENTER);
			mntmBReportes.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirReportes();}});
			bmenuBar.add(mntmBReportes);
			add(bmenuBar, "cell 0 0,growx,aligny top");
			
			scrollPane_Backlog = new JScrollPane();
			add(scrollPane_Backlog, "cell 0 2,grow");
			
			table = new JTable();
			scrollPane_Backlog.setViewportView(table);
			table.setModel(new TareasTM(Proyecto.getInstance().getBlog().getLTareasP()));
			
			revalidate();
			repaint();

		
	}
}

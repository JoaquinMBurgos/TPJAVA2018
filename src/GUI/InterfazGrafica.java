package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JScrollPane;

import clases.EstadoSprint;
import clases.Sprint;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

public final class InterfazGrafica {

	private JFrame frmScrum = new JFrame();
	private JPanel panel = new JPanel();

	private ABMSprints abms = new ABMSprints();
	private ABMTareas abmt = new ABMTareas();
	private Backlog abmb = new Backlog();
	private Reportes rep = new Reportes();
	private AdminSprints admins = new AdminSprints();
	
	private static InterfazGrafica instance = null;

	/**
	 * Launch the application.
	 */
	public void start() {
		try {
			frmScrum.setVisible(true);
			panel.setVisible(true);
			frmScrum.setLocationRelativeTo(null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void abrirAdminSprints(){
		
		frmScrum.remove(panel);
		panel = admins;
		
		frmScrum.getContentPane().add(panel);		
		frmScrum.revalidate();
		frmScrum.repaint();
	}
	
	public void abrirABMSprint(){
		
		frmScrum.remove(panel);
		panel = abms;
		
		frmScrum.getContentPane().add(panel);
		frmScrum.revalidate();
		frmScrum.repaint();
	}
	
	public void abrirABMSTareas(){
	
		frmScrum.remove(panel);
		panel = abmt;
			
		frmScrum.getContentPane().add(panel);
		frmScrum.revalidate();
		frmScrum.repaint();
	}

	public void abrirBacklog(){

		frmScrum.remove(panel);
		panel = abmb;
		
		frmScrum.getContentPane().add(panel);
		frmScrum.revalidate();
		frmScrum.repaint();
	}
	
	public void abrirReportes(){
		 	
		frmScrum.remove(panel);
		panel = rep;
		
		frmScrum.getContentPane().add(panel);
		frmScrum.revalidate();
		frmScrum.repaint();
	}
	
	
	/**
	 * Create the application.
	 */
	
	private InterfazGrafica() {
		initialize();
		
	}

	public static InterfazGrafica getInstance(){
		
		if (instance == null)
			instance = new InterfazGrafica(); 
			
		return instance; 
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmScrum.setTitle("Scrum");
		frmScrum.setBounds(100, 100, 1280, 720);
		frmScrum.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScrum.getContentPane().setLayout(new MigLayout());
		panel = abms;
		frmScrum.getContentPane().add(panel, "cell 0 0,grow");
		
		
		/*frame.add(panel);
		panel.add(index);
		panel.add(abms);*/
		
		//index.setVisible(true);
		
	}


}

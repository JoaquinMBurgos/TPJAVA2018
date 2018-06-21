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
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
import clases.EstadoSprint;
import clases.Proyecto;
import clases.Sprint;
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
import tareas.Tarea;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.Button;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import java.awt.Label;

public class ABMSprints extends JPanel {
	private JMenuBar smenuBar;	
		private JMenuItem mntmSAdmSprints;
		private JMenuItem mntmSSprints;	
		private JMenuItem mntmSTareas;
		private JMenuItem mntmSBacklog;
		private JMenuItem mntmSHistorico;
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
	private JTable table_STareasBacklog;
	private JLabel lblTareasEnBacklog;
	private JLabel lblNombreSprint;
	private JTextField txtSNombre;
	private JButton btnIniciar;
	
	private JTable table_STareas;
	private JLabel lblSprintSeleccionado;
	private JLabel lblTareadelBacklogSelec;
	private JLabel lblTareadelSprintSelec;
	private Label label;
	private JDateChooser dateChooser_Ffin;
	private JLabel lblFechaDeFin;
	private JLabel lblFechaDeIni;
<<<<<<< HEAD
	private JDateChooser dateChooser_Fini;
=======
>>>>>>> 0bed7b656b89fd514bd1adafd6393efc37d7df54

	/**
	 * Create the panel.
	 */
	
	public ABMSprints() {
		setLayout(new MigLayout("", "[10][53][53,grow][53][10][261,grow][261,grow][57][522,grow]", "[24px:24px][20.00px][24.00][][15][][15][][15][][15][][15][][][10][][10][grow][15][39.00][15][][15][][15][][111][111,grow][17.00]"));
		
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
				mntmSHistorico = new JMenuItem("Historico");
				mntmSHistorico.setHorizontalAlignment(SwingConstants.CENTER);
				mntmSHistorico.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {	
						InterfazGrafica.getInstance().abrirHistorico();}});
				smenuBar.add(mntmSHistorico);
				mntmSReportes = new JMenuItem("Reportes");
				mntmSReportes.setHorizontalAlignment(SwingConstants.CENTER);
				mntmSReportes.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {	
						InterfazGrafica.getInstance().abrirReportes();}});
				smenuBar.add(mntmSReportes);
				add(smenuBar, "cell 0 0 9 1,growx,aligny top");
		
			

				
				
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
			
			txtSNombre = new JTextField();
			txtSNombre.setColumns(10);
			add(txtSNombre, "cell 0 11 4 1,growx,aligny top");
			
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
			add(rdbtnPlanificado, "cell 2 14");
				
<<<<<<< HEAD
			rdbtnFinalizado = new JRadioButton("Finalizado");
			rdbtnFinalizado.setSelected(false);
			rdbtnFinalizado.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					rdbtnPlanificado.setSelected(false);
					rdbtnEnCurso.setSelected(false);
					rdbtnFinalizado.setSelected(true);
				}
			});
			add(rdbtnFinalizado, "cell 2 18,aligny top");
						
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
		
			lblFechaDeIni = new JLabel("Fecha de Ini:");
			lblFechaDeIni.setFont(new Font("Tahoma", Font.PLAIN, 12));
			add(lblFechaDeIni, "cell 0 20 2 1");
=======
				rdbtnFinalizado = new JRadioButton("Finalizado");
				rdbtnFinalizado.setSelected(false);
				rdbtnFinalizado.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						rdbtnPlanificado.setSelected(false);
						rdbtnEnCurso.setSelected(false);
						rdbtnFinalizado.setSelected(true);
					}
				});
				add(rdbtnFinalizado, "cell 2 18,aligny top");
							
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
			
			lblFechaDeIni = new JLabel("Fecha de Ini:");
			lblFechaDeIni.setFont(new Font("Tahoma", Font.PLAIN, 12));
			add(lblFechaDeIni, "cell 0 20 2 1");
			
			JDateChooser dateChooser_Fini = new JDateChooser();
			add(dateChooser_Fini, "cell 2 20 2 1,growx,aligny center");
		
			lblFechaDeFin = new JLabel("Fecha de Fin:");
			lblFechaDeFin.setFont(new Font("Tahoma", Font.PLAIN, 12));
			add(lblFechaDeFin, "cell 0 22 2 1");
				
			dateChooser_Ffin = new JDateChooser();
			add(dateChooser_Ffin, "cell 2 22 2 1,growx,aligny center");

				
			
			
			
>>>>>>> 0bed7b656b89fd514bd1adafd6393efc37d7df54
			
			dateChooser_Fini = new JDateChooser();
			add(dateChooser_Fini, "cell 2 20 2 1,growx,aligny center");
			dateChooser_Fini.setVisible(false);

		
			lblFechaDeFin = new JLabel("Fecha de Fin:");
			lblFechaDeFin.setFont(new Font("Tahoma", Font.PLAIN, 12));
			add(lblFechaDeFin, "cell 0 22 2 1");
			lblFechaDeFin.setVisible(false);
				
			dateChooser_Ffin = new JDateChooser();
			add(dateChooser_Ffin, "cell 2 22 2 1,growx,aligny center");
			dateChooser_Ffin.setVisible(false);
				
	
			try {
				lblSprintSeleccionado = new JLabel((table.getValueAt(table.getSelectedRow(), 0)).toString());
			}
			catch(NullPointerException npe) {
				lblSprintSeleccionado = new JLabel("Sprint Seleccionado");				
			}
			
			try {
				lblTareadelSprintSelec = new JLabel((table_STareas.getValueAt(table_STareas.getSelectedRow(), 0)).toString());
			}
			catch(NullPointerException npe) {
				lblTareadelSprintSelec = new JLabel("Tarea del Sprint Selecionada");				
			}
			
			try {
				lblTareadelBacklogSelec = new JLabel((table_STareasBacklog.getValueAt(table_STareasBacklog.getSelectedRow(), 0)).toString());	
			}
			catch(NullPointerException npe) {
				lblTareadelBacklogSelec = new JLabel("Tarea del Backlog Selecionada");				
			}
						
			lblSTareas = new JLabel("Tareas en Sprint -");
			lblSTareas.setFont(new Font("Tahoma", Font.PLAIN, 16));
			add(lblSTareas, "cell 5 20,alignx right,aligny center");
			
			//lblSprintSeleccionado = new JLabel("Sprint Seleccionado");
			lblSprintSeleccionado.setFont(new Font("Tahoma", Font.PLAIN, 16));
			add(lblSprintSeleccionado, "cell 6 20,alignx left,aligny center");

			
			lblTareasEnBacklog = new JLabel("Tareas en Backlog");
			lblTareasEnBacklog.setFont(new Font("Tahoma", Font.PLAIN, 16));
			add(lblTareasEnBacklog, "cell 8 20");
			
			
			
			btnSAgregarTarea = new JButton("  \u00AB  ");
			btnSAgregarTarea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (lblSprintSeleccionado.getText() != "Sprint Seleccionado" && lblTareadelBacklogSelec.getText() != "Tarea del Backlog Selecionada") {
						Sprint s = Proyecto.getInstance().getSprint(lblSprintSeleccionado.getText());
						Tarea t =  Proyecto.getInstance().getBlog().getTarea(lblTareadelBacklogSelec.getText());
						if(!s.getEstado().toString().equals("DONE")){
							Proyecto.getInstance().agregarTareasSprint(s.getClave(),  t.getId());
							table_STareasBacklog.setModel(new TareasTM(Proyecto.getInstance().getBlog().getLTareasP()));
							table_STareas.setModel(new TareasTM(s.getListaT()));
							lblTareadelBacklogSelec.setText("Tarea del Backlog Selecionada");
							lblTareadelSprintSelec.setText("Tarea del Sprint Selecionada");
						}
						else
							JOptionPane.showMessageDialog(null, "ERROR: El sprint esta finalizado");
					}
				}
			});
			btnSAgregarTarea.setFont(new Font("Tahoma", Font.PLAIN, 14));
			add(btnSAgregarTarea, "cell 7 22,growx,aligny center");

			
			btnSQuitaTarea = new JButton("  \u00BB  ");
			btnSQuitaTarea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (lblSprintSeleccionado.getText() != "Sprint Seleccionado" && lblTareadelSprintSelec.getText() != "Tarea del Sprint Selecionada") {
						Sprint s = Proyecto.getInstance().getSprint(lblSprintSeleccionado.getText());
						Tarea t = s.getTarea(lblTareadelSprintSelec.getText());
						if(!s.getEstado().toString().equals("DONE")){
							Proyecto.getInstance().bajaTareaSprint(s.getClave(), t.getId());
							table_STareasBacklog.setModel(new TareasTM(Proyecto.getInstance().getBlog().getLTareasP()));
							table_STareas.setModel(new TareasTM(s.getListaT()));
							lblTareadelBacklogSelec.setText("Tarea del Backlog Selecionada");
							lblTareadelSprintSelec.setText("Tarea del Sprint Selecionada");
						}
						else 
							JOptionPane.showMessageDialog(null, "ERROR: El sprint esta finalizado");
					}
				}
			});
			
			
			btnIniciar = new JButton("Inicia Sprint");
			btnIniciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						Proyecto.getInstance().cambiarEstadoSprint(table.getValueAt(table.getSelectedRow(), 0).toString(), "ENCURSO");
						table.setModel(new SprintsTM(Proyecto.getInstance().getLSprints()));
					} catch (SprintNoValido e) {
						JOptionPane.showMessageDialog(null, "Ya hay un Sprint en curso.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			add(btnIniciar, "cell 1 24 3 1,alignx center,aligny center");		
			btnSQuitaTarea.setFont(new Font("Tahoma", Font.PLAIN, 14));
			add(btnSQuitaTarea, "cell 7 24,growx,aligny center");
			
			btnIniciar = new JButton("Inicia Sprint");
			btnIniciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//try {
						Date dateI=dateChooser_Fini.getDate();
						Date dateF=dateChooser_Ffin.getDate();
						String fechaI=DateFormat.getDateInstance().format(dateI);
						String fechaF=DateFormat.getDateInstance().format(dateF);
						DateTimeFormatter dateForm=DateTimeFormatter.ofPattern("dd/MM/yyyy");
						Proyecto.getInstance().getSprint(table.getValueAt(table.getSelectedRow(), 0).toString()).comenzar(LocalDate.parse(fechaI, dateForm),LocalDate.parse(fechaF, dateForm));
						//Proyecto.getInstance().getSprint(table.getValueAt(table.getSelectedRow(), 0).toString()).comenzar(LocalDate.parse(dateChooser_Fini.getDateFormatString(), dateForm),LocalDate.parse(dateChooser_Ffin.getDateFormatString(), dateForm));
						//Proyecto.getInstance().cambiarEstadoSprint(table.getValueAt(table.getSelectedRow(), 0).toString(), "ENCURSO");
						table.setModel(new SprintsTM(Proyecto.getInstance().getLSprints()));
						
					/*} catch (SprintNoValido e) {
						JOptionPane.showMessageDialog(null, "Ya hay un Sprint en curso.", "Error", JOptionPane.ERROR_MESSAGE);
					}*/
						InterfazGrafica.getInstance().cargaDatosAdmin();
						InterfazGrafica.getInstance().abrirAdminSprints();
				}
			});
			add(btnIniciar, "cell 1 24 3 1,alignx center,aligny center");		


			
			
			
			
						
			scrollPane_STareas = new JScrollPane();
			add(scrollPane_STareas, "cell 5 21 2 9,grow");
			
			table_STareas = new JTable();
			table_STareas.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					lblTareadelSprintSelec.setText((table_STareas.getValueAt(table_STareas.getSelectedRow(), 0)).toString());
				}
			});
			scrollPane_STareas.setViewportView(table_STareas);
			
			scrollPane_STareasBacklog = new JScrollPane();
			add(scrollPane_STareasBacklog, "cell 8 21 1 9,grow");
			
			table_STareasBacklog = new JTable();
			table_STareasBacklog.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblTareadelBacklogSelec.setText((table_STareasBacklog.getValueAt(table_STareasBacklog.getSelectedRow(), 0)).toString());
				}
			});
			scrollPane_STareasBacklog.setViewportView(table_STareasBacklog);
			table_STareasBacklog.setModel(new TareasTM(Proyecto.getInstance().getBlog().getLTareasP()));
			
			
			

			scrollPane_Sprints=new JScrollPane();
			add(scrollPane_Sprints, "cell 5 2 4 17,grow");
			
			table = new JTable();
			scrollPane_Sprints.setViewportView(table);
			table.setModel(new SprintsTM(Proyecto.getInstance().getLSprints()));
			table.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
					String estado;
					
					lblSprintSeleccionado.setText((table.getValueAt(table.getSelectedRow(), 0)).toString());
					lblTareadelSprintSelec.setText("Tarea del Sprint Selecionada");
					lblTareadelBacklogSelec.setText("Tarea del Backlog Selecionada");
					table_STareas.setModel(new TareasTM(Proyecto.getInstance().getSprint(table.getValueAt(table.getSelectedRow(), 0).toString()).getListaT()));
					txtSID.setText(Proyecto.getInstance().getSprint(table.getValueAt(table.getSelectedRow(), 0).toString()).getClave());
					txtSNombre.setText(Proyecto.getInstance().getSprint(table.getValueAt(table.getSelectedRow(), 0).toString()).getDescripcion());
					estado = Proyecto.getInstance().getSprint(table.getValueAt(table.getSelectedRow(), 0).toString()).getEstado().toString();
					
					if (estado == "PLANIFICADO") {
						rdbtnPlanificado.setSelected(true);
						rdbtnEnCurso.setSelected(false);
						rdbtnFinalizado.setSelected(false);
						}
					else {
						if (estado == "ENCURSO") {
							rdbtnPlanificado.setSelected(false);
							rdbtnEnCurso.setSelected(true);
							rdbtnFinalizado.setSelected(false);
						}
						else {
							rdbtnPlanificado.setSelected(false);
							rdbtnEnCurso.setSelected(false);
							rdbtnFinalizado.setSelected(true);
						}
					}
				};

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				};

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				});

			
			
			
			
			btnSAgregar = new JButton("Agregar");
			btnSAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Proyecto.getInstance().altaSprint(txtSID.getText(), txtSNombre.getText());
					table.setModel(new SprintsTM(Proyecto.getInstance().getLSprints()));
					JOptionPane.showMessageDialog(null, "Sprint agregado con exito.");
					//Proyecto.getInstance().corrersp();
				}
			});

			
			//lblTareadelSprintSelec = new JLabel("Tarea del Sprint Selecionada");
			lblTareadelSprintSelec.setFont(new Font("Tahoma", Font.BOLD, 12));
			add(lblTareadelSprintSelec, "cell 2 27,alignx center");
			lblTareadelSprintSelec.setVisible(false);
			

			
			//lblTareadelBacklogSelec = new JLabel("Tarea del Backlog Selecionada");
			lblTareadelBacklogSelec.setFont(new Font("Tahoma", Font.BOLD, 12));		
			add(lblTareadelBacklogSelec, "cell 2 28,alignx center");
			lblTareadelBacklogSelec.setVisible(false);
			
			add(btnSAgregar, "cell 1 29,alignx center,aligny bottom");
			
			btnSModificar = new JButton("Modificar");
			btnSModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Proyecto.getInstance().getSprint(table.getValueAt(table.getSelectedRow(), 0).toString()).actualizar(txtSID.getText(), txtSNombre.getText()); 
					//Proyecto.getInstance().modificacionSprint(txtSID.getText(), txtSNombre.getText());
					table.setModel(new SprintsTM(Proyecto.getInstance().getLSprints()));
					JOptionPane.showMessageDialog(null, "Sprint modificado con exito.");
				}
			});
			add(btnSModificar, "cell 2 29,alignx center,aligny bottom");
			
			btnSEliminar = new JButton("Eliminar");
			btnSEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try{
						Proyecto.getInstance().bajaSprint(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
						}
						catch(ArrayIndexOutOfBoundsException e1){
							JOptionPane.showMessageDialog(null, "Debe existir seleccionar un Sprint a eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
						} catch (SprintNoValido snv) {
							JOptionPane.showMessageDialog(null, "No se pueden eliminar los Sprints EN CURSO o FINALIZADO.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						table.setModel(new SprintsTM(Proyecto.getInstance().getLSprints()));
				
				}
			});
			add(btnSEliminar, "cell 3 29,alignx center,aligny bottom");	
	}
}

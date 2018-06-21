package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTable;
import javax.swing.JTextField;

import backLogs.Backlog;
import clases.Proyecto;
import clases.Sprint;
import clases.TareaNoValida;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import tareas.EstadoTarea;
import tareas.Tarea;

import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ABMTareas extends JPanel {
	private JMenuBar tmenuBar;	
		private JMenuItem mntmTAdmSprints;
		private JMenuItem mntmTSprints;	
		private JMenuItem mntmTTareas;
		private JMenuItem mntmTBacklog;
		private JMenuItem mntmTHistorico;
		private JMenuItem mntmTReportes;
		
	private JLabel lblTarea;
	private JSeparator separatorTarea;
	private JLabel lblTId;
	private JTextField txtTNombre;
	private JLabel lblTnomb;
	private JTextField txtTID;
	private JLabel lblSTipo;
	private JComboBox<String> comboBoxTTipo;
	private JLabel lblTDescripcion;
	private JTextField txtTDescp;
	private JLabel lblTComplejidad;
	private JSpinner spinnerTComp;
	private JLabel lblTEstado;
	private JComboBox<String> comboBoxTEstado;
	private JScrollPane scrollPane_Tareas;
	private JButton btnTSubtareas;
	private JButton btnTDependencias;
	
	private JButton btnTAgregar;
	private JButton btnTModificar;
	private JButton btnTEliminar;
	
	private JLabel lblTSubtareasDependenciasFlujos;			
	private JScrollPane scrollPane_TSD;
	private JTable table_TSD;
	private JButton btnTAgregarSD;
	private JButton btnTQuitarSD;
	private JScrollPane scrollPane_TD;
	private JTable table_TD;
	private JLabel lblTareasDisponibles;
	private JTable table_Tareas;
	
	char modo = 'd';
	private JLabel lblPasos;
	private JSpinner spinner_FPasos;
	private JLabel lblFlujo;
	private JTextField textField_Flujo;
	private JButton btnFAgregar;
	private JButton btnFCancelar;
	private JButton btnFlujopasos;
	

	/**
	 * Create the panel.
	 */
	public ABMTareas() {
		
		setLayout(new MigLayout("", "[50][53.00][5][53,grow][5][70.00][131.00][603.00,grow][][603.00,grow]", "[24px:24px][10.00][][15.00][][][15][][15][][15][][15][138.00,grow][15][][3.00][48.00][19.00][][9.00][pref!][43.00][139.00,grow][55.00][]"));
		
		tmenuBar = new JMenuBar();
		tmenuBar.setMargin(new Insets(0, 15, 0, 15));
			mntmTAdmSprints = new JMenuItem("Administración");
			mntmTAdmSprints.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirAdminSprints();}});
			tmenuBar.add(mntmTAdmSprints);
			mntmTSprints = new JMenuItem("Sprints");
			mntmTSprints.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirABMSprint();}});
			tmenuBar.add(mntmTSprints);
			mntmTTareas = new JMenuItem("Tareas");
			mntmTTareas.setSelected(true);
			mntmTTareas.setBackground(Color.LIGHT_GRAY);
			mntmTTareas.setFont(new Font("Segoe UI", Font.BOLD, 13));
			tmenuBar.add(mntmTTareas);
			mntmTBacklog = new JMenuItem("Backlog");
			mntmTBacklog.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirBacklog();}});
			tmenuBar.add(mntmTBacklog);
			mntmTHistorico = new JMenuItem("Historico");
			mntmTHistorico.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirHistorico();}});
			tmenuBar.add(mntmTHistorico);
			mntmTReportes = new JMenuItem("Reportes");
			mntmTReportes.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					InterfazGrafica.getInstance().abrirReportes();}});
			tmenuBar.add(mntmTReportes);
		add(tmenuBar, "cell 0 0 10 1,growx,aligny top");
		
		
			
			lblTarea = new JLabel("Tarea");
			lblTarea.setFont(new Font("Tahoma", Font.BOLD, 24));
			add(lblTarea, "cell 1 2 4 1,alignx left,aligny bottom");
			
			scrollPane_Tareas = new JScrollPane();
			add(scrollPane_Tareas, "cell 7 2 3 12,grow");
			
			table_Tareas = new JTable();
			scrollPane_Tareas.setViewportView(table_Tareas);
			table_Tareas.setModel(new TareasTM(Proyecto.getInstance().tareasBacklogYSprints()));
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
					String tarea = table_Tareas.getValueAt(table_Tareas.getSelectedRow(), 0).toString().substring(0, 3);
					switch (tarea) {
					case "TAR":
						txtTID.setText("TAR");
						lblTSubtareasDependenciasFlujos.setText("Sub Tareas");
						btnFlujopasos.setVisible(false);
						lblPasos.setVisible(false);
						spinner_FPasos.setVisible(false);
						lblFlujo.setVisible(false);
						textField_Flujo.setVisible(false);
						btnFCancelar.setVisible(false);
						btnFAgregar.setVisible(false);
						btnTSubtareas.setEnabled(true);
					case "BUG":
						txtTID.setText("BUG");
						lblTSubtareasDependenciasFlujos.setText("Sub Tareas");
						btnFlujopasos.setVisible(false);
						lblPasos.setVisible(false);
						spinner_FPasos.setVisible(false);
						lblFlujo.setVisible(false);
						textField_Flujo.setVisible(false);
						btnFCancelar.setVisible(false);
						btnFAgregar.setVisible(false);
						btnTSubtareas.setEnabled(false);
						btnTDependencias.doClick();
					break;
					case "HIS":
						txtTID.setText("HIS");
						lblTSubtareasDependenciasFlujos.setText("Flujo-Pasos");
						btnFlujopasos.setVisible(true);
						lblPasos.setVisible(true);
						spinner_FPasos.setVisible(true);
						lblFlujo.setVisible(true);
						textField_Flujo.setVisible(true);
						btnFCancelar.setVisible(true);
						btnFAgregar.setVisible(true);
						btnTSubtareas.setEnabled(true);
						break;
					case "MEJ":
						txtTID.setText("MEJ");
						lblTSubtareasDependenciasFlujos.setText("Sub Tareas");
						btnFlujopasos.setVisible(false);
						lblPasos.setVisible(false);
						spinner_FPasos.setVisible(false);
						lblFlujo.setVisible(false);
						textField_Flujo.setVisible(false);
						btnFCancelar.setVisible(false);
						btnFAgregar.setVisible(false);
						btnTSubtareas.setEnabled(true);
					}
				}
		});
			
			separatorTarea = new JSeparator();
			separatorTarea.setForeground(Color.BLACK);
			add(separatorTarea, "cell 1 3 5 1,growx,aligny center");
			
			lblSTipo = new JLabel("Tipo:");
			add(lblSTipo, "cell 1 5,alignx center,aligny center");
			
			comboBoxTTipo = new JComboBox();

			comboBoxTTipo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					switch (comboBoxTTipo.getSelectedItem().toString()) {
					case "Tarea":
						txtTID.setText("TAR");
						lblTSubtareasDependenciasFlujos.setText("Sub Tareas");
						btnFlujopasos.setVisible(false);
						lblPasos.setVisible(false);
						spinner_FPasos.setVisible(false);
						lblFlujo.setVisible(false);
						textField_Flujo.setVisible(false);
						btnFCancelar.setVisible(false);
						btnFAgregar.setVisible(false);
						break;
					case "Bug":
						txtTID.setText("BUG");
						lblTSubtareasDependenciasFlujos.setText("Sub Tareas");
						btnFlujopasos.setVisible(false);
						lblPasos.setVisible(false);
						spinner_FPasos.setVisible(false);
						lblFlujo.setVisible(false);
						textField_Flujo.setVisible(false);
						btnFCancelar.setVisible(false);
						btnFAgregar.setVisible(false);
						break;
					case "Historia":
						txtTID.setText("HIS");
						lblTSubtareasDependenciasFlujos.setText("Flujo-Pasos");
						btnFlujopasos.setVisible(true);
						lblPasos.setVisible(true);
						spinner_FPasos.setVisible(true);
						lblFlujo.setVisible(true);
						textField_Flujo.setVisible(true);
						btnFCancelar.setVisible(true);
						btnFAgregar.setVisible(true);
						break;
					case "Mejora":
						txtTID.setText("MEJ");
						lblTSubtareasDependenciasFlujos.setText("Sub Tareas");
						btnFlujopasos.setVisible(false);
						lblPasos.setVisible(false);
						spinner_FPasos.setVisible(false);
						lblFlujo.setVisible(false);
						textField_Flujo.setVisible(false);
						btnFCancelar.setVisible(false);
						btnFAgregar.setVisible(false);
					}
				}
			});
			comboBoxTTipo.setModel(new DefaultComboBoxModel(new String[] {"Tarea", "Bug", "Historia", "Mejora"}));
			add(comboBoxTTipo, "cell 3 5 3 1,growx");
			
			lblTId = new JLabel("ID:");
			add(lblTId, "cell 1 7,alignx center,aligny center");
			
			txtTID = new JTextField();
			add(txtTID, "cell 3 7 3 1,growx");
			txtTID.setColumns(10);
			
			lblTnomb = new JLabel("Nombre:");
			add(lblTnomb, "cell 1 9,alignx center");
			
			txtTNombre = new JTextField();
			add(txtTNombre, "cell 3 9 3 1,growx");
			txtTNombre.setColumns(10);
			
			lblTEstado = new JLabel("Estado:");
			add(lblTEstado, "cell 1 11,alignx center");
			
			comboBoxTEstado = new JComboBox();
			comboBoxTEstado.setModel(new DefaultComboBoxModel(new String[] {"", "ToDo", "InProgress", "PendingToBuild", "ReadyToTest", "Testing", "Done"}));
			add(comboBoxTEstado, "cell 3 11 3 1,growx");
			
			lblTDescripcion = new JLabel("Descripcion: ");
			add(lblTDescripcion, "cell 1 13,alignx center,aligny top");
			
			txtTDescp = new JTextField();
			add(txtTDescp, "cell 3 13 3 1,grow");
			txtTDescp.setColumns(10);
			
			lblTComplejidad = new JLabel("Complejidad:");
			add(lblTComplejidad, "cell 1 15,alignx center");
			
			spinnerTComp = new JSpinner();
			spinnerTComp.setModel(new SpinnerNumberModel(0, 0, 10, 1));
			add(spinnerTComp, "cell 3 15 3 1,growx");
			
			lblTareasDisponibles = new JLabel("Tareas Disponibles");
			lblTareasDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 16));
			add(lblTareasDisponibles, "cell 9 15,alignx left");
			
			scrollPane_TD = new JScrollPane();
			add(scrollPane_TD, "cell 9 16 1 10,grow");
			
			JTable table_TD = new JTable();
			scrollPane_TD.setViewportView(table_TD);
			
			btnTSubtareas = new JButton("Sub Tareas");
			btnTSubtareas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					modo = 's';
					String id = table_Tareas.getValueAt(table_Tareas.getSelectedRow(), 0).toString();
					lblTSubtareasDependenciasFlujos.setText("Sub Tareas");
					table_TSD.setModel(new TareasTM(Proyecto.getInstance().getTareaBacklogYSprints(id).getListaSubtareas()));
					//table_TD.setModel(new TareasTM(Proyecto.getInstance().getBlog().getSubTareas(id)));
					table_TD.setModel(new TareasTM(Proyecto.getInstance().tareasBacklogYSprintsSinSubTareas(id)));
				}
			});
			add(btnTSubtareas, "cell 1 17 5 1,alignx center,aligny bottom");
			
			btnTDependencias = new JButton("Dependencias");
			btnTDependencias.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					modo = 'd';
					String id = table_Tareas.getValueAt(table_Tareas.getSelectedRow(), 0).toString();
					lblTSubtareasDependenciasFlujos.setText("Dependencias");
					table_TSD.setModel(new TareasTM(Proyecto.getInstance().getTareaBacklogYSprints(id).getLdependencias()));
					table_TD.setModel(new TareasTM(Proyecto.getInstance().tareasBacklogYSprintsSinDependencias(id)));
					}
			});
			add(btnTDependencias, "cell 1 19 5 1,alignx center,aligny center");
			
			
			btnTAgregar = new JButton("Agregar");
			btnTAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					txtTID.setEnabled(true);
					Proyecto.getInstance().getBlog().altaTarea(comboBoxTTipo.getSelectedItem().toString(),txtTID.getText(),txtTNombre.getText(),txtTDescp.getText(),EstadoTarea.DONE,null,(int)spinnerTComp.getValue());
					
					table_Tareas.setModel(new TareasTM(Proyecto.getInstance().getBlog().getLTareasP()));
				}
			});
			

			btnTAgregarSD = new JButton("\u00AB");
			btnTAgregarSD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String id = table_Tareas.getValueAt(table_Tareas.getSelectedRow(), 0).toString();
					
					if(modo == 'd'){
						Tarea tar = Proyecto.getInstance().getBlog().getTarea(id); 
						if(tar!=null)
							try {
								Proyecto.getInstance().agregarDependencias(id, table_TD.getValueAt(table_TD.getSelectedRow(), 0).toString());
							} catch (TareaNoValida e1) {
								JOptionPane.showMessageDialog(null, "No se puede realizar esta accion");
							}
						else{
							Sprint s = Proyecto.getInstance().getTareaEnSprint(id); 
							try {
								s.agregaDependencia(id,table_TD.getValueAt(table_TD.getSelectedRow(), 0).toString());
							} catch (TareaNoValida e1) {
								JOptionPane.showMessageDialog(null, "No se puede realizar esta accion");
							}
						}
						table_TSD.setModel(new TareasTM(Proyecto.getInstance().getTareaBacklogYSprints(id).getLdependencias()));
						table_Tareas.setModel(new TareasTM(Proyecto.getInstance().tareasBacklogYSprints()));
						table_TD.setModel(new TareasTM(Proyecto.getInstance().tareasBacklogYSprintsSinDependencias(id)));
						
					}
					else{ //SUBTAREA
						Tarea tar = Proyecto.getInstance().getBlog().getTarea(id); 
						if(tar!=null)
							try {
								Proyecto.getInstance().agregaSubT(id, table_TD.getValueAt(table_TD.getSelectedRow(), 0).toString());
							} catch (TareaNoValida e1) {
								JOptionPane.showMessageDialog(null, "Las subtareas solo pueden ser de tipo tarea y no tienen que tener complejidad");
							}
						else{
							Sprint s = Proyecto.getInstance().getTareaEnSprint(id); 
							try {
								s.agregaSubTarea(id,table_TD.getValueAt(table_TD.getSelectedRow(), 0).toString());
							} catch (TareaNoValida e1) {
								JOptionPane.showMessageDialog(null, "No se puede realizar esta accion");
							}
						}
						table_TSD.setModel(new TareasTM(Proyecto.getInstance().getTareaBacklogYSprints(id).getListaSubtareas()));
						table_Tareas.setModel(new TareasTM(Proyecto.getInstance().tareasBacklogYSprints()));
						table_TD.setModel(new TareasTM(Proyecto.getInstance().tareasBacklogYSprintsSinSubTareas(id)));
					}
				}
			});
			btnTAgregarSD.setFont(new Font("Tahoma", Font.PLAIN, 14));
			add(btnTAgregarSD, "cell 8 19,growx,aligny center");
			
			btnTQuitarSD = new JButton("\u00BB");
			btnTQuitarSD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				String id = table_Tareas.getValueAt(table_Tareas.getSelectedRow(), 0).toString();
						if(modo == 'd'){	
							Tarea tar = Proyecto.getInstance().getBlog().getTarea(id); 
							if(tar!=null)
								Proyecto.getInstance().getBlog().bajaDependencia(id, table_TSD.getValueAt(table_TSD.getSelectedRow(), 0).toString());
							else{
								Sprint s = Proyecto.getInstance().getTareaEnSprint(id); 
								s.bajaDependencia(id,table_TSD.getValueAt(table_TSD.getSelectedRow(), 0).toString()); 
							}
								
							//Proyecto.getInstance().eliminarDependencia(id, table_TSD.getValueAt(table_TSD.getSelectedRow(), 0).toString());
							//table_Tareas.setModel(new TareasTM(Proyecto.getInstance().tareasBacklogYSprints()));
							table_TD.setModel(new TareasTM(Proyecto.getInstance().tareasBacklogYSprintsSinDependencias(id)));
							table_TSD.setModel(new TareasTM(Proyecto.getInstance().getTareaBacklogYSprints(id).getLdependencias()));								
						}
						else{ //SUBTAREA
							Tarea tar = Proyecto.getInstance().getBlog().getTarea(id); 
							if(tar!=null)
								Proyecto.getInstance().getBlog().bajaSubTarea(id, table_TD.getValueAt(table_TD.getSelectedRow(), 0).toString());
							else{
								Sprint s = Proyecto.getInstance().getTareaEnSprint(id); 
								s.bajaSubTarea(id,table_TD.getValueAt(table_TD.getSelectedRow(), 0).toString());
							}
							//Proyecto.getInstance().eliminarSubT(id, table_TSD.getValueAt(table_TSD.getSelectedRow(), 0).toString());
							table_TD.setModel(new TareasTM(Proyecto.getInstance().getBlog().getSubTareas(id)));
							table_TSD.setModel(new TareasTM(Proyecto.getInstance().getBlog().getTarea(id).getListaSubtareas()));
							//table_Tareas.setModel(new TareasTM(Proyecto.getInstance().getBlog().getLTareasP()));
								
							}
						}
				});
						
			btnFlujopasos = new JButton("Flujo-Pasos");
			btnFlujopasos.setVisible(false);
			btnFlujopasos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblTSubtareasDependenciasFlujos.setText("Flujo-Pasos");
				}
				});
			add(btnFlujopasos, "cell 1 21 5 1,alignx center,aligny center");
			btnTQuitarSD.setFont(new Font("Tahoma", Font.PLAIN, 14));
			add(btnTQuitarSD, "cell 8 21,growx,aligny center");
			
			lblPasos = new JLabel("Pasos:");
			lblPasos.setVisible(false);
			add(lblPasos, "cell 1 22,alignx center,aligny center");
			
			spinner_FPasos = new JSpinner();
			spinner_FPasos.setVisible(false);
			add(spinner_FPasos, "cell 3 22,alignx center,aligny center");
			
			lblFlujo = new JLabel("Flujo:");
			lblFlujo.setVisible(false);
			add(lblFlujo, "flowx,cell 1 23,alignx center,aligny top");
			
			textField_Flujo = new JTextField();
			textField_Flujo.setColumns(10);
			textField_Flujo.setVisible(false);
			add(textField_Flujo, "cell 3 23 3 1,grow");
			
			btnFCancelar = new JButton("Cancelar");
			btnFCancelar.setVisible(false);
			add(btnFCancelar, "cell 1 24 3 1,alignx right,aligny center");
			
			btnFAgregar = new JButton("Agregar");
			btnFAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String id=table_Tareas.getValueAt(table_Tareas.getSelectedRow(), 0).toString();
					Proyecto.getInstance().agregarFlujoPaso(id,textField_Flujo.getText() ,(int) spinner_FPasos.getValue());
					table_TSD.setModel(new FlujoPasoTM(Proyecto.getInstance().getBlog().getTarea(table_Tareas.getValueAt(table_Tareas.getSelectedRow(), 0).toString()).getHashMap()));
					//System.out.println(Proyecto.getInstance().getBlog().getTarea(table_Tareas.getValueAt(table_Tareas.getSelectedRow(), 0).toString()).getHashMap());
					//System.out.println(id);
					//System.out.println(table_Tareas.getSelectedRow());
					//System.out.println(Proyecto.getInstance().getBlog().getTarea(table_Tareas.getValueAt(table_Tareas.getSelectedRow(), 0).toString()).getFlujoPasos());
				}
			});
			btnFAgregar.setVisible(false);
			add(btnFAgregar, "cell 5 24,alignx center,aligny center");
			add(btnTAgregar, "cell 1 25,aligny bottom");
			
			btnTModificar = new JButton("Modificar");
			btnTModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						Tarea tar = Proyecto.getInstance().getBlog().getTarea(table_Tareas.getValueAt(table_Tareas.getSelectedRow(), 0).toString());
						txtTID.setText(tar.getId());
						txtTNombre.setText(tar.getNombre());
						txtTDescp.setText(tar.getDescripcion());
						spinnerTComp.setValue(tar.getComplejidad()-1);
						
						txtTID.setEnabled(false);
						
						Proyecto.getInstance().getBlog().bajaTarea(tar.getId());
					}catch(ArrayIndexOutOfBoundsException ex){
						JOptionPane.showMessageDialog(null, "Debe seleccionarse una tarea a modificar.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			add(btnTModificar, "cell 3 25,aligny bottom");
		
			btnTEliminar = new JButton("Eliminar");
			btnTEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Proyecto.getInstance().bajaTareaBackLog(table_Tareas.getValueAt(table_Tareas.getSelectedRow(), 0).toString());
					table_Tareas.setModel(new TareasTM(Proyecto.getInstance().getBlog().getLTareasP()));
				}
			});
			add(btnTEliminar, "cell 5 25,aligny bottom");
			
			
			lblTSubtareasDependenciasFlujos = new JLabel("Dependencias");
			lblTSubtareasDependenciasFlujos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			add(lblTSubtareasDependenciasFlujos, "cell 7 15");
			
			scrollPane_TSD = new JScrollPane();
			add(scrollPane_TSD, "cell 7 16 1 10,grow");
			
			table_TSD = new JTable();
			scrollPane_TSD.setViewportView(table_TSD);


	}
}

package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.EmpleadoController;
import models.Empleado;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtSexo;
	private JTextField txtSalario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEmpleado frame = new FrmEmpleado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 300);
		contentPane = new JPanel();
		contentPane.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 28, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE");
		lblNewLabel_1.setBounds(40, 106, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("APELLIDO");
		lblNewLabel_2.setBounds(40, 81, 66, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("SEXO");
		lblNewLabel_3.setBounds(40, 156, 49, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("EDAD");
		lblNewLabel_4.setBounds(40, 131, 49, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("SALARIO");
		lblNewLabel_5.setBounds(40, 181, 49, 14);
		contentPane.add(lblNewLabel_5);
		
		txtId = new JTextField();
		txtId.setBounds(40, 25, 96, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(135, 78, 96, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(135, 103, 96, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(135, 128, 96, 20);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		
		txtSexo = new JTextField();
		txtSexo.setBounds(135, 153, 96, 20);
		contentPane.add(txtSexo);
		txtSexo.setColumns(10);
		
		txtSalario = new JTextField();
		txtSalario.setBounds(135, 178, 96, 20);
		contentPane.add(txtSalario);
		txtSalario.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnNewButton.setBounds(146, 24, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGrabar.setBounds(135, 209, 89, 23);
		contentPane.add(btnGrabar);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnNuevo.setBounds(247, 24, 89, 23);
		contentPane.add(btnNuevo);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtId.getText().equals("") && Integer.parseInt(txtId.getText())>0) {
					eliminar();
				}
			}
		});
		btnEliminar.setBounds(347, 24, 89, 23);
		contentPane.add(btnEliminar);
	}
	void buscar() {
		Empleado empleado = new EmpleadoController().readerEmpleado(Integer.parseInt(txtId.getText()) );
		if(empleado!=null) {
			txtApellido.setText(empleado.getApellido());
			txtNombre.setText(empleado.getNombre());
			txtEdad.setText(String.valueOf(empleado.getEdad()));
			txtSexo.setText(empleado.getSexo());
			txtSalario.setText(String.valueOf(empleado.getSalario()));
			
			
			
		}else {
			JOptionPane.showMessageDialog(this, "No se encontro empleado");
		}
	}
	void eliminar() {
		String respuesta =new EmpleadoController().deleteEmpleado(Integer.parseInt(txtId.getText()));
		JOptionPane.showMessageDialog(this, respuesta);
		limpiar();
	}
	void limpiar() {
		txtId.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtSalario.setText("");
		txtEdad.setText("");
	}
	public void guardar() {
		
		String respuesta ="";
		String apellido=txtApellido.getText();
		String nombre =txtNombre.getText();
		int edad = Integer.parseInt(txtEdad.getText());
		String sexo=txtSexo.getText();
		double salario=Double.parseDouble( txtSalario.getText());
		if(!txtId.getText().equals("") && Integer.parseInt(txtId.getText())>0) {
			respuesta=	new EmpleadoController().updateEmpleado(Integer.parseInt(txtId.getText()) , nombre, apellido);
		}else {
			respuesta=new EmpleadoController().createEmpleado(apellido,nombre,edad,sexo,salario);
			limpiar();
		}
		JOptionPane.showMessageDialog(this, respuesta);
		
	}
}

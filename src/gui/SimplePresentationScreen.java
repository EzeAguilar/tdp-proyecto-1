package gui;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import entities.Student;




@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel labelLu;
	
	private JLabel textoFecha;
	private JLabel labelFecha;
	private JLabel labelHora;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentaciÃ³n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		
		JLabel labelImagen = new JLabel("");
		labelImagen.setBounds(251, 21, 142, 90);
		tabInformation.add(labelImagen);
		
		ImageIcon image = new ImageIcon(studentData.getPathPhoto());
	    Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelImagen.getWidth(), labelImagen.getHeight(), Image.SCALE_DEFAULT));
	    labelImagen.setIcon(icon);
	    
		tabInformation.setLayout(null);
		
		Calendar fecha = new GregorianCalendar();
		String anho = Integer.toString(fecha.get(Calendar.YEAR));
		String mes = Integer.toString(fecha.get(Calendar.MONTH)+1);
		String dia = Integer.toString(fecha.get(Calendar.DATE));
		String fechaCompleta = anho+"/"+mes+"/"+dia;
		String minute = "";
		if (fecha.get(Calendar.MINUTE)<10) {
			minute = "0"+Integer.toString(fecha.get(Calendar.MINUTE));
		}
		else {
			minute = Integer.toString(fecha.get(Calendar.MINUTE));
		}
		String hora = Integer.toString(fecha.get(Calendar.HOUR_OF_DAY));
		String horaComp = hora+":"+minute;
		
		labelLu = new JLabel("LU");
		labelLu.setBounds(10, 11, 49, 14);
		tabInformation.add(labelLu);
		
		JLabel LabelApellido = new JLabel("Apellido");
		LabelApellido.setBounds(10, 46, 49, 14);
		tabInformation.add(LabelApellido);
		
		JLabel LabelNombre = new JLabel("Nombre");
		LabelNombre.setBounds(10, 85, 49, 14);
		tabInformation.add(LabelNombre);
		
		JLabel LabelMail = new JLabel("E-mail");
		LabelMail.setBounds(10, 119, 49, 14);
		tabInformation.add(LabelMail);
		
		JLabel LabelGit = new JLabel("Github");
		LabelGit.setBounds(10, 150, 67, 14);
		tabInformation.add(LabelGit);
		
		
		
		textoFecha = new JLabel("Esta ventana se genero el ");
		textoFecha.setFont(new Font("Tahoma", Font.PLAIN, 8));
		textoFecha.setBounds(234, 151, 113, 14);
		tabInformation.add(textoFecha);
		
		labelFecha = new JLabel(fechaCompleta);
		labelFecha.setFont(new Font("Tahoma", Font.PLAIN, 8));
		labelFecha.setBounds(331, 151, 49, 14);
		tabInformation.add(labelFecha);
		
		labelHora = new JLabel(horaComp);
		labelHora.setFont(new Font("Tahoma", Font.PLAIN, 8));
		labelHora.setBounds(393, 151, 49, 14);
		tabInformation.add(labelHora);
		contentPane.add(tabbedPane, BorderLayout.WEST);
		
		JLabel textoFecha2 = new JLabel("a las");
		textoFecha2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		textoFecha2.setBounds(374, 151, 24, 14);
		tabInformation.add(textoFecha2);
		
		JTextArea areaLU = new JTextArea(Integer.toString(studentData.getId()));
		areaLU.setBounds(89, 6, 130, 22);
		tabInformation.add(areaLU);
		
		JTextArea areaApellido = new JTextArea(studentData.getLastName());
		areaApellido.setBounds(89, 41, 130, 22);
		tabInformation.add(areaApellido);
		
		JTextArea areaNombre = new JTextArea(studentData.getFirstName());
		areaNombre.setBounds(89, 80, 130, 22);
		tabInformation.add(areaNombre);
		
		JTextArea areaMail = new JTextArea(studentData.getMail());
		areaMail.setBounds(52, 114, 172, 22);
		tabInformation.add(areaMail);
		
		JTextArea areaGit = new JTextArea(studentData.getGithubURL());
		areaGit.setBounds(52, 144, 172, 22);
		tabInformation.add(areaGit);
		
		
	}
}

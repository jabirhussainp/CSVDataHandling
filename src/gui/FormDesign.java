package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import filereading.FileReading;
import filereading.PersonData;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;

/**
 * @author jabirhussain
 *
 */
public class FormDesign extends JFrame {

	private JPanel contentPane;
	public JTable table;
	private JScrollPane scrollPane;
	
	public static String filepath="data/titanic.csv";
	FileReading methods= new FileReading();
	ArrayList<PersonData> list;
	
	String []title = {"ID","Name","Age","Sex","P.Class","Survived","Fare"};
	ArrayList<PersonData> curList = null;
	DefaultTableModel a= null;
	PersonData p = new PersonData();
	private JButton btnSort;
	private JButton btnMax;
	private JButton btnMin;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnMax1;
	private JButton btnMin1;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDesign frame = new FormDesign();
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
	public FormDesign() {
		
		a = new DefaultTableModel(title,0);
		list = methods.readData();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("CSV DataHandling");
		setBounds(100, 100, 1102, 548);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				removeAllTableRows();
				loadRowsToTable(list);
				
				ArrayList<PersonData> curlist = methods.readData();
				FormDesign fd = new FormDesign();
				fd.loadRowsToTable(curlist);
				
				File file = new File(filepath);


				BufferedReader br;
				
				try {
					br = new BufferedReader(new FileReader(file));
				
				//String[] title = {"ID","Name","Age","Sex","P.Class","Survived","Fare"};
				String firstLine = br.readLine().trim();
				String[] columsName =firstLine.split(",");
				
				DefaultTableModel model =(DefaultTableModel)table.getModel();
				model.setColumnIdentifiers(columsName);
				Object[] tableLines = br.lines().toArray();
				
				for(int i =1;i<tableLines.length;i++)
				{
				String line= tableLines[i].toString().trim();
				String[] dataRow =line.split(",");
				model.addRow(dataRow);
				
				}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				}
				
			
		});
		btnImport.setBounds(291, 24, 89, 23);
		contentPane.add(btnImport);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 59, 675, 406);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(210, 180, 140));
		String title = "Operations";
		panel.setBounds(719, 60, 377, 405);
		contentPane.add(panel);
		panel.setLayout(null);
		Border border = BorderFactory.createTitledBorder(title);
		panel.setBorder(border);
		getContentPane().add(panel);
		
		btnSort = new JButton("Sort");
		panel.add(btnSort);
		//Sorting
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table.setAutoCreateRowSorter(true);
			}
		});
		btnSort.setBounds(127, 21, 117, 29);
		panel.add(btnSort);
		
		//String[] items = {"Age","Fare"};
		//Action Listener for Maximum button
		btnMax = new JButton("Max");
		btnMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//curList= methods.removeRowsofTotal(curList);
				PersonData max= methods.getMax(list);
				if(max==null) {
					//FormDesign fd = new FormDesign();
					JOptionPane.showMessageDialog(contentPane, "No Result Found");
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, max.toString());
				}
			}
		});
		btnMax.setBounds(23, 140, 117, 29);
		
		panel.add(btnMax);
		
		btnMin = new JButton("Minimum");
		//ActionListener for Minimum
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PersonData min= methods.getMin(list);
				if(min==null) {
					JOptionPane.showMessageDialog(contentPane, "No Result Found");
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, min.toString());
				}
			}
		});
		btnMin.setBounds(152, 140, 117, 29);
		panel.add(btnMin);
		
		lblNewLabel = new JLabel("Click to Sort");
		lblNewLabel.setBounds(23, 26, 92, 16);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Find Max & Min of Age");
		lblNewLabel_1.setBounds(21, 112, 159, 16);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Find Max & Min of Fare");
		lblNewLabel_2.setBounds(23, 199, 157, 16);
		panel.add(lblNewLabel_2);
		
		btnMax1 = new JButton("Max");
		btnMax1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonData min= methods.getMaxFare(list);
				if(min==null) {
					JOptionPane.showMessageDialog(contentPane, "No Result Found");
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, min.toString());
				}
			}
				
				
			
		});
		btnMax1.setBounds(23, 227, 117, 29);
		panel.add(btnMax1);
		
		btnMin1 = new JButton("Minimum");
		btnMin1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonData min= methods.getMinFare(list);
				if(min==null) {
					JOptionPane.showMessageDialog(contentPane, "No Result Found");
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, min.toString());
				}
			}
			
		});
		btnMin1.setBounds(152, 227, 117, 29);
		panel.add(btnMin1);
	}
	
	
	
	protected void removeAllTableRows() {
		
		((DefaultTableModel)table.getModel()).setRowCount(0);
		
		table.revalidate();
	
}
	//Load arraylist to jtable
public void loadRowsToTable(ArrayList<PersonData> curlist) {
		
		
		curlist=list;
		for(int i=0;i<list.size();i++) {
			
			
			PersonData pd= list.get(i);
			String []row = new String[7];
			row[0] = pd.getId()+"";
			row[1] = pd.getName();
			row[2] = pd.getAge()+"";
			row[3] = pd.getSex();
			row[4] = pd.getPclass()+"";
			row[5] = pd.getSurvived()+"";
			row[6] = pd.getFare()+"";
			
			a.addRow(row);
}
}




	
}


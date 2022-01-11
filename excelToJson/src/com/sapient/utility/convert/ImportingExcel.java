package com.sapient.utility.convert;

import static com.sapient.utility.convert.Constants.*;

import java.awt.Cursor;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

/**
 * 
 * @author manbatra1
 * @version 1.1
 * @since 1.0
 */
@SuppressWarnings("serial")
public class ImportingExcel extends JFrame {

	/**
	 *  Initialization of UI elements
	 */
	private JPanel contentPane;
	private JTextField textFieldInput;
	private JTextField textFieldOutput;
	protected String excelPath;
	protected String excelPathOutput;
	protected JTextArea textFieldStatus;
	private JScrollPane jscrollPane;
	static long startTime;
	static double duration;
	
	
		
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
	//	Runtime.getRuntime().exec("java -Xmx=1024m");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ImportingExcel frame = new ImportingExcel();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e,
				              "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public ImportingExcel() {
		
		
		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImportTheExcel = new JLabel(IMPORT_LABEL);
		lblImportTheExcel.setBounds(265, 11, 100, 14);
		contentPane.add(lblImportTheExcel);
		
		textFieldInput = new JTextField();
		textFieldInput.setBounds(123, 58, 386, 20);
		contentPane.add(textFieldInput);
		textFieldInput.setColumns(10);
		textFieldInput.setEditable(false);
		jscrollPane = new JScrollPane();
		jscrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		jscrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jscrollPane.setBounds(7, 188, 576, 108);
		contentPane.add(jscrollPane);
		
		textFieldStatus = new JTextArea();
		textFieldStatus.setWrapStyleWord(true);
		jscrollPane.setViewportView(textFieldStatus);
		
		
		 
		//InputFile Button for selecting the excel
		JButton btnBrowseInput = new JButton(INPUT_BUTTON);
		btnBrowseInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				JFileChooser selectInputFile = new JFileChooser();
				selectInputFile.setDialogTitle(INPUT_FILE_DIALOG_TITLE);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("XLS files", "xls","xlsx");
				selectInputFile.setFileFilter(filter);
				int result = selectInputFile.showOpenDialog(null);
				if(result != JFileChooser.APPROVE_OPTION || !(selectInputFile.getSelectedFile().getName().endsWith(".xlsx") || selectInputFile.getSelectedFile().getName().endsWith(".xls"))) {
					
					    if(selectInputFile.getSelectedFile() != null) {  
					    	
					      JOptionPane.showMessageDialog(null, "The file "
					              + selectInputFile.getSelectedFile() + " is not an Excel file.",
					              FILE_OPEN_ERROR , JOptionPane.ERROR_MESSAGE);
					      
					    }         
				}
				else if(result == JFileChooser.APPROVE_OPTION && (selectInputFile.getSelectedFile().getName().endsWith(".xlsx") || selectInputFile.getSelectedFile().getName().endsWith(".xls")) ) {
			
					excelPath = selectInputFile.getSelectedFile().getAbsolutePath();	
					textFieldInput.setText(excelPath);
					
				}
			}
		});
					
		btnBrowseInput.setBounds(519, 57, 89, 23);
		contentPane.add(btnBrowseInput);
			
		
		//Output file button for settting the output JSON path
		JButton btnBrowseOutput = new JButton(OUTPUT_BUTTON);
		btnBrowseOutput.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
						
						JFileChooser selectOutputFile = new JFileChooser();
						selectOutputFile.setCurrentDirectory(new java.io.File("."));
						selectOutputFile.setDialogTitle(OUTPUT_FILE_DIALOG_TITLE);
						selectOutputFile.setAcceptAllFileFilterUsed(false);
						selectOutputFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
									            
						int result = selectOutputFile.showOpenDialog(null);
						if(result == JFileChooser.APPROVE_OPTION) {
							
							selectOutputFile.setCurrentDirectory(selectOutputFile.getSelectedFile());
							selectOutputFile.setSelectedFile(new File(selectOutputFile.getCurrentDirectory() + OUTPUT_FILE_NAME));						
							excelPathOutput = selectOutputFile.getSelectedFile().getAbsolutePath();
							textFieldOutput.setText(excelPathOutput);
						
						}
					}
				});
		
				btnBrowseOutput.setBounds(519, 91, 89, 23);
				contentPane.add(btnBrowseOutput);	
		
				
		//Call the convert function on Submit
		JButton btnSubmit = new JButton(SUBMIT_BUTTON);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(excelPath!=null && excelPathOutput!=null) {
					startTime = System.currentTimeMillis();
					btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					ConvertJson.importExcel(excelPath, excelPathOutput, textFieldStatus);
					duration = (System.currentTimeMillis() - startTime)/1000D;
					System.out.println("duration = " + duration);
					btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					
				}
				else {
					
					if(excelPath == null && excelPathOutput != null)
					JOptionPane.showMessageDialog(null, INPUT_FILE_MESSAGE,
							NO_FILE_SELECTED_ERROR, JOptionPane.ERROR_MESSAGE);
					else if(excelPathOutput == null && excelPath != null){
						JOptionPane.showMessageDialog(null, OUTPUT_FILE_MESSAGE,
								NO_FILE_SELECTED_ERROR, JOptionPane.ERROR_MESSAGE);
					}
					else if(excelPath == null && excelPathOutput == null) {
						JOptionPane.showMessageDialog(null, NO_FILE_SELECTED_MESSAGE,
								NO_FILE_SELECTED_ERROR, JOptionPane.ERROR_MESSAGE);
					}
				}
				
				
			}
		});
				
		btnSubmit.setBounds(276, 129, 89, 23);
		contentPane.add(btnSubmit);
				
		
		//setting the labels
		JLabel lblInputFile = new JLabel(INPUT_FILE_LABEL);
		lblInputFile.setBounds(7, 58, 59, 20);
		contentPane.add(lblInputFile);
		
		JLabel lblOutputFile = new JLabel(OUTPUT_FILE_LABEL);
		lblOutputFile.setBounds(7, 95, 106, 14);
		contentPane.add(lblOutputFile);
		
		textFieldOutput = new JTextField();
		textFieldOutput.setBounds(123, 94, 386, 20);
		contentPane.add(textFieldOutput);
		textFieldOutput.setColumns(10);
		textFieldOutput.setEditable(false);
		
								
		JLabel lblStatus = new JLabel(STATUS_FILE_LABEL);
		lblStatus.setBounds(7, 168, 46, 14);
		contentPane.add(lblStatus);
		
		
	
	}
}

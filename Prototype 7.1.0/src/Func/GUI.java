package Func;

import java.util.ArrayList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;

public class GUI extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public  static String URLstring;
	public static int timeNum;
	public static String xpathString;
	public static String value;
	private JTextField input1Var;
	private JTextField input2Var;
	private JButton clickVar;
	private JButton waitVar;
	private JButton inputVar;
	private JLabel stepnumVar;
	private JButton minusVar;
	private JButton runVar;
	private JTextArea stepsdisplayVar;
		
	
	ArrayList<String> steps = new ArrayList<String>();
	ArrayList<String> input1arr = new ArrayList<String>();
	ArrayList<String> input2arr = new ArrayList<String>();
	
	public String input1Value;
	public String input2Value;
	int count=0;
	String countstr;
	int input1counter=0;
	int input2counter=0;
	String stepsdisplay="";
	private JButton btnstopVar;
	private JButton btnsaveVar;
	private JTextField savednameVar;
	
	Map<String,RunObj> myMap = new TreeMap<String,RunObj>();
	private JTextField fileinputVar;
	private JButton btnimportVar;
	private JScrollBar scrollbarVar;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	
	long start = 0;
	private JScrollPane scrollPane_1;
	private JButton btnexporttoexcelVar;
	private JButton btnimportfromexcelVar;
	private JTextField saveexcelnameVar;
	private JTextField savedexcelnameVar;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPanel panel;
	private JButton btnclearinputVar;
	private JButton btnscrollVar;
	private JButton btndoubleclickVar;
	private JButton btnscreenshotVar;
	private JButton btndropdownVar;
	private JPanel panel_1;
	private JLabel lblNewLabel_7;
	private JTextField ifinput1Var;
	private JLabel lblNewLabel_8;
	private JTextField ifinput2Var;
	private JLabel lblNewLabel_9;
	private JButton btnminusifVar;
	private JTextArea ifstepsVar;
	private JScrollPane scrollPane_3;
	private JLabel ifwarningVar;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btnifstartVar;
	private JButton btnifstopVar;
	private JScrollPane scrollPane_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setFont(new Font("Arial", Font.PLAIN, 12));
		setTitle("GUI Prototype 5.0.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 548);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		OpenURL OpenURLObject = new OpenURL();
		
		input1Var = new JTextField();
		input1Var.setText("input 1");
		input1Var.setBounds(514, 77, 88, 19);
		contentPane.add(input1Var);
		input1Var.setColumns(10);
		
		input2Var = new JTextField();
		input2Var.setText("input 2");
		input2Var.setBounds(514, 123, 88, 19);
		contentPane.add(input2Var);
		input2Var.setColumns(10);
	
		stepnumVar = new JLabel("   0");
		stepnumVar.setFont(new Font("Tahoma", Font.BOLD, 15));
		stepnumVar.setBounds(72, 81, 33, 32);
		contentPane.add(stepnumVar);
		
		minusVar = new JButton("-");
		
		minusVar.setFont(new Font("Arial", Font.PLAIN, 15));
		minusVar.setBounds(22, 88, 40, 21);
		contentPane.add(minusVar);
		
		runVar = new JButton("RUN");
		
		runVar.setBounds(10, 259, 76, 21);
		contentPane.add(runVar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 123, 268, 126);
		contentPane.add(scrollPane);
		
		stepsdisplayVar = new JTextArea();
		scrollPane.setViewportView(stepsdisplayVar);
		stepsdisplayVar.setText("STEPS ");
		
		JProgressBar progressbarVar = new JProgressBar();
		progressbarVar.setStringPainted(true);
		progressbarVar.setBounds(136, 46, 146, 11);
		progressbarVar.setValue(0);
		contentPane.add(progressbarVar);
		
		btnstopVar = new JButton("STOP");
		
		btnstopVar.setBounds(104, 259, 76, 21);
		contentPane.add(btnstopVar);
		
		fileinputVar = new JTextField();
		fileinputVar.setText("Enter file name to run");
		fileinputVar.setBounds(115, 308, 172, 19);
		contentPane.add(fileinputVar);
		fileinputVar.setColumns(10);
		
		btnimportVar = new JButton("Import");
		btnimportVar.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		btnimportVar.setBounds(20, 307, 85, 21);
		contentPane.add(btnimportVar);
		
		
		stepnumVar.setText("0");
		
		lblNewLabel = new JLabel("  COMPONENTS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(376, 38, 106, 21);
		contentPane.add(lblNewLabel);
		
		JLabel currentstepVar = new JLabel("             ...");
		currentstepVar.setBounds(199, 62, 102, 13);
		contentPane.add(currentstepVar);
		
		JLabel lblNewLabel_1 = new JLabel("Current step - ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(122, 64, 88, 11);
		contentPane.add(lblNewLabel_1);
		
		JButton btnclearVar = new JButton("CLEAR");
		
		btnclearVar.setBounds(203, 259, 85, 21);
		contentPane.add(btnclearVar);
		
		stepsdisplayVar.setText("STEPS : ");
		
		lblNewLabel_2 = new JLabel("Test Cases :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(10, 338, 83, 24);
		contentPane.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(279, 404, -245, 22);
		contentPane.add(textArea);
		Border screenborder = BorderFactory.createLineBorder(Color.BLACK);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 415, 268, 78);
		contentPane.add(scrollPane_1);
		
		JLabel timedisplayscreenVar = new JLabel("");
		scrollPane_1.setViewportView(timedisplayscreenVar);
		timedisplayscreenVar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		timedisplayscreenVar.setVerticalAlignment(SwingConstants.TOP);
		timedisplayscreenVar.setBackground(new Color(255, 255, 255));
		timedisplayscreenVar.setBorder(screenborder);
		
		JLabel lblNewLabel_3 = new JLabel("TIMER  LOG");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(20, 392, 73, 13);
		contentPane.add(lblNewLabel_3);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 255, 255));
		desktopPane.setBounds(436, 465, 139, -60);
		contentPane.add(desktopPane);
		
		
		JLabel addedfilesVar = new JLabel("No testcases added");
		addedfilesVar.setBounds(96, 341, 194, 19);
		contentPane.add(addedfilesVar);
		addedfilesVar.setFont(new Font("Tahoma", Font.ITALIC, 11));
		
		
		JLabel warningVar = new JLabel("");
		warningVar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		warningVar.setBounds(398, 234, 187, 19);
		contentPane.add(warningVar);
		
		lblNewLabel_4 = new JLabel("URL/XPATH/waittime");
		lblNewLabel_4.setBounds(514, 100, 131, 13);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Input 2 textfield");
		lblNewLabel_5.setBounds(514, 144, 88, 13);
		contentPane.add(lblNewLabel_5);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(655, 65, 229, 251);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnexistsVar = new JButton("Exists");
		btnexistsVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				steps.add("exists");
				input1Value = ifinput1Var.getText();
				input1arr.add(input1Value);
				input2Value = ifinput2Var.getText();
				input2arr.add(input2Value);
				
				String ifstepsdisplay = ifstepsVar.getText() + " -- Condition : Exists = "+input1Value+", for the xpath : " +input2Value;
				System.out.println(stepsdisplay);
				ifstepsVar.setText(ifstepsdisplay);
				
				ifinput1Var.setText("");
				ifinput2Var.setText("");
				
			}
		});
		btnexistsVar.setBounds(10, 43, 85, 21);
		panel_1.add(btnexistsVar);
		
		JButton btncontainsVar = new JButton("Contains");
		btncontainsVar.setBounds(10, 74, 85, 21);
		panel_1.add(btncontainsVar);
		
		JButton btnnotequalsVar = new JButton("Not Equals");
		btnnotequalsVar.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnnotequalsVar.setBounds(10, 105, 85, 21);
		panel_1.add(btnnotequalsVar);
		
		JButton btnstartswithVar = new JButton("Starts with");
		btnstartswithVar.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnstartswithVar.setBounds(10, 136, 85, 21);
		panel_1.add(btnstartswithVar);
		
		JButton btnendswithVar = new JButton("Ends With");
		btnendswithVar.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnendswithVar.setBounds(10, 167, 85, 21);
		panel_1.add(btnendswithVar);
		
		lblNewLabel_7 = new JLabel("CONDITIONS");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_7.setBounds(10, 10, 95, 23);
		panel_1.add(lblNewLabel_7);
		
		ifinput1Var = new JTextField();
		ifinput1Var.setBounds(105, 58, 114, 21);
		panel_1.add(ifinput1Var);
		ifinput1Var.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Input field 1");
		lblNewLabel_8.setBounds(131, 84, 72, 21);
		panel_1.add(lblNewLabel_8);
		
		ifinput2Var = new JTextField();
		ifinput2Var.setBounds(107, 125, 112, 19);
		panel_1.add(ifinput2Var);
		ifinput2Var.setColumns(10);
		
		lblNewLabel_9 = new JLabel("Input field 2");
		lblNewLabel_9.setBounds(131, 154, 72, 13);
		panel_1.add(lblNewLabel_9);
		
		btnminusifVar = new JButton("-");
		btnminusifVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ifstepsVar.setText("STEPS : ");
				String previousstep = steps.get(steps.size()-1);
				if(previousstep.equals("exists") || previousstep.equals("contains") || previousstep.equals("starts with") || previousstep.equals("ends with") || previousstep.equals("not equals")) {
					System.out.println("Entered the if minus condition successfully");
					steps.remove(steps.size()-1);
					input1arr.remove(input1arr.size()-1);
					input2arr.remove(input2arr.size()-1);
				}
				else {
					warningVar.setText("Warning: click the main minus button to clear further");
				}
				
			}
		});
		btnminusifVar.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnminusifVar.setBounds(115, 15, 37, 13);
		panel_1.add(btnminusifVar);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 200, 209, 41);
		panel_1.add(scrollPane_3);
		
		ifstepsVar = new JTextArea();
		scrollPane_3.setViewportView(ifstepsVar);
		ifstepsVar.setText("STEPS :");
		ifstepsVar.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Build your if condition block here");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_6.setBounds(683, 42, 204, 14);
		contentPane.add(lblNewLabel_6);
		
		ifwarningVar = new JLabel("");
		ifwarningVar.setFont(new Font("Tahoma", Font.ITALIC, 10));
		ifwarningVar.setBackground(new Color(255, 255, 255));
		ifwarningVar.setBounds(655, 324, 229, 24);
		contentPane.add(ifwarningVar);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(336, 407, 268, 72);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		btnexporttoexcelVar = new JButton("Export to excel");
		btnexporttoexcelVar.setBounds(10, 10, 116, 19);
		panel_2.add(btnexporttoexcelVar);
		btnexporttoexcelVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String savedName = saveexcelnameVar.getText() + ".xlsx";
				saveexcelnameVar.setText("");
				String path = System.getProperty("user.dir");
				path = path + "\\excel\\" + savedName;
				
				System.out.println("The file path is = "+path);
				
				
				try   {  
					FileOutputStream fileOut = new FileOutputStream(path);  
					fileOut.close();  
					System.out.println("Excel file has been generated successfully.");  
				}   
				catch (Exception e2)   {  
					e2.printStackTrace();  
				}  
				
				System.out.println("A new file, " +savedName+ " has been made");
				
			
				 try (XSSFWorkbook workbook = new XSSFWorkbook()) {
					XSSFSheet sheet = workbook.createSheet("Test Case");
					
					Row row0 = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(0);
					Cell cell0 = row0.createCell(0);
					cell0.setCellValue("STEPS");
					 
					Cell cell1 = row0.createCell(1);
					cell1.setCellValue("XPATHS");
					
					Cell cell2 = row0.createCell(2);
					cell2.setCellValue("INPUT");
					
					for(int i=0; i<steps.size(); i++) {
							Row row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(i+1);
							Cell cell = row.createCell(0);
							cell.setCellValue(steps.get(i));
							
					}
						
					for(int j=0; j<input1arr.size(); j++) {
							Row row = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(j+1);
							Cell cell = row.createCell(1);
							cell.setCellValue(input1arr.get(j));
							
					}
						
					for(int k=0; k<input2arr.size(); k++) {
							Row row = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(k+1);
							Cell cell = row.createCell(2);
							cell.setCellValue(input2arr.get(k));
							
					}
					
					 
					  try {
						  
					        FileOutputStream out = new FileOutputStream(new File(path));
					        workbook.write(out);
					        out.close();
					        System.out.println("Data written successfully on disk.");
					    }
  
					    catch (Exception e1) {
					        e1.printStackTrace();
					    }
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		
		btnexporttoexcelVar.setFont(new Font("Tahoma", Font.BOLD, 9));
		
		saveexcelnameVar = new JTextField();
		saveexcelnameVar.setBounds(136, 10, 122, 19);
		panel_2.add(saveexcelnameVar);
		saveexcelnameVar.setText("Enter file name");
		saveexcelnameVar.setColumns(10);
		
		
		btnimportfromexcelVar = new JButton("Import from excel");
		btnimportfromexcelVar.setBounds(10, 41, 116, 21);
		panel_2.add(btnimportfromexcelVar);
		btnimportfromexcelVar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				String fileName = savedexcelnameVar.getText() + ".xlsx";
				savedexcelnameVar.setText("");
				String path = System.getProperty("user.dir");
				path = path + "\\excel\\" + fileName;
				System.out.println("The file path is = "+path);
				
				try  {  
					File file = new File(path);   
					FileInputStream fis = new FileInputStream(file);    
					try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
						XSSFSheet sheet = wb.getSheet("Test Case");
					
						System.out.println("Workbook has been obtained and sheet has been obtained");
						int i = 1;
						Boolean exit = false;
						//!((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(i).getCell(0).getStringCellValue().equals("")
						//(((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(i).getCell(0)) != null
						Row rowcheck2 = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(i);
						if(rowcheck2 == null) {
							exit = true;
						}
						while(exit == false) {
							Row row1 = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(i);
							Cell cell1 = row1.getCell(0);
							String step = cell1.getStringCellValue();
							System.out.println(step);
							steps.add(step);
							i += 1;
							Row rowcheck = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(i);
							if(rowcheck == null) {
								exit = true;
							}
						}
						
						System.out.println("Exited out of the steps loop");
						exit = false;
						int j = 1;
						Row rowcheck1 = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(j);
						if(rowcheck1 == null) {
							exit = true;
						}
						else if(rowcheck1.getCell(1) == null) {
							exit = true;
						}
						//!(((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(i).getCell(0)).equals("")
						while(exit == false) {
							Row row1 = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(j);
							Cell cell1 = row1.getCell(1);
							String input1 = cell1.getStringCellValue();
							System.out.println(input1);
							input1arr.add(input1);
							j += 1;
							Row rowcheck = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(j);
							if(rowcheck == null) {
								exit = true;
							}
							else if(rowcheck.getCell(1) == null) {
								exit = true;
							}
						}
						
						exit = false;
						int k = 1;
						//!(((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(i).getCell(0)).equals("")
						Row rowcheck0 = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(k);
						if(rowcheck0 == null) {
							exit = true;
							System.out.println(exit);
						}
						else if(rowcheck0.getCell(2) == null) {
							exit = true;
						}
						
						while(exit == false) {
							Row row1 = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(k);
							Cell cell1 = row1.getCell(2);
							String input2 = cell1.getStringCellValue();
							System.out.println(input2);
							input2arr.add(input2);
							k += 1;
							Row rowcheck = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(k);
							if(rowcheck == null) {
								exit = true;
								System.out.println(exit);
							}
							else if(rowcheck.getCell(2) == null) {
								exit = true;
							}
						}
						//Boilerplate display code starts
							
							stepsdisplay = "STEPS - ";
							int count = 0;
							for(int m=0; m<steps.size(); m++) {
								stepsdisplay = stepsdisplay + steps.get(m) + " - ";
								count += 1;
								
							}
							System.out.println(count);
							String countstr = String.valueOf(steps.size());
							stepnumVar.setText(countstr);
							int ind = stepsdisplay.lastIndexOf("-");
							String stepsdisplayfinal = stepsdisplay.substring(0, ind);
							stepsdisplayVar.setText(stepsdisplayfinal);
							
							System.out.println("");
							System.out.println("Current steps array after importing = " +steps);
							System.out.println("Current input1arr array after importing = " +input1arr);
							System.out.println("Current input2arr array after importing = " +input2arr);
							
							String fileName2 = fileinputVar.getText();
							fileinputVar.setText("");
							if((addedfilesVar.getText()).equals("No testcases added")) {
								addedfilesVar.setText("");
							}
							String filedisplay = addedfilesVar.getText() + fileName2 + ", ";
							addedfilesVar.setText(filedisplay);
						//Boilerplate display code ends
					}  

				}
				
				catch(Exception e3)  {  
					e3.printStackTrace();  
				} 
				System.out.println("Size of steps array = "+steps.size());
				System.out.println("Size of input1arr array = "+input1arr.size());
				System.out.println("Size of input2arr array = "+input2arr.size());
			}
		});
		
		
		btnimportfromexcelVar.setFont(new Font("Tahoma", Font.BOLD, 8));
		
		savedexcelnameVar = new JTextField();
		savedexcelnameVar.setBounds(136, 41, 122, 19);
		panel_2.add(savedexcelnameVar);
		savedexcelnameVar.setText("Enter file name");
		savedexcelnameVar.setColumns(10);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(351, 277, 253, 39);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		btnsaveVar = new JButton("Save");
		btnsaveVar.setBounds(10, 10, 68, 21);
		panel_3.add(btnsaveVar);
		
		savednameVar = new JTextField();
		savednameVar.setBounds(88, 11, 155, 20);
		panel_3.add(savednameVar);
		savednameVar.setText("Enter save name");
		savednameVar.setColumns(10);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(376, 64, 112, 172);
		contentPane.add(scrollPane_2);
		
		panel = new JPanel();
		scrollPane_2.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{80, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		
		JButton openurlVar = new JButton("Open URL");
		GridBagConstraints gbc_openurlVar = new GridBagConstraints();
		gbc_openurlVar.anchor = GridBagConstraints.SOUTH;
		gbc_openurlVar.fill = GridBagConstraints.HORIZONTAL;
		gbc_openurlVar.insets = new Insets(0, 0, 5, 0);
		gbc_openurlVar.gridx = 0;
		gbc_openurlVar.gridy = 0;
		panel.add(openurlVar, gbc_openurlVar);
		openurlVar.setFont(new Font("Tahoma", Font.BOLD, 9));
		
		openurlVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(input1Var.getText().equals("input 1") || input1Var.getText().equals("")) {
					warningVar.setText("Warning: URL field not entered");
				}
				else {
				
				steps.add("openURL");
				input1Value = input1Var.getText();
				input1arr.add(input1Value);
				
				count = Integer.parseInt(stepnumVar.getText()) + 1;
				countstr =Integer.toString(count);
				stepnumVar.setText(countstr);
				
				stepsdisplay = stepsdisplayVar.getText() + " - OpenURL";
				System.out.println(stepsdisplay);
				stepsdisplayVar.setText(stepsdisplay);
				
				input1Var.setText("");
				
				warningVar.setText("Working fine Boss!");
				}
			}
		});
		
		
		clickVar = new JButton("Click");
		GridBagConstraints gbc_clickVar = new GridBagConstraints();
		gbc_clickVar.anchor = GridBagConstraints.SOUTH;
		gbc_clickVar.fill = GridBagConstraints.HORIZONTAL;
		gbc_clickVar.insets = new Insets(0, 0, 5, 0);
		gbc_clickVar.gridx = 0;
		gbc_clickVar.gridy = 1;
		panel.add(clickVar, gbc_clickVar);
		
		
		clickVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(input1Var.getText().equals("input 1") || input1Var.getText().equals("")) {
					warningVar.setText("Warning: xpath field not entered");
				}
				else {
				steps.add("click");
				input1Value = input1Var.getText();
				input1arr.add(input1Value);
				
				count = Integer.parseInt(stepnumVar.getText()) + 1;
				countstr =Integer.toString(count);
				stepnumVar.setText(countstr);
				
				stepsdisplay = stepsdisplayVar.getText() + " - click";
				stepsdisplayVar.setText(stepsdisplay);
				
				input1Var.setText("");
				
				warningVar.setText("Working fine Boss!");
				}
			}
		});
		
		waitVar = new JButton("Wait");
		GridBagConstraints gbc_waitVar = new GridBagConstraints();
		gbc_waitVar.anchor = GridBagConstraints.SOUTH;
		gbc_waitVar.fill = GridBagConstraints.HORIZONTAL;
		gbc_waitVar.insets = new Insets(0, 0, 5, 0);
		gbc_waitVar.gridx = 0;
		gbc_waitVar.gridy = 2;
		panel.add(waitVar, gbc_waitVar);
		
		
		waitVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(input1Var.getText().equals("input 1") || input1Var.getText().equals("")) {
					warningVar.setText("Warning: xpath field not entered");
				}
				else {
				steps.add("wait");
				input1Value = input1Var.getText();
				input1arr.add(input1Value);
				
				int count = Integer.parseInt(stepnumVar.getText()) + 1;
				countstr =Integer.toString(count);
				stepnumVar.setText(countstr);
				
				stepsdisplay = stepsdisplayVar.getText() + " - wait";
				stepsdisplayVar.setText(stepsdisplay);
				
				input1Var.setText("");
				
				warningVar.setText("Working fine Boss!");
				}
			}
				
		});
		
		inputVar = new JButton("Input");
		GridBagConstraints gbc_inputVar = new GridBagConstraints();
		gbc_inputVar.anchor = GridBagConstraints.SOUTH;
		gbc_inputVar.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputVar.insets = new Insets(0, 0, 5, 0);
		gbc_inputVar.gridx = 0;
		gbc_inputVar.gridy = 3;
		panel.add(inputVar, gbc_inputVar);
		
		
		inputVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(input1Var.getText().equals("input 1") || input1Var.getText().equals("")) {
					warningVar.setText("Warning: xpath field not entered");
				}
				else {
				steps.add("input");
				input1Value = input1Var.getText();
				input1arr.add(input1Value);
				input2Value = input2Var.getText();
				input2arr.add(input2Value);
				
				int count = Integer.parseInt(stepnumVar.getText()) + 1;
				countstr =Integer.toString(count);
				stepnumVar.setText(countstr);
				
				stepsdisplay = stepsdisplayVar.getText() + " - input";
				stepsdisplayVar.setText(stepsdisplay);
				
				input1Var.setText("");
				input2Var.setText("");
				
				warningVar.setText("Working fine Boss!");
				}
			}
		});
		
		
		JButton btnstarttimerVar = new JButton("Start timer");
		GridBagConstraints gbc_btnstarttimerVar = new GridBagConstraints();
		gbc_btnstarttimerVar.anchor = GridBagConstraints.SOUTH;
		gbc_btnstarttimerVar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnstarttimerVar.insets = new Insets(0, 0, 5, 0);
		gbc_btnstarttimerVar.gridx = 0;
		gbc_btnstarttimerVar.gridy = 4;
		panel.add(btnstarttimerVar, gbc_btnstarttimerVar);
		
		
		btnstarttimerVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				steps.add("startTime");
							
				count = Integer.parseInt(stepnumVar.getText()) + 1;
				countstr =Integer.toString(count);
				stepnumVar.setText(countstr);
				
				stepsdisplay = stepsdisplayVar.getText() + " - StartTime";
				System.out.println(stepsdisplay);
				stepsdisplayVar.setText(stepsdisplay);
				
				warningVar.setText("Working fine Boss!");
			
				
			}
		});
		
		btnstarttimerVar.setFont(new Font("Tahoma", Font.BOLD, 9));
		
		JButton btnstoptimerVar = new JButton("Stop timer");
		GridBagConstraints gbc_btnstoptimerVar = new GridBagConstraints();
		gbc_btnstoptimerVar.anchor = GridBagConstraints.SOUTH;
		gbc_btnstoptimerVar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnstoptimerVar.insets = new Insets(0, 0, 5, 0);
		gbc_btnstoptimerVar.gridx = 0;
		gbc_btnstoptimerVar.gridy = 5;
		panel.add(btnstoptimerVar, gbc_btnstoptimerVar);
		btnstoptimerVar.setVerticalAlignment(SwingConstants.TOP);
		
		
		btnstoptimerVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				steps.add("stopTime");
				
				count = Integer.parseInt(stepnumVar.getText()) + 1;
				countstr =Integer.toString(count);
				stepnumVar.setText(countstr);
				
				stepsdisplay = stepsdisplayVar.getText() + " - StopTime";
				System.out.println(stepsdisplay);
				stepsdisplayVar.setText(stepsdisplay);
				
				warningVar.setText("Working fine Boss!");
				
				
			}
		});
		
		btnstoptimerVar.setFont(new Font("Tahoma", Font.BOLD, 9));
		
		btnclearinputVar = new JButton("Clear Input");
		btnclearinputVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(input1Var.getText().equals("input 1") || input1Var.getText().equals("")) {
					warningVar.setText("Warning: xpath field not entered");
				}
				else {
				
				steps.add("clear_input");
				input1Value = input1Var.getText();
				input1arr.add(input1Value);
				
				int count = Integer.parseInt(stepnumVar.getText()) + 1;
				countstr =Integer.toString(count);
				stepnumVar.setText(countstr);
				
				stepsdisplay = stepsdisplayVar.getText() + " - clear_input";
				stepsdisplayVar.setText(stepsdisplay);
				
				input1Var.setText("");
				
				warningVar.setText("Working fine Boss!");
				}
				
			}
		});
		GridBagConstraints gbc_btnclearinputVar = new GridBagConstraints();
		gbc_btnclearinputVar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnclearinputVar.insets = new Insets(0, 0, 5, 0);
		gbc_btnclearinputVar.gridx = 0;
		gbc_btnclearinputVar.gridy = 6;
		panel.add(btnclearinputVar, gbc_btnclearinputVar);
		
		btnscrollVar = new JButton("Scroll");
		btnscrollVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(input1Var.getText().equals("input 1") || input1Var.getText().equals("")) {
					warningVar.setText("Warning: xpath field not entered");
				}
				else {
				
				steps.add("scroll");
				input1Value = input1Var.getText();
				input1arr.add(input1Value);
				
				int count = Integer.parseInt(stepnumVar.getText()) + 1;
				countstr =Integer.toString(count);
				stepnumVar.setText(countstr);
				
				stepsdisplay = stepsdisplayVar.getText() + " - scroll";
				stepsdisplayVar.setText(stepsdisplay);
				
				input1Var.setText("");
				
				warningVar.setText("Working fine Boss!");
				}
				
			}
		});
		GridBagConstraints gbc_btnscrollVar = new GridBagConstraints();
		gbc_btnscrollVar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnscrollVar.insets = new Insets(0, 0, 5, 0);
		gbc_btnscrollVar.gridx = 0;
		gbc_btnscrollVar.gridy = 7;
		panel.add(btnscrollVar, gbc_btnscrollVar);
		
		btndoubleclickVar = new JButton("Double click");
		btndoubleclickVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(input1Var.getText().equals("input 1") || input1Var.getText().equals("")) {
					warningVar.setText("Warning: xpath field not entered");
				}
				else {
								
				steps.add("doubleclick");
				input1Value = input1Var.getText();
				input1arr.add(input1Value);
				
				int count = Integer.parseInt(stepnumVar.getText()) + 1;
				countstr =Integer.toString(count);
				stepnumVar.setText(countstr);
				
				stepsdisplay = stepsdisplayVar.getText() + " - doubleclick";
				stepsdisplayVar.setText(stepsdisplay);
				
				input1Var.setText("");
				
				warningVar.setText("Working fine Boss!");
				}
				
				
			}
		});
		GridBagConstraints gbc_btndoubleclickVar = new GridBagConstraints();
		gbc_btndoubleclickVar.insets = new Insets(0, 0, 5, 0);
		gbc_btndoubleclickVar.gridx = 0;
		gbc_btndoubleclickVar.gridy = 8;
		panel.add(btndoubleclickVar, gbc_btndoubleclickVar);
		
		btnscreenshotVar = new JButton("Screenshot");
		GridBagConstraints gbc_btnscreenshotVar = new GridBagConstraints();
		gbc_btnscreenshotVar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnscreenshotVar.insets = new Insets(0, 0, 5, 0);
		gbc_btnscreenshotVar.gridx = 0;
		gbc_btnscreenshotVar.gridy = 9;
		panel.add(btnscreenshotVar, gbc_btnscreenshotVar);
		
		btndropdownVar = new JButton("Dropdown");
		GridBagConstraints gbc_btndropdownVar = new GridBagConstraints();
		gbc_btndropdownVar.insets = new Insets(0, 0, 5, 0);
		gbc_btndropdownVar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btndropdownVar.gridx = 0;
		gbc_btndropdownVar.gridy = 10;
		panel.add(btndropdownVar, gbc_btndropdownVar);
		
		btnifstartVar = new JButton("If start");
		GridBagConstraints gbc_btnifstartVar = new GridBagConstraints();
		gbc_btnifstartVar.insets = new Insets(0, 0, 5, 0);
		gbc_btnifstartVar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnifstartVar.gridx = 0;
		gbc_btnifstartVar.gridy = 11;
		panel.add(btnifstartVar, gbc_btnifstartVar);
		
		btnifstopVar = new JButton("If stop");
		GridBagConstraints gbc_btnifstopVar = new GridBagConstraints();
		gbc_btnifstopVar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnifstopVar.gridx = 0;
		gbc_btnifstopVar.gridy = 12;
		panel.add(btnifstopVar, gbc_btnifstopVar);
		
		JButton btnminustcVar = new JButton("-");
	
		btnminustcVar.setBounds(209, 89, 40, 21);
		contentPane.add(btnminustcVar);
		
		JLabel testcasenumVar = new JLabel("0");
		testcasenumVar.setFont(new Font("Tahoma", Font.BOLD, 15));
		testcasenumVar.setBounds(259, 81, 33, 32);
		contentPane.add(testcasenumVar);
		
		JLabel lblNewLabel_10 = new JLabel("Testcases");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_10.setBounds(158, 85, 52, 29);
		contentPane.add(lblNewLabel_10);
		btnifstopVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				steps.add("if stop");
				
				count = Integer.parseInt(stepnumVar.getText()) + 1;
				countstr =Integer.toString(count);
				stepnumVar.setText(countstr);
				
				stepsdisplay = stepsdisplayVar.getText() + " - If stop";
				System.out.println(stepsdisplay);
				stepsdisplayVar.setText(stepsdisplay);
				
				warningVar.setText("Working fine Boss!");
				
				ifstepsVar.setText("STEPS : ");
				
			}
		});
		btnifstartVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				steps.add("if start");
				
				count = Integer.parseInt(stepnumVar.getText()) + 1;
				countstr =Integer.toString(count);
				stepnumVar.setText(countstr);
				
				stepsdisplay = stepsdisplayVar.getText() + " - If start";
				System.out.println(stepsdisplay);
				stepsdisplayVar.setText(stepsdisplay);
				
				warningVar.setText("Working fine Boss!");
				
				
			}
		});
		
		
		
		
		btndropdownVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(input1Var.getText().equals("input 1") || input1Var.getText().equals("")) {
					warningVar.setText("Warning: xpath field not entered");
				}
				else {
				
				steps.add("dropdown");
				input1Value = input1Var.getText();
				input1arr.add(input1Value);
				input2Value = input2Var.getText();
				input2arr.add(input2Value);
				
				int count = Integer.parseInt(stepnumVar.getText()) + 1;
				countstr =Integer.toString(count);
				stepnumVar.setText(countstr);
				
				stepsdisplay = stepsdisplayVar.getText() + " - dropdown";
				stepsdisplayVar.setText(stepsdisplay);
				
				input1Var.setText("");
				input2Var.setText("");
				
				warningVar.setText("Working fine Boss!");
				}
				
				
			}
		});
		
		
		
		btnscreenshotVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				steps.add("screenshot");
				
				count = Integer.parseInt(stepnumVar.getText()) + 1;
				countstr =Integer.toString(count);
				stepnumVar.setText(countstr);
				
				stepsdisplay = stepsdisplayVar.getText() + " - screenshot";
				System.out.println(stepsdisplay);
				stepsdisplayVar.setText(stepsdisplay);
				
				warningVar.setText("Working fine Boss!");
					
				
			}
		});
		
		
		btnsaveVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String savedName = savednameVar.getText() + ".txt";
				savednameVar.setText("");
				String path = System.getProperty("user.dir");
				path = path + "\\saved tests\\" + savedName;
				
				myMap.put(savedName, new RunObj());
				RunObj currentRunObject = myMap.get(savedName);
				currentRunObject.steps = steps;
				currentRunObject.filename = savedName;
				currentRunObject.input1arr = input1arr;
				currentRunObject.input2arr = input2arr;
				
				 
				File file = new File(path);
				try {
					if (file.createNewFile()) {
					  System.out.println("File created: " + file.getName());
					 } 
					else {
					  
						System.out.println("File already exists.");
					  }
				} catch (IOException e2) {
					e2.printStackTrace();
				} 
				  
				 
				try {
					//File file = new File(savedName);
					FileOutputStream f = new FileOutputStream(file);
					ObjectOutputStream o = new ObjectOutputStream(f);

					// Write objects to file
					o.writeObject(currentRunObject);

					o.close();
					f.close();
					warningVar.setText("Working fine Boss!");
					
				} catch (FileNotFoundException e1) {
					System.out.println("File not found");
				} catch (IOException e1) {
					e1.printStackTrace();
					System.out.println("Error initializing stream");
				} 

				
			}
		});
		
		//
		
		minusVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String prevstep = steps.get(steps.size()-1);
				if(prevstep.equals("exists") || prevstep.equals("contains") || prevstep.equals("starts with") || prevstep.equals("ends with") || prevstep.equals("not equals")) {
					System.out.println("No can do-sville babydoll");
					warningVar.setText("Warning : click the minus in the if condition block");
				}
				else {
				int count = Integer.parseInt(stepnumVar.getText()) - 1;
				
				if(count == 0) {
					currentstepVar.setText("");
					addedfilesVar.setText("No testcases added");
					timedisplayscreenVar.setText("");
					
				}
				
				if(count >= 0) {
					String countstr = String.valueOf(count);
					stepnumVar.setText(countstr);
					
					System.out.println("The step about to be removed is = " +steps.get(steps.size()-1));
					String steptoberemoved = steps.get(steps.size()-1);
					if(steptoberemoved.equals("input")) {
						input2arr.remove(input2arr.size()-1);
						System.out.println("The current input2arr after removal of the previous steps is = " +input2arr);
										}
					else if(steptoberemoved.equals("dropdown")) {
						input2arr.remove(input2arr.size()-1);
						System.out.println("The current input2arr after removal of the previous steps is = " +input2arr);
					}
					
					if(steptoberemoved.equals("input")) {
						input1arr.remove(input1arr.size()-1);
						System.out.println("The current input1arr after removal of the previous steps is = " +input1arr);
					}
					else if(steptoberemoved.equals("click")){
						input1arr.remove(input1arr.size()-1);
						System.out.println("The current input1arr after removal of the previous steps is = " +input1arr);
					}
					else if(steptoberemoved.equals("wait")){
						input1arr.remove(input1arr.size()-1);
						System.out.println("The current input1arr after removal of the previous steps is = " +input1arr);
					}
					else if(steptoberemoved.equals("openURL")){
						input1arr.remove(input1arr.size()-1);
						System.out.println("The current input1arr after removal of the previous steps is = " +input1arr);
					}
					else if(steptoberemoved.equals("clear_input")){
						input1arr.remove(input1arr.size()-1);
						System.out.println("The current input1arr after removal of the previous steps is = " +input1arr);
					}
					else if(steptoberemoved.equals("scroll")){
						input1arr.remove(input1arr.size()-1);
						System.out.println("The current input1arr after removal of the previous steps is = " +input1arr);
					}
					else if(steptoberemoved.equals("doubleclick")){
						input1arr.remove(input1arr.size()-1);
						System.out.println("The current input1arr after removal of the previous steps is = " +input1arr);
					}
					else if(steptoberemoved.equals("dropdown")){
						input1arr.remove(input1arr.size()-1);
						System.out.println("The current input1arr after removal of the previous steps is = " +input1arr);
					}
					
					steps.remove(steps.size()-1);
					
					stepsdisplay = stepsdisplayVar.getText();
					System.out.println(stepsdisplay);
					int index = stepsdisplay.lastIndexOf("-");
					System.out.println(index);
					stepsdisplay = stepsdisplay.substring(0, index);
					System.out.println(stepsdisplay);
					stepsdisplayVar.setText(stepsdisplay);
					
					warningVar.setText("Working fine Boss!");
					
				}
				}
			}
		});

		
		runVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				timedisplayscreenVar.setText("");
				
				currentstepVar.setText("   ...   ");
				
				String step = "";
				progressbarVar.setValue(0);
				int stepsize = steps.size();
				int input1arraysize = input1arr.size();
				int input2arraysize = input2arr.size();
				System.out.println("At the start of run command, the size of the steps array = " +stepsize);
				System.out.println("At the start of run command, the size of the input1 array = " +input1arraysize);
				System.out.println("At the start of run command, the size of the steps array = " +input2arraysize);
				
				for(int i=0; i<stepsize; i++) {
					
					System.out.println("In the main loop");
					
					step = steps.get(i);
					currentstepVar.setText(step);
					String input1 = "";
					String input2 = "";
					
					switch(step) {
					case "openURL":
						input1 = input1arr.get(0+input1counter);
						input1counter += 1;
						OpenURLObject.openURL(input1);
						break;
					case "click":
						input1 = input1arr.get(0+input1counter);
						input1counter += 1;
						OpenURLObject.click(input1);
						break;
					case "wait":
						input1 = input1arr.get(0+input1counter);
						input1counter += 1;
						int time = Integer.parseInt(input1);
						OpenURLObject.wait(time);
						break;
					case "input":
						input1 = input1arr.get(0+input1counter);
						input1counter += 1;
						input2 = input2arr.get(0+input2counter);
						input2counter += 1;
						OpenURLObject.input(input2, input1);
						break;
					case "startTime":
						start = System.currentTimeMillis();	
						break;
					case "stopTime":
						long now = System.currentTimeMillis();
						double timelogged = ((now - start)/1000.0);
						System.out.println("Time logged for the step = " +timelogged);
						String timedisplay = timedisplayscreenVar.getText() + " Time elapsed = " +timelogged +"    ";
						timedisplayscreenVar.setText(timedisplay);
						break;
					case "clear_input":
						input1 = input1arr.get(0+input1counter);
						input1counter += 1;
						OpenURLObject.clearInput(input1);
						break;
					case "scroll":
						input1 = input1arr.get(0+input1counter);
						input1counter += 1;
						OpenURLObject.scroll(input1);
						break;
					case "doubleclick":
						input1 = input1arr.get(0+input1counter);
						input1counter += 1;
						OpenURLObject.doubleclick(input1);
						break;
					case "screenshot":
						OpenURLObject.screenshot();
						break;
					case "dropdown":
						input1 = input1arr.get(0+input1counter);
						input1counter += 1;
						input2 = input2arr.get(0+input2counter);
						input2counter += 1;
						OpenURLObject.dropdown(input2, input1);
						break;
					case "if stop":
						System.out.println("Something went wrong in the execution because the runVar reached if stop");
						break;
					case "if start":
						ifstepsVar.setText("STEPS : ");
						System.out.println("Entered the if block ");
					    
						i += 1;
						
					    System.out.println("Current i value = "+i);
					    
					    String condition = steps.get(i);
					    
					    System.out.println("The condition is = "+condition);
					    
					    int start = i;
					    ArrayList<String> slicedsteps = new ArrayList<String>(steps.subList(i, steps.size()));
					    
					    System.out.println("The sliced string is = "+slicedsteps);
					    
					    int end = slicedsteps.indexOf("if stop") + i + 1;
					    System.out.println("end is = "+end);
					    
					    if(slicedsteps.indexOf("if stop") == -1) {
					    	warningVar.setText("Warning: if start exists without if stop. Please add if stop");
					    }
					    boolean finalcall = false;
					      
					    switch(condition){

					        case "exists":
					        	
					        	System.out.println("Entered the switch case for condition");
					        	
					            String xpath = input2arr.get(input2counter);
					            
					            System.out.println("The xpath = "+xpath);
					            
					            Boolean flag = false;
					            Boolean output = OpenURL.exist(xpath);
					            System.out.println("The output is = "+output);
					            System.out.println("The input1arr value with the input1counter = "+input1arr.get(input1counter));
					            
					            if(input1arr.get(input1counter).equals("true")){
					            	System.out.println("The flag value is true");
					                flag = true;
					            }
					            else if(input1arr.get(input1counter).equals("false")){
					            	System.out.println("The flag value is false");
					                flag = false;
					            }
					            else {
					            	System.out.println("For some reason, I'm here");
					            }
					            if(output == flag){
					              finalcall = true;
					              System.out.println("finalcall value is true");
					            }
					            
								input1counter += 1;
								input2counter += 1;
								
					            break;

					        case "contains":
					            break;
					        case "starts with":
					            break;
					        case "ends with":
					            break;
					        case "not equals":
					            break;

					        
					    }
					    if(finalcall == false) {
					    	System.out.println("The if condition has been rejected");
					    	for(int b = i+1; b < end; b++) {
					    		step = steps.get(b);
					    		switch(step) {
								case "openURL":
									input1counter += 1;
									break;
								case "click":
									input1counter += 1;
									break;
								case "wait":
									input1counter += 1;
									break;
								case "input":
									input1counter += 1;
									input2counter += 1;
									break;
								case "clear_input":
									input1counter += 1;
									break;
								case "scroll":
									input1counter += 1;
									break;
								case "doubleclick":
									input1counter += 1;
									break;
								case "dropdown":
									input1counter += 1;
									input2counter += 1;
									break;
					    		}
					    	}
					    	i = end-1;
					    }
					    break;

					}
					//
					int progress = progressbarVar.getValue() + 100/(steps.size());
					progressbarVar.setValue(progress);
					int stepno = i+1;
					//
					System.out.println("Progress bar value while running in step " +stepno+ " = " +progressbarVar.getValue());
					System.out.println("Step number " +stepno+ " = " +step);
					System.out.println("The value of i now is = " +i);
				}
				input1counter = 0;
				input2counter = 0;
				progressbarVar.setValue(100);
				
				warningVar.setText("Working fine Boss!");
			}
		});
		
		//
		ArrayList<Integer> testcaseRef = new ArrayList<Integer>();
		btnimportVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fileName = fileinputVar.getText() + ".txt";
				String path = System.getProperty("user.dir");
				path = path + "\\saved tests\\" + fileName;
				
				try {

					FileInputStream fi = new FileInputStream(new File(path));
					ObjectInputStream oi = new ObjectInputStream(fi);

					// Read objects
					RunObj currentRunObject = (RunObj) oi.readObject();
					
					int size = (currentRunObject.steps).size();
					System.out.println("Size of the steps array in Current Run Object = " +size);
					int truesize1 = steps.size();
					
					testcaseRef.add(size); //to keep track of testcases to minus them
					//int truesize2 = input1arr.size();
					for(int i=0; i<size; i++) {
						truesize1 += i;
						//truesize2 += i;
						String step = (currentRunObject.steps).get(i);
						System.out.println("Step imported into "+truesize1+"th place in steps array = " +step);
						steps.add(step);
						
						//String input1 = (currentRunObject.input1arr).get(i);
						//System.out.println("Step imported into " +truesize2+ "th place in input1arr array= " +input1);
						//input1arr.add(input1);
					}
					
					
					int size3 = (currentRunObject.input1arr).size();
					System.out.println("Size of input1arr array from current object = "+size3);
					int truesize4 = input1arr.size();
					
					testcaseRef.add(size3); //to keep track of testcases to minus them
					
					for(int j=0; j<size3; j++) {
						truesize4 += j;
						String input1 = (currentRunObject.input1arr).get(j);
						System.out.println("Step imported into " +truesize4+ "th place in input1arr array= " +input1);
						input1arr.add(input1);
					}
					 
					
					int size2 = (currentRunObject.input2arr).size();
					System.out.println("Size of input2arr array from current object = "+size2);
					int truesize3 = input2arr.size();
					
					testcaseRef.add(size2); //to keep track of testcases to minus them
					
					for(int j=0; j<size2; j++) {
						truesize3 += j;
						String input2 = (currentRunObject.input2arr).get(j);
						System.out.println("Step imported into " +truesize3+ "th place in input2arr array= " +input2);
						input2arr.add(input2);
					}
					
					
					  //steps = currentRunObject.steps; 
					  //input1arr = currentRunObject.input1arr;
					  //input2arr = currentRunObject.input2arr;
					 

					oi.close();
					fi.close();

				} catch (FileNotFoundException e1) {
					System.out.println("File not found");
				} catch (IOException e1) {
					 e1.printStackTrace();
					System.out.println("Error initializing stream");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
					
				stepsdisplay = "STEPS - ";
				int count = 0;
				for(int i=0; i<steps.size(); i++) {
					stepsdisplay = stepsdisplay + steps.get(i) + " - ";
					count += 1;
					
				}
				String countstr = String.valueOf(count);
				stepnumVar.setText(countstr);
				
				int testcaseCount = Integer.parseInt(testcasenumVar.getText());
				testcaseCount += 1;
				testcasenumVar.setText(String.valueOf(testcaseCount));
				
				int ind = stepsdisplay.lastIndexOf("-");
				String stepsdisplayfinal = stepsdisplay.substring(0, ind);
				stepsdisplayVar.setText(stepsdisplayfinal);
				
				System.out.println("");
				System.out.println("Current steps array after importing = " +steps);
				System.out.println("Current input1arr array after importing = " +input1arr);
				System.out.println("Current input2arr array after importing = " +input2arr);
				
				String fileName2 = fileinputVar.getText();
				fileinputVar.setText("");
				if((addedfilesVar.getText()).equals("No testcases added")) {
					addedfilesVar.setText("");
				}
				String filedisplay = addedfilesVar.getText() + fileName2 + ", ";
				addedfilesVar.setText(filedisplay);
				
				warningVar.setText("Working fine Boss!");
				
			}
		});
				
		
		btnstopVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenURLObject.stop();
			}
		});
		
		
		btnclearVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timedisplayscreenVar.setText("");
				stepsdisplayVar.setText("STEPS : ");
				steps.clear();
				input1arr.clear();
				input2arr.clear();
				stepnumVar.setText("0");
				progressbarVar.setValue(0);
				input2counter = 0;
				addedfilesVar.setText("No testcases added");
				currentstepVar.setText("");
				System.out.println(steps);
				System.out.println(input1arr);
				System.out.println(input2arr);
				warningVar.setText("Working fine Boss!");
				
			}
		});
		
		
		btnminustcVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int count = Integer.parseInt(testcasenumVar.getText());
				System.out.println("Testcase Reference array = "+testcaseRef);
				if(count > 0) {
					count -= 1;
					testcasenumVar.setText(String.valueOf(count));
					
					int stepssize = testcaseRef.get(testcaseRef.size()-3);
					int input1arrsize = testcaseRef.get(testcaseRef.size()-2);
					int input2arrsize = testcaseRef.get(testcaseRef.size()-1);
					
					System.out.println("stepssize = "+stepssize+" input1arrsize = "+input1arrsize+ " input2arrsize = " +input2arrsize);
					
					int stepnum = 0;
					for(int i = 0; i<stepssize; i++) {
						
						steps.remove(steps.size()-1);
						
						stepsdisplay = stepsdisplayVar.getText();
						int index = stepsdisplay.lastIndexOf("-");
						stepsdisplay = stepsdisplay.substring(0, index);
						stepsdisplayVar.setText(stepsdisplay);
						
						stepnum += 1;
						
					}
					
					stepnum = Integer.parseInt(stepnumVar.getText()) - stepnum;
					stepnumVar.setText(String.valueOf(stepnum));
					
					for(int j=0; j<input1arrsize; j++) {
						
						input1arr.remove(input1arr.size()-1);
						
					}
					
					for(int j=0; j<input2arrsize; j++) {
						
						input2arr.remove(input2arr.size()-1);
						
					}
					
					stepsdisplay = addedfilesVar.getText();
					int index = stepsdisplay.lastIndexOf(",");
					stepsdisplay = stepsdisplay.substring(0, index);
					index = stepsdisplay.lastIndexOf(",");
					stepsdisplay = stepsdisplay.substring(0, index+1);
					addedfilesVar.setText(stepsdisplay);
					
					testcaseRef.remove(testcaseRef.size()-1);
					testcaseRef.remove(testcaseRef.size()-1);
					testcaseRef.remove(testcaseRef.size()-1);
					
				}
				
			}
		});
		
		
		//
	}
}

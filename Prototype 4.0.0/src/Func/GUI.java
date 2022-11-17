package Func;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
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
		setTitle("GUI Prototype 3.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 557);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		OpenURL OpenURLObject = new OpenURL();
		
		
		
		JButton openurlVar = new JButton("Open URL");
		openurlVar.setFont(new Font("Tahoma", Font.BOLD, 9));
		
		
		openurlVar.setBounds(389, 54, 85, 21);
		contentPane.add(openurlVar);
		
		input1Var = new JTextField();
		input1Var.setText("input 1");
		input1Var.setBounds(514, 55, 88, 19);
		contentPane.add(input1Var);
		input1Var.setColumns(10);
		
		input2Var = new JTextField();
		input2Var.setText("input 2");
		input2Var.setBounds(514, 84, 88, 19);
		contentPane.add(input2Var);
		input2Var.setColumns(10);
		
		
		clickVar = new JButton("Click");
		
		
		clickVar.setBounds(389, 85, 85, 21);
		contentPane.add(clickVar);
		
		waitVar = new JButton("Wait");
		
		
		waitVar.setBounds(389, 116, 85, 21);
		contentPane.add(waitVar);
		
		inputVar = new JButton("Input");
	
		
		inputVar.setBounds(389, 147, 85, 21);
		contentPane.add(inputVar);
	
		stepnumVar = new JLabel("   0");
		stepnumVar.setFont(new Font("Tahoma", Font.BOLD, 15));
		stepnumVar.setBounds(60, 77, 33, 32);
		contentPane.add(stepnumVar);
		
		minusVar = new JButton("-");
		
		minusVar.setFont(new Font("Arial", Font.PLAIN, 15));
		minusVar.setBounds(10, 82, 40, 21);
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
		
		btnsaveVar = new JButton("Save");
		
		btnsaveVar.setBounds(398, 307, 76, 21);
		contentPane.add(btnsaveVar);
		
		savednameVar = new JTextField();
		savednameVar.setText("Enter save name");
		savednameVar.setBounds(483, 307, 119, 20);
		contentPane.add(savednameVar);
		savednameVar.setColumns(10);
		
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
		lblNewLabel.setBounds(383, 22, 106, 21);
		contentPane.add(lblNewLabel);
		
		JLabel currentstepVar = new JLabel("             ...");
		currentstepVar.setBounds(220, 62, 102, 13);
		contentPane.add(currentstepVar);
		
		JLabel lblNewLabel_1 = new JLabel("Current step - ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(122, 64, 88, 11);
		contentPane.add(lblNewLabel_1);
		
		JButton btnclearVar = new JButton("CLEAR");
		
		btnclearVar.setBounds(203, 259, 85, 21);
		contentPane.add(btnclearVar);
		
		stepsdisplayVar.setText("STEPS : ");
		
		JLabel addedfilesVar = new JLabel("No testcases added");
		addedfilesVar.setFont(new Font("Tahoma", Font.ITALIC, 11));
		addedfilesVar.setBounds(125, 341, 327, 21);
		contentPane.add(addedfilesVar);
		
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
		
		
		JButton btnstarttimerVar = new JButton("Start timer");
		btnstarttimerVar.setBounds(389, 178, 85, 21);
		contentPane.add(btnstarttimerVar);
		
		
		btnstarttimerVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				steps.add("startTime");
							
				count = Integer.parseInt(stepnumVar.getText()) + 1;
				countstr =Integer.toString(count);
				stepnumVar.setText(countstr);
				
				stepsdisplay = stepsdisplayVar.getText() + " - StartTime";
				System.out.println(stepsdisplay);
				stepsdisplayVar.setText(stepsdisplay);
			
				
			}
		});
		
		btnstarttimerVar.setFont(new Font("Tahoma", Font.BOLD, 9));
		
		JButton btnstoptimerVar = new JButton("Stop timer");
		btnstoptimerVar.setBounds(389, 209, 85, 21);
		contentPane.add(btnstoptimerVar);
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
				
				
			}
		});
		
		btnstoptimerVar.setFont(new Font("Tahoma", Font.BOLD, 9));
		
		//
		
		minusVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
					if((!steptoberemoved.equals("startTime")) || (!steptoberemoved.equals("stopTime"))) {
						input1arr.remove(input1arr.size()-1);
						System.out.println("The current input1arr after removal of the previous steps is = " +input1arr);
					}
					steps.remove(steps.size()-1);
					
					stepsdisplay = stepsdisplayVar.getText();
					int index = stepsdisplay.lastIndexOf("-");
					stepsdisplay = stepsdisplay.substring(0, index);
					stepsdisplayVar.setText(stepsdisplay);
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
				System.out.println("At the start of run command, the size of the steps array = " +stepsize);
				
				for(int i=0; i<stepsize; i++) {
					
					step = steps.get(i);
					currentstepVar.setText(step);
					String input1 = "";
					
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
						String input2 = input2arr.get(0+input2counter);
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

					}
					//
					int progress = progressbarVar.getValue() + 100/(steps.size());
					progressbarVar.setValue(progress);
					int stepno = i+1;
					//
					System.out.println("Progress bar value while running in step " +stepno+ " = " +progressbarVar.getValue());
					System.out.println("Step number " +stepno+ " = " +step);
				}
				input1counter = 0;
				input2counter = 0;
				progressbarVar.setValue(100);
			}
		});
		
		//
		
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
					for(int j=0; j<size3; j++) {
						truesize4 += j;
						String input1 = (currentRunObject.input1arr).get(j);
						System.out.println("Step imported into " +truesize4+ "th place in input1arr array= " +input1);
						input1arr.add(input1);
					}
					 
					
					int size2 = (currentRunObject.input2arr).size();
					System.out.println("Size of input2arr array from current object = "+size2);
					int truesize3 = input2arr.size();
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
				
			}
		});
				
		
		btnstopVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenURLObject.stop();
			}
		});
		
		openurlVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
			}
		});
		
		
		clickVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				steps.add("click");
				input1Value = input1Var.getText();
				input1arr.add(input1Value);
				
				count = Integer.parseInt(stepnumVar.getText()) + 1;
				countstr =Integer.toString(count);
				stepnumVar.setText(countstr);
				
				stepsdisplay = stepsdisplayVar.getText() + " - click";
				stepsdisplayVar.setText(stepsdisplay);
				
				input1Var.setText("");
			}
		});
		
		
		inputVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
			}
		});
		
		
		waitVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				steps.add("wait");
				input1Value = input1Var.getText();
				input1arr.add(input1Value);
				
				int count = Integer.parseInt(stepnumVar.getText()) + 1;
				countstr =Integer.toString(count);
				stepnumVar.setText(countstr);
				
				stepsdisplay = stepsdisplayVar.getText() + " - wait";
				stepsdisplayVar.setText(stepsdisplay);
				
				input1Var.setText("");
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
					
					
				} catch (FileNotFoundException e1) {
					System.out.println("File not found");
				} catch (IOException e1) {
					e1.printStackTrace();
					System.out.println("Error initializing stream");
				} 

				
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
				
			}
		});
		
		
		//
	}
}

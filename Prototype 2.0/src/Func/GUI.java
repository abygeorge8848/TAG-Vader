package Func;

import java.util.ArrayList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;

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
	int input2counter=0;
	String stepsdisplay="";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		setTitle("GUI Prototype 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		OpenURL OpenURLObject = new OpenURL();
		
		
		
		JButton openurlVar = new JButton("Open URL");
		
		
		openurlVar.setBounds(337, 61, 85, 21);
		contentPane.add(openurlVar);
		
		input1Var = new JTextField();
		input1Var.setText("input 1");
		input1Var.setBounds(24, 281, 88, 19);
		contentPane.add(input1Var);
		input1Var.setColumns(10);
		
		input2Var = new JTextField();
		input2Var.setText("input 2");
		input2Var.setBounds(122, 281, 88, 19);
		contentPane.add(input2Var);
		input2Var.setColumns(10);
		
		
		clickVar = new JButton("Click");
		
		
		clickVar.setBounds(337, 92, 85, 21);
		contentPane.add(clickVar);
		
		waitVar = new JButton("Wait");
		
		
		waitVar.setBounds(337, 123, 85, 21);
		contentPane.add(waitVar);
		
		inputVar = new JButton("Input");
	
		
		inputVar.setBounds(337, 154, 85, 21);
		contentPane.add(inputVar);
	
		stepnumVar = new JLabel("   0");
		stepnumVar.setFont(new Font("Tahoma", Font.BOLD, 15));
		stepnumVar.setBounds(75, 65, 33, 32);
		contentPane.add(stepnumVar);
		
		minusVar = new JButton("-");
		minusVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int count = Integer.parseInt(stepnumVar.getText()) - 1;
				if(count >= 0) {
					String countstr = String.valueOf(count);
					stepnumVar.setText(countstr);
					
					steps.remove(steps.size()-1);
					
					stepsdisplay = stepsdisplayVar.getText();
					int index = stepsdisplay.lastIndexOf("-");
					stepsdisplay = stepsdisplay.substring(0, index);
					stepsdisplayVar.setText(stepsdisplay);
				}
				
			}
		});
		minusVar.setFont(new Font("Arial", Font.PLAIN, 20));
		minusVar.setBounds(39, 73, 40, 21);
		contentPane.add(minusVar);
		
		runVar = new JButton("RUN");
		runVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String step;
				String input1;
				for(int i=0; i<=steps.size(); i++) {
					step = steps.get(i);
					input1 = input1arr.get(i);
					
					switch(step) {
					case "openURL":
						OpenURLObject.openURL(input1);
						break;
					case "click":
						OpenURLObject.click(input1);
						break;
					case "wait":
						int time = Integer.parseInt(input1);
						OpenURLObject.wait(time);
						break;
					case "input":
						String input2 = input2arr.get(0+input2counter);
						input2counter += 1;
						OpenURLObject.input(input2, input1);
						break;


					}
				}
			}
		});
		
		runVar.setBounds(337, 280, 85, 21);
		contentPane.add(runVar);
		
		stepsdisplayVar = new JTextArea();
		stepsdisplayVar.setText("STEPS ");
		stepsdisplayVar.setBounds(20, 123, 268, 126);
		contentPane.add(stepsdisplayVar);
		
		
		//
		openurlVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				stepnumVar.setText("0");
				
				steps.add("openURL");
				input1Value = input1Var.getText();
				input1arr.add(input1Value);
				
				count = Integer.parseInt(stepnumVar.getText()) + 1;
				countstr =Integer.toString(count);
				stepnumVar.setText(countstr);
				
				stepsdisplay = stepsdisplayVar.getText() + " - OpenURL";
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
		
		
		//
	}
}

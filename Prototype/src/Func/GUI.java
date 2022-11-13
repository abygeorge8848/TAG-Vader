package Func;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField URLvar;
	public  static String URLstring;
	private JTextField xpathVar;
	private JButton btnClick;
	private JTextField timeVar;
	private JButton btnWait;
	public static int timeNum;
	public static String xpathString;
	private JTextField xpathInputVar;
	private JTextField InputValueVar;
	private JButton btnInput;
	public static String value;
	private JTextField xpathClearVar;
	private JButton btnClearInput;
	private JTextField xpathScrollVar;
	private JButton btnScroll;
	

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
		setTitle("GUI Prototype");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		OpenURL OpenURLObject = new OpenURL();
		
		JButton btnNewButton = new JButton("OpenURL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				URLstring = URLvar.getText();
				//OpenURL OpenURLObject = new OpenURL();
				OpenURLObject.openURL(URLstring);
				                               
			}
		});
		btnNewButton.setBounds(20, 50, 114, 19);
		contentPane.add(btnNewButton);
		
		URLvar = new JTextField();
		URLvar.setText("Enter URL");
		URLvar.setBounds(10, 21, 130, 19);
		contentPane.add(URLvar);
		URLvar.setColumns(10);
		
		xpathVar = new JTextField();
		xpathVar.setText("Enter xpath to be clicked");
		xpathVar.setBounds(169, 21, 130, 19);
		contentPane.add(xpathVar);
		xpathVar.setColumns(10);
		
		btnClick = new JButton("Click");
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xpathString = xpathVar.getText();
				//Click ClickObject = new Click();
				OpenURLObject.click(xpathString);
			}
		});
		btnClick.setBounds(190, 50, 85, 19);
		contentPane.add(btnClick);
		
		timeVar = new JTextField();
		timeVar.setText("Enter wait time");
		timeVar.setBounds(10, 97, 130, 19);
		contentPane.add(timeVar);
		timeVar.setColumns(10);
		
		btnWait = new JButton("Wait");
		btnWait.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeNum = Integer.parseInt(timeVar.getText());
				//Wait WaitObject = new Wait();
				OpenURLObject.wait(timeNum);
			}
		});
		btnWait.setBounds(30, 126, 85, 19);
		contentPane.add(btnWait);
		
		xpathInputVar = new JTextField();
		xpathInputVar.setText("Enter xpath");
		xpathInputVar.setBounds(169, 97, 70, 19);
		contentPane.add(xpathInputVar);
		xpathInputVar.setColumns(10);
		
		InputValueVar = new JTextField();
		InputValueVar.setText("Enter value");
		InputValueVar.setBounds(249, 97, 70, 19);
		contentPane.add(InputValueVar);
		InputValueVar.setColumns(10);
		
		btnInput = new JButton("Input");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xpathString = xpathVar.getText();
				value = InputValueVar.getText();
				OpenURLObject.input(value, xpathString);
			}
		});
		btnInput.setBounds(190, 125, 85, 21);
		contentPane.add(btnInput);
		
		xpathClearVar = new JTextField();
		xpathClearVar.setText("Enter xpath");
		xpathClearVar.setBounds(10, 169, 130, 19);
		contentPane.add(xpathClearVar);
		xpathClearVar.setColumns(10);
		
		btnClearInput = new JButton("Clear Input");
		btnClearInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xpathString = xpathClearVar.getText();
				OpenURLObject.clearInput(xpathString);
			}
		});
		btnClearInput.setBounds(20, 198, 114, 21);
		contentPane.add(btnClearInput);
		
		xpathScrollVar = new JTextField();
		xpathScrollVar.setText("Enter xpath");
		xpathScrollVar.setBounds(169, 169, 130, 19);
		contentPane.add(xpathScrollVar);
		xpathScrollVar.setColumns(10);
		
		btnScroll = new JButton("Scroll");
		btnScroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xpathString = xpathScrollVar.getText();
				OpenURLObject.scroll(xpathString);
			}
		});
		btnScroll.setBounds(190, 198, 85, 21);
		contentPane.add(btnScroll);
	}

}

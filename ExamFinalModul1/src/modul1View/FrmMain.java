package modul1View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class FrmMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMain window = new FrmMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("Button.light"));
		menuBar.setBounds(0, 0, 534, 21);
		
		frame.getContentPane().add(menuBar);
		
		JMenu mnTool = new JMenu("File");
		menuBar.add(mnTool);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mnTool.add(mntmNewMenuItem);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnTool.add(mntmOpen);
		
		JMenu mnAppliction = new JMenu("Appliction");
		menuBar.add(mnAppliction);
		
		JMenuItem mntmAppeditinformation = new JMenuItem("AppEditInformation");
		mnAppliction.add(mntmAppeditinformation);
		
		JMenuItem mntmApp = new JMenuItem("AppContactPhone");
		mnAppliction.add(mntmApp);
		
		JMenuItem mntmAppcaculator = new JMenuItem("AppCaculator");
		mnAppliction.add(mntmAppcaculator);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmIntroduce = new JMenuItem("Introduce");
		mnHelp.add(mntmIntroduce);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 22, 534, 339);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}

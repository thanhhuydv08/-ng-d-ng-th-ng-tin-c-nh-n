package modul1View;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import modul1Control.Controller;
import modul1Model.People;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmEditInformation extends Controller {
	Object [] colum = {"Picture","Full Name","Phone"};

	int rowUpdate;
	private JFrame frame;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtPicture;
	DefaultTableModel dtm= new DefaultTableModel(colum,0);
	JTable jTable;
	Object [][] dataTemp ;
	Controller controller = new Controller();
	ArrayList <People> arrayList = new ArrayList<>();
	DefaultTableModel defaultTableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEditInformation window = new FrmEditInformation();
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
	public FrmEditInformation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Cập nhật thông tin cá nhân");
		frame.getContentPane().setBackground(new Color(224, 255, 255));
		frame.setBounds(100, 100, 613, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtName = new JTextField();
		txtName.setBounds(101, 45, 191, 20);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 48, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(354, 48, 70, 14);
		frame.getContentPane().add(lblPhone);

		txtPhone = new JTextField();
		txtPhone.setBounds(434, 45, 111, 20);
		txtPhone.setColumns(10);
		frame.getContentPane().add(txtPhone);

		JLabel lblPicture = new JLabel("Picture");
		lblPicture.setBounds(10, 92, 61, 14);
		frame.getContentPane().add(lblPicture);

		txtPicture = new JTextField();
		txtPicture.setBounds(101, 89, 354, 20);
		txtPicture.setColumns(10);
		frame.getContentPane().add(txtPicture);

		JButton button = new JButton(".....");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int checked = chooser.showOpenDialog(frame);
				if(checked==JFileChooser.APPROVE_OPTION) {
					// trả file path cho textfiel để getText
					txtPicture.setText(chooser.getSelectedFile().getPath());
				}
			}
		});
		button.setBounds(475, 88, 31, 23);
		button.setBackground(UIManager.getColor("CheckBox.background"));
		frame.getContentPane().add(button);

		JButton btnNewButton = new JButton("Updates");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                if(jTable.getSelectedRow()>=0) {
				arrayList = controller.Update(rowUpdate,txtName.getText(),txtPhone.getText(),txtPicture.getText()); 
				RefeshJtable(arrayList);
                }else {
					JOptionPane.showMessageDialog(frame, "Vui lòng chọn row cần chỉnh sữa hay delete");
				}
			}
		});
		btnNewButton.setBounds(101, 132, 89, 23);
		btnNewButton.setBackground(UIManager.getColor("CheckBox.background"));
		frame.getContentPane().add(btnNewButton);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowSelected = jTable.getSelectedRow();
				if(rowSelected>=0) {
					int deleteChecked = JOptionPane.showConfirmDialog(frame, "Bạn có thật sự muốn xóa hàng "+rowSelected+" trong bảng.");
					if(deleteChecked==JOptionPane.OK_OPTION) {
					arrayList = controller.Delete(rowSelected,arrayList);
					RefeshJtable(arrayList);
					}
				}else {
					JOptionPane.showMessageDialog(frame, "Vui lòng chọn row cần chỉnh sữa hay delete");
				}
				
			}
		});
		btnDelete.setBounds(203, 132, 89, 23);
		btnDelete.setBackground(UIManager.getColor("CheckBox.background"));
		frame.getContentPane().add(btnDelete);

		/*
		 * hien thi du lieu ra jtable tao moi cung luc chay
		 */
		arrayList = controller.AddValue();
		ConvertArrToObject(arrayList);
		System.out.println(dataTemp.length);
		jTable = new JTable(defaultTableModel) {
			@Override
			public Class<?> getColumnClass(int column) {
				// TODO Auto-generated method stub
				return super.getValueAt(0, column).getClass();
			}

		};
		jTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {		
				int row =jTable.getSelectedRow();
				GetValuesFromJtableToWigets(row);
			}
		});
		jTable.getColumnModel().getColumn(0).setPreferredWidth(30);
		jTable.getColumnModel().getColumn(2).setPreferredWidth(20);
		jTable.setRowHeight(100);

		//		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		//        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		//        jTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		jTable.setFont(new Font("Time New Roman",Font.LAYOUT_LEFT_TO_RIGHT, 13));
		jTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
			@Override
			public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column) {
				Component c = super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
				if(isSelected==true) {
					// thuoocj tinhs cell thi vao day de set
				}

				return c;
			}
		});
		JTableHeader header = jTable.getTableHeader();
		header.setFont(new Font("Time New Roman", Font.BOLD, 15));
		header.setBackground(Color.lightGray);
		JScrollPane scrollPane = new JScrollPane(jTable);
		scrollPane.setBounds(10, 177, 577, 257);
		frame.getContentPane().add(scrollPane);

	}
	public void GetValuesFromJtableToWigets(int row) {
		rowUpdate=row;
		switch (row) {
		case 0:
			txtName.setText(arrayList.get(0).getsName());
			txtPhone.setText(arrayList.get(0).getsPhone());
			txtPicture.setText(arrayList.get(0).getsPicture().toString());
			break;
		case 1:
			txtName.setText(arrayList.get(1).getsName());
			txtPhone.setText(arrayList.get(1).getsPhone());
			txtPicture.setText(arrayList.get(1).getsPicture().toString());
			break;
		case 2:
			txtName.setText(arrayList.get(2).getsName());
			txtPhone.setText(arrayList.get(2).getsPhone());
			txtPicture.setText(arrayList.get(2).getsPicture().toString());
			break;
		}
	}
	public void ConvertArrToObject(ArrayList<People> arrayList) {
		dataTemp = new Object[][] {{arrayList.get(0).getsPicture(),arrayList.get(0).getsName(),arrayList.get(0).getsPhone()},
			{arrayList.get(1).getsPicture(),arrayList.get(1).getsName(),arrayList.get(1).getsPhone()}
		,{arrayList.get(2).getsPicture(),arrayList.get(2).getsName(),arrayList.get(2).getsPhone()}};
		defaultTableModel = new DefaultTableModel(dataTemp, colum);
	}
	public void RefeshJtable(ArrayList<People> arrayList) {
		Object[] dataUpdates ;
		defaultTableModel.setRowCount(0);// xóa bảng cũ
		for(int i=0;i<arrayList.size();i++) {
			dataUpdates = new Object[] {arrayList.get(i).getsPicture(),arrayList.get(i).getsName(),arrayList.get(i).getsPhone()};
			defaultTableModel.addRow(dataUpdates);
		}
        
	}

}

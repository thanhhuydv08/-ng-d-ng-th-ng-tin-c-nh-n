package modul1Control;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import modul1Model.Abtractor;
import modul1Model.People;

public class Controller implements Abtractor{
	People people, people2, people1, people3;
	ArrayList<People> arrayList1= new ArrayList<People>();
	

	public Controller() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * tra ve mang tu ngoai them vao 
	 */
	public ArrayList<People>  AddValue() {
		people = new People("Nguyễn Thành Huy", "0965606480", new ImageIcon("E:\\APLICATION_WORKING\\JAVACORE & SQL SERVER\\KHTN\\project_huynt75\\ExamFinalModul1\\images\\man1.png"));
		people1 = new People("Đào Thị Minh Hảo", "038133637", new ImageIcon("E:\\APLICATION_WORKING\\JAVACORE & SQL SERVER\\KHTN\\project_huynt75\\ExamFinalModul1\\images\\man2.png"));
		people2 = new People("Phan Ngọc Tùng", "037388382", new ImageIcon("E:\\APLICATION_WORKING\\JAVACORE & SQL SERVER\\KHTN\\project_huynt75\\ExamFinalModul1\\images\\man3.png"));
		arrayList1.add(people);
		arrayList1.add(people1);
		arrayList1.add(people2);
 
		return arrayList1;
	}

	@Override
	public ArrayList<People> Update(int rowUpdate,String name, String phone, String picture) {
		arrayList1.remove(rowUpdate);// xóa thằng index muốn sữa xong add lại vị trí đó nhưng có tên , số dth, hình ảnh khác
		arrayList1.add(rowUpdate, new People(name, phone, new ImageIcon(picture)));
	
		return arrayList1;
	}

	@Override
	public ArrayList<People> Delete (int rowSelected, ArrayList<People> arrayList) {
		arrayList.remove(rowSelected);
		arrayList1 =arrayList;
		return arrayList1;
	}
}

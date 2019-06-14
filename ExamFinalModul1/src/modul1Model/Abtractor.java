package modul1Model;

import java.util.ArrayList;

public interface Abtractor {
public  ArrayList<People> Update(int row,String name, String phone, String picture ) ;
public  ArrayList<People> Delete(int rowSelected, ArrayList<People> arrayList) ;	

}

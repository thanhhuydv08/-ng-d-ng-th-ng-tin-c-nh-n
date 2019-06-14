package modul1Model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class People {
String sName, sPhone;
ImageIcon sPicture;
public People(String sName, String sPhone, ImageIcon sPicture) {
	super();
	this.sName = sName;
	this.sPhone = sPhone;
	this.sPicture = sPicture;
}
public String getsName() {
	return sName;
}
public void setsName(String sName) {
	this.sName = sName;
}
public String getsPhone() {
	return sPhone;
}
public void setsPhone(String sPhone) {
	this.sPhone = sPhone;
}
public Icon getsPicture() {
	return sPicture;
}
public void setsPicture(ImageIcon sPicture) {
	this.sPicture = sPicture;
}



}

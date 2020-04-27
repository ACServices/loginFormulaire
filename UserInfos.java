package formulaireProject;

import java.util.ArrayList;
import java.util.List;

public class UserInfos {
	private String f_name = "", l_name ="", sexe = "",phone="", email="", nation="", adress = "";
	private List<String> hobbies = new ArrayList<String>();
	private int age = 0;
	
	public UserInfos(String fname, String lname, int age, String sexe, String adress, String phone, String email, String nation, List hobbies) {
		this.f_name = fname;
		this.l_name = lname;
		this.age = age;
		this.sexe = sexe;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
		this.nation = nation;
		this.hobbies = hobbies;
	}
	
	public String toString() {
		String info = "Vos Informations\n\n";
			info += "\tNom: "+this.f_name+"\t\t Prenom: "+this.l_name+"\t\t Sexe: "+this.sexe+"\n";
			info += "\tNation: "+this.nation+"\t Adress: "+this.adress+"\t Phone: "+this.phone+" Email:"+this.email+"\n";
			info +="Loisirs: "+this.hobbies.toString();
		return info;			
	}

}

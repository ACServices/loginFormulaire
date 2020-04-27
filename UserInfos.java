package formulaireProject;

import java.util.ArrayList;
import java.util.List;

public class UserInfos {
	private String f_name = "", l_name ="", sexe = "",phone="", email="", nation="", adress = "";
	private List<String> hobbies = new ArrayList<String>();
	private String age = "";
	
	public UserInfos(String fname, String lname, String age, String sexe, String adress, String phone, String email, String nation, List hobbies) {
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
			info += "\tNom: "+this.f_name+"; \t\t Prenom: "+this.l_name+"; \t\t Sexe: "+this.sexe+"; \n\n";
			info += "\tAge: "+ this.age+"; \t\tNation: "+this.nation+"; \t\t Adress: "+this.adress+";\n\n";
			info +="\tPhone: "+this.phone+"; \t\tEmail:"+this.email+";\n\nLoisirs: "+this.hobbies.toString();
		return info;			
	}

}

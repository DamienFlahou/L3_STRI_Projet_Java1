package Model;
public class CarteReseau {
	private String adresseMac;
	private boolean isActive;
	
	public CarteReseau(String adresse_mac, boolean _isActive) {
		super();
		this.adresseMac = adresse_mac;
		this.isActive = _isActive;
	}

	public String getAdresseMac() {
		return adresseMac;
	}

	public void setAdresse_mac(String adresseMac) {
		this.adresseMac = adresseMac;
	}
	
	public String toString(){
		return adresseMac;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}

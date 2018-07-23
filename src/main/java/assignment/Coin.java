package assignment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Coin {

	public Coin() {
	}

	private String id;
	private String name;
	private String price_eur;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice_eur() {
		return price_eur;
	}

	public void setPrice_eur(String price_eur) {
		this.price_eur = price_eur;
	}

}

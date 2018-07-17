package assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity
@Data
@Getter
@Setter
@Table(name = "portfolio_item")
public class PortfolioItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(
            name = "question_generator",
            sequenceName = "portfolio_item_id_seq"
            
    )
	@Column(name = "id")
	public Long id;
	
	@Column(name = "amount")
	public int amount;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getWallet() {
		return wallet;
	}


	public void setWallet(String wallet) {
		this.wallet = wallet;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	@Column(name = "date")
	public String date;
	
	@Column(name = "wallet")
	public String wallet;
	
	
	@Column(name = "currency")
	public String currency;

}


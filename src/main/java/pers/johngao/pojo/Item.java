package pers.johngao.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="item")
public class Item {
	@Id
	@GenericGenerator(strategy="uuid",name="uuid")
	@GeneratedValue(generator="uuid")
	private String id;
	private String itemName;
	private Integer itemNum;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="b_id")
	private Base base;

	public Item(String id, String itemName, Integer itemNum, Base base) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemNum = itemNum;
		this.base = base;
	}

	public Item() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	

	public Integer getItemNum() {
		return itemNum;
	}

	public void setItemNum(Integer itemNum) {
		this.itemNum = itemNum;
	}

	public Base getBase() {
		return base;
	}

	public void setBase(Base base) {
		this.base = base;
	}
	
	
}

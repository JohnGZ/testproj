package pers.johngao.pojo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="base")
public class Base {
	@Id
	@GenericGenerator(strategy="uuid",name="uuid")
	@GeneratedValue(generator="uuid")
	private String id;
	private String baseName;
	@JsonIgnore
	@OneToMany(mappedBy="base",cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	private Set<Item> addrs = new HashSet<Item>();
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBaseName() {
		return baseName;
	}
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}
	public Set<Item> getAddrs() {
		return addrs;
	}
	public void setAddrs(Set<Item> addrs) {
		this.addrs = addrs;
	}
	public Base(String id, String baseName, Set<Item> addrs) {
		super();
		this.id = id;
		this.baseName = baseName;
		this.addrs = addrs;
	}
	public Base() {
		super();
	}
	
}

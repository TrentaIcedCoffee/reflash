package reflash.entry;

import java.lang.Long;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Entry {
	@Id
	@GeneratedValue
	private Long id;
	private String key;
	private String val;

	public Entry() {
	}

	public Entry(String key, String val) {
		super();
		this.key = key;
		this.val = val;
	}

	public Long getId() {
		return this.id;
	}

	public String getKey() {
		return this.key;
	}

	public void setkey(String key) {
		this.key = key;
	}

	public String getVal() {
		return this.val;
	}

	public void setVal(String val) {
		this.val = val;
	}
}

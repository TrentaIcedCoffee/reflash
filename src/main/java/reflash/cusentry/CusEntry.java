package reflash.cusentry;

// import java.util.Arrays;
// import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "cusentry")
public class CusEntry {
    @Id
    @Column(name = "cusentry_id")
    private String id;
    @Column(name = "cusentry_key")
	private String key;
    @Column(name = "cusentry_value")
	private String value;

    public CusEntry() {

    }

	public CusEntry(String id, String key, String value){
		super();
		this.id = id;
		this.key = key;
		this.value = value;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey() {
		return this.key;
	}

	public void setkey(String key) {
		this.key = key;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

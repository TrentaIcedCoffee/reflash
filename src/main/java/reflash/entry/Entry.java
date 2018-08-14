package reflash.entry;

// import java.util.Arrays;
// import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


public class Entry {
    private String id;
	private String key;
	private String value;

    public Entry() {

    }

	public Entry(String id, String key, String value){
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

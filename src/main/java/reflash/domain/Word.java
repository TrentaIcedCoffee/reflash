package reflash.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("words")
public class Word implements Serializable {
	@PrimaryKey
	@CassandraType(type = DataType.Name.UUID)
	private UUID id;
	private String word;
	private String meaning;
	private Integer contRecog;
	private Boolean isMastered;

	public Word(final String word, final String meaning) {
		super();
		this.id = UUID.randomUUID();
		this.word = word;
		this.meaning = meaning;
		this.contRecog = new Integer(0);
		this.isMastered = new Boolean(false);
	}

	public UUID getId() {
		return this.id;
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMeaning() {
		return this.meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public Integer getContRecog() {
		return this.contRecog;
	}

	public void setContRecog(Integer contRecog) {
		this.contRecog = contRecog;
	}

	public Boolean getIsMastered() {
		return this.isMastered;
	}

	public void setIsMastered(Boolean isMastered) {
		this.isMastered = isMastered;
	}

	public Word join(Word other) {
		if (other.getWord() != null) {
			this.setWord(other.getWord());
		}
		if (other.getMeaning() != null) {
			this.setMeaning(other.getMeaning());
		}
		if (other.getContRecog() != null) {
			this.setContRecog(other.getContRecog());
		}
		if (other.getIsMastered() != null) {
			this.setIsMastered(other.getIsMastered());
		}
		return this;
	}
}

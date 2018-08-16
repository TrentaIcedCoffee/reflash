package reflash.word;

import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Word {
    @Id
    @GeneratedValue
    private Long id;
    private String word = "";
    private String meaning = "";
    private Integer contRecog = new Integer(0);
    private Boolean isMastered = new Boolean(false);

    public Word() {
        super();
    }

    public Long getId() {
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

    public void join(Word other) {
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
    }
}

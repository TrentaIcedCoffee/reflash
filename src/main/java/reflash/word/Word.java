package reflash.word;

import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Word {
    @Id
    @GeneratedValue
    private Long id;
    private String word;
    private String meaning;
    private Integer contRecog;
    private Boolean isMastered;

    public Word() {
        super();
        this.contRecog = new Integer(0);
        this.isMastered = new Boolean(false);
    }

    public Word(String word, String meaning) {
        super();
        this.word = word;
        this.meaning = meaning;
        this.contRecog = new Integer(0);
        this.isMastered = new Boolean(false);
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
}

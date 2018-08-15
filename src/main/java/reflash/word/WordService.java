package reflash.word;

import java.lang.Long;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class WordService {
	@Autowired
	private WordRepository wordRepository;

	public List<Word> findAllWords() {
		List<Word> words = new ArrayList<>();
        this.wordRepository.findAll().forEach(words::add);
        return words;
	}

    public Word addWord(Word word) {
        return this.wordRepository.save(word);
    }

	public Word findById(Long id) {
		return this.wordRepository.findById(id).get();
	}

    public List<Word> findAllLearningWords() {
        return this.wordRepository.findByIsMastered(new Boolean(false));
    }

    public Word findByWord(String word) {
        return this.wordRepository.findByWord(word);
    }

	public Word findByMeaning(String meaning) {
		return this.wordRepository.findByMeaning(meaning);
	}

    public Word updateWord(Word word) {
        return this.wordRepository.save(word);
    }

	public Word deleteById(Long id) {
		Word res = this.wordRepository.findById(id).get();
		this.wordRepository.deleteById(id);
		return res;
	}

    public Word deleteWordByWord(String word) {
		Word wordRes = this.wordRepository.findByWord(word);
		this.wordRepository.deleteById(wordRes.getId());
        return wordRes;
    }
}

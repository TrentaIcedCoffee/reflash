package reflash.word;

import java.lang.Long;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

// TODO exceptions

@RestController
public class WordController {
    @Autowired
    private WordRepository wordRepository;

    @RequestMapping(method=RequestMethod.GET, value="/words")
    public List<Word> findAllWords() {
        List<Word> words = new ArrayList<>();
        this.wordRepository.findAll().forEach(words::add);
        return words;
    }

    @RequestMapping(method=RequestMethod.POST, value="/words")
    public Word addWord(@RequestBody Word word) {
        return this.wordRepository.save(word);
    }

    @RequestMapping(method=RequestMethod.GET, value="/words/{id}")
    public Word findWordById(@PathVariable Long id) {
        try {
            Word word = this.wordRepository.findById(id).get();
            return word;
        } catch (NoSuchElementException e) {
            return e.toString();
        }
    }

    @RequestMapping(method=RequestMethod.PUT, value="/words/{id}")
    public Word updateWordById(@PathVariable Long id, @RequestBody Word word) {
        return this.wordRepository.save(word); // TODO impl object join
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/words/{id}")
    public Word deleteWordById(@PathVariable Long id) {
        Word word = this.wordRepository.findById(id).get();
        this.wordRepository.deleteById(id);
        return word;
    }

    @RequestMapping(method=RequestMethod.GET, value="/words/word/{word}")
    public Word findWordByWord(@PathVariable String word) {
        return this.wordRepository.findByWord(word);
    }

    @RequestMapping(method=RequestMethod.GET, value="/words/meaning/{meaning}")
    public Word findWordByMeaning(@PathVariable String meaning) {
        return this.wordRepository.findByMeaning(meaning);
    }

    @RequestMapping(method=RequestMethod.GET, value="/words/learning")
    public List<Word> findAllLearningWords() {
        return this.wordRepository.findByIsMastered(new Boolean(false));
    }
}

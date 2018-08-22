package reflash.controllers;

import java.lang.Long;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;

import reflash.domain.Word;
import reflash.repositories.WordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {
	private WordRepository wordRepository;

	@Autowired
	public void setWordRepository(WordRepository wordRepository) {
		this.wordRepository = wordRepository;
	}

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
	public Word findWordById(@PathVariable String id) {
		return this.wordRepository.findById(UUID.fromString(id)).get();
	}

	@RequestMapping(method=RequestMethod.PUT, value="/words/{id}")
	public Word updateWordById(@PathVariable String id, @RequestBody Word word) {
		Word wordOld = this.wordRepository.findById(UUID.fromString(id)).get();
		Word wordNew = wordOld.join(word);
		this.wordRepository.save(wordNew);
		return wordNew;
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/words/{id}")
	public Word deleteWordById(@PathVariable String id) {
		Word word = this.wordRepository.findById(UUID.fromString(id)).get();
		this.wordRepository.deleteById(UUID.fromString(id));
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

package reflash.repositories;

import java.util.List;
import java.util.UUID;

import reflash.domain.Word;

import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<Word, UUID> {
	List<Word> findByIsMastered(Boolean isMastered);
	Word findByMeaning(String meaning);
	Word findByWord(String word);
}

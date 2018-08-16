package reflash.word;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<Word, Long> {
    List<Word> findByIsMastered(Boolean isMastered);
    Word findByMeaning(String meaning);
    Word findByWord(String word);
}

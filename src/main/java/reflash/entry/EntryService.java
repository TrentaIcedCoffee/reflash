package reflash.entry;

import java.util.ArrayList;
import java.util.List;
import java.lang.Long;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EntryService {
	@Autowired
	private EntryRepository entryRepository;

	public List<Entry> getAllEntries() {
		List<Entry> entries = new ArrayList<>();
		this.entryRepository.findAll().forEach(entries::add);
		return entries;
	}

	public Entry getEntry(Long id) {
		return this.entryRepository.findById(id).get();
	}

	public void addEntry(Entry entry) {
		this.entryRepository.save(entry);
	}

	public void updateEntry(Long id, Entry entry) {
		this.entryRepository.save(entry);
	}

	public void deleteEntry(Long id) {
		this.entryRepository.deleteById(id);
	}
}

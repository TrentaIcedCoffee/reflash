package reflash.entry;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EntryService {
	private List<Entry> entries = new ArrayList<>(Arrays.asList(
							      new Entry("0", "one", "1"),
							      new Entry("1", "two", "2"),
							      new Entry("2", "three", "3")));

	public List<Entry> getAllEntries() {
		return entries;
	}

	public Entry getEntry(String id) {
		return this.entries.stream().filter(e -> e.getId().equals(id)).findFirst().get();
	}

	public void addEntry(Entry entry) {
		entries.add(entry);
	}

	public void updateEntry(String id, Entry entry) {
		for (int i = 0; i < this.entries.size(); i++) {
			Entry e = this.entries.get(i);
			if (e.getId().equals(id)) {
				this.entries.set(i, entry);
				return;
			}
		}
	}

	public void deleteEntry(String id) {
		this.entries.removeIf(e -> e.getId().equals(id));
	}
}

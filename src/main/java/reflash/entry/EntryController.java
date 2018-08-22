package reflash.entry;

import java.lang.Long;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntryController {
	@Autowired
	private EntryService entryService;

	@RequestMapping("/entries")
	public List<Entry> getAllEntries() {
		return this.entryService.getAllEntries();
	}

	@RequestMapping("/entries/{id}")
	public Entry getEntry(@PathVariable Long id) {
		return this.entryService.getEntry(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/entries")
	public void addEntry(@RequestBody Entry entry) {
		this.entryService.addEntry(entry);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/entries/{id}")
	public void addEntry(@PathVariable Long id, @RequestBody Entry entry) {
		this.entryService.updateEntry(id, entry);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/entries/{id}")
	public void deleteEntry(@PathVariable Long id) {
		this.entryService.deleteEntry(id);
	}
}

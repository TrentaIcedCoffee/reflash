package reflash.cusentry;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class CusEntryController {
	@Autowired
	private CusEntryService entryService;

	@RequestMapping("/cusentries")
	public List<CusEntry> getAllEntries() {
		return this.entryService.getAllEntries();
	}

	@RequestMapping("/cusentries/{id}")
	public CusEntry getCusEntry(@PathVariable String id) {
		return this.entryService.getCusEntry(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/cusentries")
	public void addCusEntry(@RequestBody CusEntry cusEntry) {
		this.entryService.addCusEntry(cusEntry);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/cusentries/{id}")
	public void addCusEntry(@PathVariable String id, @RequestBody CusEntry cusEntry) {
		this.entryService.updateCusEntry(id, cusEntry);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/cusentries/{id}")
	public void deleteCusEntry(@PathVariable String id) {
		this.entryService.deleteCusEntry(id);
	}
}

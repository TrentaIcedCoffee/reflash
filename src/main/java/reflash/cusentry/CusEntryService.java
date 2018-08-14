package reflash.cusentry;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CusEntryService {
	@Autowired
	private CusEntryRepository cusEntryRepository;

	public List<CusEntry> getAllEntries() {
		List<CusEntry> cusEntries = new ArrayList<>();
		this.cusEntryRepository.findAll().forEach(cusEntries::add);
		return cusEntries;
	}

	public CusEntry getCusEntry(String id) {
		return this.cusEntryRepository.findById(id).get();
	}

	public void addCusEntry(CusEntry cusEntry) {
		this.cusEntryRepository.save(cusEntry);
	}

	public void updateCusEntry(String id, CusEntry cusEntry) {
		this.cusEntryRepository.save(cusEntry);
	}

	public void deleteCusEntry(String id) {
		this.cusEntryRepository.deleteById(id);
	}
}

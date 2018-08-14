package reflash.entry;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class EntryController {

    @RequestMapping("/entries")
    public List<Entry> getAllEntries() {
        return Arrays.asList(
            new Entry("0", "one", "1"),
            new Entry("1", "two", "2"),
            new Entry("2", "three", "3")
        );
    }

}

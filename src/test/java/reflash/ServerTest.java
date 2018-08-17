package reflash;

import reflash.Server;
import reflash.word.WordController;
import reflash.word.Word;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Server.class)
@WebAppConfiguration
public class ServerTest {
	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

	@Before
	public void setUp() throws Exception {
		this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void ping() throws Exception {
		this.mvc.perform(get("/ping")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
            		.andDo(print())
            		.andExpect(MockMvcResultMatchers.content().string("pong"));
	}

    @Test
    public void words() throws Exception {
        this.mvc.perform(get("/words").accept(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(print())
                    .andExpect(jsonPath("$", hasSize(0)));

        Word sampleWord = new Word("junit4", "unitTest");
        // POST
        MvcResult mvcResult = this.mvc.perform(post("/words")
                                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                                .content(this.objectMapper.writeValueAsString(sampleWord))
                                                .accept(MediaType.APPLICATION_JSON))
                                        .andExpect(MockMvcResultMatchers.status().isOk())
                                		.andDo(print())
                                        .andExpect(jsonPath("$.id").exists())
                                        .andExpect(jsonPath("$.word").value(sampleWord.getWord()))
                                        .andExpect(jsonPath("$.meaning").value(sampleWord.getMeaning()))
                                        .andExpect(jsonPath("$.contRecog").value(sampleWord.getContRecog()))
                                        .andExpect(jsonPath("$.isMastered").value(sampleWord.getIsMastered()))
                                        .andReturn();
        String json = mvcResult.getResponse().getContentAsString();
        Long id = objectMapper.readValue(json, Word.class).getId();
        // PUT
        sampleWord.setMeaning("testUnit");
        this.mvc.perform(put("/words/" + id)
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content("{\"meaning\": \"testUnit\"}")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(print())
                    .andExpect(jsonPath("$.id").value(id))
                    .andExpect(jsonPath("$.word").value(sampleWord.getWord()))
                    .andExpect(jsonPath("$.meaning").value(sampleWord.getMeaning()))
                    .andExpect(jsonPath("$.contRecog").value(sampleWord.getContRecog()))
                    .andExpect(jsonPath("$.isMastered").value(sampleWord.getIsMastered()));
        // GET
        this.mvc.perform(get("/words/" + id)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(print())
                    .andExpect(jsonPath("$.id").value(id))
                    .andExpect(jsonPath("$.word").value(sampleWord.getWord()))
                    .andExpect(jsonPath("$.meaning").value(sampleWord.getMeaning()))
                    .andExpect(jsonPath("$.contRecog").value(sampleWord.getContRecog()))
                    .andExpect(jsonPath("$.isMastered").value(sampleWord.getIsMastered()));
        // DELETE
        this.mvc.perform(delete("/words/" + id)
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(print())
                    .andExpect(jsonPath("$.id").value(id))
                    .andExpect(jsonPath("$.word").value(sampleWord.getWord()))
                    .andExpect(jsonPath("$.meaning").value(sampleWord.getMeaning()))
                    .andExpect(jsonPath("$.contRecog").value(sampleWord.getContRecog()))
                    .andExpect(jsonPath("$.isMastered").value(sampleWord.getIsMastered()));
    }
}

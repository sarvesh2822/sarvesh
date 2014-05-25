package assign2.ngram;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class NGramStoreTest {

	NGramStore nStore;
	String context = "be or not to";
	String[] words = { "be", "or", "not", "to" };
	String[] predictions = { "be", "mention", "exceed", "say", "the" };
	Double[] probabilities = { 0.182345, 0.092678, 0.061200, 0.031654, 0.021144 };
	//private Map<String, NGramContainer> model = new HashMap<String, NGramContainer>();

	@Before
	public void setUp() throws NGramException {
		nStore = new NGramStore();
		nStore.getNGramsFromService("be or not to", 5);
	}

	@Test
	public void getNGramFromServiceTest() throws NGramException {
		boolean testTrue = nStore.getNGramsFromService("be or not to ", 5);
		assertEquals(true, testTrue);
	}

	@Test
	public void getNGramTest() throws NGramException {
		NGramContainer node = nStore.getNGram(context);
		assertEquals("be or not to", node.getContext());
	}

}

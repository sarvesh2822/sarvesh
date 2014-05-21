package assign2.ngram;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NGramNodeTest {

	NGramNode nGram;
	String context = "be or not to";
	String[] words = {"to", "be", "or", "not"};
	String[] predictions = {"my", "home", "come", "here", "to"};
	Double[] probabilities = {0.123456, 0.038926, 0.028956, 0.021325, 0.021998};

	@Before
	public void initilialize() throws NGramException {
		nGram = new NGramNode(context, predictions, probabilities);
	}

	// ---------------------------------------------------------------//
	@Test
	public void getContextTest() {

		assertEquals("be or not to", nGram.getContext());
	}

	@Test
	public void setContextTest() throws NGramException {
		nGram.setContext("new String Test");
		assertEquals("new String Test", nGram.getContext());
	}

	// ---------------------------------------------------------------//

	@Test
	public void getPredictionsTest() {
		assertArrayEquals(predictions, nGram.getPredictions());
	}

	@Test
	public void setPredictionsTest() throws NGramException {
		String[] testPredict = { "this", "is", "prediction" };
		nGram.setPredictions(testPredict);
		assertArrayEquals(testPredict, nGram.getPredictions());

	}

	// ---------------------------------------------------------------//

	@Test
	public void getProbabilitiesTest() {
		assertArrayEquals(probabilities, nGram.getProbabilities());
	}

	@Test
	public void setProbabilitiesTest() throws NGramException {
		Double[] testProb = { 0.1234, 0.3245, 0.9876 };
		nGram.setProbabilities(testProb);
		assertArrayEquals(testProb, nGram.getProbabilities());
	}

}

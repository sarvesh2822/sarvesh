package assign2.ngram;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NGramNodeTest {

	NGramNode nGram;
	String context = "be or not to";
	String[] words = { "to", "be", "or", "not" };
	String[] predictions = { "my", "home", "come", "here", "to" };
	Double[] probabilities = { 0.123456, 0.038926, 0.028956, 0.021325, 0.020998 };

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

	@Test(expected = NGramException.class)
	public void setContextNullTest() throws NGramException {
		String nullTest = null;
		nGram.setContext(nullTest);
		assertEquals(null, nGram.getContext());
	}

	@Test(expected = NGramException.class)
	public void setContextEmptyTest() throws NGramException {
		String emptyTest = " ";
		nGram.setContext(emptyTest);
		assertEquals(" ", nGram.getContext());
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

	@Test(expected = NGramException.class)
	public void setPredictionNullTest() throws NGramException {
		String[] testPredictions = null;
		nGram.setPredictions(testPredictions);
		assertArrayEquals(null, nGram.getPredictions());
	}

	@Test(expected = NGramException.class)
	public void setPredictionEmptyPredictionTest() throws NGramException {
		String[] testPredictions = { " ", "to" };
		nGram.setPredictions(testPredictions);
		assertEquals(" ", "to", nGram.getPredictions());
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

	@Test(expected = NGramException.class)
	public void setProbabilitiesNullTest() throws NGramException {
		Double[] testProbabilities = null;
		nGram.setProbabilities(testProbabilities);

	}

	@Test(expected = NGramException.class)
	public void setProbabilitiesInvalidProbabilitiesTest()
			throws NGramException {
		Double[] testProbabilities = { 1.5, -2.8 };
		nGram.setProbabilities(testProbabilities);
	}

	// ---------------------------------------------------------------//

	@Test
	public void setContextArrayTest() throws NGramException {
		String[] stringArray = { "to", "the", "end" };
		nGram.setContext(stringArray);
		assertEquals("to the end ", nGram.getContextPhrase(stringArray));

	}

	@Test(expected = NGramException.class)
	public void setContextArrayNullTest() throws NGramException {
		String[] stringNull = null;
		nGram.setContext(stringNull);
		assertEquals(null, nGram.getContextPhrase(stringNull));
	}

	// ---------------------------------------------------------------//

}

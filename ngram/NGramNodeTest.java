package assign2.ngram;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

import org.junit.Before;
import org.junit.Test;

public class NGramNodeTest {

	private NGramNode nGram;
	private String context = "be or not to";
	private String[] words = { "to", "be", "or", "not" };
 	private String[] predictions = { "my", "home", "come", "here", "to" };
	private Double[] probabilities = { 0.123456, 0.038926, 0.028956, 0.021325, 0.020998 };
	private NGramNode toTest;
	private NGramNode nGramNode;

	@Before
	public void initilialize() throws NGramException {
		nGram = new NGramNode(context, predictions, probabilities);
		nGramNode = new NGramNode(words, predictions, probabilities);
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
	public void wordsConstructorPredictionsEmptyTest() throws NGramException {
		String[] testPredictArray = {};
		NGramNode testnode = new NGramNode(words, testPredictArray, probabilities);
		assertEquals("", testnode.getContextPhrase(testPredictArray));
	}

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
	
	
	@Test
	(expected=NGramException.class)
	public void constructorProbabilitiesContainsZeroTest() throws NGramException {
		Double[] testDouble = {};
		NGramNode testnode = new NGramNode(context, predictions, testDouble);
		testnode.setProbabilities(testDouble);
		assertEquals("", testnode.getProbabilities());
	}
	
	


	
	
	
	
	
	// ---------------------------------------------------------------//
	@Test (expected=NullPointerException.class )
	public void wordsConstructorNullTest() throws NGramException {
		String[] testWords = null;
		NGramNode testnode = new NGramNode(testWords, predictions, probabilities);
		assertEquals(null, testnode.getContextPhrase(testWords));
	}

	// For the requirement provided
	@Test
	public void NoExtraPublicMethods() {
		// Extends Object, implements NGramContainer
		final int toStringCount = 1;
		final int NumObjectClassMethods = Array.getLength(Object.class
				.getMethods());
		final int NumInterfaceMethods = Array.getLength(NGramContainer.class
				.getMethods());
		final int NumNGramNodeClassMethods = Array.getLength(NGramNode.class
				.getMethods());
		assertTrue(
				"obj:" + NumObjectClassMethods + ":inter:"
						+ NumInterfaceMethods + " - 1 (toString()) = class:"
						+ NumNGramNodeClassMethods,
				(NumObjectClassMethods + NumInterfaceMethods - toStringCount) == NumNGramNodeClassMethods);
	}

	@Test
	public void NoExtraPublicFields() {
		// Extends Object, implements NGramContainer
		final int NumObjectClassFields = Array.getLength(Object.class
				.getFields());
		final int NumInterfaceFields = Array.getLength(NGramContainer.class
				.getFields());
		final int NumNGramNodeClassFields = Array.getLength(NGramNode.class
				.getFields());
		assertTrue(
				"obj + interface = class",
				(NumObjectClassFields + NumInterfaceFields) == NumNGramNodeClassFields);
	}

	@Test
	public void NoExtraPublicConstructors() {
		// Extends Object, implements NGramContainer
		final int ExtraConsCount = 1;
		final int NumObjectClassConstructors = Array.getLength(Object.class
				.getConstructors());
		final int NumInterfaceConstructors = Array
				.getLength(NGramContainer.class.getConstructors());
		final int NumNGramNodeClassConstructors = Array
				.getLength(NGramNode.class.getConstructors());
		assertTrue(
				"obj:" + NumObjectClassConstructors + ":inter:"
						+ NumInterfaceConstructors + " 1 (extra) = class:"
						+ NumNGramNodeClassConstructors,
				(NumObjectClassConstructors + NumInterfaceConstructors + ExtraConsCount) == NumNGramNodeClassConstructors);
	}

	@Test

    public void TOSTRING_ComplexObject() throws NGramException {

             DecimalFormat df = new DecimalFormat(NGramContainer.DecFormat);

             String test = "be or not to | be : 0.136059\n" + "be or not to | mention : 0.066563\n" +

                                       "be or not to | exceed : 0.032759\n" + "be or not to | say : 0.028824\n" +

                                       "be or not to | the : 0.024524\n";

             toTest.setContext("be or not to");

             toTest.setPredictions(new String[]{"be","mention","exceed","say","the"});

             toTest.setProbabilities(new Double[]{0.13605912332,0.066563234345,0.03275912314,0.028823899932,0.0245242343});

             String str = toTest.toString();

          assertEquals(test,str);

    }

}

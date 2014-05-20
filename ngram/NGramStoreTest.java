package assign2.ngram;

import static org.junit.Assert.*;

import java.lang.reflect.Array;

import org.junit.Before;
import org.junit.Test;

public class NGramStoreTest {

	private NGramStore nStore;
	private String context = "be or not to";
	private String[] words = { "be", "or", "not", "to" };
	private String[] predictions = { "be", "mention", "exceed", "say", "the" };
	private Double[] probabilities = { 0.182345, 0.092678, 0.061200, 0.031654, 0.021144 };

	// private Map<String, NGramContainer> model = new HashMap<String,
	// NGramContainer>();

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

	
	
	
	

	// ------------Provided test -------------------
	@Test
	public void NoExtraPublicMethods() {
		// Extends Object, implements NGramMap
		final int toStringCount = 1;
		final int NumObjectClassMethods = Array.getLength(Object.class
				.getMethods());
		final int NumInterfaceMethods = Array.getLength(NGramMap.class
				.getMethods());
		final int NumNGramStoreClassMethods = Array.getLength(NGramStore.class
				.getMethods());
		assertTrue(
				"obj:" + NumObjectClassMethods + ":inter:"
						+ NumInterfaceMethods + " - 1 (toString()) = class:"
						+ NumNGramStoreClassMethods,
				(NumObjectClassMethods + NumInterfaceMethods - toStringCount) == NumNGramStoreClassMethods);
	}

	@Test
	public void NoExtraPublicFields() {
		// Extends Object, implements NGramMap
		final int NumObjectClassFields = Array.getLength(Object.class
				.getFields());
		final int NumInterfaceFields = Array.getLength(NGramMap.class
				.getFields());
		final int NumNGramStoreClassFields = Array.getLength(NGramStore.class
				.getFields());
		assertTrue(
				"obj + interface = class",
				(NumObjectClassFields + NumInterfaceFields) == NumNGramStoreClassFields);
	}

	@Test
	public void NoExtraPublicConstructors() {
		// Extends Object, implements NGramMap
		final int NumObjectClassConstructors = Array.getLength(Object.class
				.getConstructors());
		final int NumInterfaceConstructors = Array.getLength(NGramMap.class
				.getConstructors());
		final int NumNGramStoreClassConstructors = Array
				.getLength(NGramStore.class.getConstructors());
		assertTrue(
				"obj:" + NumObjectClassConstructors + ":inter:"
						+ NumInterfaceConstructors + " = class:"
						+ NumNGramStoreClassConstructors,
				(NumObjectClassConstructors + NumInterfaceConstructors) == NumNGramStoreClassConstructors);
	}

}

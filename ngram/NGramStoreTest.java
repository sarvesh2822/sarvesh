package assign2.ngram;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.microsoft.research.webngram.service.exception.NgramServiceException;

public class NGramStoreTest {

	private NGramStore nStore;
	private String context = "be or not to";
	private String[] words = { "be", "or", "not", "to" };
	private String[] predictions = { "be", "mention", "exceed", "say", "the" };
	private Double[] probabilities = { 0.182345, 0.092678, 0.061200, 0.031654, 0.021144 };

	// private Map<String, NGramContainer> model = new HashMap<String,
	// NGramContainer>();

	private Map<String, NGramContainer> 
	model = new HashMap<String, NGramContainer>();
	
	@Before
	public void setUp() throws NGramException {
		nStore = new NGramStore();
		nStore.getNGramsFromService("be or not to", 5);
	}
	@Test 
	public void addNGramTest(){ 
		NGramContainer node = nStore.getNGram(context); 
		model.put(context, node); assertTrue(model.containsKey(context)); }
	
	@Test public void removeNGramTest(){ 
		NGramContainer node = nStore.getNGram(context); nStore.addNGram(node);
		model.remove(node); //model.hash assertEquals(false,model.containsKey(node)); }
	
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
	
	@Test (expected = NgramServiceException.class)
		public void getNGramsFromServiceNullTest() throws NGramException {
		boolean testFalse = nStore.getNGramsFromService(null, 5);
		assertEquals(false, testFalse);
	}
	
	
	@Test (expected = NgramServiceException.class)
	public void getNGramsFromServiceReturnEmptyStringTest() throws NGramException {
	boolean testFalse = nStore.getNGramsFromService("", 5);
	assertEquals(false, testFalse);
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

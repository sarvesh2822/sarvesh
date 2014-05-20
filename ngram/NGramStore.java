package assign2.ngram;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import assign2.examples.ngram.SimpleNGramGenerator;

import com.microsoft.research.webngram.service.GenerationService;
import com.microsoft.research.webngram.service.NgramServiceFactory;
import com.microsoft.research.webngram.service.GenerationService.TokenSet;

public class NGramStore implements NGramMap {

	private static final String Key = "068cc746-31ff-4e41-ae83-a2d3712d3e68";
	//private static final String DefaultContext = "My hovercraft is full";

	private Map<String, NGramContainer> model;

	public NGramStore() {
		if (model == null) {
			model = new HashMap<String, NGramContainer>();
		}
	}

	@Override
	public void addNGram(NGramContainer ngram) {
		model.put(ngram.getContext(), ngram);

	}

	@Override
	public void removeNGram(String context) {
		model.remove(context);

	}

	@Override
	public NGramContainer getNGram(String context) {

		if (model.get(context) != null) {
			return model.get(context);
		}
		return null;
	}

	@Override
	public boolean getNGramsFromService(String context, int maxResults) throws NGramException {
		
		NgramServiceFactory factory = NgramServiceFactory.newInstance(NGramStore.Key);
		GenerationService service = factory.newGenerationService();

		TokenSet tokenSet = service.generate(NGramStore.Key,"bing-body/2013-12/5", context, maxResults, null);
		//System.out.println(tokenSet.getWords());
		if (tokenSet.getProbabilities().size() == 0) {
			return false;
		}

		List<Double> logProbs = tokenSet.getProbabilities();

		int resultSize = tokenSet.getWords().size();
		
		Double[] probs = new Double[resultSize];
		String[] predictions = new String[resultSize];

		for (int i = 0; i < resultSize; i++) {
			predictions[i] = tokenSet.getWords().get(i);
			probs[i] = Math.pow(10.0, logProbs.get(i));
		}

		NGramContainer nGramContainer = new NGramNode(context, predictions,probs);
		model.put(context, nGramContainer);
		return true;
	}

	
	@Override
	public String toString() {
		String str = "";
		for (String context : model.keySet()) {
			str += model.get(context) + "\n";
		}

		return str;
	}

}

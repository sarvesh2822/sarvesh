package assign2.ngram;

public class NGramNode implements NGramContainer {

	private String context;
	private String[] predictions;
	private Double[] probabilities;

	public NGramNode(String context, String[] predictions,
			Double[] probabilities) throws NGramException {
		this.context = context;
		this.predictions = predictions;
		this.probabilities = probabilities;
	}

	public NGramNode(String[] words, String[] predictions,
			Double[] probabilities) throws NGramException {
		if (words.length > 0) {
			this.context = getContextPhrase(words);
		}
		this.predictions = predictions;
		this.probabilities = probabilities;

	}

	@Override
	public String getContext() {

		return this.context;
	}

	@Override
	public void setContext(String context) throws NGramException {
		if (context == null || context == " ") {
			throw new NGramException("Context is null or empty");
		}
		this.context = context;

	}

	@Override
	public void setContext(String[] words) throws NGramException {
		if (words == null || words.length == 0) {
			throw new NGramException("Words is empty or null");
		}
		this.context = getContextPhrase(words);

	}

	// Getting the context from the words array appending it and returning it as
	// a merged string
	public String getContextPhrase(String[] words) {
		if (words != null) {
			StringBuilder sb = new StringBuilder();
			for (String s : words) {
				sb.append(s)
				.append(" ");
			}
			return sb.toString();
		} else
			return " ";
	}

	@Override
	public String[] getPredictions() {

		return this.predictions;
	}

	@Override
	public void setPredictions(String[] predictions) throws NGramException {
		if (predictions == null || predictions.length == 0
				|| emptyPrediction(predictions, " ")) {
			throw new NGramException("Prediction not valid ");
		}
		this.predictions = predictions;

	}

	// method created to check the exception conditions.
	public boolean emptyPrediction(String[] predict, String empty) {
		for (String s : predict) {
			if (s == empty)
				return true;
		}
		return false;
	}

	@Override
	public Double[] getProbabilities() {

		return this.probabilities;
	}

	@Override
	public void setProbabilities(Double[] probabilities) throws NGramException {
		if (probabilities == null || probabilities.length == 0
				|| invalidProbability(probabilities)) {
			throw new NGramException("Invalid probability");
		}
		this.probabilities = probabilities;

	}

	// method for checking exception condition
	public boolean invalidProbability(Double[] invalidProb) {
		for (Double d : invalidProb) {
			if (d <= 0 || d > 1) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < getPredictions().length; i++) {
			str += getContext() + " | " + getPredictions()[i] + " : "
					+ getProbabilities()[i] +"\n";
		}

		/*String test = "be or not to | be : 0.136059\n"
				+ "be or not to | mention : 0.066563\n"
				+ "be or not to | exceed : 0.032759\n"
				+ "be or not to | say : 0.028824\n"
				+ "be or not to | the : 0.024524\n";
		 * 
		 */
		return str;
	}

}

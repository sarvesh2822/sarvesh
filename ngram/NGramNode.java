package assign2.ngram;

public class NGramNode implements NGramContainer {

	private String context;
	private String[] predictions;
	private Double[] probabilities;
	
	public NGramNode(String context, String[] predictions, Double[] probabilities)throws NGramException {
		this.context = context;
		this.predictions = predictions;
		this.probabilities = probabilities;
	}
	
	public NGramNode(String[] words, String[] predictions, Double[] probabilities)throws NGramException{
		
		
	}

	@Override
	public String getContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContext(String context) throws NGramException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContext(String[] words) throws NGramException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getPredictions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPredictions(String[] predictions) throws NGramException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double[] getProbabilities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProbabilities(Double[] probabilities) throws NGramException {
		// TODO Auto-generated method stub
		
	}

}

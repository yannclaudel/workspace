package quizz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.stream.Collectors;
//gggg
public class Quizz {
	private List<Question> all = new ArrayList<>();
	private Stack<Question> current = null;
	private Question cq = null;
	private int currentScore = 0;

	public List<Question> getAll() {
		return all;
	}

	public void setAll(List<Question> all) {
		this.all = all;
	}

	public void generateQuizz(String cat, int number) {
		currentScore = 0;
		current = new Stack<Question>();
		List<Question> lsa = all.stream().filter(q -> cat == null || cat.equals(q.getCat()))
				.collect(Collectors.toList());
		Random r = new Random();
		for (int i = 0; i < number && !lsa.isEmpty(); i++) {
			int ii = r.nextInt(lsa.size());
			Question q = lsa.get(ii);
			current.push(q);
			lsa.remove(ii);
		}
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}

	public double getScore() {
		if (all == null || all.size() == 0)
			return 0;
		long score = all.stream().filter(q -> q.isSuccess()).count();
		return score / all.size();
	}

	public double getRatioDone() {
		if (all == null || all.size() == 0)
			return 0;
		double score = all.stream().filter(q -> q.isAnswered()).count();
		return score / all.size();
	}

	public boolean isQuizzFinished() {
		if (current == null)
			return true;
		return current.isEmpty();
	}

	public Question getNextQuestion() {
		if (current == null || current.isEmpty())
			return null;
		cq = current.pop();
		return cq;
	}

	public boolean submitCurrentQuestion(int answer) {
		if (cq == null)
			return false;
		boolean rtn = cq.submit(answer);
		if (rtn)
			currentScore++;
		return rtn;
	}
}

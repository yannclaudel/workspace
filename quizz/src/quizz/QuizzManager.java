package quizz;

import java.util.ArrayList;
import java.util.List;

import persistence.ObjectPersistence;

public class QuizzManager {
	private static final String KEY = "myQuizz";
	private static volatile QuizzManager instance = null;
	private Quizz quizz = null;

	private QuizzManager() {
	}

	public final static synchronized QuizzManager getInstance() throws ErrorApp {
		if (instance == null)
			instance = new QuizzManager();
		if (instance.quizz == null) {
			instance.quizz = (Quizz) ObjectPersistence.loadObject(KEY);
		}

		if (instance.quizz == null) {
			instance.quizz = initQuizz();
		}
		return instance;
	}

	private static Quizz initQuizz() throws ErrorApp {
		Quizz quizz = new Quizz();

		List<Question> all = new ArrayList<>();
		all.add(new Question(1, "path", "path2", "answertext1", "answertext2", "answertext3", 1, "CAT1", false, false));
		all.add(new Question(2, "path", "path2", "2 answertext1", "2 answertext2", "2answertext3", 1, "CAT2", false,
				false));
		all.add(new Question(3, "path", "path2", "3 answertext1", "3 answertext2", "3answertext3", 1, "CAT3", false,
				false));
		all.add(new Question(4, "path", "path2", "4 answertext1", "4 answertext2", "4answertext3", 1, "CAT4", false,
				false));
		all.add(new Question(5, "path", "path2", "4 answertext1", "4 answertext2", "4answertext3", 1, "CAT4", false,
				false));
		all.add(new Question(6, "path", "path2", "4 answertext1", "4 answertext2", "4answertext3", 1, "CAT4", false,
				false));
		all.add(new Question(7, "path", "path2", "4 answertext1", "4 answertext2", "4answertext3", 1, "CAT4", false,
				false));
		all.add(new Question(8, "path", "path2", "4 answertext1", "4 answertext2", "4answertext3", 1, "CAT4", false,
				false));
		quizz.setAll(all);
		return quizz;
	}

	public Quizz getQuizz() {
		return quizz;
	}

	public void setQuizz(Quizz quizz) {
		this.quizz = quizz;
	}
}

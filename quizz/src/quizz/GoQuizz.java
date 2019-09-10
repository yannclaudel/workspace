package quizz;

public class GoQuizz {

	public static void main(String[] args) {
		try {
			System.out.println(QuizzManager.getInstance().getQuizz().getCurrentScore());
			System.out.println(QuizzManager.getInstance().getQuizz().getRatioDone());
			QuizzManager.getInstance().getQuizz().generateQuizz(null, 3);
			Question q = null; 
			for (int i = 0; i < 10; i++) {
				q = QuizzManager.getInstance().getQuizz().getNextQuestion();
				if (q==null) break;
				System.out.println(q.toString());
				System.out.println(QuizzManager.getInstance().getQuizz().submitCurrentQuestion(1));
				System.out.println(QuizzManager.getInstance().getQuizz().getCurrentScore());
				System.out.println(QuizzManager.getInstance().getQuizz().getRatioDone());
				System.out.println(QuizzManager.getInstance().getQuizz().isQuizzFinished());
			}
			
		} catch (ErrorApp e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
 
package quizz;

public class Question {
	
	private int id = 0;
    private String questionPath = null;
    private String answerPath = null;
    private String answer1Text = null;
    private String answer2Text = null;
    private String answer3Text = null;
    private int answer = -1;
    private String cat = null;
    private boolean answered = false;
    private boolean success = false;
    
    public Question(int id, String questionPath, String answerPath, String answer1Text, String answer2Text,
			String answer3Text, int answer, String cat, boolean answered, boolean success) {
		super();
		this.id = id;
		this.questionPath = questionPath;
		this.answerPath = answerPath;
		this.answer1Text = answer1Text;
		this.answer2Text = answer2Text;
		this.answer3Text = answer3Text;
		this.answer = answer;
		this.cat = cat;
		this.answered = answered;
		this.success = success;
	}

	public boolean submit(int panswer) {
    	this.answered = true;
    	if (panswer==answer) {
    		this.success = true;
    	}
    	else {
    		this.success = false;
    	}
    	return this.success;
    } 

    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestionPath() {
		return questionPath;
	}
	public void setQuestionPath(String questionPath) {
		this.questionPath = questionPath;
	}
	public String getAnswerPath() {
		return answerPath;
	}
	public void setAnswerPath(String answerPath) {
		this.answerPath = answerPath;
	}
	public String getAnswer1Text() {
		return answer1Text;
	}
	public void setAnswer1Text(String answer1Text) {
		this.answer1Text = answer1Text;
	}
	public String getAnswer2Text() {
		return answer2Text;
	}
	public void setAnswer2Text(String answer2Text) {
		this.answer2Text = answer2Text;
	}
	public String getAnswer3Text() {
		return answer3Text;
	}
	public void setAnswer3Text(String answer3Text) {
		this.answer3Text = answer3Text;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public boolean isAnswered() {
		return answered;
	}
	public void setAnswered(boolean answered) {
		this.answered = answered;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", questionPath=" + questionPath + ", answerPath=" + answerPath + ", answer1Text="
				+ answer1Text + ", answer2Text=" + answer2Text + ", answer3Text=" + answer3Text + ", answer=" + answer
				+ ", cat=" + cat + ", answered=" + answered + ", success=" + success + "]";
	}

    
    
}

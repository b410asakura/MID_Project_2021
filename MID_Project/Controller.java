package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Controller {

    @FXML
    private ToggleGroup answers;

    @FXML
    private Text question_text;

    @FXML
    private RadioButton radio_btn_1;

    @FXML
    private RadioButton radio_btn_2;

    @FXML
    private RadioButton radio_btn_3;

    @FXML
    private RadioButton radio_btn_4;

    @FXML
    private Button answerBtn;

    private Questions[] questions = new Questions[] {
            new Questions("Which of the options is the correct format for displaying information on the screen?", new String[] {"Console.Write()", "console.log()", "print()", "System.out.println()"}),
            new Questions("What data type is responsible for integers?", new String[] {"String", "Float", "Boolean", "Integer"}),
            new Questions("Where is correctly assigned a new value to a multidimensional array?", new String[] {"a(0)(0) = 1;", "a[0 0] = 1;", "a{0}{0} = 1;", "a[0][0] = 1;"}),
            new Questions("Which method allows you to run a Java program?", new String[] {"There is no main method", "From the class that was written first and from the methods that are inside it", "Any, it can be set in the project settings", "From the main method in any of the classes"}),
            new Questions("Each file should be called ...", new String[] {"by the name of the first library in it", "by package name", "as you want", "by class name in it"}),
            new Questions("How many parameters can a function take?", new String[] {"5", "10", "20", "unlimited quantity"})
    };

    private int nowQuestion = 0, correctAnswers;
    private String nowCorrectAnswer;

    @FXML
    public void initialize() {
        nowCorrectAnswer = questions[nowQuestion].correctAnswer();

        answerBtn.setOnAction(e -> {
            RadioButton selectedRadioButton = (RadioButton) answers.getSelectedToggle();
            if(selectedRadioButton != null) {
                String toogleGroupValue = selectedRadioButton.getText();

                if(toogleGroupValue.equals(nowCorrectAnswer)) {
                    System.out.println("Correct answer");
                    correctAnswers++;
                } else {
                    System.out.println("Incorrect answer");
                }


                if(nowQuestion + 1 == questions.length) {
                    radio_btn_1.setVisible(false);
                    radio_btn_2.setVisible(false);
                    radio_btn_3.setVisible(false);
                    radio_btn_4.setVisible(false);
                    answerBtn.setVisible(false);

                    question_text.setText("Congratulations!!!\nYou answered correctly to " + correctAnswers + " from " + questions.length + " questions!\nClose the program");

                } else {
                    nowQuestion++;
                    nowCorrectAnswer = questions[nowQuestion].correctAnswer();

                    question_text.setText(questions[nowQuestion].getQuestion());
                    String[] answers = questions[nowQuestion].getAnswers();


                    List<String> intList = Arrays.asList(answers);

                    Collections.shuffle(intList);

                    radio_btn_1.setText(intList.get(0));
                    radio_btn_2.setText(intList.get(1));
                    radio_btn_3.setText(intList.get(2));
                    radio_btn_4.setText(intList.get(3));

                    selectedRadioButton.setSelected(false);
                }

            }
        });
    }

}

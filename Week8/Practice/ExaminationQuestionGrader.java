import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExaminationQuestionGrader {

    abstract static class Question {
        double points;

        Question(double points) {
            this.points = points;
        }

        abstract double grade(String answer, String correctAnswer);
    }

    static class MCQ extends Question {
        MCQ(double points) {
            super(points);
        }

        double grade(String answer, String correctAnswer) {
            return answer.equals(correctAnswer) ? points : 0;
        }
    }

    static class TrueFalse extends Question {
        TrueFalse(double points) {
            super(points);
        }

        double grade(String answer, String correctAnswer) {
            return answer.equals(correctAnswer) ? points : 0;
        }
    }

    static class Essay extends Question {
        Essay(double points) {
            super(points);
        }

        double grade(String answer, String correctAnswer) {
            String[] keywords = correctAnswer.split(",");
            int count = 0;

            for (String keyword : keywords) {
                if (answer.toLowerCase().contains(keyword.trim().toLowerCase())) {
                    count++;
                }
            }

            if (count >= 2) {
                return points * 0.75;
            } else if (count == 1) {
                return points * 0.50;
            }

            return 0;
        }
    }

    static String[] parseLine(String line) {
        ArrayList<String> values = new ArrayList<>();
        Matcher matcher = Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(line);

        while (matcher.find()) {
            values.add(matcher.group(1) != null
                    ? matcher.group(1)
                    : matcher.group(2));
        }

        return values.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            while (line.isEmpty()) {
                line = sc.nextLine().trim();
            }

            String[] input = parseLine(line);

            String type = input[0];
            String correctAnswer = input[2];
            String answer = input[3];
            double points = Double.parseDouble(input[4]);

            Question question;

            switch (type) {
                case "MCQ":
                    question = new MCQ(points);
                    break;
                case "TF":
                    question = new TrueFalse(points);
                    break;
                default:
                    question = new Essay(points);
                    break;
            }

            double score = question.grade(answer, correctAnswer);

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
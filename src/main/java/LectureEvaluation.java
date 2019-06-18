
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class LectureEvaluation implements ViewInterface {

    private int sum;
    private int check;
    private Scanner scanner = new Scanner(System.in);
    private boolean[] checkers = new boolean[4];
    private final String path = "/Users/hongbeom/Workspace/java_Data/project/src/lectureEvaluation.properties";

    //TODO 과목을 선택하는 뷰 & 기능 구현
    void subjectChoice() {
        while (true) {
            saveId();
            System.out.println("==================");
            System.out.println("1. Java");
            System.out.println("2. Algorithm");
            System.out.println("3. OS");
            System.out.println("4. Data");
            System.out.println("5. 종료");
            System.out.println("==================");
            System.out.println("과목을 선택해 주세요 >>");

            try {

                switch (checkerInput()) {
                    case 1:
                        overlapCheck();
                        break;
                    case 2:
                        overlapCheck();
                        break;
                    case 3:
                        overlapCheck();
                        break;
                    case 4:
                        overlapCheck();
                        break;
                    case 5:
                        return;
                    default:
                }
            }catch (InputMismatchException e) {
                System.out.println();
                System.out.println("숫자로 입력해주세요.");
                subjectChoice();
            }
        }
    }

    //TODO 과목 선택에 대한 입력 기능 구현
    private int checkerInput() {
        check = scanner.nextInt();
        return check;
    }

    //TODO 각 과목마다 강의 평가 점수들의 합에 대한 저장 기능 구현
    private void saveService() {
        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream(path);
            props.load(new java.io.BufferedInputStream(fis));

            switch (check) {
                case 1:
                    props.put(ManagementService.getId() + "java점수", Integer.toString(sum));
                    props.store(new FileOutputStream(path), "강의평가");
                    break;
                case 2:
                    props.put(ManagementService.getId() + "algo점수", Integer.toString(sum));
                    props.store(new FileOutputStream(path), "강의평가");
                    break;
                case 3:
                    props.put(ManagementService.getId() + "os점수", Integer.toString(sum));
                    props.store(new FileOutputStream(path), "강의평가");
                    break;
                case 4:
                    props.put(ManagementService.getId() + "data점수", Integer.toString(sum));
                    props.store(new FileOutputStream(path), "강의평가");
                    break;
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    // TODO 과목에 대한 강의 평가 점수 및 아이디를 프로퍼티 파일에 저장하는 기능
    private void LectureEvalautionScoreService() {
        int number = scanner.nextInt();
        if (number > 0 && number <= 5) {
            sum += number;
        } else {
            System.out.println("1~5 사이의 점수를 입력해주세요.");
            LectureEvalautionScoreService();
        }
    }

    //TODO 강의평가 항목에 대한 뷰
    @Override
    public void viewAble() {
        final String[] lectureEvalautionStrings = {
                "1. 교수는 수업준비를 철저하게 하였다.",
                "2. 평가기준 및 방식이 객관적이고 합리적으로 제시되었다.",
                "3. 교수는 열정적으로 강의하였다",
                "4. 교수는 교과내용을 학생들이 이해할 수 있도록 명확하게 설명하였다.",
                "5. 과제는 학습효과를 높이는데 도움이 되었다."};
        sum = 0;
        //점수 합은 0으로 다시 초기화
        System.out.println("1. 전혀 그렇지 않다. 2. 그렇지 않다. 3. 보통이다. 4. 그렇다. 5.매우 그렇다.");
        for (String string : lectureEvalautionStrings) {
            System.out.println(string);
            LectureEvalautionScoreService();
            saveService();
        }
    }

    // TODO 강의평가 설문에 대한 중복 체크 기능
    private void overlapCheck() {
        if (!checkers[check - 1]) {
            viewAble();
            checkers[check - 1] = true;
        } else {
            System.out.println("종료된 설문입니다.");
        }
    }

    //TODO 강의평가를 시작하기 전에 아이디에 대한 정보를 불러와서 저장
    private void saveId() {
        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream(path);
            props.load(new java.io.BufferedInputStream(fis));
            props.store(new FileOutputStream(path), "");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}

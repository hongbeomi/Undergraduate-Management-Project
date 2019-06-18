
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu implements ViewInterface {

    private Score score = new Score();
    private Tuition tuition = new Tuition();
    private LectureEvaluation lectureEvaluation = new LectureEvaluation();

    //TODO 메뉴에 대한 뷰 기능
    @Override
    public void viewAble() {
        Scanner scanner = new Scanner(System.in);

        int number;
        while (true) {
            System.out.println("\n==================");
            System.out.println("메뉴");
            System.out.println("1. 성적관리");
            System.out.println("2. 등록금");
            System.out.println("3. 강의평가");
            System.out.println("4. 종료");
            System.out.println("==================\n");

            System.out.print("선택해주세요 >> ");


            try {
                number = scanner.nextInt();
                System.out.println();

                switch (number) {
                    case 1:
                        score.viewAble();
                        break;
                    case 2:
                        tuition.viewAble();
                        break;
                    case 3:
                        lectureEvaluation.subjectChoice();
                        break;
                    case 4:
                        return;
                    default:
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("숫자로 입력해주세요.");
                viewAble();
            }
        }
    }

}

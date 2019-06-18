
import java.util.ArrayList;

public class Tuition implements ViewInterface {

    private final static int TUITION = 2364000;
    private ArrayList<Double> changeScores = new ArrayList<>();

    //TODO 평균 학점을 구하는 기능
    private double averegeScore() {
        double avgScore;
        double sumScore = 0;

        for (Double changeScore : changeScores) {
            sumScore += (changeScore * 3);
        }

        avgScore = sumScore / 12;
        return avgScore;
    }

    //TODO 점수를 학점으로 바꾸는 기능
    private double changeScoreService(final String subject) {
        double grade;
        int sub = Integer.parseInt(subject);

        grade = sub >= 95 ? 4.5 : (90 <= sub ? 4.0 : (85 <= sub ? 3.5 : (80 <= sub ? 3.0 : (75 <= sub ? 2.5 : (70 <= sub ? 2.0 : 0.0)))));

        return grade;
    }

    //TODO 등록금, 장학금, 실제내야 하는 등록금에 대한 뷰 기능
    @Override
    public void viewAble() {
        changeScores.add(changeScoreService(ManagementService.getJavas()[ManagementService.indexNum]));
        changeScores.add(changeScoreService(ManagementService.getAlgos()[ManagementService.indexNum]));
        changeScores.add(changeScoreService(ManagementService.getOss()[ManagementService.indexNum]));
        changeScores.add(changeScoreService(ManagementService.getDatas()[ManagementService.indexNum]));

        System.out.println("\n==================");
        System.out.println("등록금 : " + TUITION);
        System.out.println("장학금 : " + calculateScholarshipService(averegeScore()));
        System.out.println("총 액  : " + (TUITION - calculateScholarshipService(averegeScore())));
        System.out.println("\n==================");
    }

    //TODO 장학금을 구하는 기능
    private int calculateScholarshipService(final double avgScore) {
        return (int) (avgScore >= 4.0 ? TUITION : (avgScore >= 3.5 ? (TUITION * 0.5) : 0));
    }

}

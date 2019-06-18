
public class Score implements ViewInterface {

    //TODO 점수에 대한 뷰 기능
    @Override
    public void viewAble() {
        System.out.println("[" + ManagementService.getUserNames()[ManagementService.indexNum] + "]\n");
        System.out.println("java : " + ManagementService.getJavas()[ManagementService.indexNum] + "점" + "\t" +
                "학점 : " + calculateScoreService(ManagementService.getJavas()[ManagementService.indexNum]) + "\n");
        System.out.println("Algorithm : " + ManagementService.getAlgos()[ManagementService.indexNum] + "점" + "\t" +
                "학점 : " + calculateScoreService(ManagementService.getAlgos()[ManagementService.indexNum]) + "\n");
        System.out.println("Os : " + ManagementService.getOss()[ManagementService.indexNum] + "점" + "\t" +
                "학점 : " + calculateScoreService(ManagementService.getOss()[ManagementService.indexNum]) + "\n");
        System.out.println("Data : " + ManagementService.getDatas()[ManagementService.indexNum] + "점" + "\t" +
                "학점 : " + calculateScoreService(ManagementService.getDatas()[ManagementService.indexNum]) + "\n");
    }

    //TODO 학점계산 기능
    private String calculateScoreService(final String subject) {
        String grade;
        int sub = Integer.parseInt(subject);

        grade = sub >= 95 ? "A+" : (90 <= sub ? "A" : (85 <= sub ? "B+" : (80 <= sub ? "B" : (75 <= sub ? "C+" : (70 <= sub ? "C" : "F")))));

        return grade;
    }

}

package src;

public class Client {

    public static void main(String[] args) {
        ManagementService managementService = new ManagementService();
        managementService.login();
        // 로그인 서비스 시작

        Menu menu = new Menu();
        menu.viewAble();
        // 메뉴화면 보여주기
    }

}

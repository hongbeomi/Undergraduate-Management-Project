package src;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Scanner;

public class ManagementService extends Member {

    public static int indexNum;

    //TODO 로그인 시 사용자의 이름, 아이디, 비밀번호, 과목점수들을 불러오는 기능
    public void requestLogin() {
        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("/Users/hongbeom/Workspace/java_Data/project/src/client.properties");
            props.load(new java.io.BufferedInputStream(fis));

            setUserId(props.getProperty("id").split(","));
            setUserPass(props.getProperty("password").split(","));
            setUserNames(new String(props.getProperty("name").getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8).split(","));
            setJavas(props.getProperty("java").split(","));
            setAlgos(props.getProperty("algo").split(","));
            setOss(props.getProperty("os").split(","));
            setDatas(props.getProperty("data").split(","));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO 로그인 구현
    public void login() {
        Scanner scanner = new Scanner(System.in);
        boolean ifcheck = false;

        while (true) {
            System.out.print("ID : ");
            setId(scanner.next());
            System.out.print("PASSWORD : ");
            setPassword(scanner.next());

            requestLogin();

            for (int i = 0; i < UserId.length; i++) {
                if (getId().equals(getUserId()[i]) && getPassword().equals(getUserPass()[i])) {
                    System.out.println("[로그인 되었습니다.]");
                    indexNum = i;
                    return;
                } else {
                    ifcheck = true;
                }
            }

            if (ifcheck) {
                System.out.println("[일치하지 않습니다.]");
            }
        }
    }

}

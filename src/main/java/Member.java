class Member {

    static private String id;
    static private String password;
    static String[] UserId;
    static private String[] UserPass;
    static private String[] userNames;
    static private String[] javas;
    static private String[] algos;
    static private String[] oss;
    static private String[] datas;

    //TODO Setter
    static void setId(final String ids) {
        id = ids;
    }

    static void setPassword(final String passwords) {
        password = passwords;
    }

    static void setUserId(final String[] userId) {
        UserId = userId;
    }

    static void setUserPass(final String[] userPass) {
        UserPass = userPass;
    }

    static void setUserNames(final String[] userName) {
        userNames = userName;
    }

    static void setJavas(final String[] java) {
        javas = java;
    }

    static void setAlgos(final String[] algo) {
        algos = algo;
    }

    static void setOss(final String[] os) {
        oss = os;
    }

    static void setDatas(final String[] data) {
        datas = data;
    }


    //TODO Getter
    static String getId() {
        return id;
    }

    static String getPassword() {
        return password;
    }

    static String[] getUserId() {
        return UserId;
    }

    static String[] getUserPass() {
        return UserPass;
    }

    static String[] getUserNames() {
        return userNames;
    }

    static String[] getJavas() {
        return javas;
    }

    static String[] getAlgos() {
        return algos;
    }

    static String[] getOss() {
        return oss;
    }

    static String[] getDatas() {
        return datas;
    }

}

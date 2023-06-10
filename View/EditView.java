package View;

public class EditView {
    public static void printeditView() {
        System.out.println("에딧 모듈 입니다");
        System.out.println("1. 비행기 조회  2. 비행기 추가  3. 비행기 삭제 4. 유저 정보 조회 5. 유저 정보 추가 6.유저 정보 삭제 0. 종료");
    }

    public void printOutLineDevelop() {

    }

    public void printDevelopMenu() {
        System.out.println("=====================[ 개발자 모드 ]=====================");
        System.out.println("1. 비행기 정보 조회  2. 비행기 추가  3. 비행기 삭제");
        System.out.println("4. 유저 정보 조회  5. 유저 추가  6. 유저 삭제  0. 이전 메뉴");
        System.out.println("======================================================");
        System.out.println("번호 입력 >> ");
    }

    public void printAirplaneInfo(int num) {
        if (num == 1) {
            System.out.println("비행기 이름 입력 >> ");
        } else if (num == 2) {
            System.out.println("출발지 입력 >> ");
        } else if (num == 3) {
            System.out.println("도착지 입력 >> ");
        }
    }

    public void printSuccess() {
        System.out.println("성공적으로 완료 되었습니다.");
    }
}

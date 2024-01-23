package mysqltest;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		DB db = new DB();
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("1. 게시물등록");
			System.out.println("2. 게시물목록");
			System.out.println("3. 종료");
			System.out.println("번호 입력하세요");
			
			String input = scan.nextLine();
			
			if (input.equals("1")) {
			    System.out.print("제목: ");
			    String board_title = scan.nextLine();
			    System.out.print("내용: ");
			    String board_contents = scan.nextLine();
			    db.insert(board_title, board_contents);
			}

			else if(input.equals("2")) {
				db.select();
			}
			else {
				System.out.println("종료합니다.");
				break;
			}
		}
		
	}
}

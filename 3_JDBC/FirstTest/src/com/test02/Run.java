package com.test02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {
	Scanner sc = new Scanner(System.in);

	public static int getMenu() {
		int select = 0;
		System.out.println("1. 전체 출력");
		System.out.println("2. 추가하기");
		System.out.println("번호 선택 : ");
		select = new Scanner(System.in).nextInt();
		return select;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException{
//		연결
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/multi", "root", "1234");
		PreparedStatement pstm = null;
		
//		PreparedStatement pstm=con.prepareStatement(sql);
		Run run = new Run();

		int no = 0;
		do {
			no = getMenu();
			switch (no) {
			case 1:
				List<Board> res = run.selectAll();
				for (Board tmp : res) {
					System.out.println(tmp);
				}
				break;
			case 2:
				SimpleDateFormat sdf= new SimpleDateFormat("yyyymmdd");
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-mm-dd");
//				System.out.println("번호 :");
//				int bno = sc.nextInt();    => auto_increment로 대체
				System.out.println("제목 :");
				String btitle = sc.nextLine();
				
				System.out.println("작성자 :");
				String bwriter = sc.nextLine();
				
				System.out.println("내용 :");
				String bcont = sc.nextLine(); // 문장을 입력할때 공백이 생기다보니 next()가 아닌 nextLine()으로 작성
				
				System.out.println("날짜 : '-' 기호를 제외하고 작성해주세요 ex)20231019");
				java.util.Date tempdate=sdf.parse(sc.nextLine()); // 출력형식을 바꾸기위해 simpledateformat 사용
//				java.util.Date tempdate=sdf.parse(date);
				String transDate=sdf2.format(tempdate); //출력형식을 수정하고 데이터타입 Date -> String으로 변환
				Date d=Date.valueOf(transDate); // String값은 Date생성자매개변수로 사용할수 없기때문에 타입을 다시 Date로 변환 
//				Date bDate = new Date(sc.nextInt());
				Board board= new Board(0,btitle, bwriter, bcont,d);
				System.out.println(d);
				
				int insertRes=run.insert(board);
				if(insertRes>0) {
					System.out.println("입력 성공");
				}else {
					System.out.println("입력 실패");
				}
				break;
			}
		} while (no != 3);

	}

	public int insert(Board Board) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/multi", "root", "1234");
		con.setAutoCommit(false);
		PreparedStatement pstm = null;
		int rs = 0;
		String sql = "INSERT INTO BOARD VALUES(NULL,?,?,?,?)";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyymmdd");
//	sql실행 및 리턴
		Date datemp=Board.getbDate();
		try {
			pstm=con.prepareStatement(sql);
//			btitle, bwriter, bcont, new Date(bDate
//			auto-increment 사용으로 bno를 가져오는 코드는 생략
			pstm.setString(1,Board.getBtitle());
			pstm.setString(2,Board.getBwriter());
			pstm.setString(3,Board.getBcont());
			pstm.setDate(4,Board.getbDate());

			rs = pstm.executeUpdate();
			
			System.out.println("숫자 1이 나오면 입력 성공");
			if(rs>0) {
				con.commit();
			}else {
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
			pstm.close();
		}
		return rs;
	}

	public List<Board> selectAll() throws SQLException {
		List<Board> container = new ArrayList<Board>();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/multi", "root", "1234");
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM BOARD";

		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Board tmp = new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
				container.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			psmt.close();
			con.close();
		}
		return container;
	}
}

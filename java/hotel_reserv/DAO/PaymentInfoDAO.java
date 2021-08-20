package hotel_reserv.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import hotel_reserv.DTO.PaymentInfoDTO;

public class PaymentInfoDAO {
	public void create(PaymentInfoDTO dto) {
		System.out.println("전달된 결제 ID는 " + dto.getPaymentId());
		System.out.println("전달된 주문자 ID는 " + dto.getmId());
		System.out.println("전달된 결제 내용은 " + dto.getPaymentData());
		System.out.println("전달된 결제 일시은 " + dto.getPaymentDatetime());
		System.out.println("전달된 결제 금액은 " + dto.getPaymentTotal());

		try { 
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. connector연결 성공!!!");
	
			String url = "jdbc:mysql://localhost:3306/hotel_reserv?useUnicode=true&characterEncoding=utf8";
			String username = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("2. hotel_reserv db연결 성공!!!");
			
			String sql = "insert into paymentinfo values (null, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getmId());
			ps.setString(2, dto.getPaymentData());
			ps.setString(3, dto.getPaymentDatetime());
			ps.setInt(4, dto.getPaymentTotal());
			System.out.println("3. sql문 생성 성공!!!");
	
			int result = ps.executeUpdate();
			System.out.println("4. sql문 전송 전송");
			System.out.println(result);
		} catch (ClassNotFoundException e) {
			System.out.println("1번 에러 >> 드라이버 없음!!!");
		} catch (SQLException e) {
			System.out.println("2-4번 에러 >> DB 관련된 처리하다 에러 발생!!!");
			e.printStackTrace();
		}
		
	}

}

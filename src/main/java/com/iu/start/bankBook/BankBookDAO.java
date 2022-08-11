package com.iu.start.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.iu.start.util.DBConnector;

import oracle.jdbc.proxy.annotation.Pre;

public class BankBookDAO implements BookDAO{

	//1.bankbook 테이블에 인서트
	//북넘은 현재시간을 밀리세컨즈로 변환해서입력, 북세일은 1로입력
	public int setBankBook(BankBookDTO bankbookDTO) throws Exception {
		Calendar ca = Calendar.getInstance();
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO BANKBOOK VALUES (?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, ca.getTimeInMillis());
		st.setString(2, bankbookDTO.getBookname());
		st.setDouble(3, bankbookDTO.getBookrate());
		st.setInt(4, 1);
		
		int result = st.executeUpdate();
		
		return result; 
	}

	//2.뱅크북에 있는 모든 데이터를 조회 최신순으로 
	public ArrayList<BankBookDTO> getList() throws Exception {
		
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		BankBookDTO bankbookDTO = null;
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BANKBOOK";
		//String sql = "SELECT * FROM BANKBOOK ORDER BY BOOKNUM DESC";
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			bankbookDTO = new BankBookDTO();
			bankbookDTO.setBooknum(rs.getLong("BOOKNUM"));
			bankbookDTO.setBookname(rs.getString("BOOKNAME"));
			bankbookDTO.setBookrate(rs.getDouble("BOOKRATE"));
			bankbookDTO.setBooksale(rs.getInt("BOOKSALE"));
			ar.add(bankbookDTO);
		}
		
		return ar;
	}

	//3. 세일 컬럼을 판매중지, 판매중으로 껐다켰다합니다.
	public int setChangeSale(BankBookDTO bankbookDTO) throws Exception {
		int result = 0;
		
		
		
		
		Connection con = DBConnector.getConnection();
		String sql = "UPDATE BANKBOOK SET BANKSALE = ? WHERE BOOKNUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		Scanner sc = new Scanner(System.in);
		System.out.println("판매여부를 바꿀 통장의 번호를 입력하세요");
		
		
		
		if(bankbookDTO.getBooksale()==1) {
		st.setInt(1, 0);
		} else if(bankbookDTO.getBooksale()==0) {
		st.setInt(1, 1);
		}
		st.setLong(2,sc.nextLong());
		
		result = st.executeUpdate();
		return result;
		
//		int result = 0;
//			if(bankbookDTO.getBooksale()==1) {
//			bankbookDTO.setBooksale(0);
//			result = 1;
//			} else if(bankbookDTO.getBooksale()==0) {
//				bankbookDTO.setBooksale(1);
//				result = 1;
//			}
//		
//		return result;
	}

	//4. 뱅크북디티오 하나를 받아와서, 북넘의 값(프라이머리값)으로 전체정보를조회합니다. 1개아니면 0이나옵니다. 
	public BankBookDTO getDetail(BankBookDTO bankbookDTO) throws Exception {
		
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		//BankBookDTO bankbookDTO = null;
		
		st.setLong(1, bankbookDTO.getBooknum());
		
		ResultSet rs = st.executeQuery();

		
		while(rs.next()) {
			bankbookDTO = new BankBookDTO();
			bankbookDTO.setBooknum(rs.getLong("BOOKNUM"));
			bankbookDTO.setBookname(rs.getString("BOOKNAME"));
			bankbookDTO.setBookrate(rs.getDouble("BOOKRATE"));
			bankbookDTO.setBooksale(rs.getInt("BOOKSALE"));
		}
		
		DBConnector.getClose(rs, st, con);
		return bankbookDTO;
	}

	@Override
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "update bankbook set bookname=?, bookrate=? where booknum=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bankBookDTO.getBookname());
		st.setDouble(2, bankBookDTO.getBookrate());
		st.setLong(3, bankBookDTO.getBooknum());
		
		
		int result = st.executeUpdate();
		
		return result; 
		
	}

	@Override
	public int setDelete(BankBookDTO bankBookDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "DELETE BANKBOOK WHERE BOOKNUM=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, bankBookDTO.getBooknum());
		
		
		
		int result = st.executeUpdate();
		
		return result; 
	}

}

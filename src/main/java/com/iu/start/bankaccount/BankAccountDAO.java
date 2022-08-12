package com.iu.start.bankaccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.start.util.DBConnector;

public class BankAccountDAO {
	
	public int add(BankAccountDTO bankAccountDTO) throws Exception {
		
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO BANKACCOUNT VALUES(ACCOUNT_SEQ.NEXTVAL, ?, ?, SYSDATE)";
				
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, bankAccountDTO.getUserName()); //세션에서 꺼낸다.
		st.setLong(2, bankAccountDTO.getBookNum());
		
		int result = st.executeUpdate();
		
		DBConnector.getClose(st, con);
		
		return result;
	}

}

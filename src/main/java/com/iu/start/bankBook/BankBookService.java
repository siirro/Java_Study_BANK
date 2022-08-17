package com.iu.start.bankBook;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBookService {
	
	@Autowired
	BankBookDAO bankbookDAO;
	
	
	public int setUpdate(BankBookDTO bankBookDTO)throws Exception {
		return bankbookDAO.setUpdate(bankBookDTO);
	}
	
	public int setDelete(BankBookDTO bankBookDTO)throws Exception {
		return bankbookDAO.setDelete(bankBookDTO);
	}
	
	//bankbook 테이블에 인서트
	//북넘은 현재시간을 밀리세컨즈로 변환해서입력, 북세일은 1로입력
	public int setBankBook(BankBookDTO bankbookDTO) throws Exception {
		return bankbookDAO.setBankBook(bankbookDTO);
	}
	
	
	//뱅크북에 있는 모든 데이터를 조회 최신순으로 
	public ArrayList<BankBookDTO> getList()throws Exception {
		return bankbookDAO.getList();
	}
	
	//세일 컬럼을 판매중지, 판매중으로 껐다켰다합니다.
	public int setChangeSale(BankBookDTO bankbookDTO)throws Exception {
		return bankbookDAO.setChangeSale(bankbookDTO);
	}
	
	//뱅크북디티오 하나를 받아와서, 북넘의 값(프라이머리값)으로 전체정보를조회합니다. 1개아니면 0이나옵니다. 
	public BankBookDTO getDetail(BankBookDTO bankbookDTO) throws Exception {
		return bankbookDAO.getDetail(bankbookDTO);
	}

}

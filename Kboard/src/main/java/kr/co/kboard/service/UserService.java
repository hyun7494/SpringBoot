package kr.co.kboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kboard.dao.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO dao;
}

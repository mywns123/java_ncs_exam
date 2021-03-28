package java_ncs_exam.service;

import java.util.List;

import java_ncs_exam.dao.TitleDao;
import java_ncs_exam.dao.impl.TitleDaoImpl;
import java_ncs_exam.dto.Title;

public class TitleService {
	private TitleDao dao = TitleDaoImpl.getInstance();
	
	public List<Title> showTitles() {
		return dao.selectTitleByAll();
	}

	public void addTitle(Title title) {
		dao.insertTitle(title);
	}

	public void removeTitle(Title title) {
		dao.deleteTitle(title.getNo());
	}
	
	public void modifyTitle(Title title) {
		dao.updateTitle(title);
	}
}

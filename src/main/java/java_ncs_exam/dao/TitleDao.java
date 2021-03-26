package java_ncs_exam.dao;

import java.util.List;

import java_ncs_exam.dto.Title;

public interface TitleDao {
	List<Title> selectTitleByAll();

	Title selectTitleByNo(Title title);

	int insertTitle(Title title);

	int updateTitle(Title title);

	int deleteTitle(int titleNo);
}

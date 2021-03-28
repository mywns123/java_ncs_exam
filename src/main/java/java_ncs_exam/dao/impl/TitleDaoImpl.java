package java_ncs_exam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java_ncs_exam.dao.TitleDao;
import java_ncs_exam.dto.Title;
import util.jdbcConn; 

public class TitleDaoImpl implements TitleDao {
	private static final TitleDaoImpl instance = new TitleDaoImpl();
	

	public TitleDaoImpl() {
	}
	
	public static TitleDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Title> selectTitleByAll() {
		String sql= "Select tno, tname from title";
		try(Connection con = jdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Title> list = new ArrayList<>();
				do {
					list.add(getTitle(rs));					
				}while(rs.next());
				return list;
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return null;
	}

	private Title getTitle(ResultSet rs) throws SQLException {
		int no = rs.getInt("tno");
		String name = rs.getString("tname");
		return new Title(no,name);
	}

	@Override
	public Title selectTitleByNo(Title title) {
		String sql = "select tno,tname from title where tno=?";
		try (Connection con = jdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, title.getNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getTitle(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}		

	@Override
	public int insertTitle(Title title) {
		String sql = "insert into title values(?,?)";
		try (Connection con = jdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, title.getNo());
				pstmt.setString(2, title.getName());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateTitle(Title title) {
		String sql = "update  title  set tname =? where tno =?";
		try (Connection con = jdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, title.getName());
			pstmt.setInt(2, title.getNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteTitle(int titleNo) {
		String sql = "delete from title where tno = ?";
		try(Connection con = jdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, titleNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}

package biz.aeffegroup.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class AlbumsDAO
{
	public void insert(Albums Albums)
	{
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("biz.aeffegroup.AlbumsMapper.insertAlbums", Albums);
		session.commit();
		session.close();
	}

	public void update(Albums Albums)
	{
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.update("biz.aeffegroup.AlbumsMapper.updateAlbums", Albums);
		session.commit();
		session.close();
	}

	public void delete(Integer id)
	{
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("biz.aeffegroup.AlbumsMapper.deleteAlbums", id);
		session.commit();
		session.close();
	}

	public Albums getData(Integer id)
	{
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Albums Albums = session.selectOne("biz.aeffegroup.AlbumsMapper.selectAlbums", id);
		session.close();
		return Albums;
	}
	
	public List<Albums> getAllData()
	{
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Albums> Albums = session.selectList("biz.aeffegroup.AlbumsMapper.selectAllAlbums");
		session.close();
		return Albums;
	}
	
}

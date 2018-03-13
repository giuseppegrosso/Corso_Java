package biz.aeffegroup.mybatis;

import java.util.Iterator;
import java.util.List;

public class RunMybatis
{
	public static void main(String[] args)
	{
		AlbumsDAO albumDAO = new AlbumsDAO();
		// insert
		Albums album = new Albums();
		album.setTitle("Crossing Republic");
		album.setArtistId(10L);
		albumDAO.insert(album);
		System.out.println("---Data saved---");
		// update
		album = new Albums();
		album.setAlbumId(348L);
		album.setTitle("Dhananjaypur");
		album.setArtistId(5L);
		albumDAO.update(album);
		System.out.println("---Data updated---");
		// select
		album = albumDAO.getData(1);
		System.out.println(
				"id:" + album.getAlbumId() + ", Name:" + album.getTitle() + ", District:" + album.getArtistId());
		// delete
		albumDAO.delete(350);
		System.out.println("---Data deleted---");
		
		// select ALL
		System.out.println("---select all---");
		List<Albums> albums = albumDAO.getAllData();
		
		albums.stream().forEach(System.out::println);
		albums.stream().forEach(e -> System.out.println(e));
		for (Iterator iterator = albums.iterator(); iterator.hasNext();)
		{
			Albums albums2 = (Albums) iterator.next();
			System.out.println(albums2);
			
		}
		
		System.out.println(
				"id:" + album.getAlbumId() + ", Name:" + album.getTitle() + ", District:" + album.getArtistId());
		
	}
}

package biz.aeffegroup.mybatis;

public class Albums
{

	private Long albumId;
	private String title;
	private Long artistId;

	public Long getAlbumId()
	{
		return albumId;
	}

	public void setAlbumId(Long albumId)
	{
		this.albumId = albumId;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Long getArtistId()
	{
		return artistId;
	}

	public void setArtistId(Long artistId)
	{
		this.artistId = artistId;
	}

	public String toString()
	{
		return "id: " + albumId + " " + title + " " + artistId;
	}
}

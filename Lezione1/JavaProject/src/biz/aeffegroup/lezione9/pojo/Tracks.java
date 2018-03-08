package biz.aeffegroup.lezione9.pojo;

import biz.aeffegroup.lezione9.manager.Column;
import biz.aeffegroup.lezione9.manager.Entity;
@Entity
public class Tracks
{

	@Column(name = "TrackId")
	Long trackId;
	@Column(name = "Name")
	String name;
	@Column(name = "AlbumId")
	Long albumId;

	// ritorno istanza del documento.
	public static Tracks getInstance()
	{
		return new Tracks();
	}

	public Long getTrackId()
	{
		return trackId;
	}

	public void setTrackId(Long trackId)
	{
		this.trackId = trackId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Long getAlbumId()
	{
		return albumId;
	}

	public void setAlbumId(Long albumId)
	{
		this.albumId = albumId;
	}

	public String toString()
	{
		return this.trackId + " " + this.albumId + " " + this.name;
	}
}

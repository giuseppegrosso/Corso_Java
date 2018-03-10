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
	

	@Column(name = "MediaTypeId")
	Long mediaTypeId;
	
	@Column(name = "GenreId")
	Long genreId;
	@Column(name = "composer")
	String composer;
	
	@Column(name = "milliseconds")
	Long milliseconds;
	@Column(name = "bytes")
	Long bytes;
	@Column(name = "unitPrice")
	Double unitPrice;

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
	
	public Long getMediaTypeId()
	{
		return mediaTypeId;
	}

	public void setMediaTypeId(Long mediaTypeId)
	{
		this.mediaTypeId = mediaTypeId;
	}

	public Long getGenreId()
	{
		return genreId;
	}

	public void setGenreId(Long genreId)
	{
		this.genreId = genreId;
	}

	public String getComposer()
	{
		return composer;
	}

	public void setComposer(String composer)
	{
		this.composer = composer;
	}

	public Long getMilliseconds()
	{
		return milliseconds;
	}

	public void setMilliseconds(Long milliseconds)
	{
		this.milliseconds = milliseconds;
	}

	public Long getBytes()
	{
		return bytes;
	}

	public void setBytes(Long bytes)
	{
		this.bytes = bytes;
	}

	public Double getUnitPrice()
	{
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice)
	{
		this.unitPrice = unitPrice;
	}


	public String toString()
	{
		return this.trackId + " " + this.albumId + " " + this.name +" " +mediaTypeId + " " + genreId;
	}
	
}

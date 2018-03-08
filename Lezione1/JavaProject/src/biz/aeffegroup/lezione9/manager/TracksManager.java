package biz.aeffegroup.lezione9.manager;

import biz.aeffegroup.lezione9.pojo.Tracks;

public class TracksManager<T> extends AbstractManager
{

	public TracksManager()
	{
		this(null);
	}

	public TracksManager(ConnectionHelper helper)
	{
		super(helper);
		this.keyName = "id";
		this.tableName = "TRACKS";
	}

	public static TracksManager<Tracks> getInstance()
	{
		return new TracksManager<Tracks>(null);
	}

	public static TracksManager<Tracks> getInstance(ConnectionHelper helper)
	{
		return new TracksManager<Tracks>(helper);
	}

}

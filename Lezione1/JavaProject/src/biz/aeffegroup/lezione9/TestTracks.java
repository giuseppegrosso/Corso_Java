package biz.aeffegroup.lezione9;

import java.util.List;

import biz.aeffegroup.lezione9.manager.TracksManager;
import biz.aeffegroup.lezione9.pojo.Tracks;

public class TestTracks
{

	public static void main(String[] args)
	{
		List<Tracks> tracks = TracksManager.getInstance().getList(Tracks.class);

		for (Tracks track : tracks)
		{
			System.out.println(track);
		}

//		tracks.stream().forEach(System.out::println);

	}
}

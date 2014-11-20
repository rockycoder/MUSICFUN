package com.app.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.app.pojo.*;

public class SongMap {
	ArrayList<List<Song>> songsLists;

	public SongMap(ArrayList<List<Song>> songsLists) {
		this.songsLists = songsLists;
	}

	public ArrayList<Song> getSearcheddSongs() {

		HashSet<songCount> hs = new HashSet<>();

		for (List<Song> sList : songsLists) {
			for (Song song : sList) {

				hs.add(new songCount(song, 1));
			}
		}

		// System.out.println("from SongMap-->"+hs);

		ArrayList<songCount> sC = new ArrayList<>();

		sC.addAll(hs);
		Collections.sort(sC);
		System.out.println("New arr list-->" + sC);

		ArrayList<Song> finalsongs = new ArrayList<>();

		for (songCount songCount : sC) {
			finalsongs.add(songCount.getSong());
		}

		return finalsongs;
	}

}

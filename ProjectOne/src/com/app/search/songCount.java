package com.app.search;

import com.app.pojo.*;

public class songCount implements Comparable<songCount>{

	Song song;
	
	long count;
	
	
	public songCount(Song song, long count) {

		this.song = song;
		this.count = count;
	}

	
	/*public songCount(long sId, long count) {
	
		this.sId = sId;
		this.count = count;
	}*/

	@Override
	public boolean equals(Object obj) {
		
		songCount other = (songCount) obj;
		
		if (this.song.getSongId() == other.getSong().getSongId())
		{
			other.count=other.count+1;
			
			return true;
		}
		
		
		return false;
	}

	



	public Song getSong() {
		return song;
	}


	public void setSong(Song song) {
		this.song = song;
	}


	@Override
	public String toString() {
		return "songCount [sId=" + song.getSongId() + ", count=" + count + "]";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
	//	result = prime * result + (int) (count ^ (count >>> 32));
		result = prime * result + (int) (song.getSongId() ^ (song.getSongId() >>> 32));
		return result;
	}

	@Override
	public int compareTo(songCount arg0) {
		
		return (int)(arg0.getCount()-this.count);
	}


	public long getCount() {
		return count;
	}

	
	
}

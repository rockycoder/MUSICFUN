package com.app.pojo;

import org.hibernate.validator.constraints.NotEmpty;

public class SongArtistForm {

	@NotEmpty
	private String albumName;
	private Song s;
	private Artist art;

	
	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public Song getS() {
		return s;
	}

	public void setS(Song s) {
		this.s = s;
	}

	public Artist getArt() {
		return art;
	}

	public void setArt(Artist art) {
		this.art = art;
	}

	@Override
	public String toString() {
		return "SongArtistForm [s=" + s + ", art=" + art + "]";
	}

}

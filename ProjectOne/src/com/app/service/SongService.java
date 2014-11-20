package com.app.service;

import java.util.List;

import com.app.pojo.Album;
import com.app.pojo.Listener;
import com.app.pojo.Song;
import com.app.pojo.SongArtistForm;

public interface SongService {

	public List<Song> getSongs(int c);

	public void setAlbum(Album a);

	public void setSongsDetails(SongArtistForm sa);

	public Song getClickedSong(long songId);

	public Song getClickedSong(long songId, long listenerId);
	
	public List<Song> getTopSong();

	Listener getValidate(String email, String password);

	long getCreatePlaylist(String lnm, long lId);

	long getRegister(String email, String name, String password);

	List<Song> getAddSong(long playlistId, long songId);

	List<Album> getAlbumByLanguage(String language);

	Album getAlbum(long albumId);

	List<Album> getTopAlbum();

	Listener getValidate(String email);

	boolean getRemoveSong(long listenerId, long sId);

	List<Song> getPlaylist(long lId);

	List<Song> getRecommendedSong(long listenerId);

	String generateForgotMail(String unm);

	List<Song> getSearchSongs(String pattern);

	Song getClickedSongWithoutUpdate(long songId);

	Song getClickedSongWithoutUpdate(long songId, long listenerId);

	String generateAdvertMail();

	//Listener getValidate(String email);

	
}

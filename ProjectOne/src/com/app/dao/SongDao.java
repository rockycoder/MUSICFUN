package com.app.dao;

import java.util.List;

import com.app.pojo.Album;
import com.app.pojo.Listener;
import com.app.pojo.Song;

public interface SongDao {
	List<Song> getAllSong();
	void addSong(Song s);
	void updateSong(Song s);
	void removeSong(int id);
	public String insertAlbum(Album ob) throws Exception;
	public String insertSong(String albumName, Song song);
	public String insertArtist(String songName, List<String> artist);
	public Listener validateListener(Listener listenerObj);
	Song getSong(long songid, long lId);
	Song getSong(long songid);
	List<Song> getTopSongs();
	List<Album> getTopAlbum();
	public void cleanUp();
	List<Song> searchSongByName(String sName);
	List<Song> getAlbumSong(String albumName);
	public List<Album> getAlbumsByLanguage(String language);
	long createPlaylist(String playlistName, long lId);
	long insertListener(Listener listener);
	public String songToPlaylist(long lId, long sId);
	List<Song> getPlaylistSongs(long playlistId);
	Album getAlbum(long albumId);
	Listener validateListener(String email);
	boolean RemoveSongFromPlaylist(long lId, long sId);
	List<Song> getRecommendedSongs(long lId);
	int forgotPassword(String email, String password);
	Song getSongWithoutUpdate(long songid);
	Song getSongWithoutUpdate(long songid, long lId);
	List<String> getAllListeners();
	
	//Listener validateListener(String email);
	
}

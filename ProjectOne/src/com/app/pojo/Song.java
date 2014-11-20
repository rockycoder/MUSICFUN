package com.app.pojo;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;


/**
 * The persistent class for the SONGS database table.
 * 
 */
@Entity
@Table(name="SONGS")
public class Song implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long songId;
	@NotEmpty
	private long durationSeconds;
	@NotEmpty
	private String fileLocation;
	@NotEmpty
	private String genre;
	@NotEmpty
	private long hitCount;
	@NotEmpty
	private String songName;
	@NotEmpty
	private Album album;
	private List<Artist> artists;
	private List<Listener> listeners;
	private List<Playlistmanager> playlistmanagers;

    public Song() {
    }


	public Song( long durationSeconds, String fileLocation,
			String genre, long hitCount, String songName) {
		
		this.durationSeconds = durationSeconds;
		this.fileLocation = fileLocation;
		this.genre = genre;
		this.hitCount = hitCount;
		this.songName = songName;
	}


	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getSongId() {
		return this.songId;
	}

	public void setSongId(long songId) {
		this.songId = songId;
	}


	public long getDurationSeconds() {
		return this.durationSeconds;
	}

	public void setDurationSeconds(long durationSeconds) {
		this.durationSeconds = durationSeconds;
	}


	public String getFileLocation() {
		return this.fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}


	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}


	public long getHitCount() {
		return this.hitCount;
	}

	public void setHitCount(long hitCount) {
		this.hitCount = hitCount;
	}


	public String getSongName() {
		return this.songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}


	//bi-directional many-to-one association to Album
    @ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="ALBUMID")
	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		System.out.println("in sett album");
		this.album = album;
	}
	

	//bi-directional many-to-many association to Artist
    @ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(
		name="SONGARTIST"
		, joinColumns={
			@JoinColumn(name="SONGID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ARTISTID")
			}
		)
	public List<Artist> getArtists() {
		return this.artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}
	

	//bi-directional many-to-many association to Listener
    @ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(
		name="VIEWEDSONG"
		, joinColumns={
			@JoinColumn(name="SONGID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="LISTENERID")
			}
		)
	public List<Listener> getListeners() {
		return this.listeners;
	}

	public void setListeners(List<Listener> listeners) {
		this.listeners = listeners;
	}
	

	//bi-directional many-to-many association to Playlistmanager
    @ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(
		name="PLAYLIST"
		, joinColumns={
			@JoinColumn(name="SONGID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="PLAYLISTID")
			}
		)
	public List<Playlistmanager> getPlaylistmanagers() {
		return this.playlistmanagers;
	}

	public void setPlaylistmanagers(List<Playlistmanager> playlistmanagers) {
		this.playlistmanagers = playlistmanagers;
	}


	@Override
	public String toString() {
		return "Song [songId=" + songId + ", durationSeconds="
				+ durationSeconds + ", fileLocation=" + fileLocation
				+ ", genre=" + genre + ", hitCount=" + hitCount + ", songName="
				+ songName + ", album=" + album  + "]";
	}
	

	
}
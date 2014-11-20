package com.app.pojo;
import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;


/**
 * The persistent class for the PLAYLISTMANAGER database table.
 * 
 */
@Entity
public class Playlistmanager implements Serializable {
	private static final long serialVersionUID = 1L;
	private long playlistId;
	@NotEmpty
	private String playlistName;
	private List<Listener> listeners;
	private List<Song> songs;

    public Playlistmanager() {
    }


	public Playlistmanager(String playlistName) {
		super();
		this.playlistName = playlistName;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getPlaylistId() {
		return this.playlistId;
	}

	public void setPlaylistId(long playlistId) {
		this.playlistId = playlistId;
	}


	public String getPlaylistName() {
		return this.playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}


	//bi-directional many-to-many association to Listener
    @ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(
		name="LISTENERPLAYLIST"
		, joinColumns={
			@JoinColumn(name="PLAYLISTID")
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
	

	//bi-directional many-to-many association to Song
	@ManyToMany(mappedBy="playlistmanagers",cascade={CascadeType.ALL})
	public List<Song> getSongs() {
		return this.songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
}
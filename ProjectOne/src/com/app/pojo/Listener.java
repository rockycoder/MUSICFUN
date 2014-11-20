package com.app.pojo;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;


/**
 * The persistent class for the LISTENER database table.
 * 
 */
@Entity
public class Listener implements Serializable {
	private static final long serialVersionUID = 1L;
	private long listenerId;
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String name;
	@NotEmpty
	private String password;
	private List<Playlistmanager> playlistmanagers;
	private List<Song> songs;

    public Listener() {
    }
    public Listener(String email, String name, String password) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public Listener(String email2, String password2) {
		this.email = email2;
		this.password = password2;
	}
	
	
	
	@Override
	public String toString() {
		return "Listener [listenerId=" + listenerId + ", email=" + email
				+ ", name=" + name + ", password=" + password + "]";
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getListenerId() {
		return this.listenerId;
	}

	public void setListenerId(long listenerId) {
		this.listenerId = listenerId;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	//bi-directional many-to-many association to Playlistmanager
	@ManyToMany(mappedBy="listeners",cascade={CascadeType.ALL})
	public List<Playlistmanager> getPlaylistmanagers() {
		return this.playlistmanagers;
	}

	public void setPlaylistmanagers(List<Playlistmanager> playlistmanagers) {
		this.playlistmanagers = playlistmanagers;
	}
	

	//bi-directional many-to-many association to Song
	@ManyToMany(mappedBy="listeners",cascade={CascadeType.ALL})
	public List<Song> getSongs() {
		return this.songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
}
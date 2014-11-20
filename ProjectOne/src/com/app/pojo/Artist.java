package com.app.pojo;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;


/**
 * The persistent class for the ARTIST database table.
 * 
 */
@Entity
public class Artist implements Serializable {
	private static final long serialVersionUID = 1L;
	private long artistId;
	@NotEmpty
	private String artistName;
	private List<Song> songs;

    public Artist() {
    }

    

	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", artistName=" + artistName
				+ ", songs=" + songs + "]";
	}



	public Artist(String artistName) {
		
		this.artistName = artistName;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getArtistId() {
		return this.artistId;
	}

	public void setArtistId(long artistId) {
		this.artistId = artistId;
	}


	public String getArtistName() {
		return this.artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}


	//bi-directional many-to-many association to Song
	@ManyToMany(mappedBy="artists",cascade={CascadeType.ALL})
	public List<Song> getSongs() {
		return this.songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
}
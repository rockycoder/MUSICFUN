package com.app.pojo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ALBUM database table.
 * 
 */
@Entity
public class Album implements Serializable {
	private static final long serialVersionUID = 1L;
	private long albumId;
	@NotEmpty
	private String albumName;
	@NotEmpty
	private String imagePath;
	@NotEmpty
	private String language;
	@NotNull
	@DateTimeFormat(iso=ISO.DATE)
	private Date releaseDate;
	private List<Song> songs;

    public Album() {
    }


	public Album( String albumName, String imagePath,
			String language, Date releaseDate) {
		super();

		this.albumName = albumName;
		this.imagePath = imagePath;
		this.language = language;
		this.releaseDate = releaseDate;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return albumId+" "+albumName+" "+language+" "+releaseDate; 
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getAlbumId() {
		return this.albumId;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}


	public String getAlbumName() {
		return this.albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}


	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	@Column(name="\"LANGUAGE\"")
	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}


    @Temporal( TemporalType.DATE)
	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}


	//bi-directional many-to-one association to Song
	@OneToMany(mappedBy="album",cascade={CascadeType.ALL})
	public List<Song> getSongs() {
		return this.songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
}
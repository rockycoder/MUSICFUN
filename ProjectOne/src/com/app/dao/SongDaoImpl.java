package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import com.app.pojo.Album;
import com.app.pojo.Artist;
import com.app.pojo.Listener;
import com.app.pojo.Playlistmanager;
import com.app.pojo.Song;

@Repository("daoo")
public class SongDaoImpl implements SongDao {

	Session s;

	@Autowired
	private SessionFactory mySF;

	@Autowired
	private PlatformTransactionManager mgr;

	@SuppressWarnings("unchecked")
	@Override
	public List<Song> getAllSong() {
		System.out.println("in dao " + mySF + " mgr " + mgr);
		s = mySF.openSession();
		Transaction tx = null;
		try {
			System.out.println(s);
			return s.createQuery("select k from Song k").list();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (s != null)
				s.close();
		}
		return null;
	}

	@Override
	public String insertAlbum(Album ob) throws Exception {

		String str = "Failed to add Album";
		s = mySF.openSession();
		Transaction tx = s.beginTransaction();
		try {

			System.out.println("album created with id " + s.save(ob));
			tx.commit();
			str = "Album added";
		} catch (HibernateException e) {
			tx.rollback();
			return null;
		}
		System.out.println("album added  " + ob);
		return str;
	}

	@Override
	public void addSong(Song s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSong(Song s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeSong(int id) {
		// TODO Auto-generated method stub

	}

	public String insertSong(String albumName, Song song) {
		String str = "album not found";
		s = mySF.openSession();
		Transaction tx = s.beginTransaction();
		Album albmObj = null;

		String q = "from Album a where a.albumName=:nam";

		try {
			albmObj = (Album) s.createQuery(q).setParameter("nam", albumName)
					.uniqueResult();

			if (albmObj != null) {

				List<Song> songs1 = albmObj.getSongs();
				System.out.println("song.setalbum");
				song.setAlbum(albmObj);
				System.out.println("song list add" + songs1.add(song));
				System.out.println("song.add(song)");
				str = "Song Added to the album";

			}
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			return null;
		} finally {
			if (s != null)
				s.close();
		}

		return str;
	}

	public String insertArtist(String songName, List<String> artist) {
		String str = "Failed to insert Artist";

		s = mySF.openSession();
		Transaction tx = s.beginTransaction();
		Song songObj = null;

		int artcount = artist.size();

		try {
			String songFetcher = "from Song a where a.songName=:name";
			songObj = (Song) s.createQuery(songFetcher)
					.setParameter("name", songName).uniqueResult();

			System.out.println(songObj.toString());

			ArrayList<Song> songarrlist = new ArrayList<>();
			songarrlist.add(songObj);

			System.out.println(songarrlist.toString());

			while (artcount > 0) {

				String artName = artist.get(artcount - 1);
				String q = "from Artist a where a.artistName=:nam";

				Artist artObj = (Artist) s.createQuery(q)
						.setParameter("nam", artName).uniqueResult();

				if (artObj == null) {

					Artist art = new Artist(artName);
					s.save(art);
					artObj = (Artist) s.createQuery(q)
							.setParameter("nam", artName).uniqueResult();
				}

				List<Artist> artList = songObj.getArtists();
				artObj.setSongs(songarrlist);

				System.out.println("in while artList-->-------------");
				System.out.println("Added artist " + artObj.getArtistName()
						+ " " + artList.add(artObj));

				artcount--;

			}
			str = "artist Added to the album";
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} finally {
			if (s != null)
				s.close();
		}
		return str;

	}

	/*
	 * public long validateListener(Listener listenerObj) {
	 * 
	 * long lId = 0; s = mySF.openSession(); Transaction tx =
	 * s.beginTransaction();
	 * 
	 * String q = "from Listener l where l.email=:mail and l.password=:pswd";
	 * try {
	 * 
	 * Listener lObj = (Listener) s.createQuery(q) .setParameter("mail",
	 * listenerObj.getEmail()) .setParameter("pswd", listenerObj.getPassword())
	 * .uniqueResult();
	 * 
	 * if (lObj != null) lId = lObj.getListenerId(); tx.commit();
	 * 
	 * } catch (HibernateException e) { tx.rollback(); throw e; }
	 * 
	 * return lId; }
	 */

	private String addViewedSong(long lId, long sId) {
		String str = "Failed to add viewed song with id " + sId
				+ " and listener id " + lId;

		/*if(s.isOpen())
			s.close();*/
		
		s = mySF.openSession();
		Transaction tx = s.beginTransaction();
		Song songObj = null;

		try {

			ArrayList<Listener> lList = new ArrayList<>();
			String qL = "from Listener l where l.listenerId=:listid";
			String qS = "from Song s where s.songId=:songid";

			Listener lObj = (Listener) s.createQuery(qL)
					.setParameter("listid", lId).uniqueResult();

			lList.add(lObj);

			songObj = (Song) s.createQuery(qS).setParameter("songid", sId)
					.uniqueResult();

			List<Song> sList = lObj.getSongs();
			songObj.setListeners(lList);
			sList.add(songObj);

			tx.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
		//	e.printStackTrace();
		}

		return str;

	}

	@Override
	public Song getSong(long songid, long lId) {

		System.out.println(lId+"before vieded song call"+songid);
		addViewedSong(lId, songid);
		cleanUp();
		System.out.println(lId+"after vieded song call"+songid);
		s = mySF.openSession();
		System.out.println(lId+"after session song call"+songid);
		Transaction tx = s.beginTransaction();

		String q = "from Song s where s.songId=:sid";
		String updateCount = "update Song s set s.hitCount=:newHCount where s.songId=:sid";

		Song sObj = null;
		try {
			sObj = (Song) s.createQuery(q).setParameter("sid", songid)
					.uniqueResult();

			System.out.println("hit" + (sObj.getHitCount() + 1));
			int rowcount = s.createQuery(updateCount)
					.setParameter("newHCount", (sObj.getHitCount() + 1))
					.setParameter("sid", songid).executeUpdate();

			System.out.println("changed rows = " + rowcount);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
		return sObj;
	}

	@Override
	public Song getSongWithoutUpdate(long songid, long lId) {

		System.out.println(lId+"before vieded song call"+songid);
		addViewedSong(lId, songid);
		cleanUp();
		System.out.println(lId+"after vieded song call"+songid);
		s = mySF.openSession();
		System.out.println(lId+"after session song call"+songid);
		Transaction tx = s.beginTransaction();

		String q = "from Song s where s.songId=:sid";
		
		Song sObj = null;
		try {
			sObj = (Song) s.createQuery(q).setParameter("sid", songid)
					.uniqueResult();

					tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
		return sObj;
	}

	
	
	
	@Override
	public Song getSong(long songid) {

		System.out.println("in get song dao" + songid);
		s = mySF.openSession();
		Transaction tx = s.beginTransaction();

		System.out.println("in get song ");
		String q = "from Song s where s.songId=:sid";
		String updateCount = "update Song s set s.hitCount=:newHCount where s.songId=:sid";
		Song sObj = null;
		try {
			sObj = (Song) s.createQuery(q).setParameter("sid", songid)
					.uniqueResult();

			System.out.println("hit" + (sObj.getHitCount() + 1));
			int rowcount = s.createQuery(updateCount)
					.setParameter("newHCount", (sObj.getHitCount() + 1))
					.setParameter("sid", songid).executeUpdate();

			System.out.println("changed rows = " + rowcount);
			System.out.println("in SongDao" + sObj.toString());
			tx.commit();
		} catch (HibernateException e) {
			//e.printStackTrace();
			tx.rollback();
			//throw e;
		}
		return sObj;
	}
	
	
	@Override
	public Song getSongWithoutUpdate(long songid) {

		System.out.println("in get song dao" + songid);
		s = mySF.openSession();
		Transaction tx = s.beginTransaction();

		System.out.println("in get song ");
		String q = "from Song s where s.songId=:sid";
		Song sObj = null;
		try {
			sObj = (Song) s.createQuery(q).setParameter("sid", songid)
					.uniqueResult();

			
			System.out.println("in SongDao" + sObj.toString());
			tx.commit();
		} catch (HibernateException e) {
			//e.printStackTrace();
			tx.rollback();
			//throw e;
		}
		return sObj;
	}
	

	@Override
	public List<Album> getTopAlbum() {

		s = mySF.openSession();
		Transaction tx = s.beginTransaction();
		List<Album> tmpList = null;
		try {
			String q = "from Album a order by a.releaseDate";
			tmpList = s.createQuery(q).setMaxResults(16).list();
			System.out.println("method album " + tmpList.toString());

			tx.commit();
		} catch (HibernateException e) {
			//e.printStackTrace();
			tx.rollback();
			//throw e;
		}
		return tmpList;
	}

	public List<String> getTopSinger() {

		s = mySF.openSession();
		Transaction tx = s.beginTransaction();
		ArrayList<String> allNames = null;
		try {
			String q = "from Song s order by s.hitCount desc";
			List<Song> tmpList = s.createQuery(q).setMaxResults(10).list();

			int i = 0;
			HashSet<String> aNames = new HashSet<>();

			while (i < tmpList.size()) {
				int j = 0;
				while (j < tmpList.get(i).getArtists().size()) {
					aNames.add(tmpList.get(i).getArtists().get(j)
							.getArtistName());
					j = j + 1;
				}
				i = i + 1;

			}

			allNames = new ArrayList<>(aNames);

			tx.commit();
		} catch (HibernateException e) {
			//e.printStackTrace();
			tx.rollback();
			//throw e;
		}
		return allNames;
	}

	// ----------------------------------------------------------------
	@Override
	public List<Song> getPlaylistSongs(long listId) {

		String q1 = "from Listener l where l.listenerId=:lid";

		String q = "from Playlistmanager plm where plm.playlistId=:pid";
		s = mySF.openSession();
		Transaction tx = s.beginTransaction();
		Playlistmanager plObj = null;
		Listener lObj = null;
		List<Song> songs = null;
		try {
			lObj = (Listener) s.createQuery(q1).setParameter("lid", listId)
					.uniqueResult();
			long id = lObj.getPlaylistmanagers().get(0).getPlaylistId();
			System.out.println("id got as-->" + id);
			plObj = (Playlistmanager) s.createQuery(q).setParameter("pid", id)
					.uniqueResult();

			songs = plObj.getSongs();
			System.out.println(songs.size());
			tx.commit();
		} catch (HibernateException e) {
			//e.printStackTrace();
			tx.rollback();
			//throw e;
		}
		return songs;

	}

	// -----------------------------------------------------------------------

	@SuppressWarnings("unchecked")
	@Override
	public List<Song> getTopSongs() {

		s = mySF.openSession();
		Transaction tx = s.beginTransaction();
		List<Song> tmpList = null;
		try {
			String q = "from Song s order by s.hitCount desc";
			tmpList = s.createQuery(q).setMaxResults(10).list();

			tx.commit();
		} catch (HibernateException e) {
			//e.printStackTrace();
			tx.rollback();
			//throw e;
		}
		return tmpList;
	}

	@Override
	public Listener validateListener(Listener listenerObj) {

		// long lId = -1;
		s = mySF.openSession();
		Transaction tx = s.beginTransaction();
		Listener lObj = null;
		String q = "from Listener l where l.email=:mail and l.password=:pswd";
		try {

			lObj = (Listener) s.createQuery(q)
					.setParameter("mail", listenerObj.getEmail())
					.setParameter("pswd", listenerObj.getPassword())
					.uniqueResult();

			tx.commit();

		} catch (HibernateException e) {
			//e.printStackTrace();
			tx.rollback();
			//throw e;
		}

		return lObj;
	}

	@Override
	public List<Song> getAlbumSong(String albumName) {

		String q = "from Album a where a.albumName=:nam";
		s = mySF.openSession();
		Transaction tx = s.beginTransaction();

		List<Song> songList = null;
		try {
			Album albmname = (Album) s.createQuery(q)
					.setParameter("nam", albumName).uniqueResult();
			songList = albmname.getSongs();
			tx.commit();
		} catch (HibernateException e) {
			//e.printStackTrace();
			tx.rollback();
			//throw e;
		}
		for (Song song : songList) {
			System.out.println(song.getArtists().size());
		}
		return songList;
	}

	/*@Override
	public Song searchSongByName(String sName) {
		String q = "from Song s where s.songName=:nam";
		s = mySF.openSession();
		Transaction tx = s.beginTransaction();
		Song retSong = null;
		try {
			retSong = (Song) s.createQuery(q).setParameter("nam", sName)
					.uniqueResult();

			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			throw e;
		}
		System.out.println(retSong);
		return retSong;
	}
*/
	@Override
	public long createPlaylist(String playlistName, long lId) {

		// String str = "Failed to create playlist " + playlistName;
		long plId = -1;
		s = mySF.openSession();
		Transaction tx = s.beginTransaction();
		Song songObj = null;

		try {
			Playlistmanager lPlaylist = new Playlistmanager(playlistName);
			plId = (Long) s.save(lPlaylist);

			String q = "from Listener l where l.listenerId=:id";
			Listener lObj = (Listener) s.createQuery(q).setParameter("id", lId)
					.uniqueResult();

			ArrayList<Listener> listenerList = new ArrayList<>();
			listenerList.add(lObj);

			List<Playlistmanager> plist = lObj.getPlaylistmanagers();
			lPlaylist.setListeners(listenerList);

			plist.add(lPlaylist);
			// str = "created";
			tx.commit();
		} catch (HibernateException e) {
			//e.printStackTrace();
			tx.rollback();
			plId = -2;
		}
		return plId;

	}

	@Override
	public long insertListener(Listener listener) {
		System.out.println("in dao");
		long lid = -1;
		s = mySF.openSession();
		Transaction tx = s.beginTransaction();
		try {
			System.out.println(listener);
			lid = (Long) s.save(listener);
			tx.commit();
		} catch (HibernateException e) {
			
			
			tx.rollback();
			lid = -2;
		}catch (Exception e) {
			// TODO: handle exception
			lid = -2;
			tx.rollback();
		}

		return lid;

	}

	@Override
	public void cleanUp() {
		if (s.isOpen())
			s.close();
	}

	@Override
	public String songToPlaylist(long lId, long sId) {
		String str = "Failed to add song with id " + sId + " in " + lId;

		s = mySF.openSession();
		Transaction tx = s.beginTransaction();
		Song songObj = null;

		try {

			String qL = "from Listener l where l.listenerId=:listid";
			String qS = "from Song s where s.songId=:songid";

			Listener lObj = (Listener) s.createQuery(qL)
					.setParameter("listid", lId).uniqueResult();

			songObj = (Song) s.createQuery(qS).setParameter("songid", sId)
					.uniqueResult();

			Playlistmanager plListenerObj = lObj.getPlaylistmanagers().get(0);

			List<Song> playlistSongList = plListenerObj.getSongs();
			List<Playlistmanager> plSongObjList = songObj.getPlaylistmanagers();
			plSongObjList.add(plListenerObj);
			songObj.setPlaylistmanagers(plSongObjList);
			playlistSongList.add(songObj);

			tx.commit();

		} catch (HibernateException e) {
			//e.printStackTrace();
			tx.rollback();
			//throw e;
		}catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}

		return str;
	}

	@Override
	public List<Album> getAlbumsByLanguage(String language) {

		String q = "from Album a where a.language=:lang order by a.albumName";
		s = mySF.openSession();
		Transaction tx = s.beginTransaction();

		List<Album> albmlist = null;
		try {
			albmlist = s.createQuery(q).setParameter("lang", language).list();
			tx.commit();
		} catch (Exception e) {
			//e.printStackTrace();
			tx.rollback();
			//throw e;
		}
		System.out.println(albmlist.size()
				+ "=========================================================");
		return albmlist;
	}

	@Override
	public Album getAlbum(long albumId) {

		String q = "from Album a where a.albumId=:aId";
		s = mySF.openSession();
		Transaction tx = s.beginTransaction();

		Album albmname;

		Album albm = null;
		try {
			albm = (Album) s.createQuery(q).setParameter("aId", albumId)
					.uniqueResult();

			tx.commit();
		} catch (Exception e) {
			//e.printStackTrace();
			tx.rollback();
			//throw e;
		}

		for (Song s : albm.getSongs()) {
			System.out.println(s.getArtists().size());
		}

		return albm;
	}

	@Override
	public Listener validateListener(String email) {

		long lId = -1;
		s = mySF.openSession();
		Transaction tx = s.beginTransaction();
		Listener lObj = null;
		String q = "from Listener l where l.email=:mail";
		try {

			lObj = (Listener) s.createQuery(q).setParameter("mail", email)
					.uniqueResult();

			tx.commit();

		} catch (Exception e) {
			//e.printStackTrace();
			tx.rollback();
			//throw e;
		}

		return lObj;
	}
	
	
	@Override
	public boolean RemoveSongFromPlaylist(long lId, long sId) {
		boolean str=false;

		s = mySF.openSession();
		Transaction tx = s.beginTransaction();
		Song songObj = null;

		try {

			String qL = "from Listener l where l.listenerId=:listid";
			String qS = "from Song s where s.songId=:songid";

			Listener lObj = (Listener) s.createQuery(qL)
					.setParameter("listid", lId).uniqueResult();

			songObj = (Song) s.createQuery(qS).setParameter("songid", sId)
					.uniqueResult();

			Playlistmanager plListenerObj = lObj.getPlaylistmanagers().get(0);
			List<Song> playlistSongList = plListenerObj.getSongs();
			
			List<Playlistmanager> plSongObjList = songObj.getPlaylistmanagers();
			plSongObjList.remove(plListenerObj);
			songObj.setPlaylistmanagers(plSongObjList);
			
			playlistSongList.remove(songObj);

			tx.commit();
			str=true;

		} catch (Exception e) {
			//e.printStackTrace();
			tx.rollback();
			//throw e;
		}

		return str;
	}
	
	
	private ArrayList<String> getGenres(long lId) {

		ArrayList<String> genreList=null;
		try {

					
			
			// load
			Class.forName("oracle.jdbc.OracleDriver");
			// cn
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "system", "power");

			String select = "SELECT get_topGenre(" + lId + ") FROM DUAL";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(select);
			rs.next();

			String genres = rs.getString(1);

			Scanner sc = new Scanner(genres);
			sc.useDelimiter(",");
			genreList=new ArrayList<>();
			while(sc.hasNext())
			genreList.add(sc.next());
			System.out.println(genreList.size());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
		//	e1.printStackTrace();
		}
	
		return genreList;
	}
	

	@Override
	public List<Song> getRecommendedSongs(long lId) {
		ArrayList<String> genreList=getGenres(lId);
		
		System.out.println(lId+"in dao of recommended");
		if(genreList==null)
			return getTopSongs();
		
		String q = "from Song s where ";
		int count=genreList.size()-1;
		
		for(int i=0;i<genreList.size();i++)
			{
			
			q+="s.genre='"+genreList.get(i)+"'";
			if(count==0)
				break;
			else
				q+=" or ";
			count--;
			}
			
		q+=" order by s.hitCount desc";
		
		System.out.println(q);
		
		System.out.println(genreList);
		
		s= mySF.openSession();
		Transaction tx = s.beginTransaction();
		
		
		
		List<Song> retSong = null;
		try {
			retSong =s.createQuery(q).setMaxResults(10).list();
			System.out.println("from dao--> "+retSong);
			tx.commit();
		} catch (Exception e) {
			//e.printStackTrace();
			tx.rollback();
			//throw e;
		}
		
		
	return retSong;
	
	}

	@Override
	public List<Song> searchSongByName(String sName) {
		System.out.println("String received===>"+sName);
		
		
		//String q = " where lower(s.songName) like '%lower("+sName+")%'";
		s =mySF.openSession();
		Transaction tx = s.beginTransaction();
		
		Query q = s.createQuery("from Song s WHERE lower(s.songName) like ?)");
		q.setString(0, '%' + sName.toLowerCase() + '%');
		
		List<Song> retSong = null;
		try {
			retSong = q.list();

			tx.commit();
		} catch (HibernateException e) {
			//e.printStackTrace();
			tx.rollback();
			//throw e;
		}
		//System.out.println("from dao--"+retSong);
		return retSong;
	}

	@Override
	public int forgotPassword(String email, String password) {

		
		s = mySF.openSession();
		Transaction tx = s.beginTransaction();
		
		int rowcnt=0; 
		
		String q = "update Listener l set password=:pass where l.email=:mail";
		try {

			rowcnt =  s.createQuery(q).setParameter("mail", email).setParameter("pass", password)
					.executeUpdate();

			tx.commit();

		} catch (HibernateException e) {
			//e.printStackTrace();
			tx.rollback();
			//throw e;
		}

		return rowcnt ;
	}
	
	@Override
	public List<String> getAllListeners() {

		s = mySF.openSession();
		Transaction tx = s.beginTransaction();

		List<String> list =null;
		String q = "select l.email from Listener l";
		try {

			list = (List<String>)s.createQuery(q).list();

			tx.commit();

		} catch (HibernateException e) {
			tx.rollback();
			
		}

		return list;
	}


}
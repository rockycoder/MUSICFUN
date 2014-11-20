package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.dao.SongDao;
import com.app.email.autoemail;
import com.app.encrypt.EncryptPswd;
import com.app.pojo.Album;
import com.app.pojo.Artist;
import com.app.pojo.Listener;
import com.app.pojo.Song;
import com.app.pojo.SongArtistForm;
import com.app.search.SongMap;

import java.util.*;

import javax.mail.MessagingException;

@Service("serv")
public class SongServiceImpl implements SongService {

	@Autowired
	@Qualifier("daoo")
	private SongDao dao;

	
	
	@Autowired
	@Qualifier("encrypt")
	private EncryptPswd enc;
	
	@Autowired
	@Qualifier("autoemail")
	private autoemail em;

	
	public SongServiceImpl() {
		super();
		System.out.println("in service constrctr");
	}

	@Override
	public List<Song> getSongs(int c) {
		
		 List<Song>songList= dao.getAllSong();

		dao.cleanUp();
		return songList;
	}

	@Override
	public void setAlbum(Album a) {
		try {

			dao.insertAlbum(a);
			dao.cleanUp();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}

	}

	@Override
	public void setSongsDetails(SongArtistForm sa) {

		setInsertedSong(sa.getS(), sa.getAlbumName());
		setInsertedArtist(sa.getArt(), sa.getS().getSongName());

	}

	public String setInsertedSong(Song s, String an) {

		String str = "fail";

		try {

			
			str = dao.insertSong(an, s);

		} catch (Exception e) {
			// TODO: handle exception
			

		}
		dao.cleanUp();
		return str;

	}

	public String setInsertedArtist(Artist a, String sn) {

		String str = "fail";

		Scanner sc = new Scanner(a.getArtistName());
		sc.useDelimiter("&");

		ArrayList<String> artListNames = new ArrayList<>();

		while (sc.hasNext()) {
			artListNames.add(sc.next());
		}

		try {

			str = dao.insertArtist(sn, artListNames);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		dao.cleanUp();
		return str;

	}

	@Override
	public Song getClickedSong(long songId) {
		
		//System.out.println("In servicemkdsjkhsdkjffkdsfkdsfkdsfkdsk"+songId);
		Song sObj=dao.getSong(songId);
		
		//System.out.println(sObj.toString()+",kndsnjfhjsdkhfjkdsfdshfdsgh"+songId);
		dao.cleanUp();
		return sObj;
	}
	
	@Override
	public Song getClickedSongWithoutUpdate(long songId) {
		
		//System.out.println("In servicemkdsjkhsdkjffkdsfkdsfkdsfkdsk"+songId);
		Song sObj=dao.getSongWithoutUpdate(songId);
		
		//System.out.println(sObj.toString()+",kndsnjfhjsdkhfjkdsfdshfdsgh"+songId);
		dao.cleanUp();
		return sObj;
	}
	
	
	
	@Override
	public Song getClickedSong(long songId, long listenerId) {
		
		System.out.println("In service"+songId+"listner id"+listenerId);
		Song sObj=dao.getSong(songId,listenerId);
		dao.cleanUp();
		return sObj;
	}
	
	@Override
	public Song getClickedSongWithoutUpdate(long songId, long listenerId) {
		
		System.out.println("In service"+songId+"listner id"+listenerId);
		Song sObj=dao.getSongWithoutUpdate(songId,listenerId);
		dao.cleanUp();
		return sObj;
	}
	
	@Override
	public List<Song> getTopSong(){
		List<Song> lst=dao.getTopSongs();
		dao.cleanUp();
		return lst;
		
		
	}
	
	
	 @Override
		public Listener getValidate(String email,String password)
		{
			Listener l;
			
			l=dao.validateListener(new Listener(email, enc.getEncryptedPassword(password)));
			dao.cleanUp();
			return l;
				
		}
	 

	 
	 @Override
		public Listener getValidate(String email)
		{
			Listener l;
			
			l=dao.validateListener(email);
			dao.cleanUp();
			return l;
				
		}
	 
	 @Override
		public long getCreatePlaylist(String lnm,long lId) {
			long plid = dao.createPlaylist(lnm+lId, lId);
			dao.cleanUp();
			return plid;
		}
	 
	 @Override
		public long getRegister(String email,String name,String password)
		{
		 System.out.println("in dao of register");
			long id=dao.insertListener(new Listener(email, name, enc.getEncryptedPassword(password)));	
			dao.cleanUp();
			return id;
		}

        @Override
		public List<Song> getAddSong(long lId,long songId) {

		    dao.songToPlaylist(lId, songId);
		    dao.cleanUp();
			List<Song> list=dao.getPlaylistSongs(lId);
			dao.cleanUp();
			return list;
		}

        @Override
    	public List<Album> getTopAlbum()
    	{
    		 List<Album> albums=dao.getTopAlbum();
    		 dao.cleanUp();
    			return albums;
    			
    	}
    	
    	@Override
    	public List<Album> getAlbumByLanguage(String language)
    	{
    		 List<Album> albums=dao.getAlbumsByLanguage(language);
    		 dao.cleanUp();
    		 return albums;
    	}

    	@Override
    	public Album getAlbum(long albumId) {
    		
    		Album alb= dao.getAlbum(albumId);
    		dao.cleanUp();
    		return alb;
    	}
    	
    	@Override
    	public List<Song> getPlaylist(long lId){
    		List<Song> list=dao.getPlaylistSongs(lId);
			dao.cleanUp();
			return list;
    	}

		@Override
		public boolean getRemoveSong(long listenerId, long sId) {
			boolean ret=dao.RemoveSongFromPlaylist(listenerId, sId);
			dao.cleanUp();
			return ret;
		}
		

		@Override
		public List<Song> getRecommendedSong(long listenerId) {
			List<Song> ret=dao.getRecommendedSongs(listenerId);
			dao.cleanUp();
			return ret;
		}
	   
		@Override
		public List<Song> getSearchSongs(String pattern){
			
			
			System.out.println("pattern is-->"+pattern);
			Scanner sc= new Scanner(pattern);
			sc.useDelimiter(" ");
			
			ArrayList<Song> finalSongs=new ArrayList<>();
			
			ArrayList<String> words=new ArrayList<>();
			while(sc.hasNext())
			{
				words.add(sc.next());
			}
			
			
			ArrayList<List<Song>> songsLists=new ArrayList<>();
			
			for (String str : words) {
			
				SearchThread myth= new SearchThread(str);
					
					try {
						myth.getThread().join();
						if(myth.getThread().getState()==Thread.State.TERMINATED)
							songsLists.add(myth.getSonglist());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
			}
			System.out.println("from bean"+songsLists);
			finalSongs=new SongMap(songsLists).getSearcheddSongs();
			
			return finalSongs;
		}
		
		
		
		class SearchThread implements Runnable{

			List<Song> songlist;
			Thread t;
			public SearchThread(String pattern) {
				// TODO Auto-generated constructor stub
				t=new Thread(this,pattern);
				t.start();
			}
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String pat=t.getName();
				System.out.println("thread's name-->"+pat);
				songlist=dao.searchSongByName(pat);
				dao.cleanUp();
			}
			
			public Thread getThread()
			{
				return t;
			}
			
			public List<Song> getSonglist()
			{
				return songlist;
			}
		}
	   
		
		@Override
		public String generateForgotMail(String unm) {
			String str="user not recognised";
			Random rnd=new Random();
			
			long pswd=(rnd.nextInt()*13);
			int ret=dao.forgotPassword(unm, enc.getEncryptedPassword(pswd+""));
			dao.cleanUp();
			if(ret==1)
			{
				String[] recipent= new String[1];
				recipent[0]=unm;
				try {
					em.sendSSLMessage(recipent,"Funmusic: Reset pswd link", "Your pswd reset to"+pswd);
					str="new paswd sent to ur emailId";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					str="Network Fail:Error occured sending ur link.. Try again..";
				}
			}
			return str;
		}
	   
		@Override
		public String generateAdvertMail() {
			String str = "user not recognised";

			List<String> list = dao.getAllListeners();

			if (list.size() != 0) {
				String[] recipent = new String[(list.size() - 1)];
				dao.cleanUp();

				for (int i = 0; i < recipent.length; i++) {
					recipent[i] = list.get(i);
				}
				
				List<Album> alblist = dao.getTopAlbum();
				dao.cleanUp();
				String message = "Latest Albums on our Website";
				for (int i = 0; i < alblist.size(); i++) {
					message = message + " -> " + alblist.get(0).getAlbumName();
				}

				try {
					em.sendSSLMessage(recipent,
							"Funmusic: Check out the Latest...", message);
					str = "new paswd sent to ur emailId";
				} catch (MessagingException e) { // TODO Auto-generated catch block
					str = "No Network Connectivity:Error occured sending ur link.. Try again..";
				}
			}

			return str;
		}


}

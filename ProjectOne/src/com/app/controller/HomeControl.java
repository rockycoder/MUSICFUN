package com.app.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojo.Album;
import com.app.pojo.Artist;
import com.app.pojo.Listener;
import com.app.pojo.Song;
import com.app.pojo.SongArtistForm;
import com.app.service.SongService;

@Controller
public class HomeControl {

	@Autowired
	private SongService service;

	public HomeControl() {
		super();
		System.out.println("in controoller");
	}

	@RequestMapping("/hello")
	public String ShowSongs(Model m) {
		System.out.println("in show form");
		m.addAttribute("tensongs", service.getSongs(1));
		return "home";
	}

	@RequestMapping("/switch")
	public String ShowSong() {
		System.out.println("in show form");

		return "album_list";
	}

	@RequestMapping("/getSongs")
	public String getSongs() {
		System.out.println("hello songs");
		return "getSongs";
	}

	@RequestMapping("/insert_album")
	public String toInsertAlbum(Model m) {
		m.addAttribute("insert_album", new Album());
		return "insert_album";
	}

	@RequestMapping("/insert_songs_artists")
	public String toInsertSongs(Model m) {
		m.addAttribute("insert_songs", new SongArtistForm());
		return "insert_songs_artist";
	}
	

	

	@RequestMapping("/inserted_album")
	public String addInsertedAlbum(Model m,
			@Valid @ModelAttribute("insert_album") Album c, BindingResult res) {

		if (res.hasErrors())
			return "insert_album";

		service.setAlbum(c);

	return "redirect:/AdminLogin.jsp";
	}

	@RequestMapping("inserted_songdetails")
	public String addInsertedSongs(Model m,
			@Valid @ModelAttribute("insert_songs") SongArtistForm c,
			BindingResult res) {

		if (res.hasErrors())
			return "insert_songs_artist";

		service.setSongsDetails(c);
		return "redirect:/AdminLogin.jsp";
	}

	@RequestMapping("/play")
	public String getSongLocation(Model m,@RequestParam("sid") String sid,HttpSession s)
	{
		System.out.println("in play =========================mnjmnjmbmnbnmbnb================== "+ sid);
		Listener lObj=(Listener)s.getAttribute("user");
		String url="";
		String name="";
		
		if(lObj!=null)
		{
			System.out.println("in listener"+lObj.getListenerId());
			Song song=service.getClickedSong(Long.parseLong(sid),lObj.getListenerId());
			url=song.getFileLocation();
		}
		else 
		{
			System.out.println("in controller else part");
			Song song=service.getClickedSong(Long.parseLong(sid));
			url=song.getFileLocation();
			name=song.getSongName();
		}
		System.out.println("in play controller after else ");
		m.addAttribute("id", sid);
		m.addAttribute("surl",url);
		m.addAttribute("sname",name);
		return "clickedSong";
	}

	
	

	
	
	@RequestMapping("/nowPlaying")
	public String getNowPlaying(Model m) {
		m.addAttribute("sList", service.getTopSong());
		return "nowPlaying";
	}

	@RequestMapping("/register")
	public String doRegister(@RequestParam("username") String unm,
			@RequestParam("password") String pwd,
			@RequestParam("email") String em, Model m, HttpSession hs) {
		System.out.println("in controller");
		long id = service.getRegister(em, unm, pwd);
		if (id == -2)
			m.addAttribute("msg1", "this email id already registered");
		else if (id != -1){
			m.addAttribute("msg1", "sucessfully registered");
			long plId = service.getCreatePlaylist(unm, id);
		}
		/*if (plId == -2)
			m.addAttribute("msg1", "error creating playlist");
		else
			m.addAttribute("msg1", "playlist created");*/

		return "redirect:/index.jsp";

	}

	
	

	@RequestMapping("/latestAlbums")
	public String getLatestAlbums(Model m)
	{
		m.addAttribute("aList",service.getTopAlbum());
		return "latestAlbums";
	}
	
	@RequestMapping("/currPlaying")
	public String getCurrPlaying(Model m,@RequestParam("sid") String sid)
	{
		System.out.println("in put data -=============="+sid);
		Song s=service.getClickedSongWithoutUpdate(Long.parseLong(sid));
		System.out.println(s.toString());
		Album album=s.getAlbum();
		System.out.println(album.toString());
		m.addAttribute("song",s);
		m.addAttribute("album",album);
		return "currPlaying";
	}
	
	@RequestMapping("/yourAlbum")
	public String getCurrAlbum(Model m,@RequestParam("aid") long albumId)
	{
		
		m.addAttribute("pList",service.getAlbum(albumId));
		
		return "yourAlbum";
	}
	

	@RequestMapping("/album_test")
	public String test() {
		
		return "album_english";
	}


	
	
	@RequestMapping("/allAlbums")
	public String getAlbumsHIndi(Model m,@RequestParam("lang") String lang ) {
		m.addAttribute("albumList", service.getAlbumByLanguage(lang));
		return "allAlbums";
	}

	@RequestMapping("/album_english")
	public String getAlbumEnglish()
	{
		System.out.println("-------in english album controller----");
		return "album_english";
	}
	
	@RequestMapping("/album_hindi")
	public String getAlbumHindi()
	{
		return "album_hindi";
	}
	
	
	@RequestMapping("/generateAdvertMail")
	public String generateAdvertMail(Model m){
		
		m.addAttribute("pList",service.generateAdvertMail());
		return "redirect:/AdminLogin.jsp";
	}
	
	/*===================================searching=======================================================*/
	@RequestMapping("/search")
	public String searchSong(Model m,HttpServletRequest req,HttpSession hs)
	{
		System.out.println(req.getParameter("sText")+"jksdfjhdjsfjsdfkdskfkdskfdshfjsdkhfjsdhfkjsdkfhsdk");
		List<Song> serchedSongs=service.getSearchSongs(req.getParameter("sText"));
		m.addAttribute("sList",serchedSongs);
		return "searchedSong";
	}
	
	@RequestMapping("toIndex")
	public String goIndex(){
		return "redirect:/index.jsp";
	}
	
	
	
	
	
}
















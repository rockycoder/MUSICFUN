package com.app.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.app.pojo.Album;
import com.app.pojo.Listener;
import com.app.pojo.Song;
import com.app.service.SongService;

@Controller
@SessionAttributes({ "user" })
@RequestMapping("/user")
public class UserControl {

	@Autowired
	private SongService service;

	@RequestMapping("/gologin")
	public String goLogin() {
		System.out.println("hello........................................");
		return "Login";
	}

	
	@RequestMapping("/nowPlaying")
	public String getNowPlaying(Model m) {
		m.addAttribute("sList", service.getTopSong());
		return "userNowPlaying";
	}
	@RequestMapping("/userHome")
	public String doForward(@CookieValue("name") String nm, Model m,
			HttpServletResponse response) {

		System.out.println("==============================cookies hello     "+nm);
		Listener l = service.getValidate(nm);
		System.out.println(l);
		if (l == null)
			return "fail";
		m.addAttribute("user", l);

		return "userHome";

	}

	@RequestMapping("/login")
	public String doLogin(@RequestParam("username") String unm,
			@RequestParam("password") String pwd, Model m,
			HttpServletResponse response,HttpServletRequest request) {
		String val=request.getParameter("remember_me");
        
		Listener l = service.getValidate(unm, pwd);
		System.out.println(l);
		
		if (l == null){
			m.addAttribute("msg","Invalid Credentials");
			return "redirect:/index.jsp";
		}
			
		m.addAttribute("user", l);
		
		if (val != null) {
			System.out.println("hello........................login................"+val);
			if (val.equals("1")) {
				Cookie my_cook = new Cookie("name",unm);
				my_cook.setMaxAge(30 * 60);
				response.addCookie(my_cook);
				System.out.println(my_cook.getValue());

			}
		}
		
		if(unm.equals("funmusic13@gmail.com"))
			return "redirect:/AdminLogin.jsp";
		return "redirect:/userHome.jsp";

	}
	@RequestMapping("/logout")
	public String doLogout(HttpSession hs) {
		hs.invalidate();
		return "redirect:/index.jsp";

	}
	
	
	
	@RequestMapping("/play")
	public String getSongLocation(Model m,@RequestParam("sid") String sid,@RequestParam("lid") String lid)
	{
		System.out.println("in play =========================mnjmnjmbmnbnmbnb================== "+ sid);
		
		
		
		String url="";
		
		if(!lid.equals("unknown"))
		{
			System.out.println("sid-->"+sid+" lid-->"+lid);
			Song song=service.getClickedSong(Long.parseLong(sid),Long.parseLong(lid));
			url=song.getFileLocation();
		}
		else 
		{
			System.out.println("in controller else part");
			Song song=service.getClickedSong(Long.parseLong(sid));
			url=song.getFileLocation();
		}
		System.out.println("in play controller after else ");
		m.addAttribute("id", sid);
		m.addAttribute("surl",url);
		return "clickedSong";
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
	
	
	
	
	@RequestMapping("/allAlbums")
	public String getAlbumsHIndi(Model m,@RequestParam("lang") String lang ) {
		m.addAttribute("albumList", service.getAlbumByLanguage(lang));
		return "userAllAlbums";
	}
	
	@RequestMapping("/yourAlbum")
	public String getCurrAlbum(Model m,@RequestParam("aid") long albumId)
	{
		
		m.addAttribute("pList",service.getAlbum(albumId));
		
		return "userYourAlbum";
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
	
	@RequestMapping("/playlist")
	public String dispPlaylist(HttpSession hs,Model m){
		Listener l=(Listener)hs.getAttribute("user");
		List<Song> list=service.getPlaylist(l.getListenerId());
		m.addAttribute("slist",list);
		return "playlistSongs";
	}
	
	
	@RequestMapping("/addSong")
	public String addtoPlaylist(Model m,@RequestParam("sid") String sid,@RequestParam("lid") String lid)
	{
		
		List<Song> list = service.getAddSong(Long.parseLong(lid),
				Long.parseLong(sid));
		m.addAttribute("slist", list);
		return "playlistSongs";
	
	}
	
	@RequestMapping("/removeSong")
	public String removeSong(@RequestParam("sid") String sId,@RequestParam("lid") String lid,Model m){
		
		boolean ret=service.getRemoveSong(Long.parseLong(lid),Long.parseLong(sId));
		List<Song> list=service.getPlaylist(Long.parseLong(lid));
		m.addAttribute("slist", list);
		return "playlistSongs";
		
	}
	
	@RequestMapping("/recSong1")
	public String recommendedSong(Model m,HttpSession s)
	{
		System.out.println("  kjwhegrhwgqehjrqew    nhewgvfhgrwqekhyr cxbvhjgfweykutwqein recommende song controller mjnbashmfghgsadfhgsdhfgsdfdgsfds=====================================");
		Listener l=(Listener)s.getAttribute("user");
		
		List<Song> list=service.getRecommendedSong(l.getListenerId());
		m.addAttribute("slist",list);
		return "recSongs";
		
	}
	
	
	@RequestMapping("/recSong")
	public String recommendedSong(Model m,@RequestParam("lid") String lid)
	{
		System.out.println("  kjwhegrhwgqehjrqew    nhewgvfhgrwqekhyr cxbvhjgfweykutwqein"+lid+" recommende song controller mjnbashmfghgsadfhgsdhfgsdfdgsfds=====================================");
		
		
		List<Song> list=service.getRecommendedSong(Long.parseLong(lid));
		m.addAttribute("slist",list);
		return "recSongs";
		
	}
	
	
	
	
	
	
	
	@RequestMapping("/playPlaylist")
	public String getPlaylistSongLocation(Model m,@RequestParam("sid") String sid)
	{
		String url="";
		String name="";
	
		Song song=service.getClickedSong(Long.parseLong(sid));
		url=song.getFileLocation();
		name=song.getSongName();
	
		m.addAttribute("id", sid);
		m.addAttribute("surl",url);
		m.addAttribute("sname",name);
		return "clickedSong";
	}

	
	/*@RequestMapping("/recSongAjax")
	public String recommendedSongAjax(Model m,@RequestParam("email") String email)
	{
		
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		
		
		System.out.println("email::::::::::::::::"+email);
		
		System.out.println(email);
		
		Listener l=service.getValidate(email);
		if(l!=null)
		{
		System.out.println(l.toString());
		List<Song> list=service.getRecommendedSong(l.getListenerId());
		m.addAttribute("slist",list);
		return "recSongs";
		}
		else
		{
			System.out.println("error occured in fetching the listener record");
			return "fail";
		}
		
		
	}*/
	
	@RequestMapping("/forgotPassword")
	public String autoEmail(@RequestParam("email") String unm,Model m) {
		String ret=service.generateForgotMail(unm);
		m.addAttribute("msg2",ret);
		return "redirect:/index.jsp";

	}

	@RequestMapping("/search")
	public String searchSong(Model m,HttpServletRequest req,HttpSession hs)
	{
		List<Song> serchedSongs=service.getSearchSongs(req.getParameter("sText"));
		m.addAttribute("sList",serchedSongs);
		return "searchedSong";
	}
}














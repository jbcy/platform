package model;

import java.util.List;


public class AppType {

	private String type;
	private List<App> joined;
	private List<App> newForMe;
	private List<App> all;
	public AppType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public List<App> getJoined() {
		return joined;
	}
	public void setJoined(List<App> joined) {
		this.joined = joined;
	}
	
	
	public List<App> getNewForMe() {
		return newForMe;
	}
	public void setNewForMe(List<App> newForMe) {
		this.newForMe = newForMe;
	}
	public List<App> getAll() {
		return all;
	}
	public void setAll(List<App> all) {
		this.all = all;
	}
	
	public App checkJoined(int id) {
		for (int i = 0; i < joined.size(); i++) {
			if (joined.get(i).getId() == id) {
				return joined.get(i);
			}
		}
		return null;
	}
	
	public App getApp(int id) {
		for (int i = 0; i < all.size(); i++) {
			if (all.get(i).getId() == id) {
				return all.get(i);
			}
		}
		return null;
	}
}

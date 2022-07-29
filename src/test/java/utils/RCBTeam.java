package utils;

import java.util.List;

public class RCBTeam {

	private String name;
	private String location;
	private List<RCBPlayer> player;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<RCBPlayer> getPlayer() {
		return player;
	}
	public void setPlayer(List<RCBPlayer> player) {
		this.player = player;
	}
	
}

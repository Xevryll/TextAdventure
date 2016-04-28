import java.util.*;

public class RoomManager {
	
	private ArrayList<Room> rooms = new ArrayList<Room>();
	private ArrayList<String> roomDescriptions = new ArrayList<String>();
	
	private Room startRoom;
	
	public RoomManager() {
		registerRoomInfo();
		Collections.shuffle(roomDescriptions);
		for(int i = 1; i<=4; i++) {
			for(int j = 1; j<=4; j++) {
				boolean t = false;
				String temp = getRoomInfo();
				String te = "" + temp.charAt(0);
				Random rand = new Random();
				if(rand.nextInt(100) <= 32) {
					t=true;
				}
				Room room = new Room(i, j, temp);
				if(!(room.getInfo().contains("woke up"))) {
					if(t) {
						Skeleton skel = new Skeleton();
						skel.setRoom(room);
						room.setInfo("" + temp.charAt(0) + "S");
					}
				}
				if (temp.contains("woke up")) {
					startRoom=room;
				}
				rooms.add(room);
				t=false;
			}
		}
	}
	
	public String getRoomInfo() {
		Collections.shuffle(roomDescriptions);
		String temp = roomDescriptions.get(0);
		roomDescriptions.remove(0);
		return temp;
	}
	
	private void registerRoomInfo() {
		roomDescriptions.add("A You are standing on flat ground. To your right are trees and behind you are a lot of webs.");
		roomDescriptions.add("B You are standing in between a bunch of spider webs. This gives you the creeps. Behind you is a sidewalk, to your right, some leaves and in front of you is flat land.");
		roomDescriptions.add("C You are walking on a sidewalk. In front of you are more webs, to the right is a broken down car and behind you... A house? It looks like it is occupied!");
		roomDescriptions.add("D You win.");
		roomDescriptions.add("E You are surrounded by trees. To your right is a log on the ground, behind you, a pile of leaves and to your right, a patch of flat land.");
		roomDescriptions.add("F You are standing on top of leaves. There is something shiny. To your right is a trash pile, in front some trees, to your left some webs and behind you a broken down car.");
		roomDescriptions.add("G You are standing next to an old 2005 Red Mustang. It's a convertible with paint chipped off of the hood. To your left is a sidewalk, to your right, the end of a dirt path. Behind you is a ditch and in front of you is a pile of leaves.");
		roomDescriptions.add("H You are standing in a ditch. To your right is a dirt path, to your left... A home? In front of you is a broken down car.");
		roomDescriptions.add("I You are sitting down on the log. To your left is a burnt down building. Behind you, there is a ");
		roomDescriptions.add("J You are standing on top of some trash. It smells really bad. To your right is a rock, to your left is a pile of leaves. Forward there is a log on the ground and bahind you is the end of a dirt path.");
		roomDescriptions.add("K You are at the end of the dirt path. To your right is an abandoned shack. To your left, a car. What's that smell? In front of you, you see the trash pile. Behind you the dirt path continues.");
		roomDescriptions.add("L You are standing on top of a dirt path. To your right is a cemetary, to your left, a ditch and in front of you, the end of the dirt path.");
		roomDescriptions.add("* This is where I woke up... What happened? It seems like my friends left me. We were on a camping trip for the weekend. Why would they ditch me? Could I not get up? Was I knocked out?");
		roomDescriptions.add("N What's around me? Behind me there is a big rock. To my left there is a log laying on the ground.");
		roomDescriptions.add("O You are about two feet from a rock about as tall as your knee. In front of you there is a campsite. To your left is a garbage pile. Behind you is a cemetary.");
		roomDescriptions.add("P You are standing next to an empty shack. Behind you is the cemetary and in front, a weird rock. To the left you see the end of a dirt path.");
		roomDescriptions.add("Q You are in a cemetary. To your left you see a dirt path. In front of you, a shack.");
	}
	
	@SuppressWarnings("unchecked")
	public Room getRoomAt(int x, int y) {
		for(Room r : rooms) {
			if(r.getX() == x && r.getY() == y) {
				return r;
			}
		}
		System.out.println("Room not found...");
		return new Room();
	}
	
	public Room getStartRoom() {
		return startRoom;
	}
}
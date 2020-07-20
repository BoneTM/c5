//package com.bone.c5.service.impl;
//
//import com.bone.c5.service.LobbyService;
//import org.springframework.stereotype.Service;
//
//import javax.websocket.Session;
//import java.util.*;
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// * @author Bone
// * @Package com.bone.c5.service.impl
// * @date 2020/6/28 10:08
// */
//@Service
//public class LobbyServiceImpl implements LobbyService {
//    private static final Map<String, Set<String>> lobbies = new ConcurrentHashMap<>();
//    private static final Map<String, Boolean> players = new ConcurrentHashMap<>();
//
//    @Override
//    public String create(String username) {
//        int size = 6;
//        String sources = "0123456789";
//        Random random = new Random();
//        StringBuffer lobbyId;
//        do {
//            lobbyId = new StringBuffer();
//            for (int j = 0; j < size; j++) {
//                lobbyId.append(sources.charAt(random.nextInt(9)));
//            }
//        } while (lobbies.containsKey(lobbyId));
//        Set<String> users = new HashSet();
//        users.add(username);
//        lobbies.put(lobbyId.toString(), users);
//
//        return lobbyId.toString();
//    }
//
//    @Override
//    public Boolean playerJoin(String username) {
//        players.put(username, false);
//        return true;
//    }
//
//    @Override
//    public Boolean playerLeave(String username) {
//        players.remove(username);
//        return true;
//    }
//
//    @Override
//    public List<String> playerList() {
//        return new ArrayList<>(players.keySet());
//    }
//}

package com.bone.c5.controller;

import com.bone.c5.service.LobbyService;
import com.bone.c5.util.RestCodeEnum;
import com.bone.c5.util.Result;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.Session;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Bone
 * @Package com.bone.c5.controller
 * @date 2020/6/26 22:35
 */
@RestController
public class LobbyController {
    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    @Resource
    private SimpUserRegistry simpUserRegistry;

    @Resource
    private LobbyService LobbyService;

    private static final Map<String, Set<Session>> lobbies = new ConcurrentHashMap<>();

//    @MessageMapping("/broadcast")
//    @SendTo("/topic/response")
//    public Result join() throws Exception {
//        System.out.println(simpUserRegistry.getUsers());
//        return Result.build(RestCodeEnum.SUCCESS);
//    }

    @PostMapping("/lobby")
    public Result create(Principal principal) throws Exception {
        return Result.build(RestCodeEnum.SUCCESS).data(LobbyService.create(principal.getName()));
    }
    @GetMapping("/lobby/{lobbyId}")
    public Result create(Principal principal, @PathVariable String lobbyId) throws Exception {
        return Result.build(RestCodeEnum.SUCCESS).data(LobbyService.playerList());
    }

    @PostMapping("/lobby/{lobbyId}/player")
    public Result join(Principal principal, @PathVariable String lobbyId) throws Exception {
        LobbyService.playerJoin(principal.getName());
        List<String> list = LobbyService.playerList();
        for (int i = 0; i < list.size(); i++) {
            String username = list.get(i);
            simpMessagingTemplate.convertAndSendToUser(username, "/queue/message", "playerJoin");
        }
        return Result.build(RestCodeEnum.SUCCESS);
    }

    @DeleteMapping("/lobby/{lobbyId}/player")
    public Result leave(Principal principal, @PathVariable String lobbyId) throws Exception {
        LobbyService.playerLeave(principal.getName());
        List<String> list = LobbyService.playerList();
        for (int i = 0; i < list.size(); i++) {
            String username = list.get(i);
            simpMessagingTemplate.convertAndSendToUser(username, "/queue/message", "playerJoin");
        }
        return Result.build(RestCodeEnum.SUCCESS);
    }

}

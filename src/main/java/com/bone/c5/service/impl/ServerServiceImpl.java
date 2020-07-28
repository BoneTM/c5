package com.bone.c5.service.impl;

import com.bone.c5.dto.server.ServerAddDTO;
import com.bone.c5.entity.ServerEntity;
import com.bone.c5.repository.ServerRepository;
import com.bone.c5.service.ServerService;
import com.bone.c5.util.BizException;
import com.bone.c5.vo.server.ServerInfoVO;
import com.ibasco.agql.protocols.valve.source.query.client.SourceQueryClient;
import com.ibasco.agql.protocols.valve.source.query.pojos.SourcePlayer;
import com.ibasco.agql.protocols.valve.source.query.pojos.SourceServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @author Bone
 * @Package com.bone.c5.service.impl
 * @date 2020/7/8 9:55
 */
@Service
public class ServerServiceImpl implements ServerService {
    @Resource
    private ServerRepository serverRepository;
    @Resource
    private SourceQueryClient sourceQueryClient;

    @Override
    public ServerEntity add(ServerAddDTO serverAddDTO) {
        return serverRepository.save(ServerEntity.builder().name(serverAddDTO.getName()).ip(serverAddDTO.getIp()).port(serverAddDTO.getPort()).build());
    }

    @Override
    public ServerInfoVO getInfoByServerId(Integer serverId) {
        ServerEntity serverEntity = serverRepository.findById(serverId).orElseThrow(() -> new BizException("服务器未找到"));
        InetSocketAddress inetSocketAddress = new InetSocketAddress(serverEntity.getIp(), serverEntity.getPort());
        CompletableFuture<SourceServer> serverinfo = sourceQueryClient.getServerInfo(inetSocketAddress);
        CompletableFuture<List<SourcePlayer>> players = sourceQueryClient.getPlayers(inetSocketAddress);
        SourceServer sourceServer;
        List<String> sourcePlayers;
        try {
            sourceServer = serverinfo.get();
        } catch (Exception e) {
            throw new BizException("服务器信息加载失败");
        }

        try {
            sourcePlayers = players.get().stream().map(x -> x.getName()).collect(Collectors.toList());
        } catch (Exception e) {
            sourcePlayers = new ArrayList<>();
        }

        return new ServerInfoVO(serverEntity.getIp(), serverEntity.getPort(), sourceServer.getName(), sourceServer.getMapName(), sourceServer.getNumOfPlayers()
                , sourceServer.getMaxPlayers(), sourcePlayers);
//        List<String> players = getPlayersByServerId(serverId);
//        byte numOfPlayers = sourceServer.getNumOfPlayers();
//        if ("GOTV".equals(players.get(0))) {
//            players.remove(0);
//            numOfPlayers--;
//        }

    }

    @Override
    public List<ServerEntity> list() {
        return serverRepository.findAll();
    }
}

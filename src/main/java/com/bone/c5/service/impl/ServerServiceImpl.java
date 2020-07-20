package com.bone.c5.service.impl;

import com.bone.c5.dto.server.ServerAddDTO;
import com.bone.c5.entity.ServerEntity;
import com.bone.c5.repository.ServerRepository;
import com.bone.c5.service.ServerService;
import com.bone.c5.util.BizException;
import com.bone.c5.vo.server.ServerInfoVO;
import com.bone.c5.vo.server.ServerPlayerVO;
import com.ibasco.agql.protocols.valve.source.query.client.SourceQueryClient;
import com.ibasco.agql.protocols.valve.source.query.pojos.SourcePlayer;
import com.ibasco.agql.protocols.valve.source.query.pojos.SourceServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

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
        CompletableFuture<SourceServer> sourceServerCompletableFuture = sourceQueryClient.getServerInfo(new InetSocketAddress(serverEntity.getIp(), serverEntity.getPort()));

        SourceServer sourceServer = sourceServerCompletableFuture.join();
        return new ServerInfoVO(serverEntity.getIp(), serverEntity.getPort(), sourceServer.getName(), sourceServer.getMapName(),
                sourceServer.getNumOfPlayers(), sourceServer.getMaxPlayers());
    }

    @Override
    public List<ServerPlayerVO> getPlayersByServerId(Integer serverId) {
        ServerEntity serverEntity = serverRepository.findById(serverId).orElseThrow(() -> new BizException("服务器未找到"));
        System.out.println(serverEntity);
        CompletableFuture<List<SourcePlayer>> players = sourceQueryClient.getPlayers(new InetSocketAddress(serverEntity.getIp(), serverEntity.getPort()));

        List<SourcePlayer> sourcePlayers = players.join();
        System.out.println(sourcePlayers);
        return new ArrayList<>();
    }


    @Override
    public List<ServerEntity> list() {
        return serverRepository.findAll();
    }
}

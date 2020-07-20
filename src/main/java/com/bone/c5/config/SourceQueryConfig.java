package com.bone.c5.config;

import com.bone.c5.security.JwtTokenUtil;
import com.bone.c5.security.JwtUserDetailsService;
import com.ibasco.agql.protocols.valve.source.query.client.SourceQueryClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * @author Bone
 * @Package com.bone.c5.config
 * @date 2020/6/26 11:11
 */
@Configuration
public class SourceQueryConfig {
    @Bean
    public SourceQueryClient sourceQueryClient() {
        return new SourceQueryClient();
    }
}

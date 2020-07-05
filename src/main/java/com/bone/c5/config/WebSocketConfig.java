package com.bone.c5.config;

import com.bone.c5.security.JwtTokenUtil;
import com.bone.c5.security.JwtUserDetailsService;
import org.apache.commons.lang3.StringUtils;
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
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Bone
 * @Package com.bone.c5.config
 * @date 2020/6/26 11:11
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private JwtUserDetailsService jwtUserDetailsService;
    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOrigins("*");
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new ChannelInterceptor() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
                if (StompCommand.CONNECT.equals(accessor.getCommand())) {
                    String auth = accessor.getFirstNativeHeader(jwtTokenUtil.getHeader());
                    if (StringUtils.isNotBlank(auth)) {
                        String username = "";
                        try {
                            username = jwtTokenUtil.getUsernameFromToken(auth);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (StringUtils.isNotBlank(username)) {
                            UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);
                            if (jwtTokenUtil.validateToken(auth, userDetails)) {

                                try {
                                    Principal user = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword()));
                                    accessor.setUser(user);
                                } catch (AuthenticationException authenticationException) {

                                }
                            }
                        }
                    }
                }

                return message;
            }
        });
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic", "/queue");
    }
}

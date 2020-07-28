package com.bone.c5.config;

import com.ibasco.agql.protocols.valve.source.query.client.SourceQueryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

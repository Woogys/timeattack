package com.sparta.weeklytestspring.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
@PropertySource("classpath:env.properties")
public class S3Manager {
    private final AmazonS3Client amazonS3Client;
}

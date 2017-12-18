package com.rahansazeh.apiserver.services.impl;

import com.rahansazeh.apiserver.services.HeartbeatService;
import org.springframework.stereotype.Service;

@Service
public class HeartbeatServiceImpl implements HeartbeatService {
    @Override
    public boolean checkHeartbeat() {
        return true;
    }
}

package com.example.gateway.config;/*
 * @author p78o2
 * @date 2019/10/12
 */

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;
import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.logging.Logger;

public class CustomLoadBalancerRule extends AbstractLoadBalancerRule {

//    private static final Logger LOG = LoggerFactory.getLogger(CustomLoadBalancerRule.class);

    private static final String DEFAULT_KEY = "default";

    private static final String RULE_ONE = "one";

    private static final String RULE_RANDOM = "random";

    private static final String RULE_HASH = "hash";

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        List<Server> servers = this.getLoadBalancer().getReachableServers();
        if (CollectionUtils.isEmpty(servers)) {
            return null;
        }
        // 只有一个服务，则默认选择
        if (servers.size() == 1) {
            return debugServer(servers.get(0), RULE_ONE);
        }
        // 多个服务时，当cookie不存在时，随机选择
        if (key == null || DEFAULT_KEY.equals(key)) {
            return debugServer(randomChoose(servers), RULE_RANDOM);
        }
        // 多个服务时，cookie存在，根据cookie hash
        return debugServer(hashKeyChoose(servers, key), RULE_HASH);
    }

    /**
     * 随机选择一个服务
     *
     * @param servers 可用的服务列表
     * @return 随机选择一个服务
     */
    private Server randomChoose(List<Server> servers) {
        int randomIndex = RandomUtils.nextInt(servers.size());
        return servers.get(randomIndex);
    }

    /**
     * 根据key hash选择一个服务
     *
     * @param servers 可用的服务列表
     * @param key     自定义key
     * @return 根据key hash选择一个服务
     */
    private Server hashKeyChoose(List<Server> servers, Object key) {
        int hashCode = Math.abs(key.hashCode());
        if (hashCode < servers.size()) {
            return servers.get(hashCode);
        }
        int index = hashCode % servers.size();
        return servers.get(index);
    }

    /**
     * debug选择的server
     *
     * @param server 具体的服务实例
     * @param name   策略名称
     * @return 服务实例
     */
    private Server debugServer(Server server, String name) {
//        LOG.debug("choose server: {}, rule: {}", server, name);
        return server;
    }
}
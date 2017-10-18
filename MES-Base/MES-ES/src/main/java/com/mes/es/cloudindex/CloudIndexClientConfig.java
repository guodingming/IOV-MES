package com.mes.es.cloudindex;

import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.util.List;

/**
 * Created by Administrator on 2015/8/27.
 */

public class CloudIndexClientConfig {

    /**
     * 客户端设置
     */
    public static final String CLIENT_TRANSPORT_SNIFF = "client.transport.sniff";
    public static final String CLUSTER_NAME = "cluster.name";
    public static final String CLIENT_TRANSPORT_IGNORE_CLUSTRER_NAME = "client.transport.ignore_cluster_name";
    public static final String CLIENT_TRANSPORT_PING_TIMEOUT = "client.transport.ping_timeout";
    public static final String CLIENT_TRANSPORT_NODES_SAMPLER_INTERVAL = "client.transport.nodes_sampler_interval";

    /**
     * 服务端创建index时参数
     */
    public static final String SETTING_NUMBER_OF_SHARDS = "number_of_shards";
    public static final String SETTING_NUMBER_OF_RESPLICAS = "number_of_replicas";

    /**
     * 集群名称
     */
    private String clusterName;

    /**
     * 你可以设置client.transport.sniff为true来使客户端去嗅探整个集群的状态，把集群中其它机器的ip地址加到客户端中，
     * 这样做的好处是一般你不用手动设置集群里所有集群的ip到连接客户端，它会自动帮你添加，并且自动发现新加入集群的机器。
     */
    private boolean transportSniff = true;

    /**
     * 是否忽略集群名称
     */
    private boolean ignoreClusterName = false;

    /**
     * ping的超时时间 默认5秒
     */
    private int pingTimeOut;

    /**
     * ping的间隔 默认5秒
     */
    private int interval;

    private List<InetSocketTransportAddress> hosts;

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public boolean isTransportSniff() {
        return transportSniff;
    }

    public void setTransportSniff(boolean transportSniff) {
        this.transportSniff = transportSniff;
    }

    public List<InetSocketTransportAddress> getHosts() {
        return hosts;
    }

    public void setHosts(List<InetSocketTransportAddress> hosts) {
        this.hosts = hosts;
    }
}

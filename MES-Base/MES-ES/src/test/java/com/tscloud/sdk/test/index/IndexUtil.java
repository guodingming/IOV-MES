package com.tscloud.sdk.test.index;

import com.mes.es.cloudindex.CloudIndexClient;
import com.mes.es.cloudindex.CloudIndexClientConfig;
import com.mes.es.cloudindex.ICloudIndexManager;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 147458 on 2017/5/13.
 */
public class IndexUtil {
    public static void main(String[] args) throws Exception {
        String host = args[0];
        String port = args[1];
        String clusterName = args[2];
        String fromIndex = args[3];
        String fromType = args[4];
        String toIndex = args[5];
        String toType = args[6];

        CloudIndexClientConfig config = new CloudIndexClientConfig();
        config.setClusterName(clusterName);
        config.setTransportSniff(true);
        List<InetSocketTransportAddress> hosts = new ArrayList<InetSocketTransportAddress>();
        hosts.add(new InetSocketTransportAddress(InetAddress.getByName(host), Integer.parseInt(port)));
        config.setHosts(hosts);
        CloudIndexClient client = new CloudIndexClient(config);

        ICloudIndexManager manager = client.getManager();

        copy(client, fromIndex, fromType, toIndex, toType);
    }

    private static void copy(CloudIndexClient client, String fromIndex, String fromType, String toIndex, String toType) throws Exception {
        List<Map<String, Object>> docs = client.searchByQuery(fromIndex, fromType, QueryBuilders.matchAllQuery());
        client.bulkIndex(toIndex, toType, docs);
    }
}

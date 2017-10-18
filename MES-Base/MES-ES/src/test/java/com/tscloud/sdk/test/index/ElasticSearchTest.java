package com.tscloud.sdk.test.index;

import com.mes.es.cloudindex.CloudIndexClientConfig;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;

//import oracle.sql.BLOB;

/**
 * Created by Administrator on 2016/9/22.
 */
public class ElasticSearchTest {
    public static void main( String[] args ) throws IOException, SQLException {
        Settings settings = Settings.builder()
                .put(CloudIndexClientConfig.CLIENT_TRANSPORT_SNIFF, true)
                .put(CloudIndexClientConfig.CLUSTER_NAME, "yltest")
                .build();
        TransportClient client =new PreBuiltTransportClient(settings) ;
        InetSocketTransportAddress host = new InetSocketTransportAddress( InetAddress.getByName("192.168.13.82"), 9300 );
        client.addTransportAddress( host );
/*        Map<String,Object> map = new HashMap<String,Object>();
        map.put("NO",1232.0);
        map.put("C1","test");
        *//*ByteBuffer bb = null;
        ChannelBuffer cb = DirectChannelBufferFactory.getInstance().getBuffer( bb );
        ChannelBufferBytesReference b = new ChannelBufferBytesReference( cb );*//*
        map.put("B1", Base64.getEncoder().encode( "test".getBytes() ) );
        map.put("C2","test");
        map.put("name","fdsaf");
        client.prepareIndex("yl_dbindex","dd").setSource( map ).execute().actionGet();*/
        //BytesRef br = new BytesRef( Base64.getEncoder().encode( "test".getBytes() ) );
        //BLOB b = new BLOB( null );

        //ChannelBuffers.dynamicBuffer()
        //ChannelBufferBytesReference channelBufferBytesReference = new ChannelBufferBytesReference();
        IndexResponse indexResponse = client.prepareIndex("yl_dbindex",
                "dddd", "1")
                .setSource(XContentFactory.jsonBuilder().startObject()
                                .field("NO", 1232.0)
                                .field("C1", "test")
                                        //.field("B1",  )
                                        //.field("B1", br)
                                        //field("B2", "test".getBytes())
                                /*.field("B1", new BytesReference( ) {
                                    @Override
                                    public byte get(int index) {
                                        try {
                                            return b.getBytes(1,index)[0];
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        }
                                        return Byte.parseByte(null);
                                    }

                                    @Override
                                    public int length() {
                                        try {
                                            return (int) b.length();
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        }
                                        return 0;
                                    }

                                    @Override
                                    public BytesReference slice(int from, int length) {
                                        b.getBinaryStream( from, length );
                                        return null;
                                    }

                                    @Override
                                    public StreamInput streamInput() {
                                        return null;
                                    }

                                    @Override
                                    public void writeTo(OutputStream os) throws IOException {

                                    }

                                    @Override
                                    public void writeTo(GatheringByteChannel channel) throws IOException {

                                    }

                                    @Override
                                    public byte[] toBytes() {
                                        return new byte[0];
                                    }

                                    @Override
                                    public BytesArray toBytesArray() {
                                        return null;
                                    }

                                    @Override
                                    public BytesArray copyBytesArray() {
                                        return null;
                                    }

                                    @Override
                                    public ChannelBuffer toChannelBuffer() {
                                        return null;
                                    }

                                    @Override
                                    public boolean hasArray() {
                                        return false;
                                    }

                                    @Override
                                    public byte[] array() {
                                        return new byte[0];
                                    }

                                    @Override
                                    public int arrayOffset() {
                                        return 0;
                                    }

                                    @Override
                                    public String toUtf8() {
                                        return null;
                                    }

                                    @Override
                                    public BytesRef toBytesRef() {
                                        return null;
                                    }

                                    @Override
                                    public BytesRef copyBytesRef() {
                                        return null;
                                    }
                                })*/
                                .field("B1","test".getBytes())
                                .field("C2", "TEST")
                                .field("name", "TEST")
                                .endObject()
                ).execute().actionGet();
    }
}

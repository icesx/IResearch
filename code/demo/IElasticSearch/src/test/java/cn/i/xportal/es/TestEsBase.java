package cn.i.xportal.es;

import java.net.InetAddress;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;

public class TestEsBase {
	public void testQuery() {
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("host1"), 9300))
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("host2"), 9300));
		SearchResponse response = client.prepareSearch("index1", "index2").setTypes("type1", "type2")
				.setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(QueryBuilders.termQuery("multi", "test")) // Query
				.setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18)) // Filter
				.setFrom(0).setSize(60).setExplain(true).get();
	}
}

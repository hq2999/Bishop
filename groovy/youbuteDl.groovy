
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.text.StringEscapeUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

	
	RequestConfig requestConfig = RequestConfig.custom().
                setConnectTimeout(30000)
                .setConnectionRequestTimeout(30000)
                .setSocketTimeout(30000)
                .setRedirectsEnabled(true)
                .setProxy(new HttpHost("127.0.0.1", 10809, "http")).build();
	
	
	
	public Connection getConnection(String dbFilePath) {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:" + dbFilePath);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return conn;
	}


	public int dlComplete(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		int i = -1;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select count(*) c from no_download");
			rs.next();
			i=rs.getInt(0);
		} catch (Exception e) {
			
		} finally {
			try {
				rs.close();
				st.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return i;
    }
	
	
	
	public List<Map<String, String>> getDlList(Connection conn) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from no_download");

			while(rs.next()) {
				Map<String,String> item = new HashMap<String, String>();
				item.put("id", rs.getString("id"));
				item.put("url", rs.getString("A"))
				list.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
    }
	
public class CheckThread extends Thread{
	private String url;
	private String ix;
	private Connection conn;
	private RequestConfig requestConfig;
	
	public CheckThread(Connection conn, String ix, String url, RequestConfig requestConfig) {
		this.ix = ix;
		this.url = url;
		this.conn = conn;
		this.requestConfig = requestConfig;
	}
	
	public void addDl(Connection conn, String id, String url) {
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("insert into dl (id,a) values ('" + id + "','" + url + "')");
		} catch (Exception e) {
			//e.printStackTrace();
		}
    }
	
	@Override
	public void run() {
		def r = sendPost(this.url, 0)
		r = StringEscapeUtils.unescapeJava(r);

		def pat = ~/.+href="([^"]+)".+/
		def matcher = r=~pat;
		
		if(matcher.find()) {
			addDl(this.conn, this.ix, matcher[0][1]);
			System.out.println(this.ix);
		}
	}
	
	
	//public String[] getId(String url){
	public String getId(String url){
		CloseableHttpClient httpClient = HttpClients.createDefault();
        //配置超时时间
        
         
        HttpPost httpPost = new HttpPost("https://www.y2mate.com/mates/en65/analyze/ajax");
		httpPost.setConfig(this.requestConfig);
		
		httpPost.setHeader("referer", "https://www.y2mate.com/youtube/" + url)
		httpPost.setHeader("user-agent" , "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36")
		httpPost.setHeader("origin", "https://www.y2mate.com")
		httpPost.setHeader("sec-fetch-dest", "empty")
		httpPost.setHeader("sec-fetch-mode", "cors")
		httpPost.setHeader("sec-fetch-site", "same-site")
		httpPost.setHeader("cookie", "_ga=GA1.2.1330316045.1578662060; __cfduid=d429a734356639d7fb4cc4f90948cdcea1601086293; PHPSESSID=nsvbo1l8pvjuu2vtimjo8425h3; _gid=GA1.2.1776929603.1601086326; __atuvc=2%7C35%2C1%7C36%2C2%7C37%2C0%7C38%2C1%7C39; __atuvs=5f6ea50f79340a73000")

		
        //装配post请求参数
        List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>(); 
		
        list.add(new BasicNameValuePair("ajax", "1"));  //请求参数
		list.add(new BasicNameValuePair("q_auto", "0"));  //请求参数
		list.add(new BasicNameValuePair("url", "https://www.youtube.com/watch?v=" + url)); //请求参数
        String strResult = "";
        
        try {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8"); 
            //设置post求情参数
            httpPost.setEntity(entity);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            
            if(httpResponse != null){ 
                //System.out.println(httpResponse.getStatusLine().getStatusCode());
                if (httpResponse.getStatusLine().getStatusCode() == 200) {
                    strResult = EntityUtils.toString(httpResponse.getEntity());
                } else if (httpResponse.getStatusLine().getStatusCode() == 400) {
                    strResult = "Error Response: " + httpResponse.getStatusLine().toString();
                } else if (httpResponse.getStatusLine().getStatusCode() == 500) {
                    strResult = "Error Response: " + httpResponse.getStatusLine().toString();
                } else {
                    strResult = "Error Response: " + httpResponse.getStatusLine().toString();
                } 
            }
			
			// println strResult
            
        } catch (Exception e) {
			e.printStackTrace()
        }finally {
            try {
                if(httpClient != null){
                    httpClient.close(); //释放资源
                }
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
		def r = StringEscapeUtils.unescapeJava(strResult);
		//println r
		
		def pat = ~/.*"([0-9a-z]{24})".*/
		def matcher = r=~pat;
		//println(matcher[0][1])
        String id = matcher[0][1]
		
		//pat = ~/.+ k_token\s*:\s*"([^"]+)".+/
		//matcher = r=~pat;
		
		//String token = matcher[0][1]
		
		//return [id, token];
		//println id
		return id
	}
	
	
	
	public String sendPost(String url, int times) {
		
		def id = getId(url)
		//def _id = id[0]
		//def token = id[1]
		def _id = id
		
		
		CloseableHttpClient httpClient = HttpClients.createDefault();

        //HttpPost httpPost = new HttpPost("https://mate10.y2mate.com/analyze/ajax");
		HttpPost httpPost = new HttpPost("https://www.y2mate.com/mates/convert");    //720p
		
		
        //设置超时时间
        httpPost.setConfig(this.requestConfig);
		
		httpPost.setHeader("referer", "https://www.y2mate.com/youtube/" + url)
		
		httpPost.setHeader("user-agent" , "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36")
		httpPost.setHeader("origin", "https://www.y2mate.com")
		
		httpPost.setHeader("sec-fetch-dest", "empty")
		httpPost.setHeader("sec-fetch-mode", "cors")
		httpPost.setHeader("sec-fetch-site", "same-site")
		
        //装配post请求参数
        List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>(); 
        list.add(new BasicNameValuePair("ajax", "1"));  //请求参数
        //list.add(new BasicNameValuePair("url", url)); //请求参数
        
		list.add(new BasicNameValuePair("ftype", "mp4")); //请求参数
		//list.add(new BasicNameValuePair("fquality", "480")); //请求参数

//		list.add(new BasicNameValuePair("fquality", "720")); //请求参数
		list.add(new BasicNameValuePair("fquality", "480")); //请求参数

		list.add(new BasicNameValuePair("v_id", url)); //请求参数
		list.add(new BasicNameValuePair("type", "youtube")); //请求参数
		list.add(new BasicNameValuePair("_id", _id)); //请求参数
		//list.add(new BasicNameValuePair("k_token", token)); //请求参数
        String strResult = "";
        
        try {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8"); 
            //设置post求情参数
            httpPost.setEntity(entity);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            
            if(httpResponse != null){ 
                //System.out.println(httpResponse.getStatusLine().getStatusCode());
                if (httpResponse.getStatusLine().getStatusCode() == 200) {
                    strResult = EntityUtils.toString(httpResponse.getEntity());
                } else if (httpResponse.getStatusLine().getStatusCode() == 400) {
                    strResult = "Error Response: " + httpResponse.getStatusLine().toString();
                } else if (httpResponse.getStatusLine().getStatusCode() == 500) {
                    strResult = "Error Response: " + httpResponse.getStatusLine().toString();
                } else {
                    strResult = "Error Response: " + httpResponse.getStatusLine().toString();
                } 
            }else{
                 
            }
            
        } catch (Exception e) {
			//e.printStackTrace();
            if(times<3) {
				Thread.sleep(1000)
				sendPost(url, times + 1)
			}
        }finally {
            try {
                if(httpClient != null){
                    httpClient.close(); //释放资源
                }
            } catch (IOException e) {
               // e.printStackTrace();
            }
        }
        return strResult;
	}	
} 

	conn = getConnection("ytdl.db");
	
	remain = dlComplete(conn);
	//println(remain)
	
	if(remain==0){
		System.exit(0);
	}

	List<String> urls = getDlList(conn);
	println(urls.size());
	
	for(int i=0;i<urls.size();i++){
		Map<String, String> item = urls.get(i);
		Thread.sleep(3000)
		CheckThread ct = new CheckThread(conn, item.get("id"), item.get("url"), requestConfig);
		ct.start();
	}
	
	
	
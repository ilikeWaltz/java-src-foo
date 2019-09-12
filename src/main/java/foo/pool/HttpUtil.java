package foo.pool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtil {

	public static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

	public static String getKv(String url, Map<String, String> headers, Map<String, String> kvParams) throws Exception {
		return connect("GET", url, headers, kvParams);
	}

	/**
	 * 
	 * @param url
	 * @param headers
	 * @param kvParams
	 * @return
	 * @throws Exception
	 */
	public static String postKv(String url, Map<String, String> headers, Map<String, String> kvParams)
			throws Exception {
		return connect("POST", url, headers, kvParams);
	}

	private static String connect(String method, String url, Map<String, String> headers, Map<String, String> kvParams)
			throws Exception {

		logger.info("url: {}", url);
		logger.info("headers: {}", headers);
		logger.info("params: {}", kvParams);

		StringBuilder sb = new StringBuilder();

		HttpURLConnection huc = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;

		try {

			StringBuilder paramsStr = new StringBuilder();
			if (kvParams != null) {
				Set<Entry<String, String>> entrySet = kvParams.entrySet();
				for (Entry<String, String> entry : entrySet)
					paramsStr.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
			}
			logger.info("params str: {}", paramsStr);

			if ("POST".equals(method)) {
				URL urlEntity = new URL(url);
				huc = (HttpURLConnection) urlEntity.openConnection();
			} else {
				URL urlEntity = new URL(url + "?" + paramsStr.toString());
				huc = (HttpURLConnection) urlEntity.openConnection();
			}

			huc.setRequestMethod(method);
			huc.setUseCaches(false);

			huc.setDoOutput(true);
			huc.setDoInput(true);

//			huc.setConnectTimeout(60000); // TODO
//			huc.setReadTimeout(60000);

			if (headers != null) {
				Set<Entry<String, String>> entrySet = headers.entrySet();
				for (Entry<String, String> entry : entrySet)
					huc.setRequestProperty(entry.getKey(), entry.getValue());
			}

			if ("POST".equals(method)) {
				osw = new OutputStreamWriter(huc.getOutputStream(), "UTF-8");
				osw.write(paramsStr.toString());
				osw.close();
			} else {
				huc.connect();
			}

			int responseCode = huc.getResponseCode();
			logger.info("responseCode: {}", responseCode);

			String line = "";
			br = new BufferedReader(new InputStreamReader(huc.getInputStream(), "utf-8"));
			while ((line = br.readLine()) != null) {
				sb.append(line.trim());
			}
			logger.info("response: {}", sb.toString());

		} finally {

			if (osw != null)
				try {
					osw.close();
				} catch (IOException e) {
				}

			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
				}

			if (huc != null)
				huc.disconnect();

		}

		return sb.toString();
	}

}

package com.hao.json;

import net.sf.json.JSONObject;
import com.hao.util.Utils;
import java.util.HashMap;
import java.util.Map;

/**
 * Java下转换json模板
 * 
 * @author hao
 */
public class TemplateJsonForJava {

	public static final String url_Address = "http://www.wqyunpan.com/bookQr/resource/resDetail";// 地址
	// public static final String id = "43626";// 参数

	/**
	 * 取得视频实际地址
	 */
	public static String SelectDownUrl(int id) {
		String result = null;
		String videoUrl = null;
		String url = url_Address;
		Map params = new HashMap();// 请求参数
		params.put("id", id);//
		try {
			result = Utils.net(url, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			// System.err.println(object);
			if (object != null) {
				JSONObject item = object.optJSONObject("item");
				videoUrl = item.getString("downUrl");// 解析第二次json取出URL
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return videoUrl;
	}

}

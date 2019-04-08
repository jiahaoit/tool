package com.hao.video;

import java.util.Map;

import com.hao.util.FormatDate;
import com.hao.util.Utils;

public class TestQuery {
	public static void main(String[] args) {
//		for (int i = 0; i < QueryUrl.videoUrl().size(); i++) {
//		}
		Map urlMap=QueryUrl.SelectDownUrl(43627);
		QueryUrl.downVideo(urlMap.get("videoUrl").toString(), "/home/hao/Desktop/test/", urlMap.get("fileName").toString(), urlMap.get("suffix").toString());
	}
}

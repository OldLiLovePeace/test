package cn.limy.test;

import java.util.*;

public class Map2xmlTest {
	public static byte[] callMapToXML(Map map) {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><bizdata>");
		mapToXMLTest2(map, sb);
		sb.append("</bizdata>");
		try {
			return sb.toString().getBytes("UTF-8");
		} catch (Exception e) {
		}
		return null;
	}

	private static void mapToXMLTest2(Map map, StringBuffer sb) {
		Set set = map.keySet();
		for (Iterator it = set.iterator(); it.hasNext();) {
			String key = (String) it.next();
			Object value = map.get(key);
			if (null == value)
				value = "";
			if (value.getClass().getName().equals("java.util.ArrayList")) {
				ArrayList list = (ArrayList) map.get(key);
				sb.append("<" + key + ">");
				for (int i = 0; i < list.size(); i++) {
					HashMap hm = (HashMap) list.get(i);
					mapToXMLTest2(hm, sb);
				}
				sb.append("</" + key + ">");

			} else {
				if (value instanceof HashMap) {
					sb.append("<" + key + ">");
					mapToXMLTest2((HashMap) value, sb);
					sb.append("</" + key + ">");
				} else {
					sb.append("<" + key + ">" + value + "</" + key + ">");
				}

			}

		}
	}
	
	public static void main(String[] args) {
//	   	// 获取map转换为JSONObject
//        JSONObject json = new JSONObject();
//
//        Date d = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
//        String timesTamp = sdf.format( d );
//        SimpleDateFormat sdf1 = new SimpleDateFormat( "yyyyMMddHHmmssSSS" );
//        String transIdno = sdf1.format( d );
//
//        // 6位随机数
//        int radom = (int) ((Math.random() * 9 + 1) * 100000);
//        String transId = transIdno + radom;
//
//        /**
//         * body
//         */
//		JSONObject body = new JSONObject();
//		JSONObject submitMessageReq = new JSONObject();
//
//		body.put("SUBMIT_MESSAGE_REQ", submitMessageReq);
//		submitMessageReq.put("MESSAGE_SEQ", originDomin + random6);
//		submitMessageReq.put("ORIGIN_DOMAIN",originDomin);
//		submitMessageReq.put("PROCESS_TIME",timesTamp);
//
//		JSONObject messageInfo = new JSONObject();
//		submitMessageReq.put("MESSAGE_INFO",messageInfo);
//
//		messageInfo.put("MESSAGE_TYPE", "0000");
//		messageInfo.put("SEND_OBJECT", "");
//		messageInfo.put("RECV_OBJECT", phoneNumber);
//		messageInfo.put("SEND_TIME", "");
//		messageInfo.put("MESSAGE_CONTENT", "每70字拆分1条。");
//
//		body.put("UNI_BSS_PARAMS", "");
//
//        JSONObject headJson = new JSONObject();
//        headJson.put( "APP_KEY", appId );
//        headJson.put( "TIMESTAMP", timesTamp );
//        headJson.put( "TRANS_ID", transId );
//        headJson.put( "TOKEN", token );
//
//        json.put( "UNI_BSS_HEAD", headJson );
//        json.put( "UNI_BSS_BODY", body );
	}
}

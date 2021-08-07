package com.wnstjd4778.jpGG.ranker.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wnstjd4778.jpGG.ranker.vo.RankerVO;

@Service
public class RankerService {
	private static final String API_KEY = "RGAPI-842e3ef1-b8aa-4e78-ab79-5062bd356561";

	public List<RankerVO> searchSoloRanker() {
		List<RankerVO> list = new ArrayList<RankerVO>();
		RankerVO rankerVO;
		try {
			String urlstr = "https://kr.api.riotgames.com/lol/league/v4/challengerleagues/by-queue/RANKED_SOLO_5x5" + 
							"?api_key=" + API_KEY;

			JsonParser jsonParser = new JsonParser();
			URL url = new URL(urlstr);
			URLConnection urlConn = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			String inputLine;
			String result = "";
			while ((inputLine = in.readLine()) != null) {
				result = result + inputLine;
			}
			JsonObject jsonObject = (JsonObject) jsonParser.parse(result);
			JsonArray jsonArray = jsonObject.get("entries").getAsJsonArray();
			for(int i =0; i < jsonArray.size(); i++) {
				JsonObject json = jsonArray.get(i).getAsJsonObject();
				String summonerName = json.get("summonerName").getAsString();
				int leaguePoints = json.get("leaguePoints").getAsInt();
				String rank = json.get("rank").getAsString();
				int wins = json.get("wins").getAsInt();
				int losses = json.get("losses").getAsInt();
				rankerVO = new RankerVO(summonerName, leaguePoints, rank, wins, losses);
				list.add(rankerVO);
			}
			Collections.sort(list);
			
			System.out.println(list);
			in.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}

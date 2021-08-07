package com.wnstjd4778.jpGG.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wnstjd4778.jpGG.vo.LeagueEntryDTO;
import com.wnstjd4778.jpGG.vo.SummonerVO;

@Service
public class HomeService {
	private static final String API_KEY = "RGAPI-842e3ef1-b8aa-4e78-ab79-5062bd356561";

	public SummonerVO searchSummonerId(String SummonerName) {
		SummonerVO temp = null;
		try {
			String urlstr = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"
					+ SummonerName.replace(" ", "") + "?api_key=" + API_KEY;

			JsonParser jsonParser = new JsonParser();
			URL url = new URL(urlstr);
			URLConnection urlConn = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			String inputLine;
			String result = "";
			while ((inputLine = in.readLine()) != null) {
				result = result + inputLine;
			}
			JsonObject json = (JsonObject) jsonParser.parse(result);
			String id = json.get("id").getAsString();
			String accountId = json.get("accountId").getAsString();
			String puuid = json.get("puuid").getAsString();
			String name = json.get("name").getAsString();
			int profileIconId = json.get("profileIconId").getAsInt();
			int revisionDate = json.get("revisionDate").getAsInt();
			int summonerLevel = json.get("summonerLevel").getAsInt();
			temp = new SummonerVO(id, accountId, puuid, name, profileIconId, revisionDate, summonerLevel);
			in.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return temp;
	}
	
	public List<LeagueEntryDTO> searchSummonerTier(String id) {
		List<LeagueEntryDTO> list = new ArrayList<LeagueEntryDTO>();
		LeagueEntryDTO leagueEntryDTO;
		try {
			String urlstr = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + 
							id + "?api_key=" + API_KEY;
			JsonParser jsonParser = new JsonParser();
			URL url = new URL(urlstr);
			URLConnection urlConn = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			String inputLine;
			String result = "";
			while ((inputLine = in.readLine()) != null) {
				result = result + inputLine;
			}
			JsonArray arr = (JsonArray) jsonParser.parse(result);
			for(int i = 0; i < arr.size(); i++) {
			JsonObject json = arr.get(i).getAsJsonObject();
			String leagueId = json.get("leagueId").getAsString();
			String queueType = json.get("queueType").getAsString();
			String tier = json.get("tier").getAsString();
			String rank = json.get("rank").getAsString();
			int leaguePoints = json.get("leaguePoints").getAsInt();
			int wins = json.get("wins").getAsInt();
			int losses = json.get("losses").getAsInt();
			leagueEntryDTO = new LeagueEntryDTO(leagueId, queueType, tier, rank, leaguePoints, wins, losses);
			list.add(leagueEntryDTO);
			}
			Collections.sort(list);
			in.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
}

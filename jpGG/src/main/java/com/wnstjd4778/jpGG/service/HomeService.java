package com.wnstjd4778.jpGG.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wnstjd4778.jpGG.vo.LeagueEntryDTO;
import com.wnstjd4778.jpGG.vo.SummonerVO;

@Service
public class HomeService {
	private static final String API_KEY = "RGAPI-047c99de-4536-4719-81fa-154a6de459a5";

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
				System.out.println(inputLine);
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
	
	public LeagueEntryDTO searchSummonerTier(String id) {
		LeagueEntryDTO leagueEntryDTO = null;
		try {
			String url2 = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + 
							id + "?api_key=" + API_KEY;
			JsonParser jsonParser = new JsonParser();
			URL url = new URL(url2);
			URLConnection urlConn = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			String inputLine;
			String result = "";
			while ((inputLine = in.readLine()) != null) {
				result = result + inputLine;
			}
			JsonArray ar = (JsonArray) jsonParser.parse(result);
			JsonObject json = ar.get(0).getAsJsonObject();
			String leagueId = json.get("leagueId").getAsString();
			String queueType = json.get("queueType").getAsString();
			String tier = json.get("tier").getAsString();
			String rank = json.get("rank").getAsString();
			int leaguePoints = json.get("leaguePoints").getAsInt();
			int wins = json.get("wins").getAsInt();
			int losses = json.get("losses").getAsInt();
			leagueEntryDTO = new LeagueEntryDTO(leagueId, queueType, tier, rank, leaguePoints, wins, losses);
			in.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return leagueEntryDTO;
	}
}

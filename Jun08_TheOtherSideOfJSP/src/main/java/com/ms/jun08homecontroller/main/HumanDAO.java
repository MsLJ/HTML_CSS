package com.ms.jun08homecontroller.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import ms.ljh.db.manager.MsDBManager;

public class HumanDAO {

	public HumanDAO() {
		// TODO Auto-generated constructor stub
	}

	public static final HumanDAO HUMANDAO = new HumanDAO();

	public static HumanDAO getHumandao() {
		return HUMANDAO;
	}

	

	
	
	
	
	
	public String getHuman(HttpServletRequest request) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	        con = MsDBManager.connect("msPool");
	        String sql = "SELECT * FROM jun08_human";
	        pstmt = con.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        
	        JSONArray jsonArray = new JSONArray();
	        
	        while (rs.next()) {
	        	JSONObject jsonObject = new JSONObject();
	            jsonObject.put("h_name", rs.getString("h_name"));
	            jsonObject.put("h_age", rs.getInt("h_age"));
	            jsonArray.add(jsonObject);
	        }
	        
	        JSONObject result = new JSONObject();
	        result.put("jun08_human", jsonArray);
	        
	        return result.toString();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        MsDBManager.close(con, pstmt, rs);
	    }
	}

	
	
	
	
	
	
	
	}



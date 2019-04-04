package com.mozeeb.crudmvp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseSiswa{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("status")
	private boolean status;

	public String getPesan(){
		return pesan;
	}

	public List<DataItem> getData(){
		return data;
	}

	public boolean isStatus(){
		return status;
	}
}
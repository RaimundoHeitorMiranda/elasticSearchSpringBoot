package com.rhm.estagio.models;

import java.util.ArrayList;
import java.util.List;

public class SetUploadModel {

	private List<PostModel> data = new ArrayList<PostModel>();

	public SetUploadModel() {
		
	}

	public List<PostModel> getData() {
		return data;
	}

	public void setData(List<PostModel> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "SetUploadModel [data=" + data + "]";
	}
	
}

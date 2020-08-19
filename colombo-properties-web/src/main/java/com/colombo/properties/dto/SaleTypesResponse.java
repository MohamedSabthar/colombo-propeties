package com.colombo.properties.dto;

import java.util.List;

import com.colombo.properties.model.SaleType;

public class SaleTypesResponse extends Response {
	private List<SaleType> result;

	public List<SaleType> getResult() {
		return result;
	}

	public void setResult(List<SaleType> saleType) {
		this.result = saleType;
	}

	@Override
	public String toString() {
		return "SaleTypesResponse [result=" + result + ", message=" + message + ", status=" + status + "]";
	}

}

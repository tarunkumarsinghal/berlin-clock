package com.ubs.opsit.interviews.constants;

public enum Lamp {
	Yellow("Y"), Red("R"), Off("O");
	private String LampSymbol;
	Lamp(String LampSymbol){
		this.LampSymbol = LampSymbol;
	}
	
	@Override
	public String toString() {
		return LampSymbol;
	}	
}

package edu.neumont.light.javarpg.controller;

import edu.neumont.light.javarpg.view.RpgView;

public class RpgController {

	private RpgView view;
	
	public RpgController(RpgView view) {
		this.view = view;
		this.view.registerController(this);
	}

	public void run() {
		view.init();
		
		
	}
	
}

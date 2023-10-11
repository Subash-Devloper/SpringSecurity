package com.OneSoft.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class OneSoftController {
		@GetMapping(value="/student")
	public String getAll() {
		return "This is Student";
	}
		@GetMapping(value="/trainer")
		public String get() {
			return "This is Trainer";
		}
		@GetMapping(value="/manager")
		public String getvalue() {
			return "This is Manager";
		}

}

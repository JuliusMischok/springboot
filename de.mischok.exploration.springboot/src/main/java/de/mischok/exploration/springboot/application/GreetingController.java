package de.mischok.exploration.springboot.application;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value="pname", required=false, defaultValue="World") String pname, Model model) {
		model.addAttribute("name", new NameWrapper(pname, "Mischok"));
		
		return "greeting";
	}
	
	public class NameWrapper {
		private final String prename;
		private final String lastname;
		
		public NameWrapper(final String prename, final String lastname) {
			this.prename = prename;
			this.lastname = lastname;
		}

		/**
		 * @return the prename
		 */
		public String getPrename() {
			return prename;
		}

		/**
		 * @return the lastname
		 */
		public String getLastname() {
			return lastname;
		}
		
		@Override
		public String toString() {
			return this.getPrename() + " " + this.getLastname();
		}
	}
}

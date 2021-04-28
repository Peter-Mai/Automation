package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BlueBackground {


	@Given("Set skyblue background button exist")
	public void set_skyblue_background_button_exist() {
		System.out.println("Button Exist");
	}
	@When("user clicks on button")
	public void user_clicks_on_button() {
		System.out.println("Click Button");
	}
	@Then("background color will change to sky blue")
	public void background_color_will_change_to_sky_blue() {
		System.out.println("Background will be blue");
	}

}

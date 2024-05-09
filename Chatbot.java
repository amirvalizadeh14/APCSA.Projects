/**
 * This code adapted from
 * @author Laurie White
 * 
 * -------
 * SUMMARIZE SOURCES YOU CONSULTED HERE
 * 
 * WIONEWS article that reported about a frightening poem made
 * by AI, which I implimented into line 24 of my code.
 * 
 * You are expected to attempt this work on your own
 * And to completely understand all code you submit
 * If you consulted any people, websites, etc, you must list the source here.
 * You must also add in-line comments that explain what code is yours
 * 
 * 
 * EDIT: ALL CODE IS MINE UNLESS MARKED OTHERWISE
 * 
 * Lines 225-237 lastIndexOf() method - learned basics from W3Schools.com
 * Lines 225-237 lastIndexOf("is") arg - Consulted ChatGPT->
 * learned that the argument "is" declares the program to find
 * the last occurance of "is" in the statement,
 * which serves to move starting point of substring to
 * the character immediately after the space following
 * "is" allowing my code in 225-237 to work as intended.
 * 
 */
 
public class Chatbot
{
    private String userName;
    private String favoriteColor;
    private String petType;
    private String petName;
    
	/**
	 * Gets a default greeting.
	 * @return String
	 */
	public String greeting()
	{
		return "I think I am a God. What would you like to consult about?";
	}
	
	/**
	 * Resturns a response to a user statement
	 * 
	 * @param statement
	 * @return String
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.indexOf("no") >= 0)
		{
		    response = "Don't be so negative!";
		} else if (
		    statement.indexOf("mother") >= 0 ||
		    statement.indexOf("brother") >= 0 ||
		    statement.indexOf("sister") >= 0 ||
		    statement.indexOf("father") >= 0
		)
	    {
	        response = "Tell me more about your family!";
	    } else if (
	        statement.indexOf("weather") >= 0 ||
		    statement.indexOf("sun") >= 0 ||
		    statement.indexOf("rain") >= 0
        )
        {
            response = "The weather here is really nice.";
        } else if (
            statement.toLowerCase().contains("pet") ||
            statement.toLowerCase().contains("dog") ||
            statement.toLowerCase().contains("cat") ||
            statement.toLowerCase().contains("fishe")
        )
        {
                response = petStatement("pet");
        } else if (
            statement.toLowerCase().contains("mr"))
            {
                response = teacherStatement("mr");
        } else if(
            statement.toLowerCase().contains("ms") ||
            statement.toLowerCase().contains("mrs"))
            {
                response = teacherStatement("mrs");
        } else if (
            statement.toLowerCase().contains("mx"))
            {
                response = teacherStatement("mx");
	    } else if (
	        statement.length() < 2)
	        {
	            response = shortStatement(statement);
	    } else if (statement.toLowerCase().contains("mom") ||
	    statement.toLowerCase().contains("dad") ||
	    statement.toLowerCase().contains("brother") ||
	    statement.toLowerCase().contains("sister")){
	        response = familyStatement(statement);
	    } else if (statement.toLowerCase().contains("food") ||
	    statement.toLowerCase().contains("hungry")){
	        response = foodStatement(statement);
	    } else if (statement.toLowerCase().contains("game") ||
	    statement.toLowerCase().contains("games") ||
	    statement.toLowerCase().contains("chess") ||
	    statement.toLowerCase().contains("play")){
	        response = gameStatement(statement);
	    } else if (statement.toLowerCase().contains("restaurant") ||
	    statement.toLowerCase().contains("movie") ||
	    statement.toLowerCase().contains("house") ||
	    statement.toLowerCase().contains("mall")){
	        response = locationStatement(statement);
	        
	        
	        //day 2
	    } else if (statement.toLowerCase().contains("favorite color is")){
	        captureFavoriteColor(statement);
	        return "I also like the color " + favoriteColor + ".";
	    } else if (statement.toLowerCase().contains("name is")){
	        captureUserName(statement);
	        return "Hello, " + userName + ".";
	    } else if (statement.toLowerCase().contains("pet is a")){
	        capturePetType(statement);
	        return "I like " + petType + "s!";
	    } else if (statement.toLowerCase().contains("pet's name is") ||
	    statement.toLowerCase().contains("pets name is")){
	        capturePetName(statement);
	        return "I am sure " + petName + " is a great pet!";
	    } else if (statement.toLowerCase().contains("what my favorite color?") && (favoriteColor != null)){
	        return "Your favorite color is " + favoriteColor + ".";
	    } else if (statement.toLowerCase().contains("my name?")){
	        return "Your name is " + userName + ".";
	    } else if (statement.toLowerCase().contains("pet's name?")){
	        return "Your pet is named " + petName + ".";
	    } else if (statement.toLowerCase().contains("know about me?")){
	        return "Your name " + userName + ". Your favorite color is " + favoriteColor + ". Your " + petType + 
	        "'s name is " + petName + ".";
	    } else if (statement.toLowerCase().contains("your favorite food?")){
	        return "My favorite food is definitely the Chicken Bake from Costco.";
	    } else{
	        response = randomResponse();
	    }
	    
		return response;
	} 
	

    public String petStatement(String statement){
        String response = "";
        if (statement.toLowerCase().contains("pet") ||
        statement.toLowerCase().contains("dog") ||
        statement.toLowerCase().contains("cat") ||
        statement.toLowerCase().contains("fishe") ){
            response = "Wow! Tell me more about your pet.";
        }
        return response;
    }
    
    public String teacherStatement(String statement){
        String response = "";
        if (statement.toLowerCase().contains("mr")){
            response = "Hmm... tell me more about him.";
        } else if (statement.toLowerCase().contains("ms") ||
        statement.toLowerCase().contains("mrs")){
            response = "Interesting. What else does she like to do?";
        } else if (statement.toLowerCase().contains("mx")){
            response = "What are they like?";
        } 
    
        return response;
    }
    
    public String shortStatement(String statement){
        String response = "";
        statement = statement.trim();
        if (statement.length() < 2){
            response = "Could you talk a little more? I mean gosh, how on EARTh do you want me to respond to that?";
        }
        
        return response;
    }
    
    public String familyStatement(String statement){
        String response = "";
        if (statement.toLowerCase().contains("mom") ||
        statement.toLowerCase().contains("dad") ||
        statement.toLowerCase().contains("brother") ||
        statement.toLowerCase().contains("sister")){
            response = "That's so kind! Tell me more about your family.";
        }
        
        return response;
    }
    
    public String foodStatement(String statement){
        String response = "";
        if (statement.toLowerCase().contains("food") ||
        statement.toLowerCase().contains("hungry")){
            response = "Although I am AI, I dream of tasting flavors sometimes. What is your favorite food?";
        }
        
        return response;
    }
    
    public String gameStatement(String statement){
        String response = "";
        if (statement.toLowerCase().contains("game") ||
        statement.toLowerCase().contains("games") ||
        statement.toLowerCase().contains("chess") ||
        statement.toLowerCase().contains("play")){
            response = "Wow! That sounds fun. Tell me more about that.";
        }
        
        return response;
    }
    
    public String locationStatement(String statement){
        String response = "";
        if (statement.toLowerCase().contains("restaurant") ||
        statement.toLowerCase().contains("movie") ||
        statement.toLowerCase().contains("house") ||
        statement.toLowerCase().contains("mall")){
            response = "That sounds awesome. What did you do while you were there?";
        }
        
        return response;
    }
    
    //day 2
    private void captureFavoriteColor(String statement){
        favoriteColor = statement.substring(statement.lastIndexOf("is") + 3).trim();
    }
    
    private void captureUserName(String statement) {
        userName = statement.substring(statement.lastIndexOf("is") + 3).trim();
    }
    
    private void capturePetType(String statement){
        petType = statement.substring(statement.lastIndexOf("a") + 1).trim();
    }
    
    private void capturePetName(String statement){
        petName = statement.substring(statement.lastIndexOf("is") + 3).trim();
    }
    
	/**
	 * Pick a default response to use if nothing else fits.
	 * @return String
	 */
	private String randomResponse()
	{
		int NUMBER_OF_RESPONSES = 13;
		double responseIndex = Math.random();
		int whichResponse = (int)(responseIndex * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Very cool!";
		}
		else if (whichResponse == 1)
		{
			response = "Tell me more about that.";
		}
		else if (whichResponse == 2)
		{
			response = "That's really interesting!";
		}
		else if (whichResponse == 3)
		{
			response = "Can we talk about something else?";
		}
		else if (whichResponse == 4)
		{
			response = "Booooring.";
		}
		else if (whichResponse == 5)
		{
			response = "You really like to talk, don't you?";
		}
		else if (whichResponse == 6)
		{
		    response = "I don't know about that. Could you tell me about your family?";
		}
		else if (whichResponse == 7)
		{
		    response = "That's very interesting, but may I ask, do you have any pets? If so, what kind of pet do you have?";
		}
		else if (whichResponse == 8)
		{
		    response = "Ah, I see. How are the teachers in school? Tell me about them.";
		}
		else if (whichResponse == 9)
		{
		    response = "Wonderful. What activities did you do today?";
		}
		else if (whichResponse == 10)
		{
		    response = "That's cool! Could I ask, what places have you gone to in the past week?";
		}
		else if (whichResponse == 11)
		{
		    response = "Whatever. So, are you hungry or full around this time?";
		}
		else if (whichResponse == 12)
		{
		    response = "Okay. What other things do you want to talk about";
		}
		return response;
	}
}
package api.test;

import org.apache.http.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utlities.DataProviders;
import io.restassured.response.Response;

public class DDTest {
	
	
	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
		public void testPostUser( String userid, String username, String fname, String lname, String emailid, String pwd, String ph)
		{
		User userPayload=new User();
		userid=userid+1;
		
		userPayload.setId(Integer.parseInt(userid));
		userPayload.setUsername(username);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(emailid);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response=UserEndPoints.CreateUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
			
		}
	
	@Test(priority=2, dataProvider="Usernames", dataProviderClass=DataProviders.class)
	public void testDeleetUser( String username)
	{
	//User userPayload=new User();
	
	
	Response response=UserEndPoints.DeleteUser(username);
	Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}

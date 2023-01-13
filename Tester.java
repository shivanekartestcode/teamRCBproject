import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * this class offers test coverage to checks around team composition for RCB team
 * author-Shiv Anekar
 */
public class Tester {

    private JsonPath jsonPath;

    @BeforeClass
    public void getTeamDetails() throws IOException {
        String rcbTeamDetails=new String(Files.readAllBytes(Paths.get("rcbTeamDetails.json")));
        jsonPath=new JsonPath(rcbTeamDetails);
    }

    @Test(testName ="validateCountOfForeignPlayers",description = "this test validates that there are exactly four foreign players in team")
    public void validateCountOfForeignPlayers()
    {
        int numberOfPlayers=jsonPath.getInt("player.size()");
        int foreignPlayerCount=0;
        for(int i=0;i<=numberOfPlayers-1;i++)
        {
            if(!(jsonPath.getString("player["+i+"].country").equalsIgnoreCase("India")))
            {
                foreignPlayerCount++;
            }
        }
        Assert.assertEquals(foreignPlayerCount,4,"validation for count of foreign players");
    }

    @Test(testName = "validateCountOfWicketKeeper" ,description = "this test checks that there is at least one wicket keeper in team")
    public void validateCountOfWicketKeeper()
    {
        int numberOfPlayers=jsonPath.getInt("player.size()");
        int wicketKeeperCount=0;
        for(int i=0;i<=numberOfPlayers-1;i++)
        {
            if(jsonPath.getString("player["+i+"].role").equalsIgnoreCase("Wicket-keeper"))
            {
                wicketKeeperCount++;
            }
        }
        Assert.assertTrue(wicketKeeperCount>=1,"validation for count of wicket keepers");
    }

}
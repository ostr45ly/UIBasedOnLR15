import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;

public class SimpleTest {

    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
    }


   @Test //(groups = {"functional"})
   public void subTaskCRUD() throws InterruptedException {

       String parentIssueId = "QAAUT-309";
       String subTaskSummary = "test ostrovska";
       String subTaskNumber = "7";
       String subTaskAssignee = "Unassigned";

       LoginPage loginPage = new LoginPage();
       NewIssuePage newIssuePage = new NewIssuePage();
       HeaderPage headerPage = new HeaderPage();
       DashBoardPage dashBoardPage = new DashBoardPage();
       IssuePage issuePage = new IssuePage();

        loginPage.open();
        assertEquals(loginPage.isOnThePage(), true);

       loginPage.enterUsername();
       loginPage.enterPassword();
       loginPage.clickLogin();

       assertEquals(dashBoardPage.isOnThePage(), true);

       //Create new sub-task

       headerPage.search(parentIssueId);
       issuePage.clickMoreButton();
       issuePage.openNewSubTask();
       newIssuePage.fillSummary("test ostrovska");
       newIssuePage.clickSubmitButton();

     //  assertEquals(issuePage.isSubTaskSummaryPresent(subTaskSummary), true);
    //    assertEquals(issuePage.isSubTaskNumberPresent(subTaskNumber), true);
   //  assertEquals(issuePage.isSubTaskAssigneePresent(subTaskAssignee), true);

//        // TODO check success popup appeared//
//
//        issuePage.openExistingIssue(parentIssueId);
//        assertEquals(issuePage.isSubTaskSummaryMissing(subTaskSummary), true);
//

}

    @Test(groups = {"functional"})

        public void subTaskCommentCRUD() throws InterruptedException {

            String subTaskId = "QAAUT-309";

            String commentText = "write comment";

            LoginPage loginPage = new LoginPage();

            DashBoardPage dashBoardPage = new DashBoardPage();

            IssuePage issuePage = new IssuePage();

            loginPage.open();
            assertEquals(loginPage.isOnThePage(), true);

            loginPage.enterUsername();

            loginPage.enterPassword();

            loginPage.clickLogin();

           assertEquals(dashBoardPage.isOnThePage(), true);

           issuePage.openExistingIssue(subTaskId);

           assertEquals(issuePage.isOnThePage(subTaskId), true);

           issuePage.openSubtask();
          //  issuePage.openSubtaskComment(commentText);
          // issuePage.deleteSubtaskComment();


            // TODO assert that comment is present
    //    assertEquals(issuePage.isCommentTextPresent(commentText), true);

    //       assertEquals(issuePage.isCommentTextMissing(commentText), true);

              issuePage.editSubtask();

        }
    }

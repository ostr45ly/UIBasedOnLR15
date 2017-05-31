package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.RemoteDriverManager;

public class IssuePage extends BasePage {

    private String pageURL = baseURL + "/browse/%s";

    private HeaderPage headerPage;

    private By newSubtaskButtonLocator = By.id("stqc_show");
    private By summaryLocator = By.id("summary");
    private By submitButtonLocator = By.id("create-issue-submit");
    private By subtaskLocator = By.linkText("test ostrovska");
    private By moreButtonLocator = By.id("opsbar-operations_more");
    private By deleteListItemLocator = By.id("delete-issue");
    private By deleteButtonLocator = By.id("delete-issue-submit");
    private By successPopUp = By.xpath("//*[contains(@class,'aui-message-success')]");

    private By createButtonMore = By.id("create-subtask");
    private String subTaskSummary = "//*[@class='stsummary']//*[contains(text(),'%s')]";
    private String subTaskNumber = "//*[@class='stsequence']//*[contains(text(),'%s')]";
    private String subTaskAssignee = "//*[@class='assignee']//*[contains(text(),'%s')]";
//    private By subTaskText = By.xpath("//*[contains(text(),'%s')]");

    private By createComment = By.id("footer-comment-button");
    private By saveComment = By.id("issue-comment-add-submit");
    private By textComment = By.id("comment");
    private By commentTextType = By.id("aui-uid-2");
    private String commentText = "//*[@id='issue_actions_container']//child::*[contains(text(),'%s')]";

    private By deleteComment=By.cssSelector(".aui-iconfont-delete");
    private By deleteCommentp = By.xpath("//*[contains(@class,'delete-comment issue-comment-action')]");
    private By deleteSaveComment = By.id("comment-delete-submit");

    private By iconSubTask = By.xpath("//*[contains(@class,'aui-icon aui-icon-small aui-iconfont-more')]");

    private By editSubtask = By.id("edit-issue");
    private By editAssignee = By.id("assignee-single-select");
    private By editSubmit = By.id("edit-issue-submit");
    private By editreporter = By.id("reporter-single-select");
    private By editClickAssignee = By.id("assign-to-me-trigger");
  //  private By editSubtaskp = By.xpath("//*[contains(@class,'toolbar-trigger issueaction-edit-issue')]");
    private By editSubtaskp = By.xpath("//*[contains(@class,'icon aui-icon aui-icon-small aui-iconfont-edite')]");

    public IssuePage() {

        this.driver = RemoteDriverManager.getDriver();
        headerPage = new HeaderPage();

    }

    public void openExistingIssue(String issueId) {

        String url = String.format(pageURL, issueId);
        super.openExistingIssue(url);

    }

    public IssuePage openNewSubTask() throws InterruptedException {

       // waitToBePresentAndClick(newSubtaskButtonLocator);
         waitToBePresentAndClick(createButtonMore);

        return this;
    }

    public IssuePage shouldSeeSuccessPopUp() {

        waitToBePresent(successPopUp);

        return this;
    }

    public IssuePage openSubtask() throws InterruptedException {

        waitToBePresentAndClick(subtaskLocator);

        return this;
    }

    public IssuePage openSubtaskComment(String text) throws InterruptedException {
        //  waitToBePresent(iconSubTask);
        //  waitToBePresentAndClick(iconSubTask);
         waitToBePresentAndClick(createComment);

         waitToBePresentAndClick(commentTextType);
         waitToBePresentAndSendKeys(textComment,text);
        Thread.sleep(15000);
         waitToBePresentAndClick(saveComment);
        return this;
    }

    public IssuePage deleteSubtaskComment() throws InterruptedException {

        waitToBePresentAndClick(deleteCommentp);
        waitToBePresentAndClick(deleteSaveComment);

        return this;
    }

    public IssuePage editSubtask() throws InterruptedException {
               waitToBePresentAndClick(editSubtask);

      //        scrollDownOn(-250);
      //  Thread.sleep(15000);
       ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-450)", "");
        WebElement element= driver.findElement(editClickAssignee);
       element.click();
       // waitToBePresentAndClick(editSubmit);
       ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-250)", "");
        WebElement element1= driver.findElement(editSubmit);
        element1.click();

        return this;
    }

    public IssuePage clickMoreButton() {

        waitToBePresentAndClick(moreButtonLocator);

        return this;
    }

    public IssuePage clickDeleteListItem() {

        waitToBePresentAndClick(deleteListItemLocator);

        return this;
    }

    public IssuePage deleteSubTask() {

        waitToBePresentAndClick(deleteButtonLocator);

        return this;
    }

    public boolean isOnThePage(String issueId) {

        String url = String.format(pageURL, issueId);
        return super.isOnThePage(url);

    }

    public boolean isSubTaskSummaryPresent(String title) {

        String selector = String.format(subTaskSummary, title);
        return waitToBePresentAndContainsText(By.xpath(selector), title);

    }

    public boolean isSubTaskSummaryMissing(String title) {

        String selector = String.format(subTaskSummary, title);
        return waitToBeMissing(By.xpath(selector));

    }


    public boolean isSubTaskNumberPresent(String name) {

        String selector = String.format(subTaskNumber, name);
        return waitToBePresentAndContainsText(By.xpath(selector), name);

    }

    public boolean isSubTaskAssigneePresent(String name) {

        String selector = String.format(subTaskAssignee, name);
        return waitToBePresentAndContainsText(By.xpath(selector), name);

    }

    public boolean isCommentTextPresent(String text) {
             String selector = String.format(commentText, text);
          return waitToBePresentAndContainsText(By.xpath(selector), text);
  }

   public boolean isCommentTextMissing(String text) {
         String selector = String.format(commentText, text);
          return waitToBeMissing(By.xpath(selector));

  }


}


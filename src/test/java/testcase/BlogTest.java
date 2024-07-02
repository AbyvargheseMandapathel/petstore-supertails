package testcase;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.BlogPage;
import pages.HomePage;
import pages.Posts;
import testcasebase.SetUp;
import utilities.ExtentReportListener;


@Listeners(ExtentReportListener.class)
public class BlogTest extends SetUp{
	HomePage hp;
	BlogPage bp;
	Posts post;
	
  @Test
  public void viewBlogs() {
	  hp = new HomePage(driver);
	  hp.clickBlog();
	  bp= new BlogPage(driver);
	  bp.openPost();
	  post= new Posts(driver);
	 
	  String head=bp.postTitle();
	  String title=post.blogTitle();
	  assertEquals(head,title);
	 
  }
}

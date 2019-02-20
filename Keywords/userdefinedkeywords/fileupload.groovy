package userdefinedkeywords
import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.thoughtworks.selenium.webdriven.commands.KeyEvent


class fileupload {
	
	@Keyword
	def dd(){

		Runtime rt=Runtime.getRuntime()

		Process p=rt.exec('C:\\Users\\TECHOLUTION\\Desktop\\Autoit\\FileUpload1.exe')
	}
	
	@Keyword
	def uploadFile(TestObject to, String filePath)
	{
	//WebUI.click(to)
	StringSelection ab = new StringSelection(filePath);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ab, null);
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.delay(3000);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
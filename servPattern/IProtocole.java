package servPattern;
import java.awt.AWTException;
import java.io.InputStream;
import java.io.OutputStream;

public interface IProtocole {

	public void execute( IContext aContext , InputStream anInputStream , OutputStream anOutputStream ) throws AWTException;
	
}

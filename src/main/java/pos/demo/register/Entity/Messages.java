package pos.demo.register.Entity;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public interface Messages {

    static Map<HttpSession,String> messages = new HashMap<HttpSession, String>();
}

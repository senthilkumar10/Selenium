package ChromeDriverProtocol;

import com.github.kklisura.cdt.launch.ChromeLauncher;
import com.github.kklisura.cdt.protocol.commands.Network;
import com.github.kklisura.cdt.protocol.commands.Page;
import com.github.kklisura.cdt.protocol.types.network.RequestPattern;
import com.github.kklisura.cdt.services.ChromeDevToolsService;
import com.github.kklisura.cdt.services.ChromeService;
import com.github.kklisura.cdt.services.types.ChromeTab;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import java.io.IOException;

public class HTTPBasicAuthCDP {

    public static void main(String[] args) throws InterruptedException, IOException {
        // Create chrome launcher.
        final ChromeLauncher launcher = new ChromeLauncher();

        // Launch chrome either as headless (true) or regular (false).
        final ChromeService chromeService = launcher.launch(false);

        // Create empty tab ie about:blank.
        final ChromeTab tab = chromeService.createTab();

        // Get DevTools service to this tab
        final ChromeDevToolsService devToolsService = chromeService.createDevToolsService(tab);

        // Get individual commands
        final Page page = devToolsService.getPage();
        final Network network = devToolsService.getNetwork();

        network.onRequestIntercepted(
                event -> {
                    String interceptionId = event.getInterceptionId();

                    System.out.printf(
                            "Adding header to %s request%s", event.getRequest().getUrl(), System.lineSeparator());

                    Map<String, Object> headers = new HashMap<>();

                    headers.put("Authorization", "Basic YWRtaW46YWRtaW4=");

                    network.continueInterceptedRequest(
                            interceptionId, null, null, null, null, null, headers, null);
                });

        RequestPattern interceptionRequestPattern = new RequestPattern();
        network.setRequestInterception(Collections.singletonList(interceptionRequestPattern));
        network.enable();

        // Enable page events.
        page.enable();

        // Navigate to github.com.
        page.navigate("http://the-internet.herokuapp.com/basic_auth");

        devToolsService.waitUntilClosed();
    }

}

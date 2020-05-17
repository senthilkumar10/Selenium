package ChromeDriverProtocol;

import com.github.kklisura.cdt.launch.ChromeLauncher;
import com.github.kklisura.cdt.protocol.commands.Emulation;
import com.github.kklisura.cdt.protocol.commands.Page;
import com.github.kklisura.cdt.protocol.types.page.CaptureScreenshotFormat;
import com.github.kklisura.cdt.protocol.types.page.LayoutMetrics;
import com.github.kklisura.cdt.protocol.types.page.Viewport;
import com.github.kklisura.cdt.services.ChromeDevToolsService;
import com.github.kklisura.cdt.services.ChromeService;
import com.github.kklisura.cdt.services.types.ChromeTab;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class FullPageScreenShot {


    private static void captureFullPageScreenshot(ChromeDevToolsService devToolsService, Page page, String outputFilename) {
        final LayoutMetrics layoutMetrics = page.getLayoutMetrics();

        final double width = layoutMetrics.getContentSize().getWidth();
        final double height = layoutMetrics.getContentSize().getHeight();

        final Emulation emulation = devToolsService.getEmulation();
        emulation.setDeviceMetricsOverride(
                Double.valueOf(width).intValue(), Double.valueOf(height).intValue(), 1.0d, Boolean.FALSE);

        Viewport viewport = new Viewport();
        viewport.setScale(1d);

        // You can set offset with X, Y
        viewport.setX(0d);
        viewport.setY(0d);

        // Set a width, height of a page to take screenshot at
        viewport.setWidth(width);
        viewport.setHeight(height);

        dump(
                outputFilename,
                page.captureScreenshot(CaptureScreenshotFormat.PNG, 100, viewport, Boolean.TRUE));
    }


    private static void dump(String fileName, String data) {
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(fileName);
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(Base64.getDecoder().decode(data));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void fullPageScreenShot(){
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

        page.onLoadEventFired(
                event -> {
                    System.out.println("Taking screenshot...");

                    captureFullPageScreenshot(devToolsService, page, "screenshot.png");

                    System.out.println("Done!");

                    devToolsService.close();
                });

        // Enable page events.
        page.enable();

        // Navigate to github.com.
        page.navigate("https://www.amazon.com/");

        devToolsService.waitUntilClosed();

    }


}

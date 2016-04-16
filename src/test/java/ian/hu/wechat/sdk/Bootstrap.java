package ian.hu.wechat.sdk;


import ian.hu.wechat.sdk.service.ServiceHelper;
import ian.hu.wechat.sdk.service.core.AccessTokenService;
import ian.hu.wechat.sdk.service.core.result.AccessTokenResult;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class Bootstrap {
    public static void beforeStart() {
        try {
            //Class.forName("org.jboss.resteasy.plugins.providers.multipart.AbstractMultipartWriter");
            Properties properties = new Properties(System.getProperties());
            properties.load(Bootstrap.class.getResourceAsStream("/test.properties"));
            System.setProperties(properties);
            // 检查accessToken
            String appId = System.getProperty("appId");
            String appSecret = System.getProperty("appSecret");
            String accessTokenFilePath = System.getProperty("accessTokenFile") + "_" + appId;
            String accessToken;
            File file = new File(accessTokenFilePath);
            if (!file.exists() || file.lastModified() < new Date().getTime() - 7200000) {
                AccessTokenService service = ServiceHelper.getService(AccessTokenService.class);
                AccessTokenResult result = service.get(appId, appSecret, AccessTokenService.GRANT_TYPE_CLIENT_CREDENTIAL);
                if (!Integer.valueOf(0).equals(result.getErrorCode())) {
                    throw new RuntimeException("appId or appSecret is not valid");
                }
                FileWriter fw = new FileWriter(file, false);
                fw.write(accessToken = result.getAccessToken().getAccessToken());
                fw.flush();
                fw.close();
            } else {
                Scanner scanner = new Scanner(file);
                accessToken = scanner.nextLine();
                scanner.close();
            }
            System.setProperty("accessToken", accessToken);
            Class.forName("ian.hu.wechat.sdk.TestConstants");
            System.out.println("Bootstrap finished");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

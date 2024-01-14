package com.ga.bot.test;

import io.github.wechaty.Wechaty;
import io.github.wechaty.plugins.WechatyPlugins;
import io.github.wechaty.utils.QrcodeUtils;

public class HelloWrold {

    public static void main(String args[]) {
//        Wechaty bot = Wechaty.instance()
//                .onScan((qrcode, statusScanStatus, data) -> System.out.println(QrcodeUtils.getQr(qrcode)))
//                .onLogin(user -> System.out.println("User logined :" + user))
//                .onMessage(message -> System.out.println("Message:" + message))
//                .start(true);

            Wechaty bot = Wechaty.instance("")
                    .use(
                            WechatyPlugins.ScanPlugin(),
                            WechatyPlugins.DingDongPlugin(null))
                    .start(true);

    }

}

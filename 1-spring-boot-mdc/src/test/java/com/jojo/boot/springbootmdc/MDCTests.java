package com.jojo.boot.springbootmdc;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MDCTests {

    @Test
    void testMDC() {
        // ロガーの作成
        var logger = LoggerFactory.getLogger(MDCTests.class);

        // 現在のスレッドコンテキストにtraceXIdを格納
        MDC.put("traceXId", "xxxooo");

        // ログ出力（MDCのtraceXIdが含まれる）
        logger.info("ビジネス処理を実行中...");
        logger.info("ビジネス処理が完了しました");

        // 使用後、MDCのtraceXIdを削除
        MDC.remove("traceXId");
    }

}

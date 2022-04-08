package cn.zjwc.structlog4j.test;

import cn.zjwc.structlog4j.KeyValuePairFormatter;
import cn.zjwc.structlog4j.StructLog4J;
import lombok.experimental.UtilityClass;
import org.slf4j.event.Level;
import org.slf4j.impl.LogEntry;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Common testing helper methods
 */
@UtilityClass
public class TestUtils {

    /**
     * Resets the config to default settings for every test
     */
    public void initForTesting() {
        StructLog4J.clearMandatoryContextSupplier();
        StructLog4J.setFormatter(KeyValuePairFormatter.getInstance());
    }

    public void assertMessage(List<LogEntry> entries, int entryIndex, Level expectedLevel, String expectedMessage, boolean expectedExceptionPresent) {
        assertEquals(entries.toString(), expectedLevel, entries.get(entryIndex).getLevel());
        assertEquals(entries.toString(),expectedMessage,entries.get(entryIndex).getMessage());
        assertTrue(entries.toString(),entries.get(entryIndex).getError().isPresent() == expectedExceptionPresent);
    }


}

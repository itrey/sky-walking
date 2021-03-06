package org.skywalking.apm.sniffer.mock.trace;

import java.lang.reflect.Field;
import java.util.List;
import org.skywalking.apm.agent.core.context.trace.LogData;
import org.skywalking.apm.agent.core.context.trace.Span;

/**
 * @author wusheng
 */
public class SpanLogReader {
    public static List<LogData> getLogs(Span span) {
        Field logs = null;
        try {
            logs = Span.class.getDeclaredField("logs");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        logs.setAccessible(true);
        try {
            return (List<LogData>)logs.get(span);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

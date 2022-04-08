package cn.zjwc.structlog4j.test.samples;

import cn.zjwc.structlog4j.IToLog;
import lombok.Value;

/**
 * A Sample of an object that implements the IToLog
 */
@Value
public class BusinessObjectContext implements IToLog {

    private String entityName;
    private String entityId;

    @Override
    public Object[] toLog() {
        return new Object[]{"entityName",getEntityName(),"entityId",getEntityId()};
    }
}

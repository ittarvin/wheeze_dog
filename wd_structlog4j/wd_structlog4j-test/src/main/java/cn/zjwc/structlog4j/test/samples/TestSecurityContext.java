package cn.zjwc.structlog4j.test.samples;

import cn.zjwc.structlog4j.IToLog;
import lombok.Value;

/**
 * A Sample of an object that implements the IToLog
 */
@Value
public class TestSecurityContext implements IToLog {

    private String userName;
    private String tenantId;

    @Override
    public Object[] toLog() {
        return new Object[]{"userName",getUserName(),"tenantId",getTenantId()};
    }
}

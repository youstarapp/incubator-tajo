/**
 * 
 */
package nta.engine.query;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import nta.engine.MasterInterfaceProtos.InProgressStatus;
import nta.engine.MasterInterfaceProtos.QueryStatus;
import nta.engine.QueryIdFactory;
import nta.engine.ipc.PingRequest;

import org.junit.Test;

/**
 * @author jihoon
 * @author Hyunsik Choi
 */
public class TestPingRequestImpl {

  @Test
  public void test() {
    QueryIdFactory.reset();
    
    List<InProgressStatus> list 
      = new ArrayList<InProgressStatus>();
    
    InProgressStatus.Builder builder = InProgressStatus.newBuilder()
        .setId(QueryIdFactory.newQueryUnitId().toString())
        .setProgress(0.5f)
        .setStatus(QueryStatus.FINISHED);
    list.add(builder.build());
    
    builder = InProgressStatus.newBuilder()
        .setId(QueryIdFactory.newQueryUnitId().toString())
        .setProgress(0.5f)
        .setStatus(QueryStatus.FINISHED);
    list.add(builder.build());
    
    PingRequest r1 = new PingRequestImpl(System.currentTimeMillis(), 
        "testserver", list);
    PingRequest r2 = new PingRequestImpl(r1.getProto());
    
    assertEquals(r1.getProto().getStatusCount(), r2.getProto().getStatusCount());
    assertEquals(r1.getProto(), r2.getProto());
    assertEquals(r1.getProgressList().size(), r2.getProgressList().size());
  }
}
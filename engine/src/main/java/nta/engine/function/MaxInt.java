package nta.engine.function;

import nta.catalog.Column;
import nta.catalog.proto.CatalogProtos.DataType;
import nta.datum.Datum;
import nta.datum.DatumFactory;

/**
 * @author Hyunsik Choi
 */
public final class MaxInt extends Function {
  public MaxInt() {
    super(new Column[] { new Column("arg1", DataType.INT)});
  }

  @Override
  public Datum invoke(final Datum... datums) {
    if (datums.length == 1) {
      return datums[0];
    }
    return DatumFactory
        .createInt(Math.max(datums[0].asInt(), datums[1].asInt()));
  }

  @Override
  public DataType getResType() {
    return DataType.INT;
  }
}

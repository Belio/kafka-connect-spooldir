package io.confluent.kafka.connect.source.io.processing;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

import java.util.Map;

@SuppressWarnings("WeakerAccess")
public class RecordProcessorConfig extends AbstractConfig {

  public static final String BATCH_SIZE_CONF = "batch.size";
  public static final String BATCH_SIZE_DOC = "The number of records that should be returned with each batch.";
  public static final int BATCH_SIZE_DEFAULT = 100;

  public static final String TOPIC_CONF = "topic";
  public static final String TOPIC_DOC = "The Kafka topic to write the data to.";


  public RecordProcessorConfig(ConfigDef definition, Map<?, ?> originals) {
    super(definition, originals);
  }

  public static ConfigDef getConf() {
    return new ConfigDef()
        .define(BATCH_SIZE_CONF, ConfigDef.Type.INT, BATCH_SIZE_DEFAULT, ConfigDef.Importance.LOW, BATCH_SIZE_DOC)
        .define(TOPIC_CONF, ConfigDef.Type.STRING, ConfigDef.Importance.HIGH, TOPIC_DOC)

        ;
  }

  public int batchSize() {
    return this.getInt(BATCH_SIZE_CONF);
  }

  public String topic() {
    return this.getString(TOPIC_CONF);
  }
}

package io.confluent.kafka.connect.source.io;

import io.confluent.kafka.connect.source.io.processing.RecordProcessor;
import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

import java.util.Map;

@SuppressWarnings("WeakerAccess")
public class DirectoryMonitorConfig extends AbstractConfig {

  public static final String RECORD_PROCESSOR_CLASS_CONF = "record.processor.class";
  static final String RECORD_PROCESSOR_CLASS_DOC = "Class that implements RecordProcessor. This class is used to process data as it arrives.";

  public DirectoryMonitorConfig(ConfigDef configDef, Map<?, ?> originals) {
    super(configDef, originals);
  }

  public DirectoryMonitorConfig(Map<?, ?> originals) {
    this(getConf(), originals);
  }

  public static ConfigDef getConf() {
    return new ConfigDef()
        .define(RECORD_PROCESSOR_CLASS_CONF, ConfigDef.Type.CLASS, ConfigDef.Importance.HIGH, RECORD_PROCESSOR_CLASS_DOC)
        ;
  }

  Class<RecordProcessor> recordProcessor() {
    return (Class<RecordProcessor>) this.getClass(RECORD_PROCESSOR_CLASS_CONF);
  }


}

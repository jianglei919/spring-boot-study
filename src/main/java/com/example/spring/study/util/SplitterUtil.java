package com.example.spring.study.util;

import com.google.common.base.Splitter;
import com.google.common.collect.Maps;

import java.util.Map;

public class SplitterUtil {
    public static final Splitter.MapSplitter Map_Splitter = Splitter.on(';').omitEmptyStrings().trimResults().withKeyValueSeparator(":");
    public static final Splitter.MapSplitter OrMapSplitter = Splitter.on('|').omitEmptyStrings().trimResults().withKeyValueSeparator(":");
    public static final Splitter.MapSplitter ConfigSplitter = Splitter.on(';').omitEmptyStrings().trimResults().withKeyValueSeparator("-");

    public static final Splitter And_Splitter = Splitter.on("&").trimResults().omitEmptyStrings();
    public static final Splitter Comma_Splitter = Splitter.on(",").trimResults().omitEmptyStrings();
    public static final Splitter Dot_Splitter = Splitter.on(".").trimResults().omitEmptyStrings();
    public static final Splitter Slash_COLUMN = Splitter.on("/").omitEmptyStrings().trimResults();
    public static final Splitter SPACE_COLUMN = Splitter.on(" ").omitEmptyStrings().trimResults();
    public static final Splitter Semicolon_COLUMN = Splitter.on(";").omitEmptyStrings().trimResults();
    public static final Splitter Line_COLUMN = Splitter.on("_").omitEmptyStrings().trimResults();

    public static Splitter getSplitter(String split) {
        return SPLITTER_MAP.computeIfAbsent(split, key -> Splitter.on(key).omitEmptyStrings().trimResults());
    }

    private static final Map<String, Splitter> SPLITTER_MAP = Maps.newHashMap();

    static {
        SPLITTER_MAP.put("&", And_Splitter);
        SPLITTER_MAP.put(",", Comma_Splitter);
        SPLITTER_MAP.put(".", Dot_Splitter);
        SPLITTER_MAP.put("/", Slash_COLUMN);
        SPLITTER_MAP.put(" ", SPACE_COLUMN);
        SPLITTER_MAP.put(";", Semicolon_COLUMN);
        SPLITTER_MAP.put("_", Line_COLUMN);
    }
}

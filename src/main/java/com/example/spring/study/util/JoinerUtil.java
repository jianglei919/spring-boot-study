package com.example.spring.study.util;

import com.google.common.base.Joiner;

/**
 * Created by jianglei on 2019/8/23.
 */
public class JoinerUtil {
    public static final Joiner.MapJoiner Map_Joiner = Joiner.on(";").withKeyValueSeparator(":");
    public static final Joiner.MapJoiner Return_Map_Joiner = Joiner.on("\n").withKeyValueSeparator(" # ");

    public static final Joiner NoSpace_Joiner = Joiner.on("").skipNulls();
    public static final Joiner Comma_Joiner = Joiner.on(",").skipNulls();
    public static final Joiner Semi_Joiner = Joiner.on(";").skipNulls();
    public static final Joiner Colon_Joiner = Joiner.on(":").skipNulls();
    public static final Joiner Equal_Joiner = Joiner.on("=").skipNulls();
    public static final Joiner Line_Joiner = Joiner.on("_").skipNulls();
    public static final Joiner Point_Joiner = Joiner.on(".").skipNulls();
    public static final Joiner And_Joiner = Joiner.on("&").skipNulls();
    public static final Joiner Pound_Joiner = Joiner.on(" ## ").skipNulls();
    public static final Joiner Slash_Joiner = Joiner.on("/").skipNulls();
    public static final Joiner Return_Joiner = Joiner.on('\n').skipNulls();
    public static final Joiner Space_Joiner = Joiner.on(' ').skipNulls();
    public static final Joiner Mid_Pair_Joiner = Joiner.on("][").skipNulls();
    public static final Joiner Depend_Joiner = Joiner.on("-->").skipNulls();
}

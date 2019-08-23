package com.qunar.flight.alert.server.utils;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

/**
 * Author: chunfeng.liang
 * Date: 2017/3/22
 */
public class HashUtil {

    private static HashFunction hashFunction = Hashing.md5();

    public static String md5Encode(String value) {
        HashCode hashCode = hashFunction.newHasher()
                .putString(value, Charsets.UTF_8)
                .hash();

        return String.valueOf(hashCode.asLong());
    }
}

package com.qunar.flight.alert.server.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by jovanwang on 17-5-26.
 */
public class SerializeUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(SerializeUtil.class);

    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            return baos.toByteArray();
        } catch (IOException e) {
            LOGGER.error("serialize error, content {}, ", object.toString(), e);
        }
        return null;
    }

    public static Object unserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            LOGGER.error("unserialize error, ", e);
            throw e;
        }
    }
}
